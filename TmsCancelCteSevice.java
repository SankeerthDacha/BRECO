package com.fedex.breco.insurance.service;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fedex.breco.insurance.cte.model.CteIdentityMaster;
import com.fedex.breco.insurance.dto.MatchReference;
import com.fedex.breco.insurance.mapper.TmsCteAddMapper;
import com.fedex.breco.insurance.nfe.dto.StationLocationDetails;
import com.fedex.breco.insurance.repository.CteRepo;
import com.fedex.breco.insurance.repository.StationLocationRepo;
import com.fedex.breco.insurance.utils.TmsCancelCteValidation;
import com.fedex.breco.insurance.utils.TmsUtil;

@Service
public class TmsCancelCteSevice {

	@Autowired
	TmsCancelCteValidation tmsCancelCteValidation;

	@Autowired
	private CteRepo cteRepo;

	@Autowired
	private StationLocationRepo stationLocationRepo;

	@Autowired
	TmsUtil tmsUtil;

	private static final Logger log = LoggerFactory.getLogger(TmsCancelCteSevice.class);

	public String getCancelCteRecord(String cteCode) throws IOException {
		String message = "";
		log.info("Entered cancel Cte..........");

		CteIdentityMaster cteIdentityMaster = cteRepo.findByCteCode(cteCode);

		if (cteIdentityMaster != null) {

			if (cteIdentityMaster.getCteResponseDetails() != null
					&& cteIdentityMaster.getCancellationStatus().equals("Cancelled")) {
				//BufferedWriter writer = null;
				String nctNumber = cteIdentityMaster.getCteNumber();

				if (null != cteIdentityMaster.getMatchReferenceMaster()
						&& null != cteIdentityMaster.getMatchReferenceMaster().getOriginStationId()) {
					MatchReference matchReferenceMaster = cteIdentityMaster.getMatchReferenceMaster();

					String stationId = (null != matchReferenceMaster.getOriginStationId())
							? matchReferenceMaster.getOriginStationId().substring(0, 3)
							: "";
					StationLocationDetails stationLocationDetail = stationLocationRepo
							.findByStationNameStartingWith(stationId);
					int stationCd = Integer.parseInt(stationLocationDetail.getCode());
					String stationCode = String.valueOf(
							stationCd > 99 ? ("0") : stationCd >= 10 ? ("00" + stationCd) : ("000" + stationCd));

					TmsCteAddMapper tmsCteAddMapper = cteMapperAdd(cteIdentityMaster); // 109
					StringBuilder content = tmsCancelCteValidation.cteCancelValidation(tmsCteAddMapper, stationCode);

					String filePath = fileCreation(nctNumber, stationCode);
					/*
					 * writer = new BufferedWriter(new FileWriter(filePath));
					 * writer.write(content.toString() + "\r\n"); // 109 cte cancellation
					 * writer.close();
					 */
					StringBuilder data = content.append("\r\n");
					ByteArrayInputStream bInput = new ByteArrayInputStream(data.toString().getBytes());
					 tmsUtil.sendFile(bInput, filePath);

					message = "success";
					log.info("Exited cancel Cte..........");
				}

			} else {
				message = "fail";
			}
		}
		return message;
	}

	public TmsCteAddMapper cteMapperAdd(CteIdentityMaster tmscte) {
		log.info("Entered...... ctecancel mapper ");
		String cancelled = "cancelado";
		TmsCteAddMapper tmsMapperAdd = new TmsCteAddMapper();
		try {

			tmsMapperAdd.setCteNbr(tmscte.getCteNumber() != null ? tmscte.getCteNumber() : "000000000");
			tmsMapperAdd.setcCT(
					tmscte.getAccessKeyVerifyNumber() != null ? tmscte.getAccessKeyVerifyNumber() : "000000000");
			tmsMapperAdd.setCteIssueDate(tmscte.getCteIssueDate());
			tmsMapperAdd.setCteSeriesNumber(tmscte.getCteSeriesNumber() != null ? tmscte.getCteSeriesNumber() : "000");
			if (tmscte.getCteResponseDetails() != null
					&& tmscte.getCteResponseDetails().getResponseStatusCode() != null) {
				tmsMapperAdd.setResponseStatusCode(tmscte.getCteResponseDetails().getResponseStatusCode());
			} else {
				tmsMapperAdd.setResponseStatusCode("000");
			}
			tmsMapperAdd.setCteNumber(tmscte.getCteCode() != null ? tmscte.getCteCode() : "             ");
			;
			tmsMapperAdd.setStatusDescription(tmscte.getCancellationStatus() != null ? cancelled : "          ");

			tmsMapperAdd.setCancelDate(tmscte.getCancellationDate());
			tmsMapperAdd.setProtocolNumber(tmscte.getCteResponseDetails().getProtocolNumber() != null
					? tmscte.getCteResponseDetails().getProtocolNumber()
					: "00000000000000000");
		} catch (Exception e) {
			log.error("Error occured TmsCteService :: cteMapperAdd :: in {}", e.getMessage());
		}
		log.info("Exited...... ctecancel mapper ");
		return tmsMapperAdd;

	}

	private String fileCreation(String nctNumber, String code) throws IOException {
		String fileName = "Arq_" + "BRECOCTE_" + code + "_" + nctNumber + "_";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		String timestampFormat = sdf.format(new Date());
		String outPutfileName = fileName + timestampFormat + ".txt";
		String filePath = /* "C:\\Users\\dacha.sankeerth\\Desktop\\Cte\\" + */ outPutfileName;

		File file = new File(filePath);
		file.createNewFile();

		return filePath;
	}

}
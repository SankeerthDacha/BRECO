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

import com.fedex.breco.insurance.dto.MatchReference;
import com.fedex.breco.insurance.dto.NfseRequestDetail;
import com.fedex.breco.insurance.mapper.TmsNfseExtMapper;
import com.fedex.breco.insurance.nfe.dto.StationLocationDetails;
import com.fedex.breco.insurance.repository.NfseRequestRepo;
import com.fedex.breco.insurance.repository.StationLocationRepo;
import com.fedex.breco.insurance.utils.TmsCancelNfseValidation;
import com.fedex.breco.insurance.utils.TmsUtil;

@Service
public class TmsCancelNfseService {
	@Autowired
	private NfseRequestRepo repo;

	@Autowired
	private StationLocationRepo stationLocationRepo;

	@Autowired
	TmsUtil tmsUtil;

	@Autowired
	private TmsCancelNfseValidation tmsCancelNfseValidation;

	private static final Logger log = LoggerFactory.getLogger(TmsCancelNfseService.class);

	public String getCancelNfseRecord(String nfseCode) throws IOException {
		String message = " ";
		log.info("Entered getRecords in Nfse");
		NfseRequestDetail tmsNfse = repo.findByRpsId(nfseCode);

		if (tmsNfse.getRpsId() != null) {
			BufferedWriter writer = null;

			if (tmsNfse.getCancellationStatus().equals("Cancelled")) {

				if (null != tmsNfse.getMatchReferenceMaster()
						&& null != tmsNfse.getMatchReferenceMaster().getOriginStationId()) {
					MatchReference matchReferenceMaster = tmsNfse.getMatchReferenceMaster();
					String stationId = (null != matchReferenceMaster.getOriginStationId())
							? matchReferenceMaster.getOriginStationId().substring(0, 3)
							: "";
					StationLocationDetails stationLocationDetail = stationLocationRepo
							.findByStationNameStartingWith(stationId);
					int stationCd = Integer.parseInt(stationLocationDetail.getCode());
					String stationCode = String.valueOf(
							stationCd > 99 ? ("0") : stationCd >= 10 ? ("00" + stationCd) : ("000" + stationCd));

					TmsNfseExtMapper mapper1 = nfseMapper1(tmsNfse); // 109
					StringBuilder content = tmsCancelNfseValidation.nfseCancelValidation(mapper1, stationCode);
					String rpsId = tmsNfse.getRpsId();
					String filePath = fileCreation(rpsId, stationCode);

					writer = new BufferedWriter(new FileWriter(filePath));
					writer.write(content.toString() + "\r\n"); // 109 cte cancellation
					writer.close();

					StringBuilder data = content.append("\r\n");
					ByteArrayInputStream bInput = new ByteArrayInputStream(data.toString().getBytes());
					tmsUtil.sendFile(bInput, filePath);

					log.info("Exited getRecords in Nfse");
					message = " Success";
				}
			} else {
				message = "Fail";
			}

		}
		return message;

	}

	public TmsNfseExtMapper nfseMapper1(NfseRequestDetail tmsNfse) {
		String cancelled = "cancelado";
		log.info("Entered...... Nfse cancellation  mapper");
		TmsNfseExtMapper mapper1 = new TmsNfseExtMapper();
		try {
			mapper1.setRpsId(tmsNfse.getRpsId() != null ? tmsNfse.getRpsId() : "000000000");
			mapper1.setIssueDateOfRPS(tmsNfse.getNfseResponseDetail().getRpsDate());
			mapper1.setRpsSeriesId(tmsNfse.getRpsSeriesId() != null ? tmsNfse.getRpsSeriesId() : "000");
			mapper1.setResponseStatus(tmsNfse.getNfseResponseDetail().getResponseStatus() != null
					? tmsNfse.getNfseResponseDetail().getResponseStatus()
					: "000");

			mapper1.setStatusDescription(tmsNfse.getCancellationStatus() != null ? cancelled : "  ");

			mapper1.setProtocolNumber(tmsNfse.getNfseResponseDetail().getProtocolNumber() != null
					? tmsNfse.getNfseResponseDetail().getProtocolNumber()
					: "000000000000000");
			mapper1.setNfsecd(
					tmsNfse.getNotaFiscalNumber() != null ? tmsNfse.getNotaFiscalNumber() : "                 ");
			mapper1.setCancelDate(tmsNfse.getCancellationDate());

		} catch (Exception e) {
			log.error("Error occured TmsNfseService :: nfseMapper109 :: in {}", e.getMessage());
		}
		log.info("Exited...... Nfse cancellation  mapper");
		return mapper1;

	}

	private String fileCreation(String nctNumber, String code) throws IOException {
		String fileName = "Arq_" + "BRECONFSE_" + code + "_" + nctNumber + "_";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		String timestampFormat = sdf.format(new Date());
		String outPutfileName = fileName + timestampFormat + ".txt";
		String filePath = "C:\\Users\\dacha.sankeerth\\Desktop\\Nfse\\" + outPutfileName;

		File file = new File(filePath);
		file.createNewFile();

		return filePath;
	}

}

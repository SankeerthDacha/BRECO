package com.fedex.breco.insurance.service;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fedex.breco.insurance.cte.model.CteIdentityMaster;
import com.fedex.breco.insurance.dto.AwbCustMaster;
import com.fedex.breco.insurance.dto.AwbShpmtDetails;
import com.fedex.breco.insurance.dto.ChildAwbCustMaster;
import com.fedex.breco.insurance.dto.InsuranceResponseMaster;
import com.fedex.breco.insurance.dto.MatchReference;
import com.fedex.breco.insurance.dto.MatchReferenceAWB;
import com.fedex.breco.insurance.dto.MatchReferenceNFE;
import com.fedex.breco.insurance.mapper.AdditionalDataNfeMapper;
import com.fedex.breco.insurance.mapper.TmsAwbMapper;
import com.fedex.breco.insurance.mapper.TmsCteAddMapper;
import com.fedex.breco.insurance.mapper.TmsCteComplimentMapper;
import com.fedex.breco.insurance.mapper.TmsCteInsuranceMapper;
import com.fedex.breco.insurance.mapper.TmsCteMapper;
import com.fedex.breco.insurance.mapper.TmsCteMapper117;
import com.fedex.breco.insurance.mapper.TmsNfeMapper;
import com.fedex.breco.insurance.nfe.dto.NfeIdentityMaster;
import com.fedex.breco.insurance.nfe.dto.StationLocationDetails;
import com.fedex.breco.insurance.repository.AwbRepo;
import com.fedex.breco.insurance.repository.AwbShipmentRepo;
import com.fedex.breco.insurance.repository.CteRepo;
import com.fedex.breco.insurance.repository.InsuranceResponseRepo;
import com.fedex.breco.insurance.repository.MatchReferenceAwbRepo;
import com.fedex.breco.insurance.repository.MatchReferenceNfeRepo;
import com.fedex.breco.insurance.repository.MatchReferenceRepo;
import com.fedex.breco.insurance.repository.NfeRepo;
import com.fedex.breco.insurance.repository.StationLocationRepo;
import com.fedex.breco.insurance.utils.TmsAdditionalDataNfe;
import com.fedex.breco.insurance.utils.TmsAwbValidation;
import com.fedex.breco.insurance.utils.TmsBarCodeValidation;
import com.fedex.breco.insurance.utils.TmsCteComplimentValidation;
import com.fedex.breco.insurance.utils.TmsCteInsuranceValidation;
import com.fedex.breco.insurance.utils.TmsCtePickUpValidation;
import com.fedex.breco.insurance.utils.TmsCteValidation;
import com.fedex.breco.insurance.utils.TmsCteValidation117;
import com.fedex.breco.insurance.utils.TmsNfeValidation;
import com.fedex.breco.insurance.utils.TmsUtil;

@Service
public class TmsCteService {

	// private final String MSG_SU
	@Autowired
	private CteRepo cteRepo;

	@Autowired
	private AwbRepo awbRepo;

	@Autowired
	private NfeRepo nfeRepo;

	@Autowired
	private MatchReferenceRepo matchRepo;

	@Autowired
	private AwbShipmentRepo awbShipmentRepo;

	@Autowired
	private MatchReferenceNfeRepo matchReferenceNfeRepo;

	@Autowired
	private StationLocationRepo stationLocationRepo;

	@Autowired
	private InsuranceResponseRepo insuranceResponseRepo;

	@Autowired
	private MatchReferenceAwbRepo matchReferenceAwbRepo;

	@Autowired
	private TmsCteService117 tmsCteService117;

	@Autowired
	TmsUtil tmsUtil;

	@Autowired
	TmsCteValidation cteValidation;

	@Autowired
	TmsCteValidation117 tmsCteValidation117;
	@Autowired
	TmsNfeValidation tmsNfeValidation;
	@Autowired
	TmsCteComplimentValidation tmsCteComplimentValidation;
	@Autowired
	TmsAdditionalDataNfe tmsAdditionalDataNfe;

	@Autowired
	TmsCteInsuranceValidation insuranceValidation;

	@Autowired
	TmsBarCodeValidation tmsBarCodeValidation;
	@Autowired
	TmsCtePickUpValidation tmsCtePickUpValidation;

	@Autowired
	TmsAwbValidation tmsAwbValidation;

	private static final String fourtyzeros = "0000000000000000000000000000000000000000";

	private static final String fourteenzeros = "00000000000000";

	private static final Logger log = LoggerFactory.getLogger(TmsCteService.class);

	public String getRecords(String cteCode) {

		String message = "";
		log.info("Entered getRecords in Cte");
		try {
			CteIdentityMaster cteIdentityMaster = cteRepo.findByCteCode(cteCode);

			MatchReference matchReference = matchRepo
					.findByMsterMatchRefernceId(cteIdentityMaster.getMatchReferenceMaster().getMsterMatchRefernceId());
			log.info("Fetching values from : MatchReference Repo " + matchReference);

			List<MatchReferenceNFE> matchReferenceNFE = matchReferenceNfeRepo
					.findByMatchReferenceMaster(matchReference);

			List<MatchReferenceAWB> matchReferenceAWB = matchReferenceAwbRepo
					.findByMatchReferenceMaster(matchReference); // List of awb nbrs

			InsuranceResponseMaster insuranceResponseMaster = insuranceResponseRepo.findByCteKey(cteCode);

			if (cteIdentityMaster != null) {

				if (cteIdentityMaster.getCteResponseDetails() != null
						&& cteIdentityMaster.getCteResponseDetails().getStatusDescription().equals("Approved")
						&& cteIdentityMaster.getMatchReferenceMaster() != null
						&& cteIdentityMaster.getMatchReferenceMaster().getMatchRefernceAWB() != null
						&& cteIdentityMaster.getMatchReferenceMaster().getMatchRefernceNfe() != null
						&& !matchReferenceNFE.isEmpty() && !matchReferenceAWB.isEmpty()
						&& insuranceResponseMaster != null) {

					BufferedWriter writer = null;
					log.info(" Entering into mapper class with cte info");

					String awbNbr = matchReferenceAWB.get(0).getAwbNbr();

					NfeIdentityMaster nfeIdentityMaster = nfeRepo
							.findByNotaFiscalKey(matchReferenceNFE.get(0).getNfeKey());

					TmsCteMapper tmsCteMapper = cteMapper(cteIdentityMaster, nfeIdentityMaster, awbNbr); // 101

					TmsCteAddMapper tmsCteAddMapper = cteMapperAdd(cteIdentityMaster); // 109

					TmsCteComplimentMapper tmsCteComplimentMapper = cteComplimentMapper(cteIdentityMaster, awbNbr,
							String.valueOf(matchReferenceNFE.size())); // 103

					AdditionalDataNfeMapper additionalDataNfeMapper = additionalNfeMapper(cteIdentityMaster,
							nfeIdentityMaster, awbNbr); // 111

					StringBuilder content = cteValidation.cteValidation(tmsCteMapper);

					String nctNumber = cteIdentityMaster.getCteNumber();

					if (null != cteIdentityMaster.getMatchReferenceMaster()
							&& null != cteIdentityMaster.getMatchReferenceMaster().getOriginStationId()) {
						MatchReference matchReferenceMaster = cteIdentityMaster.getMatchReferenceMaster();

						String stationId = (null != matchReferenceMaster.getOriginStationId())
								? matchReferenceMaster.getOriginStationId().substring(0, 3)
								: "";

						String awbNum = matchReferenceAWB.get(0).getAwbNbr();
						AwbShpmtDetails awbShipmentObject = awbShipmentRepo.findByAwbNbr(awbNum);

						String stationDestId = (null != awbShipmentObject.getDestLocCd())
								? awbShipmentObject.getDestLocCd().substring(0, 3)
								: "";

						StationLocationDetails stationDestLoc = stationLocationRepo
								.findByStationNameStartingWith(stationDestId); // input is destLocCd

						TmsCteInsuranceMapper insuranceMapper = tmsCteInsuranceMapper(cteIdentityMaster,
								insuranceResponseMaster); // 122

						StationLocationDetails stationLocationDetail = stationLocationRepo
								.findByStationNameStartingWith(stationId); // input is originLocCd
						int stationCd = Integer.parseInt(stationLocationDetail.getCode());
						String stationCnpj = stationLocationDetail.getTaxId();
						String stationtax = stationCnpj.replace(".", "").replace("/", ""); // stationcnpj

						TmsCteMapper117 tmsCteMapper117 = tmsCteService117.cteMapper117(cteIdentityMaster,
								nfeIdentityMaster, stationtax, stationDestLoc); // 117

						log.info("Fetched Station code from Station Location detail");
						String stationCode = String.valueOf(
								stationCd > 99 ? ("0") : stationCd >= 10 ? ("00" + stationCd) : ("000" + stationCd));

						StringBuilder content6 = tmsBarCodeValidation.cteBarCodeValidation(tmsCteMapper, stationCode); // 107
						StringBuilder content7 = tmsCtePickUpValidation.ctePickUpValidation(tmsCteMapper, stationCode); // 106
						StringBuilder content1 = cteValidation.cteAddValidation(tmsCteAddMapper, stationCode); // 109
						StringBuilder content2 = tmsCteValidation117.cteValidation117(tmsCteMapper117, stationCode); // 117
						StringBuilder content5 = tmsCteComplimentValidation
								.cteComplimentValidation(tmsCteComplimentMapper); // 103

						StringBuilder content4 = tmsAdditionalDataNfe
								.additionalDataNfeValidation(additionalDataNfeMapper); // 111

						StringBuilder content8 = insuranceValidation.cteInsuranceValidation(insuranceMapper); // 122

						String filePath = fileCreation(nctNumber, stationCode);

						writer = new BufferedWriter(new FileWriter(filePath));
						writer.write(content.toString() + "\r\n"); // 101 cte
						writer.write(content1.toString() + "\r\n");// 109 cte
						writer.write(content2.toString() + "\r\n"); // 117 cte
						writer.write(content5.toString() + "\r\n"); // 103
						writer.write(content7.toString() + "\r\n"); // 106

						StringBuilder data = content.append("\r\n").append(content1).append("\r\n").append(content2)
								.append("\r\n").append(content5).append("\r\n").append(content7).append("\r\n"); // 101,109,117,103,106

						// 102
						if (cteIdentityMaster.getMatchReferenceMaster().getMatchRefernceNfe() != null) {

							List<MatchReferenceNFE> list = cteIdentityMaster.getMatchReferenceMaster()
									.getMatchRefernceNfe();
							if (list.size() != 0) {
								for (int i = 0; i < list.size(); i++) {

									NfeIdentityMaster nfeIdentityMasterObj = nfeRepo
											.findByNotaFiscalKey(matchReferenceNFE.get(i).getNfeKey());

									TmsNfeMapper tmsNfeMapper = nfeMapper(cteIdentityMaster, nfeIdentityMasterObj);
									StringBuilder content3 = tmsNfeValidation.nfeValidation(tmsNfeMapper);

									writer.write(content3.toString() + "\r\n"); // 102 cte
									data.append(content3).append("\r\n"); // 101,109,117,103,106,102
								}
							}

						}

						writer.write(content4.toString() + "\r\n"); // 111 cte{}
						writer.write(content6.toString() + "\r\n"); // 107 cte
						writer.write(content8.toString() + "\r\n"); // 122 cte

						data.append(content4).append("\r\n").append(content6).append("\r\n").append(content8)
								.append("\r\n"); // 111,107,122

						for (int i = 0; i < matchReferenceAWB.size(); i++) {
							String awbMasterValue = matchReferenceAWB.get(i).getAwbNbr();
							List<ChildAwbCustMaster> childAwbCustMasterList = awbRepo
									.findByMasterAwbNbr(awbMasterValue);

							String baseValue = null;
							AwbShpmtDetails awbShipmentObj = awbShipmentRepo.findByAwbNbr(awbMasterValue);
							if (awbShipmentObj != null) {
								baseValue = String.valueOf(awbShipmentObj.getBaseServiceCd());

							} else {
								baseValue = "00";
							}

							if (childAwbCustMasterList.isEmpty()) {
								TmsAwbMapper tmsCteAwbMapper = tmsCteAwbMapper(cteIdentityMaster, awbMasterValue,
										awbMasterValue, baseValue);
								StringBuilder content9 = tmsAwbValidation.cteAwbValidation(tmsCteAwbMapper);

								writer.write(content9.toString() + "\r\n"); // 123 cte
								data.append(content9).append("\r\n"); // 123
							}
							for (int j = 0; j < childAwbCustMasterList.size(); j++) {
								String childAwb = childAwbCustMasterList.get(j).getAwbNbr();

								TmsAwbMapper tmsCteAwbMapper = tmsCteAwbMapper(cteIdentityMaster, awbMasterValue,
										childAwb, baseValue);
								StringBuilder content9 = tmsAwbValidation.cteAwbValidation(tmsCteAwbMapper);

								writer.write(content9.toString() + "\r\n"); // 123 cte
								data.append(content9).append("\r\n"); // 123
							}

						}

						ByteArrayInputStream bInput = new ByteArrayInputStream(data.toString().getBytes());
						log.info("==============sending.............  data =============");
						writer.close();
						tmsUtil.sendFile(bInput, filePath);
						message = "File Created Successfully";
						log.info("==============File Succesfully Transfered=============");
					}
				} else {
					message = "Data Not Available to Generate file";
				}
			}
		} catch (Exception e) {
			log.error("Error occured TmsCteService :: getRecords :: in {}", e.getMessage());

		}
		return message;
	}

	private String fileCreation(String nctNumber, String code) throws IOException {
		String fileName = "Arq_" + "BRECOCTE_" + code + "_" + nctNumber + "_";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		String timestampFormat = sdf.format(new Date());
		String outPutfileName = fileName + timestampFormat + ".txt";
		String filePath = "C:\\Users\\dacha.sankeerth\\Desktop\\Cte\\" + outPutfileName;

		File file = new File(filePath);
		file.createNewFile();

		return filePath;
	}

	// 101 transaction code
	public TmsCteMapper cteMapper(CteIdentityMaster tmscte, NfeIdentityMaster nfeIdentityMaster, String awb) {
		log.info("Entered cte101 ");
		TmsCteMapper tmsMapper = new TmsCteMapper();
		try {

			tmsMapper.setCteCode(tmscte.getCteCode());

			tmsMapper.setCteNbr(tmscte.getCteNumber() != null ? tmscte.getCteNumber() : "000000000");
			tmsMapper.setCteIssueDate(tmscte.getCteIssueDate());

			tmsMapper.setPayerDetails(tmscte.getServicePayingResponsiblePersonCode());

			tmsMapper.setRecpAddrCtyCd(tmscte.getCteParticipantDetails().getRecipientAddressCityCode());
			tmsMapper.setServicetypeCode(tmscte.getServicetypeCode() != null ? "01" : "01");
			tmsMapper.setCteTotValue(tmscte.getCteProductDetails().getServiceTotalValueNumber());
			tmsMapper.setTransportModal(tmscte.getTransportModal() != null ? tmscte.getTransportModal() : "1");
			tmsMapper.setRecipientAddressStateAbbreviation(
					tmscte.getCteParticipantDetails().getRecipientAddressStateAbbreviation());
			tmsMapper.setRecipientStreetAddress(tmscte.getCteParticipantDetails().getRecipientStreetAddress());

			tmsMapper.setRecipientCityName(tmscte.getCteParticipantDetails().getRecipientCityName());
			tmsMapper.setShipperStreetAddress(tmscte.getCteParticipantDetails().getShipperStreetAddress());

			tmsMapper.setRecipientCorporateName(tmscte.getCteParticipantDetails().getRecipientCorporateName() != null
					? tmscte.getCteParticipantDetails().getRecipientCorporateName()
					: fourtyzeros);//

			tmsMapper.setShipperCorporateName(tmscte.getCteParticipantDetails().getShipperCorporateName() != null
					? tmscte.getCteParticipantDetails().getShipperCorporateName()
					: fourtyzeros); //

			tmsMapper.setShipperCityName(tmscte.getCteParticipantDetails().getShipperCityName());
			tmsMapper.setShipperStateAbbreviation(tmscte.getCteParticipantDetails().getShipperStateAbbreviation());

			if (tmscte.getCteResponseDetails() != null
					&& tmscte.getCteResponseDetails().getResponseStatusCode() != null) {
				tmsMapper.setResponseStatusCode(
						tmscte.getCteResponseDetails().getResponseStatusCode().equals("100") ? "A" : "C");
			} else {
				tmsMapper.setResponseStatusCode("");
			}

			if (tmscte.getCteResponseDetails() != null) {
				if (tmscte.getCteResponseDetails().getServiceCode() != null) {
					tmsMapper.setServico(tmscte.getCteResponseDetails().getServiceCode());
				} else {
					tmsMapper.setServico("N");
				}
			} else {
				tmsMapper.setServico("N");
			}
			if (tmscte.getCteProductDetails().getDimWt() != null) {
				tmsMapper.setDimWt(tmscte.getCteProductDetails().getDimWt());
			} else {
				tmsMapper.setDimWt("0000");
			}

			if (tmscte.getCteProductDetails().getGrossWt() != null) {
				tmsMapper.setGrossWt(tmscte.getCteProductDetails().getGrossWt());
			} else {
				tmsMapper.setGrossWt("000000");
			}

			if (tmscte.getCteProductDetails().getChargedWt() != null) {
				tmsMapper.setWeightCharged(tmscte.getCteProductDetails().getChargedWt());
			} else {
				tmsMapper.setWeightCharged("000000");
			}

			tmsMapper.setTaxIdNbr(tmscte.getCteParticipantDetails().getTaxIdNumber() != null // rem_CNPJ
					? tmscte.getCteParticipantDetails().getTaxIdNumber()
					: fourteenzeros);

			tmsMapper.setRecpTaxId(tmscte.getCteParticipantDetails().getRecpTaxIdNum() != null // dest_CNPJ
					? tmscte.getCteParticipantDetails().getRecpTaxIdNum()
					: null);

			tmsMapper.setRecpFedTaxIdntyNumber( // dest_CPF
					tmscte.getCteParticipantDetails().getRecipientFedexTaxIdentitySocialNumber() != null
							? tmscte.getCteParticipantDetails().getRecipientFedexTaxIdentitySocialNumber()
							: fourteenzeros);

			tmsMapper.setCargoTotalValueNumber(tmscte.getCteProductDetails().getCargoTotalValueNumber() != null
					? tmscte.getCteProductDetails().getCargoTotalValueNumber()
					: fourteenzeros + "0");
			tmsMapper.setCargoQuantityNumber(tmscte.getCteProductDetails().getCargoQuantityNumber() != null
					? tmscte.getCteProductDetails().getCargoQuantityNumber()
					: "0000");

			if (tmscte.getCteResponseDetails() != null) {
				tmsMapper.setSeriesId(tmscte.getCteResponseDetails().getDocumentDescription());
			} else {
				tmsMapper.setSeriesId("0000");
			}
			if (tmscte.getCteTransportInfo() != null) {
				tmsMapper.setStateTaxRate(tmscte.getCteTransportInfo().getStateTaxRate());
			} else {
				tmsMapper.setStateTaxRate("0000");
			}
			tmsMapper.setElementValueNumber(tmscte.getCteProductDetails().getElementValueNumber() != null
					? tmscte.getCteProductDetails().getElementValueNumber()
					: "000");

			tmsMapper.setTaxDocumentModelCode(
					tmscte.getTaxDocumentModalCode() != null ? tmscte.getTaxDocumentModalCode() : "57");
			tmsMapper.setBarCode(
					nfeIdentityMaster.getNotaFiscalKey() != null ? nfeIdentityMaster.getNotaFiscalKey() : "          ");
			tmsMapper.setAwbNo(awb);

			tmsMapper.setOptional("0000000000000000");
			tmsMapper.setOptional1("00000000");
			tmsMapper.setOptional2("0000");
			tmsMapper.setOptional3("00");
			tmsMapper.setOptional4("000000000000000");
			tmsMapper.setOptional5("000000");
			tmsMapper.setOptional6(" ");
			tmsMapper.setOptional7("N");
			tmsMapper.setOptional8("01");
			tmsMapper.setOptional9("000");
			tmsMapper.setOptional10("00000000000000");
			tmsMapper.setOptional11("00000000000");
			tmsMapper.setOptional12("   ");
			tmsMapper.setOptional13("0000000000000");
			tmsMapper.setOptional14("000000000");
			tmsMapper.setOptional15("57");
			tmsMapper.setOptional16("N");
			tmsMapper.setOptional17("                    ");
			tmsMapper.setOptional18("0");
			tmsMapper.setOptional19("000000000000");
			tmsMapper.setOptional20("00000");
			tmsMapper.setOptional21("0000000000000000000000000000000000000000");
			tmsMapper.setOptional27("0000000");
			tmsMapper.setNfeCreationDate(nfeIdentityMaster.getFiscalDocumentIssueDate());
			tmsMapper.setOptional22("                                                  ");
			tmsMapper.setOptional23("                    ");
			tmsMapper.setOptional24("   ");
			tmsMapper.setOptional26("      ");
			tmsMapper.setNfId(nfeIdentityMaster.getFiscalDocumentNumber());
			log.info("Exiting...... cte101 ");
		} catch (Exception e) {
			log.error("Error occured TmsCteService :: cteMapper :: in {}", e.getMessage());
		}
		return tmsMapper;

	}

	// 109 cte mapper
	public TmsCteAddMapper cteMapperAdd(CteIdentityMaster tmscte) {
		log.info("Entered...... cte109 ");
		TmsCteAddMapper tmsMapperAdd = new TmsCteAddMapper();
		String approved = "Aprovado";
		try {

			tmsMapperAdd.setCteNbr(tmscte.getCteNumber() != null ? tmscte.getCteNumber() : "000000000");
			tmsMapperAdd.setcCT(
					tmscte.getAccessKeyVerifyNumber() != null ? tmscte.getAccessKeyVerifyNumber() : "000000000");
			tmsMapperAdd.setCteIssueDate(tmscte.getCteIssueDate());
			tmsMapperAdd.setCteSeriesNumber(tmscte.getCteSeriesNumber() != null ? tmscte.getCteSeriesNumber() : "000");
			// tmsMapperAdd.setCteSeriesNumber("500");
			tmsMapperAdd.setCteNumber(tmscte.getCteCode() != null ? tmscte.getCteCode() : "                        ");
			tmsMapperAdd.setServicetypeCode(tmscte.getServicetypeCode() != null ? tmscte.getServicetypeCode() : " ");
			if (tmscte.getCteResponseDetails() != null) {
				tmsMapperAdd.setResponseStatusCode(tmscte.getCteResponseDetails().getResponseStatusCode());
			} else {
				tmsMapperAdd.setResponseStatusCode("000");
			}
			if (tmscte.getCteResponseDetails() != null
					&& tmscte.getCteResponseDetails().getStatusDescription().equals("Approved")) {

				tmsMapperAdd.setStatusDescription(approved);
			} else {
				tmsMapperAdd.setStatusDescription("                             ");
			}
			if (tmscte.getCteResponseDetails() != null) {
				tmsMapperAdd.setEnvironmentType(tmscte.getCteResponseDetails().getEnvironmentType());
			} else {
				tmsMapperAdd.setEnvironmentType("1");
			}
			tmsMapperAdd.setTaxIdNbr(tmscte.getCteParticipantDetails().getTaxIdNumber() != null
					? tmscte.getCteParticipantDetails().getTaxIdNumber()
					: "00000000000000");
			if (tmscte.getCteResponseDetails() != null) {
				tmsMapperAdd.setAuthorizationDate(tmscte.getCteResponseDetails().getAuthorizationDate());
			} else {
				tmsMapperAdd.setOptional3("00000000");
			}
			if (tmscte.getCteResponseDetails() != null) {
				tmsMapperAdd.setAuthorizationDate(tmscte.getCteResponseDetails().getAuthorizationDate());
			} else {
				tmsMapperAdd.setOptional4("000000");
			}
			if (tmscte.getCteResponseDetails() != null) {
				tmsMapperAdd.setProtocolNumber(tmscte.getCteResponseDetails().getProtocolNumber());
			} else {
				tmsMapperAdd.setOptional6("000000000000000");
			}
			tmsMapperAdd.setOptional("000000000000");
			tmsMapperAdd.setOptional1("                              ");
			tmsMapperAdd.setOptional2("0");
			tmsMapperAdd.setOptional3("00000000");
			tmsMapperAdd.setOptional4("000000");
			tmsMapperAdd.setOptional5("000");
			tmsMapperAdd.setOptional6("000000000000000");
			tmsMapperAdd.setOptional7("   ");
			tmsMapperAdd.setOptional8("000000000");
		} catch (Exception e) {
			log.error("Error occured TmsCteService :: cteMapperAdd :: in {}", e.getMessage());
		}
		log.info("Exited...... cte109 ");
		return tmsMapperAdd;

	}

	// 102 Cte
	public TmsNfeMapper nfeMapper(CteIdentityMaster cteIdentityMaster, NfeIdentityMaster nfeIdentityMaster) {

		log.info("Entered...... cte102 ");
		TmsNfeMapper nfeMapper = new TmsNfeMapper();
		try {
			nfeMapper.setCteNbr(
					cteIdentityMaster.getCteNumber() != null ? cteIdentityMaster.getCteNumber() : "000000000");
			nfeMapper.setcCT(cteIdentityMaster.getAccessKeyVerifyNumber());
			nfeMapper.setnFeNumber(nfeIdentityMaster.getFiscalDocumentNumber());

			nfeMapper.setNotaFiscalNumber(nfeIdentityMaster.getFiscalDocumentSeriesCode() != null
					? nfeIdentityMaster.getFiscalDocumentSeriesCode()
					: "000");

			nfeMapper.setValorTotal(cteIdentityMaster.getCteProductDetails().getServiceTotalValueNumber() != null
					? cteIdentityMaster.getCteProductDetails().getServiceTotalValueNumber()
					: "0000000000000");

			nfeMapper.setQuantitade(cteIdentityMaster.getCteProductDetails().getPackageQty() != null
					? cteIdentityMaster.getCteProductDetails().getPackageQty()
					: "0000");

			nfeMapper.setGrossWt(cteIdentityMaster.getCteProductDetails().getGrossWt());
			nfeMapper.setqCarga(cteIdentityMaster.getCteProductDetails().getGrossWt());

			nfeMapper.setIssueDateNfe(nfeIdentityMaster.getFiscalDocumentIssueDate());

			nfeMapper.setcteIssueDate(cteIdentityMaster.getCteIssueDate());
			nfeMapper.setNfQcarga(cteIdentityMaster.getCteProductDetails().getGrossWt());
			nfeMapper.setOptional1("00");
			nfeMapper.setOptional2("0000");
			nfeMapper.setOptional3("00000000");
			nfeMapper.setOptional4("0000000000000");
			nfeMapper.setOptional5("00000");
			nfeMapper.setOptional6(" ");
			nfeMapper.setOptional7("  ");
			nfeMapper.setOptional8("          ");
			nfeMapper.setOptional9("000000000");
		} catch (Exception e) {
			log.error("Error occured TmsCteService :: nfeMapper :: in {}", e.getMessage());
		}
		log.info("Exited...... cte102 ");
		return nfeMapper;

	}

	// 111
	public AdditionalDataNfeMapper additionalNfeMapper(CteIdentityMaster cteIdentityMaster,
			NfeIdentityMaster nfeIdentityMaster, String awbNbr) {
		AdditionalDataNfeMapper mapper = new AdditionalDataNfeMapper();
		log.info("Entered...... cte111 ");
		try {
			mapper.setCteNbr(cteIdentityMaster.getCteNumber() != null ? cteIdentityMaster.getCteNumber() : "000000000");

			mapper.setNotaFiscalID(
					nfeIdentityMaster.getFiscalDocumentNumber() != null ? nfeIdentityMaster.getFiscalDocumentNumber()
							: "000000000");

			mapper.setcCT(
					cteIdentityMaster.getAccessKeyVerifyNumber() != null ? cteIdentityMaster.getAccessKeyVerifyNumber()
							: "000000000");

			mapper.setCountOfItemNumber("0000");

			mapper.setNFeKey(
					nfeIdentityMaster.getNotaFiscalKey() != null ? nfeIdentityMaster.getNotaFiscalKey() : "000000000");
			mapper.setAwbNbr(awbNbr != null ? awbNbr : "000000000000");
			mapper.setOptional1("          ");
			mapper.setOptional2("000000000");
			mapper.setOptional3("0000");
			mapper.setOptional4(" ");
			mapper.setOptional5("   ");
			mapper.setOptional6("  ");
			mapper.setOptional7("000000000000");
			mapper.setOptional8("00000000000");
			mapper.setOptional9("00000000000000000000");
		} catch (EntityNotFoundException e) {
			log.error("Error occured TmsCteService :: additionalnfeMapper :: in {}", e.getMessage());
		}
		log.info("Exited...... cte111 ");
		return mapper;

	}

	// 103
	public TmsCteComplimentMapper cteComplimentMapper(CteIdentityMaster tmscte, String awb, String nfeCount) {
		TmsCteComplimentMapper tmsMapper = new TmsCteComplimentMapper();
		log.info("Entered...... cte103");
		try {
			tmsMapper.setCteNbr(tmscte.getCteNumber() != null ? tmscte.getCteNumber() : "000000000");
			tmsMapper.setcCT(tmscte.getCteCode());
			tmsMapper.setCteIssueDate(tmscte.getCteIssueDate());
			tmsMapper.setcCT(
					tmscte.getAccessKeyVerifyNumber() != null ? tmscte.getAccessKeyVerifyNumber() : "000000000");
			tmsMapper.setGrossWt(
					tmscte.getCteProductDetails().getGrossWt() != null ? tmscte.getCteProductDetails().getGrossWt()
							: "0000000000000");
			if (tmscte.getCteTransportInfo() != null) {
				tmsMapper.setBaseValue(tmscte.getCteTransportInfo().getStateTaxCalculationNumber() != null
						? tmscte.getCteTransportInfo().getStateTaxCalculationNumber()
						: "00000000000");
			} else {
				tmsMapper.setBaseValue("00000000000");
			}
			if (tmscte.getCteTransportInfo() != null && tmscte.getCteTransportInfo().getStateTaxValueNumber() != null) {
				tmsMapper.setStateTaxValueNumber(tmscte.getCteTransportInfo().getStateTaxValueNumber());
			} else {
				tmsMapper.setStateTaxValueNumber("00000000000");
			}
			tmsMapper.setRecipientStateName(tmscte.getCteParticipantDetails().getRecipientAddressStateAbbreviation());
			tmsMapper.setCteTypeDescription(tmscte.getCteType() != null ? tmscte.getCteType() : "1");
			if (tmscte.getServicetypeCode() != null) {
				if (tmscte.getServicetypeCode() == "2|3") {
					tmsMapper.setServicetypeCode("S");
				} else {
					tmsMapper.setServicetypeCode("N");
				}
			} else {
				tmsMapper.setServicetypeCode("N");
			}
			tmsMapper.setCountNfe(nfeCount);
			tmsMapper.setServicetypeCode(tmscte.getServicetypeCode() != null ? "01" : "01");
			if (tmscte.getCteTransportInfo() != null && tmscte.getCteTransportInfo().getStateTaxRate() != null) {
				tmsMapper.setStateTaxRate(tmscte.getCteTransportInfo().getStateTaxRate());
			} else {
				tmsMapper.setStateTaxRate("0000");
			}
			tmsMapper.setShipperTaxIdNumber(tmscte.getCteParticipantDetails().getTaxIdNumber() != null
					? tmscte.getCteParticipantDetails().getTaxIdNumber()
					: fourteenzeros); // rem_cnpj
			tmsMapper.setRecipientFedexTaxIdentitySocialNumber(
					tmscte.getCteParticipantDetails().getRecipientFedexTaxIdentitySocialNumber() != null
							? tmscte.getCteParticipantDetails().getRecipientFedexTaxIdentitySocialNumber()
							: fourteenzeros); // dest_cpf

			tmsMapper.setTaxId(tmscte.getCteParticipantDetails().getRecpTaxIdNum() != null
					? tmscte.getCteParticipantDetails().getRecpTaxIdNum()
					: null);// dest_cnpj

			tmsMapper.setShipperStateTaxNumber(tmscte.getCteParticipantDetails().getShipperStateTaxNumber());
			tmsMapper.setRecipientStateTaxNumber(tmscte.getCteParticipantDetails().getRecipientStateTaxNumber() != null
					? tmscte.getCteParticipantDetails().getRecipientStateTaxNumber()
					: fourteenzeros);
			tmsMapper.setShipperAddressZipcode(tmscte.getCteParticipantDetails().getShipperAddressZipCode());
			tmsMapper.setRecipientAddressZipcode(tmscte.getCteParticipantDetails().getRecipientAddressZipCode());
			tmsMapper.setOperationsFiscalCode(tmscte.getOperationServiceTaxCode());
			tmsMapper.setAwbNum(awb);
			if (tmscte.getServicePayingResponsiblePersonCode() != null) {
				tmsMapper.setPayerDetails(tmscte.getServicePayingResponsiblePersonCode());
			} else {
				tmsMapper.setPayerDetails("1");
			}
			tmsMapper.setOptional("0000000000000");
			tmsMapper.setOptional2("00000000000");
			tmsMapper.setOptional3("00000000");
			tmsMapper.setOptional4(" ");
			tmsMapper.setOptional5("0000");
			tmsMapper.setOptional6("00");
			tmsMapper.setOptional7("000000000");
			tmsMapper.setOptional8("N");
			tmsMapper.setOptional9("0");
			tmsMapper.setOptional10("00000");
			tmsMapper.setOptional11(" ");
			tmsMapper.setOptional12("0000000");
			tmsMapper.setOptional13("               ");
			tmsMapper.setOptional14("000");
			tmsMapper.setOptional15("000000000000");
			tmsMapper.setOptional16(" ");
			tmsMapper.setOptional17("  ");// change for 18 column in clarification sheet
			tmsMapper.setOptional18("BOX");
			tmsMapper.setOptional19("DIVERSO");
			tmsMapper.setOptional21("00000000000");
			tmsMapper.setOptional22("000000000");
			tmsMapper.setOptional25("         ");
			tmsMapper.setOptional26("00000000000");// 11zeros
			tmsMapper.setOptional27("000000000");// 9zeros
			tmsMapper.setOptional28("000000");// 6zeros
			tmsMapper.setOptional29("0000000");// 7zeros
			tmsMapper.setOptional30("00000");// 5zeros
			tmsMapper.setOptional31("00000000");// 8zeros
		} catch (Exception e) {
			log.error("Error occured TmsCteService :: cteComplimentMapper :: in {}", e.getMessage());
		}
		log.info("Exited...... cte103 ");
		return tmsMapper;
	}

	// 122
	public TmsCteInsuranceMapper tmsCteInsuranceMapper(CteIdentityMaster tmscte,
			InsuranceResponseMaster insuranceResponseMaster) {
		log.info("Entered...... cte122");
		TmsCteInsuranceMapper insuranceMapper = new TmsCteInsuranceMapper();
		try {
			insuranceMapper.setPayerTaxId(insuranceResponseMaster.getPayerTaxId());
			insuranceMapper.setCteNbr(tmscte.getCteNumber() != null ? tmscte.getCteNumber() : "000000000");
			insuranceMapper.setAnswerForInsurance("00");
			insuranceMapper.setCnpjRespForInsurance(
					/*
					 * insuranceResponseMaster.getInsuranceTaxId() != null ?
					 * insuranceResponseMaster.getInsuranceTaxId()
					 */

					insuranceResponseMaster.getCustTaxId() != null ? insuranceResponseMaster.getCustTaxId()

							: "00000000000000"); // added custtaxid -- before:: insureance tax id
			insuranceMapper.setCnpjInsurance(
					insuranceResponseMaster.getInsuranceTaxId() != null ? insuranceResponseMaster.getInsuranceTaxId()
							: "00000000000000");
			insuranceMapper.setInsurerName(
					insuranceResponseMaster.getInsuranceNbr() != null ? insuranceResponseMaster.getInsuranceNbr()
							: "00000000000000"); // Insurance Name
			insuranceMapper.setCnpjRespForInsuranceRepeat("00");
			insuranceMapper.setPolicyNumber(
					insuranceResponseMaster.getPolicyNbr() != null ? insuranceResponseMaster.getPolicyNbr()
							: "00000000000000");
			insuranceMapper.setEndorsementProtocolNumber(
					insuranceResponseMaster.getProtocolNbr() != null ? insuranceResponseMaster.getProtocolNbr()
							: "00000000000000");
			insuranceMapper.setDateOfAuthorizationOfTheEndorsementProtocol(insuranceResponseMaster.getDocRecTmstp());
			insuranceMapper.setPublicProtocolNumber(
					insuranceResponseMaster.getRegNbr() != null ? insuranceResponseMaster.getRegNbr() : "          ");
			insuranceMapper.setDateOfPublicProtocol(insuranceResponseMaster.getCreateDate());
			insuranceMapper.setCteDestinationBranchCNPJ(
					insuranceResponseMaster.getCustTaxId() != null ? insuranceResponseMaster.getCustTaxId()
							: "0000000000000");
			insuranceMapper.setOptional("00000000");
			insuranceMapper.setOptional("000000");

		} catch (Exception e) {
			log.error("Error occured TmsCteService :: tmsCteInsuranceMapper :: in {}", e.getMessage());
		}
		log.info("Exited...... cte122 ");
		return insuranceMapper;

	}

	// 123
	public TmsAwbMapper tmsCteAwbMapper(CteIdentityMaster tmscte, String masterAwb, String childAwbNumber,
			String tiposervico) {
		TmsAwbMapper awbMapper = new TmsAwbMapper();
		log.info("Entered...... cte123");
		try {
			awbMapper.setAwbNumber(masterAwb);
			awbMapper.setServiceType(tiposervico != null ? tiposervico : "00");
			awbMapper.setChildAwbNum(childAwbNumber);
		} catch (Exception e) {
			log.error("Error occured TmsCteService :: tmsCteChildAwbMapper :: in {}", e.getMessage());
		}
		log.info("Exited...... cte123");
		return awbMapper;

	}

}

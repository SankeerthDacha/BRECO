
package com.fedex.breco.insurance.service;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fedex.breco.insurance.dto.AwbShpmtDetails;
import com.fedex.breco.insurance.dto.ChildAwbCustMaster;
import com.fedex.breco.insurance.dto.InsuranceResponseMaster;
import com.fedex.breco.insurance.dto.MatchReference;
import com.fedex.breco.insurance.dto.MatchReferenceAWB;
import com.fedex.breco.insurance.dto.MatchReferenceNFE;
import com.fedex.breco.insurance.dto.NfseRequestDetail;
import com.fedex.breco.insurance.mapper.AdditionaDatalNfseMapper;
import com.fedex.breco.insurance.mapper.TmsAdditionalNfseMapper;
import com.fedex.breco.insurance.mapper.TmsAwbMapper;
import com.fedex.breco.insurance.mapper.TmsNfseComplimentMapper;
import com.fedex.breco.insurance.mapper.TmsNfseExtMapper;
import com.fedex.breco.insurance.mapper.TmsNfseInsuranceMapper;
import com.fedex.breco.insurance.mapper.TmsNfseMapper117;
import com.fedex.breco.insurance.mapper.TmsNfseOneZeroOneMapper;
import com.fedex.breco.insurance.nfe.dto.NfeIdentityMaster;
import com.fedex.breco.insurance.nfe.dto.StationLocationDetails;
import com.fedex.breco.insurance.repository.AwbRepo;
import com.fedex.breco.insurance.repository.AwbShipmentRepo;
import com.fedex.breco.insurance.repository.InsuranceResponseRepo;
import com.fedex.breco.insurance.repository.MatchReferenceAwbRepo;
import com.fedex.breco.insurance.repository.MatchReferenceNfeRepo;
import com.fedex.breco.insurance.repository.MatchReferenceRepo;
import com.fedex.breco.insurance.repository.NfeRepo;
import com.fedex.breco.insurance.repository.NfseRequestRepo;
import com.fedex.breco.insurance.repository.StationLocationRepo;
import com.fedex.breco.insurance.utils.TmsAwbValidation;
import com.fedex.breco.insurance.utils.TmsNfseComplimentValidation;
import com.fedex.breco.insurance.utils.TmsNfseInsuranceValidation;
import com.fedex.breco.insurance.utils.TmsNfseOneZeroOneValidation;
import com.fedex.breco.insurance.utils.TmsNfseValidation;
import com.fedex.breco.insurance.utils.TmsNfseValidation117;
import com.fedex.breco.insurance.utils.TmsUtil;

@Service
public class TmsNfseService {

	@Autowired
	private NfseRequestRepo repo;

	@Autowired
	private AwbRepo awbRepo;

	@Autowired
	private AwbShipmentRepo awbShipmentRepo;

	@Autowired
	private MatchReferenceRepo matchRepo;

	@Autowired
	private NfeRepo nfeRepo;

	@Autowired
	private MatchReferenceNfeRepo matchReferenceNfeRepo;

	@Autowired
	private MatchReferenceAwbRepo matchReferenceAwbRepo;

	@Autowired
	private TmsNfseValidation nfseValidation;

	@Autowired
	TmsAwbValidation tmsAwbValidation;

	@Autowired
	TmsNfseValidation117 tmsNfseValidation117;

	@Autowired
	TmsNfseService117 tmsNfseService117;

	@Autowired
	TmsNfseOneZeroOneValidation tmsOneZeroOneValidation;

	@Autowired
	TmsNfseComplimentValidation tmsNfseComplimentValidation;

	@Autowired
	StationLocationRepo stationLocationRepo;

	@Autowired
	private InsuranceResponseRepo insuranceResponseRepo;

	@Autowired
	TmsUtil tmsUtill;

	@Autowired
	TmsNfseInsuranceValidation insuranceValidation;

	private static final Logger log = LoggerFactory.getLogger(TmsNfseService.class);

	public String getNfseRecords(String nfseCode) throws IOException {
		log.info("Entered...... Nfse");
		String output = "Success";
		boolean isFileCreated = false;
		String filePath;
		NfseRequestDetail tmsNfse = repo.findByRpsId(nfseCode);
		try {

			if (tmsNfse.getRpsId() != null) {
				BufferedWriter writer = null;

				MatchReference matchReference = matchRepo
						.findByMsterMatchRefernceId(tmsNfse.getMatchReferenceMaster().getMsterMatchRefernceId());
				log.info("Fetching values from : MatchReference Repo " + matchReference);

				List<MatchReferenceNFE> matchReferenceNFE = matchReferenceNfeRepo
						.findByMatchReferenceMaster(matchReference);

				List<MatchReferenceAWB> matchReferenceAWB = matchReferenceAwbRepo
						.findByMatchReferenceMaster(matchReference); // List of awb nbrs

				InsuranceResponseMaster insuranceResponseMaster = insuranceResponseRepo
						.findByNfseKey(tmsNfse.getRpsId());

				NfeIdentityMaster nfeIdentityMaster = nfeRepo.findByNotaFiscalKey(matchReferenceNFE.get(0).getNfeKey());

				if (null != tmsNfse.getNfseResponseDetail().getStatusDescription()
						&& tmsNfse.getNfseResponseDetail().getStatusDescription().equals("Approved")
						&& null != tmsNfse.getMatchReferenceMaster()
						&& null != tmsNfse.getMatchReferenceMaster().getMatchRefernceNfe()
						&& null != tmsNfse.getMatchReferenceMaster().getMatchRefernceAWB()
						&& null != insuranceResponseMaster && null != nfeIdentityMaster) {

					log.info(" Entering into mapper class with Nfse info");
					String awbNbr = matchReferenceAWB.get(0).getAwbNbr();

					if (null != tmsNfse.getMatchReferenceMaster()
							&& null != tmsNfse.getMatchReferenceMaster().getOriginStationId()) {
						MatchReference matchReferenceMaster = tmsNfse.getMatchReferenceMaster();

						String stationId = (null != matchReferenceMaster.getOriginStationId())
								? matchReferenceMaster.getOriginStationId().substring(0, 3)
								: "";

						StationLocationDetails stationLocationDetail = stationLocationRepo
								.findByStationNameStartingWith(stationId);
						String stationCd = stationLocationDetail.getCode();

						String awbNum = matchReferenceAWB.get(0).getAwbNbr();
						AwbShpmtDetails awbShipmentObject = awbShipmentRepo.findByAwbNbr(awbNum);

						String stationDestId = (null != awbShipmentObject.getDestLocCd())
								? awbShipmentObject.getDestLocCd().substring(0, 3)
								: "";

						StationLocationDetails stationDestLoc = stationLocationRepo
								.findByStationNameStartingWith(stationDestId);

						String stationCnpj = stationLocationDetail.getTaxId().replace(".", "").replace("/", "");

						TmsNfseOneZeroOneMapper nfseOneZeroOneMapper = oneZeroOneMapper(tmsNfse, nfeIdentityMaster,
								awbNbr);
						TmsNfseExtMapper mapper1 = nfseMapper1(tmsNfse); // 109

						// NFSe
						AdditionaDatalNfseMapper addNfseMapper = nfeMapper(tmsNfse, nfeIdentityMaster, awbNum);// 111
																												// Nfse

						TmsNfseComplimentMapper nfseComplimentMapper = tmsNfseComplimentMapper(tmsNfse,
								nfeIdentityMaster, stationId, awbNum, String.valueOf(matchReferenceNFE.size())); // 103
						TmsNfseInsuranceMapper insuranceMapper = tmsNfseInsuranceMapper(tmsNfse,
								insuranceResponseMaster);
						TmsNfseMapper117 tmsNfseMapper117 = tmsNfseService117.nfseMapper117(tmsNfse, nfeIdentityMaster,
								stationDestLoc, stationCnpj);

						StringBuilder content1 = tmsOneZeroOneValidation.nfseOneZeroOneValidation(nfseOneZeroOneMapper); // 101
						StringBuilder content2 = nfseValidation.nfseadditionalValidation(mapper1, stationCd); // 109
						StringBuilder content3 = tmsNfseValidation117.nfseValidation117(tmsNfseMapper117, stationCd); // 117
						StringBuilder content4 = tmsNfseComplimentValidation
								.nfseComplimentValidation(nfseComplimentMapper);
						StringBuilder content5 = nfseValidation.nfsePickUpValidation(nfseOneZeroOneMapper, stationCd); // 106
						StringBuilder content7 = nfseValidation.AdditionalTmsNfseValidation(addNfseMapper);// 111
						StringBuilder content8 = nfseValidation.nfseBarCodeValidation(nfseOneZeroOneMapper, stationCd);// 107

						StringBuilder content9 = insuranceValidation.nfseInsuranceValidation(insuranceMapper); // 122

						String rpsId = tmsNfse.getRpsId();
						filePath = fileCreation(rpsId, stationCd);

						writer = new BufferedWriter(new FileWriter(filePath));

						writer.write(content1.toString() + "\r\n");
						writer.write(content2.toString() + "\r\n");
						writer.write(content3.toString() + "\r\n");
						writer.write(content4.toString() + "\r\n");
						writer.write(content5.toString() + "\r\n");

						StringBuilder data = content1.append("\r\n").append(content2).append("\r\n").append(content3)
								.append("\r\n").append(content4).append("\r\n").append(content5).append("\r\n"); // 101,109,117,103,106

						if (tmsNfse.getMatchReferenceMaster().getMatchRefernceNfe() != null) {

							List<MatchReferenceNFE> list = tmsNfse.getMatchReferenceMaster().getMatchRefernceNfe();
							if (list.size() != 0) {
								for (int i = 0; i < list.size(); i++) {

									NfeIdentityMaster nfeIdentityMasterObj = nfeRepo
											.findByNotaFiscalKey(matchReferenceNFE.get(i).getNfeKey());

									TmsAdditionalNfseMapper nfseMapper = AdditionalNfseMapper(tmsNfse,
											nfeIdentityMasterObj); // 102
									StringBuilder content6 = nfseValidation.tmsNfseValidation(nfseMapper);// 102

									writer.write(content6.toString() + "\r\n"); // 102 cte
									data.append(content6).append("\r\n"); // 101,109,117,103,106,102
								}
							}

						}

						writer.write(content7.toString() + "\r\n"); // 111
						writer.write(content8.toString() + "\r\n"); // 107
						writer.write(content9.toString() + "\r\n"); // 122

						data.append(content7).append("\r\n").append(content8).append("\r\n").append(content9)
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
								TmsAwbMapper tmsCteAwbMapper = tmsNfseAwbMapper(tmsNfse, awbMasterValue, awbMasterValue,
										baseValue);
								StringBuilder content10 = tmsAwbValidation.cteAwbValidation(tmsCteAwbMapper);

								writer.write(content10.toString() + "\r\n"); // 123 cte
								data.append(content10).append("\r\n"); // 123
							}
							for (int j = 0; j < childAwbCustMasterList.size(); j++) {
								String childAwb = childAwbCustMasterList.get(j).getAwbNbr();

								TmsAwbMapper tmsCteAwbMapper = tmsNfseAwbMapper(tmsNfse, awbMasterValue, childAwb,
										baseValue);
								StringBuilder content10 = tmsAwbValidation.cteAwbValidation(tmsCteAwbMapper);

								writer.write(content10.toString() + "\r\n"); // 123 cte
								data.append(content10).append("\r\n"); // 123
							}
						}

						ByteArrayInputStream bInput = new ByteArrayInputStream(data.toString().getBytes());
						//tmsUtill.sendFile(bInput, filePath);

						isFileCreated = true;

						if (writer != null) {
							writer.close();
						}

					}
					if (!isFileCreated) {
						output = "Match Reference Master Not Found.";
					}
				} else {
					output = "Data Not Found";
				}
			}
		} catch (

		Exception e) {
			log.error("Error occured TmsNfseService :: getNfseRecords :: in {}", e.getMessage());
		}
		log.info("Exited...... Nfse");
		return output;
	}

	private String fileCreation(String rpsId, String stationCode) throws IOException {
		String fileName = "Arq_" + "BRECONFSE_" + stationCode + "_" + rpsId + "_";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		String timestampFormat = sdf.format(new Date());
		String outPutfileName = fileName + timestampFormat + ".txt";
		String filePath = "C:\\Users\\dacha.sankeerth\\Desktop\\Nfse\\" + outPutfileName;
		return filePath;
	}

	// 109 NFSE mapper
	public TmsNfseExtMapper nfseMapper1(NfseRequestDetail tmsNfse) {
		String approved = "Aprovado";
		log.info("Entered...... Nfse109 mapper");
		TmsNfseExtMapper mapper1 = new TmsNfseExtMapper();
		try {

			mapper1.setRpsId(tmsNfse.getRpsId() != null ? tmsNfse.getRpsId() : "000000000");
			mapper1.setIssueDateOfRPS(tmsNfse.getNfseResponseDetail().getRpsDate());
			mapper1.setRpsSeriesId(tmsNfse.getRpsSeriesId() != null ? tmsNfse.getRpsSeriesId() : "000");
			mapper1.setResponseStatus(tmsNfse.getNfseResponseDetail().getResponseStatus() != null
					? tmsNfse.getNfseResponseDetail().getResponseStatus()
					: "000");
			mapper1.setStatusDescription(tmsNfse.getNfseResponseDetail().getStatusDescription() != null ? approved
					: "                         ");
			mapper1.setEnvironmentType(tmsNfse.getEnvironmentType() != null ? tmsNfse.getEnvironmentType() : "1");
			mapper1.setFederalTaxId(
					tmsNfse.getRecipientTaxId() != null ? tmsNfse.getRecipientTaxId() : "00000000000000");
			mapper1.setApprovalDate(tmsNfse.getRpsDate());
			mapper1.setApprovalDate1(tmsNfse.getNfseResponseDetail().getCreationDate());
			mapper1.setProtocolNumber(tmsNfse.getNfseResponseDetail().getProtocolNumber() != null
					? tmsNfse.getNfseResponseDetail().getProtocolNumber()
					: "000000000000000");
			mapper1.setNfsecd(
					tmsNfse.getNotaFiscalNumber() != null ? tmsNfse.getNotaFiscalNumber() : "                 ");
			mapper1.setUpdateDate(tmsNfse.getLastModificationDate());
			mapper1.setOptional("000000000000");
			mapper1.setOptional1("                              ");
			mapper1.setOptional2("0");
			mapper1.setOptional3("00000000");
			mapper1.setOptional4("000000");
			mapper1.setOptional5("000");
			mapper1.setOptional6("000000000000000");
			mapper1.setOptional7("   ");
			mapper1.setOptional8("000000000");
			mapper1.setOptional9(" ");

		} catch (Exception e) {
			log.error("Error occured TmsNfseService :: nfseMapper109 :: in {}", e.getMessage());
		}
		log.info("Exited...... Nfse109 mapper");
		return mapper1;

	}

	// 102 NFSe
	public TmsAdditionalNfseMapper AdditionalNfseMapper(NfseRequestDetail tmsNfse,
			NfeIdentityMaster nfeIdentityMaster) {
		log.info("Entered...... Nfse102 mapper");
		TmsAdditionalNfseMapper nfseMapper = new TmsAdditionalNfseMapper();
		try {
			nfseMapper.setRpsId(tmsNfse.getRpsId());

			nfseMapper.setnFeNumber(
					nfeIdentityMaster.getFiscalDocumentNumber() != null ? nfeIdentityMaster.getFiscalDocumentNumber()
							: "000000000");

			nfseMapper.setNotaFiscalNumber(nfeIdentityMaster.getFiscalDocumentSeriesCode() != null
					? nfeIdentityMaster.getFiscalDocumentSeriesCode()
					: "   ");

			nfseMapper.setValorTotal(tmsNfse.getTotalAmount() != null ? tmsNfse.getTotalAmount() : "0000000000000");

			nfseMapper.setQuantitade(tmsNfse.getItemQuantity() != null ? tmsNfse.getItemQuantity() : "0000");
			nfseMapper.setqCarga("0000");
			nfseMapper.setIssueDateNfe(nfeIdentityMaster.getFiscalDocumentIssueDate());
			nfseMapper.setRpsIssueDate(tmsNfse.getRpsDate());
			nfseMapper.setNfQcarga("0000000000000");
			nfseMapper.setOptional1("00");
			nfseMapper.setOptional2("0000");
			nfseMapper.setOptional3("00000000");
			nfseMapper.setOptional4("0000000000000");
			nfseMapper.setOptional5("00000");
			nfseMapper.setOptional6(" ");
			nfseMapper.setOptional7("  ");
			nfseMapper.setOptional8("          ");
			nfseMapper.setOptional9("000000000");
		} catch (Exception e) {
			log.error("Error occured TmsNfseService :: nfseMapper102 :: in {}", e.getMessage());
		}
		log.info("Exited...... Nfse102 mapper");
		return nfseMapper;

	}

	// 111 Nfse
	public AdditionaDatalNfseMapper nfeMapper(NfseRequestDetail tmsNfse, NfeIdentityMaster nfeIdentityMaster,
			String awb)

	{
		log.info("Entered...... Nfse111 mapper");
		AdditionaDatalNfseMapper mapper = new AdditionaDatalNfseMapper();
		try {

			mapper.setNotaFiscalID(
					nfeIdentityMaster.getFiscalDocumentNumber() != null ? nfeIdentityMaster.getFiscalDocumentNumber()
							: "000000000");

			mapper.setRpsId(tmsNfse.getRpsId() != null ? tmsNfse.getRpsId() : "000000000");

			mapper.setCountOfItemNumber("0000");

			mapper.setNFeKey(
					nfeIdentityMaster.getNotaFiscalKey() != null ? nfeIdentityMaster.getNotaFiscalKey() : "000000000");

			mapper.setOptional1("          ");
			mapper.setOptional2("000000000");
			mapper.setOptional3("0000");
			mapper.setOptional4(" ");
			mapper.setOptional5("   ");
			mapper.setOptional6("  ");
			mapper.setAwb(awb);
			mapper.setOptional7("000000000000");
			mapper.setOptional8("00000000000");
			mapper.setOptional9("00000000000000000000");
		} catch (Exception e) {
			log.error("Error occured TmsNfseService :: nfseMapper111 :: in {}", e.getMessage());
		}
		log.info("Exited...... Nfse111 mapper");
		return mapper;

	}

	// 120 121
	public TmsNfseInsuranceMapper tmsNfseInsuranceMapper(NfseRequestDetail tmsCte,
			InsuranceResponseMaster insuranceResponseMaster) {
		log.info("Entered...... Nfse122 mapper");
		TmsNfseInsuranceMapper insuranceMapper = new TmsNfseInsuranceMapper();
		try {

			insuranceMapper.setPayerTaxId(insuranceResponseMaster.getPayerTaxId());
			insuranceMapper.setCnpjRespForInsurance(
					insuranceResponseMaster.getCustTaxId() != null ? insuranceResponseMaster.getCustTaxId()
							: "00000000000000");
			insuranceMapper.setInsurerName(
					insuranceResponseMaster.getInsuranceNbr() != null ? insuranceResponseMaster.getInsuranceNbr()
							: "00000000000000"); // Insurance Name
			insuranceMapper.setCnpjRespForInsuranceRepeat(
					insuranceResponseMaster.getInsuranceTaxId() != null ? insuranceResponseMaster.getInsuranceTaxId()
							: "00000000000000"); // insurance cnpj
			insuranceMapper.setPolicyNumber(
					insuranceResponseMaster.getPolicyNbr() != null ? insuranceResponseMaster.getPolicyNbr()
							: "000000000000");
			insuranceMapper.setEndorsementProtocolNumber(
					insuranceResponseMaster.getProtocolNbr() != null ? insuranceResponseMaster.getProtocolNbr()
							: "00000000000");
			insuranceMapper.setDateOfAuthorizationOfTheEndorsementProtocol(insuranceResponseMaster.getCreateDate());
			insuranceMapper.setPublicProtocolNumber(
					insuranceResponseMaster.getRegNbr() != null ? insuranceResponseMaster.getRegNbr() : "          ");
			insuranceMapper.setDateOfPublicProtocol(insuranceResponseMaster.getCreateDate());
			insuranceMapper.setCteDestinationBranchCNPJ(
					insuranceResponseMaster.getCustTaxId() != null ? insuranceResponseMaster.getCustTaxId()
							: "0000000000000");
			insuranceMapper.setOptional("00000000");
			insuranceMapper.setOptional("000000");

		} catch (Exception e) {
			log.error("Error occured TmsNfseService :: tmsNfseInsuranceMapper :: in {}", e.getMessage());
		}
		log.info("Exited...... Nfse122 mapper");
		return insuranceMapper;

	}

	// 101 transaction code

	public TmsNfseOneZeroOneMapper oneZeroOneMapper(NfseRequestDetail tmsNfse, NfeIdentityMaster nfeIdentityMaster,
			String awb) {

		TmsNfseOneZeroOneMapper tmsMapper = new TmsNfseOneZeroOneMapper();
		tmsMapper.setNfseNumber(tmsNfse.getRpsId());

		tmsMapper.setShipperName(
				tmsNfse.getServiceProviderLegalName() != null ? tmsNfse.getServiceProviderLegalName() : "0000000000");

		tmsMapper.setRecipientName(nfeIdentityMaster.getNfeParticipantDetails().getDestinationCorporateName() != null
				? nfeIdentityMaster.getNfeParticipantDetails().getDestinationCorporateName()
				: "0000000000");

		tmsMapper.setIssueDateOfRPS(tmsNfse.getRpsDate());

		if (tmsNfse.getRecipientTaxId()
				.equals(nfeIdentityMaster.getNfeParticipantDetails().getDestinationTaxIdentificationNumber())) {
			tmsMapper.setPayer("F");
		} else if (tmsNfse.getRecipientTaxId()
				.equals(nfeIdentityMaster.getNfeParticipantDetails().getDestinationTaxId())) {
			tmsMapper.setPayer("F");
		} else {
			tmsMapper.setPayer("C");
		}

		tmsMapper.setDestinationCity(tmsNfse.getServiceProviderCityName() != null ? tmsNfse.getServiceProviderCityName()
				: "0000000000000000000000000");

		tmsMapper.setValueOfProducts(tmsNfse.getTotalAmount() != null ? tmsNfse.getTotalAmount() : "000000000000000");

		if (nfeIdentityMaster.getNfeTransportDetails() != null) {
			tmsMapper.setGrossWt(String.valueOf(nfeIdentityMaster.getNfeTransportDetails().getGrossWeight() != null
					? nfeIdentityMaster.getNfeTransportDetails().getGrossWeight()
					: "000000"));
		} else {
			tmsMapper.setGrossWt("00000000000");
		}

		tmsMapper.setValueOfNfe(
				tmsNfse.getServiceTotalValueNumber() != null ? tmsNfse.getServiceTotalValueNumber() : "0000000000000");
		tmsMapper.setNetWt(String.valueOf(nfeIdentityMaster.getNfeTransportDetails().getNetWeight() != null
				? nfeIdentityMaster.getNfeTransportDetails().getNetWeight()
				: "0000"));
		tmsMapper.setWeightCharged("000000");// need to change
		tmsMapper.setDimWt("0000");

		tmsMapper.setSituacaoRPS(tmsNfse.getRpsDescription() != null ? tmsNfse.getRpsDescription() : "0");
		tmsMapper.setTaxRate(tmsNfse.getServiceSample() != null ? tmsNfse.getServiceSample() : "0000");

		if (nfeIdentityMaster.getNfeShipmentDetails() != null
				&& nfeIdentityMaster.getNfeShipmentDetails().getProductDescription() != null) {
			tmsMapper.setCodigoProduto(nfeIdentityMaster.getNfeShipmentDetails().getProductDescription());
		} else {
			tmsMapper.setCodigoProduto("000");
		}

		tmsMapper.setDestinataryFederalTaxID(nfeIdentityMaster.getNfeParticipantDetails().getDestinationTaxId() != null
				? nfeIdentityMaster.getNfeParticipantDetails().getDestinationTaxId()
				: null); // dest_cnpj

		tmsMapper.setDestTaxID(
				nfeIdentityMaster.getNfeParticipantDetails().getDestinationTaxIdentificationNumber() != null
						? nfeIdentityMaster.getNfeParticipantDetails().getDestinationTaxIdentificationNumber()
						: "00000000000000"); // dest_cpf

		tmsMapper.setShipperFederalTaxID(
				tmsNfse.getRecipientTaxId() != null ? tmsNfse.getRecipientTaxId() : "00000000000000"); // rem_cnpj

		tmsMapper.setRecipientAddress(nfeIdentityMaster.getNfeParticipantDetails().getDestinationStreetAddress() != null
				? nfeIdentityMaster.getNfeParticipantDetails().getDestinationStreetAddress()
				: "                          ");
		tmsMapper.setIssuerAddress(nfeIdentityMaster.getNfeParticipantDetails().getIssuerStreetAddress() != null
				? nfeIdentityMaster.getNfeParticipantDetails().getIssuerStreetAddress()
				: "               ");
		tmsMapper.setRecipientCity(nfeIdentityMaster.getNfeParticipantDetails().getDestinationMunicipalityName() != null
				? nfeIdentityMaster.getNfeParticipantDetails().getDestinationMunicipalityName()
				: "                    ");
		tmsMapper.setIssuerCity(nfeIdentityMaster.getNfeParticipantDetails().getIssuerMunicipalityName() != null
				? nfeIdentityMaster.getNfeParticipantDetails().getIssuerMunicipalityName()
				: "                  ");
		tmsMapper.setRecipientState(
				nfeIdentityMaster.getNfeParticipantDetails().getDestinationStateAbbreviation() != null
						? nfeIdentityMaster.getNfeParticipantDetails().getDestinationStateAbbreviation()
						: "                            ");
		tmsMapper.setIssuerState(nfeIdentityMaster.getNfeParticipantDetails().getIssuerStateAbbreviation() != null
				? nfeIdentityMaster.getNfeParticipantDetails().getIssuerStateAbbreviation()
				: "               ");
		tmsMapper.setNfseSerie(tmsNfse.getNfseResponseDetail().getRpsSerieId() != null
				? tmsNfse.getNfseResponseDetail().getRpsSerieId()
				: "0000");
		tmsMapper.setStatusCode(tmsNfse.getRpsSituation() != null ? tmsNfse.getRpsSituation() : "0");
		tmsMapper.setAwbNo(awb);

		tmsMapper.setOptional("0000000000000000");
		tmsMapper.setOptional1("00000000"); // 8
		tmsMapper.setOptional2("0000");
		tmsMapper.setOptional3("00");
		tmsMapper.setOptional4("000000000000000");
		tmsMapper.setOptional5("000000");
		tmsMapper.setOptional6(" ");
		tmsMapper.setOptional7("N");
		tmsMapper.setOptional8("01");
		tmsMapper.setOptional9("000");
		tmsMapper.setOptional10("00000000000000"); // 14
		tmsMapper.setOptional11("00000000000");
		tmsMapper.setOptional12("   ");
		tmsMapper.setOptional13("0000000000000"); // 13
		tmsMapper.setOptional14("000000000"); // 9
		tmsMapper.setOptional15("57");
		tmsMapper.setOptional16("N");
		tmsMapper.setOptional17("                    ");
		tmsMapper.setOptional18("0");
		tmsMapper.setOptional19("000000000000"); // 12
		tmsMapper.setOptional20("00000"); // 5
		tmsMapper.setOptional21("0000000000000000000000000000000000000000");
		tmsMapper.setOptional25("0000000"); // 7

		tmsMapper.setNfeCreationDate(nfeIdentityMaster.getFiscalDocumentIssueDate());
		tmsMapper.setOptional22("                                                  ");
		tmsMapper.setOptional23("                    ");
		tmsMapper.setOptional24("   ");

		tmsMapper.setNfId(nfeIdentityMaster.getFiscalDocumentNumber());

		return tmsMapper;

	}

	// 103
	public TmsNfseComplimentMapper tmsNfseComplimentMapper(NfseRequestDetail tmsNfse,
			NfeIdentityMaster nfeIdentityMaster, String StationId, String awb, String nfeCount) {
		TmsNfseComplimentMapper nfseComplimentMapper = new TmsNfseComplimentMapper();
		nfseComplimentMapper.setIssueDateOfRPS(tmsNfse.getRpsDate());
		nfseComplimentMapper.setRpsId(tmsNfse.getRpsId() != null ? tmsNfse.getRpsId() : "000000000");

		if (tmsNfse.getMatchReferenceMaster() != null && nfeIdentityMaster.getNfeTransportDetails() != null
				&& nfeIdentityMaster.getNfeTransportDetails().getGrossWeight() != null) {
			nfseComplimentMapper
					.setGrossWt(String.valueOf(nfeIdentityMaster.getNfeTransportDetails().getGrossWeight()) != null
							? String.valueOf(nfeIdentityMaster.getNfeTransportDetails().getGrossWeight())
							: "00000000000");
		} else {
			nfseComplimentMapper.setGrossWt("00000000000");
		}

		nfseComplimentMapper
				.setBaseValue(tmsNfse.getCalculationBasis() != null ? tmsNfse.getCalculationBasis() : "00000000000");
		nfseComplimentMapper
				.setTaxValueNumber(tmsNfse.getIssValueNumber() != null ? tmsNfse.getIssValueNumber() : "00000000000");

		if (tmsNfse.getRecipientTaxId()
				.equals(nfeIdentityMaster.getNfeParticipantDetails().getDestinationTaxIdentificationNumber())) {
			nfseComplimentMapper.setPayer("F");
		} else if (tmsNfse.getRecipientTaxId()
				.equals(nfeIdentityMaster.getNfeParticipantDetails().getDestinationTaxId())) {
			nfseComplimentMapper.setPayer("F");
		} else {
			nfseComplimentMapper.setPayer("C");
		}

		nfseComplimentMapper.setReceiverCnpj(nfeIdentityMaster.getNfeParticipantDetails().getDestinationTaxId() != null
				? nfeIdentityMaster.getNfeParticipantDetails().getDestinationTaxId()
				: "00000000000000");

		nfseComplimentMapper.setShipperCnpj(nfeIdentityMaster.getNfeParticipantDetails().getIssuerTaxId() != null
				? nfeIdentityMaster.getNfeParticipantDetails().getIssuerTaxId()
				: "00000000000000");
		nfseComplimentMapper.setShipperIe(nfeIdentityMaster.getNfeParticipantDetails().getIssuerIeNumber() != null
				? nfeIdentityMaster.getNfeParticipantDetails().getIssuerIeNumber()
				: "00000000000000");
		nfseComplimentMapper.setReceiverIe(nfeIdentityMaster.getNfeParticipantDetails().getDestinationIeNumber() != null
				? nfeIdentityMaster.getNfeParticipantDetails().getDestinationIeNumber()
				: "00000000000000");
		if (tmsNfse.getIssValueContinualNumber() != null) {
			nfseComplimentMapper.setIestFlag("S");
		} else {
			nfseComplimentMapper.setIestFlag("N");
		}
		nfseComplimentMapper.setIssueDateOfRPS1(tmsNfse.getRpsDate());
		nfseComplimentMapper.setDestinationState(tmsNfse.getServiceProviderLegalAddressStateName() != null
				? tmsNfse.getServiceProviderLegalAddressStateName()
				: "  ");
		nfseComplimentMapper.setTpRps(tmsNfse.getRpsType() != null ? tmsNfse.getRpsType() : "1");

		if (tmsNfse.getRpsType() != null) {

			nfseComplimentMapper.setServiceType(tmsNfse.getRpsType());
		} else {
			nfseComplimentMapper.setServiceType("N");
		}

		nfseComplimentMapper.setCnpjCpfTomador(
				tmsNfse.getRecipientTaxId() != null ? tmsNfse.getRecipientTaxId() : "00000000000000");
		nfseComplimentMapper.setNumOfNfe("1");

		nfseComplimentMapper.setTaxRate(tmsNfse.getServiceSample() != null ? tmsNfse.getServiceSample() : "0000");
		nfseComplimentMapper
				.setTaxValue(tmsNfse.getIssValueNumber() != null ? tmsNfse.getIssValueNumber() : "00000000000");// need
																												// to
																												// pad
																												// and
		nfseComplimentMapper.setCountNfe(nfeCount); // point

		nfseComplimentMapper.setAwbNbr(awb != null ? awb : "                    ");

		nfseComplimentMapper.setSenderZipCode(tmsNfse.getServiceProviderLegalAddressZipCode() != null
				? tmsNfse.getServiceProviderLegalAddressZipCode()
				: "00000000");
		nfseComplimentMapper.setRecipientZipCode(
				tmsNfse.getRecipientAddressZipCode() != null ? tmsNfse.getRecipientAddressZipCode() : "00000000");
		nfseComplimentMapper.setDefaultValue("BOX");
		nfseComplimentMapper.setDefaultValue1("DIVERSO");
		nfseComplimentMapper.setDefaultValue3("N");
		nfseComplimentMapper.setOptional("0000000000000");// 13zeros
		nfseComplimentMapper.setOptional1("00000000000");// 11zeros
		nfseComplimentMapper.setOptional2("000000000");// 9zeros
		nfseComplimentMapper.setOptional3("00000000");// 8zeros
		nfseComplimentMapper.setOptional4("0000000");// 7zeros
		nfseComplimentMapper.setOptional5("00000");// 5zeros
		nfseComplimentMapper.setOptional6("0000");// 4zeros
		nfseComplimentMapper.setOptional7("000");// 3zeros
		nfseComplimentMapper.setOptional8("00");// 2zeros
		nfseComplimentMapper.setOptional9("0");// 1zero
		nfseComplimentMapper.setOptional14("000000");// 6zeros
		nfseComplimentMapper.setOptional15("000000000000");// 12zeros

		nfseComplimentMapper.setOptional10(" ");// 1space
		nfseComplimentMapper.setOptional11("  ");// 2spaces
		nfseComplimentMapper.setOptional12("               ");// 15spaces
		nfseComplimentMapper.setOptional13("                    ");// 20spaces
		nfseComplimentMapper.setOptional16("         ");// 9spaces

		nfseComplimentMapper.setCfop(nfeIdentityMaster.getNfeShipmentDetails().getOperationsFiscalCode() != null
				? nfeIdentityMaster.getNfeShipmentDetails().getOperationsFiscalCode()
				: "0000");

		return nfseComplimentMapper;
	}

	// 123 MAPPER
	public TmsAwbMapper tmsNfseAwbMapper(NfseRequestDetail tmscte, String masterAwb, String childAwbNumber,
			String tipoServico) {
		TmsAwbMapper awbMapper = new TmsAwbMapper();

		awbMapper.setAwbNumber(masterAwb);
		awbMapper.setServiceType(tipoServico);
		awbMapper.setChildAwbNum(childAwbNumber);
		return awbMapper;

	}

	public String stationCodePadding(String cd) {
		String flag = null;
		int length = cd.toString().length();
		if (length <= 4 && cd != null) {
			if (length == 4)
				flag = cd;
			else if (length == 3) {
				flag = "0" + cd;

			} else if (length == 2) {
				flag = "00" + cd;
			} else if (length == 1) {
				flag = "000" + cd;
			}

		}

		return flag;

	}

}

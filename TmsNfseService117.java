package com.fedex.breco.insurance.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fedex.breco.insurance.dto.NfseRequestDetail;
import com.fedex.breco.insurance.mapper.TmsNfseMapper117;
import com.fedex.breco.insurance.nfe.dto.NfeIdentityMaster;
import com.fedex.breco.insurance.nfe.dto.StationLocationDetails;
import com.fedex.breco.insurance.utils.TmsNfseValidation117;

@Service
public class TmsNfseService117 {

	TmsNfseValidation117 nfseValidation117 = new TmsNfseValidation117();
	private static final Logger log = LoggerFactory.getLogger(TmsNfseService117.class);

	public TmsNfseMapper117 nfseMapper117(NfseRequestDetail tmsNfse, NfeIdentityMaster nfeIdentityMaster,
			StationLocationDetails stationDestLoc, String stationCnpj) {
		TmsNfseMapper117 mapper117 = new TmsNfseMapper117();
		try {
			final String defaultvalue1 = "Brasil";
			final String cnpj = "J";
			final String cpf = "F";
			final String nfsevalue = "05";

			mapper117.setInternalServiceCode(
					tmsNfse.getInternalServiceCode() != null ? tmsNfse.getInternalServiceCode() : "0000");
			mapper117.setRpsId(tmsNfse.getRpsId() != null ? tmsNfse.getRpsId() : "000000000");
			mapper117.setRpsDate(tmsNfse.getRpsDate());
			mapper117.setQcarga("000000");
			mapper117.setStationidcnpj(stationCnpj != null ? stationCnpj : "00000000000000");
			mapper117.setModal("01");
			mapper117.setOptional17(" ");
			mapper117.setMod(nfsevalue);
			mapper117.setNfseType(tmsNfse.getRpsType() != null ? tmsNfse.getRpsType() : "00");
			mapper117.setOptional1("                                           ");// 44spaces
			mapper117.setOptional2("00");
			mapper117.setOptional3("               ");// 15s
			mapper117.setOptional4("     ");// 5s
			mapper117.setServicetype("000");

			if (tmsNfse.getRecipientTaxId()
					.equals(nfeIdentityMaster.getNfeParticipantDetails().getDestinationTaxIdentificationNumber())) {
				mapper117.setPayer("03");
			} else if (tmsNfse.getRecipientTaxId()
					.equals(nfeIdentityMaster.getNfeParticipantDetails().getDestinationTaxId())) {
				mapper117.setPayer("03");
			} else {
				mapper117.setPayer("00");
			}
			// mapper117.setPayer("00");

			mapper117.setCfop(nfeIdentityMaster.getNfeShipmentDetails().getOperationsFiscalCode() != null
					? nfeIdentityMaster.getNfeShipmentDetails().getOperationsFiscalCode()
					: "0000"); // cfop mapped FROM nfe

			mapper117.setOptional5("000000");// 6zer
			mapper117.setOptional6("0000000000000");// 13zero
			mapper117.setOptional7("00000"); // 5.2-5zero
			mapper117
					.setTax(tmsNfse.getIssValueContinualNumber() != null ? tmsNfse.getIssValueContinualNumber() : "00");
			mapper117.setOptional7("00000"); // 5.2-5zero
			mapper117.setOptional6("0000000000000");// 13.2-13zero
			mapper117.setOptional6("0000000000000");// 13.2=13zero
			mapper117.setOptional23("0"); // 1z
			mapper117.setOptional2("00");
			mapper117.setOptional8("00000000000000");// 14z
			mapper117.setOptional9("              ");// 14sp
			mapper117.setOptional10("  ");// 2sp
			mapper117.setOptional11("                                        ");// 40sp
			mapper117.setOptional12("   ");// 3sp
			mapper117.setOptional13("    ");// 4sp
			mapper117.setOptional14("                    ");// 20sp
			mapper117.setOptional15("00000000"); // 8zer
			mapper117.setObservations("          "); // xobs

			// emiT
			mapper117.setFedextaxid(tmsNfse.getFedexTaxId() != null ? tmsNfse.getFedexTaxId() : "00000000000000");
			mapper117.setStatetaxid("              ");
			mapper117.setCompanyname(
					tmsNfse.getServiceProviderLegalName() != null ? tmsNfse.getServiceProviderLegalName()
							: "                            ");
			mapper117.setOptional22("FedEx");
			mapper117.setAddressstrt(
					tmsNfse.getServiceProviderLegalAddress() != null ? tmsNfse.getServiceProviderLegalAddress()
							: "                            ");
			mapper117.setAddressno(tmsNfse.getServiceProviderLegalAddressNumber() != null
					? tmsNfse.getServiceProviderLegalAddressNumber()
					: "         ");
			mapper117.setOptional17("                                        ");// 60sp
			mapper117.setAddressstrtnbrhd(tmsNfse.getServiceProviderLegalNeighbourhoodAddressNumber() != null
					? tmsNfse.getServiceProviderLegalNeighbourhoodAddressNumber()
					: "                            ");
			mapper117.setAddressscitycd("000000000"); // no field in db
			mapper117.setAddresscity(tmsNfse.getServiceProviderCityName() != null ? tmsNfse.getServiceProviderCityName()
					: "                 ");
			mapper117.setAddressszip(tmsNfse.getServiceProviderLegalAddressZipCode() != null
					? tmsNfse.getServiceProviderLegalAddressZipCode()
					: "00000000");
			mapper117.setAddressstate(tmsNfse.getServiceProviderLegalAddressStateName() != null
					? tmsNfse.getServiceProviderLegalAddressStateName()
					: "  ");
			mapper117.setOptional18(" ");// 1sp
			mapper117.setDefvalue("1058");
			mapper117.setDefvalue1(defaultvalue1);

			// rem
			mapper117.setShipperfedextaxid(nfeIdentityMaster.getNfeParticipantDetails().getIssuerTaxId() != null
					? nfeIdentityMaster.getNfeParticipantDetails().getIssuerTaxId()
					: "00000000000000");
			mapper117.setShipperfdxSocIdentyNum(
					nfeIdentityMaster.getNfeParticipantDetails().getShipperTaxIdentificationNumber() != null
							? nfeIdentityMaster.getNfeParticipantDetails().getShipperTaxIdentificationNumber()
							: "00000000000000");
			mapper117.setValue(cnpj);

			mapper117.setShipperstatetaxid(nfeIdentityMaster.getNfeParticipantDetails().getIssuerIeNumber() != null
					? nfeIdentityMaster.getNfeParticipantDetails().getIssuerIeNumber()
					: "ISENTO"); // REM_IE

			mapper117.setShippercorpnm(nfeIdentityMaster.getNfeParticipantDetails().getIssuerCorporateName() != null
					? nfeIdentityMaster.getNfeParticipantDetails().getIssuerCorporateName()
					: "                 ");

			mapper117.setOptional17("                                        ");// 60sp

			mapper117
					.setShipperaddrstrtext(nfeIdentityMaster.getNfeParticipantDetails().getIssuerStreetAddress() != null
							? nfeIdentityMaster.getNfeParticipantDetails().getIssuerStreetAddress()
							: "                 ");

			mapper117.setShipperaddrnbr(nfeIdentityMaster.getNfeParticipantDetails().getIssuerAddressNumber() != null
					? nfeIdentityMaster.getNfeParticipantDetails().getIssuerAddressNumber()
					: "         ");

			mapper117.setOptional17("                                        ");// 60sp

			mapper117.setShippernebortxt(
					nfeIdentityMaster.getNfeParticipantDetails().getIssuerNeighborhoodAddress() != null
							? nfeIdentityMaster.getNfeParticipantDetails().getIssuerNeighborhoodAddress()
							: "                 ");

			mapper117.setShippercitycd(nfeIdentityMaster.getNfeParticipantDetails().getIssuerMunicipalityCode() != null
					? nfeIdentityMaster.getNfeParticipantDetails().getIssuerMunicipalityCode()
					: "000000000");

			mapper117
					.setShippercityname(nfeIdentityMaster.getNfeParticipantDetails().getIssuerMunicipalityName() != null
							? nfeIdentityMaster.getNfeParticipantDetails().getIssuerMunicipalityName()
							: "                 ");

			mapper117.setShipperaddrzipcd(nfeIdentityMaster.getNfeParticipantDetails().getIssuerZipCodeAddress() != null
					? nfeIdentityMaster.getNfeParticipantDetails().getIssuerZipCodeAddress()
					: "00000000");

			mapper117
					.setShipperabbrtxt(nfeIdentityMaster.getNfeParticipantDetails().getIssuerStateAbbreviation() != null
							? nfeIdentityMaster.getNfeParticipantDetails().getIssuerStateAbbreviation()
							: "  ");

			mapper117.setOptional18(" ");// 1sp
			mapper117.setDefvalue("1058");
			mapper117.setDefvalue1(defaultvalue1);

			// dest
			mapper117.setDestcnpj(nfeIdentityMaster.getNfeParticipantDetails().getDestinationTaxId() != null
					? nfeIdentityMaster.getNfeParticipantDetails().getDestinationTaxId()
					: null); // added dest_cnpj

			mapper117.setDestcpf(
					nfeIdentityMaster.getNfeParticipantDetails().getDestinationTaxIdentificationNumber() != null
							? nfeIdentityMaster.getNfeParticipantDetails().getDestinationTaxIdentificationNumber()
							: "00000000000000");

			/*
			 * mapper117.setDestfedtaxidnbr(nfeIdentityMaster.getNfeParticipantDetails().
			 * getDestinationTaxId() != null ?
			 * nfeIdentityMaster.getNfeParticipantDetails().getDestinationTaxId() :
			 * "00000000000000");
			 */

			mapper117.setValue(cnpj);

			mapper117.setValue1(cpf);

			mapper117.setDeststatetaxnbr(nfeIdentityMaster.getNfeParticipantDetails().getDestinationIeNumber() != null
					? nfeIdentityMaster.getNfeParticipantDetails().getDestinationIeNumber()
					: "ISENTO");// DEST_IE

			mapper117.setDestcorpnm(nfeIdentityMaster.getNfeParticipantDetails().getDestinationCorporateName() != null
					? nfeIdentityMaster.getNfeParticipantDetails().getDestinationCorporateName()
					: "                 ");

			mapper117.setOptional17("                                        ");// 60sp

			mapper117.setDestaddrstrtxt(
					nfeIdentityMaster.getNfeParticipantDetails().getDestinationStreetAddress() != null
							? nfeIdentityMaster.getNfeParticipantDetails().getDestinationStreetAddress()
							: "                 "); // dest-xlgr

			mapper117.setDestaddrnbr(nfeIdentityMaster.getNfeParticipantDetails().getDestinationAddressNumber() != null
					? nfeIdentityMaster.getNfeParticipantDetails().getDestinationAddressNumber()
					: "         ");// 10sp

			mapper117.setOptional17("                                        ");// 60sp

			mapper117.setDestniborhdtxt(
					nfeIdentityMaster.getNfeParticipantDetails().getDestinationNeighborhoodAddress() != null
							? nfeIdentityMaster.getNfeParticipantDetails().getDestinationNeighborhoodAddress()
							: "                 ");

			mapper117
					.setDestaddrcd(nfeIdentityMaster.getNfeParticipantDetails().getDestinationMunicipalityCode() != null
							? nfeIdentityMaster.getNfeParticipantDetails().getDestinationMunicipalityCode()
							: "000000000");

			mapper117.setDestcityname(
					nfeIdentityMaster.getNfeParticipantDetails().getDestinationMunicipalityName() != null
							? nfeIdentityMaster.getNfeParticipantDetails().getDestinationMunicipalityName()
							: "                 ");

			mapper117.setDestaddrzipcd(
					nfeIdentityMaster.getNfeParticipantDetails().getDestinationZipCodeAddress() != null
							? nfeIdentityMaster.getNfeParticipantDetails().getDestinationZipCodeAddress()
							: "00000000");

			mapper117.setDestaddstabbr(
					nfeIdentityMaster.getNfeParticipantDetails().getDestinationStateAbbreviation() != null
							? nfeIdentityMaster.getNfeParticipantDetails().getDestinationStateAbbreviation()
							: "  ");

			mapper117.setOptional18(" ");// 1sp
			mapper117.setDefvalue("1058");

			// optionals
			mapper117.setOptional16("0000"); // 4zeros
			mapper117.setOptional19("000000000"); // 9zeros
			mapper117.setOptional8("00000000000000"); // 14zeros
			mapper117.setOptional18(" "); // 1space
			mapper117.setOptional9("              "); // 14space
			mapper117.setOptional17("                             "); // 60space
			mapper117.setOptional17("                             "); // 60space
			mapper117.setOptional17("                             "); // 60space
			mapper117.setOptional20("         "); // 10space
			mapper117.setOptional17("                             "); // 60space
			mapper117.setOptional17("                             "); // 60space
			mapper117.setOptional19("000000000"); // 9zeros
			mapper117.setOptional17("                             "); // 60space
			mapper117.setOptional15("00000000"); // 8zeros
			mapper117.setOptional10("  "); // 2space
			mapper117.setOptional18(" "); // 1space
			mapper117.setOptional16("0000"); // 4zeros
			mapper117.setOptional16("0000"); // 4zeros

			// exp
			mapper117.setExpedcnpj("00000000000000");
			mapper117.setOptional(cnpj);
			mapper117.setExpedstatetaxid("ISENTO");
			mapper117.setExpedcompname("                 ");
			mapper117.setOptional22("FedEx");
			mapper117.setExpedxlgr("                 ");
			mapper117.setExpednro("         ");// 10sp
			mapper117.setExpedaddrress("                                        ");// 60sp
			mapper117.setExpednbrhdaddrress("                 ");
			mapper117.setExpedcitycode("000000000");
			mapper117.setExpedcityname("                 ");
			mapper117.setExpedaddrzipcd("00000000");
			mapper117.setExpedaddrst("  ");
			mapper117.setOptional23(" ");// 1sp
			mapper117.setDefvalue("1058");
			mapper117.setDefvalue1(defaultvalue1);

			// recep
			mapper117.setRecebcnpj("00000000000000");
			mapper117.setOptional(cnpj);
			mapper117.setRecebstatetaxid("ISENTO");
			mapper117.setRecebcompname("                 ");
			mapper117.setOptional22("  ");
			mapper117.setRecebxlgr("                 ");
			mapper117.setRecebnro("         ");// 10sp
			mapper117.setRecebaddrress("                                        ");// 60sp
			mapper117.setRecebnbrhdaddrress("                 ");
			mapper117.setRecebcitycode("000000000");
			mapper117.setRecebcityname("                 ");
			mapper117.setRecebaddrzipcd("00000000");
			mapper117.setRexcebaddrst("  ");
			mapper117.setOptional23(" ");// 1sp
			mapper117.setDefvalue("1058");
			mapper117.setDefvalue1(defaultvalue1);

			// optionals
			mapper117.setOptional8("00000000000000"); // 14zeros
			mapper117.setOptional18(" "); // 1space
			mapper117.setOptional9("              "); // 14space
			mapper117.setOptional17("                             "); // 60space
			mapper117.setOptional17("                             "); // 60space
			mapper117.setOptional17("                             "); // 60space
			mapper117.setOptional20("         "); // 10space
			mapper117.setOptional17("                             "); // 60space
			mapper117.setOptional17("                             "); // 60space
			mapper117.setOptional19("000000000"); // 9zeros
			mapper117.setOptional17("                             "); // 60space
			mapper117.setOptional15("00000000"); // 8zeros
			mapper117.setOptional10("  "); // 2space
			mapper117.setOptional18(" "); // 1space
			mapper117.setOptional16("0000"); // 4zeros
			mapper117.setOptional17("                             "); // 60space
			mapper117.setOptional8("00000000000000"); // 14zeros
			mapper117.setOptional18(" "); // 1space
			mapper117.setOptional9("              "); // 14space
			mapper117.setOptional17("                             "); // 60space
			mapper117.setOptional17("                             "); // 60space
			mapper117.setOptional17("                             "); // 60space
			mapper117.setOptional20("         "); // 10space
			mapper117.setOptional17("                             "); // 60space
			mapper117.setOptional17("                             "); // 60space
			mapper117.setOptional19("000000000"); // 9zeros
			mapper117.setOptional17("                             "); // 60space
			mapper117.setOptional15("00000000"); // 8zeros
			mapper117.setOptional10("  "); // 2space
			mapper117.setOptional18(" "); // 1space
			mapper117.setOptional16("0000"); // 4zeros
			mapper117.setOptional17("                             "); // 60space
			mapper117.setOptional18(" "); // 1space
			mapper117.setOptional5("000000"); // 6zeros

			mapper117.setDefvalue1(defaultvalue1);

			mapper117.setOptional18(" "); // 1space
			mapper117.setOptional18(" "); // 1space

			mapper117.setSendzipcode("C");
			mapper117.setRecpzipcode("C");

			mapper117.setOptional18(" "); // 1space
			mapper117.setOptional16("0000"); // 4zeros
			mapper117.setOptional18(" "); // 1space
			mapper117.setOptional2("00"); // 2zeros
			mapper117.setOptional10("  "); // 2space
			mapper117.setOptional10("  "); // 2space
			mapper117.setOptional21("0000000"); // 7zeros

			mapper117.setManualentered("S");
			mapper117.setAmtentered("N");
			mapper117.setGrosswght("0000");

			mapper117.setOptional13("    ");// 4sp

			if (stationDestLoc != null) {
				mapper117.setDestinationCnpj(
						stationDestLoc.getTaxId() != null ? stationDestLoc.getTaxId() : "00000000000000");
			} else {
				mapper117.setDestinationCnpj("00000000000000");
			}

		} catch (Exception e) {
			log.info("Error occured TmsCteService117 :: CteMapper117 :: in {}", e.getMessage());
		}
		return mapper117;

	}
}

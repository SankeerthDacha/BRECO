package com.fedex.breco.insurance.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fedex.breco.insurance.cte.model.CteIdentityMaster;
import com.fedex.breco.insurance.mapper.TmsCteMapper117;
import com.fedex.breco.insurance.nfe.dto.NfeIdentityMaster;
import com.fedex.breco.insurance.nfe.dto.StationLocationDetails;
import com.fedex.breco.insurance.utils.TmsCteValidation117;

@Service
public class TmsCteService117 {

	TmsCteValidation117 cteValidation117 = new TmsCteValidation117();
	private static final Logger log = LoggerFactory.getLogger(TmsCteService.class);

	public TmsCteMapper117 cteMapper117(CteIdentityMaster tmscte, NfeIdentityMaster nfeIdentityMaster,
			String stationOriginTaxId, StationLocationDetails stationLocationDetails) {
		TmsCteMapper117 mapper117 = new TmsCteMapper117();
		try {
			final String defaultvalue1 = "Brasil";
			final String cnpj = "J";
			final String cpf = "F";
			final String ctevalue = "57";
			final String valuespace = "                                           ";
			mapper117.setCteNbr(tmscte.getCteNumber() != null ? tmscte.getCteNumber() : "000000000");
			mapper117.setcCT(
					tmscte.getAccessKeyVerifyNumber() != null ? tmscte.getAccessKeyVerifyNumber() : "000000000");
			mapper117.setCteIssueDate(tmscte.getCteIssueDate());
			mapper117.setQcarga(
					tmscte.getCteProductDetails().getGrossWt() != null ? tmscte.getCteProductDetails().getGrossWt()
							: "000000");
			mapper117.setStationidcnpj(stationOriginTaxId != null ? stationOriginTaxId : "00000000000000"); // changed
			mapper117.setModal(tmscte.getTransportModal() != null ? tmscte.getTransportModal() : "01");
			mapper117.setOptional2(" ");
			mapper117.setMod(tmscte.getTaxDocumentModalCode() != null ? tmscte.getTaxDocumentModalCode() : ctevalue);
			mapper117.setCtetype(tmscte.getCteType() != null ? tmscte.getCteType() : "00");
			mapper117.setCteid(tmscte.getCteCode() != null ? tmscte.getCteCode() : valuespace);
			mapper117.setOptional3("00");
			mapper117.setOptional4("               ");
			mapper117.setOptional5("     ");
			mapper117.setServicetype(tmscte.getServicetypeCode() != null ? tmscte.getServicetypeCode() : "000");
			mapper117.setPayer(tmscte.getServicePayingResponsiblePersonCode() != null
					? tmscte.getServicePayingResponsiblePersonCode()
					: "00");
			mapper117.setCfop(tmscte.getOperationServiceTaxCode());
			mapper117.setOptional6("000000");
			mapper117.setOptional7("0000000000000");
			mapper117.setOptional8("00000"); // changed to 5.2=5zeros

			if (tmscte.getCteTransportInfo() != null) {
				mapper117.setTax(tmscte.getCteTransportInfo().getStateTaxCode() != null
						? tmscte.getCteTransportInfo().getStateTaxCode()
						: "00"); // changed to cst
			} else {
				mapper117.setTax("00");
			}

			mapper117.setOptional8("00000"); // changed to 5.2zeros
			mapper117.setOptional9("0000000000000"); // changed to 13.2 =13 zeros
			mapper117.setOptional9("0000000000000"); // changed to 13.2 zeros
			mapper117.setOptional10("0");
			mapper117.setOptional3("00");
			mapper117.setOptional11("00000000000000");
			mapper117.setOptional12("              ");
			mapper117.setOptional13("  ");
			mapper117.setOptional14("                                              ");
			mapper117.setOptional15("   ");
			mapper117.setOptional16("    ");
			mapper117.setOptional17("                    ");
			mapper117.setOptional18("   "); // changed date row 37
			mapper117.setObservations("  "); // xobs

			// emit
			mapper117.setFedextaxid(tmscte.getCteParticipantDetails().getSenderTaxId() != null
					? tmscte.getCteParticipantDetails().getSenderTaxId()
					: "0000000000000");
			mapper117.setStatetaxid(tmscte.getCteParticipantDetails().getSenderStateTaxNumber());// emit_ie
			mapper117.setCompanyname(tmscte.getCteParticipantDetails().getSenderCorporateName());
			mapper117.setOptional19("FedEx");

			mapper117.setAddressstrt(tmscte.getCteParticipantDetails().getSenderStreetAddress());
			mapper117.setAddressno(tmscte.getCteParticipantDetails().getSenderAddressNumber());
			mapper117.setOptional20("                ");
			mapper117.setAddressstrtnbrhd(tmscte.getCteParticipantDetails().getSenderNeibourhoodAddress());
			mapper117.setAddressscitycd(tmscte.getCteParticipantDetails().getSenderCityCode());
			mapper117.setAddresscity(tmscte.getCteParticipantDetails().getSenderCityName());

			mapper117.setAddressszip(tmscte.getCteParticipantDetails().getSenderAddressZipCode());
			mapper117.setAddressstate(tmscte.getCteParticipantDetails().getSenderStateAbbreviation());
			mapper117.setOptional21(" ");
			mapper117.setDefvalue("1058"); // changed
			mapper117.setDefvalue1(defaultvalue1);

			// rem
			mapper117.setShipperfedextaxid(tmscte.getCteParticipantDetails().getTaxIdNumber());
			mapper117.setShipperstatetaxid(tmscte.getCteParticipantDetails().getShipperStateTaxNumber() != null
					? tmscte.getCteParticipantDetails().getShipperStateTaxNumber()
					: "ISENTO"); // rem_IE
			mapper117.setShippercorpnm(tmscte.getCteParticipantDetails().getShipperCorporateName());
			mapper117.setOptional20("                ");
			mapper117.setShipperaddrstrtext(tmscte.getCteParticipantDetails().getShipperStreetAddress());
			mapper117.setShipperaddrnbr(tmscte.getCteParticipantDetails().getShipperAddressNumber());
			mapper117.setOptional20("                ");
			mapper117.setShippernebortxt(tmscte.getCteParticipantDetails().getShipperNeighbourhoodAddress());
			mapper117.setShippercitycd(tmscte.getCteParticipantDetails().getShipperAddressCityCode());
			mapper117.setShippercityname(tmscte.getCteParticipantDetails().getShipperCityName());
			mapper117.setShipperaddrzipcd(tmscte.getCteParticipantDetails().getShipperAddressZipCode());
			mapper117.setShipperabbrtxt(tmscte.getCteParticipantDetails().getShipperStateAbbreviation());
			mapper117.setOptional2(" ");
			mapper117.setDefvalue("1058"); // changed
			mapper117.setDefvalue1(defaultvalue1);

			// dest
			mapper117.setDestCNPJ(tmscte.getCteParticipantDetails().getRecpTaxIdNum() != null
					? tmscte.getCteParticipantDetails().getRecpTaxIdNum()
					: null); // added recp_cnpj

			mapper117.setRecpCPF(tmscte.getCteParticipantDetails().getRecipientFedexTaxIdentitySocialNumber() != null
					? tmscte.getCteParticipantDetails().getRecipientFedexTaxIdentitySocialNumber()
					: "00000000000000");

			mapper117.setRecpCNPJ(cpf);
			mapper117.setRecpstatetaxnbr(tmscte.getCteParticipantDetails().getRecipientStateTaxNumber() != null
					? tmscte.getCteParticipantDetails().getRecipientStateTaxNumber()
					: "ISENTO"); // dest_IE
			mapper117.setRecpcorpnm(tmscte.getCteParticipantDetails().getRecipientCorporateName());
			mapper117.setOptional20("                ");
			mapper117.setRecpaddrstrtxt(tmscte.getCteParticipantDetails().getRecipientStreetAddress());
			mapper117.setRecpaddrnbr(tmscte.getCteParticipantDetails().getRecipientAddressNumber());
			mapper117.setOptional20("                ");
			mapper117.setRecpniborhdtxt(tmscte.getCteParticipantDetails().getRecipientNeighbourhoodAddress());
			mapper117.setRecpaddrcd(tmscte.getCteParticipantDetails().getRecipientAddressCityCode());
			mapper117.setRecpcityname(tmscte.getCteParticipantDetails().getRecipientCityName());
			mapper117.setRecpAddrZipCd(tmscte.getCteParticipantDetails().getRecipientAddressZipCode());
			mapper117.setRecpaddstabbr(tmscte.getCteParticipantDetails().getRecipientAddressStateAbbreviation());
			mapper117.setOptional2(" ");
			mapper117.setDefvalue("1058");

			mapper117.setOptional22("    ");
			mapper117.setOptional23("000000000");
			mapper117.setOptional24("00000000000000");
			mapper117.setOptional2(" ");
			mapper117.setOptional25("              ");
			mapper117.setOptional20("                ");
			mapper117.setOptional20("                ");
			mapper117.setOptional20("                ");
			mapper117.setOptional26("           ");
			mapper117.setOptional20("                ");
			mapper117.setOptional20("                ");
			mapper117.setOptional27("000000000");
			mapper117.setOptional20("                ");
			mapper117.setOptional28("00000000"); // 8
			mapper117.setOptional13("  ");
			mapper117.setOptional2(" ");
			mapper117.setOptional29("0000");
			mapper117.setOptional29("0000");

			mapper117.setExpedcnpj("00000000000000");
			mapper117.setOptional32(" ");
			mapper117.setExpedstatetaxid("ISENTO"); // exped_IE
			mapper117.setExpedcompname(nfeIdentityMaster.getNfeParticipantDetails().getShipperCorporateName() != null
					? nfeIdentityMaster.getNfeParticipantDetails().getShipperCorporateName() // added name from nfe
																								// table
					: "            ");
			mapper117.setOptional19(" ");
			mapper117.setExpedxlgr("          ");
			mapper117.setExpednro("           ");
			mapper117.setExpedaddrress("");
			mapper117.setExpednbrhdaddrress("          ");

			mapper117.setExpedcitycode("000000000");
			mapper117.setExpedcityname("          ");
			mapper117.setExpedaddrzipcd("00000000");
			mapper117.setExpedaddrst("  ");
			mapper117.setOptional31("0");
			mapper117.setDefvalue("1058"); //
			mapper117.setDefvalue1(defaultvalue1);

			mapper117.setRecebcnpj("00000000000000");
			mapper117.setOptional32(" ");
			mapper117.setRecebstatetaxid("ISENTO"); // Receb_IE
			mapper117.setRecebcompname(nfeIdentityMaster.getNfeParticipantDetails().getRecipientCorporateName() != null
					? nfeIdentityMaster.getNfeParticipantDetails().getRecipientCorporateName()
					: "         ");
			mapper117.setOptional19(" ");
			mapper117.setRecebxlgr("           ");
			mapper117.setRecebnro("            ");
			mapper117.setRecebaddrress(" ");
			mapper117.setRecebnbrhdaddrress("          ");

			mapper117.setRecebcitycode("000000000");
			mapper117.setRecebcityname("           ");
			mapper117.setRecebaddrzipcd("00000000");
			mapper117.setRexcebaddrst("          ");

			mapper117.setOptional10("0");
			mapper117.setDefvalue("1058");
			mapper117.setDefvalue1(defaultvalue1);

			mapper117.setOptional11("00000000000000");
			mapper117.setOptional2(" ");
			mapper117.setOptional12("              ");
			mapper117.setOptional20("                ");
			mapper117.setOptional20("                ");
			mapper117.setOptional20("                ");
			mapper117.setOptional26("           ");
			mapper117.setOptional20("                ");
			mapper117.setOptional20("                ");
			mapper117.setOptional27("000000000");
			mapper117.setOptional20("                ");
			mapper117.setOptional28("00000000");
			mapper117.setOptional13("  ");
			mapper117.setOptional2(" ");
			mapper117.setOptional29("0000");
			mapper117.setOptional20("                ");
			mapper117.setOptional2(" ");
			mapper117.setOptional6("000000");
			mapper117.setDefvalue1(defaultvalue1);
			mapper117.setOptional2(" ");
			mapper117.setOptional2(" ");

			mapper117.setSendzipcode("C");
			mapper117.setRecpzipcode("C");

			mapper117.setOptional2(" ");
			mapper117.setOptional29("0000");
			mapper117.setOptional2(" ");
			mapper117.setOptional3("00");
			mapper117.setOptional13("  ");
			mapper117.setOptional13("  ");
			mapper117.setOptional30("0000000");// changed to 7.4 zeros

			mapper117.setManualentered("S");
			mapper117.setAmtentered("N");
			Float value = 0f;
			if (tmscte.getCteProductDetails().getGrossWt() != null
					&& tmscte.getCteProductDetails().getTotalVolume() != null) {

				Float grosswt = Float.parseFloat(tmscte.getCteProductDetails().getGrossWt());
				Float cubicwt = Float.parseFloat(tmscte.getCteProductDetails().getTotalVolume());
				if (grosswt > 0 && cubicwt > 0) {
					value = (grosswt / cubicwt);
					mapper117.setGrosswght(String.valueOf(value));
				} else {
					mapper117.setGrosswght("0000");
				}
			} else {
				mapper117.setGrosswght("0000");

			}

			mapper117.setOptional16("    ");

			if (stationLocationDetails != null) {

				mapper117.setDestStatonidcnpj(
						stationLocationDetails.getTaxId() != null ? stationLocationDetails.getTaxId()
								: "00000000000000");
			} else {
				mapper117.setDestStatonidcnpj("00000000000000");
			}

		} catch (Exception e) {
			log.info("Error occured TmsCteService117 :: CteMapper117 :: in {}", e.getMessage());
		}
		return mapper117;

	}

}

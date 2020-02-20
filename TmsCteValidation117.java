package com.fedex.breco.insurance.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import com.fedex.breco.insurance.mapper.TmsCteMapper117;

@Component
public class TmsCteValidation117 {

	public StringBuilder cteValidation117(TmsCteMapper117 tmscte, String stationcd) {

		StringBuilder content = new StringBuilder();

		concat(content, "117", "#"); // 1.117
		if (stationcd != null) {
			concat(content, stationcd, "#"); // 2. station code

		} else {
			concat(content, "0000", "#");
		}
		concat(content, tmscte.getCteNbr(), "#"); // 3.accs_key_Code

		if (tmscte.getCteIssueDate() != null) {// 4.YYYYMMDD

			DateTime dateTime = new DateTime(tmscte.getCteIssueDate());

			String ddMMyyyy = "";

			ddMMyyyy = "" + (dateTime.getDayOfMonth() < 10 ? "0" + dateTime.getDayOfMonth() : dateTime.getDayOfMonth())
					+ String.valueOf(dateTime.getMonthOfYear() < 10 ? "0" + dateTime.getMonthOfYear()
							: dateTime.getMonthOfYear())
					+ (String.valueOf(dateTime.getYear()));

			concat(content, ddMMyyyy, "#");
		} else {
			concat(content, tmscte.getOptional(), "#");

		}
		String replaceCargo = tmscte.getQcarga().replace(".", "");
		String with6digits = String.format("%06d", Integer.parseInt(replaceCargo));
		concat(content, with6digits, "#"); // 16

		concat(content, tmscte.getStationidcnpj().replaceAll("[()?:!/.,;{}-]", ""), "#"); // 6.stationid cnpj
		concat(content, tmscte.getModal(), "#"); // 7.modal
		concat(content, tmscte.getOptional2(), "#"); // 8.1 space
		concat(content, tmscte.getMod(), "#"); // 9.mod
		concat(content, StringUtils.leftPad(tmscte.getCtetype(), 2, "0"), "#"); // 10.cte type 00
		concat(content, tmscte.getCteid(), "#"); // 11.cte id 44 digits
		concat(content, tmscte.getOptional3(), "#"); // 2 zeros
		concat(content, tmscte.getOptional4(), "#"); // 15 sapces
		concat(content, tmscte.getOptional5(), "#"); // 5 spaces
		concat(content, StringUtils.leftPad(tmscte.getServicetype(), 3, "0"), "#"); // 3N

		concat(content, StringUtils.leftPad(tmscte.getPayer(), 2, "0"), "#"); // 2N

		concat(content, tmscte.getCfop(), "#"); // 4A
		concat(content, tmscte.getOptional6(), "#"); // 6 zeros
		concat(content, tmscte.getOptional7(), "#"); // 13 zeros
		concat(content, tmscte.getOptional8(), "#"); // 5.2 zeros
		concat(content, tmscte.getTax(), "#"); // cst tag
		concat(content, tmscte.getOptional8(), "#"); // 5.2 zeros
		concat(content, tmscte.getOptional9(), "#"); // 13.2 zeros
		concat(content, tmscte.getOptional9(), "#"); // 13.2 zeros
		concat(content, tmscte.getOptional10(), "#"); // 1 zero
		concat(content, tmscte.getOptional3(), "#"); // 2 zero
		concat(content, tmscte.getOptional11(), "#"); // 14 zero
		concat(content, tmscte.getOptional12(), "#"); // 14 spaces
		concat(content, tmscte.getOptional13(), "#"); // 2 spaces
		concat(content, tmscte.getOptional14(), "#"); // 40 spaces
		concat(content, tmscte.getOptional15(), "#"); // 3
		concat(content, tmscte.getOptional16(), "#"); // 4
		concat(content, tmscte.getOptional17(), "#"); // 20
		concat(content, tmscte.getOptional28(), "#"); // 8 ZEROS
		concat(content, tmscte.getObservations(), "#"); // xobs
		// Emit_
		concat(content, tmscte.getFedextaxid(), "#"); // 14 N

		concat(content, StringUtils.leftPad(tmscte.getStatetaxid().replaceAll("[()?:!/.,;{}-]", ""), 14, "0"), "#"); // 14
																														// A

		concat(content, tmscte.getCompanyname(), "#"); // 60 A
		concat(content, tmscte.getOptional19(), "#"); // FedEx
		concat(content, tmscte.getAddressstrt(), "#"); //
		concat(content, tmscte.getAddressno(), "#");
		concat(content, tmscte.getOptional20(), "#"); // op
		concat(content, tmscte.getAddressstrtnbrhd(), "#");
		concat(content, tmscte.getAddressscitycd(), "#");
		concat(content, tmscte.getAddresscity(), "#");
		concat(content, tmscte.getAddressszip(), "#");
		concat(content, tmscte.getAddressstate(), "#");
		concat(content, tmscte.getOptional21(), "#"); // 1 space
		concat(content, tmscte.getDefvalue(), "#"); // 1058
		concat(content, tmscte.getDefvalue1(), "#");
		// rem_
		concat(content, tmscte.getShipperfedextaxid(), "#");
		concat(content, tmscte.getValue(), "#");// J

		concat(content, StringUtils.leftPad(tmscte.getShipperstatetaxid().replaceAll("[()?:!/.,;{}-]", ""), 14, "0"),
				"#");

		concat(content, tmscte.getShippercorpnm(), "#");
		concat(content, tmscte.getOptional20(), "#");
		concat(content, tmscte.getShipperaddrstrtext(), "#");
		concat(content, tmscte.getShipperaddrnbr(), "#");
		concat(content, "          ", "#");
		concat(content, tmscte.getShippernebortxt(), "#");
		concat(content, tmscte.getShippercitycd(), "#");// exchanged
		concat(content, tmscte.getShippercityname(), "#");// exchanged
		concat(content, tmscte.getShipperaddrzipcd(), "#");
		concat(content, tmscte.getShipperabbrtxt(), "#");
		concat(content, tmscte.getOptional2(), "#");
		concat(content, tmscte.getDefvalue(), "#"); // 1058
		concat(content, tmscte.getDefvalue1(), "#"); // Brasil

		// dest_
		if (tmscte.getDestCNPJ() != null) {
			concat(content, tmscte.getDestCNPJ().replaceAll("[()?:!/.,;{}-]", ""), "#");// dest_cnpj
			concat(content, "J", "#"); // CNPJ

			concat(content, tmscte.getRecpstatetaxnbr(), "#");// dest_IE

		} else {

			concat(content, StringUtils.leftPad(tmscte.getRecpCPF().replaceAll("[()?:!/.,;{}-]", ""), 14, "0"), "#"); // dest_cpf
			concat(content, tmscte.getRecpCNPJ(), "#"); // CPf
			concat(content, "ISENTO", "#");

		}
		//
		concat(content, tmscte.getRecpcorpnm(), "#"); //
		concat(content, tmscte.getOptional20(), "#");
		concat(content, tmscte.getRecpaddrstrtxt(), "#"); //
		concat(content, tmscte.getRecpaddrnbr(), "#"); //
		concat(content, tmscte.getOptional20(), "#");
		concat(content, tmscte.getRecpniborhdtxt(), "#");
		concat(content, tmscte.getRecpaddrcd(), "#");// exchanged
		concat(content, tmscte.getRecpcityname(), "#"); // exchanged
		concat(content, tmscte.getRecpAddrZipCd(), "#"); //
		concat(content, tmscte.getRecpaddstabbr(), "#"); //
		concat(content, tmscte.getOptional2(), "#");
		concat(content, tmscte.getDefvalue(), "#"); // 1058

		// optionals
		concat(content, tmscte.getOptional22(), "#"); // 4 spaces
		concat(content, tmscte.getOptional23(), "#"); // 9 zeros
		concat(content, tmscte.getOptional24(), "#"); // 14 zeros
		concat(content, tmscte.getOptional2(), "#"); // 1 spaces
		concat(content, tmscte.getOptional12(), "#"); // 14 spaces
		concat(content, tmscte.getOptional20(), "#"); // 60 spaces
		concat(content, tmscte.getOptional20(), "#"); // 60 spaces
		concat(content, tmscte.getOptional20(), "#"); // 255 spces
		concat(content, tmscte.getOptional26(), "#"); // 10
		concat(content, tmscte.getOptional20(), "#");// 60
		concat(content, tmscte.getOptional20(), "#");// 60
		concat(content, tmscte.getOptional27(), "#");// 9
		concat(content, tmscte.getOptional20(), "#");// 60
		concat(content, tmscte.getOptional28(), "#");// 8
		concat(content, tmscte.getOptional13(), "#");// 2
		concat(content, tmscte.getOptional2(), "#");// 1
		concat(content, tmscte.getOptional29(), "#");// 4
		concat(content, tmscte.getOptional29(), "#");// 4

		// Expec
		concat(content, tmscte.getExpedcnpj(), "#");
		concat(content, tmscte.getValue(), "#"); // CNPJ //added J DEFAULT
		concat(content, tmscte.getExpedstatetaxid(), "#");
		concat(content, tmscte.getExpedcompname(), "#");
		concat(content, tmscte.getOptional19(), "#");
		concat(content, tmscte.getExpedxlgr(), "#");
		concat(content, tmscte.getExpednro(), "#");
		concat(content, tmscte.getExpedaddrress(), "#");
		concat(content, tmscte.getExpednbrhdaddrress(), "#");
		concat(content, tmscte.getExpedcitycode(), "#");
		concat(content, tmscte.getExpedcityname(), "#");
		concat(content, tmscte.getExpedaddrzipcd(), "#");
		concat(content, tmscte.getExpedaddrst(), "#");
		concat(content, tmscte.getOptional31(), "#");
		concat(content, tmscte.getDefvalue(), "#");
		concat(content, tmscte.getDefvalue1(), "#");

		// receb
		concat(content, tmscte.getRecebcnpj(), "#");
		concat(content, tmscte.getValue(), "#"); // CNPJ ADDED J AS DEFAULT
		concat(content, tmscte.getRecebstatetaxid(), "#");
		concat(content, tmscte.getRecebcompname(), "#");
		concat(content, tmscte.getOptional19(), "#");
		concat(content, tmscte.getRecebxlgr(), "#");
		concat(content, tmscte.getRecebnro(), "#");
		concat(content, tmscte.getRecebaddrress(), "#");
		concat(content, tmscte.getRecebnbrhdaddrress(), "#");
		concat(content, tmscte.getRecebcitycode(), "#");
		concat(content, tmscte.getRecebcityname(), "#");
		concat(content, tmscte.getRecebaddrzipcd(), "#");
		concat(content, tmscte.getRexcebaddrst(), "#");
		concat(content, tmscte.getOptional2(), "#");
		concat(content, tmscte.getDefvalue(), "#"); // 1058
		concat(content, tmscte.getDefvalue1(), "#"); // Brasil

		// optionals
		concat(content, tmscte.getOptional24(), "#"); // 14 zeros
		concat(content, tmscte.getOptional2(), "#"); // 1 spaces
		concat(content, tmscte.getOptional12(), "#"); // 14 spaces
		concat(content, tmscte.getOptional20(), "#"); // 60 spaces
		concat(content, tmscte.getOptional20(), "#"); // 60 spaces
		concat(content, tmscte.getOptional20(), "#"); // 255 spces
		concat(content, tmscte.getOptional26(), "#"); // 10
		concat(content, tmscte.getOptional20(), "#");// 60
		concat(content, tmscte.getOptional20(), "#");// 60
		concat(content, tmscte.getOptional27(), "#");// 9
		concat(content, tmscte.getOptional20(), "#");// 60
		concat(content, tmscte.getOptional28(), "#");// 8
		concat(content, tmscte.getOptional13(), "#");// 2
		concat(content, tmscte.getOptional2(), "#");// 1
		concat(content, tmscte.getOptional29(), "#");// 4
		concat(content, tmscte.getOptional20(), "#");// 60
		concat(content, tmscte.getOptional24(), "#"); // 14 zeros
		concat(content, tmscte.getOptional2(), "#"); // 1 spaces
		concat(content, tmscte.getOptional12(), "#"); // 14 spaces
		concat(content, tmscte.getOptional20(), "#"); // 60 spaces
		concat(content, tmscte.getOptional20(), "#"); // 60 spaces
		concat(content, tmscte.getOptional20(), "#"); // 255 spces
		concat(content, tmscte.getOptional26(), "#"); // 10
		concat(content, tmscte.getOptional20(), "#");// 60
		concat(content, tmscte.getOptional20(), "#");// 60
		concat(content, tmscte.getOptional27(), "#");// 9
		concat(content, tmscte.getOptional20(), "#");// 60
		concat(content, tmscte.getOptional28(), "#");// 8
		concat(content, tmscte.getOptional13(), "#");// 2
		concat(content, tmscte.getOptional2(), "#");// 1
		concat(content, tmscte.getOptional29(), "#");// 4
		concat(content, tmscte.getOptional20(), "#");// 60
		concat(content, tmscte.getOptional2(), "#"); // 1 space
		concat(content, tmscte.getOptional6(), "#"); // 6 zeros
		concat(content, tmscte.getDefvalue1(), "#"); // Brrasil
		concat(content, tmscte.getOptional2(), "#"); //// 1 space
		concat(content, tmscte.getOptional2(), "#"); // 1 space
		concat(content, tmscte.getSendzipcode(), "#"); // 172 row
		concat(content, tmscte.getRecpzipcode(), "#"); // 173 row
		concat(content, tmscte.getOptional2(), "#"); // 1
		concat(content, tmscte.getOptional29(), "#");// 4
		concat(content, tmscte.getOptional2(), "#");// 1
		concat(content, tmscte.getOptional3(), "#"); // 2
		concat(content, tmscte.getOptional13(), "#");// 2
		concat(content, tmscte.getOptional13(), "#");// 2
		concat(content, tmscte.getOptional30(), "#"); // 7.4zeros
		concat(content, tmscte.getManualentered(), "#"); // 181
		concat(content, tmscte.getAmtentered(), "#"); // 182

		NumberFormat formatterStringValue = new DecimalFormat("0000");
		double grossValue = Double.parseDouble(tmscte.getGrosswght());
		String grossNumber = formatterStringValue.format(grossValue).replace(".", "");
		concat(content, grossNumber, "#"); // 183

		concat(content, tmscte.getOptional22(), "#"); // 4 spaces
		concat(content, tmscte.getDestStatonidcnpj().replaceAll("[()?:!/.,;{}-]", ""), "#"); // 6.stationid cnpj added
																								// extra field
		content.append("#");

		return content;

	}

	private StringBuilder concat(StringBuilder builder, String value, String token) {
		StringBuilder output = builder;
		value = (value != null && !value.isEmpty() ? value : "0");
		if (output == null) {
			output = new StringBuilder();
		}

		if (output.length() == 0) {
			output.append(value);
		} else {
			output.append(token).append(value);
		}

		return output;

	}
}

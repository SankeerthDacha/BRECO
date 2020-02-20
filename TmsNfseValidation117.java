package com.fedex.breco.insurance.utils;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import com.fedex.breco.insurance.mapper.TmsNfseMapper117;

@Component
public class TmsNfseValidation117 {
	public StringBuilder nfseValidation117(TmsNfseMapper117 tmsNfse, String stationcd) {

		StringBuilder content = new StringBuilder();

		concat(content, "117", "#"); // 1.117
		concat(content, tmsNfse.getInternalServiceCode(), "#");

		concat(content, tmsNfse.getRpsId(), "#");

		if (tmsNfse.getRpsDate() != null) {

			DateTime dateTime = new DateTime(tmsNfse.getRpsDate());

			String ddMMyyyy = "";

			ddMMyyyy = "" + (dateTime.getDayOfMonth() < 10 ? "0" + dateTime.getDayOfMonth() : dateTime.getDayOfMonth())
					+ String.valueOf(dateTime.getMonthOfYear() < 10 ? "0" + dateTime.getMonthOfYear()
							: dateTime.getMonthOfYear())
					+ (String.valueOf(dateTime.getYear()));

			concat(content, ddMMyyyy, "#");
		} else {
			concat(content, tmsNfse.getOptional15(), "#");
		}

		String replaceCargo = tmsNfse.getQcarga().replace(".", "");
		String with6digits = String.format("%06d", Integer.parseInt(replaceCargo));
		concat(content, with6digits, "#");

		concat(content, tmsNfse.getStationidcnpj().replaceAll("[()?:!/.,;{}-]", ""), "#"); // 6.stationid cnpj
		concat(content, tmsNfse.getModal(), "#"); // 7.modal
		concat(content, tmsNfse.getOptional18(), "#"); // 8.1 space
		concat(content, tmsNfse.getMod(), "#"); // 9.mod
		concat(content, StringUtils.leftPad(tmsNfse.getNfseType(), 2, "0"), "#");
		// concat(content, tmsNfse.getNfseType(), "#");
		concat(content, tmsNfse.getOptional1(), "#"); // NfseCode-44digit
		concat(content, tmsNfse.getOptional2(), "#"); // 2zero
		concat(content, tmsNfse.getOptional3(), "#"); // 15space
		concat(content, tmsNfse.getOptional4(), "#"); // 5space
		concat(content, tmsNfse.getServicetype(), "#"); // 3Zeroes always

		concat(content, tmsNfse.getPayer(), "#"); // 3Zeroes always

		concat(content, tmsNfse.getCfop(), "#"); // 3Zeroes always
		concat(content, tmsNfse.getOptional5(), "#"); // 6zeros
		concat(content, tmsNfse.getOptional6(), "#"); // 13zeros
		concat(content, tmsNfse.getOptional7(), "#"); // 5zeros
		concat(content, tmsNfse.getTax(), "#"); // cst tag
		concat(content, tmsNfse.getOptional7(), "#"); // 5zeros
		concat(content, tmsNfse.getOptional6(), "#"); // 13zeros
		concat(content, tmsNfse.getOptional6(), "#"); // 13zeros
		concat(content, tmsNfse.getMandatory(), "#"); // 1Zero
		concat(content, tmsNfse.getOptional2(), "#"); // 2zeros
		concat(content, tmsNfse.getOptional8(), "#"); // 14zeros
		concat(content, tmsNfse.getOptional9(), "#"); // 14space
		concat(content, tmsNfse.getOptional10(), "#"); // 2space
		concat(content, tmsNfse.getOptional11(), "#"); // 40space
		concat(content, tmsNfse.getOptional12(), "#"); // 3space
		concat(content, tmsNfse.getOptional13(), "#"); // 4space
		concat(content, tmsNfse.getOptional14(), "#"); // 20space
		concat(content, tmsNfse.getOptional15(), "#"); // 8zeros
		concat(content, tmsNfse.getObservations(), "#"); // xobs

		// Emit_
		concat(content, tmsNfse.getFedextaxid(), "#"); // 14 N
		concat(content, StringUtils.leftPad(tmsNfse.getStatetaxid().replaceAll("[()?:!/.,;{}-]", ""), 14, "0"), "#");
		// concat(content, tmsNfse.getStatetaxid(), "#"); // 14 A
		concat(content, tmsNfse.getCompanyname(), "#"); // 60 A
		concat(content, tmsNfse.getOptional22(), "#"); // FedEx
		concat(content, tmsNfse.getAddressstrt(), "#"); //
		concat(content, tmsNfse.getAddressno(), "#");// .
		concat(content, tmsNfse.getOptional17(), "#"); // 60space
		concat(content, tmsNfse.getAddressstrtnbrhd(), "#");// levi
		concat(content, tmsNfse.getAddressscitycd(), "#");// 000
		concat(content, tmsNfse.getAddresscity(), "#");// 150
		concat(content, tmsNfse.getAddressszip(), "#");// 673
		concat(content, tmsNfse.getAddressstate(), "#");// pa
		concat(content, tmsNfse.getOptional18(), "#"); // 1space
		concat(content, tmsNfse.getDefvalue(), "#"); // 1058
		concat(content, tmsNfse.getDefvalue1(), "#");// Brasil

		// rem_

		if (tmsNfse.getShipperfedextaxid() != null) {
			String value = tmsNfse.getShipperfedextaxid().replaceAll("[()?:!/.,;{}-]", "");
			concat(content, value, "#"); // NEED to remove special characters
			concat(content, tmsNfse.getValue(), "#");// J
		} else {

			String value = tmsNfse.getShipperfdxSocIdentyNum().replaceAll("[()?:!/.,;{}-]", "");
			concat(content, value, "#"); // NEED to remove special characters
			concat(content, tmsNfse.getValue1(), "#"); // CPf

		}

		concat(content, StringUtils.leftPad(tmsNfse.getShipperstatetaxid().replaceAll("[()?:!/.,;{}-]", ""), 14, "0"),
				"#");
		// concat(content, tmsNfse.getShipperstatetaxid(), "#");
		concat(content, tmsNfse.getShippercorpnm(), "#");
		concat(content, tmsNfse.getOptional17(), "#"); // 60space
		concat(content, tmsNfse.getShipperaddrstrtext(), "#");
		concat(content, tmsNfse.getShipperaddrnbr(), "#");
		concat(content, tmsNfse.getOptional17(), "#"); // 60space
		concat(content, tmsNfse.getShippernebortxt(), "#");
		concat(content, tmsNfse.getShippercitycd(), "#");
		concat(content, tmsNfse.getShippercityname(), "#");
		concat(content, tmsNfse.getShipperaddrzipcd(), "#");
		concat(content, tmsNfse.getShipperabbrtxt(), "#");
		concat(content, tmsNfse.getOptional18(), "#"); // 1space
		concat(content, tmsNfse.getDefvalue(), "#"); // 1058
		concat(content, tmsNfse.getDefvalue1(), "#");// Brasil

		// dest_
		if (tmsNfse.getDestcnpj() != null) {
			concat(content, tmsNfse.getDestcnpj().replaceAll("[()?:!/.,;{}-]", ""), "#");// dest_cnpj
			concat(content, "J", "#"); // CNPJ
			concat(content, tmsNfse.getDeststatetaxnbr(), "#");
		} else {
			concat(content, StringUtils.leftPad(tmsNfse.getDestcpf().replaceAll("[()?:!/.,;{}-]", ""), 14, "0"), "#"); // dest_cpf
			concat(content, tmsNfse.getValue1(), "#"); // CPf
			concat(content, "ISENTO", "#"); // CPf

		}

		/*
		 * String valueId = tmsNfse.getDestfedtaxidnbr().replaceAll("[()?:!/.,;{}-]",
		 * ""); concat(content, valueId, "#"); // NEED to remove special characters
		 */

		// concat(content, tmsNfse.getDestcpf(), "#"); //

		// concat(content, tmsNfse.getDeststatetaxnbr(), "#"); //
		concat(content, tmsNfse.getDestcorpnm(), "#"); //
		concat(content, tmsNfse.getOptional17(), "#"); // 60space
		concat(content, tmsNfse.getDestaddrstrtxt(), "#"); //
		concat(content, tmsNfse.getDestaddrnbr(), "#"); //
		concat(content, tmsNfse.getOptional17(), "#"); // 60space
		concat(content, tmsNfse.getDestniborhdtxt(), "#");
		concat(content, tmsNfse.getDestaddrcd(), "#");
		concat(content, tmsNfse.getDestcityname(), "#");
		concat(content, tmsNfse.getDestaddrzipcd(), "#");
		concat(content, tmsNfse.getDestaddstabbr(), "#");
		concat(content, tmsNfse.getOptional18(), "#"); // 1space
		concat(content, tmsNfse.getDefvalue(), "#"); // 1058

		// optionals
		concat(content, tmsNfse.getOptional16(), "#"); // 4zeros
		concat(content, tmsNfse.getOptional19(), "#"); // 9zeros
		concat(content, tmsNfse.getOptional8(), "#"); // 14zeros
		concat(content, tmsNfse.getOptional18(), "#"); // 1space
		concat(content, tmsNfse.getOptional9(), "#"); // 14space
		concat(content, tmsNfse.getOptional17(), "#"); // 60space
		concat(content, tmsNfse.getOptional17(), "#"); // 60space
		concat(content, tmsNfse.getOptional17(), "#"); // 60space
		concat(content, tmsNfse.getOptional20(), "#"); // 10space
		concat(content, tmsNfse.getOptional17(), "#"); // 60space
		concat(content, tmsNfse.getOptional17(), "#"); // 60space
		concat(content, tmsNfse.getOptional19(), "#"); // 9zeros
		concat(content, tmsNfse.getOptional17(), "#"); // 60space
		concat(content, tmsNfse.getOptional15(), "#"); // 8zeros
		concat(content, tmsNfse.getOptional10(), "#"); // 2space
		concat(content, tmsNfse.getOptional18(), "#"); // 1space
		concat(content, tmsNfse.getOptional16(), "#"); // 4zeros
		concat(content, tmsNfse.getOptional16(), "#"); // 4zeros

		// Expec
		concat(content, tmsNfse.getExpedcnpj(), "#");
		concat(content, tmsNfse.getValue(), "#");// J
		concat(content, tmsNfse.getExpedstatetaxid(), "#");
		concat(content, tmsNfse.getExpedcompname(), "#");
		concat(content, tmsNfse.getOptional22(), "#");// FedEx
		concat(content, tmsNfse.getExpedxlgr(), "#");
		concat(content, tmsNfse.getExpednro(), "#");
		concat(content, tmsNfse.getExpedaddrress(), "#");
		concat(content, tmsNfse.getExpednbrhdaddrress(), "#");
		concat(content, tmsNfse.getExpedcitycode(), "#");
		concat(content, tmsNfse.getExpedcityname(), "#");
		concat(content, tmsNfse.getExpedaddrzipcd(), "#");
		concat(content, tmsNfse.getExpedaddrst(), "#");
		concat(content, tmsNfse.getOptional23(), "#"); // row116, always 0
		concat(content, tmsNfse.getDefvalue(), "#");
		concat(content, tmsNfse.getDefvalue1(), "#");

		// receb
		concat(content, tmsNfse.getRecebcnpj(), "#");
		concat(content, tmsNfse.getValue(), "#");// J
		concat(content, tmsNfse.getRecebstatetaxid(), "#");
		concat(content, tmsNfse.getRecebcompname(), "#");
		concat(content, tmsNfse.getOptional22(), "#");
		concat(content, tmsNfse.getRecebxlgr(), "#");
		concat(content, tmsNfse.getRecebnro(), "#");
		concat(content, tmsNfse.getRecebaddrress(), "#");
		concat(content, tmsNfse.getRecebnbrhdaddrress(), "#");
		concat(content, tmsNfse.getRecebcitycode(), "#");
		concat(content, tmsNfse.getRecebcityname(), "#");
		concat(content, tmsNfse.getRecebaddrzipcd(), "#");
		concat(content, tmsNfse.getRexcebaddrst(), "#");
		concat(content, tmsNfse.getOptional23(), "#"); // row116, always 0
		concat(content, tmsNfse.getDefvalue(), "#"); // 1058
		concat(content, tmsNfse.getDefvalue1(), "#"); // Brasil

		// optionals
		concat(content, tmsNfse.getOptional8(), "#"); // 14zeros
		concat(content, tmsNfse.getOptional18(), "#"); // 1space
		concat(content, tmsNfse.getOptional9(), "#"); // 14 spaces
		concat(content, tmsNfse.getOptional17(), "#"); // 60space
		concat(content, tmsNfse.getOptional17(), "#"); // 60space
		concat(content, tmsNfse.getOptional17(), "#"); // 60space
		concat(content, tmsNfse.getOptional20(), "#"); // 10space
		concat(content, tmsNfse.getOptional20(), "#"); // 60 spaces
		concat(content, tmsNfse.getOptional20(), "#"); // 60 spaces
		concat(content, tmsNfse.getOptional19(), "#"); // 9zeros
		concat(content, tmsNfse.getOptional17(), "#"); // 60space
		concat(content, tmsNfse.getOptional15(), "#"); // 8zeros
		concat(content, tmsNfse.getOptional10(), "#"); // 2space
		concat(content, tmsNfse.getOptional18(), "#"); // 1space
		concat(content, tmsNfse.getOptional16(), "#"); // 4zeros
		concat(content, tmsNfse.getOptional20(), "#"); // 60 spaces
		concat(content, tmsNfse.getOptional8(), "#"); // 14zeros
		concat(content, tmsNfse.getOptional18(), "#"); // 1space
		concat(content, tmsNfse.getOptional9(), "#"); // 14 spaces
		concat(content, tmsNfse.getOptional17(), "#"); // 60space
		concat(content, tmsNfse.getOptional17(), "#"); // 60space
		concat(content, tmsNfse.getOptional17(), "#"); // 60space
		concat(content, tmsNfse.getOptional20(), "#"); // 10space
		concat(content, tmsNfse.getOptional20(), "#"); // 60 spaces
		concat(content, tmsNfse.getOptional20(), "#"); // 60 spaces
		concat(content, tmsNfse.getOptional19(), "#"); // 9zeros
		concat(content, tmsNfse.getOptional17(), "#"); // 60space
		concat(content, tmsNfse.getOptional15(), "#"); // 8zeros
		concat(content, tmsNfse.getOptional10(), "#"); // 2space
		concat(content, tmsNfse.getOptional18(), "#"); // 1space
		concat(content, tmsNfse.getOptional16(), "#"); // 4zeros
		concat(content, tmsNfse.getOptional20(), "#"); // 60 spaces
		concat(content, tmsNfse.getOptional18(), "#"); // 1space
		concat(content, tmsNfse.getOptional5(), "#"); // 6zero

		concat(content, tmsNfse.getDefvalue1(), "#"); // Brasil

		concat(content, tmsNfse.getOptional18(), "#"); // 1space
		concat(content, tmsNfse.getOptional18(), "#"); // 1space

		concat(content, tmsNfse.getSendzipcode(), "#"); // 172 row
		concat(content, tmsNfse.getRecpzipcode(), "#"); // 173 row

		concat(content, tmsNfse.getOptional18(), "#"); // 1space
		concat(content, tmsNfse.getOptional16(), "#"); // 4zeros
		concat(content, tmsNfse.getOptional18(), "#"); // 1space
		concat(content, tmsNfse.getOptional2(), "#"); // 2zero
		concat(content, tmsNfse.getOptional10(), "#"); // 2space
		concat(content, tmsNfse.getOptional10(), "#"); // 2space
		concat(content, tmsNfse.getOptional21(), "#"); // 7zero

		concat(content, tmsNfse.getManualentered(), "#"); // row 181
		concat(content, tmsNfse.getAmtentered(), "#"); // 182
		concat(content, tmsNfse.getGrosswght(), "#"); // 183
		concat(content, tmsNfse.getOptional13(), "#"); // 4space

		concat(content, tmsNfse.getDestinationCnpj().replaceAll("[()?:!/.,;{}-]", ""), "#"); // 6. dest stationid cnpj

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

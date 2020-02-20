package com.fedex.breco.insurance.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import com.fedex.breco.insurance.mapper.TmsCteComplimentMapper;

@Component
public class TmsCteComplimentValidation {
	public StringBuilder cteComplimentValidation(TmsCteComplimentMapper tmscte) {

		StringBuilder content = new StringBuilder();

		concat(content, "103", "#");
		if (tmscte.getCteIssueDate() != null) {// YYYYMMDD

			DateTime dateTime = new DateTime(tmscte.getCteIssueDate());

			String yyyymmdd = "";
			yyyymmdd = "" + (String.valueOf(dateTime.getYear())
					+ String.valueOf(dateTime.getMonthOfYear() < 10 ? "0" + dateTime.getMonthOfYear()
							: dateTime.getMonthOfYear())
					+ (dateTime.getDayOfMonth() < 10 ? "0" + dateTime.getDayOfMonth() : dateTime.getDayOfMonth()));

			concat(content, yyyymmdd, "#");
		} else {
			concat(content, tmscte.getOptional3(), "#");// 08 zeros
		}

		concat(content, String.valueOf(tmscte.getCteNbr()), "#");

		NumberFormat formatterStringGross = new DecimalFormat("000000000.00");
		double grossTotValue = Double.parseDouble(tmscte.getGrossWt());
		String gorssNumber = formatterStringGross.format(grossTotValue).replace(".", "");
		concat(content, gorssNumber, "#");

		concat(content, tmscte.getOptional26(), "#"); // 11 zeros//changed

		concat(content, tmscte.getOptional27(), "#"); // 9 zeros
		concat(content, tmscte.getOptional27(), "#"); // 9 zeros
		concat(content, tmscte.getOptional28(), "#"); // 6 zeros
		concat(content, tmscte.getOptional27(), "#"); // 9 zeros
		concat(content, tmscte.getOptional28(), "#"); // 6 zeros
		concat(content, tmscte.getOptional27(), "#"); // 9 zeros

		NumberFormat formatterStringBaseValue = new DecimalFormat("000000000.00");
		double BaseValue = Double.parseDouble(tmscte.getBaseValue());
		String baseVal = formatterStringBaseValue.format(BaseValue).replace(".", "");
		concat(content, baseVal, "#");

		NumberFormat formatterStringStateTaxValueNumber = new DecimalFormat("000000000.00");
		double StateTaxValueNumber = Double.parseDouble(tmscte.getStateTaxValueNumber());
		String taxVal = formatterStringStateTaxValueNumber.format(StateTaxValueNumber).replace(".", "");
		concat(content, taxVal, "#");

		concat(content, tmscte.getOptional17(), "#");

		concat(content, tmscte.getOptional10(), "#"); // 18 changed (branch orgin)

		concat(content, tmscte.getOptional10(), "#"); // 19 changed (dest orgin) 16
		// 18&19

		concat(content, tmscte.getOptional5(), "#"); // 04 zeros //Row 20

		concat(content, tmscte.getOptional6(), "#"); // 02 zeros //Row 21

		if (tmscte.getPayerDetails().equals("0")) { // Row 22 -- 0-shipper , else - dest

			if (tmscte.getTaxId() != null) {
				concat(content, tmscte.getTaxId(), "#"); // dest_cnpj
				concat(content, tmscte.getRecipientStateTaxNumber(), "#"); // destIE
			} else {
				concat(content,
						StringUtils.leftPad(
								tmscte.getRecipientFedexTaxIdentitySocialNumber().replaceAll("[()?:!/.,;{}-]", ""), 14,
								"0"),
						"#"); // destcpf
				concat(content, tmscte.getRecipientStateTaxNumber(), "#"); // destIe

			}

		} else {

			concat(content, tmscte.getShipperTaxIdNumber(), "#"); // rem_cnpj
			concat(content, tmscte.getShipperStateTaxNumber(), "#");// rem_IE
		}
		concat(content, tmscte.getOptional8(), "#"); // 24 IEST FLAG= N

		if (tmscte.getCteIssueDate() != null) { // HHMM

			DateTime dateTime = new DateTime(tmscte.getCteIssueDate());
			String time = String
					.valueOf(dateTime.getHourOfDay() < 10 ? "0" + dateTime.getHourOfDay() : dateTime.getHourOfDay())
					+ (String.valueOf(dateTime.getMinuteOfHour() < 10 ? "0" + dateTime.getMinuteOfHour()
							: dateTime.getMinuteOfHour()));

			concat(content, time, "#");
		} else {
			concat(content, tmscte.getOptional5(), "#");

		}
		// 26,27
		concat(content, tmscte.getOptional18(), "#"); // BOX always
		concat(content, tmscte.getOptional19(), "#"); // DIVERSO always

		concat(content, tmscte.getRecipientStateName(), "#");

		concat(content, "00", "#"); // 29 2zeros
		concat(content, "1", "#");// changed to always 1

		concat(content, tmscte.getOptional27(), "#"); // 9 zeros//changed
		concat(content, tmscte.getOptional27(), "#"); // 9 zeros//changed

		concat(content, tmscte.getOptional29(), "#"); // 7 zeros//changed
		concat(content, tmscte.getOptional10(), "#"); // 05 zeros 34
		concat(content, tmscte.getOptional3(), "#"); // 08 zeros 35
		concat(content, tmscte.getOptional5(), "#"); // 04 zeros 36
		concat(content, tmscte.getOptional3(), "#"); // 08 zeros 37

		// 34-37
		concat(content, tmscte.getOptional8(), "#"); // N always
		// 39 CNPJ newly added
		if (tmscte.getPayerDetails().equals("0")) {
			concat(content, tmscte.getShipperTaxIdNumber(), "#"); // rem_cnpj
		} else if (tmscte.getPayerDetails().equals("1")) {
			concat(content, tmscte.getTaxId(), "#"); // dest_cnpj
		} else {
			concat(content, tmscte.getTaxId(), "#"); // dest_cnpj
		}
		concat(content, tmscte.getOptional14(), "#"); // 40 03 zeros

		concat(content, tmscte.getOptional6(), "#"); // 02 zeros
		concat(content, tmscte.getOptional28(), "#"); // 6 zeros
		concat(content, tmscte.getOptional9(), "#"); // 01 zero
		concat(content, "N", "#");
		concat(content, tmscte.getOptional29(), "#"); // 7 zeros//changed
		concat(content, tmscte.getOptional10(), "#"); // 05 zeros
		concat(content, tmscte.getOptional10(), "#"); // 05 zeros
		concat(content, tmscte.getOptional11(), "#"); // 01 space
		concat(content, tmscte.getOptional29(), "#"); // 7 zeros//changed
		// 50 TOMA

		if (tmscte.getTaxId() != null) {

			concat(content, "J", "#"); // cnpj
		} else {
			concat(content, "F", "#"); // cpf
		}

		concat(content, tmscte.getOptional16(), "#"); // 1space
		concat(content, tmscte.getOptional28(), "#"); // 06 zeros
		concat(content, tmscte.getOptional28(), "#"); // 06 zeros
		concat(content, tmscte.getOptional28(), "#"); // 06 zeros
		concat(content, tmscte.getOptional28(), "#"); // 06 zeros
		concat(content, tmscte.getOptional28(), "#"); // 06 zeros
		concat(content, tmscte.getOptional30(), "#"); // 05 zeros
		concat(content, tmscte.getOptional11(), "#"); // 01 space
		concat(content, tmscte.getOptional11(), "#"); // 01 space
		concat(content, tmscte.getOptional11(), "#"); // 01 space
		concat(content, tmscte.getOptional11(), "#"); // 01 space
		concat(content, tmscte.getOptional11(), "#"); // 01 space
		concat(content, tmscte.getOptional11(), "#"); // 01 space
		concat(content, tmscte.getOptional11(), "#"); // 01 space
		concat(content, tmscte.getOptional11(), "#"); // 01 space
		// 66//nfe
		String nfeCount = String.format("%03d", Integer.parseInt(tmscte.getCountNfe()));
		concat(content, nfeCount, "#"); // 03 zeros

		concat(content, tmscte.getOptional26(), "#"); // 11 zeros//changed
		concat(content, tmscte.getOptional5(), "#"); // 04 zeros
		concat(content, tmscte.getOptional29(), "#"); // 07 zeros//changed
		concat(content, tmscte.getOptional29(), "#"); // 07 zeros//changed
		concat(content, tmscte.getOptional13(), "#"); // 15 spaces
		concat(content, tmscte.getOptional13(), "#"); // 15 spaces
		concat(content, tmscte.getOptional13(), "#"); // 15 spaces
		concat(content, tmscte.getOptional13(), "#"); // 15 spaces
		concat(content, tmscte.getOptional13(), "#"); // 15 spaces
		concat(content, tmscte.getOptional13(), "#"); // 15 spaces
		concat(content, tmscte.getOptional14(), "#"); // 03 zeros

		NumberFormat formatterString = new DecimalFormat("000000000.00");
		double grossValue = Double.parseDouble(tmscte.getGrossWt());
		String number = formatterString.format(grossValue).replace(".", "");
		concat(content, number, "#"); // 16

		String TaxRate = tmscte.getStateTaxRate().replace(".", "");
		String with04digits = String.format("%04d", Integer.parseInt(TaxRate));
		concat(content, with04digits, "#");

		NumberFormat formatterStringStateTaxValueNbr = new DecimalFormat("000000000.00");
		double TaxValue = Double.parseDouble(tmscte.getStateTaxValueNumber());
		String taxValue = formatterStringStateTaxValueNbr.format(TaxValue).replace(".", "");
		concat(content, taxValue, "#");

		concat(content, tmscte.getOptional11(), "#"); // 01 space
		concat(content, tmscte.getOptional11(), "#"); // 01 space
		concat(content, tmscte.getOptional11(), "#"); // 01 space
		concat(content, tmscte.getOptional6(), "#"); // 02 zeros
		concat(content, tmscte.getOptional14(), "#"); // 03 zeros
		concat(content, tmscte.getOptional31(), "#"); // 8 zeros
		concat(content, tmscte.getOptional27(), "#"); // 9 zeros
		concat(content, tmscte.getOptional29(), "#"); // 07 zeros
		concat(content, tmscte.getOptional29(), "#"); // 07 zeros
		concat(content, tmscte.getOptional29(), "#"); // 07 zeros
		concat(content, tmscte.getOptional29(), "#"); // 07 zeros
		concat(content, tmscte.getOptional29(), "#"); // 07 zeros
		concat(content, tmscte.getShipperAddressZipcode(), "#");
		concat(content, tmscte.getRecipientAddressZipcode(), "#");
		concat(content, tmscte.getAwbNum(), "#");
		concat(content, tmscte.getOptional11(), "#"); // 01 space
		concat(content, tmscte.getAwbNum(), "#");
		concat(content, tmscte.getOperationsFiscalCode(), "#");
		concat(content, tmscte.getOptional25(), "#"); // 09 spaces//changed
		concat(content, tmscte.getOptional29(), "#"); // 7 zeros

		content.append("#");

		return content;

	}

	private StringBuilder concat(StringBuilder builder, String value, String token) {
		StringBuilder output = builder;
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

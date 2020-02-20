package com.fedex.breco.insurance.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import com.fedex.breco.insurance.mapper.TmsNfseComplimentMapper;

@Component
public class TmsNfseComplimentValidation {
	public StringBuilder nfseComplimentValidation(TmsNfseComplimentMapper tmsNfse) {

		StringBuilder content = new StringBuilder();

		concat(content, "103", "#");

		if (tmsNfse.getIssueDateOfRPS() != null) {// YYYYMMDD

			DateTime dateTime = new DateTime(tmsNfse.getIssueDateOfRPS());

			String yyyymmdd = "";
			yyyymmdd = "" + (String.valueOf(dateTime.getYear())
					+ String.valueOf(dateTime.getMonthOfYear() < 10 ? "0" + dateTime.getMonthOfYear()
							: dateTime.getMonthOfYear())
					+ (dateTime.getDayOfMonth() < 10 ? "0" + dateTime.getDayOfMonth() : dateTime.getDayOfMonth()));

			concat(content, yyyymmdd, "#");
		} else {
			concat(content, tmsNfse.getOptional3(), "#");// 08 zeros }
		}

		concat(content, String.valueOf(tmsNfse.getRpsId()), "#");

		NumberFormat formatterStringGrossWgt = new DecimalFormat("000000000.00");
		double grossWgt = Double.parseDouble(tmsNfse.getGrossWt() != null ? tmsNfse.getGrossWt() : "00000000000");
		String gorssNbr = formatterStringGrossWgt.format(grossWgt).replace(".", "");
		concat(content, gorssNbr, "#");

		concat(content, tmsNfse.getOptional1(), "#"); // 11 zeros
		concat(content, tmsNfse.getOptional2(), "#"); // 9 zeros
		concat(content, tmsNfse.getOptional2(), "#"); // 9 zeros
		concat(content, tmsNfse.getOptional14(), "#"); // 6 zeros
		concat(content, tmsNfse.getOptional2(), "#"); // 9 zeros
		concat(content, tmsNfse.getOptional14(), "#"); // 6 zeros
		concat(content, tmsNfse.getOptional2(), "#"); // 9 zeros

		NumberFormat formatterStringBaseValue = new DecimalFormat("000000000.00");
		double BaseValue = Double.parseDouble(tmsNfse.getBaseValue());
		String baseVal = formatterStringBaseValue.format(BaseValue).replace(".", "");
		concat(content, baseVal, "#");

		NumberFormat formatterStringTaxValueNumber = new DecimalFormat("000000000.00");
		double TaxValueNumber = Double
				.parseDouble(tmsNfse.getTaxValueNumber() != null ? tmsNfse.getTaxValueNumber() : "00000000000");
		String taxVal = formatterStringTaxValueNumber.format(TaxValueNumber).replace(".", "");
		concat(content, taxVal, "#");

		concat(content, tmsNfse.getOptional11(), "#"); // 02 spaces

		concat(content, tmsNfse.getOptional5(), "#"); // 18 stid+seq (branch orgin)
		concat(content, tmsNfse.getOptional5(), "#"); // 19 stid+seq (dest orgin)
		// 18&19
		concat(content, tmsNfse.getOptional6(), "#"); // 04 zeros //Row 20
		concat(content, tmsNfse.getOptional8(), "#"); // 02 zeros //Row 21

		if (tmsNfse.getPayer().equals("C")) { // Row 22

			String value = tmsNfse.getReceiverCnpj().replaceAll("[()?:!/.,;{}-]", "");
			concat(content, value, "#"); // Special Characters
		} else {
			String valueShipper = tmsNfse.getShipperCnpj().replaceAll("[()?:!/.,;{}-]", "");
			concat(content, valueShipper, "#");
		}

		if (tmsNfse.getPayer().equals("C")) { // Row 23
			concat(content, StringUtils.leftPad(tmsNfse.getReceiverIe().replaceAll("[()?:!/.,;{}-]", ""), 14, "0"),
					"#");
			// concat(content, tmsNfse.getReceiverIe(), "#");
		} else {
			concat(content, StringUtils.leftPad(tmsNfse.getShipperIe().replaceAll("[()?:!/.,;{}-]", ""), 14, "0"), "#");
			// concat(content, tmsNfse.getShipperIe(), "#");
		}

		concat(content, tmsNfse.getIestFlag(), "#");

		if (tmsNfse.getIssueDateOfRPS() != null) { // HHMM

			DateTime dateTime = new DateTime(tmsNfse.getIssueDateOfRPS());
			String time = String
					.valueOf(dateTime.getHourOfDay() < 10 ? "0" + dateTime.getHourOfDay() : dateTime.getHourOfDay())
					+ (String.valueOf(dateTime.getMinuteOfHour() < 10 ? "0" + dateTime.getMinuteOfHour()
							: dateTime.getMinuteOfHour()));

			concat(content, time, "#");
		} else {
			concat(content, tmsNfse.getOptional5(), "#");

		}

		// 26,27
		concat(content, tmsNfse.getDefaultValue(), "#"); // BOX always
		concat(content, tmsNfse.getDefaultValue1(), "#"); // DIVERSO always

		concat(content, tmsNfse.getDestinationState(), "#");

		concat(content, "00", "#"); // 29
		concat(content, tmsNfse.getTpRps(), "#");

		concat(content, tmsNfse.getOptional2(), "#"); // 9 zeros
		concat(content, tmsNfse.getOptional2(), "#"); // 9 zeros

		concat(content, tmsNfse.getOptional4(), "#"); // 7 zeros
		concat(content, tmsNfse.getOptional5(), "#"); // 05 zeros 34
		concat(content, tmsNfse.getOptional3(), "#"); // 08 zeros 35
		concat(content, tmsNfse.getOptional6(), "#"); // 04 zeros 36
		concat(content, tmsNfse.getOptional3(), "#"); // 08 zeros 37

		concat(content, tmsNfse.getDefaultValue3(), "#"); // N always
		// 39 CNPJ

		if (tmsNfse.getPayer().equals("0")) { // 0- shipper - shipper tax
			String valueShipper = tmsNfse.getShipperCnpj().replaceAll("[()?:!/.,;{}-]", "");
			concat(content, valueShipper, "#"); // Special chars

		} else {

			String valueReceiver = tmsNfse.getReceiverCnpj().replaceAll("[()?:!/.,;{}-]", "");
			concat(content, valueReceiver, "#"); // Special chars
		}

		concat(content, tmsNfse.getOptional7(), "#"); // 40 03 zeros

		concat(content, tmsNfse.getOptional8(), "#"); // 02 zeros
		concat(content, tmsNfse.getOptional14(), "#"); // 6 zeros
		concat(content, tmsNfse.getOptional9(), "#"); // 01 zero

		concat(content, tmsNfse.getIestFlag(), "#"); // s|n

		concat(content, tmsNfse.getOptional4(), "#"); // 07 zeros
		concat(content, tmsNfse.getOptional5(), "#"); // 05 zeros
		concat(content, tmsNfse.getOptional5(), "#"); // 05 zeros
		concat(content, tmsNfse.getOptional10(), "#"); // 01 space
		concat(content, tmsNfse.getOptional4(), "#"); // 7 zeros
		// 50 TOMA

		if (tmsNfse.getReceiverCnpj() != null) {

			concat(content, "J", "#"); //
		} else {
			concat(content, "F", "#"); // 0 -SHIPPER
		}

		concat(content, tmsNfse.getOptional10(), "#"); // 1space
		concat(content, tmsNfse.getOptional14(), "#"); // 06 zeros
		concat(content, tmsNfse.getOptional14(), "#"); // 06 zeros
		concat(content, tmsNfse.getOptional14(), "#"); // 06 zeros
		concat(content, tmsNfse.getOptional14(), "#"); // 06 zeros
		concat(content, tmsNfse.getOptional14(), "#"); // 06 zeros
		concat(content, tmsNfse.getOptional5(), "#"); // 5 zeros
		concat(content, tmsNfse.getOptional10(), "#"); // 01 space
		concat(content, tmsNfse.getOptional10(), "#"); // 01 space
		concat(content, tmsNfse.getOptional10(), "#"); // 01 space
		concat(content, tmsNfse.getOptional10(), "#"); // 01 space
		concat(content, tmsNfse.getOptional10(), "#"); // 01 space
		concat(content, tmsNfse.getOptional10(), "#"); // 01 space
		concat(content, tmsNfse.getOptional10(), "#"); // 01 space
		concat(content, tmsNfse.getOptional10(), "#"); // 01 space
		// 66
		String nfeCount = String.format("%03d", Integer.parseInt(tmsNfse.getCountNfe()));
		concat(content, nfeCount, "#"); // 03 zeros

		concat(content, tmsNfse.getOptional1(), "#"); // 11 zeros
		concat(content, tmsNfse.getOptional6(), "#"); // 04 zeros
		concat(content, tmsNfse.getOptional4(), "#"); // 07 zeros
		concat(content, tmsNfse.getOptional4(), "#"); // 07 zeros
		concat(content, tmsNfse.getOptional12(), "#"); // 15 spaces
		concat(content, tmsNfse.getOptional12(), "#"); // 15 spaces
		concat(content, tmsNfse.getOptional12(), "#"); // 15 spaces
		concat(content, tmsNfse.getOptional12(), "#"); // 15 spaces
		concat(content, tmsNfse.getOptional12(), "#"); // 15 spaces
		concat(content, tmsNfse.getOptional12(), "#"); // 15 spaces
		concat(content, tmsNfse.getOptional7(), "#"); // 03 zeros

		NumberFormat formatterStringGross = new DecimalFormat("000000000.00");
		double grossTotValue = Double.parseDouble(tmsNfse.getGrossWt() != null ? tmsNfse.getGrossWt() : "00000000000");
		String gorssNumber = formatterStringGross.format(grossTotValue).replace(".", "");
		concat(content, gorssNumber, "#");

		String TaxRate = tmsNfse.getTaxRate().replace(".", "");
		String with04digits = String.format("%04d", Integer.parseInt(TaxRate));
		concat(content, with04digits, "#");

		NumberFormat formatterStringTaxValue = new DecimalFormat("000000000.00");
		double TaxValue = Double.parseDouble(tmsNfse.getTaxValue() != null ? tmsNfse.getTaxValue() : "00000000000");
		String taxValue = formatterStringTaxValue.format(TaxValue).replace(".", "");
		concat(content, taxValue, "#");

		concat(content, tmsNfse.getOptional10(), "#"); // 01 space
		concat(content, tmsNfse.getOptional10(), "#"); // 01 space
		concat(content, tmsNfse.getOptional10(), "#"); // 01 space
		concat(content, tmsNfse.getOptional8(), "#"); // 02 zeros
		concat(content, tmsNfse.getOptional7(), "#"); // 03 zeros
		concat(content, tmsNfse.getOptional3(), "#"); // 8 zeros
		concat(content, tmsNfse.getOptional2(), "#"); // 9zeros
		concat(content, tmsNfse.getOptional4(), "#"); // 07 zeros
		concat(content, tmsNfse.getOptional4(), "#"); // 07 zeros
		concat(content, tmsNfse.getOptional4(), "#"); // 07 zeros
		concat(content, tmsNfse.getOptional4(), "#"); // 07 zeros
		concat(content, tmsNfse.getOptional4(), "#"); // 07 zeros
		concat(content, tmsNfse.getSenderZipCode(), "#");
		concat(content, tmsNfse.getRecipientZipCode(), "#"); // 94
		concat(content, tmsNfse.getAwbNbr(), "#");
		concat(content, tmsNfse.getOptional10(), "#"); // 01 space
		concat(content, tmsNfse.getAwbNbr(), "#");
		concat(content, tmsNfse.getCfop(), "#");
		concat(content, tmsNfse.getOptional16(), "#"); // 09 spaces
		concat(content, tmsNfse.getOptional4(), "#"); // 07 zeros

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
package com.fedex.breco.insurance.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import com.fedex.breco.insurance.mapper.TmsCteAddMapper;
import com.fedex.breco.insurance.mapper.TmsCteMapper;

@Component
public class TmsCteValidation {

	public StringBuilder cteValidation(TmsCteMapper tmscte) {

		StringBuilder content = new StringBuilder();

		concat(content, "101", "#");

		concat(content, String.valueOf(tmscte.getCteNbr()), "#"); // cct

		concat(content, tmscte.getOptional(), "#"); // 16 zeros

		concat(content, tmscte.getShipperCorporateName(), "#"); // _rem_ xNome

		concat(content, tmscte.getRecipientCorporateName(), "#"); // _dest_xNome

		if (tmscte.getCteIssueDate() != null) {// YYYYMMDD Row 9 dhEmi

			DateTime dateTime = new DateTime(tmscte.getCteIssueDate());

			String yyyymmdd = "";
			yyyymmdd = "" + (String.valueOf(dateTime.getYear())
					+ String.valueOf(dateTime.getMonthOfYear() < 10 ? "0" + dateTime.getMonthOfYear()
							: dateTime.getMonthOfYear())
					+ (dateTime.getDayOfMonth() < 10 ? "0" + dateTime.getDayOfMonth() : dateTime.getDayOfMonth()));

			concat(content, yyyymmdd, "#");
		} else {
			concat(content, tmscte.getOptional1(), "#");

		}

		concat(content, tmscte.getOptional1(), "#");
		concat(content, tmscte.getOptional1(), "#");
		concat(content, tmscte.getOptional2(), "#");
		concat(content, tmscte.getOptional3(), "#");

		if (tmscte.getPayerDetails().equals("0")) { // Row 14 toma

			concat(content, "C", "#");// shipper(rem)
		} else {

			concat(content, "F", "#"); // receiver(dest)
		}

		concat(content, tmscte.getRecipientCityName(), "#"); // 15 _dest_cMun

		NumberFormat formatterString = new DecimalFormat("00000000000.00");
		double cargoValue = Double.parseDouble(tmscte.getCargoTotalValueNumber());
		String number = formatterString.format(cargoValue).replace(".", "");
		concat(content, number, "#"); // 16

		double d = Double.parseDouble(tmscte.getCteTotValue());
		String totValue = formatterString.format(d).replace(".", "");
		concat(content, totValue, "#"); // 17 Value of CTE

		concat(content, StringUtils.leftPad(tmscte.getDimWt().replace(".", ""), 4, "0"), "#"); // dimwt

		concat(content, StringUtils.leftPad(tmscte.getGrossWt().replace(".", ""), 6, "0"), "#");

		concat(content, StringUtils.leftPad(tmscte.getWeightCharged().replace(".", ""), 6, "0"), "#");

		concat(content, tmscte.getOptional5(), "#"); // 06 zeros(CUBIC wt optional)

		concat(content, tmscte.getOptional6(), "#"); // 1 SPACE //22

		if (tmscte.getServico().equals("1")) { // 23
			concat(content, "N", "#"); // s|n
		} else {
			concat(content, "S", "#"); // s|n
		}

		if (tmscte.getStateTaxRate() != null) { // picms 24

			String with004digits = String
					.valueOf(new BigDecimal(tmscte.getStateTaxRate()).stripTrailingZeros().toPlainString());
			String with0004digits = String.format("%04d", Integer.parseInt(with004digits));
			concat(content, with0004digits, "#"); // 4 0s
		} else {
			concat(content, tmscte.getOptional2(), "#");
		}

		concat(content, tmscte.getOptional6(), "#"); // 1pace 25
		concat(content, "1", "#"); // modal 26
		concat(content, "N", "#"); // recep_cnpj (need to check conditiona and print S|N) 27
		concat(content, String.valueOf(tmscte.getElementValueNumber()), "#");

		if (tmscte.getPayerDetails().equals("0")) { // C

			concat(content, tmscte.getOptional10(), "#");
			concat(content, tmscte.getTaxIdNbr().replaceAll("[()?:!/.,;{}-]", ""), "#"); // 30 rem_cnpj

		} else {

			if (tmscte.getRecpTaxId() != null) {

				concat(content, tmscte.getRecpTaxId().replaceAll("[()?:!/.,;{}-]", ""), "#"); // dest_cnpj
				concat(content, tmscte.getOptional10(), "#");// 30

			} else {
				concat(content, StringUtils.leftPad(tmscte.getRecpFedTaxIdntyNumber().replaceAll("[()?:!/.,;{}-]", ""),
						14, "0"), "#"); // 29 dest_cpf
				concat(content, tmscte.getOptional10(), "#");
			}

		}

		concat(content, tmscte.getOptional10(), "#"); // 31

		if (tmscte.getPayerDetails().equals("0")) {
			concat(content, tmscte.getShipperStreetAddress(), "#");
		} else {

			concat(content, tmscte.getRecipientStreetAddress(), "#");
		}

		if (tmscte.getPayerDetails().equals("0")) {

			concat(content, tmscte.getShipperCityName(), "#");
		} else {

			concat(content, tmscte.getRecipientCityName(), "#");
		}

		if (tmscte.getPayerDetails().equals("0")) {

			concat(content, tmscte.getShipperStateAbbreviation(), "#");
		} else {
			concat(content, tmscte.getRecipientAddressStateAbbreviation(), "#");
		}

		concat(content, tmscte.getOptional1(), "#");
		concat(content, tmscte.getOptional11(), "#");
		concat(content, tmscte.getOptional12(), "#"); // 3 spaces
		concat(content, tmscte.getOptional6(), "#"); // 1 space
		concat(content, tmscte.getOptional6(), "#");
		concat(content, tmscte.getOptional2(), "#");
		concat(content, tmscte.getOptional8(), "#");
		concat(content, tmscte.getOptional2(), "#");
		concat(content, tmscte.getOptional10(), "#");
		concat(content, tmscte.getOptional9(), "#");
		concat(content, tmscte.getOptional6(), "#");
		concat(content, tmscte.getOptional6(), "#");
		concat(content, tmscte.getOptional2(), "#"); // 4 zeroes

		NumberFormat formatterStringValue = new DecimalFormat("00000.0000");
		double grossValue = Double.parseDouble(tmscte.getGrossWt());
		String grossNumber = formatterStringValue.format(grossValue).replace(".", "");
		concat(content, grossNumber, "#");

		concat(content, tmscte.getOptional14(), "#");

		LocalDate date = LocalDate.now().plusDays(5);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		if (date.getDayOfWeek().equals("Saturday")) {
			concat(content, (date.plusDays(2)).format(formatter), "#");
		} else if (date.getDayOfWeek().equals("Sunday")) {
			concat(content, (date.plusDays(1)).format(formatter), "#");
		} else {
			concat(content, (date.format(formatter)), "#");
		}
		concat(content, tmscte.getOptional27(), "#"); // 51
		concat(content, tmscte.getOptional1(), "#");
		concat(content, tmscte.getOptional2(), "#");
		concat(content, tmscte.getOptional6(), "#");
		concat(content, "N", "#");// Need to check OPTIONAL FIELD //55
		concat(content, "N", "#");// Need to check OPTIONAL FIELD //56
		concat(content, tmscte.getOptional6(), "#");

		if (tmscte.getCteCode() != null) {
			concat(content, String.valueOf(tmscte.getCteNbr()), "#");
		} else {
			concat(content, tmscte.getOptional14(), "#");
		}

		concat(content, tmscte.getSeriesId(), "#");

		if (tmscte.getCteIssueDate() != null) { // YYYYMMDD

			DateTime dateTime1 = new DateTime(tmscte.getCteIssueDate());

			String yearMonthDate = "";
			yearMonthDate = "" + (String.valueOf(dateTime1.getYear())
					+ String.valueOf(dateTime1.getMonthOfYear() < 10 ? "0" + dateTime1.getMonthOfYear()
							: dateTime1.getMonthOfYear())
					+ (dateTime1.getDayOfMonth() < 10 ? "0" + dateTime1.getDayOfMonth() : dateTime1.getDayOfMonth()));
			concat(content, yearMonthDate, "#");

		} else {
			concat(content, tmscte.getOptional1(), "#");

		}

		concat(content, String.valueOf(tmscte.getResponseStatusCode()), "#");

		if (tmscte.getCteIssueDate() != null) { // HHMMSS

			DateTime dateTime = new DateTime(tmscte.getCteIssueDate());
			String time = String
					.valueOf(dateTime.getHourOfDay() < 10 ? "0" + dateTime.getHourOfDay() : dateTime.getHourOfDay())
					+ (String
							.valueOf(dateTime.getMinuteOfHour() < 10 ? "0" + dateTime.getMinuteOfHour()
									: dateTime.getMinuteOfHour())
							+ String.valueOf(dateTime.getSecondOfMinute() < 10 ? "0" + dateTime.getSecondOfMinute()
									: dateTime.getSecondOfMinute()));

			concat(content, time, "#");
		} else {
			concat(content, tmscte.getOptional2(), "#");

		}

		if (tmscte.getCteCode() != null) {
			concat(content, tmscte.getCteCode(), "#");
		}

		concat(content, tmscte.getOptional15(), "#"); // mod
		concat(content, tmscte.getOptional7(), "#"); // N
		concat(content, tmscte.getAwbNo(), "#"); // AWB
		concat(content, tmscte.getOptional17(), "#");
		concat(content, tmscte.getOptional18(), "#");
		concat(content, tmscte.getOptional19(), "#");
		concat(content, tmscte.getOptional20(), "#");
		concat(content, tmscte.getOptional17(), "#");
		concat(content, tmscte.getOptional4(), "#");

		content.append("#");

		return content;
	}

	// 109 cte valiodation
	public StringBuilder cteAddValidation(TmsCteAddMapper tmscte, String stationcd) {

		StringBuilder content = new StringBuilder();

		concat(content, "109", "#");

		if (stationcd != null) {
			concat(content, stationcd, "#");

		} else {
			concat(content, "0000", "#");
		}

		concat(content, String.valueOf(tmscte.getCteNbr()), "#");

		if (tmscte.getCteIssueDate() != null) { // YYYYMMDD

			DateTime dateTime = new DateTime(tmscte.getCteIssueDate());

			String yyyymmdd = "";
			yyyymmdd = "" + (String.valueOf(dateTime.getYear())
					+ String.valueOf(dateTime.getMonthOfYear() < 10 ? "0" + dateTime.getMonthOfYear()
							: dateTime.getMonthOfYear())
					+ (dateTime.getDayOfMonth() < 10 ? "0" + dateTime.getDayOfMonth() : dateTime.getDayOfMonth()));

			concat(content, yyyymmdd, "#");

		} else {
			concat(content, tmscte.getOptional3(), "#");

		}

		concat(content, tmscte.getCteSeriesNumber(), "#");

		concat(content, String.valueOf(tmscte.getCteNbr()), "#");

		concat(content, tmscte.getOptional(), "#"); // 12 zeros

		concat(content, tmscte.getCteNumber(), "#");

		concat(content, tmscte.getServicetypeCode(), "#");

		concat(content, String.valueOf(tmscte.getResponseStatusCode()), "#");

		concat(content, tmscte.getStatusDescription(), "#");

		concat(content, tmscte.getEnvironmentType(), "#");

		concat(content, tmscte.getTaxIdNbr(), "#"); // added 14 didgits

		if (tmscte.getAuthorizationDate() != null) { // YYYYMMDD

			DateTime dateTime = new DateTime(tmscte.getAuthorizationDate());

			String yearMonthDate = "";
			yearMonthDate = "" + (String.valueOf(dateTime.getYear())
					+ String.valueOf(dateTime.getMonthOfYear() < 10 ? "0" + dateTime.getMonthOfYear()
							: dateTime.getMonthOfYear())
					+ (dateTime.getDayOfMonth() < 10 ? "0" + dateTime.getDayOfMonth() : dateTime.getDayOfMonth()));

			concat(content, yearMonthDate, "#");

		} else {
			concat(content, tmscte.getOptional3(), "#");

		}

		if (tmscte.getAuthorizationDate() != null) { // HHMMSS

			DateTime dateTime = new DateTime(tmscte.getAuthorizationDate());
			String time = String
					.valueOf(dateTime.getHourOfDay() < 10 ? "0" + dateTime.getHourOfDay() : dateTime.getHourOfDay())
					+ (String
							.valueOf(dateTime.getMinuteOfHour() < 10 ? "0" + dateTime.getMinuteOfHour()
									: dateTime.getMinuteOfHour())
							+ String.valueOf(dateTime.getSecondOfMinute() < 10 ? "0" + dateTime.getSecondOfMinute()
									: dateTime.getSecondOfMinute()));

			concat(content, time, "#");
		} else {
			concat(content, tmscte.getOptional4(), "#");

		}

		concat(content, tmscte.getProtocolNumber(), "#");

		concat(content, tmscte.getOptional1(), "#");// 42
		concat(content, tmscte.getOptional2(), "#");
		concat(content, tmscte.getOptional3(), "#");
		concat(content, tmscte.getOptional4(), "#");
		concat(content, tmscte.getOptional3(), "#");
		concat(content, tmscte.getOptional4(), "#");
		concat(content, tmscte.getOptional7(), "#");
		concat(content, tmscte.getOptional8(), "#");

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

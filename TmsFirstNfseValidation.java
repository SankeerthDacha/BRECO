package com.fedex.breco.insurance.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import com.fedex.breco.insurance.mapper.TmsCteMapper;

@Component
public class TmsFirstNfseValidation {

	public StringBuilder nfseFirstValidation(TmsCteMapper tmscte) {

		StringBuilder content = new StringBuilder();

		concat(content, "101", "#");

		concat(content, String.valueOf(tmscte.getcCT()), "#");

		concat(content, tmscte.getOptional(), "#"); // 16 zeros
		concat(content, tmscte.getShipperCorporateName(), "#");

		concat(content, tmscte.getRecipientCorporateName(), "#");

		if (tmscte.getCteIssueDate() != null) {// YYYYMMDD Row 9

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

		if (tmscte.getPayerDetails().equals("0")) { // Row 14

			concat(content, "C", "#");
		} else {

			concat(content, "F", "#");
		}

		concat(content, tmscte.getRecipientCityName(), "#"); // 15

		concat(content, tmscte.getCargoTotalValueNumber(), "#"); // 16

		concat(content, tmscte.getCteTotValue(), "#"); // 17 Value of CTE

		String replacedim = tmscte.getDimWt().replace(".", "");
		String with4digits = String.format("%04d", Integer.parseInt(replacedim));
		concat(content, with4digits, "#"); // dimwt

		String replaceGross = tmscte.getGrossWt().replace(".", "");
		String with04digits = String.format("%06d", Integer.parseInt(replaceGross));
		concat(content, with04digits, "#");

		String replaceWtChrgd = tmscte.getWeightCharged().replace(".", "");
		String with6digits = String.format("%06d", Integer.parseInt(replaceWtChrgd));
		concat(content, with6digits, "#");

		concat(content, tmscte.getOptional5(), "#"); // 06 zeros(CUBIC wt optional)

		concat(content, tmscte.getOptional6(), "#"); // 1 SPACE //22

		if (tmscte.getServico().equals("1")) { // 23
			concat(content, "S", "#"); // s|n
		} else {
			concat(content, "N", "#"); // s|n
		}

		if (tmscte.getStateTaxRate() != null) { // picms 24
			concat(content, String.valueOf(tmscte.getStateTaxRate()), "#"); // 4 0s
		} else {
			concat(content, tmscte.getOptional2(), "#");
		}

		concat(content, tmscte.getOptional6(), "#"); // 1pace 25
		concat(content, "1", "#"); // modal 26
		concat(content, "N", "#"); // recep_cnpj (need to check conditiona and print S|N) 27

		concat(content, String.valueOf(tmscte.getElementValueNumber()), "#");

		concat(content, String.valueOf(tmscte.getRecpFedTaxIdntyNumber()), "#");

		concat(content, tmscte.getTaxIdNbr(), "#");

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
		concat(content, tmscte.getOptional12(), "#");
		concat(content, tmscte.getOptional6(), "#");
		concat(content, tmscte.getOptional6(), "#");
		concat(content, tmscte.getOptional2(), "#");
		concat(content, tmscte.getOptional8(), "#");
		concat(content, tmscte.getOptional2(), "#");
		concat(content, tmscte.getOptional10(), "#");
		concat(content, tmscte.getOptional9(), "#");
		concat(content, tmscte.getOptional6(), "#");
		concat(content, tmscte.getOptional6(), "#");
		concat(content, tmscte.getOptional2(), "#"); // 4 zeroes
		concat(content, tmscte.getOptional13(), "#"); // 13 0s hardcoded 48 row (No column with name NT Wt)
		concat(content, tmscte.getOptional13(), "#");

		LocalDate date = LocalDate.now().plusDays(5);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		if (date.getDayOfWeek().equals("Saturday")) {
			concat(content, (date.plusDays(2)).format(formatter), "#");
		} else if (date.getDayOfWeek().equals("Sunday")) {
			concat(content, (date.plusDays(1)).format(formatter), "#");
		} else {
			concat(content, (date.format(formatter)), "#");
		}
		concat(content, tmscte.getOptional14(), "#"); // 51
		concat(content, tmscte.getOptional1(), "#");
		concat(content, tmscte.getOptional2(), "#");
		concat(content, tmscte.getOptional6(), "#");
		concat(content, "N", "#");// Need to check OPTIONAL FIELD //55
		concat(content, "N", "#");// Need to check OPTIONAL FIELD //56
		concat(content, tmscte.getOptional6(), "#");

		if (tmscte.getCteCode() != null) {
			concat(content, String.valueOf(tmscte.getcCT()), "#");
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

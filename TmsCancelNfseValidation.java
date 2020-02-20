package com.fedex.breco.insurance.utils;

import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import com.fedex.breco.insurance.mapper.TmsNfseExtMapper;

@Component
public class TmsCancelNfseValidation {

	public StringBuilder nfseCancelValidation(TmsNfseExtMapper tmsNfse, String stationcd) {

		StringBuilder content = new StringBuilder();
		concat(content, "109", "#");
		if (stationcd != null) {
			concat(content, stationcd, "#");

		} else {
			concat(content, "0000", "#");
		}

		concat(content, String.valueOf(tmsNfse.getRpsId()), "#");

		if (tmsNfse.getIssueDateOfRPS() != null) { // YYYYMMDD

			DateTime dateTime = new DateTime(tmsNfse.getIssueDateOfRPS());

			String yyyymmdd = "";
			yyyymmdd = "" + (String.valueOf(dateTime.getYear())
					+ String.valueOf(dateTime.getMonthOfYear() < 10 ? "0" + dateTime.getMonthOfYear()
							: dateTime.getMonthOfYear())
					+ (dateTime.getDayOfMonth() < 10 ? "0" + dateTime.getDayOfMonth() : dateTime.getDayOfMonth()));

			concat(content, yyyymmdd, "#");

		} else {
			concat(content, "00000000", "#");

		}

		concat(content, tmsNfse.getRpsSeriesId(), "#"); // serieCte

		concat(content, tmsNfse.getNfsecd(), "#");

		concat(content, String.valueOf(tmsNfse.getResponseStatus()), "#"); // status

		concat(content, tmsNfse.getStatusDescription(), "#");

		if (tmsNfse.getCancelDate() != null) { // YYYYMMDD

			DateTime dateTime = new DateTime(tmsNfse.getCancelDate());

			String yearMonthDate = "";
			yearMonthDate = "" + (String.valueOf(dateTime.getYear())
					+ String.valueOf(dateTime.getMonthOfYear() < 10 ? "0" + dateTime.getMonthOfYear()
							: dateTime.getMonthOfYear())
					+ (dateTime.getDayOfMonth() < 10 ? "0" + dateTime.getDayOfMonth() : dateTime.getDayOfMonth()));

			concat(content, yearMonthDate, "#");

		} else {
			concat(content, "00000000", "#");

		}

		if (tmsNfse.getCancelDate() != null) { // HHMMSS

			DateTime dateTime = new DateTime(tmsNfse.getCancelDate());
			String time = String
					.valueOf(dateTime.getHourOfDay() < 10 ? "0" + dateTime.getHourOfDay() : dateTime.getHourOfDay())
					+ (String
							.valueOf(dateTime.getMinuteOfHour() < 10 ? "0" + dateTime.getMinuteOfHour()
									: dateTime.getMinuteOfHour())
							+ String.valueOf(dateTime.getSecondOfMinute() < 10 ? "0" + dateTime.getSecondOfMinute()
									: dateTime.getSecondOfMinute()));

			concat(content, time, "#");
		} else {
			concat(content, "000000", "#");

		}
		concat(content, tmsNfse.getProtocolNumber(), "#");
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

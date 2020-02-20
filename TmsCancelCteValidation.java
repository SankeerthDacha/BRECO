package com.fedex.breco.insurance.utils;

import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import com.fedex.breco.insurance.mapper.TmsCteAddMapper;

@Component
public class TmsCancelCteValidation {
	// 109 cte valiodation
	public StringBuilder cteCancelValidation(TmsCteAddMapper tmscte, String stationcd) {

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
			concat(content, "00000000", "#");

		}

		concat(content, tmscte.getCteSeriesNumber(), "#"); // serieCte

		concat(content, tmscte.getCteNumber(), "#");

		concat(content, String.valueOf(tmscte.getResponseStatusCode()), "#"); // status

		concat(content, tmscte.getStatusDescription(), "#");

		if (tmscte.getCancelDate() != null) { // YYYYMMDD

			DateTime dateTime = new DateTime(tmscte.getCancelDate());

			String yearMonthDate = "";
			yearMonthDate = "" + (String.valueOf(dateTime.getYear())
					+ String.valueOf(dateTime.getMonthOfYear() < 10 ? "0" + dateTime.getMonthOfYear()
							: dateTime.getMonthOfYear())
					+ (dateTime.getDayOfMonth() < 10 ? "0" + dateTime.getDayOfMonth() : dateTime.getDayOfMonth()));

			concat(content, yearMonthDate, "#");

		} else {
			concat(content, "00000000", "#");

		}

		if (tmscte.getCancelDate() != null) { // HHMMSS

			DateTime dateTime = new DateTime(tmscte.getCancelDate());
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
		concat(content, tmscte.getProtocolNumber(), "#");
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

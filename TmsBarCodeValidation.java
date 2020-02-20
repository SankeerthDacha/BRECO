package com.fedex.breco.insurance.utils;

import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import com.fedex.breco.insurance.mapper.TmsCteMapper;

@Component
public class TmsBarCodeValidation {

	public StringBuilder cteBarCodeValidation(TmsCteMapper tmscte, String stationCode) {

		StringBuilder content = new StringBuilder();

		concat(content, "107", "#");
		concat(content, tmscte.getBarCode(), "#"); // 16 zeros

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

		concat(content, stationCode, "#");
		concat(content, String.valueOf(tmscte.getCteNbr()), "#");

		String notaFiscalKeyvalue = tmscte.getNfId();
		String with9digits = String.format("%09d", Integer.parseInt(notaFiscalKeyvalue));
		concat(content, with9digits, "#");
		
		//concat(content, tmscte.getNfId(), "#");

		concat(content, tmscte.getOptional23(), "#"); // 20 Characters
		concat(content, tmscte.getOptional26(), "#");
		concat(content, tmscte.getOptional23(), "#");
		concat(content, tmscte.getOptional2(), "#");
		concat(content, tmscte.getOptional6(), "#");
		concat(content, tmscte.getOptional12(), "#");

		concat(content, tmscte.getOptional1(), "#");
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

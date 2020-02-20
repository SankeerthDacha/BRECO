package com.fedex.breco.insurance.utils;

import org.springframework.stereotype.Component;

import com.fedex.breco.insurance.mapper.TmsAwbMapper;

@Component
public class TmsAwbValidation {

	public StringBuilder cteAwbValidation(TmsAwbMapper tmscte) {

		StringBuilder content = new StringBuilder();

		concat(content, "123", "#");
		concat(content, tmscte.getAwbNumber(), "#");
		concat(content, tmscte.getChildAwbNum(), "#");
		if (tmscte.getServiceType().equals("5") || tmscte.getServiceType().equals("05")) {
			concat(content, "SO", "#");
		} else if (tmscte.getServiceType().equals("20"))

		{
			concat(content, "XS", "#");
		} else if (tmscte.getServiceType().equals("70"))

		{
			concat(content, "F1", "#");
		} else if (tmscte.getServiceType().equals("80"))

		{
			concat(content, "F2", "#");
		} else if (tmscte.getServiceType().equals("01") || tmscte.getServiceType().equals("1"))

		{
			concat(content, "PO", "#");
		} else if (tmscte.getServiceType().equals("06") || tmscte.getServiceType().equals("6"))

		{
			concat(content, "FO", "#");
		}

		else {
			concat(content, "00", "#");
		}

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
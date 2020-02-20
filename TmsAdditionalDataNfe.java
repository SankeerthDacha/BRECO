package com.fedex.breco.insurance.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fedex.breco.insurance.mapper.AdditionalDataNfeMapper;
import com.fedex.breco.insurance.repository.StationLocationRepo;

@Component
public class TmsAdditionalDataNfe {

	@Autowired
	StationLocationRepo stationLocationRepo;

	public StringBuilder additionalDataNfeValidation(AdditionalDataNfeMapper tmsnfe) {

		StringBuilder content = new StringBuilder();

		concat(content, "111", "#");

		String notaFiscalKey = tmsnfe.getNotaFiscalID();
		String with9digits = String.format("%09d", Integer.parseInt(notaFiscalKey));
		concat(content, with9digits, "#");

		concat(content, String.valueOf(tmsnfe.getCteNbr()), "#");

		concat(content, tmsnfe.getCountOfItemNumber(), "#");

		concat(content, String.valueOf(tmsnfe.getNFeKey()), "#");

		concat(content, tmsnfe.getOptional1(), "#");
		concat(content, tmsnfe.getOptional2(), "#");
		concat(content, tmsnfe.getOptional2(), "#");
		concat(content, tmsnfe.getOptional4(), "#");
		concat(content, tmsnfe.getOptional5(), "#");
		concat(content, tmsnfe.getOptional6(), "#");

		concat(content, tmsnfe.getAwbNbr(), "#");

		concat(content, tmsnfe.getOptional8(), "#");
		concat(content, tmsnfe.getOptional9(), "#");

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

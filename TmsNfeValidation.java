package com.fedex.breco.insurance.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.fedex.breco.insurance.mapper.TmsNfeMapper;

@Component
public class TmsNfeValidation {
	public StringBuilder nfeValidation(TmsNfeMapper tmsNfe) {
		StringBuilder content = new StringBuilder();

		concat(content, "102", "#");
		concat(content, tmsNfe.getCteNbr(), "#");

		String with9digits = String.format("%09d", Integer.parseInt(tmsNfe.getnFeNumber())); // NFE NUm 09size
		concat(content, with9digits, "#");

		concat(content, tmsNfe.getOptional1(), "#");

		
		String NotaFiscalSerieNumber = tmsNfe.getNotaFiscalSerieNumber();
		String with3digits = String.format("%03d", Integer.parseInt(NotaFiscalSerieNumber));
		concat(content, with3digits, "#");
		
		//concat(content, tmsNfe.getNotaFiscalSerieNumber(), "#");

		concat(content, tmsNfe.getOptional3(), "#");
		concat(content, tmsNfe.getOptional2(), "#");

		NumberFormat formatterString = new DecimalFormat("00000000000.00");
		double grossValue = Double.parseDouble(tmsNfe.getValorTotal());
		String grossNumber = formatterString.format(grossValue).replace(".", "");
		concat(content, grossNumber, "#");
		concat(content, tmsNfe.getQuantitade(), "#"); // Quantitade Total //Row 12

		NumberFormat formatterStringSix = new DecimalFormat("000000");
		double grossValueSix = Double.parseDouble(tmsNfe.getGrossWt());
		String grossNumberSix = formatterStringSix.format(grossValueSix).replace(".", "");
		concat(content, grossNumberSix, "#");

		concat(content, tmsNfe.getOptional4(), "#");

		if (tmsNfe.getIssueDateNfe() != null) {
			String formattedDateNfe = new SimpleDateFormat("2yyyMMdd").format(tmsNfe.getIssueDateNfe());
			concat(content, formattedDateNfe.toString(), "#");
		} else {

			SimpleDateFormat formattedDate = new SimpleDateFormat("yyyyMMdd");
			String timestampFormat = formattedDate.format(new Date());
			concat(content, timestampFormat, "#");
		}

		concat(content, tmsNfe.getOptional6(), "#");
		concat(content, tmsNfe.getOptional7(), "#");
		concat(content, tmsNfe.getOptional7(), "#");
		concat(content, tmsNfe.getOptional4(), "#");
		concat(content, tmsNfe.getOptional4(), "#");
		concat(content, tmsNfe.getOptional5(), "#");
		concat(content, tmsNfe.getOptional4(), "#");
		concat(content, tmsNfe.getOptional4(), "#");
		concat(content, tmsNfe.getOptional5(), "#");
		concat(content, tmsNfe.getOptional3(), "#");
		concat(content, tmsNfe.getOptional2(), "#");
		if (tmsNfe.getcteIssueDate() != null) {

			String formattedDateCte = new SimpleDateFormat("yyyyMMdd").format(tmsNfe.getcteIssueDate());
			concat(content, formattedDateCte.toString(), "#");
		} else {
			concat(content, tmsNfe.getOptional3(), "#");
		}

		concat(content, tmsNfe.getOptional2(), "#");
		concat(content, tmsNfe.getOptional2(), "#");
		concat(content, tmsNfe.getOptional8(), "#");
		concat(content, tmsNfe.getOptional8(), "#");

		NumberFormat formatterStringGross = new DecimalFormat("00000.0000");
		double grossWt = Double.parseDouble(tmsNfe.getGrossWt());
		String grossWtNumber = formatterStringGross.format(grossWt).replace(".", "");
		concat(content, grossWtNumber, "#");

		concat(content, tmsNfe.getOptional4(), "#");
		concat(content, tmsNfe.getOptional2(), "#");
		concat(content, tmsNfe.getOptional9(), "#");

		concat(content, tmsNfe.getOptional1(), "#");
		concat(content, tmsNfe.getOptional9(), "#");
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

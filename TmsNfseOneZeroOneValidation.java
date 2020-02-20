package com.fedex.breco.insurance.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import com.fedex.breco.insurance.mapper.TmsNfseOneZeroOneMapper;

@Component
public class TmsNfseOneZeroOneValidation {

	public StringBuilder nfseOneZeroOneValidation(TmsNfseOneZeroOneMapper tmsNfse) {

		StringBuilder content = new StringBuilder();

		concat(content, "101", "#");

		concat(content, tmsNfse.getNfseNumber(), "#");

		concat(content, tmsNfse.getOptional(), "#"); // 16 zeros

		concat(content, tmsNfse.getShipperName(), "#");

		concat(content, tmsNfse.getRecipientName(), "#");

		if (tmsNfse.getIssueDateOfRPS() != null) {// YYYYMMDD Row 9

			DateTime dateTime = new DateTime(tmsNfse.getIssueDateOfRPS());

			String yyyymmdd = "";
			yyyymmdd = "" + (String.valueOf(dateTime.getYear())
					+ String.valueOf(dateTime.getMonthOfYear() < 10 ? "0" + dateTime.getMonthOfYear()
							: dateTime.getMonthOfYear())
					+ (dateTime.getDayOfMonth() < 10 ? "0" + dateTime.getDayOfMonth() : dateTime.getDayOfMonth()));

			concat(content, yyyymmdd, "#");
		} else {
			concat(content, tmsNfse.getOptional1(), "#");

		}
		concat(content, tmsNfse.getOptional1(), "#"); // 8
		concat(content, tmsNfse.getOptional1(), "#"); // 8
		concat(content, tmsNfse.getOptional2(), "#");// 4
		concat(content, tmsNfse.getOptional3(), "#"); // Row 13 2

		concat(content, tmsNfse.getPayer(), "#");

		concat(content, tmsNfse.getDestinationCity(), "#"); // 15

		NumberFormat formatterString = new DecimalFormat("00000000000.00");
		double totalValueOfProducts = Double.parseDouble(tmsNfse.getValueOfProducts());
		String number = formatterString.format(totalValueOfProducts).replace(".", "");
		concat(content, number, "#"); // 16

		NumberFormat formatterStringSumOfProducts = new DecimalFormat("00000000000.00");
		double SumOfProducts = Double.parseDouble(tmsNfse.getValueOfNfe());
		String totalNumber = formatterStringSumOfProducts.format(SumOfProducts).replace(".", "");
		concat(content, totalNumber, "#"); // 17

		/*
		 * String replacedim = tmsNfse.getDimWt().replace(".", ""); String with4digits =
		 * String.format("%04d", Integer.parseInt(replacedim)); concat(content,
		 * with4digits, "#"); // dimwt
		 */
		// concat(content, tmsNfse.getValueOfNfe(), "#");
		concat(content, tmsNfse.getDimWt(), "#");

		String replaceGross = tmsNfse.getGrossWt().replace(".", "");
		String with04digits = String.format("%06d", Integer.parseInt(replaceGross));
		concat(content, with04digits, "#");

		concat(content, tmsNfse.getWeightCharged(), "#");
		/*
		 * String replaceWtChrgd = tmsNfse.getWeightCharged().replace(".", ""); String
		 * with6digits = String.format("%06d", Integer.parseInt(replaceWtChrgd));
		 * concat(content, with6digits, "#");
		 */
		concat(content, tmsNfse.getOptional5(), "#"); // 06 zeros(CUBIC wt optional)

		concat(content, tmsNfse.getOptional6(), "#"); // 1 SPACE //22

		if (tmsNfse.getSituacaoRPS().equals("2")) {

			concat(content, "S", "#");
		} else {
			concat(content, "N", "#"); // 23
		}

		String with004digits = String
				.valueOf(new BigDecimal(tmsNfse.getTaxRate()).stripTrailingZeros().toPlainString());
		String taxRate = with004digits.replace(".", "");
		String with4digits = String.format("%04d", Integer.parseInt(taxRate));
		concat(content, with4digits, "#"); // taxRate

		// concat(content, tmsNfse.getTaxRate(), "#"); // 24
		concat(content, tmsNfse.getOptional6(), "#"); // 1 SPACE //25
		concat(content, "1", "#"); // 1 Always 26
		concat(content, "N", "#"); // N receb Always 26
		// concat(content, tmsNfse.getOptional9(), "#"); // 000 27

		concat(content, tmsNfse.getCodigoProduto(), "#"); // 000 28

		if (tmsNfse.getPayer().equals("C")) {

			concat(content, tmsNfse.getOptional10(), "#");
			concat(content, tmsNfse.getShipperFederalTaxID().replaceAll("[()?:!/.,;{}-]", ""), "#"); // 30 rem_cnpj

		} else {

			if (tmsNfse.getDestinataryFederalTaxID() != null) {

				concat(content, String.valueOf(tmsNfse.getDestinataryFederalTaxID().replaceAll("[()?:!/.,;{}-]", "")),
						"#"); // 29 dest_cnpj
				concat(content, tmsNfse.getOptional10(), "#");

			} else {

				concat(content, StringUtils.leftPad(tmsNfse.getDestTaxID().replaceAll("[()?:!/.,;{}-]", ""), 14, "0"),
						"#"); // 29
								// dest_cpf
				concat(content, tmsNfse.getOptional10(), "#");

			}

		}

		concat(content, tmsNfse.getOptional10(), "#"); // 000 31

		if (tmsNfse.getPayer().equals("C")) {// 32

			concat(content, tmsNfse.getRecipientAddress(), "#");

		} else {
			concat(content, tmsNfse.getIssuerAddress(), "#");
		}

		if (tmsNfse.getPayer().equals("C")) {// 33
			concat(content, tmsNfse.getRecipientCity(), "#");

		} else {

			concat(content, tmsNfse.getIssuerCity(), "#");
		}

		if (tmsNfse.getPayer().equals("C")) {// 34
			concat(content, tmsNfse.getRecipientState(), "#");

		} else {
			concat(content, tmsNfse.getIssuerState(), "#");
		}

		concat(content, tmsNfse.getOptional1(), "#"); // 35

		concat(content, tmsNfse.getOptional11(), "#"); // 36
		concat(content, tmsNfse.getOptional12(), "#"); // 37
		concat(content, tmsNfse.getOptional6(), "#"); // 38
		concat(content, tmsNfse.getOptional6(), "#"); // 39
		concat(content, tmsNfse.getOptional2(), "#"); // 40 4 0's
		concat(content, "01", "#"); // 41
		concat(content, tmsNfse.getOptional2(), "#"); // 42
		concat(content, tmsNfse.getOptional10(), "#"); // 43
		concat(content, tmsNfse.getOptional9(), "#"); // 44
		concat(content, tmsNfse.getOptional6(), "#"); // 45
		concat(content, tmsNfse.getOptional6(), "#"); // 46
		concat(content, tmsNfse.getOptional2(), "#"); // 47

		NumberFormat netWtFormatterString = new DecimalFormat("00000.0000");
		double totalValueNetWt = Double.parseDouble(tmsNfse.getNetWt());
		String netWt = netWtFormatterString.format(totalValueNetWt).replace(".", "");
		concat(content, netWt, "#"); // Net wt 48

		concat(content, tmsNfse.getOptional14(), "#"); // 49

		LocalDate date = LocalDate.now().plusDays(5);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		if (date.getDayOfWeek().equals("Saturday")) {
			concat(content, (date.plusDays(2)).format(formatter), "#");
		} else if (date.getDayOfWeek().equals("Sunday")) {
			concat(content, (date.plusDays(1)).format(formatter), "#");
		} else {
			concat(content, (date.format(formatter)), "#");
		} // 50

		concat(content, tmsNfse.getOptional25(), "#"); // 51
		concat(content, tmsNfse.getOptional1(), "#"); // 52
		concat(content, tmsNfse.getOptional2(), "#"); // 53
		concat(content, tmsNfse.getOptional6(), "#"); // 54
		concat(content, "N", "#"); // 55
		concat(content, "N", "#"); // 56
		concat(content, tmsNfse.getOptional6(), "#"); // 57

		concat(content, tmsNfse.getNfseNumber(), "#");// 58

		concat(content, tmsNfse.getNfseSerie(), "#");// 59

		if (tmsNfse.getIssueDateOfRPS() != null) {// YYYYMMDD Row 60

			DateTime dateTime = new DateTime(tmsNfse.getIssueDateOfRPS());

			String yyyymmdd = "";
			yyyymmdd = "" + (String.valueOf(dateTime.getYear())
					+ String.valueOf(dateTime.getMonthOfYear() < 10 ? "0" + dateTime.getMonthOfYear()
							: dateTime.getMonthOfYear())
					+ (dateTime.getDayOfMonth() < 10 ? "0" + dateTime.getDayOfMonth() : dateTime.getDayOfMonth()));

			concat(content, yyyymmdd, "#");
		} else {
			concat(content, tmsNfse.getOptional1(), "#");

		}

		if (tmsNfse.getSituacaoRPS().equals("1")) {

			concat(content, "A", "#");
		} else {
			concat(content, "C", "#"); // 61
		}

		if (tmsNfse.getIssueDateOfRPS() != null) { // HHMMSS 62

			DateTime dateTime = new DateTime(tmsNfse.getIssueDateOfRPS());
			String time = String
					.valueOf(dateTime.getHourOfDay() < 10 ? "0" + dateTime.getHourOfDay() : dateTime.getHourOfDay())
					+ (String
							.valueOf(dateTime.getMinuteOfHour() < 10 ? "0" + dateTime.getMinuteOfHour()
									: dateTime.getMinuteOfHour())
							+ String.valueOf(dateTime.getSecondOfMinute() < 10 ? "0" + dateTime.getSecondOfMinute()
									: dateTime.getSecondOfMinute()));

			concat(content, time, "#");
		} else {
			concat(content, tmsNfse.getOptional2(), "#");

		}

		concat(content, tmsNfse.getNfId(), "#"); // 63
		concat(content, "05", "#"); // 64

		concat(content, "N", "#"); // 65
		concat(content, tmsNfse.getAwbNo(), "#"); // 66
		concat(content, tmsNfse.getOptional17(), "#"); // 67

		concat(content, tmsNfse.getOptional18(), "#"); // 68
		concat(content, tmsNfse.getOptional19(), "#"); // 69
		concat(content, tmsNfse.getOptional20(), "#"); // 70
		concat(content, tmsNfse.getOptional17(), "#"); // 71
		concat(content, tmsNfse.getNfseNumber(), "#"); // 72
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

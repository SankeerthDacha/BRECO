package com.fedex.breco.insurance.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fedex.breco.insurance.mapper.AdditionaDatalNfseMapper;
import com.fedex.breco.insurance.mapper.TmsAdditionalNfseMapper;
import com.fedex.breco.insurance.mapper.TmsNfseExtMapper;
import com.fedex.breco.insurance.mapper.TmsNfseMapper;
import com.fedex.breco.insurance.mapper.TmsNfseOneZeroOneMapper;
import com.fedex.breco.insurance.repository.StationLocationRepo;

@Component
public class TmsNfseValidation {

	@Autowired
	StationLocationRepo stationLocationRepo;

	public StringBuilder nfseValidation(TmsNfseMapper tmsnfse, String stationcd) {
		StringBuilder content = new StringBuilder();

		concat(content, "119", "#");
		if (stationcd != null) {
			concat(content, stationcd, "#"); // station code

		} else {
			concat(content, "0000", "#");
		}

		concat(content, String.valueOf(tmsnfse.getRpsId()), "#"); // rps id
		if (tmsnfse.getIssueDateOfRPS() != null) {

			DateTime dateTime = new DateTime(tmsnfse.getIssueDateOfRPS());

			String yyyymmdd = "";
			yyyymmdd = "" + (String.valueOf(dateTime.getYear())
					+ String.valueOf(dateTime.getMonthOfYear() < 10 ? "0" + dateTime.getMonthOfYear()
							: dateTime.getMonthOfYear())
					+ (dateTime.getDayOfMonth() < 10 ? "0" + dateTime.getDayOfMonth() : dateTime.getDayOfMonth()));

			concat(content, yyyymmdd, "#");
		} else {
			concat(content, "00000000", "#");
		}

		concat(content, tmsnfse.getRpsSerie(), "#"); // seri rps

		concat(content, String.valueOf(tmsnfse.getRpsId()), "#"); // rps id

		concat(content, String.valueOf(tmsnfse.getOptional1()), "#"); // 12zeroes

		concat(content, String.valueOf(tmsnfse.getRpsId()), "#"); // rpsid
		if (tmsnfse.getDataAproved() != null) {
			DateTime yyyymmdd = new DateTime(tmsnfse.getDataAproved());
			String date = String.valueOf(yyyymmdd.getYear()) + (String.valueOf(
					yyyymmdd.getMonthOfYear() < 10 ? "0" + yyyymmdd.getMonthOfYear() : yyyymmdd.getMonthOfYear())
					+ String.valueOf(
							yyyymmdd.getDayOfMonth() < 10 ? "0" + yyyymmdd.getDayOfMonth() : yyyymmdd.getDayOfMonth()));
			concat(content, date, "#");
		} else {
			concat(content, "00000000", "#");
		}
		if (tmsnfse.getDataAproved() != null) {
			DateTime dateTime = new DateTime(tmsnfse.getDataAproved());
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

		concat(content, String.valueOf(tmsnfse.getSiafiPrestador()), "#");// siafipresdator

		concat(content, String.valueOf(tmsnfse.getTiporps()), "#"); // tipo rps

		concat(content, String.valueOf(tmsnfse.getFederalTaxId()), "#"); //

		concat(content, String.valueOf(tmsnfse.getMunicipalTaxId()), "#");

		concat(content, String.valueOf(tmsnfse.getRateOfServices()), "#");

		concat(content, String.valueOf(tmsnfse.getValueOfServices()), "#");

		concat(content, String.valueOf(tmsnfse.getValorDeduzir()), "#");

		concat(content, String.valueOf(tmsnfse.getCodigoVerificacao()), "#");

		concat(content, String.valueOf(tmsnfse.getNumeroLote()), "#");

		concat(content, String.valueOf(tmsnfse.getNumeroProtocolo()), "#");

		concat(content, String.valueOf(tmsnfse.getUrlConsulta()), "#");

		concat(content, String.valueOf(tmsnfse.getOriginlocid()), "#");

		concat(content, String.valueOf(tmsnfse.getOptional2()), "#");
		concat(content, String.valueOf(tmsnfse.getOptional3()), "#");
		concat(content, String.valueOf(tmsnfse.getOptional4()), "#");
		concat(content, String.valueOf(tmsnfse.getOptional5()), "#");
		concat(content, String.valueOf(tmsnfse.getOptional6()), "#");
		concat(content, String.valueOf(tmsnfse.getOptional7()), "#");
		concat(content, String.valueOf(tmsnfse.getOptional8()), "#");
		concat(content, String.valueOf(tmsnfse.getOptional9()), "#");

		content.append("#");
		return content;

	}

//109
	public StringBuilder nfseadditionalValidation(TmsNfseExtMapper tmsnfse, String stationcd) {
		StringBuilder content = new StringBuilder();

		concat(content, "109", "#");
		if (stationcd != null) {
			concat(content, stationcd, "#"); // station code

		} else {
			concat(content, "0000", "#");
		}

		concat(content, String.valueOf(tmsnfse.getRpsId()), "#"); // rps id

		if (tmsnfse.getIssueDateOfRPS() != null) { // rps issue date
			DateTime yyyymmdd = new DateTime(tmsnfse.getIssueDateOfRPS());
			String date = String.valueOf(yyyymmdd.getYear()) + (String.valueOf(
					yyyymmdd.getMonthOfYear() < 10 ? "0" + yyyymmdd.getMonthOfYear() : yyyymmdd.getMonthOfYear())
					+ String.valueOf(
							yyyymmdd.getDayOfMonth() < 10 ? "0" + yyyymmdd.getDayOfMonth() : yyyymmdd.getDayOfMonth()));
			concat(content, date, "#");
		} else {
			concat(content, "00000000", "#");
		}

		concat(content, tmsnfse.getRpsSeriesId(), "#"); // seri rps

		concat(content, String.valueOf(tmsnfse.getRpsId()), "#"); // rps id

		concat(content, String.valueOf(tmsnfse.getOptional()), "#"); // 12zeroes

		concat(content, String.valueOf(tmsnfse.getNfsecd()), "#"); // nfse_Cd

		concat(content, String.valueOf(tmsnfse.getOptional9()), "#");

		concat(content, String.valueOf(tmsnfse.getResponseStatus()), "#");

		concat(content, String.valueOf(tmsnfse.getStatusDescription()), "#");

		concat(content, String.valueOf(tmsnfse.getEnvironmentType()), "#");

		concat(content, String.valueOf(tmsnfse.getFederalTaxId()), "#"); // recp tax id

		if (tmsnfse.getApprovalDate() != null) { // rp_s_dt
			DateTime yyyymmdd = new DateTime(tmsnfse.getApprovalDate());
			String date = String.valueOf(yyyymmdd.getYear()) + (String.valueOf(
					yyyymmdd.getMonthOfYear() < 10 ? "0" + yyyymmdd.getMonthOfYear() : yyyymmdd.getMonthOfYear())
					+ String.valueOf(
							yyyymmdd.getDayOfMonth() < 10 ? "0" + yyyymmdd.getDayOfMonth() : yyyymmdd.getDayOfMonth()));
			concat(content, date, "#");
		} else {
			concat(content, "00000000", "#");
		}
		if (tmsnfse.getApprovalDate() != null) {
			DateTime dateTime = new DateTime(tmsnfse.getApprovalDate());
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

		concat(content, String.valueOf(tmsnfse.getProtocolNumber()), "#");

		concat(content, String.valueOf(tmsnfse.getOptional1()), "#");
		concat(content, String.valueOf(tmsnfse.getOptional2()), "#");

		if (tmsnfse.getApprovalDate1() != null) { // yyyymmdd creation date
			DateTime yyyymmdd = new DateTime(tmsnfse.getApprovalDate1());
			String date = String.valueOf(yyyymmdd.getYear()) + (String.valueOf(
					yyyymmdd.getMonthOfYear() < 10 ? "0" + yyyymmdd.getMonthOfYear() : yyyymmdd.getMonthOfYear())
					+ String.valueOf(
							yyyymmdd.getDayOfMonth() < 10 ? "0" + yyyymmdd.getDayOfMonth() : yyyymmdd.getDayOfMonth()));
			concat(content, date, "#");
		} else {
			concat(content, "00000000", "#");
		}
		if (tmsnfse.getApprovalDate1() != null) { // hhmmss
			DateTime dateTime = new DateTime(tmsnfse.getApprovalDate1());
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

		if (tmsnfse.getUpdateDate() != null) { // rp_s_dt
			DateTime yyyymmdd = new DateTime(tmsnfse.getUpdateDate());
			String date = String.valueOf(yyyymmdd.getYear()) + (String.valueOf(
					yyyymmdd.getMonthOfYear() < 10 ? "0" + yyyymmdd.getMonthOfYear() : yyyymmdd.getMonthOfYear())
					+ String.valueOf(
							yyyymmdd.getDayOfMonth() < 10 ? "0" + yyyymmdd.getDayOfMonth() : yyyymmdd.getDayOfMonth()));
			concat(content, date, "#");
		} else {
			concat(content, "00000000", "#");
		}
		if (tmsnfse.getUpdateDate() != null) {
			DateTime dateTime = new DateTime(tmsnfse.getUpdateDate());
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

		concat(content, String.valueOf(tmsnfse.getOptional7()), "#");
		concat(content, tmsnfse.getRpsId(), "#");

		content.append("#");
		return content;

	}

	// 102 NFSe
	public StringBuilder tmsNfseValidation(TmsAdditionalNfseMapper tmsNfse) {

		StringBuilder content = new StringBuilder();

		concat(content, "102", "#");
		concat(content, tmsNfse.getRpsId(), "#");

		String with9digits = String.format("%09d", Integer.parseInt(tmsNfse.getnFeNumber())); // NFE NUm 09size
		concat(content, with9digits, "#");
		concat(content, tmsNfse.getOptional1(), "#"); // 2 0's
		concat(content, tmsNfse.getnotaFiscalSerieNumber(), "#"); // Row 8
		concat(content, tmsNfse.getOptional3(), "#"); // 8 Zeros
		concat(content, tmsNfse.getOptional2(), "#"); // 4 0's

		String valor = tmsNfse.getValorTotal().replace(".", "");
		String with11digits = String.format("%013d", Integer.parseInt(valor));
		concat(content, String.valueOf(with11digits), "#"); // Valor Total //Row 11
		concat(content, tmsNfse.getQuantitade(), "#"); // Quantitade Total //Row 12
		concat(content, tmsNfse.getqCarga(), "#"); // Qcarga Total //Row 13
		concat(content, tmsNfse.getOptional4(), "#"); // 13 0's

		if (tmsNfse.getIssueDateNfe() != null) {// YYYYMMDD
			String formattedDate = new SimpleDateFormat("2yyyMMdd").format(tmsNfse.getIssueDateNfe());
			concat(content, formattedDate.toString(), "#");
		} else {
			SimpleDateFormat formatDate = new SimpleDateFormat("yyyyMMdd");
			String timestampFormat = formatDate.format(new Date());
			concat(content, timestampFormat, "#");
		}

		concat(content, tmsNfse.getOptional6(), "#"); // 1 space
		concat(content, tmsNfse.getOptional7(), "#"); // 2 space
		concat(content, tmsNfse.getOptional7(), "#"); // 2 space
		concat(content, tmsNfse.getOptional4(), "#"); // 13 0's
		concat(content, tmsNfse.getOptional4(), "#"); // 13 0's
		concat(content, tmsNfse.getOptional5(), "#"); // 5 0's
		concat(content, tmsNfse.getOptional4(), "#"); // 13 0's
		concat(content, tmsNfse.getOptional4(), "#"); // 13 0's
		concat(content, tmsNfse.getOptional5(), "#"); // 5 0's
		concat(content, tmsNfse.getOptional3(), "#"); // 8 0's
		concat(content, tmsNfse.getOptional2(), "#"); // 4 0's
		if (tmsNfse.getRpsIssueDate() != null) {// YYYYMMDD

			String formattedDate = new SimpleDateFormat("yyyyMMdd").format(tmsNfse.getRpsIssueDate());
			concat(content, formattedDate.toString(), "#");
		} else {
			concat(content, tmsNfse.getOptional3(), "#");
		}

		concat(content, tmsNfse.getOptional2(), "#"); // 4 0's
		concat(content, tmsNfse.getOptional2(), "#"); // 4 0's
		concat(content, tmsNfse.getOptional8(), "#"); // 10 space
		concat(content, tmsNfse.getOptional8(), "#"); // 10 space
		concat(content, tmsNfse.getNfQcarga(), "#"); // Qcarga Total //Row 13
		concat(content, tmsNfse.getOptional4(), "#"); // 13 0's
		concat(content, tmsNfse.getOptional2(), "#"); // 4 0's
		concat(content, tmsNfse.getOptional9(), "#"); // 9 0's

		concat(content, tmsNfse.getOptional1(), "#"); // 2
		concat(content, tmsNfse.getOptional9(), "#"); // 9
		content.append("#");
		return content;

	}

	// 111 Nfse
	public StringBuilder AdditionalTmsNfseValidation(AdditionaDatalNfseMapper tmsNfse) {

		StringBuilder content = new StringBuilder();

		concat(content, "111", "#");

		concat(content, StringUtils.leftPad(tmsNfse.getNotaFiscalID().replace(".", ""), 9, "0"), "#"); // 9 Zeros

		concat(content, String.valueOf(tmsNfse.getRpsId()), "#");

		// Count of Item Lines gave as default value 4 zeros
		concat(content, tmsNfse.getOptional3(), "#");

		concat(content, String.valueOf(tmsNfse.getNFeKey()), "#");

		concat(content, tmsNfse.getOptional1(), "#"); // 10 space
		concat(content, tmsNfse.getOptional2(), "#"); // 9 Zeros
		concat(content, tmsNfse.getOptional2(), "#"); // 9 Zeros
		concat(content, tmsNfse.getOptional4(), "#"); // 1 Space
		concat(content, tmsNfse.getOptional5(), "#");// 3 Space
		concat(content, tmsNfse.getOptional6(), "#"); // 2 Space

		concat(content, tmsNfse.getAwb(), "#"); // 12 Zeros
		concat(content, tmsNfse.getOptional8(), "#"); // 11 Zeros
		concat(content, tmsNfse.getOptional9(), "#"); // 20 Zeros

		content.append("#");

		return content;
	}

	// 107 BarCodeNfse
	public StringBuilder nfseBarCodeValidation(TmsNfseOneZeroOneMapper tmsnfse, String stationcd) {

		StringBuilder content = new StringBuilder();

		concat(content, "107", "#");
		concat(content, tmsnfse.getOptional5(), "#");

		if (tmsnfse.getIssueDateOfRPS() != null) {

			DateTime dateTime = new DateTime(tmsnfse.getIssueDateOfRPS());

			String yyyymmdd = "";
			yyyymmdd = "" + (String.valueOf(dateTime.getYear())
					+ String.valueOf(dateTime.getMonthOfYear() < 10 ? "0" + dateTime.getMonthOfYear()
							: dateTime.getMonthOfYear())
					+ (dateTime.getDayOfMonth() < 10 ? "0" + dateTime.getDayOfMonth() : dateTime.getDayOfMonth()));

			concat(content, yyyymmdd, "#");
		} else {
			concat(content, tmsnfse.getOptional12(), "#");

		}

		concat(content, stationcd, "#");
		concat(content, String.valueOf(tmsnfse.getNfseNumber()), "#");

		concat(content, StringUtils.leftPad(tmsnfse.getNfId().replace(".", ""), 9, "0"), "#");

		concat(content, tmsnfse.getOptional5(), "#"); // 20 Characters
		concat(content, tmsnfse.getOptional4(), "#");
		concat(content, tmsnfse.getOptional5(), "#");
		concat(content, tmsnfse.getOptional10(), "#");
		concat(content, tmsnfse.getOptional6(), "#");
		concat(content, tmsnfse.getOptional11(), "#");

		concat(content, tmsnfse.getOptional12(), "#");
		content.append("#");
		return content;
	}

	// 106NfsePickup
	public StringBuilder nfsePickUpValidation(TmsNfseOneZeroOneMapper tmsnfse, String stationcd) {

		StringBuilder content = new StringBuilder();
		concat(content, "106", "#");
		concat(content, stationcd, "#");
		if (tmsnfse.getIssueDateOfRPS() != null) {// YYYYMMDD Row 9

			DateTime dateTime = new DateTime(tmsnfse.getIssueDateOfRPS());

			String yyyymmdd = "";
			yyyymmdd = "" + (String.valueOf(dateTime.getYear())
					+ String.valueOf(dateTime.getMonthOfYear() < 10 ? "0" + dateTime.getMonthOfYear()
							: dateTime.getMonthOfYear())
					+ (dateTime.getDayOfMonth() < 10 ? "0" + dateTime.getDayOfMonth() : dateTime.getDayOfMonth()));

			concat(content, yyyymmdd, "#");
		} else {
			concat(content, tmsnfse.getOptional12(), "#");

		}

		concat(content, String.valueOf(tmsnfse.getNfseNumber()), "#");
		if (tmsnfse.getIssueDateOfRPS() != null) {// YYYYMMDD Row 9

			DateTime dateTime = new DateTime(tmsnfse.getIssueDateOfRPS());

			String yyyymmdd = "";
			yyyymmdd = "" + (String.valueOf(dateTime.getYear())
					+ String.valueOf(dateTime.getMonthOfYear() < 10 ? "0" + dateTime.getMonthOfYear()
							: dateTime.getMonthOfYear())
					+ (dateTime.getDayOfMonth() < 10 ? "0" + dateTime.getDayOfMonth() : dateTime.getDayOfMonth()));

			concat(content, yyyymmdd, "#");
		} else {
			concat(content, tmsnfse.getOptional12(), "#");

		}

		concat(content, tmsnfse.getOptional13(), "#");
		concat(content, tmsnfse.getOptional12(), "#");
		concat(content, tmsnfse.getOptional12(), "#");
		concat(content, tmsnfse.getOptional12(), "#");
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

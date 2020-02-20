package com.fedex.breco.insurance.utils;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fedex.breco.insurance.dto.CustomerInfoMaster;
import com.fedex.breco.insurance.mapper.TmsNfseInsuranceMapper;
import com.fedex.breco.insurance.repository.CustomerInfoRepo;

@Component
public class TmsNfseInsuranceValidation {

	@Autowired
	CustomerInfoRepo repo;

	public StringBuilder nfseInsuranceValidation(TmsNfseInsuranceMapper tmscte) {

		StringBuilder content = new StringBuilder();

		concat(content, "122", "#");
		CustomerInfoMaster value = repo.findByTaxId(tmscte.getPayerTaxId());
		if (value != null) {
			concat(content, "2", "#");
			concat(content, tmscte.getPayerTaxId().replaceAll("[()?:!/.,;{}-]", ""), "#");// changed to custtaxid
		} else {
			concat(content, "1", "#");
			concat(content, tmscte.getCnpjRespForInsurance().replaceAll("[()?:!/.,;{}-]", ""), "#");
		}

		concat(content, tmscte.getInsurerName(), "#");
		concat(content, tmscte.getCnpjRespForInsuranceRepeat().replaceAll("[()?:!/.,;{}-]", ""), "#");
		concat(content, tmscte.getPolicyNumber(), "#");

		concat(content, tmscte.getEndorsementProtocolNumber(), "#"); // 20 Characters
		if (tmscte.getDateOfAuthorizationOfTheEndorsementProtocol() != null) { // YYYYMMDD

			DateTime dateTime1 = new DateTime(tmscte.getDateOfAuthorizationOfTheEndorsementProtocol());

			String yearMonthDate = "";
			yearMonthDate = "" + (String.valueOf(dateTime1.getYear())
					+ String.valueOf(dateTime1.getMonthOfYear() < 10 ? "0" + dateTime1.getMonthOfYear()
							: dateTime1.getMonthOfYear())
					+ (dateTime1.getDayOfMonth() < 10 ? "0" + dateTime1.getDayOfMonth() : dateTime1.getDayOfMonth()));
			concat(content, yearMonthDate, "#");

		} else {
			concat(content, tmscte.getOptional(), "#");

		}

		if (tmscte.getDateOfAuthorizationOfTheEndorsementProtocol() != null) { // HHMMSS

			DateTime dateTime = new DateTime(tmscte.getDateOfAuthorizationOfTheEndorsementProtocol());
			String time = String
					.valueOf(dateTime.getHourOfDay() < 10 ? "0" + dateTime.getHourOfDay() : dateTime.getHourOfDay())
					+ (String
							.valueOf(dateTime.getMinuteOfHour() < 10 ? "0" + dateTime.getMinuteOfHour()
									: dateTime.getMinuteOfHour())
							+ String.valueOf(dateTime.getSecondOfMinute() < 10 ? "0" + dateTime.getSecondOfMinute()
									: dateTime.getSecondOfMinute()));

			concat(content, time, "#");
		} else {
			concat(content, tmscte.getOptional1(), "#");

		}
		concat(content, tmscte.getPublicProtocolNumber(), "#");

		if (tmscte.getDateOfAuthorizationOfTheEndorsementProtocol() != null) { // YYYYMMDD

			DateTime dateTime1 = new DateTime(tmscte.getDateOfAuthorizationOfTheEndorsementProtocol());

			String yearMonthDate = "";
			yearMonthDate = "" + (String.valueOf(dateTime1.getYear())
					+ String.valueOf(dateTime1.getMonthOfYear() < 10 ? "0" + dateTime1.getMonthOfYear()
							: dateTime1.getMonthOfYear())
					+ (dateTime1.getDayOfMonth() < 10 ? "0" + dateTime1.getDayOfMonth() : dateTime1.getDayOfMonth()));
			concat(content, yearMonthDate, "#");

		} else {
			concat(content, tmscte.getOptional(), "#");

		}

		if (tmscte.getDateOfAuthorizationOfTheEndorsementProtocol() != null) { // HHMMSS

			DateTime dateTime = new DateTime(tmscte.getDateOfAuthorizationOfTheEndorsementProtocol());
			String time = String
					.valueOf(dateTime.getHourOfDay() < 10 ? "0" + dateTime.getHourOfDay() : dateTime.getHourOfDay())
					+ (String
							.valueOf(dateTime.getMinuteOfHour() < 10 ? "0" + dateTime.getMinuteOfHour()
									: dateTime.getMinuteOfHour())
							+ String.valueOf(dateTime.getSecondOfMinute() < 10 ? "0" + dateTime.getSecondOfMinute()
									: dateTime.getSecondOfMinute()));

			concat(content, time, "#");
		} else {
			concat(content, tmscte.getOptional1(), "#");

		}
		concat(content, tmscte.getCteDestinationBranchCNPJ().replaceAll("[()?:!/.,;{}-]", ""), "#");

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
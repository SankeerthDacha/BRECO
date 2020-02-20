package com.fedex.breco.insurance.utils;

import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.XMLGregorianCalendar;

import com.fedex.breco.insurance.atm.model.CTeProc;
import com.fedex.breco.insurance.atm.model.RetCancCTe;

public class InsuranceUtils {

	public static String formatCNPJ(String cnpj) {
		StringBuilder sb = new StringBuilder(cnpj);
		Pattern pattern = Pattern.compile("[.-/]"); 
    	Matcher mt = pattern.matcher(sb);
    	if(!mt.find()) {
    		sb = sb.insert(2, ".").insert(6, ".").insert(10, "/").insert(15, "-");
		}
		return sb.toString();
	}
	
	public static String formatCNPJForStation(String cnpj) {
		StringBuilder sb = new StringBuilder(cnpj);
		Pattern pattern = Pattern.compile("[.-/]"); 
    	Matcher mt = pattern.matcher(sb);
    	if(!mt.find()) {
    		sb = sb.insert(2, ".").insert(6, ".").insert(10, "/").insert(15, ".");
		}
		return sb.toString();
	}

	public static Date convertGregorianCalToDate(XMLGregorianCalendar gCal) {
		SimpleDateFormat formattedDate = new SimpleDateFormat("dd-MMM-yyyy");
		String dateFormatted = formattedDate.format(gCal.toGregorianCalendar().getTime());
		Date dt = null;
		try {
			dt = formattedDate.parse(dateFormatted);
			System.out.println("dt : " + dt);
		} catch (ParseException e) {
			System.out.println("Exception occured in convertGregorianCalToDate : " + e.getMessage());
			e.printStackTrace();
		}
		return dt;
	}

	public static String convertATnMReqToString(CTeProc cTeProc) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(CTeProc.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		StringWriter sw = new StringWriter();
		jaxbMarshaller.setProperty("jaxb.fragment", Boolean.TRUE);
		jaxbMarshaller.marshal(cTeProc, sw);
		String xmlString = sw.toString();

		return xmlString;
	}
	
	public static String convertATnMCancelReqToString(RetCancCTe retCancCTe) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(RetCancCTe.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		StringWriter sw = new StringWriter();
		jaxbMarshaller.setProperty("jaxb.fragment", Boolean.TRUE);
		jaxbMarshaller.marshal(retCancCTe, sw);
		String xmlString = sw.toString();

		return xmlString;
	}
	
	public static int generateRandomDigits(int size) {
		int m = (int) Math.pow(10, size - 1);
		return m + new Random().nextInt(9 * m);
	}

}

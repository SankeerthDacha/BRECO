package com.fedex.breco.insurance.utils;

public class InsuranceConstant {
	
	public static final String CTE = "CTe";
	public static final String NFSE = "NFSe";
	
	//FedEx National registration code which will be fixed for all type of insurance
	public static final String RNTRC ="00117530"; 
	
	public static final int CTe_Mode = 57;
	public static final int NFSe_mode = 98;
	
	public static final String INSURANCE_NUMBER = "em emissao";
	public static int cStat = 100;
	
	public static final String COUNTRY = "BRASIL";
	public static final String COUNTRY_CD= "1058";
	
	public static final String SUCCESSFUL = "SUCCESSFUL";
	public static final String ENDORSED = "ENDORSED";
	public static final String CANCELLED = "CANCELLED";
	public static final String FAILED = "FAILED";
	
	//Added status code to identify not mapped ATnM error codes
	public static final int MAPPING_NOT_FOUND=500;
	public static final int MAPPING_FOUND=200;
	
	//Added for insurance type, 4 - if insurance with FedEx, 5 - If insurance is with customer's choice.
	public static final String FEDEX_TYPE_INSURANCE="4";
	public static final String CUSTOMER_TYPE_INSURANCE="5";
	
	public static final String SUPPORT_TEAM_MSG = "Please contact BRECO Support center. HelpDesk_BR@corp.ds.fedex.com +55 81 3476-0300";
	public static final String APPROVED ="Approved";
}

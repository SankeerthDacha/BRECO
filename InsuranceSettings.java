package com.fedex.breco.insurance.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class InsuranceSettings {
	//@Value("${breco.environment.type:1}")
	private int environmentType;

	//@Value("${breco.atnm.user}")
	private String atnmUser;
	
	//@Value("${breco.atnm.pass}")
	private String atnmPass;
	
	//@Value("${breco.atnm.cod}")
	private String atnmCode;
	
	public int getEnvironmentType() {
		return environmentType;
	}

	public void setEnvironmentType(int environmentType) {
		this.environmentType = environmentType;
	}

	public String getAtnmUser() {
		return atnmUser;
	}

	public void setAtnmUser(String atnmUser) {
		this.atnmUser = atnmUser;
	}

	public String getAtnmPass() {
		return atnmPass;
	}

	public void setAtnmPass(String atnmPass) {
		this.atnmPass = atnmPass;
	}

	public String getAtnmCode() {
		return atnmCode;
	}

	public void setAtnmCode(String atnmCode) {
		this.atnmCode = atnmCode;
	}
}

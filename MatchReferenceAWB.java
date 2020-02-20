package com.fedex.breco.insurance.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "MATCH_REF_AWB")
@Getter
@Setter
public class MatchReferenceAWB implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ISQN_CD")
	private Long matchRefAwbID;
	
	@Column(name = "AWB_NBR")
	private String awbNbr;
	
	@Column(name = "DIM_WGT_SCN_FLG")
	private String dimWeightscanFlg;
	
	@ManyToOne
	@JoinColumn(name = "ISQN_MSTR_CD" ,nullable = false)
	private MatchReference matchReferenceMaster;

	public Long getMatchRefAwbID() {
		return matchRefAwbID;
	}

	public void setMatchRefAwbID(Long matchRefAwbID) {
		this.matchRefAwbID = matchRefAwbID;
	}

	public String getAwbNbr() {
		return awbNbr;
	}

	public void setAwbNbr(String awbNbr) {
		this.awbNbr = awbNbr;
	}

	public String getDimWeightscanFlg() {
		return dimWeightscanFlg;
	}

	public void setDimWeightscanFlg(String dimWeightscanFlg) {
		this.dimWeightscanFlg = dimWeightscanFlg;
	}

	public MatchReference getMatchReferenceMaster() {
		return matchReferenceMaster;
	}

	public void setMatchReferenceMaster(MatchReference matchReferenceMaster) {
		this.matchReferenceMaster = matchReferenceMaster;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}

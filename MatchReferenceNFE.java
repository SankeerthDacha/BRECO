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
@Table(name = "MATCH_REF_NFE")
@Getter
@Setter
public class MatchReferenceNFE implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ISQN_CD")
	private Long matchRefNfeID;

	@Column(name = "NT_FSCL_CD")
	private String nfeKey;

	@Column(name = "PRE_CT_E_CHK_FLG")
	private String preCteCheckFlg;

	@ManyToOne
	@JoinColumn(name = "ISQN_MSTR_CD", nullable = false)
	private MatchReference matchReferenceMaster;

	public Long getMatchRefNfeID() {
		return matchRefNfeID;
	}

	public void setMatchRefNfeID(Long matchRefNfeID) {
		this.matchRefNfeID = matchRefNfeID;
	}

	public String getNfeKey() {
		return nfeKey;
	}

	public void setNfeKey(String nfeKey) {
		this.nfeKey = nfeKey;
	}

	public String getPreCteCheckFlg() {
		return preCteCheckFlg;
	}

	public void setPreCteCheckFlg(String preCteCheckFlg) {
		this.preCteCheckFlg = preCteCheckFlg;
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

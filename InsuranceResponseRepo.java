package com.fedex.breco.insurance.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fedex.breco.insurance.dto.InsuranceResponseMaster;

public interface InsuranceResponseRepo extends JpaRepository<InsuranceResponseMaster, Long> {
	public InsuranceResponseMaster findByCustTaxId(String taxId);

	public InsuranceResponseMaster findByCteKey(@Param(value = "CT_E_CD") String cTeKey);

	public InsuranceResponseMaster findByNfseKey(@Param(value = "NF_SE_CD") String nfseKey);
	
	//   public InsuranceResponseMaster findByIsqnCd(@Param(value = "ISQN_CD") Long isqncd);
	 
	
	@Transactional
	@Modifying
	@Query("update InsuranceResponseMaster ir set ir.errCmplmInfoCd=:errCmplmInfoCd, ir.errCmplmInfoDesc=:errCmplmInfoDesc where ir.cteKey=:cteKey")
	public int updateCteDetails(@Param("cteKey") String cteKey, @Param("errCmplmInfoCd") String errCmplmInfoCd,
			@Param("errCmplmInfoDesc") String errCmplmInfoDesc);

	@Transactional
	@Modifying
	@Query("update InsuranceResponseMaster ir set ir.errCmplmInfoCd=:errCmplmInfoCd, ir.errCmplmInfoDesc=:errCmplmInfoDesc where ir.nfseKey=:nfseKey")
	public int updateNFSeDetails(@Param("nfseKey") String nfseKey, @Param("errCmplmInfoCd") String errCmplmInfoCd,
			@Param("errCmplmInfoDesc") String errCmplmInfoDesc);

}

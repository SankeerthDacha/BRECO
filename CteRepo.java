package com.fedex.breco.insurance.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fedex.breco.insurance.cte.model.CteIdentityMaster;

/**
 * The Interface CteRepo.
 */
public interface CteRepo extends JpaRepository<CteIdentityMaster, Long> {

	public CteIdentityMaster findByCteCode(@Param(value = "CT_E_CD") String cteKey);

	@Query(value = "select c from CteIdentityMaster c where c.cteResponseDetails.statusDescription='Approved' and c.insuranceEndorseStatus is null")
	public List<CteIdentityMaster> fetchNonEndorsedInsurance();

	@Transactional
	@Modifying
	@Query(value = "update CteIdentityMaster c set insuranceEndorseStatus=:insuranceEndorseStatus where cteCode=:cteCode")
	public int updateCTeInsuranceStatus(@Param("insuranceEndorseStatus") String insuranceEndorseStatus, @Param("cteCode") String cteCode);
	
	@Transactional
	@Modifying
	@Query(value = "update CteIdentityMaster c set tmsFileStatus='PROCESSED' where cteCode=:cteCode")
	public int updateTmsStatus(@Param("cteCode") String cteCode);
	
	@Query(value = "update CteIdentityMaster c set tmsFileStatus='CANCELLED' where cteCode=:cteCode")
	public int updateTmsStatusCancellation(@Param("cteCode") String cteCode);

	@Query("select c from CteIdentityMaster c where c.cteProductDetails.notaFiscalKey = :nfeKey")
	public CteIdentityMaster findByNotaFiscalKey(@Param("nfeKey") String nfeKey);
	
	@Query(value = "select c from CteIdentityMaster c where c.cancellationStatus ='Cancelled' and c.insuranceEndorseStatus = 'ENDORSED'")
	public List<CteIdentityMaster> fetchCancelledCTe();
}

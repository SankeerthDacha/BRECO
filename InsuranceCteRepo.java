package com.fedex.breco.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.fedex.breco.insurance.cte.model.InsuranceCteIdentityMaster;
import com.fedex.breco.insurance.dto.InsuranceResponseMaster;

/**
 * The Interface CteRepo.
 */
public interface InsuranceCteRepo extends JpaRepository<InsuranceCteIdentityMaster, Long> {

	public InsuranceCteIdentityMaster findByCteCode(@Param(value = "CT_E_CD") String cTeKey);
	//public InsuranceResponseMaster findByNfseKey(String nfseKey);

}

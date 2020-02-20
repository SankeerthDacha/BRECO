package com.fedex.breco.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fedex.breco.insurance.dto.NfseResponseDetail;

/**
 * The Interface NfseResponseRepo.
 */

public interface TmsNfseResponseRepo extends JpaRepository<NfseResponseDetail, Long> {

	NfseResponseDetail findByRpsId(String nfseNumber);

	@Query(value = "Select RP_S_ID from NFSE_Response_Detail where ISQN_MSTR_CD in (Select ISQN_MSTR_CD from NFSE_Request_Detail where ISQN_REF_CD=:ISQN_REF_CD )", nativeQuery = true)
	String findByMatchRefKey(@Param("ISQN_REF_CD") Long matchReferenceId);

}

package com.fedex.breco.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fedex.breco.insurance.dto.NfseRequestDetail;

public interface NfseRequestRepo extends JpaRepository<NfseRequestDetail, Long> {

	NfseRequestDetail findByRpsId(String nfseNumber);

//	@Query(value = "select n from NfseRequestDetail n where n.matchReferenceMaster.matchReferenceId = :refCode")
//	public NfseRequestDetail getNfse(@Param("refCode") Long refCode);

}

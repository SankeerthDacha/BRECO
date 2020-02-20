package com.fedex.breco.insurance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.fedex.breco.insurance.dto.MatchReference;
import com.fedex.breco.insurance.dto.MatchReferenceNFE;

public interface MatchReferenceNfeRepo extends JpaRepository<MatchReferenceNFE, String> {

//	@Query(value = "select * from match_ref_master where ISQN_MSTR_CD in ()", nativeQuery = true)
	public List<MatchReferenceNFE> findByMatchReferenceMaster(@Param(value = "ISQN_MSTR_CD") MatchReference matchReference);

	
	
}

package com.fedex.breco.insurance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fedex.breco.insurance.dto.MatchReference;
import com.fedex.breco.insurance.dto.MatchReferenceAWB;

@Repository
public interface MatchReferenceAwbRepo extends JpaRepository<MatchReferenceAWB, Long> {

	public List<MatchReferenceAWB> findByMatchReferenceMaster(@Param(value = "ISQN_MSTR_CD")MatchReference matchReference);

	//public AwbCustMaster findNbr(@Param(value = "MSTR_AWB_NBR") String awbMasterNum);
}

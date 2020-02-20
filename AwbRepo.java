package com.fedex.breco.insurance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fedex.breco.insurance.dto.AwbCustMaster;
import com.fedex.breco.insurance.dto.ChildAwbCustMaster;

@Repository
public interface AwbRepo extends JpaRepository<ChildAwbCustMaster, Long> {

	public List<ChildAwbCustMaster> findByMasterAwbNbr(@Param(value = "MSTR_AWB_NBR") String awbMasterNum);

	//public AwbCustMaster findNbr(@Param(value = "MSTR_AWB_NBR") String awbMasterNum);
}

package com.fedex.breco.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fedex.breco.insurance.dto.AwbShpmtDetails;

@Repository
public interface AwbShipmentRepo extends JpaRepository<AwbShpmtDetails, Long> {

	public AwbShpmtDetails findByAwbNbr(@Param(value = "MSTR_AWB_NBR") String awbMasterNum);

	//public AwbCustMaster findNbr(@Param(value = "MSTR_AWB_NBR") String awbMasterNum);
	
	
}

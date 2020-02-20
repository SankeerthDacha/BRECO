package com.fedex.breco.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fedex.breco.insurance.dto.CustomerInfoMaster;

public interface CustomerInfoRepo extends JpaRepository<CustomerInfoMaster, Long>{

	public CustomerInfoMaster findByTaxId(String taxId);
}

package com.fedex.breco.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fedex.breco.insurance.dto.CustomerDetailsMaster;

public interface CustomerDetailsRepo extends JpaRepository<CustomerDetailsMaster, Long> {
	
	public CustomerDetailsMaster findByTaxId(String taxId);
}

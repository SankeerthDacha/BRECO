package com.fedex.breco.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fedex.breco.insurance.nfe.dto.StationLocationDetails;

// TODO: Auto-generated Javadoc
/**
 * The Interface StationLocationRepo.
 */

public interface StationLocationRepo extends JpaRepository<StationLocationDetails, Long> {

	/**
	 * Find by station name.
	 *
	 * @param destLocCd the dest loc cd
	 * @return the station location details
	 */
	StationLocationDetails findByStationName(String destLocCd);

	/**
	 * Find by stationName.
	 *
	 * @param stationName the stationName
	 * @return the station location detail
	 */
	public StationLocationDetails findByStationNameStartingWith(String stationName);

	/**
	 * Find by tax Id .
	 *
	 * @param taxId
	 * @return the station location detail
	 */
	public StationLocationDetails findByTaxId(String taxId);
	
}
package com.fedex.breco.insurance.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fedex.breco.insurance.dto.NfseRequestDetail;

public interface NFSeResponseRepo extends JpaRepository<NfseRequestDetail, Long>{
	public NfseRequestDetail findByRpsId(String NfseKey);
	
	//@Query(value = "select c from NfseRequestDetail c where c.nfseResponseDetail.statusDescription='Approved' and (c.insuranceEndorseStatus != 'PROCESSED' or c.insuranceEndorseStatus is null)")
	@Query(value="select c.* from nfse_request_detail c, nfse_response_detail nrd where nrd.stat_desc='Approved' and c.INS_APRVL_STAT_CD is null and c.rp_s_id = nrd.rp_s_id", nativeQuery = true)
	public List<NfseRequestDetail> fetchNonEndorsedNFSeInsurance();

	@Transactional
	@Modifying
	@Query(value = "update NfseRequestDetail n set insuranceEndorseStatus=:insuranceEndorseStatus where rpsId=:rpsId")
	public int updateNFSeEndorsement(@Param("insuranceEndorseStatus") String insuranceEndorseStatus, @Param("rpsId") String rpsId);
	
	@Transactional
	@Modifying
	@Query(value = "update NfseRequestDetail n set tmsFileStatus='PROCESSED' where rpsId=:rpsId")
	public int updateNFSeTmsStatus(@Param("rpsId") String rpsId);
	
	@Query(value = "update NfseRequestDetail n set tmsFileStatus='CANCELLED' where rpsId=:rpsId")
	public int updateNFSeTmsStatusCancellation(@Param("rpsId") String rpsId);
	
	@Query(value = "select c from NfseRequestDetail c where c.cancellationStatus ='Cancelled' and c.insuranceEndorseStatus = 'ENDORSED'")
	public List<NfseRequestDetail> fetchCancelledNFSe();
	
}
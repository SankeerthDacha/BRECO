package com.fedex.breco.insurance.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.fedex.breco.insurance.dto.MatchReference;
import com.fedex.breco.insurance.model.InsuranceExportModel;
import com.fedex.breco.insurance.model.InsuranceIssuanceModel;

public interface MatchReferenceRepo
		extends PagingAndSortingRepository<MatchReference, Long>, JpaSpecificationExecutor<MatchReference> {
	@Query(nativeQuery = true)
	Page<InsuranceIssuanceModel> getAllInsuranceDetails(@Param("AWB_NBR") String awbNumber,
			@Param("ORIGIN_LOCATION_CD") String stationId, @Param("DEST_LOC_CD") String destnationLocId,
			@Param("CTE_NFSE_CD") String cteNFseCd, @Param("PROTO_NBR") String protocolNbr,
			@Param("INS_RESP_STAT_CD") String status, @Param("DOC_TYP_ID") String docType,
			@Param("CREATE_START_DT") String insuranceStartDate, @Param("CREATE_END_DT") String insuranceEndDate,
			@Param("page") Pageable pageable);

	@Query(nativeQuery = true)
	List<InsuranceExportModel> exportCTeInsurance(@Param("AWB_NBR") String awbNumber,
			@Param("ORIGIN_LOCATION_CD") String stationId, @Param("DEST_LOC_CD") String destnationLocId,
			@Param("CTE_NFSE_CD") String cteNFseCd, @Param("PROTO_NBR") String protocolNbr,
			@Param("INS_RESP_STAT_CD") String status, @Param("DOC_TYP_ID") String docType,
			@Param("CREATE_START_DT") String insuranceStartDate, @Param("CREATE_END_DT") String insuranceEndDate);

	public MatchReference findByMsterMatchRefernceId(Long msterMatchRefernceId);
	
	public List<MatchReference> findByMsterMatchRefernceIdIn(List<Long> msterMatchRefernceId);
}

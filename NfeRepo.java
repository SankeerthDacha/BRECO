package com.fedex.breco.insurance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fedex.breco.insurance.nfe.dto.NfeIdentityMaster;

// TODO: Auto-generated Javadoc
/**
 * The Interface NfeRepository.
 */
public interface NfeRepo extends JpaRepository<NfeIdentityMaster, Long> {

	/**
	 * Find by nfe number and cnpj.
	 *
	 * @param nfeNumber the nfe number
	 * @param cnpj      the cnpj
	 * @return the nota fiscal
	 */
	//public NotaFiscal findByNfeNumberAndCnpj(String nfeNumber, Long cnpj);

	/**
	 * Find by nfe number.
	 *
	 * @param nfeNumber the nfe number
	 * @return the nota fiscal
	 */
	public NfeIdentityMaster findByNotaFiscalKey(String notaFiscalKey);
	
	@Query(value = "select NT_FSCL_CD from NFE_IDENTITY_MASTER", nativeQuery = true)
	public List<String> findAllNotaFiscalKey();
	
	public List<NfeIdentityMaster> findByNotaFiscalKeyIn(List<String> nfeKeyList);

}

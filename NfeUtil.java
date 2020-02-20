package com.fedex.breco.insurance.utils;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fedex.breco.insurance.dto.MatchReferenceNFE;
import com.fedex.breco.insurance.dto.NfseRequestDetail;
import com.fedex.breco.insurance.nfe.dto.NfeIdentityMaster;
import com.fedex.breco.insurance.repository.NfeRepo;

@Component
public class NfeUtil {
	
	@Autowired
	private NfeRepo nfeRepo;
	
	public NfeIdentityMaster getNfeIdentityMaster(NfseRequestDetail nfseRequestDetail) {
		List<MatchReferenceNFE> matchRefNFEList = nfseRequestDetail.getMatchReferenceMaster().getMatchRefernceNfe();
		
		List<String> nfeKeys = new LinkedList<String>();
		matchRefNFEList.forEach(matchReferenceNFE -> {
			nfeKeys.add(matchReferenceNFE.getNfeKey());
		});
		List<NfeIdentityMaster> nfeIdentityMasterList =  nfeRepo.findByNotaFiscalKeyIn(nfeKeys);
		if(nfeIdentityMasterList.size() > 0)
			return nfeIdentityMasterList.get(0); 
		else 
			return null;
	}
}

package com.gxz.bus.service;

import java.util.List;

import com.gxz.bus.domain.Provider;
import com.gxz.bus.vo.ProviderVo;
import com.gxz.sys.utils.json.DataGridView;

public interface ProviderService {
	DataGridView queryAllProvider(ProviderVo providerVo);
	
	Provider queryProviderById(Integer providerId);
	
	void addProvider(ProviderVo providerVo);
	
	void updateProvider(ProviderVo providerVo);
	
	void deleteProvider(Integer providerId);

	List<Provider> queryAllProviderForList(ProviderVo providerVo);
}

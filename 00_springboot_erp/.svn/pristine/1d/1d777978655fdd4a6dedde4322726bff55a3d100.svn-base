package com.gxz.bus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gxz.bus.domain.Provider;
import com.gxz.bus.mapper.ProviderMapper;
import com.gxz.bus.service.ProviderService;
import com.gxz.bus.vo.ProviderVo;
import com.gxz.sys.utils.json.DataGridView;

@Service
public class ProviderServiceImpl implements ProviderService {

	@Autowired
	private ProviderMapper providerMapper;

	@Override
	public DataGridView queryAllProvider(ProviderVo providerVo) {
		Page<Object> page = PageHelper.startPage(providerVo.getPage(), providerVo.getLimit());
		List<Provider> data = providerMapper.queryAllProvider(providerVo);
		return new DataGridView(page.getTotal(), data);
	}
	
	@Override
	public List<Provider> queryAllProviderForList(ProviderVo providerVo) {
		return providerMapper.queryAllProvider(providerVo);
	}

	@Override
	public void addProvider(ProviderVo providerVo) {
		providerMapper.insertSelective(providerVo);
	}

	@Override
	public void updateProvider(ProviderVo providerVo) {
		providerMapper.updateByPrimaryKeySelective(providerVo);
	}

	@Override
	public void deleteProvider(Integer providerId) {
		providerMapper.deleteByPrimaryKey(providerId);
	}

	@Override
	public Provider queryProviderById(Integer providerId) {
		return providerMapper.selectByPrimaryKey(providerId);
	}

	

}

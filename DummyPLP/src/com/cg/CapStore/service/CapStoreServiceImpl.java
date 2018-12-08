package com.cg.CapStore.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.CapStore.dao.ICapStoreDao;
import com.cg.CapStore.dto.Inventory;


@Service("service")
@Transactional
public class CapStoreServiceImpl implements ICapStoreService
{
	@Autowired
	ICapStoreDao dao;
	
	@Override
	public List<Inventory> getProductList() {
		return dao.getProductList();
	}

	@Override
	public void addProducts(Inventory inventory) {
		dao.addProducts(inventory);
		
	}

	@Override
	public Inventory updateProducts(Inventory in) {
		return dao.updateProducts(in);
	}
	
}

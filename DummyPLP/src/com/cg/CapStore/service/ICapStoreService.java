package com.cg.CapStore.service;

import java.util.List;
import com.cg.CapStore.dto.Inventory;

public interface ICapStoreService 
{
	public List<Inventory> getProductList();
	public void addProducts(Inventory inventory);
	public Inventory updateProducts(Inventory in);
}

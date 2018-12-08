package com.cg.CapStore.dao;

import java.util.List;
import com.cg.CapStore.dto.Inventory;

public interface ICapStoreDao 
{
	public List<Inventory> getProductList();
	public void addProducts(Inventory inventory);
	public Inventory updateProducts(Inventory in);
}

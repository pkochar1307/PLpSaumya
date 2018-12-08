package com.cg.CapStore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cg.CapStore.dto.Inventory;


@Repository("dao")
public class CapStoreDaoImpl implements ICapStoreDao
{
	@PersistenceContext
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Inventory> getProductList() {
		Query getQuery = em.createQuery("FROM Inventory");		
		List<Inventory> getProduct = getQuery.getResultList();
		return getProduct;
	}
	@Override
	public void addProducts(Inventory inventory) {
		em.persist(inventory);
		em.flush();
		
	}
	@Override
	public Inventory updateProducts(Inventory in) {
		Inventory inventory = em.find(Inventory.class, in.getProduct_id());
		inventory.setPrice(in.getPrice());
		inventory.setQuantity(in.getQuantity());
		Inventory inven= em.merge(inventory);
		return inven;
	}

	
}

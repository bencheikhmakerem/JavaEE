package org.makerem.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless 

public class CommuneEJB {

	@PersistenceContext(unitName="tp_javaee")
	private EntityManager em;
	
	public Commune findCommuneById(long id) 
	{
		return em.find(Commune.class,id);
	}
	
	public long createCommune(Commune commune)
	{
		em.persist(commune);
		return commune.getId();
	}
	
	public long updateCommuneById(Commune commune)
	{
		 em.merge(commune);
		return commune.getId();
	}
	
	public Boolean deleteCommuneById(long id)
	{
		Commune commune = em.find(Commune.class,id);
		if(commune!=null)
		{
			em.remove(commune);
			return true;
		} else
		   return false;
	}
	
}

package soa.jaxrslabs.booktrainrestwebserviceexcercice2;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TrainTransaction {
	
	@PersistenceContext(name="Catalogue")
	EntityManager em;

	public Train addTrain(Train train) {
		return em.merge(train);
	}

}

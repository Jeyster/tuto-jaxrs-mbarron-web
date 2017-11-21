package soa.jaxrslabs.booktrainrestwebserviceexcercice2;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class TrainTransaction {
	
	@PersistenceContext(name="Catalogue")
	EntityManager em;

	public void addTrain(Train train) {
		em.persist(train);
	}
	
	public List<Train> getTrains() {
		TypedQuery<Train> query = em.createQuery("from " + Train.class.getSimpleName(), Train.class);
		return query.getResultList();
	}

	public Train getTrainById(Integer numTrain) {
		Train train = em.find(Train.class, numTrain);
		return train;
	}

	public List<Train> getTrainsBySearchingCities(String departure, String arrival) {
		TypedQuery<Train> query = em.createQuery("select distinct train from " + Train.class.getSimpleName() + " train where train.villeDepart like '%" + departure +"%' and train.villeArrivee like '%" + arrival +"%'", Train.class);
		return query.getResultList();
	}
	
}

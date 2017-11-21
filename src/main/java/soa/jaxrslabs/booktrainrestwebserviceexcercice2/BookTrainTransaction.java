package soa.jaxrslabs.booktrainrestwebserviceexcercice2;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class BookTrainTransaction {
	
	@PersistenceContext(name="Catalogue")
	EntityManager em;

	public List<BookTrain> getBookTrain() {
		TypedQuery<BookTrain> query = em.createQuery("from " + BookTrain.class.getSimpleName(), BookTrain.class);
		return query.getResultList();
	}

	public void addBookTrain(BookTrain bookTrain) {
		em.merge(bookTrain);
	}

	public BookTrain getBookByNumBook(Integer numBook) {
		BookTrain bookTrain = em.find(BookTrain.class, numBook);
		return bookTrain;
	}

	public BookTrain deleteBookById(Integer numBook) {
		BookTrain bookTrain = this.getBookByNumBook(numBook);
		em.remove(bookTrain);
		return bookTrain;
	}

}

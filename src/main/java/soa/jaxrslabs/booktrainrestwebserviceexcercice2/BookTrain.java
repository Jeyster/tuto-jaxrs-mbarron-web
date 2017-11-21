package soa.jaxrslabs.booktrainrestwebserviceexcercice2;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BookTrain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numBook;
	
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
	private Train currentTrain;
	
	private int numberPlaces;
	
	public Integer getNumBook() {
		return numBook;
	}
	public void setNumBook(Integer numBook) {
		this.numBook = numBook;
	}
	public Train getCurrentTrain() {
		return currentTrain;
	}
	public void setCurrentTrain(Train currentTrain) {
		this.currentTrain = currentTrain;
	}
	public int getNumberPlaces() {
		return numberPlaces;
	}
	public void setNumberPlaces(int numberPlaces) {
		this.numberPlaces = numberPlaces;
	}
	public static BookTrain getBookByNumBook(String numBook) {
		List<BookTrain> books = BookTrainBD.getBookTrains();
		for(BookTrain current : books) {
			if (current.getNumBook().equals(numBook)) {
				return current;			
				}
		}
		return null;
	}
	public static String deleteBookByNumBook(String numBook) {
		List<BookTrain> books = BookTrainBD.getBookTrains();
		for(BookTrain current : books) {
			if (current.getNumBook().equals(numBook)) {
				books.remove(current);
				return numBook;			
				}
		}
		return null;
	}

}

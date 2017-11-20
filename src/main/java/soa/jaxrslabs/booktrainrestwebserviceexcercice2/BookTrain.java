package soa.jaxrslabs.booktrainrestwebserviceexcercice2;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "bookTrain")
public class BookTrain {
	
	private String numBook;
	private Train currentTrain;
	private int numberPlaces;
	
	public String getNumBook() {
		return numBook;
	}
	public void setNumBook(String numBook) {
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

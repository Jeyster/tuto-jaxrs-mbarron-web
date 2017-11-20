package soa.jaxrslabs.booktrainrestwebserviceexcercice2;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/books")
public class BookTrainResource {

	public BookTrainResource() {
	}
	
	@GET
	@Produces("application/xml")
	public Response getBookTrains() {
		List<BookTrain> books = BookTrainBD.getBookTrains();
		List<String> numBooks = new ArrayList<>();
		for (BookTrain book : books) {
			numBooks.add(book.getNumBook());
		}
		
		return Response
				.status(Status.OK)
				.entity("<books>" + numBooks + "</books>")
				.build();
	}
	
	@POST
	//@Produces("application/xml")
	public Response createBookTrain(@QueryParam("numTrain") String numTrain, @QueryParam("numberPlaces") int numberPlaces) {
		Train train = Train.getTrainByNumTrain(numTrain);
		
		BookTrain bookTrain = new BookTrain();
		bookTrain.setCurrentTrain(train);
		bookTrain.setNumberPlaces(numberPlaces);
		bookTrain.setNumBook(Long.toString(System.currentTimeMillis()));
		
		if (train != null && numberPlaces != 0) {
			BookTrainBD.getBookTrains().add(bookTrain);
		}
		
		return Response
				.status(Status.OK)
				.entity(bookTrain.getNumBook())//.entity("<books> Book number : " + bookTrain.getNumBook() + ", Train : " + bookTrain.getCurrentTrain().getNumTrain() + ", Nombre de places : " + bookTrain.getNumberPlaces() + "</books>")
				.build();
	}
	
	
	@GET
	@Path("/{numBook}")
	public Response getBookTrain(@PathParam("numBook") String numBook) {
		BookTrain book = BookTrain.getBookByNumBook(numBook);
		return Response
				.status(Status.OK)
				.entity("<train>" + book + "</train>")
				.build();			

	}
	
	@DELETE
	@Path("/{numBook}")
	public Response deleteBookTrain(@PathParam("numBook") String numBook) {
		BookTrain.deleteBookByNumBook(numBook);
		return Response
				.status(Status.OK)
				.entity("<train>" + numBook + "</train>")
				.build();	
	}
	
	

}

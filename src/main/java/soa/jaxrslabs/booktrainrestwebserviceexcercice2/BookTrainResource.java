package soa.jaxrslabs.booktrainrestwebserviceexcercice2;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("books")
@Produces("application/json")
public class BookTrainResource {

	public BookTrainResource() {
	}
	
	@EJB
	private BookTrainTransaction bt;
	
	@EJB
	private TrainTransaction tt;
	
	@GET
	public Response getBookTrains() {
		List<BookTrain> books = bt.getBookTrain();
		
		return Response
				.status(Status.OK)
				.entity(books)
				.build();
	}
	
	@POST
	public Response createBookTrain(@QueryParam("numTrain") Integer numTrain, @QueryParam("numberPlaces") int numberPlaces) {
		Train train = tt.getTrainById(numTrain);
		
		BookTrain bookTrain = new BookTrain();
		bookTrain.setCurrentTrain(train);
		bookTrain.setNumberPlaces(numberPlaces);
		
		bt.addBookTrain(bookTrain);
		
		return Response
				.status(Status.OK)
				.entity(bookTrain)
				.build();
	}
	
	@GET
	@Path("{numBook}")
	public Response getBookTrainById(@PathParam("numBook") Integer numBook) {
		BookTrain book = bt.getBookByNumBook(numBook);
		return Response
				.status(Status.OK)
				.entity(book)
				.build();			

	}
	
	@DELETE
	@Path("{numBook}")
	public Response deleteBookTrainById(@PathParam("numBook") Integer numBook) {
		BookTrain bookTrain = bt.deleteBookById(numBook);
		return Response
				.status(Status.OK)
				.entity(bookTrain)
				.build();	
	}
	
	

}

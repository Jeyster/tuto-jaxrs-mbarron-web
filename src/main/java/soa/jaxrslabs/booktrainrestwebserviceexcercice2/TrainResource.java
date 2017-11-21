package soa.jaxrslabs.booktrainrestwebserviceexcercice2;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("trains")
@Produces(MediaType.APPLICATION_JSON)
public class TrainResource {

	public TrainResource() {
	}
	
	@EJB
	private TrainTransaction tt;

	@OPTIONS
	public Response getOptions() {
		return Response.ok()
				.header("Access-Control-Allow-Origin", "http://localhost:4200")
				.header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
				.header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, Access-Control-Allow-Origin").build();
	}
	
	@POST
	public Response createTrain(@QueryParam("departure") String departure, @QueryParam("arrival") String arrival, @QueryParam("departureTime") int departureTime) {
		Train train = new Train();
		
		train.setVilleDepart(departure);
		train.setVilleArrivee(arrival);
		train.setHeureDepart(departureTime);
		
		tt.addTrain(train);
		
		return Response
				.status(Status.OK)
				.entity(train)
				.build();
	}
	
	@GET
	public Response getTrains() {
		List<Train> trains = tt.getTrains();		
		return Response
				.status(Status.OK)
				.header("Access-Control-Allow-Origin", "http://localhost:4200")
				.header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
				.header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, Access-Control-Allow-Origin")
				.entity(trains)
				.build();
	}
	
	@GET
	@Path("{numTrain}")
	public Response getTrainByNumTrain(@PathParam("numTrain") Integer numTrain) {
		Train train = tt.getTrainById(numTrain);
		return Response
				.status(Status.OK)
				.entity(train)
				.build();			

	}
	
	@GET
	@Path("search")
	public Response getTrainsBySearchingCities(@QueryParam("departure") String departure
			, @QueryParam("arrival") String arrival) {
		
		List<Train> trains = tt.getTrainsBySearchingCities(departure, arrival);
        
        return Response
          .status(Status.OK)
          .entity(trains)
          .build();
		
	}

}

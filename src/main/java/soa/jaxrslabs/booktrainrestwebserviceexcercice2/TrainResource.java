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
				.header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, Origin, Access-Control-Allow-Origin")
				.header("Content-Type", "application/json")
				.build();
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
				.header("Access-Control-Allow-Origin", "http://localhost:4200")
				.header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
				.header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, Access-Control-Allow-Origin")
				.entity(train)
				.build();
	}

	@POST
	@Path("new-train")
	@Consumes(MediaType.APPLICATION_JSON)
	public Train createNewTrain(Train train) {

		System.out.println("!!! ID : " + train.getNumTrain() + " !!!");
		System.out.println("!!! Departure : " + train.getVilleDepart() + " !!!");

		return tt.addTrain(train);

	}

	/*
	@POST
	@Path("new-train")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createNewTrain(Train train) {

		System.out.println("!!! ID : " + train.getNumTrain() + " !!!");
		System.out.println("!!! Departure : " + train.getVilleDepart() + " !!!");

		tt.addTrain(train);

		return Response
				.status(Status.OK)
				.header("Access-Control-Allow-Origin", "http://localhost:4200")
				.header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
				.header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, Origin, Access-Control-Allow-Origin")
				.header("Content-Type", "application/json")
				.entity(train)
				.build();
	}
	*/
	
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
	public Response getTrainByNumTrain(@PathParam("numTrain") int numTrain) {
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

package soa.jaxrslabs.booktrainrestwebserviceexcercice2;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("trains")
@Produces("application/json")
public class TrainResource {

	public TrainResource() {
	}
	
	@EJB
	private TrainTransaction tt;
	
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

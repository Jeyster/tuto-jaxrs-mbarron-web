package soa.jaxrslabs.booktrainrestwebserviceexcercice2;

import java.util.List;

import javax.ws.rs.GET;  
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("trains")
@Produces("application/xml")
public class TrainResource {

	public TrainResource() {
	}
	
	@GET
	public Response getTrains() {
		System.out.println("getTrains : " + BookTrainBD.getTrains());		
		return Response
				.status(Status.OK)
				.entity("<trains>" + BookTrainBD.getTrains() + "</trains>")
				.build();
	}
	
	@GET
	@Path("{numTrain}")
	public Response getTrainByNumTrain(@PathParam("numTrain") String numTrain) {
		Train train = Train.getTrainByNumTrain(numTrain);
		return Response
				.status(Status.OK)
				.entity("<train>" + train + "</train>")
				.build();			

	}
	
	@GET
	@Path("search")
	public Response getTrainsBySearch(@QueryParam("departure") String departure
			, @QueryParam("arrival") String arrival
			, @QueryParam("departureHour") int departureHour) {
		
		List<Train> trains = Train.getTrainsBySearch(departure, arrival, departureHour);
        
        return Response
          .status(Status.OK)
          .entity("<trains>" + trains + "</trains>")
          .build();
		
	}
	
	

}

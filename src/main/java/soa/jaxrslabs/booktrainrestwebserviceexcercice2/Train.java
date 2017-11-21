package soa.jaxrslabs.booktrainrestwebserviceexcercice2;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Train {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numTrain;
	
	private String villeDepart;
	
	private String villeArrivee;
	
    private Integer heureDepart; // Format : 1230 = 12h30

    public Integer getNumTrain() {
		return numTrain;
	}

	public void setNumTrain(Integer numTrain) {
		this.numTrain = numTrain;
	}

	public String getVilleDepart() {
		return villeDepart;
	}

	public void setVilleDepart(String villeDepart) {
		this.villeDepart = villeDepart;
	}

	public String getVilleArrivee() {
		return villeArrivee;
	}

	public void setVilleArrivee(String villeArrivee) {
		this.villeArrivee = villeArrivee;
	}

	public int getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(int heureDepart) {
		this.heureDepart = heureDepart;
	}
    
	public static Train getTrainByNumTrain(String numTrain) {
		List<Train> trains = BookTrainBD.getTrains();
		for(Train current : trains) {
			if (current.getNumTrain().equals(numTrain)) {
				return current;			
				}
		}
		return null;
	}

	public static List<Train> getTrainsBySearch(String departure, String arrival, int departureHour) {
        System.out.println("!!! searchTrainsByCriteria !!!");
        
        System.out.println("Departure : " + departure);
        System.out.println("Arrival : " + arrival);
        System.out.println("Departure Hour : " + departureHour);
        
        List<Train> trains = BookTrainBD.getTrains();
        List<Train> results1 = new ArrayList<>();
        List<Train> results2 = new ArrayList<>();
        List<Train> results3 = new ArrayList<>();
                
        if (departure != null) {
        	for (Train current : trains) {
        		if (departure.equals(current.getVilleDepart())) {
        			results1.add(current);
        		}
        	}
        }
        else {
        	results1.addAll(trains);
        }
        
        if (arrival != null) {
        	for (Train current : results1) {
        		if (arrival.equals(current.getVilleArrivee())) {
        			results2.add(current);
        		}
        	}
        }
        else {
        	results2.addAll(results1);
        }
        
        if (departureHour != 0) {
        	for (Train current : results2) {
        		if (departureHour == current.getHeureDepart()) {
        			results3.add(current);
        		}
        	}
        }
        else {
        	results3.addAll(results2);
        }
        
        return results3;
	}
	
}

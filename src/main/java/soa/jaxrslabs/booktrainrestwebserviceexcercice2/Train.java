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

	
}

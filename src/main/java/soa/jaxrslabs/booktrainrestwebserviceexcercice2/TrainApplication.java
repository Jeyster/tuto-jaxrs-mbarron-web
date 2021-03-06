package soa.jaxrslabs.booktrainrestwebserviceexcercice2;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("api")
public class TrainApplication extends Application{

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> s = new HashSet<Class<?>>();
		s.add(TrainResource.class);
		s.add(BookTrainResource.class);
		return s;
	}
	
}

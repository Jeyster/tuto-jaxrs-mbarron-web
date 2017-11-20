package soa.jaxrslabs.booktrainrestwebserviceexcercice2;

import java.util.ArrayList;
import java.util.List;

public class BookTrainBD {
	
    private static List<Train> trains = new ArrayList<Train>();

    private static List<BookTrain> bookTrains = new ArrayList<BookTrain>();

    static {
    }

    public static List<Train> getTrains() {
        return trains;
    }

    public static List<BookTrain> getBookTrains() {
        return bookTrains;
    }

}

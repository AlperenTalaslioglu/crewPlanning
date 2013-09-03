import java.util.ArrayList;

public class DataRetriever {

	protected static Flight[] flights;
	protected static Crew[] crews;

	public DataRetriever() {
		this.flights = generateFlights();
		this.crews = generateCrews();
	}

	public Crew[] generateCrews() {
		Crew[] crewList = new Crew[fetchCrewsList().length];
		for (int i = 0; i < fetchCrewsList().length; i++) {
			crewList[i] = new Crew(fetchCrewsList()[i]);
		}
		return crewList;
	}

	public Flight[] generateFlights() {
		Flight[] flightList = new Flight[fecthFlightsList().length];
		for (int i = 0; i < fecthFlightsList().length; i++) {
			flightList[i] = new Flight(fecthFlightsList()[i]);
		}
		return flightList;
	}

	public String[] fetchCrewsList() {
		return new String[] { "Michael E. Armagost", "Frederick J. Beetcher",
				"Thomas D. Bentsen", "Edward F. Bindon", "Thomas D. Borgeson",
				"Oliver J. Champeau", "Nolan S. Church", "Ransom E. Cundy",
				"Thomas E. Edwards", "Russell G. Haskell", "George J. Holl",
				"Bruce L. Hudson", "Allen G. Kalmon","SAVE CREWS" };
	}

	public String[] fecthFlightsList() {
		return new String[] { "AA5544", "BB0099", "DD9912", "TR1134", "RR1257",
				"GL1346" };
	}

}

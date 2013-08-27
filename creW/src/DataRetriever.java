import java.util.ArrayList;

public class DataRetriever {

	protected static ArrayList<Flight> flights;
	protected static ArrayList<Crew> crews;

	public DataRetriever() {
		this.flights = generateFlightsList();
		this.crews = generateCrewsList();
	}

	private ArrayList<Crew> generateCrewsList() {
		ArrayList<Crew> crewsList = new ArrayList<Crew>();
		for(int i = 0; i<fetchCrewsList().length; i++){
			crewsList.add(new Crew(fetchCrewsList()[i]));
		}		
		return crewsList;
	}

	private ArrayList<Flight> generateFlightsList() {
		ArrayList<Flight> flightList = new ArrayList<Flight>();
		for (int i = 0; i < fecthFlightsList().length; i++) {
			flightList.add(new Flight(fecthFlightsList()[i]));
		}
		return flightList;
	}

	public static String[] fetchCrewsList() {
		return new String[] { "Michael E. Armagost", "Frederick J. Beetcher",
				"Thomas D. Bentsen", "Edward F. Bindon", "Thomas D. Borgeson",
				"Oliver J. Champeau", "Nolan S. Church", "Ransom E. Cundy",
				"Thomas E. Edwards", "Russell G. Haskell", "George J. Holl",
				"Bruce L. Hudson", "Allen G. Kalmon" };
	}

	public static String[] fecthFlightsList() {
		return new String[] { "AA5544", "BB0099", "DD9912", "TR1134", "RR1257",
				"GL1346" };
	}

}

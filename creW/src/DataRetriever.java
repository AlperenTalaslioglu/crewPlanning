public class DataRetriever {

	protected static String[] flights;
	protected static String[] crews;

	public DataRetriever() {
		this.flights = fecthFlightsList();
		this.crews = fetchCrewsList();
	}

	private String[] fetchCrewsList() {
		return new String[] { "Michael E. Armagost", "Frederick J. Beetcher",
				"Thomas D. Bentsen", "Edward F. Bindon", "Thomas D. Borgeson",
				"Oliver J. Champeau", "Nolan S. Church", "Ransom E. Cundy",
				"Thomas E. Edwards", "Russell G. Haskell", "George J. Holl",
				"Bruce L. Hudson", "Allen G. Kalmon" };
	}

	private String[] fecthFlightsList() {
		return new String[] { "AA5544", "BB0099", "DD9912", "TR1134", "RR1257",
				"GL1346" };
	}

	public String[] getFlights() {
		return flights;
	}

	public String[] getCrews() {
		return crews;
	}
	

}

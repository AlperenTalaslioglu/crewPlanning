public class Crew {
	private String crewName;
	private int crewID;

	// constructor
	public Crew(String crewName, int crewID) {
		this.crewName = crewName;
		this.crewID = crewID;
	}

	// getter and setter
	public String getCrewName() {
		return crewName;
	}

	public void setCrewName(String crewName) {
		this.crewName = crewName;
	}

	public String toString() {
		return "Crew [crewName=" + crewName + "]";
	}

}

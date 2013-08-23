
public class Crew {
	private String crewName;
	
	public Crew(String crewName){
		this.crewName = crewName;
	}

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

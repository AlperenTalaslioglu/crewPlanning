
public class Flight {
	private String flightNo;
	
	//constructor
	public Flight(String flightNo){
		this.flightNo = flightNo;
	}

	//getter and setter
	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	
	public String toString() {
		return "Flight [flightNo=" + flightNo + "]";
	}

}

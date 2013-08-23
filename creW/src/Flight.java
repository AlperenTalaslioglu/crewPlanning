
public class Flight {
	private String flightNo;
	
	public Flight(String flightNo){
		this.flightNo = flightNo;
	}

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

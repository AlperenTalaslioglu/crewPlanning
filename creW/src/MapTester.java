import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MapTester {

	public static void main(String[] args) {

		// Flight fly1 = new Flight("AA5623");
		// Crew crew1 = new Crew("Alperen",0);
		// Crew crew2 = new Crew("Özmen",1);
		//
		// // Map<Flight, Crew> map = new HashMap<Flight, Crew>();
		// // map.put(fly1, crew1);
		//
		// Map crewMap = new HashMap();
		// crewMap.put(0, crew1);
		// crewMap.put(2, crew2);
		//
		//
		// Map<String, Map> flight = new HashMap<String,Map>();
		// flight.put(fly1.getFlightNo(), crewMap);
		//
		// System.out.println(flight.get("AA5623"));

//		DataRetriever data = new DataRetriever();
//
//		Map<Flight, Crew> map = new HashMap<Flight, Crew>();
//		for (int i = 0; i < data.flights.size(); i++) {
//			map.put(data.flights.get(i), data.crews.get(i));
//		}
//
//		for (int i = 0; i < map.size(); i++) {
//			System.out.println(map + " - " + map.get(data.flights.get(i)));
//		}
		
		
//		Set<Crew> crews = new HashSet<Crew>();
//		crews.add(new Crew("alperen"));
//		crews.add(new Crew("özmen"));
//		
//		
//		Set<Crew> crews2 = new HashSet<Crew>();
//		crews2.add(new Crew("alperenttt"));
//		crews2.add(new Crew("özmennn"));
//		
//		Set cr = new HashSet();
//		
//		
//		//System.out.println(crews);
//		
////		Map<Flight,Set<Crew>> fly = new HashMap<Flight,Set<Crew>>();
////		fly.put(new Flight("aa932120"), crews);
////		
////		//System.out.println(fly.get("aa932120"));
////		System.out.println(fly);
//		
//		Map fly = new HashMap();
//		fly.put("aa932129", crews);
//		fly.put("oo123456", crews2);
//		
//		
//
//		for(Crew c : crews){
//		System.out.println(c.getCrewName());
//		
//		if(c.getCrewName().equals("alperen")){
//			crews.remove(c);
//		}
//		
//		}
//		
//		System.out.println(crews);
		
		Map mp = new HashMap();
		mp.put(new Flight("1"), new Crew("2"));
		

		
		

	}
}

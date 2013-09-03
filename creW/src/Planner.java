import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.beans.EventHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.SingleSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("unused")
public class Planner {
	private static JPanel mainPanel = new JPanel();
	private static Map map = new HashMap();
	public static JList crewList;
	public static JList flightList;
	public static DataRetriever data;

	public static void main(String[] args) {

		JFrame mainFrame = new JFrame("Cabin Crew Planning");
		mainFrame.setSize(500, 400);
		generateMainPanel();
		mainFrame.add(mainPanel);
		mainFrame.setResizable(false);
		// center the frame in screen
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		mainFrame.setLocation((d.width - mainFrame.getSize().width) / 2,
				(d.height - mainFrame.getSize().height) / 2);
		mainFrame.setVisible(true);
	}

	private static void generateMainPanel() {
		// main panel layout
		GridLayout mainPanelGrid = new GridLayout(1, 2);
		mainPanel.setLayout(mainPanelGrid);

		// generating data source
		data = new DataRetriever();
		initMap(data); // map initialization

		// Flights and crews
		flightList = new JList(data.generateFlights());
		flightList.setBorder(generateBorder("Flights"));

		crewList = new JList(data.generateCrews());
		crewList.setBorder(generateBorder("Crews"));

		// listener to match flight-crew
		flightList.addListSelectionListener(new FlightListener());
		crewList.addListSelectionListener(new CrewListener());

		mainPanel.add(flightList);
		mainPanel.add(crewList);
		
	
	//		System.out.println(map);
	
	}

	private static void initMap(DataRetriever data) {
		Crew tempCrew = null;
		for (int i = 0; i < data.generateFlights().length; i++) {
			map.put(data.fecthFlightsList()[i], tempCrew);
		}
	}

	private static Border generateBorder(String name) {
		LineBorder roundedLineBorder = new LineBorder(Color.black, 1, true);
		TitledBorder roundedTitledBorder = new TitledBorder(roundedLineBorder,name);
		return roundedTitledBorder;
	}
	
	public static void selectCrew(){
		Crew temp =  (Crew) map.get(crewList.getSelectedValue().toString());
		System.out.println(temp);
	}

	public static void selectCrewOfFlight() {
		
		if (map.get(flightList.getSelectedValue().toString()) == null){
			getCrewList();
		}else{
			getSelectedCrewList();
		}
		
	}

	private static void getSelectedCrewList() {
		crewList.setSelectedIndex(getCrewsIndex());
	}

	private static int getCrewsIndex() {
		int index;
		
		System.out.println(map.get(flightList.getSelectedValue().toString()));
		
		return 0;
	}

	private static void getCrewList() {
		crewList.removeSelectionInterval(0,data.generateCrews().length);
	}
	

}





// JList Listeners

class FlightListener implements ListSelectionListener {
	@Override
	public void valueChanged(ListSelectionEvent event) {
		if (!event.getValueIsAdjusting()){// to prevent duplicate selection same element
			Planner.selectCrewOfFlight();
		}
	}
}

class CrewListener implements ListSelectionListener {
	private static List crewList;
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		
		if (!e.getValueIsAdjusting()){// to prevent duplicate selection same element
			Planner.selectCrew();
	    }
	}



}
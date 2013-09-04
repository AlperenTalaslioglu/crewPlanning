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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.EventHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
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

/**
 * @author ALPEREN TALASLIOÐLU
 *
 */

@SuppressWarnings("unused")
public class Planner {
	public static JPanel mainPanel = new JPanel();
	public static Map map = new HashMap();
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
		mainFrame.setLocation((d.width - mainFrame.getSize().width) / 2,(d.height - mainFrame.getSize().height) / 2);
		mainFrame.setVisible(true);
	}

	/**
	 * Method generates a panel that contains everthing that is called MailPanel
	 */
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
		CrewListener cList = new CrewListener();
		crewList.addListSelectionListener(cList);
		crewList.addMouseListener(cList);
		
		mainPanel.add(flightList);
		mainPanel.add(crewList);
	}

	
	/** 
	 * @param data
	 * Method for initializing the Map with Flight and Crew objects
	 */
	private static void initMap(DataRetriever data) {		
		Crew tempCrew = null;
		for (int i = 0; i < data.generateFlights().length; i++) {
			map.put(data.fecthFlightsList()[i], tempCrew);
		}
	}

	/** 
	 * @param name
	 * Method for generating border for panels with only parameter name
	 */
	private static Border generateBorder(String name) {
		LineBorder roundedLineBorder = new LineBorder(Color.black, 1, true);
		TitledBorder roundedTitledBorder = new TitledBorder(roundedLineBorder,name);
		roundedTitledBorder.setTitleJustification(TitledBorder.CENTER);
		return roundedTitledBorder;
	}

	/** 
	 * @param indice
	 * Method called by FlightListListener to choose flight in the list
	 */
	@SuppressWarnings("unchecked")
	public static void selectFlight(int indice) {
		flightList.setSelectedIndex(indice);	
		if(map.get(flightList.getSelectedValue().toString()) == null){
			crewList.removeSelectionInterval(0, data.generateCrews().length);
		}else{
			crewList.setSelectedIndex(getCrewsIndex());
		}		
	}

	/**
	 * Method for finding flight's crew's index to show selection
	 */
	private static int getCrewsIndex() {
		int index = 0;
		for (int i = 0; i < data.fetchCrewsList().length; i++) {
			if (data.fetchCrewsList()[i].equals((map.get(flightList
					.getSelectedValue().toString()).toString()))) {
				index = i;
				}
		}
		return index;
	}
	
	/** 
	 * Method for slecting crew and updating the map value of flight
	 */
	public static void selectCrew() {
		if(map.get(crewList.getSelectedValue()) == null){
			if(map.get(flightList.getSelectedValue()) == null){
				map.put(flightList.getSelectedValue().toString(),crewList.getSelectedValue());
			}			
		}
		System.out.println(Planner.map);
	}
	
}

/** 
 * Listener classes of CrewList and FlightList 
 */

class FlightListener implements ListSelectionListener  {
	@Override
	public void valueChanged(ListSelectionEvent event) {
		Planner.selectFlight(((JList) event.getSource()).getSelectedIndex());
	}
}

class CrewListener extends MouseAdapter implements ListSelectionListener {
	public static int counter = 0; // counter for unsellect option
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {// to prevent duplicate selection same element in list click
			Planner.selectCrew();
		}
	}
	

    /* (non-Javadoc)
     * @see java.awt.event.MouseAdapter#mousePressed(java.awt.event.MouseEvent)
     */
    public void mousePressed(MouseEvent e) {
       	counter++;
    	if(((counter%2) == 0) &&(counter > 0)){
    		Planner.map.put((Planner.flightList.getSelectedValue().toString()), null);
    		Planner.crewList.clearSelection();
    	}
     }

}

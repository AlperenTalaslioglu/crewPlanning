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
import javax.swing.DefaultListSelectionModel;
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
 * @author ALPEREN TALASLIO�LU
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
		mainFrame.setLocation((d.width - mainFrame.getSize().width) / 2,
				(d.height - mainFrame.getSize().height) / 2);
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

		// for multiple selection and deselection
		crewList.setSelectionModel(new DefaultListSelectionModel() {
			private int firstIndex = -1;
			private int lastIndex = -1;

			public void setSelectionInterval(int indice1, int indice2) {
				if (firstIndex == indice1 && lastIndex == indice2) {
					if (getValueIsAdjusting()) {
						setValueIsAdjusting(false);
						setSelection(indice1, indice2);
					}
				} else {
					firstIndex = indice1;
					lastIndex = indice2;
					setValueIsAdjusting(false);
					setSelection(indice1, indice2);
				}
			}

			private void setSelection(int indice1, int indice2) {
				if (super.isSelectedIndex(indice1)) {
					super.removeSelectionInterval(indice1, indice2);
					Set<Crew> tempCrewRemoveSet = new HashSet<Crew>(crewList.getSelectedValuesList());
					map.put(flightList.getSelectedValue().toString(),tempCrewRemoveSet);
				} else {
					super.addSelectionInterval(indice1, indice2);
					Set<Crew> tempCrewSet = new HashSet<Crew>(crewList.getSelectedValuesList());
					map.put(flightList.getSelectedValue().toString(),tempCrewSet);
				}
			}
		});

		mainPanel.add(flightList);
		mainPanel.add(crewList);
	}

	/**
	 * @param data
	 * Method for initializing the Map with Flight and Crew objects
	 */
	private static void initMap(DataRetriever data) {
		for (int i = 0; i < data.generateFlights().length; i++) {
			map.put(data.flights[i].toString(), new HashSet());
		}
	}

	/**
	 * @param name
	 *Method for generating border for panels with only parameter name
	 */
	private static Border generateBorder(String name) {
		LineBorder roundedLineBorder = new LineBorder(Color.black, 1, true);
		TitledBorder roundedTitledBorder = new TitledBorder(roundedLineBorder,
				name);
		roundedTitledBorder.setTitleJustification(TitledBorder.CENTER);
		return roundedTitledBorder;
	}

	/**
	 * @param selectedFlight
	 * To get flight and it's crews
	 */
	public static void getFlight(int selectedFlight) {
		flightList.setSelectedIndex(selectedFlight);
		Set<Crew> tempCrewSelectionRemoveSet = (Set<Crew>) map.get(flightList.getSelectedValue().toString());		

		if (tempCrewSelectionRemoveSet.isEmpty()) {
			crewList.removeSelectionInterval(0, data.generateCrews().length);
		} else {
			crewList.setSelectedIndices(getCrewsIndices());
		}
	}

	/**
	 * To get indices of crews for a flight
	 */
	private static int[] getCrewsIndices() {
		Set s = (Set<Crew>) map.get(flightList.getSelectedValue().toString());
		int[] selectedIndices = new int[s.size()];

		for(int i = 0; i<s.size(); i++){
			for(int j=0; j<data.fetchCrewsList().length; j++){
				if(data.fetchCrewsList()[j].toString().equals((s.toArray()[i]).toString())){
					selectedIndices[i] = j;
				}
			}			
		}		
		return selectedIndices;
	}

}

/**
 * Listener class of FlightList
 */

class FlightListener implements ListSelectionListener {
	@Override
	public void valueChanged(ListSelectionEvent event) {
		if (!event.getValueIsAdjusting()) {// to prevent duplicate selection same element in list click
			Planner.getFlight(((JList) event.getSource()).getSelectedIndex());
		}
	}
}
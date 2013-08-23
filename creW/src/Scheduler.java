import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.SingleSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Scheduler {
	private static JPanel mainPanel;
	
	public static void main(String[] args) {

		JFrame mainFrame = new JFrame("Cabin Crew Planning");
		mainFrame.setSize(500,400);
		mainFrame.add(getMainPanel());
		mainFrame.setResizable(false);
		mainFrame.setVisible(true);
	}

	private static JPanel getMainPanel() {
		mainPanel =  new JPanel();
		GridLayout mainPanelGrid = new GridLayout(1,2);
		mainPanel.setLayout(mainPanelGrid);
		setPanelsToMainPanel(getMainPanelComponents());
		return mainPanel;
		}

	private static void setPanelsToMainPanel(JPanel[] components) {
		for(int i = 0; i<components.length; i++){
			mainPanel.add(getMainPanelComponents()[i]);
		}		
	}

	private static JPanel[] getMainPanelComponents() {
		//Flights 
		JPanel flightPanel = new JPanel();
		LineBorder roundedLineFlightBorder = new LineBorder(Color.black, 1, true);
		TitledBorder roundedFlightTitledBorder = new TitledBorder(roundedLineFlightBorder, "Flights");
		flightPanel.setBorder(roundedFlightTitledBorder);
		String[] flights = {"AA5544","BB0099","DD9912","TR1134","RR1257","GL1346"}; // flights' codes
		@SuppressWarnings({ "unchecked", "rawtypes" })
		JList flightList = new JList(flights);
		flightList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		flightPanel.setLayout( new BorderLayout() );
		flightPanel.add(flightList);
		
		
		//Crews
		JPanel crewPanel = new JPanel();
		LineBorder roundedLineCrewBorder = new LineBorder(Color.black, 1, true);
		TitledBorder roundedCrewTitledBorder = new TitledBorder(roundedLineCrewBorder, "Crews");
		crewPanel.setBorder(roundedCrewTitledBorder);
		String[] crews = {"Michael E. Armagost","Frederick J. Beetcher","Thomas D. Bentsen","Edward F. Bindon","Thomas D. Borgeson",
				"Oliver J. Champeau","Nolan S. Church","Ransom E. Cundy","Thomas E. Edwards","Russell G. Haskell","George J. Holl",
				"Bruce L. Hudson","Allen G. Kalmon",
		};
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JList crewList = new JList(crews);
		crewList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		crewPanel.setLayout(new BorderLayout());
		crewPanel.add(crewList);
		
		
		return new JPanel[]{flightPanel, crewPanel};
	}	
}

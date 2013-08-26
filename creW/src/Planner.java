import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

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

@SuppressWarnings("unused")
public class Planner {
	private static JPanel mainPanel = new JPanel();

	public static void main(String[] args) {
		JFrame mainFrame = new JFrame("Cabin Crew Planning");
		mainFrame.setSize(500, 400);
		mainFrame.add(getMainPanel());
		mainFrame.setResizable(false);
		mainFrame.setVisible(true);
	}

	private static JPanel getMainPanel() {
		// mainPanel = new JPanel();
		GridLayout mainPanelGrid = new GridLayout(1, 2);
		mainPanel.setLayout(mainPanelGrid);   
		setPanelsToMainPanel(getMainPanelComponents());
		return mainPanel;
	}

	private static void setPanelsToMainPanel(List<JPanel> list) {
		for (int i = 0; i < list.size(); i++) {
			mainPanel.add(getMainPanelComponents().get(i));
		}
	}

	private static List<JPanel> getMainPanelComponents() {
		// Generating data storage
		DataRetriever data = new DataRetriever();

		// Flights and Crews
		JPanel flightPanel = getPanel("Flights", data.getFlights(), 0);
		JPanel crewPanel = getPanel("Crews", data.getCrews(), 2);

		List<JPanel> panelList = new ArrayList<JPanel>();
		panelList.add(flightPanel);
		panelList.add(crewPanel);

		return panelList;
	}

	private static JPanel getPanel(String panelName, String[] list,int selectionMode) {
		JPanel panel = new JPanel();
		LineBorder roundedLineBorder = new LineBorder(Color.black, 1, true);
		TitledBorder roundedTitledBorder = new TitledBorder(roundedLineBorder,panelName);
		panel.setBorder(roundedTitledBorder);
		JList elements = new JList(list);
		elements.setSelectionMode(selectionMode);
		panel.setLayout(new BorderLayout());
		panel.add(elements);
		return panel;
	}
}

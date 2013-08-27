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
import java.util.List;

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
	public static JList crewList;

	
	public static void main(String[] args) {
		JFrame mainFrame = new JFrame("Cabin Crew Planning");
		mainFrame.setSize(500, 400);		
		generateMainPanel();		
		mainFrame.add(mainPanel);		
		mainFrame.setResizable(false);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		mainFrame.setLocation((d.width - mainFrame.getSize().width) / 2,(d.height - mainFrame.getSize().height) / 2);
		mainFrame.setVisible(true);
	}

	private static void generateMainPanel() {
		//main panel layout
		GridLayout mainPanelGrid = new GridLayout(1, 2);
		mainPanel.setLayout(mainPanelGrid);   
		
		//Flights and crews
		JList flightList = new JList(DataRetriever.fecthFlightsList());		
		flightList.setBorder(generateBorder("Flights"));
		
		crewList = new JList(DataRetriever.fetchCrewsList());	
		crewList.setBorder(generateBorder("Crews"));
		
		//listener to match flight-crew
		flightList.addListSelectionListener(new FlightListener());
		
		mainPanel.add(flightList);
		mainPanel.add(crewList);
	}
	
	private static Border generateBorder(String name) {
		LineBorder roundedLineBorder = new LineBorder(Color.black, 1, true);
		TitledBorder roundedTitledBorder = new TitledBorder(roundedLineBorder,name);
		return roundedTitledBorder;
	}

	public static void selectItem(int i){
		crewList.setSelectedIndex(i);
	}
}


class FlightListener implements ListSelectionListener{
	@Override
	public void valueChanged(ListSelectionEvent event) {
		Planner.selectItem(((JList)event.getSource()).getSelectedIndex()+1);
	}	
}
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JFrame;
import javax.swing.JList;

public class MapTester {

	public static void main(String[] args) {

		JFrame mainFrame = new JFrame("Cabin Crew Planning");
		mainFrame.setSize(500, 400);
		mainFrame.setResizable(false);
		
		DataRetriever data = new DataRetriever();
		
		JList l = new JList(data.generateFlights());
		
		mainFrame.add(l);
		
		Flight temp = new Flight("GL1346");
		l.setSelectedValue(temp, true);
		
		
		
		
		
		
		
		
		
		
		
		
		// center the frame in screen
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		mainFrame.setLocation((d.width - mainFrame.getSize().width) / 2,(d.height - mainFrame.getSize().height) / 2);
		mainFrame.setVisible(true);

		
		

	}
}

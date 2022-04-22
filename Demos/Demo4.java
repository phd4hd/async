import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

public class Demo4 {
    private static JProgressBar linkerBalken, rechterBalken;
    private static String sharedString;

	private static void zeigeFenster(String title) {
        JFrame frame = new JFrame(title);
        frame.setSize(250, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout( new GridLayout(1,2) );
        frame.getRootPane().setBorder( new EmptyBorder(10, 10, 10, 10) );

        linkerBalken = new JProgressBar(JProgressBar.VERTICAL, 0, 100);
        linkerBalken.setValue(0);
        linkerBalken.setForeground(Color.green);
        
        rechterBalken = new JProgressBar(JProgressBar.VERTICAL, 0, 100);
        rechterBalken.setValue(0);
        rechterBalken.setForeground( new Color(250,128,114) );
        
        frame.add(linkerBalken);
        frame.add(rechterBalken);
        frame.setVisible(true);
	}
	
	private static void verbraucheEtwasZeit(int millisec) {
		try {
			Thread.sleep(millisec);
		}
		catch (Exception ignored) {}
	}
	
	// eine normale Methode mit Rückgabewert
	public static String methode() {
		System.out.println("Methode legt los...");
		for (int i=1; i<=100; i++) {
			verbraucheEtwasZeit(10);
			rechterBalken.setValue(i);
		}
		System.out.println("Methode fertig!");
		return "Erfolg";
	}
	
	public static void main(String[] args) {
		zeigeFenster("Demo #4");
		System.out.println("Jetzt gehts los...");
		
		for (int i=1; i<=100; i++) {
			verbraucheEtwasZeit(20);
			linkerBalken.setValue(i);
			
			// asynchroner Methodenaufruf
			if (i == 50)
				new Thread( () -> sharedString = methode() ).start();
		}

		System.out.println("Ergebnis der Methode: " + sharedString);
		System.out.println("Fertig!");
	}
}

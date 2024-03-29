import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

public class �bung3 {
    private static JProgressBar linkerBalken, rechterBalken;

	private static void zeigeFenster(String title) {
        JFrame frame = new JFrame(title);
        frame.setSize(250, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout( new GridLayout(1,2) );
        frame.getRootPane().setBorder( new EmptyBorder(10, 10, 10, 10) );

        linkerBalken = new JProgressBar(JProgressBar.VERTICAL, 0, 100);
        linkerBalken.setValue(0);
        linkerBalken.setForeground(Color.blue);
        
        rechterBalken = new JProgressBar(JProgressBar.VERTICAL, 0, 100);
        rechterBalken.setValue(0);
        rechterBalken.setForeground(Color.magenta);
        
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

	public static int erzeugeZahl() {
		for (int i=1; i <= 10; i++) {
			verbraucheEtwasZeit(10);
			rechterBalken.setValue(i * 10);
		}
		return (int)(Math.random() * 100) + 1;
	}
	
	public static void main(String[] args) {
		zeigeFenster("�bung 3");
		System.out.println("Jetzt gehts los...");

	    List<Integer> z�hlerSpeicher = new ArrayList<>();
		for (int i=1; i<=10; i++) {
			verbraucheEtwasZeit(20);
			linkerBalken.setValue(i*10);
			
		    // �bung: �ndern Sie diesen synchronen Aufruf in einen asynchronen Aufruf um
			z�hlerSpeicher.add( erzeugeZahl() );
		}
		z�hlerSpeicher.sort( (a,b) -> a-b );
		
		System.out.println("Fertig!");
		System.out.println(z�hlerSpeicher);
	}
}

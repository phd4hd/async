import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

public class Übung2 {
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

	public static List<Integer> erzeugeZahlen() {
	    List<Integer> zählerSpeicher = new ArrayList<>();
		for (int i=1; i <= 10; i++) {
			verbraucheEtwasZeit(50);
			rechterBalken.setValue(i * 10);
			zählerSpeicher.add( (int)(Math.random() * 100) + 1 );
			zählerSpeicher.sort( (a,b) -> { return a-b; } );
		}
		return zählerSpeicher;
	}
	
	public static void main(String[] args) {
		zeigeFenster("Lösung 2");
		System.out.println("Jetzt gehts los...");

		// Ändern Sie diesen synchronen Aufruf in einen asynchronen Aufruf um
		Future<List<Integer>> zahlenListe = 
				Executors.newSingleThreadExecutor().submit( () ->  erzeugeZahlen() );
		
		for (int i=1; i<=100; i++) {
			verbraucheEtwasZeit(3);
			linkerBalken.setValue(i);
		}
		
		System.out.println("Fertig?");
		System.out.println("Zahlen sind " + (zahlenListe.isDone() ? "" : "nicht ") + "fertig");
		try {
			// get() ist ein blockierender Aufruf, d.h. wartet bis die Liste fertig ist
			System.out.println(zahlenListe.get());
		}
		catch (Exception ignored) {}
	}
}

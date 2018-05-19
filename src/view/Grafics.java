package view;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;
import javax.swing.text.JTextComponent;

import org.math.plot.Plot2DPanel;

import practice3.Controller;



public class Grafics {
	//private static Plot2DPanel plot;
	private Controller ctrl;
	private static JFrame window;
	private static Plot2DPanel plot;
	private static Barras barra;
	private static JTextArea decodedtext;
	@SuppressWarnings("static-access")
	public Grafics(Controller ctrl) {
		this.ctrl = ctrl;
		 //create your PlotPanel (you can use it as a JPanel)
		this.plot = new Plot2DPanel();
		plot.setSize(100, 300);
		// define the legend position
		//plot.addLegend("CENTER");
		Dimension dim = new Dimension(400, 400);
		Dimension dim2 = new Dimension(700, 700);
		
		decodedtext = new JTextArea("Here is shown the decoded text from above");
		decodedtext.setPreferredSize(dim);
		decodedtext.setEditable(false);
		decodedtext.setLineWrap(true);
		decodedtext.setWrapStyleWord(true);
	
		JScrollPane scroll = new JScrollPane(); 
		scroll.setViewportView(decodedtext);
		
		
		JPanel texts = new JPanel();
		texts.setLayout(new BoxLayout(texts, BoxLayout.Y_AXIS));
		texts.setSize(dim2);
		this.barra = new Barras(this.ctrl);
		//texts.add(barra.getPanel(), BorderLayout.WEST);
		
		texts.add(scroll, BorderLayout.NORTH);
		//texts.add(barra.getToolBar(), BorderLayout.SOUTH);
		
		Grafics.window = new JFrame("Gráfica");
		Grafics.window.setSize(900, 500);
		Grafics.window.setContentPane(plot);
		Grafics.window.add(texts, BorderLayout.EAST);
		Grafics.window.add(barra.getPanel(), BorderLayout.WEST);
		Grafics.window.add(barra.getToolBar(), BorderLayout.SOUTH);
		Grafics.window.setVisible(true);
		Grafics.window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	public static void refresh(double[] elMejorDeTodos, double[] losMejores, double[] media, char[] geno, String text){
		plot.removeAllPlots();
		double aux= 0;
		decodedtext.setText(text);
		plot.addLinePlot("Mejor absoluto", elMejorDeTodos);
		plot.addLinePlot("Mejor de la generacion",losMejores);
		plot.addLinePlot("Media de la generacion",media );
		for(int i = 0;i < media.length;i++) {
			aux+=media[i];
		}
		aux= aux/media.length;
		System.out.println(aux);
		window.repaint();
	}
	
	public static void add(String solution) {
		// TODO Auto-generated method stub
		decodedtext.setText(solution);
	}
}
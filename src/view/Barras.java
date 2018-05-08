package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import practice3.Controller;

public class Barras {

	private JToolBar panel;
	private JToolBar toolBar;
	@SuppressWarnings("unused")
	private Controller ctrl;
	private JTextField[] finalgen;
	public Barras(Controller ctrl, JTextArea cyphertext) {
		this.ctrl = ctrl;
		this.panel = new JToolBar();
		this.toolBar = new JToolBar();
		Dimension dimension = new Dimension(150, 25);
		JTextField poblacion = new JTextField("150");
		poblacion.setMaximumSize(dimension);
		JTextField generaciones = new JTextField("300");
		generaciones.setMaximumSize(dimension);
		JTextField porcentajecruce = new JTextField("50");
		porcentajecruce.setMaximumSize(dimension);
		JTextField porcentajemutacion = new JTextField("10");
		porcentajemutacion.setMaximumSize(dimension);
		JTextField num = new JTextField("2");
		num.setMaximumSize(dimension);
		JCheckBox elitismo = new JCheckBox("Elitismo", true);
		JTextField porcelit = new JTextField("2");
		porcelit.setMaximumSize(dimension);
		elitismo.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				porcelit.setVisible(elitismo.isSelected());
			}
			
		});
		String[] posselecciones = { "TOURNEY","PROB TOURNEY","RULET", "STOCHASTIC", "RESTS" };
		JComboBox<String> seleccion = new JComboBox<String>(posselecciones);
		seleccion.setMaximumSize(dimension);
		seleccion.setEditable(false);
		String[] poscruces = { "PMX", "OX", "OUR METHOD", "INDEX" };
		JComboBox<String> cruce = new JComboBox<String>(poscruces);
		cruce.setMaximumSize(dimension);
		cruce.setEditable(false);
		String[] posmutations = {"EXCHANGE", "HEURISTIC", "INSERTION", "INVERSION", "OUR METHOD", "INDEX"};
		JComboBox<String> mutations = new JComboBox<String>(posmutations);
		mutations.setMaximumSize(dimension);
		mutations.setEditable(false);
		
		this.panel.setOrientation(SwingConstants.VERTICAL);
		JLabel maxpob = new JLabel("Max.Pob.");
		JLabel maxgen = new JLabel("Max.Gen.");
		JLabel porccruce = new JLabel("Porc.Cruce");
		JLabel porcmuta = new JLabel("Porc.Muta.");
		JLabel titcruce = new JLabel("Tipo de cruce");
		JLabel titselect = new JLabel("Tipo de seleccion");
		JLabel titmutac = new JLabel("Tipo de mutacion");
		JLabel mutatenum = new JLabel("Num para muta.");
		this.panel.add(maxpob);
		this.panel.add(poblacion);
		this.panel.add(maxgen);
		this.panel.add(generaciones);
		this.panel.add(porccruce);
		this.panel.add(porcentajecruce);
		this.panel.add(porcmuta);
		this.panel.add(porcentajemutacion);
		this.panel.add(elitismo);
		this.panel.add(porcelit);
		this.panel.add(titcruce);
		this.panel.add(cruce);
		this.panel.add(titselect);
		this.panel.add(seleccion);
		this.panel.add(titmutac);
		this.panel.add(mutations);
		this.panel.add(mutatenum);
		this.panel.add(num);
		this.panel.setFloatable(false);
		
		
		JButton f1 = new JButton();
		f1.setToolTipText("Start decypher");
		f1.setText("Start");
		f1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//LANZAR F1 
				ctrl.execute(poblacion.getText(),generaciones.getText(), porcentajecruce.getText(),porcentajemutacion.getText(),elitismo.isSelected()
						, porcelit.getText(), (String)cruce.getSelectedItem(), (String)seleccion.getSelectedItem(),(String)mutations.getSelectedItem(), num.getText(),
						cyphertext.getText());
			}

		});
		this.finalgen = new JTextField[26];
		
		this.toolBar.add(f1);
		for(int i =0;i < 26;i++) {
			finalgen[i] = new JTextField();
			finalgen[i].setEditable(false);
			finalgen[i].setPreferredSize(new Dimension(10,20));
			this.toolBar.add(finalgen[i]);
		}
		
		this.toolBar.setOrientation(SwingConstants.HORIZONTAL);
		this.toolBar.setFloatable(false);
	}
	public Component getPanel() {
		// TODO Auto-generated method stub
		return this.panel;
	}
	public Component getToolBar() {
		// TODO Auto-generated method stub
		return this.toolBar;
	}
	public void showfenotipe(char[] geno) {
		// TODO Auto-generated method stub
		for(int i = 0; i < 26; i++)
		{
			this.finalgen[i].setText(Character.toString(geno[i]));
			this.finalgen[i].repaint();
		}
	}
}

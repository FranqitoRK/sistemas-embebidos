package clase;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Ventana extends JFrame implements ActionListener
{
	JMenuBar barra;
	JMenu tema,idioma,extra;
	JMenuItem claro,oscuro,ingles,espanol,aleman,jebusito,dcinco;
	Lienzo tablero = new Lienzo();
	int language;
	
	public Ventana()
	{
		setTitle("");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(tablero);
		tablero.setBackground(Color.WHITE);
		setIconImage(new ImageIcon(getClass().getResource("Imags/chino.png")).getImage());
		
		barra=new JMenuBar();
		setJMenuBar(barra);
		
		tema=new JMenu("Tema");
		barra.add(tema);
		claro=new JMenuItem("Claro");
		claro.addActionListener(this);
		tema.add(claro);
		oscuro=new JMenuItem("Oscuro");
		oscuro.addActionListener(this);
		tema.add(oscuro);
		
		idioma=new JMenu("Idioma");
		barra.add(idioma);
		espanol=new JMenuItem("Espanol");
		espanol.addActionListener(this);
		idioma.add(espanol);
		ingles=new JMenuItem("English");
		ingles.addActionListener(this);
		idioma.add(ingles);
		aleman=new JMenuItem("Deutsch");
		aleman.addActionListener(this);
		idioma.add(aleman);
		
		extra=new JMenu("+");
		barra.add(extra);
		jebusito=new JMenuItem("a/d Cristo");
		jebusito.addActionListener(this);
		extra.add(jebusito);
		dcinco=new JMenuItem("5 digito");
		dcinco.addActionListener(this);
		extra.add(dcinco);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==dcinco) 
		{
			tablero.Dcinco();
		}
		if(e.getSource()==jebusito) 
		{
			tablero.ACDC();
		}
		if(e.getSource()==claro) 
		{
			tablero.TEMA(true);
		}
		if(e.getSource()==oscuro) 
		{
			tablero.TEMA(false);
		}
		if(e.getSource()==espanol) 
		{
			tablero.idioma(0);
			tema.setText("Tema");
			idioma.setText("Idioma");
			oscuro.setText("Oscuro");
			claro.setText("Claro");
			dcinco.setText("5 digitos");
			jebusito.setText("a/d Cristo");
		}
		if(e.getSource()==ingles) 
		{
			tablero.idioma(1);
			tema.setText("Theme");
			idioma.setText("Language");
			oscuro.setText("Dark");
			claro.setText("Light");
			dcinco.setText("5 digits");
			jebusito.setText("BC/AD");
		}
		if(e.getSource()==aleman) 
		{
			tablero.idioma(2);
			tema.setText("Thema");
			idioma.setText("Sprache");
			oscuro.setText("Dunkel");
			claro.setText("Klar");
			dcinco.setText("5 Ziffern");
			jebusito.setText("v/n Chr.");
		}
	}
}
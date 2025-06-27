package clase;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Lienzo extends JPanel implements ActionListener
{
	JLabel label1,label2,label3;
	JButton boton;
	JTextField campo1,campo2;
	
	int nota1,nota2;
	float prom;
	
	public Lienzo()
	{
		setLayout(null);
		
		label1=new JLabel("Nota 1: ");
		label1.setBounds(40,20,60,40);
		add(label1);
		
		label2 = new JLabel("Nota 2: ");
		label2.setBounds(40,60,60,40);
		add (label2);
		
		boton = new JButton("PROMEDIAR");
		boton.setBackground(new Color(150,150,150));
		boton.setBounds(75,130,150,30);
		add(boton);
		boton.addActionListener(this);
		
		campo1=new JTextField();
		campo1.setBounds(100,25,150,30);
		add(campo1);
		
		campo2=new JTextField();
		campo2.setBounds(100,65,150,30);
		add(campo2);
		
		label3=new JLabel("PROMEDIO: ");
		label3.setBounds(40,200,200,40);
		add(label3);
	}
	public void actionPerformed(ActionEvent evento) 
	{
		if(evento.getSource() == boton) 
		{
			nota1=Integer.parseInt(campo1.getText());
			nota2=Integer.parseInt(campo2.getText());
			prom=((float)nota1+(float)nota2)/2;
			label3.setText("PROMEDIO: "+ prom);
		}
	}
}
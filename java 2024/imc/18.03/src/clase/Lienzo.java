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
	
	float altura,peso,imc;
	
	public Lienzo()
	{
		setLayout(null);
		
		label1=new JLabel("Altura (m): ");
		label1.setBounds(40,20,100,40);
		add(label1);
		
		label2 = new JLabel("Peso (kg): ");
		label2.setBounds(40,60,60,40);
		add (label2);
		
		boton = new JButton("IMC: ");
		boton.setBackground(new Color(150,150,150));
		boton.setBounds(120,130,100,30);
		add(boton);
		boton.addActionListener(this);
		
		campo1=new JTextField();
		campo1.setBounds(150,25,150,30);
		add(campo1);
		
		campo2=new JTextField();
		campo2.setBounds(150,65,150,30);
		add(campo2);
		
		label3=new JLabel("IMC: ");
		label3.setBounds(40,200,200,40);
		add(label3);
	}
	public void actionPerformed(ActionEvent evento) 
	{
		if(evento.getSource() == boton) 
		{
			altura=Float.parseFloat(campo1.getText());
			peso=Float.parseFloat(campo2.getText());
			imc=(peso/(altura*altura));
			label3.setText("IMC: "+ imc);
		}
	}
}
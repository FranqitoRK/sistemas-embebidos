package clases;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Lienzo extends JPanel implements ActionListener
{	
	Objeto canasta,fruta;
	Timer timer;
	JTextField campo;
	JButton boton;
	JLabel texto,empezar;
	int puntosmax,pos=1,delay=0,puntos,qfruta;
	boolean start=false,atrapar=false,banana=false,naranja=false,manzana=false;
	public Lienzo()
	{
		setLayout(null);
		
		campo=new JTextField();
		campo.setBounds(50,50,100,30);
		campo.addActionListener(this);
		add(campo);
		
		boton=new JButton("Hecho");
		boton.setBounds(50,100,100,30);
		boton.addActionListener(this);
		boton.setFocusable(false);
		add(boton);
		
		texto=new JLabel("Puntos:");
		texto.setBounds(200,50,100,30);
		add(texto);
		
		empezar=new JLabel("START");
		empezar.setBounds(50,400,100,30);
		add(empezar);
		
		canasta=new Objeto(200,300);
		canasta.setImg(0);
		
		fruta=new Objeto(20,300);
		fruta.setImg(1);
		
		timer = new Timer(10,this);
		timer.start();
	}
	
	public void paint(Graphics g) 
	{
		super.paint(g);
		Graphics2D g2=(Graphics2D)g;
		g2.drawImage(canasta.getImg(),canasta.getX(),canasta.getY(),null);
		g2.drawImage(fruta.getImg(),fruta.getX(),fruta.getY(),null);
		g2.drawLine(180, 100, 650, 100);
		g2.drawLine(180, 400, 650, 400);
	}
	
	public void actionPerformed(ActionEvent e)
	{   
		if(start) 
		{
			puntosmax=Integer.parseInt(campo.getText());
			texto.setText("Puntos: "+puntos);
			canasta.setX(100+(pos*100));
			int b=fruta.getY()+5;
			fruta.setY(b);
			if(fruta.getY() >= 400||atrapar)
		    {
				int qfruta = (int)(Math.random()*10);
				if(qfruta==1) {fruta.setImg(1);banana=true;}
				else if(qfruta==2||qfruta==3) {fruta.setImg(2);naranja=true;}
				else if (qfruta!=1&&qfruta!=2&&qfruta!=3) {fruta.setImg(3);manzana=true;}
		        fruta.setY(100);
		        int posf = (int)(Math.random()*5);
		        fruta.setX(100+(posf*100));
		        if(posf==0) {fruta.setX(200);}
		        atrapar=false;
		        if(puntosmax<=puntos)
				{
					start=false;
					campo.setEnabled(true);
					boton.setEnabled(true);
					fruta.setX(20);
					fruta.setY(300);
				}
		    }
			
			if(fruta.getY()>=320) 
			{
				if(canasta.getX()==fruta.getX()) 
				{
					if(banana) {puntos=puntos+20;banana=false;}
					if(naranja) {puntos=puntos+10;naranja=false;}
					if(manzana) {puntos=puntos+5;manzana=false;}
					atrapar=true;
				}
			}
		}
		if(e.getSource()==boton) 
		{
			puntos=0;
			campo.setEnabled(false);
			boton.setEnabled(false);
			start=true;
		}
		if(Teclado.izq)
		{
			if(start) 
			{
				delay=delay+1;
				if(delay>=7) 
				{
					delay=0;
					pos=pos-1;
					if(pos<=0) {pos=1;}
				}
			}
			
		}
		else if(Teclado.der) 
		{
			if(start) 
			{
				delay=delay+1;
				if(delay>=7) 
				{
					delay=0;
					pos=pos+1;
					if(pos>=5) {pos=4;}
				}
			}
		}
		repaint();
	}
}
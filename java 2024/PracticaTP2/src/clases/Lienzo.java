package clases;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Lienzo extends JPanel implements ActionListener
{

	int elegido,ganador,auxtimer=3,asd=1000; // VARIABLES
 	boolean turno=false, terminado=false; // LLAVES
	Timer pelotitas,tiempito,medioseg; // TIMER
	JLabel etiqueta1; // TEXTO
	JButton[] botones = new JButton[3]; // BOTONES
	JButton fondo = new JButton(); // FONDO
	Bolita[] pelo = new Bolita[6]; // IMAGENES
	
	public Lienzo()
	{
		setLayout(null);

		botones[0] = new JButton("AZUL");
		botones[0].setBounds(100, 50, 150, 60);
		botones[0].setForeground(Color.BLUE);
		botones[0].setBorder(new LineBorder(Color.blue,2,true));
		
		botones[1] = new JButton("VERDE");
		botones[1].setBounds(300, 50, 150, 60);
		botones[1].setForeground(Color.GREEN);
		botones[1].setBorder(new LineBorder(Color.green,2,true));
		
		botones[2] = new JButton("ROJO");
		botones[2].setBounds(500, 50, 150, 60);
		botones[2].setForeground(Color.RED);
		botones[2].setBorder(new LineBorder(Color.red,2,true));
		
		for (int i = 0; i < 3; i++)
		{
			botones[i].setBackground(Color.WHITE);
	        botones[i].addActionListener(this);
	        botones[i].setFont(new Font("Tahoma", Font.BOLD, 20));
	        botones[i].setOpaque(true);
	        botones[i].setEnabled(true);   
	        add(botones[i]);
		}   
          
		fondo.setEnabled(false);
		fondo.setBounds(50,130,650,350);
		fondo.setBackground(Color.WHITE);
		fondo.setBorder(new LineBorder(Color.BLACK,5,true));
		add(fondo);
		
        etiqueta1 = new JLabel("Hagan sus apuestas");
        etiqueta1.setBounds(250,470,400,100);
        etiqueta1.setFont(new Font("Tahoma", Font.BOLD, 30)); 
        add(etiqueta1);
        etiqueta1.setVisible(true);        
        
        for(int i=0,x=170;i<6;i++,x=x+50) 
        {
        	pelo[i] = new Bolita(100, x, i%3);
        }

		tiempito = new Timer(1000,this);
		tiempito.start();
		
		medioseg = new Timer(200,this);
		medioseg.start();
		
		pelotitas = new Timer(30, this); // TIMER
		pelotitas.start();
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2 = (Graphics2D)g;
		
		for (int i=0;i<6;i++) // PARA IMRPIMIR TODAS LAS IMAGENES SIN SPAM
		{
			g2.drawImage(pelo[i].getImg(),pelo[i].getX(),pelo[i].getY(),null);
		}
	}
	
	public void actionPerformed(ActionEvent e)
	{   
		if (turno == false) // AL PRINCIPIO, PARA QUE SE ASIGNE UN VALOR POR CADA BOTON
		{
			if (e.getSource() == botones[0])
			{
				elegido = 1;
				turno = true;
			}
			
			if (e.getSource() == botones[1])
			{
				elegido = 2;
				turno = true;
			}
			
			if (e.getSource() == botones[2])
			{
				elegido = 3;
				turno = true;
			}
		}
		
		if (turno == true)
		{
			for (int i = 0; i < 3; i++) // DESHABILITAR TODOS LOS BOTONES PARA NO VOLVER A PRESIONAR MIENTRAS FUNCIONA EL PROGRAMA
			{
		        botones[i].setEnabled(false);   
			}   
			
			if (terminado == false) // PARA QUE CUANDO TERMINADO SEA TRUE, NO SE PUEDA MOVER MAS
			{
				if(e.getSource()==tiempito && auxtimer>= 0) 
				{
					etiqueta1.setBounds(390,470,400,100);
					etiqueta1.setText(""+auxtimer);
					auxtimer=auxtimer-1;
				}
				if(auxtimer==-1)
				{
					etiqueta1.setBounds(300,470,400,100);
					etiqueta1.setText("Comiencen!");
					
					for(int i=0;i<6;i++) // MOVIMIENTO PELOTITAS
					{
						pelo[i].setX(pelo[i].getX()+5+(int)(Math.random()*10));
					}
				}
			}
		}
		
		if (pelo[0].getX() > 675 || pelo[3].getX() > 675)
		{
			ganador = 2;
			if(e.getSource()==medioseg&&ganador==2) 
			{
				pelo[0].setX(pelo[0].getX()+asd);
				pelo[3].setX(pelo[3].getX()+asd);
				asd=-asd;
			}
			terminado = true;
		}
		
		if (pelo[1].getX() > 675 || pelo[4].getX() > 675)
		{
			ganador = 1;
			if(e.getSource()==medioseg&&ganador==1) 
			{
				pelo[1].setX(pelo[1].getX()+asd);
				pelo[4].setX(pelo[4].getX()+asd);
				asd=-asd;
			}
			terminado = true;
		}
		
		if (pelo[2].getX() > 675 || pelo[5].getX() > 675)
		{
			ganador = 3;
			if(e.getSource()==medioseg&&ganador==3) 
			{
				pelo[2].setX(pelo[2].getX()+asd);
				pelo[5].setX(pelo[5].getX()+asd);
				asd=-asd;
			}
			terminado = true;
		}
		
		if (elegido == ganador && terminado == true) // SI GANA EL EQUIPO ELEGIDO
		{
			etiqueta1.setText("Has ganado!");
		}
		if (elegido != ganador && terminado == true) // SI NO GANA EL EQUIPO ELEGIDO
		{
			etiqueta1.setText("Has perdido!");
		}
		
		repaint(); // ACTUALIZAR IMAGENES
	}
}
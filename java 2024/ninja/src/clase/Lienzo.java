package clase;

import java.awt.Color;
import java.awt.Font;
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
	Objeto pelota,ninja;
	Timer timer1;
	JButton iniciar;
	JLabel ltiempo,lvidas;
	JTextField ingrese;
	Font fuente= new Font("tahoma",Font.BOLD,17);
	Font fuente2= new Font("tahoma",Font.BOLD,20);

	int tiempo=0,vidas=0,frame=0,ancho=140,alto=320;
	boolean activo=false,saltar=false,agachar=false,damage=true;
	
	public Lienzo()
	{
		setLayout(null);
		
		pelota = new Objeto(-1000,-1000,0);
		
		ninja = new Objeto(300,300,1);
		
		timer1 = new Timer(20,this);
		timer1.start();
		
		iniciar = new JButton("Iniciar");
		iniciar.setBounds(30,100,150,40);
		iniciar.addActionListener(this);
		iniciar.setBackground(new Color(100,100,100));
		iniciar.setForeground(new Color(255,255,255));
		iniciar.setFont(fuente);
		iniciar.setFocusable(false);
		add(iniciar);
		
		ingrese = new JTextField("");
		ingrese.setBounds(30,50,150,40);
		ingrese.setFont(fuente);
		add(ingrese);
		
		ltiempo = new JLabel("Tiempo transcurrido: 0:00");
		ltiempo.setBounds(250,50,600,40);
		ltiempo.setFont(fuente2);
		add(ltiempo);
		
		lvidas = new JLabel("");
		lvidas.setBounds(250,100,600,40);
		lvidas.setFont(fuente2);
		add(lvidas);

		
		repaint();
	}
	
	public void paint(Graphics g) 
	{
		super.paint(g);
		Graphics2D g2=(Graphics2D) g;

			g2.drawImage(pelota.getImage(),pelota.getX(),pelota.getY(),null);
			g2.drawImage(ninja.getImage(),ninja.getX(),ninja.getY(),null);

	}

	public void actionPerformed(ActionEvent evento) 
	{
		
		if(evento.getSource()==iniciar)
		{
			vidas = Integer.parseInt(ingrese.getText());
			ingrese.setEnabled(false);
			iniciar.setEnabled(false);
			activo=true;
			lvidas.setText(vidas+" vidas restantes");
		}
		
		if(evento.getSource()==timer1 && activo)
		{
			tiempo++;
			if(pelota.getX()<-40)
			{
				pelota.setY(270+(int)(Math.random()*2)*300);
				pelota.setX(1000);
				damage=true;
			}
			pelota.setX(pelota.getX()-20);
			ltiempo.setText("Tiempo transcurrido: "+tiempo/1980+":"+(tiempo/330)%6+(tiempo/33)%10);
			
			if(saltar)											//ANIMACION SALTO
			{
				frame++;
				if(frame<=15)
				{
					ninja.setY(ninja.getY()-10);
				}
				else
				{
					ninja.setY(ninja.getY()+10);
				}
				if(frame==3)
				{
					ninja.setImage(4);
					ancho=140;
					alto=320;
				}
				else if(frame==7)
				{
					ninja.setImage(5);
					ancho=180;
					alto=240;
				}
				else if(frame==23)
				{
					ninja.setImage(4);
					ancho=140;
					alto=320;

				}
				else if(frame==30)
				{
					saltar=false;
					frame=0;
					ninja.setImage(1);
					ancho=140;
					alto=320;
				}
				
			} 
			else if(agachar)               //ANIMACION AGACHAR
			{
				frame++;
				if(frame==3)
				{
					ninja.setImage(3);
					ninja.setY(400);
					ancho=360;
					alto=250;
				}
				else if(frame==7)
				{
					ninja.setImage(2);
					ninja.setY(400);
					ancho=240;
					alto=250;

				}
				else if(frame==23)
				{
					ninja.setImage(3);
					ninja.setY(400);
					ancho=360;
					alto=250;

				}
				else if(frame==30)
				{
					ninja.setY(300);
					agachar=false;
					frame=0;
					ninja.setImage(1);
					ancho=140;
					alto=320;
				}
				

			}
		
			if(!saltar && !agachar) 
			{
				if(EventoTeclado.up)
				{
					saltar=true;
				}
				else if(EventoTeclado.down)
				{
					agachar=true;
				}
			}

			
			if(damage)         //COLISIONES
			{
				if(pelota.getX()+100>=ninja.getX() && pelota.getX()+10<=ninja.getX()+ancho)
				{
					if(pelota.getY()+100>=ninja.getY()+20 && pelota.getY()+10<=ninja.getY()+alto)
					{
						vidas--;
						damage=false;
						lvidas.setText(vidas+" vidas restantes");
						if(vidas==0)
						{
							activo=false;
							
						}
					}
				}
			}
		}
			
		repaint();
	}	

}
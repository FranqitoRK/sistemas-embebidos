package clase;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Lienzo extends JPanel implements ActionListener,ItemListener
{
	Features asdf = new Features();
	JButton ingresar,random,borrar,regresar,update;
	JButton[] aumentar = new JButton[5], disminuir = new JButton[5];
	JComboBox<String> jebus;
	JLabel ano, bis,horo;
	JLabel[] n = new JLabel[5];
	Horoscopo chino;
	boolean acdc=false,cincod=false,acdcsito=false,ingreso=false;
	int a,animal,uno,dos,tres,cuatro,cinco,idioma=0,bisiesto=0;
	String[][] tuanimal= {
			{"<html><center>Mono:<br>inteligente, ambicioso, curioso, gracioso<center><html>","<html><center>Gallo:<br>trabajador, valiente, orgulloso<center><html>","<html><center>Perro:<br>sociable, agradable, leal<center><html>",
				"<html><center>Chancho:<br>generoso, amable, compasivo<center><html>","<html><center>Rata:<br>inteligente, imaginativo, vers&#225;til, agradable<center><html>","<html><center>Buey:<br>trabajador, confiable, poderoso, inflexible<center><html>",
				"<html><center>Tigre:<br>valiente, seguro de s&#237; mismo, combativo<center><html>","<html><center>Conejo:<br>elegante, amable, sut&#237;l, sensible<center><html>","<html><center>Dragon:<br>seguro, inteligente, entusiasta<html><center>",
				"<html><center>Serpiente:<br>inteligente, flexible, misterioso<center><html>","<html><center>Caballo:<br>activo, poderoso, aventurero<center><html>","<html><center>Cabra:<br>sensible, comprensivo, servicial, amable<center><html>"},
			{"<html><center>Monkey:<br>intelligent, ambitious, curious, funny<center><html>","<html><center>Rooster:<br>hardworking, brave, proud<center><html>","<html><center>Dog:<br>sociable, pleasant, loyal<center><html>",
					"<html><center>Pig:<br>generous, kind, compassionate<center><html>","<html><center>Rat:<br>intelligent, imaginative, versatile, pleasant<center><html>","<html><center>Ox:<br>hardworking, reliable, powerful, inflexible<center><html>",
				"<html><center>Tiger:<br>brave, self-assured, combative<center><html>","<html><center>Rabbit:<br>elegant, friendly, subtle, sensitive<center><html>","<html><center>Drag-on(deez nuts):<br>confident, intelligent, enthusiastic<center><html>",
				"<html><center>Snake:<br>intelligent, flexible, mysterious<center><html>","<html><center>Horse:<br>active, powerful, adventurous<center><html>","<html><center>Goat:<br>sensitive, understanding, helpful, kind<center><html>"},
			{"<html><center>Affe:<br>intelligent, ehrgeizig, neugierig, lustig<center><html>","<html><center>Hanh:<br>flei&#223;ig, mutig, stolz<center><html>","<html><center>Hund:<br> gesellig, angenehm, loyal<center><html>",
                    "<html><center>Schwein:<br>gro&#223;z&#252;gig, freundlich, mitf&#252;hlend<center><html>","<html><center>Ratte:<br> intelligent, einfallsreich, vielseitig, angenehm<center><html>","<html><center>B&#252;ffer:<br>flei&#223;ig, zuverl&#227;ssig, m&#228;chtig, unflexibel<center><html>",
                "<html><center>Tiger:<br>mutig, selbstbewusst, k&#228;mpferisch<center><html>","<html><center>Hase:<br> elegant, freundlich, subtil, sensibel<center><html>","<html><center>Drache:<br>selbstbewusst, intelligent, begeistert<center><html>",
                "<html><center>Schlange:<br>intelligent, flexibel, geheimnisvoll<center><html>","<html><center>Pferd:<br>aktiv, m&#228;chtig, abenteuerlustig<center><html>","<html><center>Ziege:<br>sensibel, verst&#228;ndnisvoll, hilfsbereit, freundlich<center><html>"}
						 };
					
	String[][] esbis= {
			{"no es bisiesto","es bisiesto"},
			{"isn't a leap-year","is a leap-year"},
			{"ist nicht Schaltjahr","ist Schaltjahr"}
	};

	Color grismedio=new Color(180,180,180),grisclarisimo=new Color(250,250,250);
	Color grisoscurisimo = new Color(50,50,50), grisoscuro=new Color(100,100,100);
	Border borde1=new LineBorder(Color.black,2,false);
	Border borde2=new LineBorder(grisoscurisimo,1,false);
	Border borde3=new LineBorder(grismedio,1,false);
	Font font1=new Font("calibri",Font.BOLD,22);
	Font font2=new Font("calibri",Font.BOLD,30);
	Font font3=new Font("bahnschrift",Font.BOLD,55);

	public Lienzo()
	{
		setLayout(null);
		setBackground(grisclarisimo);

				
		//UPDATE
		update = new JButton();
		update.setBounds(530,380,40,40);
		update.setFont(font1);
		update.setFocusable(false);
		update.setBorderPainted(false);
		update.setContentAreaFilled(false);
		update.addActionListener(this);
		update.setIcon(new ImageIcon(getClass().getResource("Imags/megafono1.png")));
		update.setRolloverIcon(new ImageIcon(getClass().getResource("Imags/megafono2.png")));
		update.setPressedIcon(new ImageIcon(getClass().getResource("Imags/megafono3.png")));

		add(update);
		
		//VENTANA 1
		ingresar = new JButton("Ingresar");
		ingresar.setBackground(grismedio);
		ingresar.setForeground(Color.black);
		ingresar.setBounds(225,280,150,60);
		ingresar.setFont(font1);
		ingresar.setFocusable(false);
		ingresar.addActionListener(this);
		ingresar.setBorder(borde2);
		add(ingresar);
		
		random= new JButton();
		random.setBounds(100,280,60,60);
		random.setBorderPainted(false);
		random.setFocusable(false);
		random.setRolloverEnabled(true);
		random.setContentAreaFilled(false);
		random.setIcon(new ImageIcon(getClass().getResource("Imags/dado1.png")));
		random.setRolloverIcon(new ImageIcon(getClass().getResource("Imags/dado2.png")));
		random.setPressedIcon(new ImageIcon(getClass().getResource("Imags/dado3.png")));
		random.addActionListener(this);
		add(random);


		for(int i=0,x=65;i<5;i++,x=x+80)
		{
			n[i] = new JLabel("0");
			n[i].setBounds(x,120,70,90);
			n[i].setBorder(borde1);
			n[i].setHorizontalAlignment(JLabel.CENTER);
			n[i].setOpaque(true);
			n[i].setBackground(new Color(240,240,240));
			n[i].setFont(new Font("bahnschrift",Font.BOLD,70));
			n[i].setForeground(Color.black);
			add(n[i]);
			
			aumentar[i] = new JButton();
			aumentar[i].setBounds(x,80,70,30);
			aumentar[i].setBackground(grismedio);
			aumentar[i].setIcon(new ImageIcon(getClass().getResource("Imags/flecha1.png")));
			aumentar[i].setFocusable(false);
			aumentar[i].addActionListener(this);
			aumentar[i].setBorder(borde2);
		
			add(aumentar[i]);
			
			disminuir[i] = new JButton();
			disminuir[i].setBounds(x,220,70,30);
			disminuir[i].setBackground(grismedio);
			disminuir[i].setIcon(new ImageIcon(getClass().getResource("Imags/flecha2.png")));
			disminuir[i].setFocusable(false);
			disminuir[i].addActionListener(this);
			disminuir[i].setBorder(borde2);
			add(disminuir[i]);
		}
		
		borrar=new JButton();
		borrar.setBounds(450,280,60,60);
        borrar.setBorderPainted(false);
        borrar.setFocusable(false);
        borrar.setRolloverEnabled(true);
        borrar.setContentAreaFilled(false);
        borrar.setIcon(new ImageIcon(getClass().getResource("Imags/borrar1.png")));
        borrar.setRolloverIcon(new ImageIcon(getClass().getResource("Imags/borrar2.png")));
        borrar.setPressedIcon(new ImageIcon(getClass().getResource("Imags/borrar3.png")));
        borrar.addActionListener(this);
        add(borrar);
        
		n[0].setVisible(false);
		disminuir[0].setVisible(false);
		aumentar[0].setVisible(false);
		
		jebus=new JComboBox<String>();
        jebus.setBounds(485,130,70,70);
        jebus.setFont(font1);
        add(jebus);
        jebus.addItem("d.C.");
        jebus.addItem("a.C.");
        jebus.addItemListener(this);
        jebus.getEditor().getEditorComponent().setBackground(grisclarisimo);
        jebus.setBackground(grismedio);
        jebus.getEditor().getEditorComponent().setForeground(Color.black);
        jebus.setEditable(true);
        jebus.setForeground(Color.black);
        jebus.setFocusable(false);
        jebus.getEditor().getEditorComponent().setFocusable(false);
        jebus.setVisible(false);
		
		//VENTANA 2
		ano = new JLabel();
		ano.setBounds(10,0,300,100);
		ano.setFont(font3);
        ano.setForeground(Color.black);
		add(ano);
		ano.setVisible(false);
		
		bis = new JLabel();
		bis.setBounds(20,90,300,100);
		bis.setFont(font2);
        bis.setForeground(Color.black);
		add(bis);
		bis.setVisible(false);
				
		horo = new JLabel("",SwingConstants.CENTER);
		horo.setBounds(270,200,300,200);
		horo.setFont(font2);
        horo.setForeground(Color.black);
		add(horo);
		horo.setVisible(false);
		
		regresar = new JButton("Regresar");
        regresar.setBackground(grismedio);
        regresar.setForeground(Color.black);
        regresar.setBounds(20,350,150,60);
        regresar.setFont(font1);
        regresar.addActionListener(this);
        regresar.setBorder(borde2);
        regresar.setFocusable(false);
        add(regresar);
        regresar.setVisible(false);
		//IMAGENES
		
		chino = new Horoscopo(320,0);

		asdf.setLanguage(0);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		
		//UPDATE
		
		if(e.getSource()==update) 
		{
			asdf.setVisible(true);
		}
		
		//BOTONES +/-
		
		for(int i=0;i<5;i++)
		{
			if(e.getSource()==aumentar[i])
			{
				n[i].setText(String.valueOf(Integer.parseInt(n[i].getText())+1));
				if(n[i].getText().equals("10"))
				{
					n[i].setText("0");
				}
			}
			if(e.getSource()==disminuir[i])
			{
				n[i].setText(String.valueOf(Integer.parseInt(n[i].getText())-1));
				if(n[i].getText().equals("-1"))
				{
					n[i].setText("9");
				}
			}
		
			if(e.getSource()==borrar)
	        {
				if(cincod==true) 
				{
					n[0].setText("0");	
				}
	            n[1].setText("0");
	            n[2].setText("0");
	            n[3].setText("0");
	            n[4].setText("0");
	        }
		}
		
		//REGRESAR
		
		if(e.getSource()==regresar)
        {
			ingreso=false;
            regresar.setVisible(false);
            ano.setVisible(false);
            bis.setVisible(false);
    		horo.setVisible(false);
            ingresar.setVisible(true);
        	update.setVisible(true);
            for(int i=1;i<5;i++)
            {
                n[i].setVisible(true);
                aumentar[i].setVisible(true);
                disminuir[i].setVisible(true);
            }
            n[0].setVisible(cincod);
            aumentar[0].setVisible(cincod);
            disminuir[0].setVisible(cincod);
            jebus.setVisible(acdcsito);
            random.setVisible(true);
            borrar.setVisible(true);
            chino.setInvisible();
            repaint();

        }
		
		// INGRESAR
		
		if(e.getSource()==ingresar)
        {
            cinco=Integer.parseInt(n[0].getText());
            cuatro=Integer.parseInt(n[1].getText());
            tres=Integer.parseInt(n[2].getText());
            dos=Integer.parseInt(n[3].getText());
            uno=Integer.parseInt(n[4].getText());
            a=uno+dos*10+tres*100+cuatro*1000+cinco*10000;
            if(cincod==false) 
            {
                a=a-cinco*10000;
            }
            
            if(a==0)
            {
            	ano.setFont(font1);
            	ano.setVisible(true);
            	if(idioma==0)
            	{
            		ano.setText("<html>No existe el a&ntilde;o 0<html>");
            	}
            	else if(idioma==1)
            	{
            		ano.setText("The year 0 doesn't exist");
            	}
            	else
            	{
            		ano.setText("Das Jahr 0 existiert nicht");
            	}
            }
            else
            {
            	ano.setFont(font3);
            	animal=a%12;
        		if(acdc==true)
        		{
        			animal=13-animal;
        			if(animal>11)
        			{
        				animal=animal-12;
        			}
        		}
            	ano.setText(String.valueOf(a));
            	if(acdcsito==true)
            	{
        			ano.setText(ano.getText()+" "+jebus.getSelectedItem());
            	}
            	if(acdc==false && (a%4==0 && (a%100!=0 || a%400==0)))
            	{
            		bisiesto=1;
            	}
            	else
            	{
            		bisiesto=0;
            	}
            	if(acdc==true && (a%4==1 && (a%100!=1 || a%400==1)))
            	{
            		bisiesto=1;
            	}
            	bis.setText(esbis[idioma][bisiesto]);
            	horo.setText(tuanimal[idioma][animal]);
            	chino.setAnimal(animal);
            	repaint();
            
            	for(int i=0;i<5;i++)
            	{
            		n[i].setVisible(false);
            		aumentar[i].setVisible(false);
            		disminuir[i].setVisible(false);
            	}
            	random.setVisible(false);
            	borrar.setVisible(false);
            	ingresar.setVisible(false);
            	jebus.setVisible(false);
            	update.setVisible(false);
            	regresar.setVisible(true);
            	ano.setVisible(true);
            	bis.setVisible(true);
            	horo.setVisible(true);
            	ingreso=true;
            }
      }
            
		
		//RESTO DE BOTONES

		if(e.getSource()==random) 
        {
            if(cincod==true)
            {
                n[0].setText(String.valueOf((int)(Math.random()*10)));
            }
            n[1].setText(String.valueOf((int)(Math.random()*10)));
            n[2].setText(String.valueOf((int)(Math.random()*10)));
            n[3].setText(String.valueOf((int)(Math.random()*10)));
            n[4].setText(String.valueOf((int)(Math.random()*10)));
            if(acdcsito==true)
            {
                if(Math.random()<=0.5)
                {
                    jebus.setSelectedItem("a.C.");
                }
                else
                {
                    jebus.setSelectedItem("d.C.");
                }
            }
        }
		for(int i=0;i<5;i++)
		{
			if(n[i].getText().equals("10"))
			{
				n[i].setText("0");
			}
			if(n[i].getText().equals("-1"))
			{
				n[i].setText("9");
			}
		}
		
	}
	
	public void itemStateChanged(ItemEvent e) 
	{
		if(jebus.getSelectedItem()=="a.C." ||jebus.getSelectedItem()=="BC"||jebus.getSelectedItem()=="v.C.")
		{
			acdc=true;
			
		}
		else			
		{
		    acdc=false;
		}
	}
	
	public void Dcinco() 
	{
		if(ingreso==false)
		{
			cincod=!cincod;
			n[0].setVisible(cincod);
			aumentar[0].setVisible(cincod);
			disminuir[0].setVisible(cincod);
		}
	}
	
	public void ACDC() 
	{
		if(ingreso==false)
		{
			acdcsito=!acdcsito;
			jebus.setVisible(acdcsito);
		}
	}
	
	public void TEMA(boolean b) 
	{
		//CLARO
		if(b==true)
        {
			setBackground(grisclarisimo);
            asdf.getContentPane().setBackground(grisclarisimo);
            asdf.texto.setForeground(Color.black);
            ingresar.setBackground(grismedio);
	        ingresar.setForeground(Color.black);
	        regresar.setForeground(Color.black);
            jebus.getEditor().getEditorComponent().setBackground(new Color(240,240,240));
            jebus.setBackground(grismedio);
            jebus.getEditor().getEditorComponent().setForeground(Color.black);

            for(int i=0;i<5;i++) 
            {
                n[i].setBackground(new Color(240,240,240));
                n[i].setForeground(Color.black);

                aumentar[i].setBackground(grismedio);

                disminuir[i].setBackground(grismedio);
            }
            random.setIcon(new ImageIcon(getClass().getResource("Imags/dado1.png")));
            random.setRolloverIcon(new ImageIcon(getClass().getResource("Imags/dado2.png")));
            random.setPressedIcon(new ImageIcon(getClass().getResource("Imags/dado3.png")));

            borrar.setIcon(new ImageIcon(getClass().getResource("Imags/borrar1.png")));
            borrar.setRolloverIcon(new ImageIcon(getClass().getResource("Imags/borrar2.png")));
            borrar.setPressedIcon(new ImageIcon(getClass().getResource("Imags/borrar3.png")));

    		update.setIcon(new ImageIcon(getClass().getResource("Imags/megafono1.png")));
    		update.setRolloverIcon(new ImageIcon(getClass().getResource("Imags/megafono2.png")));
    		update.setPressedIcon(new ImageIcon(getClass().getResource("Imags/megafono3.png")));
            
            ano.setForeground(Color.black);
            bis.setForeground(Color.black);
	        horo.setForeground(Color.black);
            regresar.setBackground(grismedio);
    		repaint();
        }
		//OSCURO
		if(b==false)
	    {
			setBackground(grisoscurisimo);
			asdf.getContentPane().setBackground(grisoscurisimo);
			asdf.texto.setForeground(Color.white);
	        ingresar.setForeground(grisclarisimo);
	        regresar.setForeground(grisclarisimo);
	        ingresar.setBackground(grisoscuro);
	        jebus.getEditor().getEditorComponent().setBackground(new Color(40,40,40));
	        jebus.setBackground(grisoscuro);
	        jebus.getEditor().getEditorComponent().setForeground(Color.white);
	        for(int i=0;i<5;i++) 
	        {
	        	n[i].setBackground(new Color(40,40,40));
	            n[i].setForeground(Color.white);
	            aumentar[i].setBackground(grisoscuro);
	            disminuir[i].setBackground(grisoscuro);
	        }
	        random.setIcon(new ImageIcon(getClass().getResource("Imags/dado1osc.png")));
	        random.setRolloverIcon(new ImageIcon(getClass().getResource("Imags/dado2osc.png")));
	        random.setPressedIcon(new ImageIcon(getClass().getResource("Imags/dado3osc.png")));

	        borrar.setIcon(new ImageIcon(getClass().getResource("Imags/borrar1osc.png")));
	        borrar.setRolloverIcon(new ImageIcon(getClass().getResource("Imags/borrar2osc.png")));
	        borrar.setPressedIcon(new ImageIcon(getClass().getResource("Imags/borrar3osc.png")));

			update.setIcon(new ImageIcon(getClass().getResource("Imags/megafonosc1.png")));
			update.setRolloverIcon(new ImageIcon(getClass().getResource("Imags/megafonosc2.png")));
			update.setPressedIcon(new ImageIcon(getClass().getResource("Imags/megafonosc3.png")));
	        
	        ano.setForeground(Color.white);
	        bis.setForeground(Color.white);
	        horo.setForeground(Color.white);
	        regresar.setBackground(grisoscuro);
	        
    		repaint();
	    }
	}
	public void idioma(int b)
	{
		if(b==0)
		{
			regresar.setText("Regresar");
			ingresar.setText("Ingresar");
			jebus.removeAllItems();
	        jebus.addItem("d.C.");
	        jebus.addItem("a.C.");
        	
			asdf.setLanguage(0);
	        if(a==0)
	        {
        		ano.setText("<html>No existe el a&ntilde;o 0<html>");
	        }
		}
		else if(b==1)
		{
			regresar.setText("Return");
			ingresar.setText("Enter");
			jebus.removeAllItems();
	        jebus.addItem("AD");
	        jebus.addItem("BC");
			asdf.setLanguage(1);
	        if(a==0)
	        {
        		ano.setText("The year 0 doesn't exist");
	        }
		}
		else
		{
			regresar.setText("Retournieren");
			ingresar.setText("Eingeben");
			jebus.removeAllItems();
	        jebus.addItem("n.C.");
	        jebus.addItem("v.C.");
			asdf.setLanguage(2);
	        if(a==0)
	        {
        		ano.setText("Das Jahr 0 existiert nicht");
	        }
		}
		bis.setText(esbis[b][bisiesto]);
		horo.setText(tuanimal[b][animal]);
		if(acdcsito==true)
		{
	    	ano.setText(String.valueOf(a)+" "+jebus.getSelectedItem());
		}
		idioma=b;
	}
	public void paint(Graphics g) 
	{
		super.paint(g);
		Graphics2D g2=(Graphics2D) g;
		g2.drawImage(chino.getImage(),chino.getX(),chino.getY(),null);
	}
}
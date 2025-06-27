package clase;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Features extends JFrame
{
	String eng,esp,deu;
	JLabel texto;
	
	public Features()
	{
		setIconImage(new ImageIcon(getClass().getResource("Imags/megafono1.png")).getImage());
		setBackground(new Color(240,240,240));
		setTitle("Features");
	    setBounds(100, 100, 353, 437);
	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    setLayout(null);
	    setLocationRelativeTo(null);
	    setResizable(false);
	    setAlwaysOnTop(true);
	    setBackground(Color.black);
	    
	    eng="<center>VERSION 1.0</center><br><br>"
	    		+ "-custome made buttons(using golden ratio)<br>-available in 3 languages"
	    		+ "<br>-dark and light mode<br>-insert years up to 5 whole digits, and even before Christ<br>"
	    		+ "-removed herobrine<br>-you won't last 5 minutes playing this game<br>"
	    		+ "-get judged by that one red haired girl depending on your horoscope results<br>"
	    		+ "-join the sovietic union for free <br>-free 30 days trial";
	    
	    esp="<center>VERSI&Oacute;N 1.0</center><br><br>"
	    		+ "-botones personalizados(hechos usando la proporcion aurea)<br>"
	    		+"-disponible en 3 idiomas<br>-modos oscuro y claro<br>"
	    		+"-ingrese a&ntilde;os de hasta 5 digitos, antes y despues de cristo<br>"
	    		+"-se juzgado por una milipili basado en tu signo(tipico de piscis)<br>"
	    		+"-prueba gratuita de 30 dias!";
	    
	    deu="<center>AUSF&#220;HRUNG 1.0</center><br><br>"
	    		+"-ma&#223;geschneiderte Kn&#246;pfe (mit goldener Schnitt)<br>"
	    		+"-die Katze ist unter dem Tisch<br>"
	    		+"-verf&#252;gbar in 3 Sprachen<br>"
	    		+"-das Buch ist rot, 177013<br>"
	    		+"-dazu gibt es hausgemachte Pfannkuchen<br>"
	    		+"-"
	    		+"-30 Tage kostenlose Testversion<br>";
	    
	    texto=new JLabel ();
	    texto.setBounds(15,15,300,280);
	    texto.setOpaque(false);
	    texto.setForeground(Color.black);
	    texto.setEnabled(true);
	    add(texto);
	    
	}
	public void setLanguage(int a)
	{		
		if(a==0)
		{
			texto.setText("<html>"+esp+"</html>");
		}
		if(a==1)
		{
			texto.setText("<html>"+eng+"</html>");
		}
		if(a==2)
		{
			texto.setText("<html>"+deu+"</html>");
		}

	}
}
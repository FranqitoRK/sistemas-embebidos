package clase;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Lienzo extends JPanel
{
	JLabel label1;
	
	public Lienzo()
	{
		setLayout(null);
		label1=new JLabel("una boludez");
		label1.setBounds(185,100,150,40);
		label1.setFont(new Font("arial",Font.BOLD,20));
		add(label1);
		
	}
	public void establecerColorTexto(int a) 
	{
		if(a==1) 
		{
			label1.setForeground(new Color(255,0,255));
		}
		if(a==2) 
		{
			label1.setForeground(new Color(255,180,0));
		}
	}
}
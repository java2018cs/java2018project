import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import javax.swing.*;

import com.sun.glass.events.WindowEvent;


public class menu extends JFrame
{	

	JFrame j = new JFrame("音樂HarHar玩");
	JButton start = new JButton("GoGo");
	JButton help = new JButton("說明");
	JButton exit = new JButton("離開"); 
	private ButtonHandler handler =  new ButtonHandler();
	JLabel img = new JLabel(new ImageIcon("C:\\Users\\andy\\Downloads\\demo1\\back.jpg"));
	public menu()
	{

	j.setSize(1200,700);
  //j.setResizable(false);//視窗放大按鈕無效
   
    j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    start.setBounds(350, 200, 500, 100);
    j.add(start);
    help.setBounds(350,300,500,100);
    j.add(help);
    j.add(start);
    exit.setBounds(350,400,500,100);
    j.add(exit);
    j.add(img); 
    j.setVisible(true);
    start.addActionListener(handler);
    help.addActionListener(handler);
    exit.addActionListener(handler);
	}
	  
	private class ButtonHandler implements ActionListener
	{
		 public void actionPerformed(ActionEvent E)
		 {
			 if(E.getSource() == start)
			 {	
				j.getContentPane().removeAll();
				j.dispose();
				new DEMO1();
			 }
			 else if(E.getSource() == help)
			 {
				j.getContentPane().removeAll();
				j.dispose();
				new Help();
				
			 }
			 else if(E.getSource() == exit)
			 {           
				 j.dispose();   
				 return;
			 }
		 
		 }
	}
	
	 public static void main(String [] args){
	        new menu();
	    }
}

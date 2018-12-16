import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Help extends JFrame{
	JFrame j = new JFrame("操作說明");
	static JLabel lb;
	JButton BtnBack=new JButton("back");
	public Help(){
		super("操作說明");
		j.setSize(1200,700);
        
    
        /*
        背景
        **/
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon ic = new ImageIcon("D:\\00557103\\JAVA設計\\demo1\\bg.jpg");
		lb=new JLabel(ic);
		

		/*
		返回按鈕
		**/
		BtnBack.setBounds(5,10,90,30);
  		j.add(BtnBack);
  		j.add(lb);
  		
  		j.setVisible(true);
	}
 	public static void main(String [] args){
        Help id = new Help();
    }
}

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;


public class DemoFrame implements ActionListener
{
	JFrame image_fr;
	JButton b1_btn,b2_btn,b3_btn;
	JLabel txt_lb,img_lb;
	JSeparator jsp;

	public DemoFrame()
	{



		image_fr = new JFrame("Graphical Password authentication using Pass-Go");
		image_fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		image_fr.setLayout(null);
		image_fr.setBounds(200,200,400,400);

			img_lb = new JLabel(new ImageIcon("images/yy.jpg"))	;
			img_lb.setBounds(0,0,400,400);

			txt_lb = new JLabel("<html><body><font color='#0000' size='6'>Graphical Passwords</font></body></html>");
			txt_lb.setBounds(80,50,280,40);

			jsp= new JSeparator(SwingConstants.HORIZONTAL);
			jsp.setBounds(5,100,400,5);

			b1_btn = new JButton("REGISTER");
			b1_btn.addActionListener(this);
			b1_btn.setBounds(150,150,100,25);



			b2_btn = new JButton("LOGIN");
			b2_btn.addActionListener(this);
			b2_btn.setBounds(150,200,100,25);

			b3_btn = new JButton("CHANGE PASSWORD");
			b3_btn.addActionListener(this);
			b3_btn.setBounds(100,250,200,25);



		image_fr.add(txt_lb);
		image_fr.add(jsp);





		image_fr.add(b1_btn);
		image_fr.add(b2_btn);
		image_fr.add(b3_btn);

		image_fr.add(img_lb);
		image_fr.setVisible(true);

	}

	public void actionPerformed(ActionEvent e)
	{


		if(e.getSource() == b1_btn)
		{
						new usrname();
		image_fr.setVisible(false);
		}

		else if(e.getSource() == b2_btn)
		{

			new login();
		image_fr.setVisible(false);
		}

		else if(e.getSource() == b3_btn)
		{

			JOptionPane.showMessageDialog(null,"Enter current username and password" );
			new chlogin();
		image_fr.setVisible(false);
		}

	}





	public static void main(String args[]){
		new DemoFrame();
	}


}
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.net.*;

public class usrname extends JFrame {
	JButton ok;
	static JTextField uname;
	JLabel jl;
	String un;
	
	public usrname()
	{
		
		setLayout(null);
		setTitle("Graphical Password authentication using Pass-Go");
		this.getContentPane().setBackground(Color.lightGray);
		
		add(ok=new JButton ("ok"));
		add(uname=new JTextField(20));
		add(jl=new JLabel("USERNAME"));
		jl.setBounds(20,40,100,25);
		uname.setBounds(90,40,150,25);
		setLocation(250,300);
	
		ok.setBounds(250,40,60,25);
		
				
		  ok.addActionListener(new ActionListener() {
		  	
	public void actionPerformed(ActionEvent e ) {
		
			
    //MyData a = new MyData();
  un=uname.getText();
    if(un.isEmpty())
    {
    		JOptionPane.showMessageDialog(null,"enter the username" );
    }	
	 else 
	{
			String status="";
		try {
			
			Socket sock = new Socket("localhost",9999);
			BufferedReader buf = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			PrintStream ps = new PrintStream(sock.getOutputStream());
			
			ps.println("ucheck");
			ps.println(un);
		
			
			status = buf.readLine();
			
		//	JOptionPane.showMessageDialog(null,"login successfully");
			 
		  	 
			
			
		}catch(Exception ex) {
			
		}
		if(status.equals("ok")) {
		
			JOptionPane.showMessageDialog(null,"User Name already exists!! enter new username" );
		}
		else
		{
	    	new gridframe();
	    
	    	setVisible(false); 	
		}
	}


				}
			});
			
		setSize(350,200);
		setVisible(true);
			}
			




public static void main(String args[])
{
	SwingUtilities.invokeLater(new Runnable()
	{
		public void run()
		{
			new usrname();
		}
	});
}
}




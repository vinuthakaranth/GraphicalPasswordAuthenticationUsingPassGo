
import javax.swing.*;
import java.net.*;
import java.io.*;

import java.awt.event.*;


public class Server  implements Runnable
{

	ServerSocket ss;
	public Server()
	{
			try {

				ss = new ServerSocket(9999);
				new Thread(this).start();

			}catch(Exception ex) {

			}



	}

	public void run() {

		while(true) {
			try {
				System.out.println("Waiting for Socket");
				Socket sock = ss.accept();
				BufferedReader buf = new BufferedReader(new InputStreamReader(sock.getInputStream()));
				PrintStream ps = new PrintStream(sock.getOutputStream());

				String str = buf.readLine();

				if(str.equals("insert")) {
					MyData a = new MyData();
					String  s1 = buf.readLine();
					String  s2 = buf.readLine();
					String  s3 = buf.readLine();
					String  s4 = buf.readLine();

					a.insert(s1,s2,s3,Integer.parseInt(s4));
					ps.println("ok");

				}
					if(str.equals("inserts")) {
					MyData a = new MyData();
					String  s1 = buf.readLine();
					String s2 = buf.readLine();
					String s3 = buf.readLine();
					String s4 = buf.readLine();

					a.inserts(s1,s2,s3,Integer.parseInt(s4));
					ps.println("ok");

				}
				if(str.equals("ucheck")) {
					MyData a = new MyData();
					String  s1 = buf.readLine();

					boolean b=a.checkuname(s1);
					if(b)
					ps.println("ok");
					else
						ps.println("no");

				}
				if(str.equals("check")) {
					MyData a = new MyData();
					String  s1 = buf.readLine();
					String s2 = buf.readLine();
					String s3 = buf.readLine();
					String s4 = buf.readLine();

					boolean b=a.validate(s1,s2,s3,Integer.parseInt(s4));
					if(b) {
						ps.print("ok");
					}
					else {
						ps.print("no");
					}
				}
				
			/*	if(str.equals("welcome")) {
					
					try{
						
						FileInputStream fis = new FileInputStream("welcome.htm");
						byte b[] = new byte[fis.available()];
						fis.read(b);
						ps.print(new String(b));
						
						
					}catch(Exeption ex) {
						
					}
					
					
				}*/

				sock.close();

			}catch(Exception ex) {

			}

		}

	}




	public static void main(String args[]){
		new Server();
	}


}
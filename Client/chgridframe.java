import java.awt.*;
import java.net.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.event.*;


class chpaintPanel extends JPanel implements ChangeListener,MouseMotionListener,MouseListener
{
 JFrame frm;
 JLabel cho;
  public chpaintPanel( JFrame frm)	//constructor
  {
  	 final JFrame frm1=frm;
  frm=this.frm;
   
   setLayout(null);
   
   setBackground(Color.lightGray);
   slidex=new JSlider();
     add(xs=new JLabel("slider"));
     add(bt=new JButton("submit"));
   add(uname=new JLabel("UserName"));
   add(tbx=new JTextField(20));
   add(pass=new JLabel("Enter Password"));
   add(clear=new JButton("Clear"));
   add(Undo=new JButton("Undo"));
   add(browse=new JButton("browse"));
     add(cho=new JLabel("Choose Image"));
   add( p =new JPanel());
   p.setLayout(new GridLayout(2,3));
   p.add( skoala= new JButton( new ImageIcon("skoala.jpg")));
   p.add( sb=new  JButton(new ImageIcon("sb.jpg")));
   p.add( sc=new  JButton(new ImageIcon("sc.jpg")));
   p.add( sd=new  JButton(new ImageIcon("sd.jpg")));
   p.add( spen=new  JButton(new ImageIcon("spen.jpg")));
   p.add( sx=new  JButton(new ImageIcon("sx.jpg")));
   p.setBounds(500,180,150,100);
   p.setVisible(true);
   
   
   
    cho.setBounds(500,150,150,25);
   bt.addActionListener(new ActionListener() {
 
	public void actionPerformed(ActionEvent e ) {
   // MyData a = new MyData();
	String strt="";
	
		
		if(gp.size()==0)
		{
			slidex.enable();
			JOptionPane.showMessageDialog(new JFrame(),"No password found!!!");
			return;
			}

	
	for(int i=0;i<gp.size();i++)
	{
		strt+=gp.get(i) +",";
		
		
	}

	
	// Server -Interaction
	try {
			
			strt = strt.substring( 0, strt.lastIndexOf(","));
		Socket sock = new Socket("localhost",9999);
		BufferedReader buf = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		PrintStream ps = new PrintStream(sock.getOutputStream());
		
		ps.println("inserts");
		ps.println(chlpaintPanel.tbx.getText());
			ps.println(strt);
		ps.println(iname);
		ps.println(sca+"");
		
	
		
		JOptionPane.showMessageDialog(null,"registered successfully");
		 
	  	 frm1.setVisible(false);
					
				new DemoFrame();
		
		
	}catch(Exception ex) {
		
	}
	
	//a.insert (usrname.uname.getText(),strt,iname,sca);

	
	}
			});

				clear.addActionListener(new ActionListener() {		//clear button which clears all the points selected 
					 												//by user as password 
			public void actionPerformed(ActionEvent e ) {

				if(e.getSource()==clear)
				{
					count=0;
					count1=0;
					pc.clear();
					gp.clear();
					repaint();
						slidex.enable();
				}
			}
			});
			
			
		
			skoala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e ) {

				if(e.getSource()==skoala)
				{
				img = Toolkit.getDefaultToolkit().getImage("koala.jpg");
				iname="koala.jpg";
						repaint();
				}
			}
			});
				sb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e ) {

				if(e.getSource()==sb)
				{
				img = Toolkit.getDefaultToolkit().getImage("b.jpg");
				iname="b.jpg";
						repaint();
				}
			}
			});
				sc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e ) {

				if(e.getSource()==sc)
				{
				img = Toolkit.getDefaultToolkit().getImage("c.jpg");
						iname="c.jpg";
						repaint();
				}
			}
			});
				sd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e ) {

				if(e.getSource()==sd)
				{
				img = Toolkit.getDefaultToolkit().getImage("d.jpg");
				iname="d.jpg";
						repaint();
				}
			}
			});
				spen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e ) {

				if(e.getSource()==spen)
				{
				img = Toolkit.getDefaultToolkit().getImage("pen.jpg");
						
						iname="pen.jpg";
						repaint();
				}
			}
			});
				sx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e ) {

				if(e.getSource()==sx)
				{
				img = Toolkit.getDefaultToolkit().getImage("x.jpg");
						iname="x.jpg";
						repaint();
				}
			}
			});	

				Undo.addActionListener(new ActionListener() {		

			public void actionPerformed(ActionEvent e ) {

				if(e.getSource()==Undo)
				{
					
					if(s.size() >0) {
					
							String st=(String)s.peek();
						
						
                   				if(st.equals("0"))	//points
                   				{
                   					count1--; 
                   					s.pop();                   					
                   					int size = gp.size();
                   						
                   					gp.remove(--size);
                   					gp.remove(--size);
                   					//	System.out.println(gp);               				  
                   				
                   				}
                   				else if(st.equals("1"))
                   				{
                   					count--;
                   					s.pop(); 
                   						             //lines
                   				                     				    
                   					int size= gp.size();
                   					gp.remove(size-1);
                   					
                   					for(int i=size-2;i>=0;i--) {
                   					
                  						String cst = (String)gp.get(i);
                   						
                   						if(cst.equals("-1,-1")) {
                   							break;
                   						}
                   						gp.remove(i);
                   					}
                   					//	System.out.println(gp);
                   					
                   				}
                   				 
                   				if(s.size() ==0) {
                   						slidex.enable();
                   					SwingUtilities.updateComponentTreeUI(chpaintPanel.this);
                   				}                  			
                   			
                   				repaint();		
                   		
					} 
				}
					
			}
		});
			add(slidex=new JSlider());
            slidex.setMajorTickSpacing(5);
               	slidex.setMinimum(5);
               	slidex.setMaximum(20);
               	slidex.setValue(0);
               	slidex.setSnapToTicks(true);
                slidex.setPaintTicks(true);
                slidex.setPaintLabels(true);
                slidex.setBounds(50,400,200,50);
               slidex.setBackground(Color.lightGray);




				xs.setBounds(50,375,50,25);
				bt.setBounds(500,350,100,50);
				pass.setBounds(50,10,150,50);

				clear.setBounds(500,50,100,30);
				Undo.setBounds(500,100,100,30);

               slidex.addChangeListener(this);
               addMouseMotionListener(this);
               addMouseListener(this);

              bt.addMouseListener(this);
              bt.addMouseMotionListener(this);

               img =Toolkit.getDefaultToolkit().getImage("pen.jpg");
               iname="pen.jpg";

}


 public void stateChanged(ChangeEvent e) {

       if(e.getSource() == slidex) {
       		repaint();
       }
    }

    public void mouseDragged(MouseEvent e)
    {
    	   if (drawing)
			{
    		   Graphics g = getGraphics();
    		   g.setXORMode(getBackground());
    		   g.drawLine(start.x, start.y, end.x, end.y);
    		   end.setLocation(e.getX(), e.getY());
    		   g.drawLine(start.x, start.y, end.x, end.y);
            		   g.dispose();

            }
   }


    public boolean isSensitive(int x,int y) {
    	int width=300;
    	int scale =slidex.getValue();
  		 sca =slidex.getValue();
    	int grid=width/scale;

       	boolean sens=false;
    	for(int i=0;i<=scale;i++) {
    		for(int j=0;j<=scale;j++) {

    			int agx = (j*grid) + 50;
    			int agy = (i*grid) + 50;
    			double d =   Math.sqrt(Math.pow(agx-x,2) + Math.pow(agy-y, 2));				//distance formula
					slidex.disable();
    			if( d  <= (double)grid*(double)0.4) {
    				sens=true;
					bestx=j;
					besty=i;

					adjx =agx;
					adjy = agy;

    				return sens;
    			}

    		}
    	}

    	return sens;


    }   

    void addpoint(int gx,int gy) {

	
    	pc.add(gx+","+gy);	

    }

    
    public void mouseMoved(MouseEvent e)
    {

    }

      public void mousePressed(MouseEvent e)
    {

    	  if(isSensitive(e.getX(),e.getY()) ) {

          		if (count < 5000)
              	{
               		drawing = true;

					addpoint(bestx,besty);
               		start.setLocation(adjx, adjy);
               		end.setLocation(start);
               		Graphics g = getGraphics();
               		g.setXORMode(getBackground());
               		g.drawLine(start.x, start.y, end.x, end.y);
               		g.dispose();

              }
       	  }

    }


    public void mouseReleased(MouseEvent e)
    {
            if (drawing)
            {

            	if(isSensitive(e.getX(),e.getY())) {


            			end.x = adjx;
            			end.y = adjy;

            			drawing = false;
            			if (!start.equals(end))
            			{
            				ptStarts[count] = new Point(start);
            				ptEnds[count] = new Point(end);
            				count++;
            				repaint();
               			}
               			
              			flag=false;
          				if((start.x==end.x) || (start.y==end.y))						//checkin for ve n ho lines
		    				flag=true;
	     	 			else if((start.x-end.x)==(end.y-start.y) ||(end.x-start.x)==(start.y-end.y)||(start.x-end.x)==(end.y-start.y)||(start.x-end.x)==(start.y-end.y))
							flag=true;
				
						else
						{
			
							flag=false;	
							
		
						}
               			
               			if(flag)
               			{
               			
               				addpoint(bestx,besty);
               				addtograph(pc);
                   			
                 			Iterator it = pc.iterator();

                  			while(it.hasNext()) {

                   				String str=(String) it.next();
                   				gp.add(str);
                   				//System.out.println(str);
                   			}

                 			gp.add("-1,-1");
                   			pc.clear();
                   			repaint();
              			}
               			else {
               				
               				pc.clear();
               				
               				count--;
               				repaint();
               				
               			}
			   }
			   else {
			   		drawing=false;
			   		repaint();
			   }

            }

    }
   public void addtograph(HashSet pc)
    {
    	 Iterator  itr=pc.iterator();
    	 int c=0,l=0;
    	if(pc.size()==1)              	//point
    	{
    			int x11,y11;

				String p11 =(String)itr.next();
				StringTokenizer st = new StringTokenizer(p11,",");
    	 		x11 = Integer.parseInt(st.nextToken());
    	  		y11 = Integer.parseInt(st.nextToken());

				pc.add(x11+","+y11);
				s.push("0");    
    	}
    	if(pc.size()==2)				//line
    	{

	   	  	String p1 =(String)itr.next();
    	  	String p2 = (String) itr.next();
    	  	

    	  	int x1,x2,y1,y2,a,b;
    	  
    	  	//System.out.println(p1+":"+ p2);
    	  	StringTokenizer st = new StringTokenizer(p1,",");

    	  	x1 = Integer.parseInt(st.nextToken());
    	  	y1 = Integer.parseInt(st.nextToken());

    	  	st = new StringTokenizer(p2,",");

    	  	x2 = Integer.parseInt(st.nextToken());
    	  	y2 = Integer.parseInt(st.nextToken());

			pc.add(x1+","+y1);

    		if(x1==x2)			                                 //draws vertical line
    		{
    			if(y1<y2)
    			{
    				while(y1!=y2)
    				{
    					y1++;
    					pc.add(x1+","+y1);
    				}
    			}

    			else if(y1>y2)
    			{
    				while(y1!=y2)
    				{
    					y2++;
    
    				pc.add(x2+","+y2);
    				}
    			}
    		}

    	  	if(y1==y2)		                    	//draws horizontal line
    		{
    			if(x1<x2)
    			{
    				while(x1!=x2)
    				{
                            x1++;

    						pc.add(x1+","+y1);
    				}
    			}
    			else if(x1>x2)
    			{
    				while(x1!=x2)
    				{
    					x2++;

    					pc.add(x2+","+y2);
    				}
    			}


    		}

    		if(x1<=x2)				                    	//left to right diagonal line
    		{

    			a=x1;
                b=x2;

    			if(y1<=y2)
    			{
    				while(x1!=x2)
    				{
    					x1++;
    					y1++;

    					pc.add(x1+","+y1);
    				
    				}
    			}
    			

               else if(y1>y2)
    			{
    				while(c!=x2-a)
    				{
    					x1++;
    					y1--;

    					pc.add(x1+","+y1);
    					c++;
    				}
    			}

              pc.add(b+","+y2);

                }
         // gp.add("0,0");
         	//System.out.println(x2+","+y2);
         	if(x1>=x2)
         	{
         		a=x1;
                b=x2;

    			if(y1>=y2)
    			{
    				while(x1!=x2)
    				{
    					x1--;
    					y1--;

    					pc.add(x1+","+y1);
    				
    				}
    			}
    			else if(y2>=y1)
    			{
    				while(c!=a-x2)
    				{
    					y1++;
    					x1--;
    					pc.add(x1+","+y1);
    					c++;
    				}
    			}
    				
         	}
		 s.push("1");
	
			}
			
	    }
    
     public void mouseExited(MouseEvent e)
    {
    	if(e.getComponent()==bt)
    	{

              int type=Cursor.DEFAULT_CURSOR;
           	  Cursor c=new Cursor(type);
              setCursor(c);
    	}

    }
    public void mouseEntered(MouseEvent e)
    {

    		if(e.getComponent()==bt)
    		{
        	 int type=Cursor.HAND_CURSOR;
             Cursor c=new Cursor(type);
             setCursor(c);
    		}
    }
    public void mouseClicked(MouseEvent e)
    {
    		if(isSensitive(e.getX(),e.getY())) {

    			ptClick[count1] = new Point(adjx,adjy);
              	count1++;
             	repaint();
    		}



    }
     public void update(Graphics g)
     	 {
                paint(g);
         }
public void paintComponent(Graphics g)
{
		super.paintComponent(g);

	    int x1=50,x2=350,y1=50,y2=50;
        int y3=50,y4=350,x3=50,x4=50;
        int i,n=0;
        g.drawImage(img,50,50,this);
       // g.drawRect(50,50,250,250); //optional
       	g.drawLine(x1,y1,x2,y2);

         for(i=1;i<=slidex.getValue();i++)
               {
                       y1+=300/slidex.getValue();
                       y2+=300/slidex.getValue();
                       g.drawLine(x1,y1,x2,y2);
               }
                g.drawLine(x3,y3,x4,y4);
                for(i=1;i<=slidex.getValue();i++)
               {
                  x3=x3+300/slidex.getValue();
                  x4=x4+300/slidex.getValue();
                  g.drawLine(x3,y3,x4,y4);

               }
             	g.setColor(Color.red);
		
				
           for ( i = 0; i < count; i++)
           {

           	if(((ptStarts[i].x >=50 && ptEnds[i].x >=50) && (ptStarts[i].y >=50 && ptEnds[i].y >=50))&&(ptEnds[i].x <=350 && ptEnds[i].y <=350) && (ptStarts[i].x <=350  && ptStarts[i].y <=350))
           	{
           		Graphics2D g2 = (Graphics2D) g;
           		g2.setStroke(new BasicStroke(3));
			
            g.drawLine(ptStarts[i].x, ptStarts[i].y, ptEnds[i].x, ptEnds[i].y);

           	}
           }
			

           for( i=0;i<count1;i++) {
           		if((ptClick[i].x >=50 && ptClick[i].y >=50)  &&(ptClick[i].x <=350 && ptClick[i].y <=350))

           		{
           			g.fillOval(ptClick[i].x-5,ptClick[i].y-5,10,10);

           		}
}
}

 JSlider slidex;
 JLabel xs;
 JButton bt,clear,Undo,sc,sd,sb,spen,skoala,sx,browse;
 JLabel uname,pass;
 JTextField tbx;
String iname;
int sca;
 boolean flag=false;
 int mx2,my2,mx1,my1,mc1,mr1;
 Image img,img1,img2,img3;
 boolean first=true;
 int bestx,besty,adjx,adjy;
 HashSet <String> pc = new HashSet<String>();
 ArrayList <String> gp = new ArrayList<String>();
 Stack <String> s = new Stack<String>();        //undo
 int count = 0;
 public Point[] ptStarts = new Point[5000];
 public Point[] ptEnds = new Point[5000];
 public Point[] ptClick = new Point[5000];
 public Point[] db = new Point[5000];
 public Point start = new Point(), end = new Point(), click = new Point();
 public boolean drawing = false;
 int count1;

 JPanel p;
}

class chgridframe
{

chpaintPanel pp;
	 

chgridframe()
{
	
	JFrame Jfrm=new JFrame("Graphical Password authentication using Pass-Go");
	Jfrm.setSize(700,550);
	Jfrm.setLocation(180,100);
	Jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pp=new chpaintPanel(Jfrm);    
	Jfrm.add(pp);
	Jfrm.setVisible(true);
	            
}

public static void main(String args[])
{
	SwingUtilities.invokeLater(new Runnable()
	{
		public void run()
		{
			new chgridframe();
		}
	});
}




}

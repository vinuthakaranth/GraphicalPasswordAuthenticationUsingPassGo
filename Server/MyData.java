
        import java.sql.*;
      

        public class MyData {

                Connection cn;


                public MyData() {

                        try {					//loading of drivers

                                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        
                                cn = DriverManager.getConnection("jdbc:odbc:MyAccess","admin","");	//connection establishment

                        }catch(Exception ex)  {

                                System.out.println("Constructor:"+ex);
                        }



                }
                
               boolean checkuname(String user){
               	try{
               		
               		
               		String sql="select * from points where username=?";
               		PreparedStatement ps = cn.prepareStatement(sql);		
               	    ps.setString(1,user);
                   	
                    ResultSet i=ps.executeQuery();
                    
                    
                 return i.next();
         
               	}
               	catch(Exception ex){
               
               		System.out.println(ex);
               	}
               	 return false;     	
               }

               	void insert(String user,String pts,String iname,int slider) {
                      try{
    	 	
    	       		String sql ="insert into points Values(?,?,?,?)";
                    PreparedStatement ps = cn.prepareStatement(sql);
                  
                   	ps.setString(1,user);
                   	ps.setString(2,pts);
                   	ps.setString(3,iname);
                   	  	ps.setInt(4,slider);
                   	int i=ps.executeUpdate();
                 


              }catch(Exception ex) {
            //  JOptionPane.showMessageDialog(this,ex+"");
            	System.out.println(ex);
            
            	
              }
        	
     	}
     	void inserts(String user,String pts,String iname,int slider) {
                      try{
    	 	
    	       		String sql ="insert into points Values(?,?,?,?)";
                    
                    Statement stmt = cn.createStatement();
                    stmt.execute("Delete from points where username='"+user+"'");
                    stmt.close();
                    
                    PreparedStatement ps = cn.prepareStatement(sql);
                  
                   	ps.setString(1,user);
                   	ps.setString(2,pts);
                   	ps.setString(3,iname);
                   	  	ps.setInt(4,slider);
                   	int i=ps.executeUpdate();
                 


              }catch(Exception ex) {
            //  JOptionPane.showMessageDialog(this,ex+"");
            	System.out.println(ex);
            
            	
              }
        	
     	}
boolean validate(String user,String pts,String iname,int slider)
{
	String duser="",dpts="",diname="";
	int dslider=5;
	try{
		 //System.out.println("L:" +user+":"+pts+":"+iname+":"+slider);
		String sql="select * from points where username=?";
		
		 PreparedStatement ps = cn.prepareStatement(sql);
                  
                   ps.setString(1,user);
 ResultSet rs=ps.executeQuery();
                 if( rs.next())
                 {
                 duser=rs.getString(1);
                 dpts=rs.getString(2);
                 diname=rs.getString(3);
                 dslider=Integer.parseInt(rs.getString(4));
               
                 	
                 }
                 
                 
                 
                 if(duser.equals(user) && dpts.equals(pts) && diname.equals(iname) && dslider==slider)
                 {
                 	return true;
                 	
                 }
                 else
                 {
                 
                 	return false;
                 }
               
                 
	}catch(Exception ex) {
           
     System.out.println(ex);
	}
    return false;        
	
}
              


                }


       


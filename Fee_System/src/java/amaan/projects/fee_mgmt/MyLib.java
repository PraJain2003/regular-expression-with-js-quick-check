
package amaan.projects.fee_mgmt;
import java.sql.*;


public class MyLib 
{
        public Connection connect()
        {
            Connection cn=null;
            try
            {

                Class.forName("com.mysql.jdbc.Driver");
                String path="jdbc:mysql://localhost:3306/fee_system";
                String dbuser="root";
                String dbpass="";
                cn=DriverManager.getConnection(path,dbuser,dbpass);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }

            return cn;
        }



    public String getCourseName(int cid)
        {
            String s=null;
            try
            {
               Connection cn=new MyLib().connect();
               String sql="select * from st_course where course_id=?";
               PreparedStatement p1=cn.prepareStatement(sql);
               p1.setInt(1, cid);
               ResultSet r1=p1.executeQuery();
               if(r1.next())
               {
                   s=r1.getString("course_name");
               }            
            }
            catch(Exception e)
            {
                System.out.println(""+e);
            }
        return s;
    }


    public int course_paid(int s_id,int course_id)
    {
        int t=0; 
        try
        {
            Connection cn=this.connect();
            String sql="select * from st_installment where s_id=? and course_id=?";
            PreparedStatement p1=cn.prepareStatement(sql);
            p1.setInt(1, s_id);
            p1.setInt(2, course_id);
            ResultSet r1=p1.executeQuery();
            while(r1.next())
            {
                t=t+r1.getInt("amount");
            }
          }  
         catch(Exception e)
         {
             System.out.println(e);
         }
         return t;
    }
}
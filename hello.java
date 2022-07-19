import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class hello {
	public static void main(String[] args) {
		System.out.println("Hello JAVA!! Maven Project!!");
		Connection con = null;
		 
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(
                    "jdbc:mysql://158.247.206.97:31307/haryul?useSSL=false", // DB URL
                    "haryul", "haryul");  // USER_NAME과 PASSWORD
            System.out.println("Success");
        }
        catch(SQLException ex){ 
            System.out.println("SQLException" + ex);
            ex.printStackTrace();
        }
        catch(Exception ex){ 
            System.out.println("Exception:" + ex);
            ex.printStackTrace();
        }
	}
}

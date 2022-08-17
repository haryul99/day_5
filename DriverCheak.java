package haryul;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class DriverCheak {
	
	public static void main(String args[]){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
        Connection con = null;
        System.out.println("start test");
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(
                    "jdbc:mysql://158.247.206.97:31307/haryul?useSSL=false", // DB URL
                    "haryul", "haryul");  // USER_NAME과 PASSWORD
            System.out.println("Success");
            
            String sql = "select * from vo";
            pstmt = con.prepareStatement(sql); 
             
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
	
	public static void conClose(Connection conn, PreparedStatement pstmt, ResultSet rsRs){
    	try {
    		if (rsRs != null) try { rsRs.close(); rsRs = null; } catch(Exception ex){}
    		if (pstmt != null) try { pstmt.close(); pstmt = null; } catch(Exception ex){}
    		if (conn != null) try { conn.close(); conn = null; } catch(Exception ex){}
    	}catch(Exception e2){}
	}
		
	public static void conClose(Connection conn, PreparedStatement pstmt){
		try{
			if (pstmt != null) try { pstmt.close(); pstmt = null; } catch(Exception ex){}
			if (conn != null) try { conn.close(); conn = null; } catch(Exception ex){}
		}catch (Exception e2){}		
	}
}

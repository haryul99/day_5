package haryul;

public class QueryMap {
	public static String AllView() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT * ");
		buffer.append("FROM Vo ");
		
		return buffer.toString();
	}
	
	public static String testSelect(){
    	StringBuffer buffer=new StringBuffer();
    	buffer.append("SELECT ID, NAME, BIRTHDAY, DELETEHA");
    	buffer.append("FROM Vo ");
    	buffer.append("WHERE ID=?");
    	buffer.append("ORDER BY ID ASC");
    	
    	return buffer.toString();
    }
	
	public static String testNameView() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT ID, NAME, BIRTHDAY, DELETEHA ");
		buffer.append("FROM Vo ");
		buffer.append("WHERE NAME=? ");
		buffer.append("ORDER BY NAME DESC");
		
		return buffer.toString();
	}
	
	//asc = 오름차순, desc = 내림차순
	
	public static String Inserttt() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("INSERT INTO Vo(ID, NAME, BIRTHDAY, DELETEHA ");
		buffer.append("VALUES(?,?,sysdate(),'Y'");
		
		return buffer.toString();
	}
    
}

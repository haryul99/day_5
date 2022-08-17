package haryul;

public class QueryMap {
	public static String AllView() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT * ");
		buffer.append("FROM haryul.Vo ");
		
		return buffer.toString();
	}
	
	public static String testSelect(){
    	StringBuffer buffer=new StringBuffer();
    	buffer.append("SELECT * ");
    	buffer.append("FROM haryul.Vo ");
    	buffer.append("WHERE ID=?");
    	buffer.append("ORDER BY ID ASC");
    	
    	return buffer.toString();
    }
	
	public static String testNameView() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT ID, NAME, BIRTHDAY, DELETEHA \n ");
		buffer.append("FROM haryul.Vo \n");
		buffer.append("WHERE NAME=? \n");
		buffer.append("ORDER BY NAME DESC");
		
		return buffer.toString();
	}
	
	//asc = 오름차순, desc = 내림차순
	
	public static String Inserttt() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("INSERT INTO haryul.Vo(ID, NAME, BIRTHDAY, DELETEHA ");
		buffer.append("VALUES(?,?,sysdate(),'Y'");
		
		return buffer.toString();
	}
    
}

package haryul;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class TestCr {
	String id = null;
	String name = null;
	Boolean bool = false;
	
	
	 public boolean testInsert(String id, String name){
	    	System.out.println("testInsert 함수 진입 > ");
	    	
	    	Connection conn=null;
	    	PreparedStatement pstmt=null;
	    	int nCnt=0;
	    	Boolean bool=false;
	    	Vo tvo=null;
	    	
	    	try{
	    		
	    		// 쿼리문 받아오기
	    		String sql=QueryMap.Inserttt();
	    		pstmt=conn.prepareStatement(sql);
	    		
	    		System.out.println("INSERT     > \n"+sql);
	    		
	    		// setter
	    		tvo = new Vo();
	    		tvo.SetId(id);
	    		tvo.SetName(name);
	    		
	    		// getter and PreparedStatement setString
	    		pstmt.setString(1, tvo.GetId());
	    		pstmt.setString(2, tvo.GetName());
	    		
	    		nCnt = pstmt.executeUpdate();
	    		
	    		// commit이 안 됐을 경우  commit
	    		if(!conn.getAutoCommit()) conn.commit();
	    		
	    		System.out.println(nCnt+"건 등록되었음.");
	    		if (nCnt>0) {bool=true;}
	    		DriverCheak.conClose(conn, pstmt);
	    	}catch(Exception e){
	    		System.out.println("testInsert 함수 내 에러    >  "+e.getMessage());
	    	}finally{
	    		DriverCheak.conClose(conn, pstmt);
	    	}
	    	
	    	return bool;
	    }
	    
	    // SELECT ALL
	    public ArrayList<Vo> testSelectAll(){
	    	Connection conn = null;
	    	PreparedStatement pstmt = null;
	    	ResultSet rsRs = null;
	    	ArrayList<Vo> arr = null;
	    	Vo _tvo = null;
	    	
	    	try {
	    		conn=DriverManager.getConnection(
	                    "jdbc:mysql://158.247.206.97:31307/haryul?useSSL=false", // DB URL
	                    "haryul", "haryul");  // USER_NAME과 PASSWORD
	            System.out.println("Success");
	    		String sql= QueryMap.AllView();
	    		pstmt=conn.prepareStatement(sql);
	    		System.out.println("전체 조회   >  \n"+sql);
	    		rsRs=pstmt.executeQuery();
	    		
	    		if(rsRs!=null) {
	    			arr=new ArrayList<Vo>();
	    			
	    			while(rsRs.next()){
	    				_tvo=new Vo();
	    				_tvo.SetId(rsRs.getString(1)); // ID
	    				_tvo.SetName(rsRs.getString(2)); // NAME
	    				_tvo.SetBirthday(rsRs.getString(3)); // INSERTDATE
	    				_tvo.SetDeleteha(rsRs.getString(5)); // DELETEYN
	    				
	    				arr.add(_tvo);
	    			} 
	    		}else{
	    			System.out.println("전체 조회 결과가 없습니다 >>> : "+rsRs);
	    		}
	    	}catch(Exception e){
	    		System.out.println("전체조회중 에러가 >>> : "+e.getMessage());
	    	}
	    	
	    	return arr;
	    }
	    
	    // SELECT
	    public ArrayList<Vo> testSelect(String id){
	    	Connection conn=null;
	    	PreparedStatement pstmt=null;
	    	ResultSet rsRs=null;
	    	ArrayList<Vo> arr=null;
	    	Vo tvo=null;
	    	Vo _tvo=null;
	    	
	    	try {
	    		conn=DriverManager.getConnection(
	                    "jdbc:mysql://158.247.206.97:31307/haryul?useSSL=false", // DB URL
	                    "haryul", "haryul");  // USER_NAME과 PASSWORD
	            System.out.println("Success");
	    		String sql=QueryMap.testSelect();
	    		pstmt=conn.prepareStatement(sql);
	    		System.out.println("조건 조회 >>> : \n"+sql);
	    		
	    		// setter
	    		tvo=new Vo();
	    		tvo.SetId(id);
	    		
	    		pstmt.clearParameters();
	    		// getter and PreparedStatement setString
	    		pstmt.setString(1, tvo.GetId());
	    		
	    		rsRs=pstmt.executeQuery();
	    		
	    		if(rsRs!=null) {
	    			arr=new ArrayList<Vo>();
	    			
	    			while(rsRs.next()){
	    				_tvo=new Vo();
	    				_tvo.SetId(rsRs.getString(1)); // ID
	    				_tvo.SetName(rsRs.getString(2)); // NAME
	    				_tvo.SetBirthday(rsRs.getString(3)); // INSERTDATE
	    				_tvo.SetDeleteha(rsRs.getString(5)); // DELETEYN
	    				
	    				arr.add(_tvo);
	    			} 
	    		}else{
	    			System.out.println("조건 조회 결과가 없습니다 >>> : "+rsRs);
	    		}
	    	}catch(Exception e){
	    		System.out.println("에러 발생 > : "+e.getMessage());
	    	}
	    	
	    	return arr;
	    }
		public static void main(String[] args) {
			Scanner sc=null;
			sc=new Scanner(System.in);
			int ans=0;
			
			try{
				System.out.println("<<< Vo 테이블에서 데이터 조회 및 입력      	 \n");
				System.out.println("1 >> 데이터를 추가합니다. (INSERT)  		 \n");
				System.out.println("2 >> 데이터를  전체 조회합니다. (SELECT ALL) \n");
				System.out.println("3 >> 데이터를  아이디로 조회합니다. (SELECT)   \n");
				System.out.println("0 >> 종료   \n");
				
				ans=sc.nextInt();
				
				String id=null;
				String name=null;
				Boolean bool=false;
				
				switch(ans){
				case 0 : System.out.println("0번 입력 \n");
						System.out.println(ans+"번을 입력하셨습니다.");
						System.out.println("----시스템 종료---- ");
						sc.close();
						System.exit(0);
						
				case 1 : System.out.println("1번 입력 \n");
					
						System.out.println("ID를 입력하세요. > \n");
						Scanner sc2=new Scanner(System.in);
						id=sc2.next();
						System.out.println("입력한 ID >>> : "+id);
						
						System.out.println("이름을 입력하세요 >  \n");
						Scanner sc3=new Scanner(System.in);
						name=sc3.next();
						System.out.println("입력한 NAME >>> : "+name);
						
						TestCr ts=new TestCr();
						bool=ts.testInsert(id, name);
						if(bool){
							System.out.println("성공적으로 INSERT가 되었습니다.");
						}else{
							System.out.println("INSERT를 실패하였습니다  >>> : "+bool);
						}
						
						break;
					
				case 2 : System.out.println("2번 입력 \n");
						ArrayList<Vo> arr=new ArrayList<Vo>();
						TestCr ts1 = new TestCr();
						
						arr= ts1.testSelectAll();
						
						if(arr!=null&&arr.size()>0){
							System.out.print("ID : NAME : BIRTHDAY : DELETEYN \n");
							for (int i=0; i<arr.size(); i++){
								Vo _tvo=arr.get(i);
								_tvo.PrintVo(_tvo);
							}
						}
						break;
				case 3 : 
						System.out.println("3번 입력 \n");
						System.out.println(ans+"번을 입력하셨습니다.");
						System.out.println("조회할 테스트ID를 입력하세요. >>> : \n");
					
						Scanner sc1 = new Scanner(System.in);
						id =sc1.next();
						System.out.println("입력한 id >>> : "+id);
						
						TestCr ts11 = new TestCr();
						
						ArrayList<Vo> arr1 = new ArrayList<Vo>();
						
						arr1= ts11.testSelect(id);
						
						if(arr1!=null&&arr1.size()>0){
							System.out.print("ID : NAME : BIRTHDAY : DELETEYN \n");
							for (int i=0; i<arr1.size(); i++){
								Vo _tvo=arr1.get(i);
								_tvo.PrintVo(_tvo);
							}
						}	
						break;
				}
			}catch(Exception e){
				System.out.println(" TEST 테이블에서 데이터 조회 및 입력하기 도중 실패 >>> : "+e.getMessage());
			}		
		}
}

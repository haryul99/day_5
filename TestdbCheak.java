
public class TestdbCheak {
	// 1. Connect 함수 hello.java 함수 사용해서 먼저실행
	// Class.forName
	// DriverManger.getConnection
	
//	DriverManger : JDBC 드라이버 로드
//	Connectoin : DB와 연결하기 위한 인터페이스
//	Statement / PreparedStatement / CallableStatement (SQL을 보내기 위한 통로)
//
//	Statement : SQl을 보내기 위한 통로. 인자가 없음.  
//	PreparedStatement : Statement와 동일한데 차이점은 인자값으로 SQL을 받기 때문에 특정한 SQL에 대한 통로라고 생각하면 된다. 
//	CallableStatement : PL/SQL을 호출할 때 사용
//	ResultSet : SQL문의 결과를 저장하는 객체
//	
	// 2. Statement vs PreparedStatement
	// 정적 vs 동적
	// PreparedStatement : 쿼리문 작성해서
	// 조회 : ResultSet 
	// 입력 : ResultSet X
	
	// where 절에 들어갈 것을 Scanner로 받아도 되고, 아니면 여기서 정해놓고 해도 되고
	
	// 쿼리문 담는 함수
	// String => 객체가 여러개 생김
	// StringBuffer 클래스 "~~~~"
	// String 변환해서 객체 한개 만들어서
	
	
	// PreparedStatement 에 쿼리를 담아서 조회 후 출력
	
	// Select만
	// VO 클래스 만들어서
	//  1 2 3 4 5 
	//  가 나 다 라 마
	// 12345 <= VO 클래스 참조변수
	// ArrayList에 담는다
	// 0 index : 12345
	// 1 index : 가나다라마바
	
	// while 문써서 반복해서 VO클래스 참조변수를 print 시킨다.
	// 콘솔창에 결과가 뜹니다.
	
	public static void main(String[] args) {
		
		
	}
}

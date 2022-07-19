
public abstract class TESTQueryMap {
	// 전체 테이블 조회
		public static String testSelectAll(){
			StringBuffer sb=new StringBuffer();
			sb.append("SELECT ID, NAME, INSERTDATE, UPDATEDATE, DELETEYN     \n");
			sb.append("FROM imyoseob.TEST \n");
			sb.append("ORDER BY ID ASC \n");
			
			return sb.toString();
		}
		
		// 해당 테이블 select
		public static String testSelect(){
			StringBuffer sb=new StringBuffer();
			sb.append("SELECT cl.1, clu.101       \n");
			sb.append("FROM class cl, club clu     \n");
			
			return sb.toString();
		}
}

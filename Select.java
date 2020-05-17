package ConnectEx;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Select {

	public int[] sqlSelect() {
		
		int[] ret = new int[5];
		Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        
        String ip = "192.168.119.119";
        String sid = "dink";
      String user = "scott";
      String password = "tiger";
        
        try {
            
            conn = DBUtil.getConnection(ip, sid, user, password);
            stat = conn.createStatement();
            System.out.println(conn.isClosed() ? "Á¢¼Ó¾ÈµÊ":"Á¢¼ÓµÊ");
            
            String str = "SELECT TRUNC(AVG(CREDIT_LIMIT)) as cnt FROM customer WHERE trunc((to_char(sysdate, 'rrrr') - to_char(BIRTH_DT, 'rrrr') + 1)/10) = ";
            String sql = str + "2 UNION ALL " + str + "3 UNION ALL " + str + "4 UNION ALL " + str + "5 UNION ALL " + str + "6";
            		
            rs= stat.executeQuery(sql);

            int i = 0;
            while(rs.next()) {
            	ret[i] = rs.getInt("cnt");
            	//System.out.println((i*10) + "´ë Æò±Õ Ä«µå Á¦ÇÑ ±Ý¾×: " + rs.getInt("cnt"));
            	i++;
            }

            stat.close();
            conn.close();
            
            
        } catch (Exception e) {
            System.out.println("JDBCTest.main()" + e.toString());
        }
        
        return ret;
	}
   
}
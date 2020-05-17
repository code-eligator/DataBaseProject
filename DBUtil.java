package ConnectEx;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

   public static Connection getConnection(String ip, String sid, String id, String pw) {
        Connection conn = null;
        String url = String.format("jdbc:oracle:thin:@%s:1521:%s",ip, sid);
 
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
 
            conn = DriverManager.getConnection(url, id, pw);
 
            return conn;
        } catch (Exception e) {
            System.out.println("DBUtil.getConnection() : " + e.toString());
        }
 
        return null;
    }
}
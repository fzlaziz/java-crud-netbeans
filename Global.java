import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Global {
  public static String id;
  public static String sql;
  public static int JmlRec(String sql) throws SQLException {
    int n=0;
    java.sql.Connection db=(Connection)KoneksiDB.getKoneksi();
    try (PreparedStatement q = db.prepareStatement(sql)) {
      java.sql.ResultSet rs = q.executeQuery();
      while ( rs.next() ) 
      {
        n++;
      } // end while
    } // end try
    return n;
  }
} // end Class

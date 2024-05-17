import java.sql.Connection;
import java.sql.DriverManager;
public class KoneksiDB {
  private static Connection koneksi;
  public static Connection getKoneksi(){
    try {
      DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
      String url="jdbc:mysql://localhost:3306/dataku"; //url databaseString
      user="root"; //user databaseString
      pass=""; //password 
      databasekoneksi=DriverManager.getConnection(url, user, pass); 
      System.out.println("Berhasil Koneksi");
    } 
    catch (Exception e) {
      System.err.println("koneksi gagal "+ e.getMessage()); //perintah menampilkan error pada koneksi
    }
    return koneksi;
  } 
  public static void main(String[] args)
  {
    //private Connection koneksi2;
    koneksi = getKoneksi();
  } 
}

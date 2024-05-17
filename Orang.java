import java.sql.ResultSet;
import java.sql.* ;
import javax.swing.table.DefaultTableModel;
public class Orang extends Data {
  private String id;
  private String kota;
  private String telp;
  public Orang(String id, String nama, String alamat, String kota, String telp ) 
  {
    super(nama, alamat);
    this.id = id;
    this.kota = kota;
    this.telp = telp;
  }
  public String getId() {return id;}
  public String getKota() {return kota;}
  public String getTelp() {return telp;}
  public void setId(String id) {this.id = id;}
  public void setKota(String kota) {this.kota = kota;}
  public void setTelp(String telp) {this.telp = telp;}
  @Override 
  public void info() {
    System.out.println("ID " + getId());
    System.out.println("Nama " + getNama());
    System.out.println("Alamat " + getAlamat());
    System.out.println("Kota " + getKota());
  }

  public static void baca_data(DefaultTableModel tb, String sql) throws SQLException
  {
    java.sql.Connection db=(Connection)KoneksiDB.getKoneksi();
    try (PreparedStatement q = db.prepareStatement(sql)) 
    {
      ResultSet rs = q.executeQuery();
      while (rs.next()) {
        tb.addRow(new Object[]{
          rs.getString("id"),
          rs.getString("nama"),
          rs.getString("alamat")
        });
      } // end while
    }// end try 
  }// end baca_data

  public static void Add(Orang orang) throws SQLException {
    java.sql.Connection db=(Connection)KoneksiDB.getKoneksi();
    String sql = "INSERT INTO r_orang (id, nama, alamat, kota, telp) VALUES (?, ?, ?, ?, ?)";
    try (PreparedStatement q = db.prepareStatement(sql)) {
      q.setString(1, orang.getId());
      q.setString(2, orang.getNama());
      q.setString(3, orang.getAlamat());
      q.setString(4, orang.getKota());
      q.setString(5, orang.getTelp());
      q.executeUpdate();
    }
  } 


  public static void Edit(Orang orang) throws SQLException {
    java.sql.Connection db=(Connection)KoneksiDB.getKoneksi();
    String sqledit = "UPDATE r_orang SET nama = ?, alamat = ?, kota = ?, telp=? WHERE id ='" + orang.getId()+"'";
    try (PreparedStatement q = db.prepareStatement(sqledit)) {
      q.setString(1, orang.getNama());
      q.setString(2, orang.getAlamat());
      q.setString(3, orang.getKota());
      q.setString(4, orang.getTelp());
      q.executeUpdate();
    }
  } 


  public static boolean Del(String id) throws SQLException {
    java.sql.Connection db=(Connection)KoneksiDB.getKoneksi();
    boolean tf;
    String sql = "DELETE FROM r_orang WHERE id = '" + id + "' ";
    try (PreparedStatement q = db.prepareStatement(sql)) {
      int efek = q.executeUpdate();
      if (efek > 0) {
        tf=true;
      } else {
        tf=false;
      }
    }
    return tf;
  } 


  public static void main(String[] args) {
    
  }
  
}


  


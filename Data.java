public class Data {
  private String nama;
  private String alamat;
  public Data(String nama, String alamat)
  {
    this.nama = nama;
    this.alamat = alamat;
  }
  public String getNama() {return nama;}
  public String getAlamat() {return alamat;}
  public void setNama(String nama) {this.nama = nama;}
  public void setAlamat(String alamat) {this.alamat = alamat;}
  public void info() {
    System.out.println("Nama " + nama);
    System.out.println("Alamat " + alamat);
  }
}

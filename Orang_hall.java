import com.stripbandunk.jwidget.model.DefaultPaginationModel;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
public class Orang_hal1 extends javax.swing.JFrame {
 int kol;
 int baris;
 String order;
 String ascdes;
 private DefaultPaginationModel paginationModel;
 private DefaultTableModel tb= new DefaultTableModel();
 
 public Orang_hal1() {
  initComponents();
  tb.addColumn("Id");
  tb.addColumn("Nama");
  tb.addColumn("Alamat");
  tbData.setModel(tb); 
  ascdes=" ASC";
 
  cbkol.removeAllItems();
  cbkol.addItem("id");
  cbkol.addItem("nama");
  cbkol.addItem("alamat");
 
  cbtampil.removeAllItems();
  cbtampil.addItem("10");
  cbtampil.addItem("20");
  cbtampil.addItem("50");
  cbtampil.addItem("70");
  cbtampil.addItem("100");
  try {
    IsiTabel();
  } catch (SQLException ex) {
  }
 
 }

private void IsiTabel() throws SQLException {
 String tampil = (String)cbtampil.getSelectedItem();
 String f = (String)cbkol.getSelectedItem();
 order = " ORDER BY " + f + ascdes ;
 Global.sql="Select * FROM r_orang WHERE id <> '' ";
 KosongTabel();
 String cari = txtcari.getText();
 String sql =Global.sql;
 if (!cari.isEmpty()) {
 sql = sql + " AND ( id like '%" + cari + "%' ";
 sql = sql + " OR nama like '%" + cari + "%' ";
 sql = sql + " OR kota like '%" + cari + "%' ";
 sql = sql + " OR telp like '%" + cari + "%' ";
 sql = sql + " OR alamat like '%" + cari + "%' ) ";
 }
 Global.sql = sql + order;
 
 paginationModel = new DefaultPaginationModel();
 //Kita misalkan ada 500 record, disini bisa lakukan count di DB
 paginationModel.setTotalItem(Global.JmlRec(Global.sql));
 //Mengeset jumlah record untuk satu halaman
 int n = Integer.parseInt(tampil);
 paginationModel.setPageSize(n);
 Halaman.setModel(paginationModel); 
 sql = Global.sql + " limit " + n;
 Orang.baca_data(tb,sql);
 System.out.println(sql);
}

  private void KosongTabel(){
   baris = tb.getRowCount();
   for (int i=0; i < baris; i++ ) {
    tb.removeRow(0);
   }
 }

  






  
private void tbDataMouseClicked(java.awt.event.MouseEvent evt) { 
 // TODO add your handling code here:
 baris = tbData.getSelectedRow();
 kol = tbData.getSelectedColumn();
 
 Object id = tbData.getValueAt(baris, 0);
 Global.id = id.toString();
 }


/**
 *
 * @return
  **/

private void btnEditActionPerformed(java.awt.event.ActionEvent evt) { 
 // TODO add your handling code here:
 new Orang_edit_frm().setVisible(true);
} 
private void btnAddActionPerformed(java.awt.event.ActionEvent evt) { 
 // TODO add your handling code here:
 new Orang_add_frm().setVisible(true);
} 
private void btnDelActionPerformed(java.awt.event.ActionEvent evt) { 
 // TODO add your handling code here:
 new Orang_del_frm().setVisible(true);
}




private void HalamanOnPageChange(com.stripbandunk.jwidget.event.PaginationEvent evt) { 
 // TODO add your handling code here:
 // digunakan untuk mengeset limit pada query DB
 int limit = (evt.getCurrentPage() - 1) * evt.getPageSize();
 //contoh query
 String sql =Global.sql + " Limit " + limit + ", " + evt.getPageSize();
 //System.out.println(sql);
 try {
 KosongTabel();
 Orang.baca_data(tb,sql);
 } catch (SQLException ex) {
 }
 
 }


private void btntampilActionPerformed(java.awt.event.ActionEvent evt) { 
 try {
  IsiTabel();
   
} catch (SQLException ex) {
 System.out.println(ex);
 }
 } 
 
private void btncariActionPerformed(java.awt.event.ActionEvent evt) { 
 try {
 IsiTabel();
 } catch (SQLException ex) {
 //
 }
 } 
 private void btnascActionPerformed(java.awt.event.ActionEvent evt) { 
 // TODO add your handling code here:
 ascdes = " ASC";
 try {
 IsiTabel();
 } catch (SQLException ex) {
 //
 }
 }


  private void btndescActionPerformed(java.awt.event.ActionEvent evt) { 
 // TODO add your handling code here:
 ascdes = " DESC";
 try {
 IsiTabel();
 } catch (SQLException ex) {
 //
 }
 }

  
/**
 * @param args the command line arguments
 */

  




  // Variables declaration - do not modify 
 private com.stripbandunk.jwidget.JPagination Halaman;
 private javax.swing.JButton btnAdd;
 private javax.swing.JButton btnDel;
 private javax.swing.JButton btnEdit;
 private javax.swing.JButton btnasc;
 private javax.swing.JButton btncari;
 private javax.swing.JButton btndesc;
 private javax.swing.JButton btntampil;
 private javax.swing.JComboBox<String> cbkol;
 private javax.swing.JComboBox<String> cbtampil;
 private javax.swing.JLabel jLabel1;
 private javax.swing.JLabel jLabel2;
 private javax.swing.JScrollPane jScrollPane1;
 private javax.swing.JTable tbData;
 private javax.swing.JTextField txtcari;
 // End of variables declaration
  






  
}

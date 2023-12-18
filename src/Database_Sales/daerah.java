/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Database_Sales;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
/**
 *
 * @author al190
 */
public class daerah extends javax.swing.JFrame {
    
    public Connection conn;
    public Statement stat;
    public ResultSet rs;
    public DefaultTableModel tb;

    /**
     * Creates new form daerah
     */
   public daerah(){
   initComponents();
   String [] judul = {"No","Kode Daerah","Nama Daerah"};
   tb = new DefaultTableModel(judul,0);
   TableDaerah.setModel(tb);
   tampildata();
   lebarkolom();
   padam();
   hidup();
   }
   
   
   public void tampildata(){
   Koneksi classKoneksi = new Koneksi();
   int jumlahrow = TableDaerah.getRowCount();
   for (int i=0; i<jumlahrow; i++){
       tb.removeRow(0);
   }
    try {
    conn = classKoneksi.getKoneksi();
    stat = conn.createStatement();
    rs = stat.executeQuery("SELECT * FROM daerah");
    int no = 1;
    while(rs.next()){
        String [] row = { Integer.toString(no),rs.getString(1),rs.getString(2)};
        tb.addRow(row);
        no++;
    }
}
    catch (SQLException ex){
        System.out.print(ex.getMessage());
    }
}

   
   public void lebarkolom() {
        TableColumn column;
        TableDaerah.setAutoResizeMode (javax.swing.JTable.AUTO_RESIZE_OFF);
        column=TableDaerah.getColumnModel().getColumn(0);
        column.setPreferredWidth (30);
        column=TableDaerah.getColumnModel().getColumn (1);
        column.setPreferredWidth (150);
        column=TableDaerah.getColumnModel().getColumn (2);
        column.setPreferredWidth (310);
    }
        public void padam() {
        txtKode.setEnabled(false);
        txtDaerah.setEnabled(false);
    }
        public void hidup() {
        txtKode.setEnabled(true);
        txtDaerah.setEnabled(true);
        txtKode.requestFocus();
    }
        
        private void simpan() {
            Koneksi konek = new Koneksi();
            if (txtKode.getText().equals("")) { 
                JOptionPane.showMessageDialog(null, "Kode Daerah tidak boleh kosong");
                txtKode.requestFocus();
            }    
            else if (txtDaerah.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Nama Daerah tidak boleh kosong");
                txtDaerah.requestFocus();
            } else {
                try{
                conn = konek.getKoneksi();
                stat = conn.createStatement();
                
                stat.executeUpdate("INSERT INTO daerah VALUES('"+txtKode.getText()+"," + "'"+txtDaerah.getText()+"')");
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan", "Alert", JOptionPane.INFORMATION_MESSAGE);
                tampildata();
            } catch (SQLException ex) { {
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan", "Alert", JOptionPane. INFORMATION_MESSAGE);
                System.out.print(ex.getMessage());
            }
        }
    }
}
        
        public void Angka (KeyEvent e) {
            if (Character.isAlphabetic(e.getKeyChar())) {
            e.consume ();
            JOptionPane.showMessageDialog(null, "Kode Daerah Wajib Angka", "Peringatan", +JOptionPane. WARNING_MESSAGE);
        }
    }
        
        public void Huruf (KeyEvent a) {
            if (Character.isDigit(a.getKeyChar())) {
            a.consume();
            JOptionPane.showMessageDialog(null, "Nama Daerah Wajib Huruf", "Peringatan", +JOptionPane.WARNING_MESSAGE);
        }
    }
        
        public void hapus () {
            txtKode.setText (null);
            txtDaerah.setText (null);
        }
        
        public void cariData () {
            String Kode = txtKode.getText();
            try {
            int baris = TableDaerah.getRowCount();
            for (int i=0; i < baris; i++) { tb.removeRow(0); 
            }
            String SQL = "SELECT * FROM daerah WHERE iddaerah = '"+Kode+"'"; 
            ResultSet rs = stat.executeQuery(SQL);
            
            int no = 1;
            while(rs.next()) {
                String [] row = { Integer.toString(no), rs.getString(1), rs.getString(2)}; tb.addRow(row);
                no++;
            }
            
            System.out.println("Berhasil menampilkan pencarian");
        } catch (SQLException ex) {
            System.err.print(ex);
    }
}
        
        public void Cari () {
            String Kata = txtKode.getText(); System.out.println(Kata);
            if (Kata !="") {
            cariData();
            } else {
            tampildata();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtKode = new javax.swing.JTextField();
        txtDaerah = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        btnBaru = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableDaerah = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Kode Daerah");

        jLabel2.setText("Nama Daerah");

        btnCari.setText("Cari");

        btnBaru.setText("Baru");

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnUbah.setText("Ubah");

        btnHapus.setText("Hapus");

        btnKeluar.setText("Keluar");

        TableDaerah.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TableDaerah.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                TableDaerahComponentAdded(evt);
            }
        });
        jScrollPane2.setViewportView(TableDaerah);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBaru)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUbah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnKeluar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDaerah, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(btnCari)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDaerah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBaru)
                    .addComponent(btnSimpan)
                    .addComponent(btnUbah)
                    .addComponent(btnHapus)
                    .addComponent(btnKeluar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        simpan();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void TableDaerahComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_TableDaerahComponentAdded
        // TODO add your handling code here:
        tampildata();
        lebarkolom();
    }//GEN-LAST:event_TableDaerahComponentAdded

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(daerah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(daerah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(daerah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(daerah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new daerah().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableDaerah;
    private javax.swing.JButton btnBaru;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtDaerah;
    private javax.swing.JTextField txtKode;
    // End of variables declaration//GEN-END:variables
}


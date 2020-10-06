/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.penjualanmakanan.view;

import com.penjualanmakanan.controller.BarangController;
import java.util.ArrayList;
import java.util.List;
import com.penjualanmakanan.model.Barang;
import com.penjualanmakanan.util.FormatRupiah;
import com.penjualanmakanan.util.FormatTanggal;
import com.penjualanmakanan.util.ValidasiUpdateNamaBarang;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

class ProcessBarang extends Thread {

    revisiBarangView barangView;

    public ProcessBarang(revisiBarangView v) {
        this.barangView = v;
    }

    @Override
    public void run() {
        while (true) {
            barangView.tampilBarang();

            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Process.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

/**
 *
 * @author User
 */
public class revisiBarangView extends javax.swing.JFrame {

    List<Barang> listBarang = new ArrayList<>();
    BarangController barangController = new BarangController();
    FormatRupiah formatRupiah = new FormatRupiah();
    ValidasiUpdateNamaBarang validasiupdatenamabarang = new ValidasiUpdateNamaBarang();
    
    public void tampilBarang() {
        listBarang = new BarangController().getAllBarang();

        Object[][] obj = new Object[listBarang.size()][5];

        for (int i = 0; i < listBarang.size(); i++) {
            obj[i][0] = (i + 1) + ".";
            obj[i][1] = listBarang.get(i).getId();
            obj[i][2] = listBarang.get(i).getNama();
            obj[i][3] = listBarang.get(i).getStok();
            obj[i][4] = formatRupiah.kurensi(listBarang.get(i).getHarga());
        }

        tabelBarang.setModel(
                new javax.swing.table.DefaultTableModel(
                        obj,
                        new String[]{
                            "No.", "ID Barang", "Nama Barang", "Stok Barang", "Harga Barang"
                        }
                ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        }
        );
    }

    
    
    public void insertBarang() {
        if (inputNama.getText().equals("") && inputStok.getText().equals("")
                && inputHarga.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Form wajib diisi dengan lengkap", "Oops!", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (inputNama.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Nama barang wajib diisi", "Oops!", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (inputStok.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Stok barang wajib diisi", "Oops!", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (inputHarga.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Harga barang wajib diisi", "Oops!", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (validasiupdatenamabarang.cekNamaBarang(inputNama.getText())) {
            JOptionPane.showMessageDialog(this, "Nama barang sudah ada", "Oops!", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            try {
                Integer.parseInt(inputStok.getText());
                Integer.parseInt(inputHarga.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Stok barang / Harga barang wajib berupa angka", "Oops!", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            
            
            Barang barang = new Barang();
            barang.setId(inputId.getText());
            barang.setNama(inputNama.getText());
            barang.setStok(Integer.parseInt(inputStok.getText()));
            barang.setHarga(Integer.parseInt(inputHarga.getText()));

            boolean insertBarang = barangController.insertBarang(barang);
            if (insertBarang) {
                JOptionPane.showMessageDialog(this, "Penambahan barang berhasil");
                initData();
            } else {
                JOptionPane.showMessageDialog(this, "Penambahan barang gagal", "Oops!", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    public void initData() {
        int maxIdBarang = Integer.parseInt(barangController.getMaxIdBarang());
        inputId.setText("BRG" + String.format("%03d", ++maxIdBarang));

        inputNama.setText("");

        inputStok.setText("");

        inputHarga.setText("");

        tampilBarang();
    }

    public revisiBarangView() {
        initComponents();
        initData();
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
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        Button_Refresh = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        inputId = new javax.swing.JTextField();
        inputNama = new javax.swing.JTextField();
        inputStok = new javax.swing.JTextField();
        inputHarga = new javax.swing.JTextField();
        Button_Add = new javax.swing.JButton();
        Button_Update = new javax.swing.JButton();
        Button_Delete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelBarang = new javax.swing.JTable();
        Button_Back = new javax.swing.JButton();

        jLabel1.setText("Input");

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Barang");

        jInternalFrame1.setVisible(true);

        Button_Refresh.setText("Refresh");
        Button_Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_RefreshActionPerformed(evt);
            }
        });

        jLabel2.setText("Id");

        jLabel3.setText("Nama");

        jLabel4.setText("Stok");

        jLabel5.setText("Harga");

        inputId.setEditable(false);
        inputId.setBackground(new java.awt.Color(230, 230, 230));
        inputId.setEnabled(false);

        inputStok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputStokActionPerformed(evt);
            }
        });

        Button_Add.setText("Add");
        Button_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_AddActionPerformed(evt);
            }
        });

        Button_Update.setText("Update");
        Button_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_UpdateActionPerformed(evt);
            }
        });

        Button_Delete.setText("Delete");
        Button_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_DeleteActionPerformed(evt);
            }
        });

        tabelBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Nama", "Stok", "Harga"
            }
        ));
        tabelBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelBarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelBarang);

        Button_Back.setText("Back");
        Button_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_BackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jInternalFrame1Layout.createSequentialGroup()
                            .addComponent(Button_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Button_Update)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Button_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jInternalFrame1Layout.createSequentialGroup()
                            .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5))
                            .addGap(18, 18, 18)
                            .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(inputHarga)
                                .addComponent(inputNama)
                                .addComponent(inputStok)
                                .addComponent(inputId))))
                    .addComponent(Button_Refresh)
                    .addComponent(Button_Back, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                .addContainerGap())
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(Button_Refresh)
                        .addGap(26, 26, 26)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(inputNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(inputStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(inputHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Button_Add)
                            .addComponent(Button_Update)
                            .addComponent(Button_Delete))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(Button_Back)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jInternalFrame1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jInternalFrame1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_RefreshActionPerformed
        initData();
    }//GEN-LAST:event_Button_RefreshActionPerformed

    private void Button_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_UpdateActionPerformed
        if (inputNama.getText().equals("") && inputStok.getText().equals("")
                && inputHarga.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Form wajib diisi dengan lengkap", "Oops!", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (inputNama.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Nama barang wajib diisi", "Oops!", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (inputStok.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Stok barang wajib diisi", "Oops!", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (inputHarga.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Harga barang wajib diisi", "Oops!", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (validasiupdatenamabarang.cekNamaBarang(inputNama.getText())) {
            JOptionPane.showMessageDialog(this, "Nama barang sudah ada", "Oops!", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            try {
                Integer.parseInt(inputStok.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Stok barang wajib berupa angka", "Oops!", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            try {
                Integer.parseInt(inputHarga.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Harga barang wajib berupa angka", "Oops!", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            Barang barang = new Barang();
            barang.setId(inputId.getText());
            barang.setNama(inputNama.getText());
            barang.setStok(Integer.parseInt(inputStok.getText()));
            barang.setHarga(Integer.parseInt(inputHarga.getText().substring(2, inputHarga.getText().length() - 3).replace(".", "")));

            boolean updateBarang = barangController.updateBarang(barang);

            if (updateBarang) {
                JOptionPane.showMessageDialog(this, "Update barang berhasil");
                initData();
            } else {
                JOptionPane.showMessageDialog(this, "Update barang gagal", "Oops!", JOptionPane.ERROR_MESSAGE);
            }
        }


    }//GEN-LAST:event_Button_UpdateActionPerformed

    private void Button_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_DeleteActionPerformed
        Barang barang = new Barang();
        barang.setId(inputId.getText());
        boolean deleteBarang = barangController.deleteBarang(barang);
        if (deleteBarang) {
            JOptionPane.showMessageDialog(this, "Penghapusan barang berhasil");
            initData();
        } else {
            JOptionPane.showMessageDialog(this, "Penghapusan barang gagal", "Oops!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_Button_DeleteActionPerformed

    private void Button_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_AddActionPerformed
        insertBarang();
    }//GEN-LAST:event_Button_AddActionPerformed

    private void Button_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_BackActionPerformed
        revisiBerandaView berandaView = new revisiBerandaView();
        berandaView.setVisible(true);
        dispose();
    }//GEN-LAST:event_Button_BackActionPerformed

    private void tabelBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelBarangMouseClicked
        int baris = tabelBarang.getSelectedRow();
        Object id = tabelBarang.getValueAt(baris, 1);
        Object nama = tabelBarang.getValueAt(baris, 2);
        Object stok = tabelBarang.getValueAt(baris, 3);
        Object harga = tabelBarang.getValueAt(baris, 4);
        inputId.setText(id.toString());
        inputNama.setText(nama.toString());
        inputStok.setText(stok.toString());
        inputHarga.setText(harga.toString());
    }//GEN-LAST:event_tabelBarangMouseClicked

    private void inputStokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputStokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputStokActionPerformed

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
            java.util.logging.Logger.getLogger(revisiBarangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(revisiBarangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(revisiBarangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(revisiBarangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new revisiBarangView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Add;
    private javax.swing.JButton Button_Back;
    private javax.swing.JButton Button_Delete;
    private javax.swing.JButton Button_Refresh;
    private javax.swing.JButton Button_Update;
    private javax.swing.JTextField inputHarga;
    private javax.swing.JTextField inputId;
    private javax.swing.JTextField inputNama;
    private javax.swing.JTextField inputStok;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelBarang;
    // End of variables declaration//GEN-END:variables
}
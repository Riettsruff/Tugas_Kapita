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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



/**
 *
 * @author Riett
 */
public class BarangView extends javax.swing.JFrame {

    List<Barang> listBarang = new ArrayList<>();
    BarangController barangController = new BarangController();
    FormatRupiah formatRupiah = new FormatRupiah();
    
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
    
    public void insertBarang(){
        Barang barang = new Barang();
        barang.setId(inputId.getText());
        barang.setNama(inputNama.getText());
        barang.setStok(Integer.parseInt(inputStok.getText()));
        barang.setHarga(Integer.parseInt(inputHarga.getText()));
        
        boolean insertBarang = barangController.insertBarang(barang);
        
        if(insertBarang) {
            JOptionPane.showMessageDialog(this, "Penambahan barang berhasil");
            initData();
        } else {
            JOptionPane.showMessageDialog(this, "Penambahan barang gagal", "Oops!", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
    
    public void initData() {
        inputId.setText("BRG" + new FormatTanggal(new Date(), "yyyyMMddHHmmssSS").toString());
        
        inputNama.setText("");
        
        inputStok.setText("");
        
        inputHarga.setText("");
        
        tampilBarang();
    }
    
    

    /**
     * Creates new form Barang
     */
    public BarangView() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelBarang = new javax.swing.JTable();
        kembali = new javax.swing.JButton();
        insert = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        inputId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        inputNama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        inputStok = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        inputHarga = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tampilan Barang");

        tabelBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Nama", "Stok", "Harga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelBarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelBarang);

        kembali.setBackground(new java.awt.Color(203, 220, 219));
        kembali.setText("Kembali");
        kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliActionPerformed(evt);
            }
        });

        insert.setText("Tambah");
        insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActionPerformed(evt);
            }
        });

        update.setText("Perbarui");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setText("Hapus");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        refresh.setText("Segarkan");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        jLabel1.setText("Input Barang");

        jLabel2.setText("Id : ");

        inputId.setEditable(false);
        inputId.setBackground(new java.awt.Color(230, 230, 230));
        inputId.setEnabled(false);

        jLabel3.setText("Nama : ");

        inputNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNamaActionPerformed(evt);
            }
        });

        jLabel4.setText("Stok  : ");

        jLabel5.setText("Harga :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(kembali)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(inputHarga))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(insert)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(update)
                                                .addGap(18, 18, 18)
                                                .addComponent(delete))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel3)
                                                    .addComponent(jLabel2)
                                                    .addComponent(jLabel4))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(inputId, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                                                    .addComponent(inputNama)
                                                    .addComponent(inputStok))))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(33, 33, 33))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(refresh)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(refresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(inputId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(inputNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(inputStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(inputHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insert)
                    .addComponent(update)
                    .addComponent(delete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(kembali)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliActionPerformed
        BerandaView beranda = new BerandaView();
        beranda.setVisible(true);
        dispose();
    }//GEN-LAST:event_kembaliActionPerformed

    private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed
        // TODO add your handling code here:
        insertBarang();
    }//GEN-LAST:event_insertActionPerformed

    private void inputNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNamaActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        Barang barang = new Barang();
        barang.setId(inputId.getText());
        boolean deleteBarang = barangController.deleteBarang(barang);
        if(deleteBarang) {
            JOptionPane.showMessageDialog(this, "Penghapusan barang berhasil");
            initData();
        } else {
            JOptionPane.showMessageDialog(this, "Penghapusan barang gagal", "Oops!", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }//GEN-LAST:event_deleteActionPerformed

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

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
            
        Barang barang = new Barang();
        barang.setId(inputId.getText());
        barang.setNama(inputNama.getText());
        barang.setStok(Integer.parseInt(inputStok.getText()));
        barang.setHarga(Integer.parseInt(inputHarga.getText().substring(2, inputHarga.getText().length() - 3).replace(".", "")));
        
        boolean updateBarang = barangController.updateBarang(barang);
        
        if(updateBarang) {
            JOptionPane.showMessageDialog(this, "Update barang berhasil");
            initData();
        } else {
            JOptionPane.showMessageDialog(this, "Update barang gagal", "Oops!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
    }//GEN-LAST:event_updateActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        initData();
    }//GEN-LAST:event_refreshActionPerformed

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
            java.util.logging.Logger.getLogger(BarangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BarangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BarangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BarangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BarangView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton delete;
    private javax.swing.JTextField inputHarga;
    private javax.swing.JTextField inputId;
    private javax.swing.JTextField inputNama;
    private javax.swing.JTextField inputStok;
    private javax.swing.JButton insert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton kembali;
    private javax.swing.JButton refresh;
    private javax.swing.JTable tabelBarang;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}

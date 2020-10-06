/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.penjualanmakanan.view;

import com.penjualanmakanan.controller.DetailTransaksiController;
import com.penjualanmakanan.controller.TransaksiController;
import com.penjualanmakanan.model.Barang;
import com.penjualanmakanan.model.Transaksi;
import com.penjualanmakanan.util.FormatRupiah;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author User
 */
public class revisiHistoryTransaksiView extends javax.swing.JFrame {
    List<Transaksi> listTransaksi = new ArrayList<>();
    List<Barang> listBarang = new ArrayList<>();

    
    TransaksiController transaksiController = new TransaksiController();
    DetailTransaksiController detailTransaksiController = new DetailTransaksiController();
    
    FormatRupiah formatRupiah = new FormatRupiah();
    /**
     * Creates new form revisiHistoryTransaksiView
     */
    
    /**
     * Ini fungsi untuk menampilkan history transaksi di tabel. listTransaksi adalah arraylist yang dibuat
     * untuk getAllTransaksi. Terdapat 2 dimensi array obj yang terdiri dari listBarang.size(jumlah transaksi yang ada)
     * dan [5] karena ada 5 kolom
     */
    
    /**
    * Method yang digunakan untuk mengikat (binding) tabel transaksi
    */
    public void bindingTabelTransaksi() {
        listTransaksi = new TransaksiController().getAllTransaksi();
        
        Object [][] obj = new Object[listTransaksi.size()][5];
        
        for (int i = 0; i < listTransaksi.size();i++){
            obj[i][0] = (i+1) + ".";
            obj[i][1] = listTransaksi.get(i).getId();
            obj[i][2] = listTransaksi.get(i).getTglTransaksi();
            obj[i][3] = String.valueOf(transaksiController.getTotalBarangByIdTransaksi(listTransaksi.get(i).getId()));
            obj[i][4] = formatRupiah.kurensi(transaksiController.getTotalHargaByIdTransaksi(listTransaksi.get(i).getId()));
        }
        
        Tabel_Transaksi.setModel(
            new javax.swing.table.DefaultTableModel(
                obj,
                new String [] {
                    "No.","ID Transaksi", "Tanggal Transaksi", "Total Barang", "Total Harga"
                }
            )
            {
                boolean[] canEdit = new boolean[]{
                    false, false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            }
        );
    }
    
    public revisiHistoryTransaksiView() {
        initComponents();
        bindingTabelTransaksi();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabel_Transaksi = new javax.swing.JTable();
        Button_Back = new javax.swing.JButton();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 604, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 268, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Histori transaksi");

        jInternalFrame2.setVisible(true);

        Tabel_Transaksi.setModel(new javax.swing.table.DefaultTableModel(
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
                "Id", "Tanggal", "Waktu", "Total"
            }
        ));
        jScrollPane1.setViewportView(Tabel_Transaksi);

        Button_Back.setText("Back");
        Button_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_BackButton_BackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addComponent(Button_Back, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Button_Back)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jInternalFrame2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jInternalFrame2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_BackButton_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_BackButton_BackActionPerformed
        revisiBerandaView berandaView = new revisiBerandaView();
        berandaView.setVisible(true);
        dispose();
    }//GEN-LAST:event_Button_BackButton_BackActionPerformed

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
            java.util.logging.Logger.getLogger(revisiHistoryTransaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(revisiHistoryTransaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(revisiHistoryTransaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(revisiHistoryTransaksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new revisiHistoryTransaksiView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Back;
    private javax.swing.JTable Tabel_Transaksi;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

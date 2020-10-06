/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.penjualanmakanan.dao;

import com.penjualanmakanan.model.Barang;
import static com.penjualanmakanan.util.Koneksi.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Boona
 */
public class BarangDao implements ImplBarangDao {
    
//    private List<Barang> list;
    Connection conn;

    public BarangDao() {
        conn = Koneksi();
    }
    
    /**
     *
     * @param barang
     */
    @Override
    public void insertBarang(Barang barang) {
        try {
            String query = "INSERT INTO barang (id, nama, stok, harga) VALUES (?, ?, ?, ?)";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, barang.getId());
            ps.setString(2, barang.getNama());
            ps.setInt(3, barang.getStok());
            ps.setInt(4, barang.getHarga());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBarang(int id) {
        String query = "DELETE FROM barang WHERE id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);       
            ps.setInt(1, id);
            
            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(BarangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateBarang(Barang barang) {
        try {
            String query = "UPDATE barang SET nama = ?, stok = ?, harga = ? WHERE id = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, barang.getNama());
            ps.setInt(2, barang.getStok());
            ps.setInt(3, barang.getHarga());
            ps.setString(4, barang.getId());
            
            ps.executeUpdate();
  
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    /**
     * Ini Fungsi Array List yang digunakan untuk select semua atribut dari database
     * @return listBarang Saat fungsi ini dipanggil maka akan return array list yang 
     * berisi seluruh atribut barang dari database
     */
    @Override
    public List<Barang> getAllBarang() {
        List<Barang> listBarang = new ArrayList<>();
        
        try {
            String query = "SELECT id, nama, stok, harga FROM `barang`";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Barang barang = new Barang();

                barang.setId(rs.getString("id"));
                barang.setNama(rs.getString("nama"));
                barang.setStok(rs.getInt("stok"));
                barang.setHarga(rs.getInt("harga"));

                listBarang.add(barang);
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return listBarang;

    }

    @Override
    public String getMaxIdBarang() {
        String maxIdBarang = "001";
        try {
            String query = "SELECT RIGHT((SElECT MAX(id) AS max_id FROM barang), 3) AS \"max_id\"";

            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                if (rs.getString("max_id") != null) {
                    maxIdBarang = rs.getString("max_id");
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maxIdBarang;
    }

    @Override
    public int getStokByIdBarang(String idBarang) {

        int stok = 0;

        try {
            String query = "SELECT stok FROM barang WHERE id = ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, idBarang);
                    
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                stok = rs.getInt(1);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return stok;
        
    }
}

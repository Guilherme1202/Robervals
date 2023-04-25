/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import java.sql.Connection;
import java.util.List;
import model.bo.Marca;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;



/**
 *
 * @author aluno
 */
public class MarcaDAO implements InterfaceDAO<Marca> {

    @Override
    public void create(Marca objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO marca (descricao) VALUES (?)";
        PreparedStatement pstm = null; 
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getDescricao());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();                       
        }
        ConnectionFactory.closeConnection(conexao, pstm);
    }
        
    @Override
    public Marca retrieve(int codigo) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT id, descricao FROM marca where id = ?";
        PreparedStatement pstm = null;
        ResultSet rst = null; 
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, codigo);
            rst = pstm.executeQuery();
            Marca marca = new Marca();
            
            while(rst.next()){
                marca.setId(rst.getInt("id"));
                marca.setDescricao(rst.getString("descricao"));
            }
            
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return marca;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
    }

    @Override
    public Marca retrieve(String descricao) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT id, descricao FROM marca where descricao = ?";
        PreparedStatement pstm = null;
        ResultSet rst = null; 
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, descricao);
            rst = pstm.executeQuery();
            Marca marca = new Marca();
            
            
            while(rst.next()){
                marca.setId(rst.getInt("id"));
                marca.setDescricao(rst.getString("descricao"));
            }
            
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return marca;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
    }

    @Override
    public List<Marca> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT marca.id, marca.descricao FROM marca";
                
        PreparedStatement pstm = null;
        ResultSet rst = null; 
        
        List<Marca> listaMarca = new ArrayList<>();
     
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();
            
            while(rst.next()){
                Marca marca = new Marca();                
                marca.setId(rst.getInt("id"));
                marca.setDescricao(rst.getString("descricao"));
                listaMarca.add(marca);
            }
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaMarca;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
        
        
        
       
    }

    @Override
    public void update(Marca objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "UPDATE marca SET marca.descricao = ? WHERE marca.id = ?";
        PreparedStatement pstm = null; 
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getDescricao());
            pstm.setInt(2, objeto.getId());
            pstm.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();                       
        }
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public void delete(Marca objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "DELETE FROM marca WHERE marca.id = ?";
        PreparedStatement pstm = null; 
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getDescricao());
            pstm.setInt(2, objeto.getId());
            pstm.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();                       
        }
        ConnectionFactory.closeConnection(conexao, pstm);
    }
}

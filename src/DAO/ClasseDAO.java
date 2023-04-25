/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import java.sql.Connection;
import java.util.List;
import model.bo.Classe;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;



/**
 *
 * @author aluno
 */
public class ClasseDAO implements InterfaceDAO<Classe> {

    @Override
    public void create(Classe objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO classe (descricao) VALUES (?)";
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
    public Classe retrieve(int codigo) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT id, descricao FROM classe where id = ?";
        PreparedStatement pstm = null;
        ResultSet rst = null; 
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, codigo);
            rst = pstm.executeQuery();
            Classe classe = new Classe();
            
            while(rst.next()){
                classe.setId(rst.getInt("id"));
                classe.setDescricao(rst.getString("descricao"));
            }
            
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return classe;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
    }

    @Override
    public Classe retrieve(String descricao) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT classe.id, classe.descricao FROM classe where classe.descicao = ?";
        PreparedStatement pstm = null;
        ResultSet rst = null; 
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, descricao);
            rst = pstm.executeQuery();
            Classe classe = new Classe();
            
            
            while(rst.next()){
                classe.setId(rst.getInt("id"));
                classe.setDescricao(rst.getString("descricao"));
            }
            
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return classe;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
    }

    @Override
    public List<Classe> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT classe.id, classe.descricao FROM classe";
                
        PreparedStatement pstm = null;
        ResultSet rst = null; 
        
        List<Classe> listaClasse = new ArrayList<>();
     
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();
            
            while(rst.next()){
                Classe classe = new Classe();                
                classe.setId(rst.getInt("id"));
                classe.setDescricao(rst.getString("descricao"));
                listaClasse.add(classe);
            }
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaClasse;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
        
        
        
       
    }

    @Override
    public void update(Classe objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "UPDATE classe SET classe.descricao = ? WHERE classe.id = ?";
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
    public void delete(Classe objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "DELETE FROM classe WHERE classe.id = ?";
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

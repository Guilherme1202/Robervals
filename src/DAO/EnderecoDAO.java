package DAO;

import java.sql.Connection;
import java.util.List;
import model.bo.Endereco;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.bo.Bairro;
import model.bo.Cidade;

public class EnderecoDAO implements InterfaceDAO<Endereco> {

    @Override
    public void create(Endereco objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO endereco (cidade_id, bairro_id, logradouro, cep ) VALUES (?,?,?,?)";
        PreparedStatement pstm = null; 
        
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, objeto.getCidade().getId());
            pstm.setInt(2, objeto.getBairro().getId());
            pstm.setString(3, objeto.getLogradouro());
            pstm.setString(4, objeto.getCep());
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();                       
        }
        ConnectionFactory.closeConnection(conexao, pstm);
    }
        
    @Override
    public Endereco retrieve(int codigo) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT "
                + "cidade_id, "
                + "bairro_id, "
                + "logradouro, "
                + "cep "
                + "FROM endereco "
                + "where id = ?";
        PreparedStatement pstm = null;
        ResultSet rst = null; 
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, codigo);
            rst = pstm.executeQuery();
            Endereco endereco = new Endereco();
            
            while(rst.next()){
            //  endereco.setId(rst.getInt("id"));
                endereco.setCep(rst.getString("cep"));
                endereco.setLogradouro(rst.getString("logradouro"));
                
                Cidade cidade = new Cidade();
                CidadeDAO  cidadeDAO = new CidadeDAO();
                cidade = cidadeDAO.retrieve(rst.getInt("cidade_id"));
                endereco.setCidade(cidade);
                
                Bairro bairro = new Bairro();
                BairroDAO  bairroDAO = new BairroDAO();
                bairro = bairroDAO.retrieve(rst.getInt("bairro_id"));
                endereco.setBairro(bairro);
            
            //  endereco.setBairro(rst.getInt("bairro_id"));
            }
            
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return endereco;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
    }

    @Override
    public Endereco retrieve(String cep) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT cidade_id, bairro_id, logradouro, cep FROM endereco where cep = ?";
        PreparedStatement pstm = null;
        ResultSet rst = null; 
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1,cep);
            pstm.executeUpdate();
            Endereco endereco = new Endereco();         
            
            while(rst.next()){
              // endereco.setCidade(rst.getInt("cidade_id"));
              //  endereco.setBairro(rst.getInt("bairro_id"));
                endereco.setCep(rst.getString("cep"));
                endereco.setLogradouro(rst.getString("logradouro"));
            }
            
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return endereco;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
    }

    @Override
    public List<Endereco> retrieve() {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "SELECT cidade_id, bairro_id, logradouro, cep FROM endereco";
                
        PreparedStatement pstm = null;
        ResultSet rst = null; 
        
        List<Endereco> listaEndereco = new ArrayList<>(); 
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();
            
            while(rst.next()){
                
                Endereco endereco = new Endereco();                
               // endereco.setCidade(rst.getInt("cidade_id"));
                //.setBairro(rst.getInt("bairro_id"));
                endereco.setCep(rst.getString("cep"));
                endereco.setLogradouro(rst.getString("logradouro"));
                listaEndereco.add(endereco);
            }
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return listaEndereco;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
    }

    @Override
    public void update(Endereco objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "UPDATE endereco SET cidade_id = ?, bairro_id= ?, logradouro= ?, cep= ? WHERE id = ?";
        PreparedStatement pstm = null; 
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getCidade().getDescricao());
            pstm.setString(2, objeto.getBairro().getDescricao());
            pstm.setString(3, objeto.getLogradouro());
            pstm.setString(4, objeto.getCep());
            pstm.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();                       
        }
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public void delete(Endereco objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "DELETE FROM endereco WHERE id = ?";
        PreparedStatement pstm = null; 
        
        try {
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getCidade().getDescricao());
            pstm.setString(2, objeto.getBairro().getDescricao());
            pstm.setString(3, objeto.getLogradouro());
            pstm.setString(4, objeto.getCep());
            pstm.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();                       
        }
        ConnectionFactory.closeConnection(conexao, pstm);
    }
}

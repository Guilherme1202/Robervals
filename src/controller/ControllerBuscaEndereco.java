
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import DAO.EnderecoDAO;
import model.bo.Endereco;
import view.NewBuscaEndereco;
//import static newmarket22.controller.ControllerEndereco.codigoEnd;


/**
 *
 * @author aluno
 */
public class ControllerBuscaEndereco implements ActionListener{
       
    NewBuscaEndereco newBuscaEndereco;
    private Endereco enderecoCarregado;
    
    public ControllerBuscaEndereco(NewBuscaEndereco newBuscaEndereco){
        this.newBuscaEndereco = newBuscaEndereco;
        this.newBuscaEndereco.getjButtonCarregar().addActionListener(this);
        this.newBuscaEndereco.getjButtonSair().addActionListener(this);
        
         DefaultTableModel tabela = (DefaultTableModel) this.newBuscaEndereco.getjTableDadosAchados().getModel();
        
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        
        for (Endereco objetoAtualDaLista : enderecoDAO.retrieve()){
            
            tabela.addRow(new Object[]{objetoAtualDaLista.getCidade(),
                                       objetoAtualDaLista.getBairro(),
                                       objetoAtualDaLista.getLogradouro(),
                                       objetoAtualDaLista.getCep()});            
            
        }
    }
    
    
    public void actioPerfomed(ActionEvent acao){
        
    }
    
    public Endereco capturarEnderecoCarregado(){
        return this.enderecoCarregado;
    }
    
    private void alterarEnderecoCarregado(Endereco endereco){
        this.enderecoCarregado = endereco;
    }

    @Override
    public void actionPerformed(ActionEvent acao) {
        if(acao.getSource() == this.newBuscaEndereco.getjButtonCarregar()){
            if (this.newBuscaEndereco.getjTableDadosAchados().getValueAt(this.newBuscaEndereco.getjTableDadosAchados().getSelectedRow(), 0) != null){
                //ControllerBairro.codigo = this.newBuscaBairro.getjTableDadosAchados().getValueAt(this.newBuscaBairro.getjTableDadosAchados().getSelectedRow(), 0);
                ControllerEndereco.codigoEnd = (int) this.newBuscaEndereco.getjTableDadosAchados().getValueAt(this.newBuscaEndereco.getjTableDadosAchados().getSelectedRow(), 0);
                newBuscaEndereco.dispose();
            }
            
        }else if(acao.getSource() == this.newBuscaEndereco.getjButtonSair()){
            newBuscaEndereco.dispose();
        }
    }    
}

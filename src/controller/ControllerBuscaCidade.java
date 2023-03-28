
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import model.DAO.CidadeDAO;
import model.bo.Cidade;
import view.NewBuscaCidade;

/**
 *
 * @author aluno
 */
public class ControllerBuscaCidade implements ActionListener{
       
    NewBuscaCidade newBuscaCidade;
    //public Cidade cidadeCarregada;
    
    public ControllerBuscaCidade(NewBuscaCidade newBuscaCidade){
        this.newBuscaCidade = newBuscaCidade;
        this.newBuscaCidade.getjButtonCarregar().addActionListener(this);
        this.newBuscaCidade.getjButtonSair().addActionListener(this);
        
                //Carregar os dados para jtable
        
        DefaultTableModel tabela = (DefaultTableModel) this.newBuscaCidade.getjTableDadosAchados().getModel();
        
        CidadeDAO cidadeDAO = new CidadeDAO();
        
        for (Cidade objetoAtualDaLista : cidadeDAO.retrieve()){
            
            tabela.addRow(new Object[]{objetoAtualDaLista.getId(),
                                       objetoAtualDaLista.getDescricao()});   
    }
    }
    
    @Override
    public void actionPerformed(ActionEvent acao) {
        if(acao.getSource() == this.newBuscaCidade.getjButtonCarregar()){
            if (this.newBuscaCidade.getjTableDadosAchados().getValueAt(this.newBuscaCidade.getjTableDadosAchados().getSelectedRow(), 0) != null){
                //ControllerCidade.codigo = this.newBuscaCidade.getjTableDadosAchados().getValueAt(this.newBuscaCidade.getjTableDadosAchados().getSelectedRow(), 0);
                ControllerCidade.codigoCida = (int) this.newBuscaCidade.getjTableDadosAchados().getValueAt(this.newBuscaCidade.getjTableDadosAchados().getSelectedRow(), 0);
                newBuscaCidade.dispose();
            }
        }else if(acao.getSource() == this.newBuscaCidade.getjButtonSair()){
            newBuscaCidade.dispose();
        }
    }
            
    
}

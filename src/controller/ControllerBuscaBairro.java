
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import DAO.BairroDAO;
import model.bo.Bairro;
import view.NewBuscaBairro;
/**
 *
 * @author aluno
 */
public class ControllerBuscaBairro implements ActionListener{
    
    NewBuscaBairro newBuscaBairro;
    // Bairro bairroCArregado;
    
    public ControllerBuscaBairro(NewBuscaBairro newBuscaBairro){
        this.newBuscaBairro = newBuscaBairro;
        this.newBuscaBairro.getjButtonCarregar().addActionListener(this);
        this.newBuscaBairro.getjButtonSair().addActionListener(this);
        
        //Carregar os dados para jtable
        
        DefaultTableModel tabela = (DefaultTableModel) this.newBuscaBairro.getjTableDadosAchados().getModel();
        
        BairroDAO bairroDAO = new BairroDAO();
        
        for (Bairro objetoAtualDaLista : bairroDAO.retrieve()){
            
            tabela.addRow(new Object[]{objetoAtualDaLista.getId(),
                                       objetoAtualDaLista.getDescricao()});            
            
        }
    }
    
   
    @Override
    public void actionPerformed(ActionEvent acao) {
        if(acao.getSource() == this.newBuscaBairro.getjButtonCarregar()){
            if (this.newBuscaBairro.getjTableDadosAchados().getValueAt(this.newBuscaBairro.getjTableDadosAchados().getSelectedRow(), 0) != null){
                //ControllerBairro.codigo = this.newBuscaBairro.getjTableDadosAchados().getValueAt(this.newBuscaBairro.getjTableDadosAchados().getSelectedRow(), 0);
                ControllerBairro.codigoBair = (int) this.newBuscaBairro.getjTableDadosAchados().getValueAt(this.newBuscaBairro.getjTableDadosAchados().getSelectedRow(), 0);
                newBuscaBairro.dispose();
            }
        }else if(acao.getSource() == this.newBuscaBairro.getjButtonSair()){
            newBuscaBairro.dispose();
        }
    }
            
    
}

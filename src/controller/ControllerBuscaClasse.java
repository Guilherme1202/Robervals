
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import DAO.ClasseDAO;
import model.bo.Classe;
import view.NewBuscaClasse;

/**
 *
 * @author aluno
 */
public class ControllerBuscaClasse implements ActionListener{
       
    NewBuscaClasse newBuscaClasse;
    
    public ControllerBuscaClasse(NewBuscaClasse newBuscaClasse){
        this.newBuscaClasse = newBuscaClasse;
        this.newBuscaClasse.getjButtonCarregar().addActionListener(this);
        this.newBuscaClasse.getjButtonSair().addActionListener(this);
        
        //Carregar os dados para jtable
        
        DefaultTableModel tabela = (DefaultTableModel) this.newBuscaClasse.getjTableDadosAchados().getModel();
        
        ClasseDAO classeDAO = new ClasseDAO();
        
        for (Classe objetoAtualDaLista : classeDAO.retrieve()){
            
            tabela.addRow(new Object[]{objetoAtualDaLista.getId(),
                                       objetoAtualDaLista.getDescricao()});            
            
        }
    }
    
   
    @Override
    public void actionPerformed(ActionEvent acao) {
        if(acao.getSource() == this.newBuscaClasse.getjButtonCarregar()){
            if (this.newBuscaClasse.getjTableDadosAchados().getValueAt(this.newBuscaClasse.getjTableDadosAchados().getSelectedRow(), 0) != null){
                //ControllerClasse.codigo = this.newBuscaClasse.getjTableDadosAchados().getValueAt(this.newBuscaClasse.getjTableDadosAchados().getSelectedRow(), 0);
                ControllerClasse.codigo = (int) this.newBuscaClasse.getjTableDadosAchados().getValueAt(this.newBuscaClasse.getjTableDadosAchados().getSelectedRow(), 0);
                newBuscaClasse.dispose();
            }
        }else if(acao.getSource() == this.newBuscaClasse.getjButtonSair()){
            newBuscaClasse.dispose();
        }
    }
            
    
}

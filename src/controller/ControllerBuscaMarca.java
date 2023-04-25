
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import DAO.MarcaDAO;
import model.bo.Marca;
import view.NewBuscaMarca;

/**
 *
 * @author aluno
 */
public class ControllerBuscaMarca implements ActionListener{
       
    NewBuscaMarca newBuscaMarca;
    
    public ControllerBuscaMarca(NewBuscaMarca newBuscaMarca){
        this.newBuscaMarca = newBuscaMarca;
        this.newBuscaMarca.getjButtonCarregar().addActionListener(this);
        this.newBuscaMarca.getjButtonSair().addActionListener(this);
        
        //Carregar os dados para jtable
        
        DefaultTableModel tabela = (DefaultTableModel) this.newBuscaMarca.getjTableDadosAchados().getModel();
        
        MarcaDAO marcaDAO = new MarcaDAO();
        
        for (Marca objetoAtualDaLista : marcaDAO.retrieve()){
            
            tabela.addRow(new Object[]{objetoAtualDaLista.getId(),
                                       objetoAtualDaLista.getDescricao()});            
            
        }
    }
    
   
    @Override
    public void actionPerformed(ActionEvent acao) {
        if(acao.getSource() == this.newBuscaMarca.getjButtonCarregar()){
            if (this.newBuscaMarca.getjTableDadosAchados().getValueAt(this.newBuscaMarca.getjTableDadosAchados().getSelectedRow(), 0) != null){
                //ControllerMarca.codigo = this.newBuscaMarca.getjTableDadosAchados().getValueAt(this.newBuscaMarca.getjTableDadosAchados().getSelectedRow(), 0);
                ControllerMarca.codigoMar = (int) this.newBuscaMarca.getjTableDadosAchados().getValueAt(this.newBuscaMarca.getjTableDadosAchados().getSelectedRow(), 0);
                newBuscaMarca.dispose();
            }
        }else if(acao.getSource() == this.newBuscaMarca.getjButtonSair()){
            newBuscaMarca.dispose();
        }
    }
            
    
}

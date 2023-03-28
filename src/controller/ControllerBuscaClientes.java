
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.NewBuscaCliente;

/**
 *
 * @author aluno
 */
public class ControllerBuscaClientes implements ActionListener{
       
    NewBuscaCliente newBuscaCliente;
    
    public ControllerBuscaClientes(NewBuscaCliente newBuscaCliente){
        this.newBuscaCliente = newBuscaCliente;
        
        this.newBuscaCliente.getjButtonCarregar().addActionListener(this);
        this.newBuscaCliente.getjButtonSair().addActionListener(this);
    }
    
    
    public void actioPerfomed(ActionEvent acao){
        
    }

    @Override
    public void actionPerformed(ActionEvent acao) {
        if(acao.getSource() == this.newBuscaCliente.getjButtonCarregar()){
            
        }else if(acao.getSource() == this.newBuscaCliente.getjButtonSair()){
            newBuscaCliente.dispose();
        }
    }
            
    
}

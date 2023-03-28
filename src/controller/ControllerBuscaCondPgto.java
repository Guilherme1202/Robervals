
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.NewBuscaCondPgto;

/**
 *
 * @author aluno
 */
public class ControllerBuscaCondPgto implements ActionListener{
       
    NewBuscaCondPgto newBuscaCondPgto;
    
    public ControllerBuscaCondPgto(NewBuscaCondPgto newBuscaCondPgto){
        this.newBuscaCondPgto = newBuscaCondPgto;
        
        this.newBuscaCondPgto.getjButtonCarregar().addActionListener(this);
        this.newBuscaCondPgto.getjButtonSair().addActionListener(this);
    }
    
    
    public void actioPerfomed(ActionEvent acao){
        
    }

    @Override
    public void actionPerformed(ActionEvent acao) {
        if(acao.getSource() == this.newBuscaCondPgto.getjButtonCarregar()){
            
        }else if(acao.getSource() == this.newBuscaCondPgto.getjButtonSair()){
            newBuscaCondPgto.dispose();
        }
    }
            
    
}

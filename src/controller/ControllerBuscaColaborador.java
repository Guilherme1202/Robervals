
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.NewBuscaColaborador;


/**
 *
 * @author aluno
 */
public class ControllerBuscaColaborador implements ActionListener{
       
    NewBuscaColaborador newBuscaColaborador;
    
    public ControllerBuscaColaborador(NewBuscaColaborador newBuscaColaborador){
        this.newBuscaColaborador = newBuscaColaborador;
        
        this.newBuscaColaborador.getjButtonCarregar().addActionListener(this);
        this.newBuscaColaborador.getjButtonSair().addActionListener(this);
    }
    
    
    public void actioPerfomed(ActionEvent acao){
        
    }

    @Override
    public void actionPerformed(ActionEvent acao) {
        if(acao.getSource() == this.newBuscaColaborador.getjButtonCarregar()){
            
        }else if(acao.getSource() == this.newBuscaColaborador.getjButtonSair()){
            newBuscaColaborador.dispose();
        }
    }
            
    
}

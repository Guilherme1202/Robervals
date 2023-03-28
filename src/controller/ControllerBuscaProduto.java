
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.NewBuscaProduto;

/**
 *
 * @author aluno
 */
public class ControllerBuscaProduto implements ActionListener{
       
    NewBuscaProduto newBuscaProduto;
    
    public ControllerBuscaProduto(NewBuscaProduto newBuscaProduto){
        this.newBuscaProduto = newBuscaProduto;
        
        this.newBuscaProduto.getjButtonCarregar().addActionListener(this);
        this.newBuscaProduto.getjButtonSair().addActionListener(this);
    }
    
    
    public void actioPerfomed(ActionEvent acao){
        
    }

    @Override
    public void actionPerformed(ActionEvent acao) {
        if(acao.getSource() == this.newBuscaProduto.getjButtonCarregar()){
            
        }else if(acao.getSource() == this.newBuscaProduto.getjButtonSair()){
            newBuscaProduto.dispose();
            
        }
    }
            
    
}

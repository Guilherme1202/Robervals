/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.bo.Bairro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.DAO.BairroDAO;
import view.NewBuscaBairro;
import view.NewViewBairro;

/**
 *
 * @author rafael.silva
 */
public class ControllerBairro implements ActionListener{

    public static int codigoBair;
    NewViewBairro telaCadBairro;
    
    public ControllerBairro (NewViewBairro parTelaCadBairro){
        
        this.telaCadBairro = parTelaCadBairro;
        
            
            telaCadBairro.getjButtonBuscar().addActionListener(this);
            telaCadBairro.getjButtonCancelar().addActionListener(this);
            telaCadBairro.getjButtonGravar().addActionListener(this);
            telaCadBairro.getjButtonNovo().addActionListener(this);
            telaCadBairro.getjButtonSair().addActionListener(this);
    
            telaCadBairro.ativa(true);
            telaCadBairro.ligaDesliga(false);
            
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == telaCadBairro.getjButtonNovo()) {
            
            telaCadBairro.ativa(false);
            telaCadBairro.ligaDesliga(true);
            telaCadBairro.getTxtId().setEnabled(false);
            telaCadBairro.getTxtDescricao().requestFocus();
            
        } else if (e.getSource() == telaCadBairro.getjButtonCancelar()) {
            
            telaCadBairro.ativa(true);
            telaCadBairro.ligaDesliga(false);
            
        } else if (e.getSource() == telaCadBairro.getjButtonBuscar()) {
            
            ControllerBairro.codigoBair = 0;
            
            NewBuscaBairro newBuscaBairro = new NewBuscaBairro(null, true);
            ControllerBuscaBairro controllerBuscaBairro = new ControllerBuscaBairro(newBuscaBairro);
            newBuscaBairro.setVisible(true);
            
            if (ControllerBairro.codigoBair != 0) {
                
            Bairro bairro = new Bairro();
            BairroDAO bairroDAO = new BairroDAO();
            bairro = bairroDAO.retrieve(codigoBair);
            
            telaCadBairro.ativa(false);
            telaCadBairro.ligaDesliga(true);
            telaCadBairro.getTxtId().setText(bairro.getId()+ "");
            telaCadBairro.getTxtDescricao().setText(bairro.getDescricao());
            telaCadBairro.getTxtId().setEnabled(false);   
            }
        
        } else if (e.getSource() == telaCadBairro.getjButtonGravar()) {
            
            if (telaCadBairro.getTxtDescricao().getText().trim().equalsIgnoreCase("")) {   
                JOptionPane.showMessageDialog(null, "Atributo Descrição é Obrigatório");
             } else {
                Bairro bairro = new Bairro();
                bairro.setDescricao(telaCadBairro.getTxtDescricao().getText());
                
                //Persistir objeto no bairro
                BairroDAO bairroDAO = new BairroDAO ();
                if (this.telaCadBairro.getTxtId().getText().equalsIgnoreCase("")){
                bairroDAO.create(bairro);
                }else{
                    bairro.setId(Integer.parseInt(telaCadBairro.getTxtId().getText()));
                    bairroDAO.update(bairro);
                }
                        
                telaCadBairro.ativa(true);
                telaCadBairro.ligaDesliga(false);
            }
        } else if(e.getSource() == telaCadBairro.getjButtonSair()) {
            telaCadBairro.dispose();        
        }
    }
}

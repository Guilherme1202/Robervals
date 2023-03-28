/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.bo.Colaborador;
import view.NewBuscaColaborador;
import view.NewViewColaborador;

/**
 *
 * @author rafael.silva
 */
public class ControllerColaborador implements ActionListener{
    
     NewViewColaborador telaCadColaborador;
    
    public ControllerColaborador (NewViewColaborador parTelaCadColaborador){
        
        this.telaCadColaborador = parTelaCadColaborador;
        
            
            telaCadColaborador.getjButtonBuscar().addActionListener(this);
            telaCadColaborador.getjButtonCancelar().addActionListener(this);
            telaCadColaborador.getjButtonGravar().addActionListener(this);
            telaCadColaborador.getjButtonNovo().addActionListener(this);
            telaCadColaborador.getjButtonSair().addActionListener(this);
    
            telaCadColaborador.ativa(true);
            telaCadColaborador.ligaDesliga(false);
            
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == telaCadColaborador.getjButtonNovo()) {
            telaCadColaborador.ativa(false);
            telaCadColaborador.ligaDesliga(true);
            telaCadColaborador.getjTextFieldNome().requestFocus();
            
        } else if (e.getSource() == telaCadColaborador.getjButtonCancelar()) {
            telaCadColaborador.ativa(true);
            telaCadColaborador.ligaDesliga(false);
            
        } else if (e.getSource() == telaCadColaborador.getjButtonBuscar()) {
             NewBuscaColaborador newBuscaColaborador = new NewBuscaColaborador(null, true);
         
        ControllerBuscaColaborador controllerBuscaColaborador = new ControllerBuscaColaborador(newBuscaColaborador);

        newBuscaColaborador.setVisible(true);
        
        } else if (e.getSource() == telaCadColaborador.getjButtonGravar()) {
            if (telaCadColaborador.getjTextFieldNome().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo Nome é Obrigatório");
            }else if (telaCadColaborador.getjTextFieldCep().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo Cep é Obrigatório");
            }else if (telaCadColaborador.getjTextFieldEmail().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo Email é Obrigatório");
            }else if (telaCadColaborador.getjTextFieldCelular().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo Celular é Obrigatório");
            }else if (telaCadColaborador.getjTextFieldLogin().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo Login é Obrigatório");
            }else if (telaCadColaborador.getjPasswordFieldSenha().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo Senha é Obrigatório");
            }else {
                Colaborador colaborador = new Colaborador();
                colaborador.setNome(telaCadColaborador.getjTextFieldNome().getText());
                telaCadColaborador.ativa(true);
                telaCadColaborador.ligaDesliga(false);
            }
        } else if(e.getSource() == telaCadColaborador.getjButtonSair()) {
            telaCadColaborador.dispose();        
        }
    }
}

 

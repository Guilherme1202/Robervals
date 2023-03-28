/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.bo.Fornecedor;
import view.NewBuscaFornecedor;
import view.NewViewFornecedor;

/**
 *
 * @author rafael.silva
 */
public class ControllerFornecedor implements ActionListener{
    NewViewFornecedor telaCadFornecedor;
    
    public ControllerFornecedor (NewViewFornecedor parTelaCadFornecedor){
        
        this.telaCadFornecedor = parTelaCadFornecedor;
        
            
            telaCadFornecedor.getjButtonBuscar().addActionListener(this);
            telaCadFornecedor.getjButtonCancelar().addActionListener(this);
            telaCadFornecedor.getjButtonGravar().addActionListener(this);
            telaCadFornecedor.getjButtonNovo().addActionListener(this);
            telaCadFornecedor.getjButtonSair().addActionListener(this);
    
            telaCadFornecedor.ativa(true);
            telaCadFornecedor.ligaDesliga(false);
            
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == telaCadFornecedor.getjButtonNovo()) {
            telaCadFornecedor.ativa(false);
            telaCadFornecedor.ligaDesliga(true);
            telaCadFornecedor.getjTextFieldNome().requestFocus();
            
        } else if (e.getSource() == telaCadFornecedor.getjButtonCancelar()) {
            telaCadFornecedor.ativa(true);
            telaCadFornecedor.ligaDesliga(false);
            
        } else if (e.getSource() == telaCadFornecedor.getjButtonBuscar()) {
            NewBuscaFornecedor newBuscaFornecedor = new NewBuscaFornecedor(null, true);
         
        ControllerBuscaFornecedor controllerBuscaFornecedor = new ControllerBuscaFornecedor(newBuscaFornecedor);

        newBuscaFornecedor.setVisible(true);
        
        } else if (e.getSource() == telaCadFornecedor.getjButtonGravar()) {
            if (telaCadFornecedor.getjTextFieldNome().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atributo Nome é Obrigatório");
            }else if (telaCadFornecedor.getjTextFieldCNPJ().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo CNPJ é Obrigatório");
            }else if (telaCadFornecedor.getjTextFieldCPF().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo CPF é Obrigatório");
            }else if (telaCadFornecedor.getjTextFieldCep().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo CEP é Obrigatório");
            }else if (telaCadFornecedor.getjTextFieldCelular().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo Celular é Obrigatório");
            } else {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setNome(telaCadFornecedor.getjTextFieldNome().getText());
                telaCadFornecedor.ativa(true);
                telaCadFornecedor.ligaDesliga(false);
            }
        } else if(e.getSource() == telaCadFornecedor.getjButtonSair()) {
            telaCadFornecedor.dispose();        
        }
    }
}

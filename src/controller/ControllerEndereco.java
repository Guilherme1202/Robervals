/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import DAO.BairroDAO;
import DAO.CidadeDAO;
import static controller.ControllerBairro.codigoBair;
import static controller.ControllerCidade.codigoCida;
import model.bo.Bairro;
import model.bo.Cidade;
import model.bo.Endereco;
import view.NewBuscaBairro;
import view.NewBuscaCidade;
import view.NewBuscaEndereco;
import view.NewViewEndereco;

/**
 *
 * @author rafael.silva
 */
public class ControllerEndereco implements ActionListener{
    public static int codigoEnd;
    NewViewEndereco telaCadEndereco;
    private ControllerBuscaCidade controllerBuscaCidade;
    private ControllerBuscaBairro controllerBuscaBairro;
    
    public ControllerEndereco (NewViewEndereco parTelaCadEndereco){
        
        this.telaCadEndereco = parTelaCadEndereco;
        
            
            telaCadEndereco.getjButtonBuscar().addActionListener(this);
            telaCadEndereco.getjButtonCancelar().addActionListener(this);
            telaCadEndereco.getjButtonGravar().addActionListener(this);
            telaCadEndereco.getjButtonNovo().addActionListener(this);
            telaCadEndereco.getjButtonSair().addActionListener(this);
            telaCadEndereco.getjButtonBuscaCida().addActionListener(this);
            telaCadEndereco.getjButtonBuscaBair().addActionListener(this);
             
            telaCadEndereco.ativa(true);
            telaCadEndereco.ligaDesliga(false);
            
            this.controllerBuscaCidade = new ControllerBuscaCidade(new NewBuscaCidade(telaCadEndereco, true));
            
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == telaCadEndereco.getjButtonNovo()) {
            telaCadEndereco.ativa(false);
            telaCadEndereco.ligaDesliga(true);
            telaCadEndereco.getjTextFieldLogradouro().requestFocus();
                   
        } else if (e.getSource() == telaCadEndereco.getjButtonCancelar()) {
            telaCadEndereco.ativa(true);
            telaCadEndereco.ligaDesliga(false);
            
        } else if (e.getSource() == telaCadEndereco.getjButtonBuscar()) {
            
            NewBuscaEndereco newBuscaEndereco = new NewBuscaEndereco(null, true);
            ControllerBuscaEndereco controllerBuscaEndereco = new ControllerBuscaEndereco(newBuscaEndereco);
            newBuscaEndereco.setVisible(true);
            
        }  else if (e.getSource() == telaCadEndereco.getjButtonGravar()) {
            if (telaCadEndereco.getjTextFieldCidade().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atributo Cidade é Obrigatório");
            }else if(telaCadEndereco.getjTextFieldBairro().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo Bairro é Obrigatório");
            }else if(telaCadEndereco.getjTextFieldLogradouro().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo Logradouro é Obrigatório");
            }else if(telaCadEndereco.getjTextFieldCep().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo Cep é Obrigatório");
            }else {
                Endereco endereco = new Endereco();
               // Cidade cidade = this.controllerBuscaCidade.cidadeCarregada; 
                //Bairro bairro = this.controllerBuscaBairro.bairroCArregado;
               // endereco.setCidade(telaCadEndereco.getjTextFieldCidade().getInt());
              //  endereco.setBairro(bairro);
                endereco.setLogradouro(telaCadEndereco.getjTextFieldLogradouro().getText());
                endereco.setCep(telaCadEndereco.getjTextFieldCep().getText());
     
                telaCadEndereco.ativa(true);
                telaCadEndereco.ligaDesliga(false);
            }
        } else if(e.getSource() == telaCadEndereco.getjButtonSair()) {
            telaCadEndereco.dispose();    
            
        } else  if (e.getSource() == telaCadEndereco.getjButtonBuscaCida()) {
            
            ControllerCidade.codigoCida = 0;
            
            NewBuscaCidade newBuscaCidade = new NewBuscaCidade(null, true);
            ControllerBuscaCidade controllerBuscaCidade = new ControllerBuscaCidade(newBuscaCidade);
            newBuscaCidade.setVisible(true);
            
            if (ControllerCidade.codigoCida != 0) {
                
            Cidade cidade = new Cidade();
            CidadeDAO cidadeDAO = new CidadeDAO();
            cidade = cidadeDAO.retrieve(codigoCida);
            
            telaCadEndereco.getjTextFieldCidade().setText(cidade.getDescricao());      
            }
            
        } else if (e.getSource() == telaCadEndereco.getjButtonBuscaBair()) {
            
            ControllerBairro.codigoBair = 0;
            
            NewBuscaBairro newBuscaBairro = new NewBuscaBairro(null, true);
            ControllerBuscaBairro controllerBuscaBairro = new ControllerBuscaBairro(newBuscaBairro);
            newBuscaBairro.setVisible(true);
            
            if (ControllerBairro.codigoBair != 0) {
                
            Bairro bairro = new Bairro();
            BairroDAO bairroDAO = new BairroDAO();
            bairro = bairroDAO.retrieve(codigoBair);

            telaCadEndereco.getjTextFieldBairro().setText(bairro.getDescricao());
            }
        }  
        
        
    }
  }



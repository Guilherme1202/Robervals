/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.DAO.EnderecoDAO;
import model.bo.Cliente;
import static controller.ControllerEndereco.codigoEnd;
import model.bo.Endereco;
import view.NewBuscaCliente;
import view.NewBuscaEndereco;
import view.NewViewClientes;

/**
 *
 * @author rafael.silva
 */
public class ControllerClientes implements ActionListener{
    NewViewClientes telaCadClientes;
    
    public ControllerClientes (NewViewClientes parTelaCadClientes){
        
        this.telaCadClientes = parTelaCadClientes;
        
            
            telaCadClientes.getjButtonBuscar().addActionListener(this);
            telaCadClientes.getjButtonCancelar().addActionListener(this);
            telaCadClientes.getjButtonGravar().addActionListener(this);
            telaCadClientes.getjButtonNovo().addActionListener(this);
            telaCadClientes.getjButtonSair().addActionListener(this);
            telaCadClientes.getjButtonPesquisaCida().addActionListener(this);

    
            telaCadClientes.ativa(true);
            telaCadClientes.ligaDesliga(false);
            
    }

    private ControllerClientes(NewBuscaCliente newBuscaCliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == telaCadClientes.getjButtonNovo()) {
            telaCadClientes.ativa(false);
            telaCadClientes.ligaDesliga(true);
            telaCadClientes.getjTextFieldCpf().requestFocus();
            
        } else if (e.getSource() == telaCadClientes.getjButtonCancelar()) {
            telaCadClientes.ativa(true);
            telaCadClientes.ligaDesliga(false);
            
        } else if (e.getSource() == telaCadClientes.getjButtonBuscar()) {
            NewBuscaCliente newBuscaCliente = new NewBuscaCliente(null, true);

            ControllerBuscaClientes controllerBuscaClientes = new ControllerBuscaClientes(newBuscaCliente);

            newBuscaCliente.setVisible(true);
        
        } else if (e.getSource() == telaCadClientes.getjButtonGravar()) {
            if (telaCadClientes.getjTextFieldCpf().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atributo CPF é Obrigatório");
            }else if (telaCadClientes.getjTextFieldNome().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo Nome é Obrigatório");
            }else if (telaCadClientes.getjTextFieldCep().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo Cep é Obrigatório");
            }else if (telaCadClientes.getjTextFieldEmail().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo Email é Obrigatório");
            }else if (telaCadClientes.getjTextFieldCelular().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo Celular é Obrigatório");
            }else {
                Cliente cliente = new Cliente();
                cliente.setCpf(telaCadClientes.getjTextFieldCpf().getText());
                telaCadClientes.ativa(true);
                telaCadClientes.ligaDesliga(false);
            }
        } else  if (e.getSource() == telaCadClientes.getjButtonPesquisaCida()) {
            
            ControllerEndereco.codigoEnd = 0;
            
            NewBuscaEndereco newBuscaEndereco = new NewBuscaEndereco(null, true);
            ControllerBuscaEndereco controllerBuscaEndereco = new ControllerBuscaEndereco(newBuscaEndereco);
            newBuscaEndereco.setVisible(true);
            
            if (ControllerCidade.codigoCida != 0) {
                
            Endereco endereco = new Endereco();
            EnderecoDAO enderecoDAO = new EnderecoDAO();
            endereco = enderecoDAO.retrieve(codigoEnd);
            
            telaCadClientes.getjTextFieldCep().setText(endereco.getCep());      
            telaCadClientes.getjTextFieldCidade().setText(endereco.getCidade().getDescricao());
            telaCadClientes.getjTextFieldBairro().setText(endereco.getBairro().getDescricao());
            telaCadClientes.getjTextFieldLogradouro().setText(endereco.getLogradouro());
            }
            
        }else if(e.getSource() == telaCadClientes.getjButtonSair()) {
            telaCadClientes.dispose();        
        }
    }
}

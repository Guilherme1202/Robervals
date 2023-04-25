/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Cidades/Class.java to edit this template
 */
package controller;

import model.bo.Cidade;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import DAO.CidadeDAO;
import view.NewBuscaCidade;
import view.NewViewCidade;

/**
 *
 * @author rafael.silva
 */
public class ControllerCidade implements ActionListener{

    public static int codigoCida;
    NewViewCidade telaCadCidade;
    
    public ControllerCidade (NewViewCidade parTelaCadCidade){
        
        this.telaCadCidade = parTelaCadCidade;
        
            
            telaCadCidade.getjButtonBuscar().addActionListener(this);
            telaCadCidade.getjButtonCancelar().addActionListener(this);
            telaCadCidade.getjButtonGravar().addActionListener(this);
            telaCadCidade.getjButtonNovo().addActionListener(this);
            telaCadCidade.getjButtonSair().addActionListener(this);
    
            telaCadCidade.ativa(true);
            telaCadCidade.ligaDesliga(false);
            
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == telaCadCidade.getjButtonNovo()) {
            
            telaCadCidade.ativa(false);
            telaCadCidade.ligaDesliga(true);
            telaCadCidade.getTxtId().setEnabled(false);
            telaCadCidade.getTxtDescricao().requestFocus();
            
        } else if (e.getSource() == telaCadCidade.getjButtonCancelar()) {
            
            telaCadCidade.ativa(true);
            telaCadCidade.ligaDesliga(false);
            
        } else if (e.getSource() == telaCadCidade.getjButtonBuscar()) {
            
            ControllerCidade.codigoCida = 0;
            
            NewBuscaCidade newBuscaCidade = new NewBuscaCidade(null, true);
            ControllerBuscaCidade controllerBuscaCidade = new ControllerBuscaCidade(newBuscaCidade);
            newBuscaCidade.setVisible(true);
            
            if (ControllerCidade.codigoCida != 0) {
                
            Cidade cidade = new Cidade();
            CidadeDAO cidadeDAO = new CidadeDAO();
            cidade = cidadeDAO.retrieve(codigoCida);
            
            telaCadCidade.ativa(false);
            telaCadCidade.ligaDesliga(true);
            telaCadCidade.getTxtId().setText(cidade.getId()+ "");
            telaCadCidade.getTxtDescricao().setText(cidade.getDescricao());
            telaCadCidade.getTxtId().setEnabled(false);   
            }
        
        } else if (e.getSource() == telaCadCidade.getjButtonGravar()) {
            
            if (telaCadCidade.getTxtDescricao().getText().trim().equalsIgnoreCase("")) {   
                JOptionPane.showMessageDialog(null, "Atributo Descrição é Obrigatório");
             } else {
                Cidade cidade = new Cidade();
                cidade.setDescricao(telaCadCidade.getTxtDescricao().getText());
                
                //Persistir objeto no cidade
                CidadeDAO cidadeDAO = new CidadeDAO ();
                if (this.telaCadCidade.getTxtId().getText().equalsIgnoreCase("")){
                cidadeDAO.create(cidade);
                }else{
                    cidade.setId(Integer.parseInt(telaCadCidade.getTxtId().getText()));
                    cidadeDAO.update(cidade);
                }
                        
                telaCadCidade.ativa(true);
                telaCadCidade.ligaDesliga(false);
            }
        } else if(e.getSource() == telaCadCidade.getjButtonSair()) {
            telaCadCidade.dispose();        
        }
    }
}

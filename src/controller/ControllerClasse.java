/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.bo.Classe;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import DAO.ClasseDAO;
import view.NewBuscaClasse;
import view.NewViewClasse;

/**
 *
 * @author rafael.silva
 */
public class ControllerClasse implements ActionListener{

    public static int codigo;
    NewViewClasse telaCadClasse;
    
    public ControllerClasse (NewViewClasse parTelaCadClasse){
        
        this.telaCadClasse = parTelaCadClasse;
        
            
            telaCadClasse.getjButtonBuscar().addActionListener(this);
            telaCadClasse.getjButtonCancelar().addActionListener(this);
            telaCadClasse.getjButtonGravar().addActionListener(this);
            telaCadClasse.getjButtonNovo().addActionListener(this);
            telaCadClasse.getjButtonSair().addActionListener(this);
    
            telaCadClasse.ativa(true);
            telaCadClasse.ligaDesliga(false);
            
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == telaCadClasse.getjButtonNovo()) {
            
            telaCadClasse.ativa(false);
            telaCadClasse.ligaDesliga(true);
            telaCadClasse.getTxtId().setEnabled(false);
            telaCadClasse.getjTextDescricao().requestFocus();
            
        } else if (e.getSource() == telaCadClasse.getjButtonCancelar()) {
            
            telaCadClasse.ativa(true);
            telaCadClasse.ligaDesliga(false);
            
        } else if (e.getSource() == telaCadClasse.getjButtonBuscar()) {
            
            ControllerClasse.codigo = 0;
            
            NewBuscaClasse newBuscaClasse = new NewBuscaClasse(null, true);
            ControllerBuscaClasse controllerBuscaClasse = new ControllerBuscaClasse(newBuscaClasse);
            newBuscaClasse.setVisible(true);
            
            if (ControllerClasse.codigo != 0) {
                
            Classe classe = new Classe();
            ClasseDAO classeDAO = new ClasseDAO();
            classe = classeDAO.retrieve(codigo);
            
            telaCadClasse.ativa(false);
            telaCadClasse.ligaDesliga(true);
            telaCadClasse.getTxtId().setText(classe.getId()+ "");
            telaCadClasse.getjTextDescricao().setText(classe.getDescricao());
            telaCadClasse.getTxtId().setEnabled(false);   
            }
        
        } else if (e.getSource() == telaCadClasse.getjButtonGravar()) {
            
            if (telaCadClasse.getjTextDescricao().getText().trim().equalsIgnoreCase("")) {   
                JOptionPane.showMessageDialog(null, "Atributo Descrição é Obrigatório");
             } else {
                Classe classe = new Classe();
                classe.setDescricao(telaCadClasse.getjTextDescricao().getText());
                
                //Persistir objeto no classe
                ClasseDAO classeDAO = new ClasseDAO ();
                if (this.telaCadClasse.getTxtId().getText().equalsIgnoreCase("")){
                classeDAO.create(classe);
                }else{
                    classe.setId(Integer.parseInt(telaCadClasse.getTxtId().getText()));
                    classeDAO.update(classe);
                }
                        
                telaCadClasse.ativa(true);
                telaCadClasse.ligaDesliga(false);
            }
        } else if(e.getSource() == telaCadClasse.getjButtonSair()) {
            telaCadClasse.dispose();        
        }
    }
}

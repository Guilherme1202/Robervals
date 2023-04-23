/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.bo.Marca;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import DAO.MarcaDAO;
import view.NewBuscaMarca;
import view.NewViewMarca;

/**
 *
 * @author rafael.silva
 */
public class ControllerMarca implements ActionListener{

    public static int codigoMar;
    NewViewMarca telaCadMarca;
    
    public ControllerMarca (NewViewMarca parTelaCadMarca){
        
        this.telaCadMarca = parTelaCadMarca;
        
            
            telaCadMarca.getjButtonBuscar().addActionListener(this);
            telaCadMarca.getjButtonCancelar().addActionListener(this);
            telaCadMarca.getjButtonGravar().addActionListener(this);
            telaCadMarca.getjButtonNovo().addActionListener(this);
            telaCadMarca.getjButtonSair().addActionListener(this);
    
            telaCadMarca.ativa(true);
            telaCadMarca.ligaDesliga(false);
            
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == telaCadMarca.getjButtonNovo()) {
            
            telaCadMarca.ativa(false);
            telaCadMarca.ligaDesliga(true);
            telaCadMarca.getTxtId().setEnabled(false);
            telaCadMarca.getjTextFieldDescricao().requestFocus();
            
        } else if (e.getSource() == telaCadMarca.getjButtonCancelar()) {
            
            telaCadMarca.ativa(true);
            telaCadMarca.ligaDesliga(false);
            
        } else if (e.getSource() == telaCadMarca.getjButtonBuscar()) {
            
            ControllerMarca.codigoMar = 0;
            
            NewBuscaMarca newBuscaMarca = new NewBuscaMarca(null, true);
            ControllerBuscaMarca controllerBuscaMarca = new ControllerBuscaMarca(newBuscaMarca);
            newBuscaMarca.setVisible(true);
            
            if (ControllerMarca.codigoMar != 0) {
                
            Marca marca = new Marca();
            MarcaDAO marcaDAO = new MarcaDAO();
            marca = marcaDAO.retrieve(codigoMar);
            
            telaCadMarca.ativa(false);
            telaCadMarca.ligaDesliga(true);
            telaCadMarca.getTxtId().setText(marca.getId()+ "");
            telaCadMarca.getjTextFieldDescricao().setText(marca.getDescricao());
            telaCadMarca.getTxtId().setEnabled(false);   
            }
        
        } else if (e.getSource() == telaCadMarca.getjButtonGravar()) {
            
            if (telaCadMarca.getjTextFieldDescricao().getText().trim().equalsIgnoreCase("")) {   
                JOptionPane.showMessageDialog(null, "Atributo Descrição é Obrigatório");
             } else {
                Marca marca = new Marca();
                marca.setDescricao(telaCadMarca.getjTextFieldDescricao().getText());
                
                //Persistir objeto no marca
                MarcaDAO marcaDAO = new MarcaDAO ();
                if (this.telaCadMarca.getTxtId().getText().equalsIgnoreCase("")){
                marcaDAO.create(marca);
                }else{
                    marca.setId(Integer.parseInt(telaCadMarca.getTxtId().getText()));
                    marcaDAO.update(marca);
                }
                        
                telaCadMarca.ativa(true);
                telaCadMarca.ligaDesliga(false);
            }
        } else if(e.getSource() == telaCadMarca.getjButtonSair()) {
            telaCadMarca.dispose();        
        }
    }
}

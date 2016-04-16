/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import View.LoginAsisten;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author HP
 */
public class ControllerLoginAsisten implements ActionListener {
    LoginAsisten la;
    public ControllerLoginAsisten() {
        la=new LoginAsisten();
        la.setVisible(true);      
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

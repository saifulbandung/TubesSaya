/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.LoginAsisten;
import View.LoginMahasiswa;
import View.MenuAsisten;
import View.MenuMhs;
import View.MenuUtama;
import View.SignupAsisten;
import View.SignupMahasiswa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author HP
 */
public class ControllerMenuUtama implements ActionListener{
    Object view;
    MenuUtama mu;
    LoginAsisten la;
    LoginMahasiswa lm;
    SignupAsisten sa;
    SignupMahasiswa sm;
    MenuAsisten ma;
    MenuMhs mm;
    
    public ControllerMenuUtama(){
        mu = new MenuUtama();
        mu.setVisible(true);
        mu.ActionListioner(this);
        view = mu;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source= new Object();
        source=e.getSource();   
            if(source.equals(mu.getLogin_Asisten())){               
                gotologinAsisten(e);
            
            }else if(source.equals(mu.getLogin_Mahasiswa())){
                gotologinMahasiswa(e);
            }else if(source.equals(mu.getSignup_Asisten())){
                gotoregistrasiAsisten();
            }else if(source.equals(mu.getSignup_Mahasiswa())){
                gotoregistrasiMahasiswa();
            }else if(source.equals(mu.getKeluar())){
                gotoKeluarMenuUtama();
            }    
    }
    public void gotologinAsisten(ActionEvent e){
        la=new LoginAsisten();
        la.setVisible(true);
        la.addActionListener(this);
        mu.dispose();
        Object source= new Object();
        source = e.getSource();
        if(source.equals(la.getMasuk())){
           gotoMenuAsisten();
        }
    }
    public void gotologinMahasiswa(ActionEvent e){
        lm= new LoginMahasiswa();
        lm.setVisible(true);
        mu.dispose();
        Object source= new Object();
        source = e.getSource();
        if(source.equals(lm.getMasuk())){
          gotoMenuMahasiswa();  
        }
    }
    public void gotoregistrasiAsisten(){
        sa = new SignupAsisten();
        sa.setVisible(true);
        mu.dispose();
    }
    public void gotoregistrasiMahasiswa(){
        sm = new SignupMahasiswa();
        sm.setVisible(true);
        mu.dispose();
    }
    public void gotoKeluarMenuUtama(){
        System.exit(0);
    }
    public void gotoMenuAsisten(){
         ma = new MenuAsisten();
         ma.setVisible(true);
         la.dispose();
    }
    public void gotoMenuMahasiswa(){
        mm = new MenuMhs();
        mm.setVisible(true);
        la.dispose();
    }
    
}

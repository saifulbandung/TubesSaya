/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Application;
import View.LoginAsisten;
import View.MenuAsisten;
import View.MenuUtama;
import View.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author HP
 */
public class ControllerMenuUtama implements ActionListener{
    View view;
    Application app;
    
    public ControllerMenuUtama(Application app){
        this.app = app;
        gotoMenuUtama();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(view instanceof MenuUtama) {
            MenuUtama x = (MenuUtama) view;
            if(source.equals(x.getLogin_Asisten())) {
                gotologinAsisten();
                x.dispose();
            }
            else if(source.equals(x.getKeluar())) {
                System.exit(0);
            }
        }
        if(view instanceof LoginAsisten) {
            LoginAsisten x = (LoginAsisten) view;
            if(source.equals(x.getMasuk())) {
                gotoMenuAsisten();
                x.dispose();
            }
            else if(source.equals(x.getKembali())) {
                gotoMenuUtama();
                x.dispose();
            }
        }
        if(view instanceof MenuAsisten) {
            MenuAsisten x = (MenuAsisten) view;
            if(source.equals(x.getKembali())) {
                gotologinAsisten();
                x.dispose();
            }
        }
            
    }
    public void gotoMenuUtama() {
        MenuUtama utama = new MenuUtama();
        utama.setVisible(true);
        utama.addActionListener(this);
        view = utama;
        
    }
    public void gotologinAsisten(){
        LoginAsisten x = new LoginAsisten();
        x.setVisible(true);
        x.addActionListener(this);
        view = x;
    }
//    public void gotologinMahasiswa(ActionEvent e){
//        lm= new LoginMahasiswa();
//        lm.setVisible(true);
//        mu.dispose();
//        Object source= new Object();
//        source = e.getSource();
//        if(source.equals(lm.getMasuk())){
//          gotoMenuMahasiswa();  
//        }
//    }
//    public void gotoregistrasiAsisten(){
//        sa = new SignupAsisten();
//        sa.setVisible(true);
//        mu.dispose();
//    }
//    public void gotoregistrasiMahasiswa(){
//        sm = new SignupMahasiswa();
//        sm.setVisible(true);
//        mu.dispose();
//    }
//    }
    public void gotoMenuAsisten(){
        MenuAsisten x = new MenuAsisten();
        x.setVisible(true);
        x.addActionListener(this);
        view = x;
    }
//    public void gotoMenuMahasiswa(){
//        mm = new MenuMhs();
//        mm.setVisible(true);
//        la.dispose();
//    }
    
}

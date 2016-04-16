/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.FileIO;
import Controller.ControllerMenuUtama;
import Model.Application;


/**
 *
 * @author HP
 */
public class Driver {
    public static void main(String[] args) {
        // TODO code application logic here
        //input from Asisten
       
        Application app = new Application(20,50);
        FileIO f= new FileIO(app);
        f.readFileAsisten();
        f.readFileMahasiswa();
        ConsoleUI m = new ConsoleUI(app,f);
       // m.menuLog();
        ControllerMenuUtama cc = new ControllerMenuUtama(app,m,f);
     
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orang;


/**
 *
 * @author HP
 */
public class Driver {
    public static void main(String[] args) {
        // TODO code application logic here
        //input from Asisten
        Application app = new Application(10,20);
        FileIO f= new FileIO(app);
        ConsoleUI m = new ConsoleUI(app,f);
        m.menuLog();
      // f.saveFileAsisten();
      // f.saveFileMahasiswa();
        
        
    }
}

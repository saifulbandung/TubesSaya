/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Model.Application;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import Model.Asisten;
import Model.Asisten;
import Model.Mahasiswa;
import Model.Mahasiswa;

public class FileIO {
    private Application app;
    
    public FileIO(Application app){
        this.app=app;
    }
    public void saveFileAsisten(){
        try(FileOutputStream fasi = new FileOutputStream("Asisten.txt")){ 
            ObjectOutputStream oout = new ObjectOutputStream(fasi);
            oout.writeObject(app.a);
            oout.flush();
        }catch(Exception e){       
        }
    }
    public void saveFileMahasiswa(){
        try(FileOutputStream fmhs = new FileOutputStream("Mahasiswa.txt")){
            ObjectOutputStream omhs = new ObjectOutputStream(fmhs);
            omhs.writeObject(app.m);
            omhs.flush();
        }catch(Exception e){
            
        }
    }
    public void readFileAsisten(){
        try(ObjectInputStream oasi= new ObjectInputStream(new FileInputStream("Asisten.txt"))){
            app.a = (Asisten[]) oasi.readObject();
            oasi.close();
        }catch(Exception e){
        }
        
    }
    public void readFileMahasiswa(){
        try(ObjectInputStream omhs= new ObjectInputStream(new FileInputStream("Mahasiswa.txt"))){
            app.m=(Mahasiswa[]) omhs.readObject();
            omhs.close();
        }catch(Exception e){
            
        }
    }
}

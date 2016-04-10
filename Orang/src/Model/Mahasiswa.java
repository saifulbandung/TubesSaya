/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author HP
 */
public class Mahasiswa extends Orang implements Serializable{
    private int id;
    private String pass;
    public  Mahasiswa(String nama, String jenisKel, int id) {
        super(nama, jenisKel);
        this.id=id;
    }
    public void setId(int id){
        
        this.id=id;
    }
    public int getId(){
         return id;
    }
    public void setPass(String pass){
    this.pass=pass;
    }
    public String getPass(){
        return pass;
}
    public String getNama(){
        return super.getNama();
    }
    public int getUmur(){
        return super.getUmur();
    }
    public String getjenisKel(){
        return super.getjenisKel();
    }
    public void setUmur(int umur){
        super.setUmur(umur);
    }
}

    
    


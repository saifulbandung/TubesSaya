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
public class Mahasiswa extends Orang{
    private int id;
    private String pass;
    public  Mahasiswa(String nama, String jenisKel, int umur) {
        super(nama, jenisKel, umur);
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
    
    
}

    
    


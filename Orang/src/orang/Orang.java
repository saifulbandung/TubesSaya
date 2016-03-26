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
public abstract class Orang {
    /**
     * @param args the command line arguments
     */
    private String nama;
    private String jenisKel;
    private int umur;
    
    public Orang (String nama, String jenisKel, int umur){
        this.nama=nama;
        this.jenisKel=jenisKel;
        this.umur=umur;
    }
    public void setNama(String nama){
        this.nama=nama;
    }
    String getNama(){
        return nama;
    }
    public void setjenisKel(String jenisKel){
        this.jenisKel=jenisKel;
    }
    String getjenisKel(){
        return jenisKel;
    }
    public void setUmur(int umur){
        this.umur=umur;
    }
    int getUmur(){
        return umur;
    }
    
}

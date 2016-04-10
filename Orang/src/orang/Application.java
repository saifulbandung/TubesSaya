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
public class Application {
     Asisten[] a;
     Mahasiswa[] m;
    private int numofAsisten=0;
    private int numofMahasiswa=0;
    public Application(int e, int q){
        a = new Asisten[e];
        m = new Mahasiswa[q];
    }
    public void addAsisten(String nama,String jenisKel, int id,int maxTugasBesar){
        a[numofAsisten] = new Asisten(nama, jenisKel, id, maxTugasBesar);
        numofAsisten++;
    }
    public void addMahasiswa(String nama, String jenisKel, int id){
        m[numofMahasiswa] = new Mahasiswa(nama, jenisKel, id);
        numofMahasiswa++;
    }
    public Asisten getAsisten(int l){
        return a[l];
    }
    public Mahasiswa getMahasiswa(int l){
        return m[l];
    }
    public int getnumofAsisten(){
        return numofAsisten;
    }
    public int getnumofMahasiswa(){
        return numofMahasiswa;
    }

    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;



/**
 *
 * @author HP
 */
public class Application {
    
     Asisten[] a;
     Mahasiswa[] m;
    private int numofAsisten=0;
    private int numofMahasiswa=0;
    
    public Application(){        
    }
    public Application(int e, int q){
        a = new Asisten[e];
        m = new Mahasiswa[q];
    }
    public void addAsisten(String nama,String jenisKel, int id,int maxTugasBesar){ 
        while(getAsisten(numofAsisten)!=null){
            numofAsisten++;
        }
            a[numofAsisten] = new Asisten(nama, jenisKel, id, maxTugasBesar);
            numofAsisten++;
    }
    public void addMahasiswa(String nama, String jenisKel, int id){
        while(getMahasiswa(numofMahasiswa)!=null){
            numofMahasiswa++;
        }
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
    public String show_all(){
        String s = "";   
        int q = 0;
        int p = 0;
        int r = 0;     
        while(getAsisten(q)!=null){
            s=s+"Asisten: "+getAsisten(q).getNama()+"\n";
            while(getAsisten(q).getTugasBesar(p)!=null){
                s=s+"\n"+("    Crate Tubes : "+getAsisten(q).getTugasBesar(p).getJudul())+"\n";
                while(getAsisten(q).getTugasBesar(p).getMahasiswa(r)!=null){
                    s=s+("        Anggota : "+getAsisten(q).getTugasBesar(p).getMahasiswa(r).getNama()+" "+getAsisten(q).getTugasBesar(p).getMahasiswa(r).getId())+"\n";
                    s=s+("        Umur    : "+getAsisten(q).getTugasBesar(p).getMahasiswa(r).getUmur())+"\n"+"\n";
                    r++;
                }
                r=0;
                p++;
            }
            p=0;
            q++;
        }
        return s;
    }
    
    
    
}

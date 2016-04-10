/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orang;
import java.util.Date;
/**
 *
 * @author HP
 */
public class TugasBesar {
    private Dokumentasi [] dokumentasi;
    private Mahasiswa [] member;
    private String judul;
    private int numofDokumentasi=0;
    private int numofMahasiswa=0;
    private int maxDokumentasi=10;
    private int maxMahasiswa;
    private boolean sucessaddMhs=false;
    
    public TugasBesar(){}
    public TugasBesar(String judul,int maxMahasiswa){
        this.judul=judul;
        this.maxMahasiswa=maxMahasiswa;
        dokumentasi= new Dokumentasi[maxDokumentasi];
        member = new Mahasiswa[maxMahasiswa];
    }
    public void createDokumentasi(String namaDokumentasi,Date tanggal,String isi){
        dokumentasi[numofDokumentasi]=new Dokumentasi(namaDokumentasi,tanggal,isi);
        numofDokumentasi++;
    }
    public void addMember(String nama,String jenisKel,int id){
        if(numofMahasiswa<maxMahasiswa){
        member[numofMahasiswa]=new Mahasiswa(nama,jenisKel,id);
        numofMahasiswa++;
        sucessaddMhs=true;
        }else if(numofMahasiswa==maxMahasiswa){
            for(int i=1;i<=maxMahasiswa;i++){
                if(member[i]==null){
                    member[i]= new Mahasiswa(nama,jenisKel,id);
                    numofMahasiswa=i+1;
                    sucessaddMhs=true;
                }
            }
        }else {
            System.out.println("maaf kelompok sudah penuh");
            sucessaddMhs=false;
        }
    }
    
    public void hapusMahasiswa(int x){       
        numofMahasiswa=numofMahasiswa-1;
        while(member[x+1]!=null){
            member[x]=member[x+1];
            x++;
        }
        if(member[x]!=null){
            member[x]=null;
            numofMahasiswa=numofMahasiswa-1;
        }
    }
    public void setJudul(String judul){
        this.judul=judul;
    }
    public String getJudul(){
        return judul;
    }
    public Dokumentasi getDokumentasi(int i){
        return dokumentasi[i];
    }
    public Mahasiswa getMahasiswa(int i){
        return member[i];
    }
    public int getNumofMahasiswa(){
        return numofMahasiswa;
    }
    public int getMaxMahasiswa(){
        return maxMahasiswa;
    }
    public int getMaxDokumentasi(){
        return maxDokumentasi;
    }
    public boolean getSucessAddMhs(){
        return sucessaddMhs;
    }
    
    
}

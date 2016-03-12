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
public class TugasBesar {
    private Dokumentasi [] dokumentasi;
    private Mahasiswa [] member;
    private String judul;
    private int numofDokumentasi;
    private int numofMahasiswa;
    private int maxDokumentasi;
    private int maxMahasiswa;
    
    public TugasBesar(){}
    public TugasBesar(String judul,int maxMahasiswa,int maxDokumentasi){
        this.judul=judul;
        this.maxDokumentasi=maxDokumentasi;
        this.maxMahasiswa=maxMahasiswa;
        dokumentasi= new Dokumentasi[maxDokumentasi];
        member = new Mahasiswa[maxMahasiswa];
    }
    public void createDokumentasi(String namaDokumentasi){
        dokumentasi[numofDokumentasi]=new Dokumentasi();
        dokumentasi[numofDokumentasi].setNamaDokumentasi(namaDokumentasi);
        numofDokumentasi++;
    }
    public void addMember(String nama,String jenisKel,int umur){
        if(numofMahasiswa<maxMahasiswa){
        member[numofMahasiswa]=new Mahasiswa(nama,jenisKel,umur);
        numofMahasiswa++;
        }else {
            System.out.println("maaf kelompok sudah penuh");
        }
    }
    
    public void hapusMahasiswa(int x){
        member[x].setId(0);
        member[x].setNama(null);
        member[x].setPass(null);
        member[x].setUmur(0);
        member[x].setjenisKel(null);
        member[x]=null;
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
    
    
    
}

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
public class Dokumentasi {
    
    private String namaDokumentasi;
    private int tanggal; 
    private int bulan;
    private int tahun;
    private String isi;
    
    public void setNamaDokumentasi(String namaDokumentasi){
        this.namaDokumentasi=namaDokumentasi;
    }
    public String getNamaDokumentasi(){
        return namaDokumentasi;
    }
    public void setIsi(String isi){
        this.isi=isi;
    }
    public String getIsi(){
        return isi;
    }
    public void setTanggal(int tanggal){
        this.tanggal=tanggal;
    }
    public int getTanggal(){
        return tanggal;
    }
    public void setBulan(int bulan){
        this.bulan=bulan;
    } 
    public int getBulan(){
        return bulan;
    }
    public void setTahun(int tahun){
        this.tahun=tahun;
    }
    public int getTahun(){
        return tahun;
    }
    
    
}

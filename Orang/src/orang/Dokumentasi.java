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
public class Dokumentasi {   
    private String namaDokumentasi;
    private Date tanggal; 
    private String isi;
    
    public Dokumentasi(String namaDokumentasi,Date tanggal,String isi){
        this.namaDokumentasi=namaDokumentasi;
        this.tanggal=tanggal;
        this.isi=isi;
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
    public void setTanggal(Date tanggal){
        this.tanggal=tanggal;
    }
    public Date getTanggal(){
        return tanggal;
    } 
}

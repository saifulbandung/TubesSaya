/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Application;
import Model.Asisten;
import Model.ConsoleUI;
import Model.FileIO;
import View.BuatDokument;
import View.KurangMahasiswa;
import View.KurangMahasiswa2;
import View.LihatTubes;
import View.LoginAsisten;
import View.LoginMahasiswa;
import View.MenuAsisten;
import View.MenuMahasiswa;
import View.MenuUtama;
import View.PilihTugasBesar;
import View.SignupAsisten;
import View.SignupMahasiswa;
import View.TambahMahasiswa;
import View.TambahMahasiswa2;
import View.TambahTubes;
import View.TampilanDokumentasi;
import View.Tampilkan;
import View.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author HP
 */
public class ControllerMenuUtama implements ActionListener{
    View view;
    Application app;
    ConsoleUI c;
    FileIO f;
    int aa,zz;
    int pilihan,pilihan2;
    boolean cek;
    String ss;
    
    public ControllerMenuUtama(Application app,ConsoleUI c,FileIO f){
        this.app = app;
        this.c=c;
        this.f=f;
        gotoMenuUtama();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(view instanceof MenuUtama) {
            MenuUtama x = (MenuUtama) view;
            aa=999;
            if(source.equals(x.getLogin_Asisten())) {
                gotoLoginAsisten();
                x.dispose();
            }
            else if(source.equals(x.getLogin_Mahasiswa())){
                gotoLoginMahasiswa();
                x.dispose();
            }
            else if(source.equals(x.getSignup_Asisten())){
                gotoSignupAsisten();
                x.dispose();
            }
            else if(source.equals(x.getSignup_Mahasiswa())){
                gotoSignupMahasiswa();
                x.dispose();
            }
            else if(source.equals(x.getKeluar())) {
                System.exit(0);
            }
        }
        if(view instanceof LoginAsisten) {
            LoginAsisten x = (LoginAsisten) view;
            try{
                if(source.equals(x.getMasuk())){
                    int v = 999;
                    v = c.cekAsisten(x.getNama(),x.getPassword());
                    if(v==999){
                     x.logingagal();
                    }else{
                        aa=v;
                        gotoMenuAsisten();
                        x.dispose();
                    }  
                } 
            else if(source.equals(x.getKembali())) {
                gotoMenuUtama();
                x.dispose();
            }
                }catch(Exception ex){
                x.logingagal();
            }
        }
        if(view instanceof MenuAsisten) {
            MenuAsisten x = (MenuAsisten) view;
            if(source.equals(x.getKeluar())) {
                gotoMenuUtama();
                x.dispose();
            }
            else if(source.equals(x.getTambahTubes())){
                gotoTambahTubes();
                x.dispose();
            }
            else if(source.equals(x.getTambahMahasiswa())){
                gotoTambahMahasiswa();
                x.dispose();
            }
            else if(source.equals(x.getKurangMahasiswa())){
                gotoKurangMahasiswa();
                x.dispose();
            }
            else if(source.equals(x.getTampilkan())){
                gotoTampilkan();
                x.dispose();
            }
        }
        if(view instanceof LoginMahasiswa){
            LoginMahasiswa x = (LoginMahasiswa) view;
            try{
                if(source.equals(x.getMasuk())){
                    int v = 999;
                    v = c.cekMahasiswa(x.getnama(),x.getPassword());
                    System.out.println(v);
                    if(v==999){
                        x.logingagal();
                    }else{
                        aa=v;
                        gotoMenuMahasiswa();
                        x.dispose();
                    }  
                }
                else if(source.equals(x.getKembali())){
                    gotoMenuUtama();
                    x.dispose();
                }
            }catch(Exception ee){
                x.logingagal();
            }
            
        }
        if(view instanceof MenuMahasiswa){
            MenuMahasiswa x = (MenuMahasiswa) view;
            if(source.equals(x.getPilih())){
                gotoPilihTugasBesar();
                x.dispose();
            }
            else if(source.equals(x.getLihat())){
                gotoLihatTubes();
                x.dispose();
            }
            else if(source.equals(x.getBuat())){
                gotoBuatDokumentasi();
                x.dispose();
            }
            else if(source.equals(x.getTampilkan())){
                gotoTampilanDokumentasi();
                x.dispose();
            }
            else if(source.equals(x.getLogout())){
                gotoMenuUtama();
                x.dispose();
            }
        }    
        if(view instanceof TambahTubes){
            TambahTubes z = (TambahTubes) view;
            if(source.equals(z.getInput())){
                try{
                    app.getAsisten(aa).createTugasBesar(z.getJudultubes(),z.getKuota());
                    f.saveFileAsisten();
                    gotoMenuAsisten();
                    z.dispose();
                }catch(Exception ee){
                    z.tambahTubesGagal();
                }
            }
            else if(source.equals(z.getKembali())){
                gotoMenuAsisten();
                z.dispose();
            }
        }
        if(view instanceof TambahMahasiswa ){
            TambahMahasiswa z = (TambahMahasiswa) view;
            z.setJudul(c.show_pilihan_tubes());
            if(source.equals(z.getOk())){
                try{
                    pilihan = z.getPilih();                   
                    if((pilihan<1)||pilihan>=c.getMaxr()){
                        JOptionPane.showMessageDialog(null,"tidak ada pilihan");
                    }else{
                    gotoTambahMahasiswa2();
                    z.dispose();
                    }
                }catch(Exception ee){
                    z.gagalPilihan();
                }
            }
            else if(source.equals(z.getKembali())){
                gotoMenuAsisten();
                z.dispose();
            }
            
        }
        if(view instanceof KurangMahasiswa){
            KurangMahasiswa z = (KurangMahasiswa) view;
            z.setJudul(c.show_kurang());
            if(source.equals(z.getOk())){
                try{
                pilihan = z.getPilihlah();
                if(pilihan<c.getMaxr()&&pilihan>0){
                   gotoKurangMahasiswa2();
                    z.dispose(); 
                }
                else{
                    JOptionPane.showMessageDialog(null,"Pilihan Tidak ada");
                }
                }catch(Exception ee){
                    JOptionPane.showMessageDialog(null,"Inputan harus angka");
                }
            }
            else if(source.equals(z.getKembali())){
                gotoMenuAsisten();
                z.dispose();
            }
        }
        if(view instanceof KurangMahasiswa2){
            KurangMahasiswa2 z =(KurangMahasiswa2) view;
            z.setJudul(c.getJudul(pilihan));
            z.setNama(c.Show_kurangMahasiswa2(pilihan));
            if(source.equals(z.getOk())){
                pilihan2= z.getPilihlah();
                if(pilihan2>0&&pilihan2<=c.getMaxr()){
                    if(c.show_KurangMahasiswa3(z.getNim(),pilihan, pilihan2)==true){
                        gotoMenuAsisten();
                        z.dispose();
                    }  
                }
                else{
                    JOptionPane.showMessageDialog(null,"Pilihan Tidak ada");
                }
            }
            else if(source.equals(z.getKembali())){
                gotoMenuAsisten();
                z.dispose();
            }
        }   
        if(view instanceof PilihTugasBesar){
            PilihTugasBesar a = (PilihTugasBesar) view;
            if(c.pilih_Tubes1(aa)==""){
                a.setJudul("Anda Telah Terdaftar Di Tugas Besar");
            }
            else{
                a.setJudul(c.pilih_Tubes1(aa));
            }           
            if(source.equals(a.getKembali())){
                gotoMenuMahasiswa();
                a.dispose();
            }
            else if (source.equals(a.getOk())){
                try{
                    pilihan=a.getPilih();
                    if(pilihan>0&&pilihan<c.getMaxr()){
                        c.pilih_tubes2(pilihan);
                        gotoMenuMahasiswa();
                        a.dispose(); 
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Pilihan tidak ada");
                    }
                }catch(Exception ea){
                        JOptionPane.showMessageDialog(null,"Inputan Salah");
                }
            }      
        }
        if(view instanceof LihatTubes){
            LihatTubes a = (LihatTubes) view;
               a.setData(c.show_TubesTerdaftar(app.getMahasiswa(aa).getNama(),app.getMahasiswa(aa).getId()));
            if(source.equals(a.getKembalii())){
                gotoMenuMahasiswa();
                a.dispose();
            }
        }
        if(view instanceof BuatDokument){
            BuatDokument a = (BuatDokument) view;
            a.setTanggal(c.getTanggal());
            if(source.equals(a.getSimpan())){
                if(c.buatDokumentasi(aa,a.getJudul(),a.getIsi())==true){
                    gotoMenuMahasiswa();
                    a.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Data Tidak tersimpan");
                }
            }
            else if(source.equals(a.GetKembali())){
                gotoMenuMahasiswa();
                a.dispose();
            }
        }
        if(view instanceof Tampilkan){
            Tampilkan a = (Tampilkan) view;
            a.setData(app.show_all()); 
            if(source.equals(a.getKembali())){
                gotoMenuAsisten();
                a.dispose();
            }
        }
        if(view instanceof TambahMahasiswa2){
            TambahMahasiswa2 a = (TambahMahasiswa2) view;
            if(source.equals(a.getSimpan())){
                try{
                    int q = c.yang_dipilih_tubes(pilihan,a.getNama(),a.getNim(),a.getUmur(),a.getJeniskel());
                    if(q==1){
                        JOptionPane.showMessageDialog(null,"penambahan Berhasil");
                    }
                    else if(q==2){
                        JOptionPane.showMessageDialog(null,"pilih Tubes Berhasil & akun Mahasiswa terbuat");
                    }else{
                       JOptionPane.showMessageDialog(null,"ada kesalahan"); 
                    }
                    gotoMenuAsisten();
                    a.dispose();
                 }catch(Exception ee){
                    JOptionPane.showMessageDialog(null,"ada kesalahan");
                }
            }
            else if(source.equals(a.getKembali())){
                gotoMenuAsisten();
                a.dispose();
            }
        }
        if(view instanceof TampilanDokumentasi){
            TampilanDokumentasi a = (TampilanDokumentasi) view;
                ss=c.tamplikanDokumentasi(aa);
            if(ss!=""){
                a.setIsi(ss);
            }
            else{
                a.setIsi("Tidak ada History pembuatan");
            } 
            if(source.equals(a.getKembali())){
                gotoMenuMahasiswa();
                a.dispose();
            }
        }
        if(view instanceof SignupAsisten){
            SignupAsisten a = (SignupAsisten) view;
            if(source.equals(a.getMasuk())){
                try{
                    app.addAsisten(a.getNama(),a.getJenis_kelamin(),a.getNim(),a.getKuota());
                    app.getAsisten(app.getnumofAsisten()-1).setUmur(a.getUmur());
                    app.getAsisten(app.getnumofAsisten()-1).setPass(a.getPassword());
                    aa=app.getnumofAsisten()-1;
                    f.saveFileAsisten();
                    gotoMenuAsisten();
                    a.dispose();
                }catch (Exception ex){
                    a.signupGagal();
                }
            }
            else if(source.equals(a.getKembali())){
                gotoMenuUtama();
                a.dispose();
            }
        }
        if(view instanceof SignupMahasiswa){
            SignupMahasiswa a = (SignupMahasiswa) view;
            if(source.equals(a.getMasuk())){
//                try{
                    app.addMahasiswa(a.getNama(),a.getJenis_kelamin(),a.getNim());
                    System.out.println(app.getnumofMahasiswa()-1);
                    app.getMahasiswa(app.getnumofMahasiswa()-1).setUmur(a.getUmur());
                    app.getMahasiswa(app.getnumofMahasiswa()-1).setPass(a.getPassword());
                    aa= app.getnumofMahasiswa()-1;
                    f.saveFileMahasiswa();                  
                    gotoMenuMahasiswa();
                    a.dispose();
//                }catch(Exception ed){
//                    a.signupGagal();
//                }
            }
            else if(source.equals(a.getKembali())){
                gotoMenuUtama();
                a.dispose();
            }
        }
    }
    public void gotoMenuUtama() {
        MenuUtama utama = new MenuUtama();
        utama.setVisible(true);
        utama.addActionListener(this);
        view = utama;
    }
    public void gotoLoginAsisten(){
        LoginAsisten x = new LoginAsisten();
        x.setVisible(true);
        x.addActionListener(this);
        view = x;
    }
    public void gotoLoginMahasiswa(){
        LoginMahasiswa x =new LoginMahasiswa();
        x.setVisible(true);
        x.addActionListener(this);
        view = x;
    }
    public void gotoSignupAsisten(){
        SignupAsisten x = new SignupAsisten();
        x.setVisible(true);
        x.addActionListener(this);
        view = x;
    }
    public void gotoSignupMahasiswa(){
        SignupMahasiswa x = new SignupMahasiswa();
        x.setVisible(true);
        x.addActionListener(this);
        view = x;
    }
    public void gotoManuAsisten(){
        MenuAsisten x = new MenuAsisten();
        x.setVisible(true);
        x.addActionListener(this);
        view = x;
    }
    public void gotoTambahTubes(){
        TambahTubes x = new TambahTubes();
        x.setVisible(true);
        x.addActionListener(this);
        view = x;
    }
    public void gotoTambahMahasiswa(){
        TambahMahasiswa x = new TambahMahasiswa();
        x.setVisible(true);
        x.addActionListener(this);
        view = x;
    }
    public void gotoKurangMahasiswa(){
        KurangMahasiswa x = new KurangMahasiswa();
        x.setVisible(true);
        x.addActionListener(this);
        view = x;
    }
    public void gotoTampilkan(){
        Tampilkan x = new Tampilkan();
        x.setVisible(true);
        x.addActionListener(this);
        view = x;
    }
    public void gotoMenuMahasiswa(){
        MenuMahasiswa x = new MenuMahasiswa();
        x.setVisible(true);
        x.addActionListener(this);
        view = x;
    }
    public void gotoBuatDokumentasi(){
        BuatDokument x = new BuatDokument();
        x.setVisible(true);
        x.addActionListener(this);
        view = x;
    }
    public void gotoPilihTugasBesar(){
        PilihTugasBesar x = new PilihTugasBesar();
        x.setVisible(true);
        x.addActionListener(this);
        view = x;
    }
    public void gotoTambahMahasiswa2(){
        TambahMahasiswa2 x = new TambahMahasiswa2();
        x.setVisible(true);
        x.addActionListener(this);
        view = x;
    }
    public void gotoLihatTubes(){
        LihatTubes x = new LihatTubes();
        x.setVisible(true);
        x.addActionListener(this);
        view = x;
    }
    public void gotoTampilanDokumentasi(){
        TampilanDokumentasi x = new TampilanDokumentasi();
        x.setVisible(true);
        x.addActionListener(this);
        view = x;
    }
    public void gotoKurangMahasiswa2(){
        KurangMahasiswa2 x = new KurangMahasiswa2();
        x.setVisible(true);
        x.addActionListener(this);
        view = x;
    }
    
   
//    public void gotologinMahasiswa(ActionEvent e){
//        lm= new LoginMahasiswa();
//        lm.setVisible(true);
//        mu.dispose();
//        Object source= new Object();
//        source = e.getSource();
//        if(source.equals(lm.getMasuk())){
//          gotoMenuMahasiswa();  
//        }
//    }
//    public void gotoregistrasiAsisten(){
//        sa = new SignupAsisten();
//        sa.setVisible(true);
//        mu.dispose();
//    }
//    public void gotoregistrasiMahasiswa(){
//        sm = new SignupMahasiswa();
//        sm.setVisible(true);
//        mu.dispose();
//    }
//    }
    public void gotoMenuAsisten(){
        MenuAsisten x = new MenuAsisten();
        x.setVisible(true);
        x.addActionListener(this);
        view = x;
    }
//    public void gotoMenuMahasiswa(){
//        mm = new MenuMhs();
//        mm.setVisible(true);
//        la.dispose();
//    }
    
}

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
public class Main {
    public static void main(String[] args) {
        // TODO code application logic here
        //input from Asisten
        Orang A1= new Asisten("Dono","laki-laki",25,2);//create Asisten
        Asisten p1=(Asisten) A1;
        p1.setId(1301144242);
        p1.createTugasBesar("sistem igracias",5,5); // create Tugas besar from asisten
        p1.createTugasBesar("aplikasi inventaris",5,5);// create Tugas besar from asisten
        System.out.println("penambahan kahasiswa :");
        p1.tambahMahasiswa("sistem igracias","akhmad saifullah","laki-laki",20);//tambah mahasiswa from asisten
        p1.tambahMahasiswa("sistem igracias","dani","laki-laki",19);
        System.out.println();
     
        TugasBesar T1= new TugasBesar();
        T1=p1.getTugasBesar(0);
        TugasBesar T2= new TugasBesar();
        T2=p1.getTugasBesar(1);
        
        Orang o1= new Mahasiswa(null,null,0);
        o1=T1.getMahasiswa(0);
        Mahasiswa M1 =(Mahasiswa)o1;
        M1.setId(1301144242);
        System.out.println("hapus Mahasiswa judul "+p1.getTugasBesar(0).getJudul());
        p1.kurangMahasiswa("sistem igracias","akhmad saifullah",1301144242);//kurang mahasiswa
        
        System.out.println();
        System.out.println("Asisten: "+A1.getNama());
        System.out.println("judul: "+T1.getJudul());
        System.out.println("       "+T2.getJudul());
        System.out.println();
        System.out.println("Hapus data Mahasiswa nama akhmad saifullah di judul tubes :"+T1.getJudul());
        System.out.println("nama: "+M1.getNama());
        
        T1.createDokumentasi("sistem igracias part 1");//create dokumentasi
        T1.getDokumentasi(0).setTanggal(12);
        T1.getDokumentasi(0).setBulan(3);
        T1.getDokumentasi(0).setTahun(2016);
        T1.getDokumentasi(0).setIsi("ini tahap inisialisai semua atribut harus lengkap");
        
        System.out.println("Dokumentasi pada tanggal: "+T1.getDokumentasi(0).getTanggal()+"-"+T1.getDokumentasi(0).getBulan()+"-"+T1.getDokumentasi(0).getTahun());
        System.out.println("judul dokumentasi"+T1.getDokumentasi(0).getNamaDokumentasi());
        System.out.println("isi :"+T1.getDokumentasi(0).getIsi());
    }

}

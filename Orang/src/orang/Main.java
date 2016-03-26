/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orang;
import java.util.Scanner;
/**
 *
 * @author HP
 */
public class Main {
    // data cuman baru 1 asisten dengan nama ahmad dan password 1234
    Asisten[] a= new Asisten[10];
    Mahasiswa[] m = new Mahasiswa[20]; 
    Scanner scan4 =new Scanner(System.in);
    Scanner scan5 =new Scanner(System.in);
    public static void main(String[] args) {
        // TODO code application logic here
        //input from Asisten
        int l;
        String id;
        String pass;
        String nama;
        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        Scanner scan3 = new Scanner(System.in);
        System.out.println("Menu Login");
        System.out.println("1. Asisten");
        System.out.println("2. Mahasiswa");
        System.out.print("Pilihlah: ");
        l = scan1.nextInt();
        Main m = new Main();
        m.input();
        if(l==1){
            System.out.println("Login Asisten");
            System.out.print("Name: ");
            nama = scan2.nextLine();
            System.out.print("Pass: ");
            pass = scan3.nextLine();
            System.out.println();
            m.cekAsisten(nama,pass);
        }else if(l==2){
            System.out.println("Login Mahasiswa");
            System.out.print("Name: ");
            nama = scan2.nextLine();
            System.out.print("Pass: ");
            pass = scan3.nextLine();
        }else{
            System.out.println("Maaf tidak ada pilihan");
        }
    }
        public void input(){
      
        a[0]= new Asisten("ahmad","laki-laki",19,5);
        Asisten p1=(Asisten) a[0];        
        p1.setId(1301144242);
        p1.setPass("1234");
        p1.createTugasBesar("sistem igracias",5,5); // create Tugas besar from asisten
        p1.createTugasBesar("aplikasi inventaris",5,5);// create Tugas besar from asisten
        p1.tambahMahasiswa("sistem igracias","akhmad saifullah","laki-laki",20);//tambah mahasiswa from asisten
        p1.tambahMahasiswa("sistem igracias","dani","laki-laki",19);
        System.out.println();
        //input Mahasiswa
        m[0]= new Mahasiswa("habib","laki2",12);
        m[0].setId(1301144002);
        m[0].setPass("1234");
        }
    public void cekAsisten(String nama, String pass){
        int q=0;
        int b=0;
        boolean cek=false;
        do{ 
            if(a[q]!=null){
            if(nama.equals(a[q].getNama())){
                Asisten a1= (Asisten) a[q];
                if(a1.getPass().equals(pass)){    
                    b=q;
                    cek=true;
                }
            }
            }
            q++;
        }while(q<10);
        if(cek==true){
            menuAsisten(b);
        }else{
            System.out.println("maaf yang anda inputkan salah");
        }
    }
    public void menuAsisten(int i){
        int pil;
        System.out.print("Asisten ");
        Asisten a1= (Asisten) a[i];
        System.out.println(a[i].getNama()+" "+a1.getId());
        System.out.println("1.Tambah Judul tubes");
        System.out.println("2.Tambah Mahasiswa");
        System.out.println("3.kurangi Mahasiswa");
        System.out.println("Pilihlah : ");
        pil=scan4.nextInt();
        switch(pil){
            case 1:
                 tambahJudulTubes(i);
            break;
            case 2:
                TambahMahsiswa(i);
            break;
            case 3:
                KurangMahasiswa(i);
            break;    
            default:
                System.out.println("maaf pilihan tidak ada");
                menuAsisten(i);
            break;
        }
    }
    public void TambahMahsiswa(int i){
        String nama,jeniskel;
        int pil,nim,umur,numofMhs;
        Asisten a1= (Asisten) a[i];
        int p=0;
        int r=1;
        do{
            if(a1.getTugasBesar(p)!=null){
                System.out.println(r+". "+a1.getTugasBesar(p).getJudul());
            }
            p++;
            r++;
        }while(p<a1.getmaxTugasBesar());
        System.out.print("pilihlah: ");
        pil=scan4.nextInt();
        System.out.println();
        System.out.print("Nama :");
        nama = scan5.nextLine();
        System.out.print("Nim :");
        nim=scan4.nextInt();
        System.out.print("umur:");
        umur=scan4.nextInt();
        System.out.print("jenis kel:");
        jeniskel=scan5.nextLine();
        pil=pil-1;
        a1.tambahMahasiswa(a1.getTugasBesar(pil).getJudul(), nama, jeniskel, umur);
        numofMhs=a1.getTugasBesar(pil).getNumofMahasiswa()-1;
        a1.getTugasBesar(pil).getMahasiswa(numofMhs).setId(nim);
        if(a1.getTugasBesar(pil).getSucessAddMhs()==true){
            System.out.println("penambahan Mahasiswa berhasil");
        }else{
            System.out.println("penambahan Mahasiswa Gagal");           
        }
        System.out.println();
        menuAsisten(i);
    }
    public void tambahJudulTubes(int i){
        String judul;
        int maxofMahasiswa,maxofDokumentasi;
        Asisten a1= (Asisten) a[i];
        System.out.print("Judul Tubes: ");
        judul=scan5.nextLine();
        System.out.print("kuota Anggota: ");
        maxofMahasiswa=scan4.nextInt();
        System.out.print("kuota Dokumentasi :");
        maxofDokumentasi=scan4.nextInt();
        a1.createTugasBesar(judul,maxofMahasiswa,maxofDokumentasi);
        if(a1.getCekCreteTugasBesar()==true){
            System.out.println("Penambahan Judul Tugas Besar Berhasil");
        }else{
            System.out.println("Penambahan Judul Tugas Besar Gagal");
        }
        menuAsisten(i);
    }
    public void KurangMahasiswa(int i){
        String judul,nama;
        int pil,pil2,id;
        Asisten a1= (Asisten) a[i];
        int p=0;
        int r=1;
        do{
            if(a1.getTugasBesar(p)!=null){
                System.out.println(r+". "+a1.getTugasBesar(p).getJudul());
            }
            p++;
            r++;
        }while(p<a1.getmaxTugasBesar());
        System.out.print("pilihlah: ");
        pil=scan4.nextInt();
        pil=pil-1;
        p=0;
        r=1;
        do{
            if((a1.getTugasBesar(pil)!=null)&&(a1.getTugasBesar(pil).getMahasiswa(p).getNama()!=null)){
            System.out.println(r+". "+a1.getTugasBesar(pil).getMahasiswa(p).getNama());
            r++;
            p++;
            }
        }while(p==4);
        System.out.println("Pilihlah :");
        pil2=scan4.nextInt();
        pil2=pil2-1;
        System.out.print("Nim: ");
        id=scan4.nextInt();
        if((a1.getTugasBesar(pil)!=null)&&(a1.getTugasBesar(pil).getMahasiswa(pil2).getNama()!=null)){
            a1.kurangMahasiswa(a1.getTugasBesar(pil).getJudul(),a1.getTugasBesar(pil).getMahasiswa(pil2).getNama(),id);
            System.out.println("Pengurangan berhasil");
        }else{
            System.out.println("pengurangan Gagal");
        }
    }
    public void cekMahasiswa(String nama, String pass){
        int p=0,q=0,r=0;
        int t=0,l=0;
        int x,y,z;
        boolean cek = false;
        do{
            if(a[p]!=null){
                do{
                    if(a[p].getTugasBesar(q)!=null){                        
                        do{
                            if((a[p].getTugasBesar(q).getMahasiswa(r).getNama()!=null)&&a[p].getTugasBesar(q).getMahasiswa(r).getPass()!=null){
                                if(a[p].getTugasBesar(q).getMahasiswa(r).getNama().equals(nama)){
                                    if(a[p].getTugasBesar(q).getMahasiswa(r).getPass().equals(pass)){
                                        x=p; y=q; z=r; cek=true;
                                    }
                                }
                                l=a[p].getTugasBesar(q).getMaxMahasiswa();
                            }
                            t++;
                        }while(r<=l);
                        t=a[p].getmaxTugasBesar();
                    }
                    q++;
                }while(q<=t);
            }
            p++;
        }while(p<=10);
        p=0;
        if(cek!=true){
            do{
                if(m[p].getNama()!=null&&m[p].getPass()!=null){
                    if((m[p].getNama().equals(nama))&&(m[p].getPass().equals(pass))){
                        x=p; cek=false;
                    }
                }
            }while(p<10);    
        }
    }
    public void menuMahasiswa(int p,int q,int r, boolean cek){
        
    }
}

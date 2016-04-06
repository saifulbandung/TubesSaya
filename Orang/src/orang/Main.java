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
    
    Scanner scan2 = new Scanner(System.in);
    Scanner scan3 = new Scanner(System.in);
    Scanner scan4 =new Scanner(System.in);
    Scanner scan5 =new Scanner(System.in);
    
    public static void main(String[] args) {
        // TODO code application logic here
        //input from Asisten
        int l;
        String id;
        
        Main m = new Main();
        m.input();
        Scanner scan1 = new Scanner(System.in);
        System.out.println("Menu Login");
        System.out.println("1. Asisten");
        System.out.println("2. Mahasiswa");
        System.out.print("Pilihlah: ");
   //     try{
        l = scan1.nextInt();
       // m.show_all();
        m.show_Mahasiswa();
        m.menuLogin(l);
        
   // }catch(Exception e){System.out.println("inputan harus angka+++");}
    }
    public void menuLogin(int l){
        String pass;
        String nama;
        if(l==1){
            System.out.println("Login Asisten");
            System.out.print("Name: ");
            nama = scan2.nextLine();
            System.out.print("Pass: ");
            pass = scan3.nextLine();
            System.out.println();
            cekAsisten(nama,pass);
        }else if(l==2){
            System.out.println("Login Mahasiswa");
            System.out.print("Name: ");
            nama = scan2.nextLine();
            System.out.print("Pass: ");
            pass = scan3.nextLine();
            cekMahasiswa(nama,pass);
        }else{
            System.out.println("Maaf tidak ada pilihan");
        }
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
            menuLogin(1);      
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
        String c[] = new String[100];
        int pil,nim,umur,numofMhs;
        int p=0;
        int q=0;
        int r=1;
        while(a[q]!=null){
            if(a[q]!=null){
            do{
                if(a[q].getTugasBesar(p)!=null){
                    System.out.println(r+". "+a[q].getTugasBesar(p).getJudul());
                    c[r-1]=a[q].getTugasBesar(p).getJudul();
                r++;
                }
                p++;
            }while(p<a[q].getmaxTugasBesar());
            }
            p=0;
            q++;
        }
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
        p=0;
        q=0;
        while(a[q]!=null){
 //      for(q=0;q<2;q++){
            if(a[q]!=null){
                do{
                    if(a[q].getTugasBesar(p)!=null){
                        if(c[pil]==a[q].getTugasBesar(p).getJudul()){
                          a[q].tambahMahasiswa(c[pil], nama, jeniskel, nim);
                          numofMhs=a[q].getTugasBesar(p).getNumofMahasiswa()-1;
                          a[q].getTugasBesar(p).getMahasiswa(numofMhs).setUmur(umur);
                            System.out.println("Penambahan Mahasiswa Berhasil");
                        }
                    }
                    p++;
                }while(p<a[q].getmaxTugasBesar());
            }
            p=0;
            q++;
        }
        show_all();
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
        String c[]= new String[50];
        String n[]= new String [100];
        int pil,pil2,id;
        Asisten a1= (Asisten) a[i];
        int q=0;
        int p=0;
        int r=1;
        boolean cek=false;
        boolean cek1=false;
        System.out.println("Menu kurangi Mahasiswa");
        while(a[q]!=null){
            if(a[q]!=null){
            do{
                if(a[q].getTugasBesar(p)!=null){
                    System.out.println(r+". "+a[q].getTugasBesar(p).getJudul());
                    c[r-1]=a[q].getTugasBesar(p).getJudul();
                    cek=true;
                r++;
                }
                p++;
            }while(p<a[q].getmaxTugasBesar());
            }
            p=0;
            q++;
        }
        System.out.print("pilihlah tubes: ");
        pil=scan4.nextInt();
        pil=pil-1;
        p=0;
        q=0;
        r=0;
        int s=0;
        int t=0;
        if(c[pil]!=null){
            System.out.println("---Judul "+c[pil]+"---");
            System.out.println("Nama Mahasiswa:");
        }
        if(cek==false){
            System.out.println("maaf belum ada inputan judul tubes");
            menuAsisten(i);
        }
        while(a[q]!=null){
            if(a[q]!=null){
                do{
                    if(a[q].getTugasBesar(p)!=null){
                        if(c[pil]==a[q].getTugasBesar(p).getJudul()){
                          while(a[q].getTugasBesar(p).getMahasiswa(s)!=null){
                              System.out.println("              "+(t+1)+". "+a[q].getTugasBesar(p).getMahasiswa(s).getNama());
                              n[t]=a[q].getTugasBesar(p).getMahasiswa(s).getNama();
                              cek1=true;
                              t++;
                              s++;
                          }
                          s=0;
                        }
                    }
                    p++;
                }while(p<a[q].getmaxTugasBesar());
            }
            p=0;
            q++;
        }
        if(cek1==false){
            System.out.println("Maaf tidak ada mahasiswa yang terdaftar ");
            menuAsisten(i);
        }else{
            System.out.print("Pilihlah :");
            pil2=scan4.nextInt();
            System.out.println("masukan NIM mahasiswa: ");
            id=scan4.nextInt();
            pil2=pil2-1;
            p=0;
            q=0;
            s=0;
            cek1=false;
            while(a[q]!=null){
            if(a[q]!=null){
                do{
                    if(a[q].getTugasBesar(p)!=null){
                        if(c[pil]==a[q].getTugasBesar(p).getJudul()){
                          while(a[q].getTugasBesar(p).getMahasiswa(s)!=null){
                              if(n[pil2]==a[q].getTugasBesar(p).getMahasiswa(s).getNama()){                                 
                                  a[q].kurangMahasiswa(a[q].getTugasBesar(p).getJudul(),a[q].getTugasBesar(p).getMahasiswa(s).getNama(),id);
                                  cek1=true;
                              }
                              s++;
                          }
                          s=0;
                        }
                    }
                    p++;
                }while(p<a[q].getmaxTugasBesar());
            }
            p=0;
            q++;
        }
        show_all();
        if(cek1==false){
            System.out.println("Maaf pengurangan gagal");
        }
        menuAsisten(i);
        }
    /*    if((a1.getTugasBesar(pil)!=null)&&(a1.getTugasBesar(pil).getMahasiswa(pil2).getNama()!=null)){
            a1.kurangMahasiswa(a1.getTugasBesar(pil).getJudul(),a1.getTugasBesar(pil).getMahasiswa(pil2).getNama(),id);
            System.out.println("Pengurangan berhasil");
        }else{
            System.out.println("pengurangan Gagal");
        }*/
    }
    public void cekMahasiswaTerdaftar(String nama, String pass){
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
    public void cekMahasiswa(String nama,String pass){
        int q=0;
        int r=0;
        System.out.println("cekkkkkk");
        boolean cek=false;
        while(m[q]!=null){
            if(m[q].getNama().equals(nama)){
                if(m[q].getPass().equals(pass)){
                    r=q;
                    cek=true;
                }
            }
            q++;
        }
        if(cek==true){
            menuMahasiswa(r);
        }else{
            System.out.println("Maaf inputan anda salah");
            menuLogin(2);
        }
    }
    public void menuMahasiswa(int i){
        int pil;
        System.out.print("Menu Mahasiswa");  
        System.out.println(m[i].getNama()+" "+m[i].getId());
        System.out.println("1.Pilih tubes ");
        System.out.println("2.Lihat Tubes");
        System.out.println("3.Buat Dokumentasi");
        System.out.println("Pilihlah : ");
        pil=scan4.nextInt();
        switch(pil){
            case 1:
                
            break;
            case 2:
                
            break;
            case 3:
                
            break;    
            default:
                System.out.println("maaf pilihan tidak ada");
                menuAsisten(i);
            break;
        }
    }
    public void show_all(){
        int q=0;
        int p=0;
        int r=0;
        while(a[q]!=null){
            System.out.println("Asisten: "+a[q].getNama());
            while(a[q].getTugasBesar(p)!=null){
                System.out.println("    Crate Tubes : "+a[q].getTugasBesar(p).getJudul());
                while(a[q].getTugasBesar(p).getMahasiswa(r)!=null){
                    System.out.println("        Anggota :"+a[q].getTugasBesar(p).getMahasiswa(r).getNama());
                    r++;
                }
                r=0;
                p++;
            }
            p=0;
            q++;
        }
    }
    public void show_Mahasiswa(){
        int q=0;
        while(m[q]!=null){
            System.out.println("nama"+m[q].getNama());
            System.out.println("pass"+m[q].getPass());
            q++;
        }
    }
     public void input(){
      
        a[0]= new Asisten("ahmad","laki-laki",19,5);
        Asisten p1=(Asisten) a[0];        
        p1.setId(1301144242);
        p1.setPass("1234");
        p1.createTugasBesar("sistem igracias",5,5); // create Tugas besar from asisten
        p1.createTugasBesar("aplikasi inventaris",5,5);// create Tugas besar from asisten
        p1.tambahMahasiswa("sistem igracias","akhmad saifullah","laki-laki",1301144242);//tambah mahasiswa from asisten
        p1.tambahMahasiswa("sistem igracias","dani","laki-laki",1301144001);
        p1.tambahMahasiswa("aplikasi inventaris","aqli","laki-laki",1301144002);
        System.out.println();
        a[1]= new Asisten("aqli","laki-laki",19,5);
        Asisten p2=(Asisten) a[1];        
        p2.setId(1301144242);
        p2.setPass("1234");
        p2.createTugasBesar("sistem informasi",5,5); // create Tugas besar from asisten
        p2.createTugasBesar("aplikasi perpustakaan",5,5);// create Tugas besar from asisten
        p2.tambahMahasiswa("aplikasi perpustakaan","azizah","perempuan",1301144003);
        //input Mahasiswa
        m[0]= new Mahasiswa("habib","laki-laki",1301144001);
        m[0].setPass("1234");
        m[1]= new Mahasiswa("akhmad saifullah","laki-laki",1301144242);
        m[1].setPass("1234");
        m[2]= new Mahasiswa("dani","laki-laki",1301144002);
        m[2].setPass("1234");
        m[3]= new Mahasiswa("aqli","laki-laki",1301144003);
        m[3].setPass("1234");
        m[4]= new Mahasiswa("azizah","perempuan",1301144004);
        m[4].setPass("1234");
        m[5]= new Mahasiswa("dono","laki-laki",1301144005);
        m[5].setPass("1234");
        
        }
}
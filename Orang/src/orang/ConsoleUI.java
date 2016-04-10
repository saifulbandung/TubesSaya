/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orang;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author HP
 */
public class ConsoleUI {
    // data cuman baru 1 asisten dengan nama ahmad dan password 1234
    private int l;
    private int id;
    private String pass;
    private String nama;
    private int q,z;
    private int b;
    private int pil;
    private String jeniskel;
    private String c[];
    private int nim,umur,numofMhs;
    private int p;
    private int r;
    private String judul;
    private int maxofMahasiswa;
    private String n[];
    private int pil2;
    private boolean cek,cek1;
    private Date tanggal;
    private String namaDokumentasi;
    private String isi;
    private SimpleDateFormat ad;
    private Application app;
    private FileIO f;
    private int kuota;
    private boolean menua;
    private boolean menum;
   
    //Asisten[] a= new Asisten[10];
    //Mahasiswa[] m = new Mahasiswa[20];   
    Scanner scan2 = new Scanner(System.in);
    Scanner scan3 = new Scanner(System.in);
    Scanner scan4 =new Scanner(System.in);
    Scanner scan5 =new Scanner(System.in);
    Scanner scan1 = new Scanner(System.in);
    public ConsoleUI(Application app,FileIO f){
        this.app=app;
        this.f=f;
    }
    public void menuLog(){       
          input();
//        show_all(l);
   //     f.readFileAsisten();
   //     f.saveFileAsisten();
      //  show_Mahasiswa();
        System.out.println(app.getMahasiswa(0).getNama());
        while(true){
        try{  
        System.out.println("Menu ");
        System.out.println("1. Login Asisten");
        System.out.println("2. Login Mahasiswa");
        System.out.println("3. Registrasi Mahasiswa");
        System.out.println("4. Registrasi Asisten");
        System.out.println("5. exit");
        System.out.print("Pilihlah: ");
        l = scan1.nextInt();
        menuLogin(l);}catch(Exception e){ 
             System.out.println("inputan harus angka+++");
             scan1=new Scanner(System.in);
             scan2=new Scanner(System.in);
             scan3=new Scanner(System.in);
             scan4=new Scanner(System.in);
             scan5=new Scanner(System.in);
            }}
    }
    
    public void MenuRegistrasiAsisten(){
        System.out.println("");
        System.out.println("===Menu Registrasi Asisten===");
        System.out.print("Nama: ");
        nama=scan2.nextLine();
        System.out.print("NIM: ");
        id = scan1.nextInt();
        System.out.print("Jenis Kelamin: ");
        jeniskel = scan2.nextLine();
        System.out.print("kuota Tugas Besar: ");
        kuota = scan1.nextInt();
        System.out.print("umur: ");
        umur = scan1.nextInt();
        System.out.print("Password: ");
        pass = scan2.nextLine();
        app.addAsisten(nama, jeniskel, id, kuota);
        q=app.getnumofAsisten()-1;
        app.getAsisten(q).setUmur(umur);
        app.getAsisten(q).setPass(pass);
        app.getAsisten(q).setjenisKel(jeniskel);
        menuAsisten(q);
    }
    public void menuLogin(int l){
       switch(l){
           case 1:
            System.out.println("");
            System.out.println("Login Asisten");
            System.out.println(nama);
            System.out.print("Name: ");
            nama = scan2.nextLine();
            System.out.println(nama);
            System.out.println(pass);
            System.out.print("Pass: ");
            pass = scan3.nextLine();
            System.out.println(pass);
            System.out.println();
            cekAsisten(nama,pass);
        break;
        case 2:
            System.out.println("");
            System.out.println("Login Mahasiswa");
            System.out.print("Name: ");
            nama = scan2.nextLine();
            System.out.print("Pass: ");
            pass = scan3.nextLine();
            cekMahasiswa(nama,pass);
        break;
        case 3:
            menuRegistrasiMahasiswa();
        break;
        case 4:
            MenuRegistrasiAsisten();
        break;
        case 5:
            System.exit(0);
        break;
        default:
            System.out.println("Pilihan salah");
        break;    
        }
    }
       
    public void cekAsisten(String nama, String pass){
        q=0;
        b=0;
        cek=false;
        do{ 
            if(app.getAsisten(q)!=null){
            if(nama.equals(app.getAsisten(q).getNama())){
                Asisten a1= (Asisten) app.getAsisten(q);
                if(a1.getPass().equals(pass)){    
                    b=q;
                    cek=true;
                }
            }
            }
            q++;
        }while(q<=app.getnumofAsisten());
        if(cek==true){
            menuAsisten(b);
        }else{
            System.out.println("maaf yang anda inputkan salah");
            menuLogin(1);      
        }
    }
    public void menuAsisten(int i){  
        menua=true;
        while(menua){
        System.out.print("Asisten ");
        Asisten a1= (Asisten) app.getAsisten(i);
        System.out.println(app.getAsisten(i).getNama()+" "+a1.getId());
        System.out.println("1.Tambah Judul tubes");
        System.out.println("2.Tambah Mahasiswa");
        System.out.println("3.Kurangi Mahasiswa");
        System.out.println("4.Show seluruh tubes dan mahasiswa");
        System.out.println("5.Log out");
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
            case 4:
                show_all(i);
            break;
            case 5:
               menua=false;
            break;
            default:
                System.out.println("maaf pilihan tidak ada");
                menuAsisten(i);
            break;
        }
        }
    }
    public void TambahMahsiswa(int i){       
        c= new String[100];
        p=0;
        q=0;
        r=1;
        while(app.getAsisten(q)!=null){
            if(app.getAsisten(q)!=null){
            do{
                if(app.getAsisten(q).getTugasBesar(p)!=null){
                    System.out.println(r+". "+app.getAsisten(q).getTugasBesar(p).getJudul());
                    c[r-1]=app.getAsisten(q).getTugasBesar(p).getJudul();
                r++;
                }
                p++;
            }while(p<app.getAsisten(q).getmaxTugasBesar());
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
        while(app.getAsisten(q)!=null){
 //      for(q=0;q<2;q++){
            if(app.getAsisten(q)!=null){
                do{
                    if(app.getAsisten(q).getTugasBesar(p)!=null){
                        if(c[pil]==app.getAsisten(q).getTugasBesar(p).getJudul()){
                          app.getAsisten(q).tambahMahasiswa(c[pil], nama, jeniskel, nim);
                          numofMhs=app.getAsisten(q).getTugasBesar(p).getNumofMahasiswa()-1;
                          app.getAsisten(q).getTugasBesar(p).getMahasiswa(numofMhs).setUmur(umur);
                            System.out.println("Penambahan Mahasiswa Berhasil");
                        }
                    }
                    p++;
                }while(p<app.getAsisten(q).getmaxTugasBesar());
            }
            p=0;
            q++;
        }
        show_all(i);
        System.out.println();
    }
    public void tambahJudulTubes(int i){
        
        Asisten a1= (Asisten) app.getAsisten(i);
        System.out.print("Judul Tubes: ");
        judul=scan5.nextLine();
        System.out.print("kuota Anggota: ");
        maxofMahasiswa=scan4.nextInt();
        a1.createTugasBesar(judul,maxofMahasiswa);
        if(a1.getCekCreteTugasBesar()==true){
            System.out.println("Penambahan Judul Tugas Besar Berhasil");
        }else{
            System.out.println("Penambahan Judul Tugas Besar Gagal");
        }
    }
    public void KurangMahasiswa(int i){
        c= new String[50];
        n= new String [100];
        
        Asisten a1= (Asisten) app.getAsisten(i);
        q=0;
        p=0;
        r=1;
        cek=false;
        cek1=false;
        System.out.println("Menu kurangi Mahasiswa");
        while(app.getAsisten(q)!=null){
            if(app.getAsisten(q)!=null){
            do{
                if(app.getAsisten(q).getTugasBesar(p)!=null){
                    System.out.println(r+". "+app.getAsisten(q).getTugasBesar(p).getJudul());
                    c[r-1]=app.getAsisten(q).getTugasBesar(p).getJudul();
                    cek=true;
                r++;
                }
                p++;
            }while(p<app.getAsisten(q).getmaxTugasBesar());
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
        while(app.getAsisten(q)!=null){
            if(app.getAsisten(q)!=null){
                do{
                    if(app.getAsisten(q).getTugasBesar(p)!=null){
                        if(c[pil]==app.getAsisten(q).getTugasBesar(p).getJudul()){
                          while(app.getAsisten(q).getTugasBesar(p).getMahasiswa(s)!=null){
                              System.out.println("              "+(t+1)+". "+app.getAsisten(q).getTugasBesar(p).getMahasiswa(s).getNama());
                              n[t]=app.getAsisten(q).getTugasBesar(p).getMahasiswa(s).getNama();
                              cek1=true;
                              t++;
                              s++;
                          }
                          s=0;
                        }
                    }
                    p++;
                }while(p<app.getAsisten(q).getmaxTugasBesar());
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
            while(app.getAsisten(q)!=null){
            if(app.getAsisten(q)!=null){
                do{
                    if(app.getAsisten(q).getTugasBesar(p)!=null){
                        if(c[pil]==app.getAsisten(q).getTugasBesar(p).getJudul()){
                          while(app.getAsisten(q).getTugasBesar(p).getMahasiswa(s)!=null){
                              if(n[pil2]==app.getAsisten(q).getTugasBesar(p).getMahasiswa(s).getNama()){                                 
                                  app.getAsisten(q).kurangMahasiswa(app.getAsisten(q).getTugasBesar(p).getJudul(),app.getAsisten(q).getTugasBesar(p).getMahasiswa(s).getNama(),id);
                                  cek1=true;
                              }
                              s++;
                          }
                          s=0;
                        }
                    }
                    p++;
                }while(p<app.getAsisten(q).getmaxTugasBesar());
            }
            p=0;
            q++;
        }
        show_all(i);
        if(cek1==false){
            System.out.println("Maaf pengurangan gagal");
        }
        }
    }
    public boolean cekMahasiswaTerdaftar(String nama, int id){
        int z=0;
        q=0;
        p=0;
        r=0;
        cek=false;
        while(app.getAsisten(q)!=null){
            while(app.getAsisten(q).getTugasBesar(p)!=null){
                while(app.getAsisten(q).getTugasBesar(p).getMahasiswa(r)!=null){
                    if((app.getAsisten(q).getTugasBesar(p).getMahasiswa(r).getNama()==nama)&&(app.getAsisten(q).getTugasBesar(p).getMahasiswa(r).getId()==id)){
                        cek=true;
                        System.out.println("Sudah Terdaftar : ");
                        System.out.println(app.getAsisten(q).getTugasBesar(p).getJudul());
                        System.out.println("Asisten "+app.getAsisten(q).getNama());
                        System.out.println("Anggota");
                        while(app.getAsisten(q).getTugasBesar(p).getMahasiswa(z)!=null){
                            System.out.println(z+1+". " +app.getAsisten(q).getTugasBesar(p).getMahasiswa(z).getNama());
                            z++;
                        }
                    }
                    r++;
                }
                r=0;
                p++;
            }
            p=0;
            q++;
        }
        return cek;
    }
    public void cekMahasiswa(String nama,String pass){
        q=0;
        r=0;
        cek=false;
        while(app.getMahasiswa(q)!=null){
            if(app.getMahasiswa(q).getNama().equals(nama)){
                if(app.getMahasiswa(q).getPass().equals(pass)){
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
        menum=true;
        while(menum){
        System.out.println("");
        System.out.println("---Menu Mahasiswa---");  
        System.out.println(app.getMahasiswa(i).getNama()+" "+app.getMahasiswa(i).getId());
        System.out.println("1.Pilih tubes ");
        System.out.println("2.Lihat Tubes");
        System.out.println("3.Buat Dokumentasi");
        System.out.println("4.Show Dokumentasi");
        System.out.println("5.Logout");
        System.out.println("Pilihlah : ");
        pil=scan4.nextInt();
        switch(pil){
            case 1:
                pilih_tubes(i);
            break;
            case 2:
                lihat_tugasbesar(i);
            break;
            case 3:
                create_dokumentasi(i);
            break;
            case 4:
                show_dokumentasi(i);
            break;
            case 5:
               menum=false;
            break;
            default:
                System.out.println("Pilihan salah");
            break;
        }}
    }
    public void show_all(int i){
        q=0;
        p=0;
        r=0;
        while(app.getAsisten(q)!=null){
            System.out.println("Asisten: "+app.getAsisten(q).getNama());
            while(app.getAsisten(q).getTugasBesar(p)!=null){
                System.out.println("    Crate Tubes : "+app.getAsisten(q).getTugasBesar(p).getJudul());
                while(app.getAsisten(q).getTugasBesar(p).getMahasiswa(r)!=null){
                    System.out.println("        Anggota : "+app.getAsisten(q).getTugasBesar(p).getMahasiswa(r).getNama()+" "+app.getAsisten(q).getTugasBesar(p).getMahasiswa(r).getId());
                    System.out.println("        Umur    : "+app.getAsisten(q).getTugasBesar(p).getMahasiswa(r).getUmur());
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
        q=0;
        while(app.getMahasiswa(q)!=null){//***********
            System.out.println("nama"+app.getMahasiswa(q).getNama());
            System.out.println("pass"+app.getMahasiswa(q).getPass());
            q++;
        }
    }
    public void pilih_tubes(int i){
        System.out.println("");      
        c = new String[100];        
        p=0;
        q=0;
        r=1;
        z=0;
        if(cekMahasiswaTerdaftar(app.getMahasiswa(i).getNama(),app.getMahasiswa(i).getId())==false){
            System.out.println("pilhan judul tubes");
            while(app.getAsisten(q)!=null){               
                do{
                    if(app.getAsisten(q).getTugasBesar(p)!=null){
                        System.out.println(r+". "+app.getAsisten(q).getTugasBesar(p).getJudul());
                        System.out.println("    Asprak: "+app.getAsisten(q).getNama());
                        c[r-1]=app.getAsisten(q).getTugasBesar(p).getJudul();
                    r++;
                    }
                    p++;
                }while(p<app.getAsisten(q).getmaxTugasBesar());               
                p=0;
                q++;
            }
            System.out.print("pilihlah: ");
            pil=scan4.nextInt();
            pil=pil-1;
        p=0;
        q=0;
        while(app.getAsisten(q)!=null){
            if(app.getAsisten(q)!=null){
                do{
                    if(app.getAsisten(q).getTugasBesar(p)!=null){
                        if(c[pil]==app.getAsisten(q).getTugasBesar(p).getJudul()){
                          app.getAsisten(q).tambahMahasiswa(c[pil],app.getMahasiswa(i).getNama(),app.getMahasiswa(i).getjenisKel(),app.getMahasiswa(i).getId());
                          numofMhs=app.getAsisten(q).getTugasBesar(p).getNumofMahasiswa()-1;
                          app.getAsisten(q).getTugasBesar(p).getMahasiswa(numofMhs).setUmur(app.getMahasiswa(i).getUmur());
                            System.out.println("");
                            System.out.println("terdaftar di: ");
                            System.out.println("Judul "+app.getAsisten(q).getTugasBesar(p).getJudul());
                            System.out.println("Asisten "+app.getAsisten(q).getNama());
                            System.out.println("Anggota ");
                            while(app.getAsisten(q).getTugasBesar(p).getMahasiswa(z)!=null){
                                System.out.println(z+1+". " +app.getAsisten(q).getTugasBesar(p).getMahasiswa(z).getNama());
                                z++;
                            }
                        }
                    }
                    p++;
                }while(p<app.getAsisten(q).getmaxTugasBesar());
            }
            p=0;
            q++;
        }
        }
    }
    public void lihat_tugasbesar(int i){
        System.out.println("");
        if(cekMahasiswaTerdaftar(app.getMahasiswa(i).getNama(), app.getMahasiswa(i).getId())==false){
            System.out.println("Maaf Anda belum memilih Tugas Besar");
        }
    }
    public void create_dokumentasi(int i){  
        tanggal = new Date();
        z=0;
        q=0;
        p=0;
        r=0;
        cek=false;
        ad= new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("");
        System.out.println("---Menu dokumentasi---");
        while(app.getAsisten(q)!=null){
            while(app.getAsisten(q).getTugasBesar(p)!=null){
                while(app.getAsisten(q).getTugasBesar(p).getMahasiswa(r)!=null){
                    if((app.getAsisten(q).getTugasBesar(p).getMahasiswa(r).getNama()==app.getMahasiswa(i).getNama())&&(app.getAsisten(q).getTugasBesar(p).getMahasiswa(r).getId()==app.getMahasiswa(i).getId())){
                   
                        cek=true;
                        System.out.print("nama dokumentasi: ");
                        namaDokumentasi = scan2.nextLine();
                        System.out.println("tanggal tgl-bln-th: "+(ad.format(tanggal)));
                        System.out.print("isi: ");
                        isi = scan3.nextLine();
                        app.getAsisten(q).getTugasBesar(p).createDokumentasi(namaDokumentasi, tanggal, isi);
                        
                    }
                    r++;
                }
                r=0;
                p++;
            }
            p=0;
            q++;
        }
        if(cek==false){
            System.out.println("Maaf anda belum terdaftar di Tugas Besar");
        }
    }
    public void show_dokumentasi(int i){
        z=0;
        q=0;
        p=0;
        r=0;
        while(app.getAsisten(q)!=null){
            while(app.getAsisten(q).getTugasBesar(p)!=null){
                while(app.getAsisten(q).getTugasBesar(p).getMahasiswa(r)!=null){
                    if((app.getAsisten(q).getTugasBesar(p).getMahasiswa(r).getNama()==app.getMahasiswa(i).getNama())&&(app.getAsisten(q).getTugasBesar(p).getMahasiswa(r).getId()==app.getMahasiswa(i).getId())){
                   
                        while(app.getAsisten(q).getTugasBesar(p).getDokumentasi(z)!=null){
                            System.out.println("===dokumentasi: "+app.getAsisten(q).getTugasBesar(p).getDokumentasi(z).getNamaDokumentasi()+"===");
                            System.out.println("Tanggal: "+ad.format(app.getAsisten(q).getTugasBesar(p).getDokumentasi(z).getTanggal()));
                            System.out.println("Isi: "+app.getAsisten(q).getTugasBesar(p).getDokumentasi(z).getIsi());
                            z++;
                        }
                    }
                    r++;
                    
                }
                r=0;
                p++;
            }
            p=0;
            q++;
        }
        if(cek==false){
            System.out.println("Maaf anda belum terdaftar di Tugas Besar");
        }
    }
    public void menuRegistrasiMahasiswa(){
        System.out.println("===Registrasi Mahasiswa===");
        System.out.print("Nama : ");
        nama = scan2.nextLine();
        System.out.print("NIM: ");
        id = scan1.nextInt();
        System.out.print("Jenis kelamin: ");
        jeniskel = scan2.nextLine();
        System.out.print("Umur: ");
        umur = scan1.nextInt();
        System.out.print("Password: ");
        pass = scan2.nextLine();
        app.addMahasiswa(nama, jeniskel, id);
        int i=app.getnumofMahasiswa()-1;
        app.getMahasiswa(i).setUmur(umur);
        app.getMahasiswa(i).setPass(pass);
    }
     public void input(){
      
        app.addAsisten("ahmad","laki-laki",19,5);
        Asisten p1=(Asisten) app.getAsisten(0);        
        p1.setId(1301144242);
        p1.setPass("1234");
        p1.createTugasBesar("sistem igracias",5); // create Tugas besar from asisten
        p1.createTugasBesar("aplikasi inventaris",5);// create Tugas besar from asisten
        p1.tambahMahasiswa("sistem igracias","akhmad saifullah","laki-laki",1301144242);//tambah mahasiswa from asisten
        p1.getTugasBesar(0).getMahasiswa(0).setUmur(20);
        p1.tambahMahasiswa("sistem igracias","dani","laki-laki",1301144002);
        p1.getTugasBesar(0).getMahasiswa(1).setUmur(19);
        p1.tambahMahasiswa("aplikasi inventaris","aqli","laki-laki",1301144003);
        p1.getTugasBesar(1).getMahasiswa(0).setUmur(15);
        System.out.println();
        app.addAsisten("Fatimah","perempuan",19,5);
        Asisten p2=(Asisten) app.getAsisten(1);        
        p2.setId(1301144242);
        p2.setPass("1234");
        p2.createTugasBesar("sistem informasi",5); // create Tugas besar from asisten
        p2.createTugasBesar("aplikasi perpustakaan",5);// create Tugas besar from asisten
        p2.tambahMahasiswa("aplikasi perpustakaan","azizah","perempuan",1301144004);
        p2.getTugasBesar(1).getMahasiswa(0).setUmur(18);
        //input Mahasiswa
        app.addMahasiswa("habib","laki-laki",1301144001);
        app.getMahasiswa(0).setPass("1234");
        app.addMahasiswa("akhmad saifullah","laki-laki",1301144242);
        app.getMahasiswa(1).setPass("1234");
        app.addMahasiswa("dani","laki-laki",1301144002);
        app.getMahasiswa(2).setPass("1234");
        app.addMahasiswa("aqli","laki-laki",1301144003);
        app.getMahasiswa(3).setPass("1234");
        app.addMahasiswa("azizah","perempuan",1301144004);
        app.getMahasiswa(4).setPass("1234");
        app.addMahasiswa("dono","laki-laki",1301144005);
        app.getMahasiswa(5).setPass("1234");          
        }
}
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
public class Asisten extends Orang{
    private TugasBesar [] tugasbesar;
    private int numofTugasBesar;
    private String pass;
    private int id;
    private int maxTugasBesar;
    private boolean cekCreateTugasBesar=false;
    
    public Asisten(String nama,String jenisKel, int id,int maxTugasBesar){
        super(nama,jenisKel);
        this.id=id;
        this.maxTugasBesar=maxTugasBesar;
        tugasbesar= new TugasBesar[maxTugasBesar];
    }
    public void createTugasBesar(String judul,int maxMahasiswa){
        
        if(numofTugasBesar<maxTugasBesar){
        tugasbesar[numofTugasBesar]= new TugasBesar(judul,maxMahasiswa);
       // tugasbesar[numofTugasBesar].setJudul(judul);
        numofTugasBesar++;
        cekCreateTugasBesar=true;
        }else{
            System.out.println("maaf anda hanya bisa mengajukan "+maxTugasBesar+"judul anda telah memnuhi kuota");
            cekCreateTugasBesar=false;
        }
    }
    
    public void tambahMahasiswa(String judul, String nama, String jenisKel, int id){
        int i;
        for(i=0;i<maxTugasBesar;i++){ 
            if(tugasbesar[i]!=null){
            if(tugasbesar[i].getJudul().equals(judul)){
                tugasbesar[i].addMember(nama, jenisKel, id);
               // System.out.println("tambah Mahasiswa berhasil");
            }
            }
        }
    }    
    public void kurangMahasiswa(String judul,String nama,int id){
        int i;
        boolean cek=false;
        for(i=0;i<numofTugasBesar;i++){
            if(tugasbesar[i].getJudul()==judul){
               int x;
                for(x=0;x<tugasbesar[i].getNumofMahasiswa();x++){
                    if(tugasbesar[i].getMahasiswa(x).getNama()==nama){
                        if(tugasbesar[i].getMahasiswa(x).getId()==id){
                            System.out.println("Nama :"+tugasbesar[i].getMahasiswa(x).getNama());
                            tugasbesar[i].hapusMahasiswa(x);
                            cek=true;
                            System.out.println(" data telah terhapus ");
                        }
                    }
                }
            }
        }
        if(cek==false){
            System.out.println("Data Gagal Dihapus NIM salah");
        }
    }
    public void setId(int id){
        this.id=id;
    }
    public int getId(){
         return id;
    }
    public void setPass(String pass){
    this.pass=pass;
    }
    public String getPass(){
        return pass;
    }
    public int getnumTugasBesar(){
        return numofTugasBesar;
    }
    public TugasBesar getTugasBesar(int q){
        return tugasbesar[q];
    }
    public void setmaxTugasBesar(int maxTugasBesar){
        this.maxTugasBesar=maxTugasBesar;
    }
    public int getmaxTugasBesar(){
        return maxTugasBesar;
    }
    public boolean getCekCreteTugasBesar(){
        return cekCreateTugasBesar;
    }
    public String getnama(){
        return super.getNama();
    }
}

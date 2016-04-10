/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.Serializable;
/**
 *
 * @author HP
 */
public class NewEntity implements Serializable {
    private String address;
    private String nama;
    private int age;
    
    public NewEntity(String nama,String address,int age){
    this.nama=nama;
    this.address=address;
    this.age=age;
    }
    public String getAdress() {
        return address;
    }
    public void setAdress(String address) {
        this.address = address;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String toString() {
        return "NewEntity{" + "address=" + address + ",Nama =" + nama + ", age=" + age + '}';
    }
}

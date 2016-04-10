/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author HP
 */
public class Person {
private String address;
    private String nama;
    private int age;

    public static void main(String[] args) {
        // TODO code application logic here
    }
    public Person(String nama,String address,int age){
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
    
}

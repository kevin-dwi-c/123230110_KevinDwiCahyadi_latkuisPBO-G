/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package latkuis;

public class Mahasiswa {
    private String nama;
    private String nim;
    private double nilaiTugas;
    private double nilaiQuiz;
    private String kelas;
    private String mataKuliah;
    
    public Mahasiswa(String nama, String nim, double nilaiTugas, double nilaiQuiz, String kelas, String mataKuliah){
        this.nama = nama;
        this.nim = nim;
        this.nilaiTugas = nilaiTugas;
        this.nilaiQuiz = nilaiQuiz;
        this.kelas = kelas;
        this.mataKuliah = mataKuliah;
    }
    
    double getTotalNilai(){
        if(kelas.equals("Teori")){ // untuk bandingin string harus pake .equals, kalau pake == yang dibandingin memori ny bukan isi string nya
            return (0.7 * nilaiTugas) + (0.3* nilaiQuiz);
        }else{
            return (0.7 * nilaiQuiz) + (0.3* nilaiTugas);
        }
    }
    
    public String getHasil(){
        if(getTotalNilai() <= 85){
            return "NOT PASS";
        }else{
            return "PASS";
        }
    }
    
    public String getInfo(){
        return  "Nama: " + nama + "\n" +
                "NIM: " + nim + "\n" +
                "Tipe Kelas: " + kelas + "\n" +
                "Mata Kuliah: " + mataKuliah + "\n" +
                "Hasil: " + getHasil() + "\n" +
                "Total Nilai: " + getTotalNilai();
    }
}

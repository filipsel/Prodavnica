import java.sql.SQLOutput;
import java.util.Scanner;

public class Artikal {
    String ime;
    double cena;
    int kolicina;
    double porez = 1.20;

    public Artikal() {}

    public Artikal(String ime, double cena, int kolicina){
        this.ime = ime;
        this.cena = cena;
        this.kolicina = kolicina;

    }
    public String getIme() {return this.ime;}
    public void setIme(String ime) {
        this.ime = ime;
    }
    public double getCena() {
        return this.cena;
    }
    public void setCena(double cena) {
        this.cena = cena;
    }
    public int getKolicina() {
        return this.kolicina;
    }
    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }
    public double getPorez() {
        return this.porez;
    }
    public void setPorez(int porez) {
        this.porez = porez;
    }


    public void stampajArtikal(){
        System.out.println("Uneli ste: " + this.getIme() + "\nCena: " + this.getCena() + "\nKolicina: " + this.getKolicina() + "\nUkupno : " + this.izracunajUkupnuCenuZaArtikal() + " dinara");
    }

    public double izracunajUkupnuCenuZaArtikal() {return (this.getKolicina() * this.getCena()) * this.getPorez();}

    }


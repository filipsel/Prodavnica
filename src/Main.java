import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); //"Scanner scanner = new Scanner(System.in)" ovo je metoda

        System.out.println("Unesite broj artikala: ");
        int brojArtikala = scanner.nextInt();
        Artikal[] nizArtikala = new Artikal[brojArtikala];
        for (int i = 0; i < nizArtikala.length; i++) {
            System.out.println("Unesite zeljeni proizvod:");
            String ime = scanner.next();
            System.out.println("Unesite cenu proizvoda:");
            double cena = scanner.nextDouble();
            System.out.println("Unesite kolicinu proizvoda:");
            int kolicina = scanner.nextInt();

            Artikal artikal = new Artikal(ime, cena, kolicina);
            nizArtikala[i] = artikal;
        }
        istampajRacun((nizArtikala));
    }

    public static <niz, max> void istampajRacun(Artikal[] niz) {
        double konacanZbir = 0;
        double maxCena = 0; //"maxCena = 0" ovo je konstruktor
        double maxUkupno = 0;
        for (int i = 0; i < niz.length; i++) {
            Artikal artikal = niz[i];
            double ukupnaCena = artikal.izracunajUkupnuCenuZaArtikal();
            konacanZbir += ukupnaCena;
            artikal.stampajArtikal();
            if (artikal.cena > maxCena) {
                maxCena = artikal.cena;
            }
            if (artikal.cena * artikal.kolicina * artikal.porez > maxUkupno) {
                maxUkupno = artikal.cena * artikal.kolicina * artikal.porez;
            }
        }
        System.out.println("Za uplatu: " + konacanZbir + " dinara");
        System.out.println("Najveca cena artikla je " + maxCena + " dinara");
        System.out.println("Najveca ukupna cena artikla je " + maxUkupno + " dinara");
    }
}
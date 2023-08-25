import javax.swing.*;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Zgadywanka extends JFrame {

    public Zgadywanka(){
        JLabel lZakres, lLiczbaProb;
        setSize(400,200);
        setTitle("Zgaduj zgadula");
        setLayout(null);

        lZakres = new JLabel("Podaj zakres od 0 do....");
        lZakres.setBounds(50,50,100,20);
        add(lZakres);
        lLiczbaProb = new JLabel("Podaj liczbę prób");
        lLiczbaProb.setBounds(50,80,100,20);
        add(lLiczbaProb);

    }

    public static void main(String[] args) {

        Zgadywanka zgadywanka = new Zgadywanka();
        zgadywanka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        zgadywanka.setVisible(true);

        Scanner scanner = new Scanner(System.in);
        boolean poprawnaLiczba = false;
        int zmienna;
        System.out.println("Podaj liczbę definiującą koniec zakresu losowanych liczb");
        int zakres = scanner.nextInt();
        Random random = new Random();
        int liczba = random.nextInt(zakres);


        System.out.println("Podaj ile prób chcesz maksymalnie wykonać");
        int liczbaProb = scanner.nextInt();


        for (int i = 0; i < liczbaProb; i++) {
            try {
            if (i==0)
            {
                System.out.println("Podaj pierwszą liczbę z zakresu 0-" + zakres + " który wybrałeś \n Masz na to jeszcze " + (liczbaProb - i) + " prób.");
            } else
            {
                System.out.println("Podaj kolejną liczbę z zakresu 0-" + zakres + " który wybrałeś \n Masz na to jeszcze " + (liczbaProb - i) + " prób.");
            }
            zmienna = scanner.nextInt();
            if (liczba == zmienna) {
                    System.out.println("Brawo! Liczba podana przez Ciebie: " + zmienna + " jest taka sama jak wylosowana przeze mnie liczba: " + liczba);
                    System.out.println("Odgadłeś liczbę po: " + i + " nieudanych próbach \n czyli za " + (i + 1) + " razem");
                    poprawnaLiczba = true;
                    break;
                } else if (liczba > zmienna) {
                    System.out.println("Twoja liczba " + zmienna + "ma za niską wartość");
                } else {
                    System.out.println("Twoja liczba " + zmienna + " ma za wysoką wartość");
                }
            } catch (InputMismatchException e) {
                System.out.println("Błąd: Niepoprawny format danych. Wprowadź poprawną liczbę.");
                scanner.nextLine(); // Konsumujemy błąd wejścia, aby uniknąć nieskończonej pętli
            }
        }
        if (!poprawnaLiczba) {
            System.out.println("Niestety, nie udało się odgadnąć liczby w ustalonych 100 próbach. Wylosowana liczba to: " + liczba);
        }
    }
}
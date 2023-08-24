import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int liczba = random.nextInt(100);
        // System.out.println("wylosowana liczba to: " + liczba);
        Scanner scanner = new Scanner(System.in);
        boolean poprawnaLiczba = false;

        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("Podaj liczbę z zakresu 0-100 którą wylosowałem \n Masz na to jeszcze " + (10 - i) + " prób.");
                int zmienna = scanner.nextInt();
                if (liczba == zmienna) {
                    System.out.println("Brawo! Liczba podana przez Ciebie: " + zmienna + " jest taka sama jak wylosowana przeze mnie liczba: " + liczba);
                    System.out.println("Odgadłeś liczbę po: " + i + " próbach \n czyli za " + (i + 1) + " razem");
                    poprawnaLiczba = true;
                    break;
                } else if (liczba > zmienna) {
                    System.out.println("Twoja liczba ma za niską wartość");
                } else {
                    System.out.println("Twoja liczba ma za wysoką wartość");
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
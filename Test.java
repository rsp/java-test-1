public class Test {

    static int numer = 0;
    static boolean ok = true;

    static void test(int[] tablica, int oczekiwana) {

        int suma = Sumator.sumuj(tablica);

        if (suma == oczekiwana) {
            System.out.println(++numer + " OK");
        } else {
            System.out.println(++numer + " ERROR!!!");
            ok = false;
        }

    }

    public static void main(String[] args) {

        int[][] t = {
            {0, 1, 2, 3},
            {1, 2, 3},
            {0, 5, -10},
        };

        test(t[0], 6);
        test(t[1], 6);
        test(t[2], -5);

        if (ok) {
            System.out.println("Wszystkie testy powiodly sie");
        } else {
            System.out.println("Niektore testy nie powiodly sie!");
            System.exit(1);
        }

    }

}

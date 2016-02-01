public class Sumator {

    public static int sumuj(int[] tablica) {

        int suma = 0;
        for (int i = 1; i < tablica.length; i++)
            suma += tablica[i];
        return suma;

    }

    public static void main(String[] args) {

        int[] t = {0, 1, 2, 3};

        int s = Sumator.sumuj(t);

        System.out.println(s);

    }

}

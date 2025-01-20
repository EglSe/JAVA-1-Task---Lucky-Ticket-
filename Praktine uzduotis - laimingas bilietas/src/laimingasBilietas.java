import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;



public class laimingasBilietas {

    //metodas tikrina ar bilietas laimingas

    public static boolean arBilietasLaimingas(String bilietoNumeris) {
         if (bilietoNumeris.length() !=6){ //ar bilieto nr yra is 6 skaitmenu
             return false;
         }

        int pirmaDalisSum = Character.getNumericValue(bilietoNumeris.charAt(0)) +
                Character.getNumericValue(bilietoNumeris.charAt(1)) +
                Character.getNumericValue(bilietoNumeris.charAt(2));
        int antraDalisSum = Character.getNumericValue(bilietoNumeris.charAt(3)) +
                Character.getNumericValue(bilietoNumeris.charAt(4)) +
                Character.getNumericValue(bilietoNumeris.charAt(5));

        //ar skaitmenys unikalus
        Set<Character> digitsSet = new HashSet<>();
        for (char digit : bilietoNumeris.toCharArray()) {
            digitsSet.add(digit);
        }

        // bilietas  laimingas jei abieju daliu suma vienoda ir visi skaiciai yra skirtingi

        return pirmaDalisSum == antraDalisSum && digitsSet.size() == 6;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Įveskite šešiaženklį skaičių: ");
        String pradinisBilietas = scanner.nextLine();

        if (pradinisBilietas.matches("\\d{6}") && pradinisBilietas.chars().mapToObj(c -> (char) c).distinct().count() != 6)  {   // \\d{6} - sesi skaiciai is eiles
            System.out.println("Bilieto numeris turi būti šešiaženklis skaičius iš skirtingų nepasikartojančių skaitmenų.");           //jei bilieto nr ne 6 sk, ne skirtingi sk, gaunu sia zinute
            return;
        }

        System.out.println("Tikrinamas pradinio bilieto numeris: " + pradinisBilietas);

        int bandymai = 0;
        int bilietoNumeris = Integer.parseInt(pradinisBilietas);

        // Generuojame bilietus kol randame laiminga bilieta

        while (true) {
            bandymai++;
            String tikrinamasBilietas = String.format("%06d", bilietoNumeris);

            if (arBilietasLaimingas(tikrinamasBilietas)) {
                System.out.println("Laimingas bilietas yra: " + tikrinamasBilietas);
                System.out.println("Bandymų skaičius: " + bandymai);
                break;
            }
            bilietoNumeris++;
        }

        scanner.close();
    }
}

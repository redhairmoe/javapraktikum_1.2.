package iterationsverfahren2;

import java.util.Scanner;

/**
 * @author Esther
 */
class Polynom {

    private double[] polynom;
    Polynom(){
    	polynomEingabe();
    }
    Polynom(double[] polynom) {
        this.polynom = polynom;
    }

    Polynom leiteAb() {
        double[] koeffizientenarrayAbleitung = new double[polynom.length - 1];

        for (int i = 0; i < koeffizientenarrayAbleitung.length; i++) {
            koeffizientenarrayAbleitung[i] = polynom[i + 1] * (i + 1);
        }

        return new Polynom(koeffizientenarrayAbleitung);
    }

    double[] getKoeffizienten() {
        return polynom;
    }

    public void polynomEingabe() {
    	Scanner scanner = new Scanner(System.in);
        System.out.println("Geben Sie den Grad des Polynoms ein.");
        System.out.println("Nur Eingaben groesser 0 werden akzeptiert.");
        int grad = scanner.nextInt();
        System.out.println("Der Grad des Polynoms ist " + grad + ".");
        System.out.println("Es sind " + (grad + 1) + " Koeffizienten einzugeben beginnend mit dem Hoechsten.\n");

        double[] koeffizientenarray = new double[grad + 1];

        for (int i = koeffizientenarray.length - 1; i >= 0; i--) {
            System.out.println("Geben Sie den " + (koeffizientenarray.length - i) + ". Koeffizienten ein.");
            koeffizientenarray[i] = scanner.nextDouble();
        }

        this.polynom = koeffizientenarray;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = polynom.length - 1; i >= 0; i--) {
            sb.append(polynom[i]);
            sb.append("x^");
            sb.append(i);

            if (i > 0) {
                sb.append(" + ");
            }
        }

        return sb.toString();
    }
}


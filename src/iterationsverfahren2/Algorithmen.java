package iterationsverfahren2;

/**
 * @author Esther
 */
public class Algorithmen {

    static double horner(Polynom polynom, double argument) {
        double[] koeffizienten = polynom.getKoeffizienten();
        double ausgabe = koeffizienten[koeffizienten.length - 1];

        for (int i = koeffizienten.length - 2; i >= 0; i--) {
            ausgabe = (ausgabe * argument) + koeffizienten[i];
        }

        return ausgabe;
    }

    static double[] newton(Polynom polynom, Polynom ableitung, double x0, double epsilon) {
        int iterationen = 0;
        double alt = x0;
        double neu = alt - horner(polynom, alt) / horner(ableitung, alt);

        while (Math.abs(horner(polynom, neu)) > epsilon) {
            iterationen++;
            alt = neu;
            neu = alt - horner(polynom, alt) / horner(ableitung, alt);

            if (iterationen == 1000) {
                System.out.println("Abbruch nach " + iterationen + " Iterationen.");
                break;
            }
        }

        return new double[]{neu, iterationen};
    }

    static double[] regulaFalsi(Polynom polynom, double x0, double x1, double epsilon) {
        if (Math.signum(x0) == Math.signum(x1)) {
            throw new IllegalArgumentException("Falsche Eingabe: Vorzeichen duerfen nicht gleich sein.");
        }

        int iterationen = 0;
        double sehrAlt = x0;
        double alt = x1;
        double neu = sehrAlt - ((alt - sehrAlt) / (horner(polynom, alt) - horner(polynom, sehrAlt))) * horner(polynom, sehrAlt);

        if (Math.signum(horner(polynom, neu)) == Math.signum(horner(polynom, alt))) {
            alt = sehrAlt;
        }

        while (Math.abs(horner(polynom, neu)) > epsilon) {
            iterationen++;
            sehrAlt = alt;
            alt = neu;
            neu = sehrAlt - ((alt - sehrAlt) / (horner(polynom, alt) - horner(polynom, sehrAlt))) * horner(polynom, sehrAlt);

            if (Math.signum(horner(polynom, neu)) == Math.signum(horner(polynom, alt))) {
                alt = sehrAlt;
            }

            if (iterationen == 1000) {
                System.out.println("Abbruch nach " + iterationen + " Iterationen.");
                break;
            }
        }

        return new double[]{neu, iterationen};
    }
}

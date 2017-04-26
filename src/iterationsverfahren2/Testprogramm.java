package iterationsverfahren2;

import iterationsverfahren2.Algorithmen;
import iterationsverfahren2.Polynom;

import java.util.Scanner;

/**
 * @author Monique
 */
public class Testprogramm {

	public static void polynomTabulator(){
		Scanner s = new Scanner(System.in);

		while(true){
			System.out.println("Abbruch mit Eingabe 0");
			int d = s.nextInt();
			if(d == 0){
				break;
			}
			Polynom polly = new Polynom();
			double p[] = polly.getKoeffizienten();
			int exponent = p.length-1;
			for (int i = p.length-1; i >= 0; i--) {
				if( i != 0) System.out.print( " + ");
				System.out.print( " " + p[ i] + "*x^" + exponent);
				exponent--;
			}
			System.out.println("\nUntere Schranke: ");
			double uS = s.nextDouble();
			System.out.println("Obere Schranke: ");
			double oS = s.nextDouble();
			System.out.println("Schrittweite: ");
			double schrittweite = s.nextDouble();
			System.out.println("\nPolynomwertberechnung: ");
			System.out.format("%10s %10s %10s %n", "x", "f(x)", "f'(x)");
			for(double x = uS; x <= oS; x += schrittweite ){
				System.out.format("%10.0f %10.2f %10.2f %n", x, 
						Algorithmen.horner(polly,x), 
						Algorithmen.horner(polly.leiteAb(), x));
			}
		}
	}

	public static void nullstellenBerechner(){
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);

		System.out.println("NullstellenBerechner");
		while(true){
			System.out.println("Weitermachen?, Abbruch mit Eingabe 0");
			int d = s.nextInt();
			if(d == 0){
				break;
			}
			Polynom polly = new Polynom();
			double p[] = polly.getKoeffizienten();
			int exponent = p.length-1;
			for (int i = p.length-1; i >= 0; i--) {
				if( i != 0) System.out.print( " + ");
				System.out.print( " " + p[ i] + "*x^" + exponent);
				exponent--;
			}
			System.out.println();
			while (true){
				System.out.println("Welches Verfahren wuenschen sie?");
				System.out.println("1. Newton           2. Regula Falsi         0. Abbruch");
				d = s.nextInt();
				if(d == 1){
					//newtonaufruf
					System.out.print("x0: ");
					double x0 = s.nextDouble();
					System.out.print("epsilon: ");
					double epsilon = s.nextDouble();

					double[] ergebnis = Algorithmen.newton(polly, polly.leiteAb(), x0, epsilon);
					System.out.println("Ergebnis : " + ergebnis[0]);
					System.out.println("Anzahl der Iterationen: " + ergebnis[1]);
				}
				else if(d == 2){
					//regulafalsiaufruf
					System.out.print("x0: ");
					double x0 = s.nextDouble();
					System.out.print("x1: ");
					double x1 = s.nextDouble();
					System.out.print("epsilon: ");
					double epsilon = s.nextDouble();

					double[] ergebnis = Algorithmen.regulaFalsi(polly, x0, x1, epsilon);
					System.out.println("Ergebnis : " + ergebnis[0]);
					System.out.println("Anzahl der Iterationen: " + ergebnis[1]);
				}
				else{
					break;
				}
			}
		}
	}


	public static void main(String[] args) {

		nullstellenBerechner();
		//polynomTabulator();
		
		
		/* Scanner scanner = new Scanner(System.in);
        Polynom polynom;
        Polynom ableitung;
        double argumentHorner;
        double hornerErgebnis;
        double hornerErgebnisAbleitung;
        double x0Newton;
        double newtonGenauigkeit;
        double[] newtonErgebnis;
        double x0RegulaFalsi;
        double x1RegulaFalsi;
        double regulaFalsiGenauigkeit;
        double[] regulaFalsiErgebnis;

        polynom = new Polynom();
        ableitung = polynom.leiteAb();

        System.out.println("\nFolgendes Polynom wurde eingegeben:");
        System.out.println(polynom.toString());
        System.out.println("\nDie 1. Ableitung des Polynoms lautet:");
        System.out.println(ableitung.toString());

        System.out.println("\nGeben Sie nun das x ein, fuer welches der Funktionswert (und Wert der 1. Ableitung) mittels Hornerschema berechnet werden soll:");
        argumentHorner = scanner.nextDouble();
        hornerErgebnis = Algorithmen.horner(polynom, argumentHorner);
        hornerErgebnisAbleitung = Algorithmen.horner(ableitung, argumentHorner);
        System.out.println("\nErgebnis Hornerschema: " + hornerErgebnis);
        System.out.println("Ergebnis Hornerschema (Ableitung): " + hornerErgebnisAbleitung);

        System.out.println("\n------- Nullstellenbestimmung (Newton) -------");
        System.out.println("Geben Sie eine Anfangsnaeherung ein:");
        x0Newton = scanner.nextDouble();
        System.out.println("Geben Sie die gewuenschte Genauigkeit ein:");
        newtonGenauigkeit = scanner.nextDouble();
        newtonErgebnis = Algorithmen.newton(polynom, ableitung, x0Newton, newtonGenauigkeit);
        System.out.println(newtonErgebnis[0] + " wurde als Nullstelle gefunden.");
        System.out.println("Es wurden " + newtonErgebnis[1] + " Iterationen gebraucht.");

        System.out.println("\n------- Nullstellenbestimmung (Regula Falsi) -------");
        System.out.println("Es werden 2 Anfangswerte gebraucht.");
        System.out.println("Die Vorzeichen der Werte duerfen nicht gleich sein.");
        System.out.println("Geben Sie Anfangswert 1 ein:");
        x0RegulaFalsi = scanner.nextDouble();
        System.out.println("Geben Sie Anfangswert 2 ein:");
        x1RegulaFalsi = scanner.nextDouble();
        System.out.println("Geben Sie die gewuenschte Genauigkeit ein:");
        regulaFalsiGenauigkeit = scanner.nextDouble();
        regulaFalsiErgebnis = Algorithmen.regulaFalsi(polynom, x0RegulaFalsi, x1RegulaFalsi, regulaFalsiGenauigkeit);
        System.out.println(regulaFalsiErgebnis[0] + " wurde als Nullstelle gefunden.");
        System.out.println("Es wurden " + regulaFalsiErgebnis[1] + " Iterationen gebraucht.");

		 */
	}
}

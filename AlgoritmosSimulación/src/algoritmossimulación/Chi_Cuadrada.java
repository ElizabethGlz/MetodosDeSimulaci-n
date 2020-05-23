/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmossimulación;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Range {

    double lowerEnd, upperEnd;
    int observed, Oi_Ei;
    double Oi_Ei_Sqr, Oi_Ei_Sqr_by_Ei;

    public Range(double low, double up) {
        lowerEnd = low;
        upperEnd = up;
    }
}

public class Chi_Cuadrada {

    Range[] range;

    int Expected, interval;

    double randomNumbers[];

    double ziNot = 0;

    String confianza;

    public Chi_Cuadrada(double valores[], int intervalo) {
        //randomNumbers = new ArrayList<Double>();
        this.randomNumbers = valores;
        acceptRandomNumbers();
        doSettings();
        doCounting();
        doCalculations();
        print();
    }

    @SuppressWarnings("empty-statement")
    public void acceptRandomNumbers() {
        try {

            int tam = randomNumbers.length;
            interval = (int) (Math.sqrt(tam));

            doSettings();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param randomNumbers
     * @param interval
     */
    public Chi_Cuadrada(double randomNumbers[], int interval, String confianza) {
        this.randomNumbers = randomNumbers;
        this.interval = interval;
        this.confianza = confianza;
        doSettings();
        doCounting();
        doCalculations();
        print();
    }

    private void doSettings() {
        range = new Range[interval];

        Expected = this.randomNumbers.length / interval;

        double low = 0;
        double up = 1.0 / interval;

        for (int i = 0; i < range.length; i++) {
            range[i] = new Range(low, up);
            low = up;
            up = up + (1.0 / interval);
        }

    }

    private void doCounting() {
        for (int i = 0; i < randomNumbers.length; i++) {
            for (int j = 0; j < range.length; j++) {
                if (randomNumbers[i] < range[j].upperEnd) {
                    range[j].observed++;
                    break;
                }
            }
        }
    }

    private void doCalculations() {
        for (int i = 0; i < range.length; i++) {
            Range current = range[i];

            current.Oi_Ei = current.observed - Expected;
            current.Oi_Ei_Sqr = Math.pow(current.Oi_Ei, 2);
            current.Oi_Ei_Sqr_by_Ei = current.Oi_Ei_Sqr / Expected * 1.0;
            ziNot += current.Oi_Ei_Sqr_by_Ei;
        }
    }

    private void print() {
//        System.out.println("Interval\t|" + "Oi\t|" + "Ei\t|" + "Oi-Ei\t|" + "(Oi-Ei)^2\t|" + "(Oi-Ei)^2/Ei");
//         
//        System.out.println("------------------------------------------------");
//                 
//        for(int i=0; i<range.length; i++)
//        {
//            Range current = range[i];
//            System.out.println("["+current.lowerEnd+"-"+current.upperEnd+")\t|"+  current.observed+"\t|"+Expected+"\t|"+current.Oi_Ei+"\t|"+current.Oi_Ei_Sqr+"\t\t|"+current.Oi_Ei_Sqr_by_Ei);
//        }

        System.out.println("Xo^2 = " + ziNot);
    }

    public static void main(String[] args) {

        double randomNumbers[] = {0.347, 0.832, 0.966, 0.472, 0.797, 0.101, 0.696, 0.966, 0.404, 0.603, 0.993, 0.371, 0.729, 0.067, 0.189, 0.977, 0.843, 0.562, 0.549, 0.992, 0.674, 0.628, 0.055, 0.494, 0.494, 0.235, 0.178, 0.775, 0.797, 0.252, 0.426, 0.054, 0.022, 0.742, 0.674, 0.898, 0.641, 0.674, 0.821, 0.19, 0.46, 0.224, 0.99, 0.786, 0.393, 0.461, 0.011, 0.977, 0.246, 0.881, 0.189, 0.753, 0.73, 0.797, 0.292, 0.876, 0.707, 0.562, 0.562, 0.821, 0.112, 0.191, 0.584, 0.347, 0.426, 0.057, 0.819, 0.303, 0.404, 0.64, 0.37, 0.314, 0.731, 0.742, 0.213, 0.472, 0.641, 0.944, 0.28, 0.663, 0.909, 0.764, 0.999, 0.303, 0.718, 0.933, 0.056, 0.415, 0.819, 0.444, 0.178, 0.516, 0.437, 0.393, 0.268, 0.123, 0.945, 0.527, 0.459, 0.652};
        Chi_Cuadrada obj = new Chi_Cuadrada(randomNumbers, (int) Math.sqrt(randomNumbers.length));
    }

}

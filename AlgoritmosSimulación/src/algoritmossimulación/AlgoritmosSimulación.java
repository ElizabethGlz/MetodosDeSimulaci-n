/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmossimulación;

import java.util.Scanner;

/**
 *
 * @author Gaby
 */
public class AlgoritmosSimulación {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String semilla, snumero2, snumero3;
        int tam1, tam2, i, primerc;
        long numero1, numero2;

        System.out.println("Escriba semilla: ");
        semilla = entrada.next();
        System.out.println("Inserta la cantidad de números aleatorios");
        int cantidad=entrada.nextInt();
        tam1 = semilla.length();
        System.out.println("Cantidad de digitos:  " + tam1);
        numero1 = Integer.parseInt(semilla);
        for (i = 1; i <= cantidad; i++) {
            numero2 = (long) Math.pow(numero1, 2);
            snumero2 = Long.toString(numero2);
            tam2 = snumero2.length();
            primerc = (tam2 - tam1) / 2;
            snumero3 = snumero2.substring(primerc, primerc + tam1);
            System.out.println(i + ". " + "0."+snumero3);
            numero1 = Integer.parseInt(snumero3);
        }
    }

}

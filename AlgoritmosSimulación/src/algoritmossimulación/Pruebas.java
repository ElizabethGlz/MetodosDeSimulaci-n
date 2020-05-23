/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmossimulación;

import java.util.HashMap;

/**
 *
 * @author Gaby
 */
public class Pruebas {
    HashMap<String,Double>valoresZ=new HashMap<>();
    
    public Pruebas(){
        valoresZ.put("95%",1.96);
        valoresZ.put("90%",1.645);
        valoresZ.put("96%",2.05);
        valoresZ.put("98%",2.33);
    }
   
//    public double calculaZ(double valor){
//        double N=Math.exp(-Math.pow(valor, 2)/2)/Math.sqrt(2*Math.PI);
//        return N;
//    }
//    
//    public double calcularZacum(double valor){
//        double acumulador=0.00000028666;
//        for (double i = -5; i < valor; i=0+0.00001) {
//            acumulador=acumulador+(0.00001*calculaZ(i-0.000005));
//        }
//        return acumulador;
//    }
//    
    
    public void Medias(double valores[],String confianza){                     
        int n=valores.length;
        double promedio=0;
        for (int i = 0; i < n; i++) {
            promedio=promedio+(valores[i]);
        }
        promedio=promedio/n;
        double límiteInferior=0.5-(valoresZ.get("95%"))*(1/Math.sqrt(12*n));
        double límiteSuperior=0.5+(valoresZ.get("95%"))*(1/Math.sqrt(12*n));
        
        System.out.println(límiteInferior+", "+límiteSuperior);
        System.out.println("Prom: "+promedio);
        if (promedio>=límiteInferior&&promedio<=límiteSuperior) {
            System.out.println("Son aceptados");
        }else{
            System.out.println("No se aceptan");
        }
    }
    
    public boolean ArribaAbajo(double valores[],String confianza){
        double unosCeros[]=new double[valores.length-1];
        for (int i = 1; i < valores.length; i++) {
            if (valores[i]>valores[i-1]) {
                unosCeros[i-1]=1;
            }else{
                unosCeros[i-1]=0;
            }
        }
        double Co=1.0;        
        for (int i = 1; i < unosCeros.length; i++) {            
            if (unosCeros[i]!=unosCeros[i-1]) {
                Co=Co+1.0;
            }
        }
        
        double miuCo=(2.0*valores.length-1)/(3);
        double varianza=(16.0*valores.length-29)/(90);        
        double Zo=(Co-miuCo)/(Math.sqrt(varianza));
        if (Zo<0) {
            Zo=Zo*-1;
        }
        System.out.println("Valor de Zo: "+Zo);
        if (Zo<valoresZ.get(confianza)) {
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        //double valores[]={0.0449, 0.1733 ,0.5746, 0.049, 0.8406, 0.8349 ,0.92 ,0.2564 ,0.6015 ,0.6694 ,0.3972 ,0.7025 ,0.1055, 0.1247 ,0.1977 ,0.0125 ,0.63 ,0.2531 ,0.8297 ,0.6483, 0.6972, 0.9582 ,0.9085, 0.8524 ,0.5514 ,0.0316 ,0.3587 ,0.7041 ,0.5915 ,0.2523 ,0.2545, 0.3044 ,0.0207, 0.1067, 0.3857, 0.1746 ,0.3362 ,0.1589 ,0.3727 ,0.4145};
        double valores2[]={0.34 ,0.83 ,0.96 ,0.47 ,0.79 ,0.99 ,0.37 ,0.72 ,0.06 ,0.18 ,0.67 ,0.62 ,0.05 ,0.49 ,0.59 ,0.42 ,0.05 ,0.02 ,0.74 ,0.67 ,0.46, 0.22, 0.99 ,0.78, 0.39 ,0.18 ,0.75, 0.73 ,0.79, 0.29, 0.11 ,0.19, 0.58 ,0.34 ,0.42, 0.37 ,0.31 ,0.73 ,0.74 ,0.21};
        Pruebas pr=new Pruebas();
        System.out.println(pr.ArribaAbajo(valores2,"95%"));
        //pr.Medias(valores, "95%");
        //double valores2[]={0.347, 0.832 ,0.966 ,0.472 ,0.797 ,0.101 ,0.696, 0.966 ,0.404, 0.603, 0.993 ,0.371 ,0.729, 0.067, 0.189, 0.977 ,0.843 ,0.562 ,0.549, 0.992, 0.674, 0.628, 0.055, 0.494, 0.494 ,0.235 ,0.178 ,0.775 ,0.797 ,0.252 ,0.426, 0.054 ,0.022 ,0.742 ,0.674 ,0.898, 0.641, 0.674 ,0.821 ,0.19, 0.46, 0.224, 0.99 ,0.786 ,0.393, 0.461, 0.011, 0.977, 0.246, 0.881, 0.189, 0.753 ,0.73, 0.797 ,0.292 ,0.876, 0.707 ,0.562 ,0.562, 0.821, 0.112 ,0.191 ,0.584, 0.347, 0.426, 0.057 ,0.819, 0.303, 0.404, 0.64, 0.37, 0.314, 0.731, 0.742, 0.213, 0.472, 0.641 ,0.944, 0.28 ,0.663, 0.909, 0.764 ,0.999 ,0.303 ,0.718, 0.933 ,0.056, 0.415, 0.819 ,0.444 ,0.178 ,0.516 ,0.437, 0.393 ,0.268 ,0.123, 0.945, 0.527 ,0.459 ,0.652};
        
    }
    
   
}

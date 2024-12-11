package com.alura.conversordemonedas;

import java.util.Scanner;

public class Aplicacion {
    private String monedaBase;
    private String monedaConversion;


    public int iniciarAplicacion(){
        int opcion;
        Scanner lectura = new Scanner(System.in);
        while (true) {
            System.out.println("*************************************");
            System.out.println("Bienvenido al conversor de monedas :3\n\n");
            System.out.println("1) Dólar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real brasileño");
            System.out.println("4) Real brasileño =>> Dólar");
            System.out.println("5) Dólar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dólar");
            System.out.println("7) Salir");
            System.out.println("Elija un opcion valida");
            System.out.println("*************************************");
            opcion = lectura.nextInt();

            if (opcion <= 7 && opcion >= 1){
                return opcion;
            }else {
                System.out.println("Ingrese una opcion valida");
            }
        }
    }

    public void evaluarOpcion(int opcion){
        switch (opcion){
            case  1:
                System.out.println("dolar =>> Peso argentino");
                this.monedaBase = "USD";
                this.monedaConversion = "ARS";
                break;
            case 2:
                System.out.println("Peso argentino =>> Dólar");
                this.monedaBase = "ARS";
                this.monedaConversion = "USD";
                break;
            case 3:
                System.out.println("Dólar =>> Real brasileño");
                this.monedaBase = "USD";
                this.monedaConversion = "BRL";
                break;
            case 4:
                System.out.println("Real brasileño =>> Dólar");
                this.monedaBase = "BRL";
                this.monedaConversion = "USD";
                break;
            case 5:
                System.out.println("Dólar =>> Peso colombiano");
                this.monedaBase = "USD";
                this.monedaConversion = "COP";
                break;
            case 6:
                System.out.println("Peso colombiano =>> Dólar");
                this.monedaBase = "COP";
                this.monedaConversion = "USD";
                break;
            case 7:
                System.out.println("Salir");
                break;
        }
    }

    public String getMonedaBase() {
        return monedaBase;
    }

    public String getMonedaConversion() {
        return monedaConversion;
    }
}

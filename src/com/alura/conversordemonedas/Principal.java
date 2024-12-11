package com.alura.conversordemonedas;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ConsultaMoneda consulta = new ConsultaMoneda();
        Aplicacion aplicacion = new Aplicacion();
        Scanner lectura = new Scanner(System.in);

        while (true){
            //se inicia la aplicacion
            int opcion = aplicacion.iniciarAplicacion();
            if (opcion == 7){
                System.out.println("Gracias por usar el conversor de monedas");
                break;
            }
            //evaluamos la opcion escogida
            aplicacion.evaluarOpcion(opcion);

            try {
                //ingresando la cantidad a convertir
                System.out.println("Ingresa el valor que deseas convertir: ");
                Double cantidad = lectura.nextDouble();
                //El resultado de la consulta se guardara a traves del record monedaexchange
                MonedaExchange moneda = consulta.ConsultaMoneda(aplicacion.getMonedaBase(), aplicacion.getMonedaConversion());
                double conversion = moneda.conversion_rate() * cantidad;
                System.out.println("El valor " + cantidad + " [" + aplicacion.getMonedaBase() +"] corresponde al valor final de =>>> " + conversion + " [" + aplicacion.getMonedaConversion() +"]\n\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

package com.alura.conversordemonedas;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;



public class ConsultaMoneda {
    private String key = "Your-Key";
    private String direccionBase = "https://v6.exchangerate-api.com/v6/" + key + "/pair/";


    public MonedaExchange ConsultaMoneda(String monedaBase, String monedaConversion) throws IOException, InterruptedException {
        String url = direccionBase + monedaBase + "/" + monedaConversion;
        //HttpClient se encarga de llevar  la solicitud al servidor
        HttpClient client = HttpClient.newHttpClient();

        /* HttpRequest es el pedido que contiene toda la informacion requerido
         * HttpRequest.newBuilder personaliza la solicitud (agregando o quitando informacion requerida)
         * build finaliza la solicitud y lo envia.*/
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        /* HttpResponse<String> es la solicitud con la informacion que pedimos
         * HttpResponse.BodyHandlers.ofString() es la presentacion de la solicitud (string)*/
        HttpResponse<String> respuesta = client.send(request, HttpResponse.BodyHandlers.ofString());

        String json = respuesta.body();

        Gson gson = new Gson();
        //retornamos la respuesto como un objeto
        return gson.fromJson(respuesta.body(),MonedaExchange.class);

    }
}

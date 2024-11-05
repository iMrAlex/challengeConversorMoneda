import com.alura.conversor.modelos.ConsumirAPI;
import com.alura.conversor.modelos.Moneda;
import com.alura.conversor.modelos.MonedaAPI;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws Exception {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        Scanner sc = new Scanner(System.in);
        String menu = """
                #####################################
                ¡Bienvenido al Conversor de Monedas =D!
                
                1) Dólar ==> Peso Argentino
                2) Peso Argentino ==> Dólar
                3) Dólar ==> Real Brasileño
                4) Real Brasileño ==> Dólar
                5) Dólar ==> Sol Peruano
                6) Sol Peruano ==> Dólar
                0) Salir
                
                #####################################
                """;
        int opcion;
        ConsumirAPI consumir = new ConsumirAPI();

        do {
            System.out.print(menu);

            while (true) {
                System.out.print("Escoja una Opción válida: ");
                opcion = sc.nextInt();
                if (opcion >= 0 && opcion <= 6) {
                    break;
                } else {
                    System.out.println("Opción inválida. Intente de nuevo.");
                }
            }

            if (opcion == 0) {
                System.out.println("Gracias por usar el conversor. ¡Hasta luego!");
                break;
            }

            String json = null;
            if (opcion == 1 || opcion == 3 || opcion == 5) {
                json = consumir.valorMonedas("USD");
            } else if (opcion == 2) {
                json = consumir.valorMonedas("ARS");
            } else if (opcion == 4) {
                json = consumir.valorMonedas("BRL");
            } else if (opcion == 6) {
                json = consumir.valorMonedas("PEN");
            }

            MonedaAPI monedaAPI = gson.fromJson(json, MonedaAPI.class);
            Moneda moneda = new Moneda(monedaAPI);

            System.out.print("Ingrese el monto a convertir: ");
            double valorConvertir = sc.nextDouble();
            double valorCalulado = 0.0;
            switch (opcion) {
                case 1:
                    valorCalulado = valorConvertir * moneda.getArs();
                    System.out.println("El valor de " + valorConvertir + " [USD], corresponde a: " + valorCalulado + "[ARS]\n");
                    break;
                case 2:
                    valorCalulado = valorConvertir * moneda.getUsd();
                    System.out.println("El valor de " + valorConvertir + " [ARS], corresponde a: " + valorCalulado + "[USD]\n");
                    break;
                case 3:
                    valorCalulado = valorConvertir * moneda.getBrl();
                    System.out.println("El valor de " + valorConvertir + " [USD], corresponde a: " + valorCalulado + "[BRL]\n");
                    break;
                case 4:
                    valorCalulado = valorConvertir * moneda.getUsd();
                    System.out.println("El valor de " + valorConvertir + " [BRL], corresponde a: " + valorCalulado + "[USD]");
                    break;
                case 5:
                    valorCalulado = valorConvertir * moneda.getPen();
                    System.out.println("El valor de " + valorConvertir + " [USD], corresponde a: " + valorCalulado + "[PEN]\n");
                    break;
                case 6:
                    valorCalulado = valorConvertir * moneda.getUsd();
                    System.out.println("El valor de " + valorConvertir + " [PEN], corresponde a: " + valorCalulado + "[USD]\n");
                    break;
                default:
                    System.out.println("Opción escodiga no valida");
                    break;
            }
        } while (opcion != 0);
    }
}
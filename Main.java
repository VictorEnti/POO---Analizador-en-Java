import java.util.Scanner;

    class Servidor{
        String nombre; // Nombre del servidor
        String origen; // Interno o externo
        String critico; // Si o no
        int intentosTotales; // Total de intentos
        int intentosFallidos; // Intentos fallidos

        boolean Datos_Validos(){ // Comprueba todas las reglas de validacion
            if ((nombre.contains("") && origen.contains("interno")) || (origen.contains("externo") && critico.contains("si")) || (critico.contains("no") && intentosTotales > 0)){
                System.out.println("Datos validos");
                return true;
            } else {
                System.out.println("Datos invalidos");
                return false;
            }
        }

        String Evaluar_Estado(){ // Devuelve uno de los estados definidos en el apartado 3
            if ((intentosFallidos >= 5) || (critico.contains("si")) || (origen.contains("externo") && intentosFallidos >= 0)){
                System.out.println("Estado: bloqueado");
                return "Bloqueado";
            } else if ((intentosFallidos >= 3) || (origen.contains("externo") && intentosFallidos >= 2)){
                System.out.println("Estado: alerta");
                return "Alerta";
            } else {
                System.out.println("Estado: normal");
                return "normal";
            }
        }

        double Porcentaje_Fallos(){ // Calcula el porcentaje de fallos sobre el total
            float Porcentaje = ((intentosFallidos/intentosTotales)*100);
            System.out.println("Porcentaje:" + Porcentaje);
            return Porcentaje;
        }

        void Mostrar_Resumen(){ // Imprime los datos, el porcentaje y el estado
            System.out.println(nombre);
            System.out.println(origen);
            System.out.println(critico);
            Porcentaje_Fallos();
            Evaluar_Estado();

        }
    }
public class Main{

    }
}
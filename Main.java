import java.util.scanner;

    class Servidor{
        String nombre; // Nombre del servidor
        String origen; // Interno o externo
        String critico; // Si o no
        int intentosTotales; // Total de intentos
        int intentosFallidos; // Intentos fallidos

        boolean Datos_Validos(){ // Comprueba todas las reglas de validacion
            if (nombre.contains("") && origen.contains("interno") || origen.contains("externo") && critico.contains("si") || critico.contains("no") && intentosTotales > 0){
                System.Out.println("Datos validos")
            } else {
                System.Out.println("Datos invalidos")
            }
        }

        String Evaluar_Estado(){ // Devuelve uno de los estados definidos en el apartado 3
            if (intentosFallidos >= 5 || servidor == "critico" || origen.contains("externo") && intentosFallidos >= 0){
                System.Out.println("Estado: bloqueado")
            } else if (intentosFallidos >= 3 || origen.contains("externo") && intentosFallidos >= 2){
                System.Out.println("Estado: alerta")
            } else {
                System.Out.println("Estado: normal")
            }
        }

        double Porcentaje_Fallos(){ // Calcula el porcentaje de fallos sobre el total
            Porcentaje = (intentosFallidos/intentosTotales)*100
            System.Out.println(Porcentaje)
        }

        void Mostrar_Resumen(){ // Imprime los datos, el porcentaje y el estado
            System.Out.println(nombre)
            System.Out.println(origen)
            System.Out.println(critico)
            Porcentaje_Fallos()
            Evaluar_Estado()

        }
    }
public class Main{

}
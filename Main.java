import java.util.Scanner;

    class Servidor{
        String nombre; // Nombre del servidor
        String origen; // Interno o externo
        String critico; // Si o no
        int intentosTotales; // Total de intentos
        int intentosFallidos; // Intentos fallidos

        String nombre_min;
        String origen_min; // Seccion para guardar las variables en minusculas
        String critico_min;


        boolean Datos_Validos(){ // Comprueba todas las reglas de validacion
            nombre_min = nombre.toLowerCase();
            origen_min = origen.toLowerCase(); // Seccion que transforma las variables en minusculas
            critico_min = critico.toLowerCase();

            if (!nombre_min.trim().isEmpty() && (origen_min.contains("interno") || origen_min.contains("externo")) && (critico_min.contains("si") || critico_min.contains("no")) && intentosTotales > 0 && intentosFallidos >= 0 && intentosFallidos <= intentosTotales){
                return true;
            } else {
                return false;
            }
        }

        String Evaluar_Estado(){ // Devuelve uno de los estados definidos en el apartado 3
            if ((intentosFallidos >= 5) || (critico_min.contains("si") && origen_min.contains("externo") && intentosFallidos >= 3)){
                return "Bloqueado";
            } else if ((intentosFallidos >= 3) || (origen_min.contains("externo") && intentosFallidos >= 2)){
                return "Alerta";
            } else {
                return "normal";
            }
        }

        double Porcentaje_Fallos(){ // Calcula el porcentaje de fallos sobre el total
            if (Datos_Validos()){
                double Porcentaje = (((double)intentosFallidos/intentosTotales)*100);
                return Porcentaje;
            } else {
                return 0;
            }
        }

        void Mostrar_Resumen(){ // Imprime los datos, el porcentaje y el estado
            if (Datos_Validos()){    
                String estado = Evaluar_Estado();
                double porciento = Porcentaje_Fallos();
                System.out.print(nombre + "|" + origen + "|" + critico + "|" + porciento + "|" + estado);
                System.out.println();
            } else {
                System.out.println(nombre + " | N/D | DATOS INVALIDOS");
                System.out.println();
            }

        }
    }

public class Main{
    public static void main(String[] args){

        Scanner Teclado = new Scanner(System.in);

        // Entrada de datos para el segundo servidor

        System.out.println("Datos del 1er servidor");

        System.out.println("Introduce el nombre del servidor");
        String Nombre = Teclado.nextLine();
        
        System.out.println("Introduce el origen del servidor");
        String Origen = Teclado.nextLine();
        
        System.out.println("Introduce la criticidad del servidor");
        String Criticidad = Teclado.nextLine();

        System.out.println("Introduce el numero de intentos totales");
        int IntTotales = Teclado.nextInt();

        System.out.println("Introduce el numero de intentos fallidos");
        int IntFallidos = Teclado.nextInt();

        Teclado.nextLine();

        Servidor Servidor_1 = new Servidor();

        Servidor_1.nombre = Nombre;
        Servidor_1.origen = Origen;
        Servidor_1.critico = Criticidad;
        Servidor_1.intentosTotales = IntTotales;
        Servidor_1.intentosFallidos = IntFallidos;

        // Entrada de datos para el segundo servidor

        System.out.println("Datos del 2do servidor");

        System.out.println("Introduce el nombre del servidor");
        Nombre = Teclado.nextLine();
        
        System.out.println("Introduce el origen del servidor");
        Origen = Teclado.nextLine();

        System.out.println("Es un servidor critico ?");
        Criticidad = Teclado.nextLine();

        System.out.println("Introduce el numero de intentos totales");
        IntTotales = Teclado.nextInt();

        System.out.println("Introduce el numero de intentos fallidos");
        IntFallidos = Teclado.nextInt();

        Servidor Servidor_2 = new Servidor();

        Servidor_2.nombre = Nombre;
        Servidor_2.origen = Origen;
        Servidor_2.critico = Criticidad;
        Servidor_2.intentosTotales = IntTotales;
        Servidor_2.intentosFallidos = IntFallidos;

        System.out.println("Reporte de seguridad");
        Servidor_1.Mostrar_Resumen();
        Servidor_2.Mostrar_Resumen();

        if (!Servidor_1.Datos_Validos() || !Servidor_2.Datos_Validos()){
            System.out.println("Comparacion no disponible");
        } else {
            String estado_1 = Servidor_1.Evaluar_Estado().toLowerCase();
            String estado_2 = Servidor_2.Evaluar_Estado().toLowerCase();

            if (estado_1.equals(estado_2)){
                System.out.println("Atencion prioritaria: igual prioridad");

            } else if (estado_1.contains("bloqueado")){
                System.out.println("Atencion prioritaria: " + Servidor_1.nombre);

            } else if (estado_2.contains("bloqueado")){
                System.out.println("Atencion prioritaria: " + Servidor_2.nombre);
            
            } else if (estado_1.contains("alerta")){
                System.out.println("Atencion prioritaria: " + Servidor_1.nombre);
            
            } else {
                System.out.println("Atencion prioritaria: " + Servidor_2.nombre);
            }
        }
    }
}
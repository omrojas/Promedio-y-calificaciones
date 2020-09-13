public class PromedioYCalificaciones {
    
     public static void main(String[] args) {
        PromedioYCalificaciones p = new PromedioYCalificaciones();
        
        String nombre = "Omar Rojas";
        int[] calificaciones = { 100, 90, 80, 100, 100 };
        
        double promedio = p.promediador(calificaciones);
        char calificacionFinal = p.calificacionFinal(promedio);
        p.imprimir(nombre, calificaciones, promedio, calificacionFinal);
    }
     
     public double promediador (int[] array) {
        int suma = array[0] + array[1] + array[2] + array[3] + array[4];
        int numeroDeCalificaciones = 5;
        
        double promedio = suma / numeroDeCalificaciones;
        
        return promedio;
    }
    
    public char calificacionFinal (double promedio) {
        char calificacionFinal = '\0';
        
        if ((promedio <= 100) && (promedio >= 91)){
            calificacionFinal = 'A';
        } else if ((promedio <= 90) && (promedio >= 81)){
            calificacionFinal = 'B';
        } else if ((promedio <= 80) && (promedio >= 71)){
            calificacionFinal = 'C';
        } else if ((promedio <= 70) && (promedio >= 61)){
            calificacionFinal = 'D';;
        } else if ((promedio <= 60) && (promedio >= 51)){
            calificacionFinal = 'E';
        } else if (promedio <= 50) {
            calificacionFinal = 'F';
        } 
        return calificacionFinal;
    }

    public void imprimir (String nombre, int[] calificaciones, double promedio, char calificacionFinal) {
        System.out.println("Nombre del estudiante: " + nombre);
        System.out.println("Calificación 1: " + calificaciones[0]);
        System.out.println("Calificación 2: " + calificaciones[1]);
        System.out.println("Calificación 3: " + calificaciones[2]);
        System.out.println("Calificación 4: " + calificaciones[3]);
        System.out.println("Calificación 5: " + calificaciones[4]);
        
        System.out.println("Promedio: " + promedio);
        System.out.println("Calificación Final: " + calificacionFinal);
    } 
}

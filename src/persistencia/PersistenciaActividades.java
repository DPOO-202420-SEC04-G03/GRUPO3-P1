package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import actividad.Actividad;
import actividad.Encuesta;
import actividad.Examen;
import actividad.Quiz;
import actividad.RecursoEducativo;
import actividad.Tarea;

public class PersistenciaActividades {

    private String rutaArchivo;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");

    public PersistenciaActividades(String rutaArchivo) {

        this.rutaArchivo = rutaArchivo;
    }

    public HashMap<Integer,Actividad> CargarActividades() {
        HashMap<Integer,Actividad> actividades = new HashMap<>();
        try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] partes = (linea.split(";"));
                String tipo = partes[0];
                int id = Integer.parseInt(partes[1]);
                String description = partes[2];
                String objetivo = partes[3];
                String niveldedificultad = partes[4];
                ArrayList<String> resenas = new ArrayList<>(List.of(partes[5].split("'")));
                String [] sugeridasstStrings = partes[6].split(",");
                int [] sugeridas = new int [sugeridasstStrings.length];
                for (int i = 0; i < sugeridasstStrings.length; i++){
                    sugeridas[i] = Integer.parseInt(sugeridasstStrings[i]);
                }
                ArrayList <Actividad> actividadessugeridas = new ArrayList<>();
                for (int s: sugeridas){
                    actividadessugeridas.add(actividades.get(s));
                }
                boolean prerrequisitos = Boolean.parseBoolean(partes[7]);
                Date fechaLimite = convertirFecha(partes[8]);
                int duracion = Integer.parseInt(partes[9]);

                if (tipo.equals("Tarea")) {
                    String estadoEntregaTarea = partes[10];
                    Date fechaEntrega = convertirFecha(partes[11]);
                    String medioEntregaTarea = partes[12];
                    Tarea tarea = new Tarea(id, description, objetivo, niveldedificultad, resenas, "Tarea",
                            actividadessugeridas, prerrequisitos, fechaLimite, estadoEntregaTarea,fechaEntrega, medioEntregaTarea,
                            duracion);
                    actividades.put(id,tarea);

                } else if (tipo.equals("Quiz")) {
                    
        

                } else if (tipo.equals("Examen")) {

                } else if (tipo.equals("Encuesta")) {

                } else if (tipo.equals("RecursoEducativo")) {

                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return actividades;

    }
    public void PersistirActividades(HashMap<Integer,Actividad> existentes){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Map.Entry<Integer, Actividad> entry : existentes.entrySet()) {
                Actividad actividad = entry.getValue();

                // Crea una línea en formato CSV o similar separada por ;
                StringBuilder sb = new StringBuilder();
                sb.append(actividad.getTipo_actividad()).append(";");  // Tipo de actividad
                sb.append(actividad.getID_actividad()).append(";");   // ID de la actividad
                sb.append(actividad.getDescripcion()).append(";");    // Descripción
                sb.append(actividad.getObjetivo()).append(";");       // Objetivo
                sb.append(actividad.getNivel_dificultad()).append(";"); // Nivel de dificultad
                sb.append(String.join("'", actividad.getResena())).append(";"); // Reseñas separadas por '
                for (Actividad sugerida: actividad.getActividades_sugeridas() ){
                    sb.append(sugerida.getID_actividad()).append(",");
                }
                sb.deleteCharAt(sb.length()-1);

                sb.append(actividad.getPrerrequisitos()).append(";"); // Prerrequisitos
                sb.append(actividad.getFecha_limite()).append(";");    // Fecha límite (puedes formatear si es un Date)
                sb.append(actividad.getDuracion()).append(";");        // Duración

                // Dependiendo del tipo de actividad, agrega atributos específicos
                if (actividad instanceof Tarea) {
                    Tarea tarea = (Tarea) actividad;
                    sb.append(tarea.getEstado_entrega()).append(";");
                    sb.append(tarea.getFecha_entrega()).append(';');
                    sb.append(tarea.getMedio_entrega());
                } else if (actividad instanceof Quiz) {
                    Quiz quiz = (Quiz) actividad;
                    
                } else if (actividad instanceof Examen) {
                    Examen examen = (Examen) actividad;
                    
                } else if (actividad instanceof Encuesta) {
                    Encuesta encuesta = (Encuesta) actividad;
                    
                } else if (actividad instanceof RecursoEducativo) {
                    RecursoEducativo recurso = (RecursoEducativo) actividad;
                    
                }

                // Escribe la línea al archivo
                writer.write(sb.toString());
                writer.newLine(); // Salto de línea para la siguiente actividad
            }
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }




    }

    private Date convertirFecha(String fechaTexto) {
        try {
            return dateFormat.parse(fechaTexto);
        } catch (ParseException e) {
            System.out.println("Error al convertir la fecha: " + e.getMessage());
            return null; // Manejo de error si no se puede parsear la fecha
        }
    }

}

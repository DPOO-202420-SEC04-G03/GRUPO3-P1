package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import learningpath.LearningPath;
import actividad.Actividad;

public class PersistenciaLearningPath {

    private String rutaArchivo;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
    private PersistenciaActividades persistenciaActividades; // Para obtener actividades a partir de sus IDs

    public PersistenciaLearningPath(String rutaArchivo, PersistenciaActividades persistenciaActividades) {
        this.rutaArchivo = rutaArchivo;
        this.persistenciaActividades = persistenciaActividades;
    }

    public HashMap<Integer, LearningPath> cargarLearningPaths() {
        HashMap<Integer, LearningPath> learningPaths = new HashMap<>();
        try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split(";");
                
                // Campos básicos
                int id_LP = Integer.parseInt(partes[0]);
                String titulo = partes[1];
                String descripcion = partes[2];
                List<String> objetivos = List.of(partes[3].split(","));
                String nivel_dificultad = partes[4];
                Date fecha_creacion = convertirFecha(partes[5]);
                String version = partes[6];
                int duracion = Integer.parseInt(partes[7]);
                double rating = Double.parseDouble(partes[8]);
                Date fecha_modificacion = convertirFecha(partes[9]);

                // Cargar actividades por sus IDs
                // Cargar actividades por sus IDs
                List<Actividad> actividades = new ArrayList<>();
                if (!partes[10].isEmpty()) {
                    for (String idActividadStr : partes[10].split(",")) {
                        int idActividad = Integer.parseInt(idActividadStr.trim());
                        Actividad actividad = persistenciaActividades.obtenerActividadPorID(idActividad); // Usar el método correcto
                        if (actividad != null) {
                            actividades.add(actividad);
                        }
                    }
                }


                // Crear el objeto LearningPath
                LearningPath lp = new LearningPath(titulo, descripcion, objetivos, nivel_dificultad, id_LP, fecha_creacion, version);
                lp.setDuracion(duracion);
                lp.setRating(rating);
                lp.setFecha_modificacion(fecha_modificacion);
                lp.setActividades(actividades);

                learningPaths.put(id_LP, lp);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return learningPaths;
    }

    public void persistirLearningPaths(HashMap<Integer, LearningPath> existentes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Map.Entry<Integer, LearningPath> entry : existentes.entrySet()) {
                LearningPath lp = entry.getValue();
                StringBuilder sb = new StringBuilder();
                
                // Campos básicos
                sb.append(lp.getId_LP()).append(";");
                sb.append(lp.getTitulo()).append(";");
                sb.append(lp.getDescripcion()).append(";");
                sb.append(String.join(",", lp.getObjetivos())).append(";");
                sb.append(lp.getNivel_dificultad()).append(";");
                sb.append(dateFormat.format(lp.getFecha_creacion())).append(";");
                sb.append(lp.getVersion()).append(";");
                sb.append(lp.getDuracion()).append(";");
                sb.append(lp.getRating()).append(";");
                sb.append(dateFormat.format(lp.getFecha_modificacion())).append(";");

                // Guardar IDs de las actividades
                List<Integer> actividadIds = new ArrayList<>();
                for (Actividad actividad : lp.getActividades()) {
                    actividadIds.add(actividad.getID_actividad());
                }
                sb.append(String.join(",", actividadIds.toString().replaceAll("[\\[\\] ]", "")));

                writer.write(sb.toString());
                writer.newLine();
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
            return null;
        }
    }
}

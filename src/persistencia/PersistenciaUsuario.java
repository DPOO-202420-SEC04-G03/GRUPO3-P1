package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import usuario.Estudiante;
import usuario.Profesor;
import usuario.Usuario;
import learningpath.LearningPath;

public class PersistenciaUsuario {

    private String rutaArchivo;

    public PersistenciaUsuario(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    // Método para cargar los usuarios desde el archivo
    public HashMap<Integer, Usuario> CargarUsuarios() {
        HashMap<Integer, Usuario> usuarios = new HashMap<>();
        try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split(";");
                String tipoUsuario = partes[0];
                int idUsuario = Integer.parseInt(partes[1]);
                String login = partes[2];
                String password = partes[3];
                
                Usuario usuario = null;
                
                // Verifica el tipo de usuario
                if (tipoUsuario.equals("Profesor")) {
                    Set <LearningPath> creados = new HashSet<>();
                    for (String id: partes[4].split(",")){
                        creados.add(Recommendation.obtenerLearningPath(Integer.parseInt(id)));
                    }
                    Profesor profe = new Profesor(idUsuario, login, password);
                    profe.setLearningPathsCreados(creados);
                    usuario = profe;
                } else if (tipoUsuario.equals("Estudiante")) {
                    // Crear una instancia de Estudiante
                    usuario = new Estudiante(idUsuario, login, password, new ArrayList<LearningPath>());
                }

                // Añadir el usuario al mapa si no es nulo
                if (usuario != null) {
                    usuarios.put(idUsuario, usuario);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return usuarios;
    }

    // Método para persistir los usuarios en el archivo
    public void PersistirUsuarios(HashMap<Integer, Usuario> usuarios) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Usuario usuario : usuarios.values()) {
                StringBuilder sb = new StringBuilder();

                // Agrega el tipo de usuario al principio de la línea
                if (usuario instanceof Profesor) {
                    sb.append("Profesor;");
                } else if (usuario instanceof Estudiante) {
                    sb.append("Estudiante;");
                }

                sb.append(usuario.getId_usuario()).append(";")
                        .append(usuario.getLogin()).append(";")
                        .append(usuario.getPassword());

                // Escribe la línea al archivo
                writer.write(sb.toString());
                writer.newLine(); // Salto de línea para el siguiente usuario
            }
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}

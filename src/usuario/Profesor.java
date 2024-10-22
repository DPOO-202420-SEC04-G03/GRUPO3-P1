package usuario;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import learningpath.LearningPath;
import actividad.Actividad;

public class Profesor extends Usuario {
    
    private Set<LearningPath> learningPathsCreados;  // Usamos Set para evitar duplicados

    // Constructor
    public Profesor(int id_usuario, String login, String password) {
        super(id_usuario, login, password);
        this.learningPathsCreados = new HashSet<>();  
    }

    // Getters y Setters
    public Set<LearningPath> getLearningPathsCreados() {
        return this.learningPathsCreados;
    }

    public void setLearningPathsCreados(Set<LearningPath> learningPathsCreados) {
        this.learningPathsCreados = learningPathsCreados;
    }

    // Crear Learning Path
    public LearningPath crearLearningPath(String titulo, String descripcion, String objetivo, String nivel_dificultad, int id_LP, Date fecha_creacion, String version) {
        LearningPath lpnuevo = new LearningPath(titulo, descripcion, new HashSet<>(), nivel_dificultad, id_LP, fecha_creacion, version, objetivo);
        this.learningPathsCreados.add(lpnuevo);  
        return lpnuevo;
    }


    public LearningPath buscarLearningPath(int id_LP) {

        for (LearningPath lp : this.learningPathsCreados) {
            if (lp.getId_LP() == id_LP) {  // Busca por ID
                return lp;
            }
        }
        return null;  
    }


    public void editarLearningPath(int id_LP, String nuevoTitulo, String nuevaDescripcion, String nuevoObjetivo,
                                    String nuevoNivelDificultad, String nuevaVersion) {

        LearningPath learningPath = buscarLearningPath(id_LP); 
        if (learningPath != null) {
            learningPath.setTitulo(nuevoTitulo);
            learningPath.setDescripcion(nuevaDescripcion);
            learningPath.setObjetivo(nuevoObjetivo);  
            learningPath.setNivel_dificultad(nuevoNivelDificultad);
            learningPath.setVersion(nuevaVersion);
            learningPath.setFecha_modificacion(new Date());  // Actualiza la fecha de modificación
        }
    }

    // Eliminar Learning Path por ID
    public void eliminarLearningPath(int id_LP) {
        LearningPath learningPath = buscarLearningPath(id_LP);
        if (learningPath != null) {
            this.learningPathsCreados.remove(learningPath); 
        }
    }

    // Agregar una actividad a un Learning Path
    public void agregarActividadALearningPath(int id_LP, Actividad nuevaActividad) {
        LearningPath learningPath = buscarLearningPath(id_LP);
        if (learningPath != null) {
            learningPath.agregarActividad(nuevaActividad);  
        }
    }

    // Editar una actividad en un Learning Path
    public void editarActividadEnLearningPath(int id_LP, Actividad antiguaActividad, Actividad nuevaActividad) {
        LearningPath learningPath = buscarLearningPath(id_LP);
        if (learningPath != null) {
            learningPath.editarActividad(antiguaActividad, nuevaActividad); 
        }
    }

    // Eliminar una actividad en un Learning Path
    public void eliminarActividadEnLearningPath(int id_LP, Actividad actividad) {
        LearningPath learningPath = buscarLearningPath(id_LP);
        if (learningPath != null) {
            learningPath.eliminarActividad(actividad);  
        }
    }
}

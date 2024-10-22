package usuario;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import learningpath.LearningPath;

public class Profesor extends Usuario {
    
    private Set<LearningPath> learningPathsCreados;  // Usamos Set para evitar duplicados

    // Constructor
    public Profesor(int id_usuario, String login, String password) {
        super(id_usuario, login, password);
        this.learningPathsCreados = new HashSet<>();  // Inicializamos el Set
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

    // Buscar Learning Path por ID
    public LearningPath buscarLearningPath(int id_LP) {
        for (LearningPath lp : this.learningPathsCreados) {
            if (lp.getId_LP() == id_LP) {  // Busca por ID
                return lp;
            }
        }
        return null;  // Si no lo encuentra, retorna null
    }

    // Editar Learning Path por ID
    public void editarLearningPath(int id_LP, String nuevoTitulo, String nuevaDescripcion, String nuevoObjetivo,
                                    String nuevoNivelDificultad, String nuevaVersion) {

        LearningPath learningPath = buscarLearningPath(id_LP);  // Busca el Learning Path por su ID
        
        if (learningPath != null) {
            learningPath.setTitulo(nuevoTitulo);
            learningPath.setDescripcion(nuevaDescripcion);
            learningPath.setObjetivo(nuevoObjetivo);  // Cambiado a String
            learningPath.setNivel_dificultad(nuevoNivelDificultad);
            learningPath.setVersion(nuevaVersion);
            learningPath.setFecha_modificacion(new Date());  // Actualiza la fecha de modificación
        }
    }

    // Eliminar Learning Path por ID
    public void eliminarLearningPath(int id_LP) {
        LearningPath learningPath = buscarLearningPath(id_LP);
        
        if (learningPath != null) {
            this.learningPathsCreados.remove(learningPath);  // Elimina el Learning Path del Set
        }
    }
}

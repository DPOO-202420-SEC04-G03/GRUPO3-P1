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

    // Crear LearningPath
    public LearningPath crearLearningPath(String titulo, String descripcion, String objetivo, String nivel_dificultad, int id_LP, Date fecha_creacion, String version) {

        LearningPath lpnuevo = new LearningPath(titulo, descripcion, new HashSet<>(), nivel_dificultad, id_LP, fecha_creacion, version, objetivo);
        this.learningPathsCreados.add(lpnuevo);  
        
        return lpnuevo;
    }

    // Llamar a los métodos de búsqueda, edición y eliminación de LearningPath

    public LearningPath buscarLearningPath(int id_LP) {
        
        return LearningPath.buscarLearningPath(this.learningPathsCreados, id_LP);
    }

    public void editarLearningPath(int id_LP, String nuevoTitulo, String nuevaDescripcion, String nuevoObjetivo,
                                    String nuevoNivelDificultad, String nuevaVersion) {

        LearningPath.editarLearningPath(this.learningPathsCreados, id_LP, nuevoTitulo, nuevaDescripcion, nuevoObjetivo, nuevoNivelDificultad, nuevaVersion);
    }

    public void eliminarLearningPath(int id_LP) {

        LearningPath.eliminarLearningPath(this.learningPathsCreados, id_LP);
    }
}

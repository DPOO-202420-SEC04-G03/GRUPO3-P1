package usuario;

import java.sql.Date;
import java.util.List;
import learningpath.LearningPath;

public class Profesor extends Usuario {
    
    private List<LearningPath> learningPathsCreados;

    // Constructor
    public Profesor(int id_usuario, String login, String password, List<LearningPath> learningPathsCreados) {
        super(id_usuario, login, password);
        this.learningPathsCreados = learningPathsCreados;
    }

    // Getters y Setters
    public List<LearningPath> getLearningPathsCreados() {
        return this.learningPathsCreados;
    }

    public void setLearningPathsCreados(List<LearningPath> learningPathsCreados) {
        this.learningPathsCreados = learningPathsCreados;
    }



    //crear learning path

    public LearningPath crearLearningPath(String titulo, String descripcion, List<String> objetivos, String nivel_dificultad, int id_LP, Date fecha_creacion, String version){

        LearningPath lpnuevo= new LearningPath(titulo, descripcion, objetivos, nivel_dificultad, id_LP, fecha_creacion, version);
        this.learningPathsCreados.add(lpnuevo);
        
        return lpnuevo;

    }

    public void editarLearningPath(int id_LP, String nuevoTitulo, String nuevaDescripcion, List<String> nuevosObjetivos,
                                        String nuevoNivelDificultad, String nuevaVersion) {

    
    
    
    
                                        }



}



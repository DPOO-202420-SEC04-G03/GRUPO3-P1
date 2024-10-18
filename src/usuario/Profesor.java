package usuario;

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
}

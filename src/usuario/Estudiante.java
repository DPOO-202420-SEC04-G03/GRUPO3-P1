package usuario;
import java.util.List;

import learningpath.LearningPath;

public class Estudiante extends Usuario {
    
    private List<LearningPath> LearningPathInscritos;


    public Estudiante(int id_usuario, String login, String password, List<LearningPath> LearningPathInscritos) {

        super(id_usuario, login, password);
        this.LearningPathInscritos = LearningPathInscritos;
    }
    

    public List<LearningPath> getLearningPathInscritos() {
        return this.LearningPathInscritos;
    }

    public void setLearningPathInscritos(List<LearningPath> LearningPathInscritos) {
        this.LearningPathInscritos = LearningPathInscritos;
    }

}

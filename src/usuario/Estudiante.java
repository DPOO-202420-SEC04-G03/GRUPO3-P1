package usuario;
import java.util.List;
import actividad.Actividad;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import learningpath.LearningPath;

public class Estudiante extends Usuario {
    
    private List<LearningPath> LearningPathInscritos;
    private HashMap<Integer, Set <Actividad>> actividades_realizadas_por_LP;
    private List<Double> calificaciones;



    public Estudiante(int id_usuario, String login, String password, List<LearningPath> LearningPathInscritos) {
        
        super(id_usuario, login, password);
        this.actividades_realizadas_por_LP= new HashMap<>();
        this.calificaciones= new ArrayList<>();
        this.LearningPathInscritos = LearningPathInscritos;
    }
    
    public List<LearningPath> getLearningPathInscritos() {
        return this.LearningPathInscritos;
    }

    public void setLearningPathInscritos(List<LearningPath> LearningPathInscritos) {
        this.LearningPathInscritos = LearningPathInscritos;
    }

    public HashMap<Integer,Set<Actividad>> getActividades_realizadas() {
        return this.actividades_realizadas_por_LP;
    }

    public void setActividades_realizadas(HashMap<Integer,Set<Actividad>> actividades_realizadas) {
        this.actividades_realizadas_por_LP = actividades_realizadas;
    }

    public List<Double> getCalificaciones() {
        return this.calificaciones;
    }

    public void setCalificaciones(List<Double> calificaciones) {
        this.calificaciones = calificaciones;
    }
    


    public void agregarCalificacion(double cali) {
        
        calificaciones.add(cali);
    }

    public void inscribirseLearningPath(LearningPath lp){

        this.LearningPathInscritos.add(lp);
    }

    
    public String mostrarProgreso(int id_learningpath){

        for (LearningPath lp: this.LearningPathInscritos){

            if (lp.getId_LP() == id_learningpath){

                int total= lp.getActividades().size();
                int completadas= actividades_realizadas_por_LP.get(id_learningpath).size();

                return "El progreso es: "+ completadas+"/"+ total;
            }
        }
        return "No está inscrito en el LP: "+ id_learningpath;
    }

    public void escribirResena(Actividad actividad, String resena){

        actividad.agregarResena(resena);

    }
    public void realizarActividad(Actividad actividad, int idLearningPath) {
        
        Set<Actividad> actividadesRealizadas = actividades_realizadas_por_LP.getOrDefault(idLearningPath, new HashSet<>());
    
        actividadesRealizadas.add(actividad);
    
        // Actualizar el mapa
        actividades_realizadas_por_LP.put(idLearningPath, actividadesRealizadas);
    }
    public void verProgreso() {
        for (LearningPath lp : LearningPathInscritos) {
            int totalActividades = lp.getActividades().size();
            int actividadesCompletadas = actividades_realizadas_por_LP.getOrDefault(lp.getId_LP(), new HashSet<>()).size();
    
            double porcentajeCompletado = totalActividades > 0 ? (actividadesCompletadas * 100.0) / totalActividades : 0;
            
            System.out.println("Learning Path: " + lp.getTitulo());
            System.out.println("Progreso: " + actividadesCompletadas + "/" + totalActividades + " actividades completadas (" + porcentajeCompletado + "%)");
        }
    }
    
    
}

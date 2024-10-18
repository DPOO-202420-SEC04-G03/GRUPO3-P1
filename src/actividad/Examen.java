package actividad;
import java.util.Date;
import java.util.List;
import pregunta.Pregunta;

public class Examen extends Actividad {
    private String estado_entrega;
    private Date fecha_entrega;
    private List<Pregunta> preguntas;

    // Constructor
    public Examen(int ID_actividad, String objetivo, String nivel_dificultad, String resena, String tipo_actividad, 
                  List<Actividad> actividades_sugeridas, boolean prerrequisitos, Date fecha_limite,
                  String estado_entrega, Date fecha_entrega, List<Pregunta> preguntas) {
        super(ID_actividad, objetivo, nivel_dificultad, resena, tipo_actividad, actividades_sugeridas, prerrequisitos, fecha_limite);
        this.estado_entrega = estado_entrega;
        this.fecha_entrega = fecha_entrega;
        this.preguntas = preguntas;
    }

    // Getters y setters
    public String getEstado_entrega() {
        return estado_entrega;
    }

    public void setEstado_entrega(String estado_entrega) {
        this.estado_entrega = estado_entrega;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    // Métodos adicionales
    public void agregarPregunta(Pregunta pregunta) {
        this.preguntas.add(pregunta);
    }

    public void eliminarPregunta(Pregunta pregunta) {
        this.preguntas.remove(pregunta);
    }
}

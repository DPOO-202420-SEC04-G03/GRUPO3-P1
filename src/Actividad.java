import java.util.Date;
import java.util.List;
import java.util.Objects;

//Atributos
public abstract class Actividad {        

    private int ID_actividad;
    private String objetivo;
    private String nivel_difultad;  // Principiante/Intermedio/Avanzado
    private String resena;
    private String tipo_actividad;
    private List<Actividad> actividades_sugeridas;
    private boolean prerrequisitos;
    private Date fecha_limite;


    //Constructor

    public Actividad(int ID_actividad, String objetivo, String nivel_difultad, String resena, String tipo_actividad, List<Actividad> actividades_sugeridas, boolean prerrequisitos, Date fecha_limite) {
        this.ID_actividad = ID_actividad;
        this.objetivo = objetivo;
        this.nivel_difultad = nivel_difultad;
        this.resena = resena;
        this.tipo_actividad = tipo_actividad;
        this.actividades_sugeridas = actividades_sugeridas;
        this.prerrequisitos = prerrequisitos;
        this.fecha_limite = fecha_limite;
    }

    //setters y getters


    public int getID_actividad() {
        return this.ID_actividad;
    }

    public void setID_actividad(int ID_actividad) {
        this.ID_actividad = ID_actividad;
    }

    public String getObjetivo() {
        return this.objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getNivel_difultad() {
        return this.nivel_difultad;
    }

    public void setNivel_difultad(String nivel_difultad) {
        this.nivel_difultad = nivel_difultad;
    }

    public String getResena() {
        return this.resena;
    }

    public void setResena(String resena) {
        this.resena = resena;
    }

    public String getTipo_actividad() {
        return this.tipo_actividad;
    }

    public void setTipo_actividad(String tipo_actividad) {
        this.tipo_actividad = tipo_actividad;
    }

    public List<Actividad> getActividades_sugeridas() {
        return this.actividades_sugeridas;
    }

    public void setActividades_sugeridas(List<Actividad> actividades_sugeridas) {
        this.actividades_sugeridas = actividades_sugeridas;
    }

    public boolean isPrerrequisitos() {
        return this.prerrequisitos;
    }

    public boolean getPrerrequisitos() {
        return this.prerrequisitos;
    }

    public void setPrerrequisitos(boolean prerrequisitos) {
        this.prerrequisitos = prerrequisitos;
    }

    public Date getFecha_limite() {
        return this.fecha_limite;
    }

    public void setFecha_limite(Date fecha_limite) {
        this.fecha_limite = fecha_limite;
    }
        
}

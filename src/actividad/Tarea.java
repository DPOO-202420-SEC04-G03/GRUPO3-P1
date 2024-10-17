package actividad;
import java.util.Date;
import java.util.List;

// Atributos
public class Tarea extends Actividad { 

    private String estado_entrega;
    private Date fecha_entrega;
    private String medio_entrega;


    //Constructor

    public Tarea(int ID_actividad, String objetivo, String nivel_dificultad, String resena, String tipo_actividad, List<Actividad> actividades_sugeridas, boolean prerrequisitos, Date fecha_limite, String estadoEntrega, Date fechaEntrega, String medioEntrega) {
        super(ID_actividad, objetivo, nivel_dificultad, resena, tipo_actividad, actividades_sugeridas, prerrequisitos, fecha_limite);
        this.estado_entrega = estadoEntrega;
        this.fecha_entrega = fechaEntrega;
        this.medio_entrega = medioEntrega;
    }
    
    //getters y setters


    public String getEstado_entrega() {
        return this.estado_entrega;
    }

    public void setEstado_entrega(String estado_entrega) {
        this.estado_entrega = estado_entrega;
    }

    public Date getFecha_entrega() {
        return this.fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public String getMedio_entrega() {
        return this.medio_entrega;
    }

    public void setMedio_entrega(String medio_entrega) {
        this.medio_entrega = medio_entrega;
    }

}
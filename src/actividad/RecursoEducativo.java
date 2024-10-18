package actividad;

import java.util.Date;
import java.util.List;

public class RecursoEducativo extends Actividad {

    private String tipoRecurso;
    private String url;

    // Constructor
    public RecursoEducativo(int ID_actividad, String descripcion, String objetivo, String nivel_dificultad, String resena, 
                            String tipo_actividad, List<Actividad> actividades_sugeridas, boolean prerrequisitos, 
                            Date fecha_limite, String tipoRecurso, String url) {
        
        super(ID_actividad, descripcion, objetivo, nivel_dificultad, resena, tipo_actividad, actividades_sugeridas, prerrequisitos, fecha_limite); 

        this.tipoRecurso = tipoRecurso;
        this.url = url;
    }

    // Getters y Setters 
    public String getTipoRecurso() {
        return tipoRecurso;
    }

    public void setTipoRecurso(String tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
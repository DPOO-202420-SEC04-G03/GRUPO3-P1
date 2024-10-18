package learningpath;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import actividad.Actividad;

//Atributos
public class LearningPath {                
    private String titulo;
    private String descripcion;
    private List<String> objetivos;
    private String nivel_dificultad;    // Principiante/Intermedio/Avanzado
    private int id_LP;
    private int duracion;
    private double rating;
    private Date fecha_creacion;
    private Date fecha_modificacion;
    private String version;
    private List<Actividad> actividades;

    //constructor
    public LearningPath(String titulo, String descripcion, List<String> objetivos, String nivel_dificultad, int id_LP, Date fecha_creacion, String version) {
    
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.objetivos = objetivos;
        this.nivel_dificultad = nivel_dificultad;
        this.id_LP = id_LP;
        this.fecha_creacion = fecha_creacion;
        this.version = version;
        this.duracion = 0; // Inicialmente 0 hasta que se añadan actividades
        this.rating = 0.0; // Inicialmente el rating es 0
        this.fecha_modificacion = new Date(); // Inicializa con la fecha actual
        this.actividades= new ArrayList<>();
    }
    //setters y getters

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<String> getObjetivos() {
        return this.objetivos;
    }

    public void setObjetivos(List<String> objetivos) {
        this.objetivos = objetivos;
    }

    public String getNivel_dificultad() {
        return this.nivel_dificultad;
    }

    public void setNivel_dificultad(String nivel_dificultad) {
        this.nivel_dificultad = nivel_dificultad;
    }

    public int getId_LP() {
        return this.id_LP;
    }

    public void setId_LP(int id_LP) {
        this.id_LP = id_LP;
    }

    public int getDuracion() {
        return this.duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public double getRating() {
        return this.rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Date getFecha_creacion() {
        return this.fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Date getFecha_modificacion() {
        return this.fecha_modificacion;
    }

    public void setFecha_modificacion(Date fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<Actividad> getActividades() {
        return this.actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }
    

}

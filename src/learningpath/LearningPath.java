package learningpath;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import actividad.Actividad;

//Atributos
public class LearningPath {       
    private String titulo;
    private String descripcion;
    private Set<Actividad> actividades; 
    private String nivel_dificultad;    // Principiante/Intermedio/Avanzado
    private int id_LP;
    private int duracion;
    private double rating;
    private Date fecha_creacion;
    private Date fecha_modificacion;
    private String version;
    private String objetivo;  // Cambiado a String

    // Constructor
    public LearningPath(String titulo, String descripcion, Set<Actividad> actividades, String nivel_dificultad, int id_LP, Date fecha_creacion, String version, String objetivo) {

        this.titulo = titulo;
        this.descripcion = descripcion;
        this.actividades = new HashSet<>(actividades);
        this.nivel_dificultad = nivel_dificultad;
        this.id_LP = id_LP;
        this.fecha_creacion = fecha_creacion;
        this.version = version;
        this.duracion = 0; // Inicialmente 0 hasta que se añadan actividades
        this.rating = 0.0; // Inicialmente el rating es 0
        this.fecha_modificacion = new Date(); // Inicializa con la fecha actual
        this.objetivo = objetivo;  // Asignamos el objetivo como un String
        actualizarDuracion();
    }

    // Setters y Getters
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

    public Set<Actividad> getActividades() {
        return this.actividades;
    }

    public void setActividades(Set<Actividad> actividades) {
        this.actividades = actividades;
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
        this.fecha_modificacion = new Date();
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

    public String getObjetivo() {
        return this.objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    // Métodos

    public void agregarActividad(Actividad actividad) {
        this.actividades.add(actividad); 
        actualizarDuracion();
        this.fecha_modificacion = new Date();
    }
    
    private void actualizarDuracion() {
        int duracion_total = 0;
        for (Actividad actividad : this.actividades) {
            duracion_total += actividad.getDuracion();
        }
        this.duracion = duracion_total;
    }

    public void eliminarActividad(Actividad actividad) {
        this.actividades.remove(actividad);
        actualizarDuracion();
        this.fecha_modificacion = new Date();
    }

    public int cantidadActividades() {
        return this.actividades.size();
    }
    
    public void editarActividad(Actividad antigua, Actividad nueva){
        for (Actividad a : this.actividades) {
            if (a.equals(antigua)) {
                a = nueva;
            }
        }
    }

}

package persistencia;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileReader;

import actividad.Actividad;
import actividad.Quiz;
import learningpath.LearningPath;
import pregunta.Pregunta;
import pregunta.PreguntaAbierta;
import usuario.Estudiante;
import usuario.Profesor;
import usuario.Usuario;

public class Recommendation {

    private HashMap<Integer, Actividad> actividades = new HashMap<>();

    private HashMap<Integer, LearningPath> learningpaths = new HashMap<>();
    private HashMap<Integer, Usuario> usuarios = new HashMap<>();
    private static Recommendation instance = new Recommendation();

    public static Recommendation getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        Recommendation recommendation = new Recommendation();
        recommendation.cargarActividades();

        // recommendation.cargarLearningPaths ();
        // recommendation.cargarUsuarios ();

        // recommendation.req1CrearLP();
        // recommendation.req2EliminarLp();
        recommendation.req3CrearActividad();
        //recommendation.req4EliminarActividad();
        // recommendation.req5EvaluarActividad();
        // recommendation.req6InscribirseALp();
        // recommendation.req7RealizarActividad();
        // recommendation.req8VerProgreso();
        // recommendation.req9DuracionLp();
        // recommendation.req10EscribirResena();

    }

    public void cargarActividades() {
        System.out.println("Cargando Actividades...");
        PersistenciaActividades carga = new PersistenciaActividades(
                "C:\\Users\\juanp\\Documents\\DPO\\proyecto1ensayo\\src\\persistencia\\actividades.txt");
        this.actividades = carga.CargarActividades();
        System.out.println("Actividades cargadas: " + this.actividades.size());
        System.out.println("primera actividad: " + this.actividades.values().iterator().next().print());

    }

    public void req3CrearActividad() {
        System.out.println("Creando Actividad");
        ArrayList<String> resenas = new ArrayList<>();
        resenas.add("El quiz mas dificil que he hecho");
        ArrayList<Actividad> actividadessugeridas = new ArrayList<>();
        actividadessugeridas.add(this.actividades.values().iterator().next());
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        preguntas.add(new PreguntaAbierta(5800, "Cuanto es 2+2?", 5, "Entregado", "4.0"));
        Actividad nuevActividad = new Quiz(5302, "aprende a contar", "contando", " Facil", resenas, "Quiz",
                actividadessugeridas, false, new Date(), 3.0f, 3.0f, preguntas, 30);
        this.actividades.put(5302, nuevActividad);
        System.out.println(nuevActividad.print());
        System.out.println("Actividad Anadida");
        System.out.println("Actividades existentes:  " + this.actividades.size());

    }

    public void req4EliminarActividad() {
        System.out.println(" Eliminando Actividad");
        this.actividades.remove(5302);
        System.out.println("Actividad Eliminada");
        System.out.println("Actividades existentes:  " + this.actividades.size());

    }
    /* 
    public void req3CrearActividad2() {
        System.out.println("Creando Actividad");
        ArrayList<Actividad> actividadessugeridas = new ArrayList<>();
        actividadessugeridas.add(this.actividades.values().iterator().next());
        Actividad nuevActividad = null;
        for (Usuario usuario : this.usuarios.values()) {
            if (usuario instanceof Profesor) {
                nuevActividad = ((Profesor) usuario).crearActividad(5302, "aprende a contar", "contando", " Facil",
                        actividadessugeridas, false, new Date(), 15, "quiz",
                        new BufferedReader(new InputStreamReader(System.in)));
                break;
            }
        }

        this.actividades.put(5302, nuevActividad);
        System.out.println(nuevActividad.print());
        System.out.println("Actividad Anadida");
        System.out.println("Actividades existentes:  " + this.actividades.size());

    }
        */

    public static LearningPath obtenerLearningPath(int id) {
        return instance.learningpaths.get(id);
    }

    public static Estudiante getEstudiante(int id) {
        if (instance.usuarios.get(id) instanceof Estudiante) {
            return (Estudiante) instance.usuarios.get(id);
        }
        return null;

    }
}

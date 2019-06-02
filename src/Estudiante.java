public class Estudiante  {

    private String nombre;
    private int numeroControl;



    public Estudiante(int numeroControl, String nombre){
        this.nombre=nombre;
        this.numeroControl=numeroControl;
    }
    public String getNombre() {



        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroControl() {
        return numeroControl;
    }

    public void setNumeroControl(int numeroControl) {
        this.numeroControl = numeroControl;
    }
}

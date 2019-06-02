import java.io.Serializable;

public class Estudiante  implements Serializable {

    private String nombre;
    private int NumerodeControl;

    Estudiante(int numeroControl, String nombre){
        this.nombre=nombre;
        this.NumerodeControl=numeroControl;
    }

    @Override
    public String toString() {
        return "Soy "+nombre+" con numero de control: "+NumerodeControl;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumerodeControl() {
        return NumerodeControl;
    }

    public void setNumeroControl(int numeroControl) {
        this.NumerodeControl = numeroControl;
    }
}

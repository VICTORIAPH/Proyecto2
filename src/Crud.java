
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Crud {

    private String archivo;
    private Estudiante estudiantes[] = null;  //un arreglo estudiantes de tipo estudiante
    private int libre;

    Crud(String archivo) {//construstor
        this.archivo = archivo;
        estudiantes = new Estudiante[100];
        libre = 0;
    }
    public void crear(){
        Estudiante inicial[] = new Estudiante[1]; //arreglo inicial
        inicial[0]=new Estudiante(1, "inicial");
        try{
            File objFile = new File(archivo);
            FileOutputStream ou = new FileOutputStream(objFile);
            ObjectOutputStream escritorobj =new ObjectOutputStream(ou);
            escritorobj.writeObject(inicial);
            escritorobj.flush();
            escritorobj.close();
        }
        catch(IOException e){
            System.out.println("Falla de entrada salida");
        }
    }
    public void leer(){
        Estudiante temporal[] = null;
        try{
            File objFile = new File(archivo);
            FileInputStream in = new FileInputStream(objFile);
            ObjectInputStream lectorobj = new ObjectInputStream(in);
            temporal = (Estudiante []) lectorobj.readObject();
            for (int i=0; i<temporal.length; i++) {
                int nc = temporal[i].getNumerodeControl();
                String nombre = temporal[i].getNombre();
                estudiantes[i] = new Estudiante(nc, nombre );
            }
            libre = temporal.length;
            lectorobj.close();
        }
        catch (ClassNotFoundException ex) {
            System.out.println("Clase no hallada");}
        catch(IOException e){
            System.out.println("Falla de entrada salida");
        }
    }
    public void agregar(){
        Scanner teclado = new Scanner(System.in);
        for (int i = 0; i < estudiantes.length ; i++) {
            if (estudiantes[i] == null) {
                System.out.println("ingrese # de control");
                    int nc = teclado.nextInt();
                System.out.println("Ingrese nombre del estudiante");
                    String nombre = teclado.nextLine();
                estudiantes [i] = new Estudiante(nc, nombre);
                System.out.println("Se agregó con exito!");
                break;
            }

        }

    }
    public String consultar(int numControl){
        String respuesta =" No se ha encontrado ";
        boolean encontrado = false;
        for(int i=0;i<estudiantes.length; i++){
            if(estudiantes[i]!=null) {
                if(estudiantes[i].getNumerodeControl() == numControl) {
                    respuesta = "Num control: " + estudiantes[i].getNumerodeControl() +
                            " Nombre: " + estudiantes[i].getNombre();
                    encontrado = true;
                    break;
                }
            }
        }
        return respuesta;
    }
    public void grabar(){
        int tam=0;
        for(int i=0;i<estudiantes.length; i++){
            if(estudiantes[i]==null) break;
            tam++;
        }
        Estudiante temporal [] = new Estudiante[tam];
        for (int i=0; i<temporal.length; i++ ){
            int nc = estudiantes[i].getNumerodeControl();
            String nombre = estudiantes[i].getNombre();
            temporal[i] = new Estudiante(nc, nombre );
        }
        try{
            File objFile = new File(archivo);
            FileOutputStream ou = new FileOutputStream(objFile);
            ObjectOutputStream escritorobj =
                    new ObjectOutputStream(ou);
            escritorobj.writeObject(temporal);
            escritorobj.flush();
            escritorobj.close();
        }
        catch(IOException e){
            System.out.println("Falla de entrada salida");
        }
    }
}


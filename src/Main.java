import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Que deseas hacer? +\n+"+
                "1.- Crear +\n+" +
                "2.-Leer +\n+" +
                "3.-Agreagar +\n" +
                "4.-Consultar +\n" +
                "5.-Modificar +\n" +
                "6.-Eliminar +\n" +
                "7.-Grabar +\n");

        switch (teclado.nextInt()){
            case 1:
                menu();
                break;
            case 2:
                menu();
                break;
            case 3:
                menu();
                break;
            case 4:
                menu();
                break;
            case 5:
                menu();
                break;
            case 6:
                menu();
                break;
            case 7:
                menu();
                break;
        }
    }
}

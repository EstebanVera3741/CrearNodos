package LaberintoGlobant.Controlador;

import LaberintoGlobant.Laberinto.Laberinto;
import java.util.Scanner;

public class Controlador {
    private Laberinto laberinto;
    private ConexionNodos conexionNodos;
    private Integer dimensionesLaberintoEjeX;
    private Integer dimensionesLaberintoEjeY;

    public Controlador (){
        Scanner scanner = new Scanner(System.in);
        inicializarLaberinto(scanner.nextInt(), scanner.nextInt());
        conexionNodos = new ConexionNodos(this);
        laberinto.visualizarElNumeroDeLasHabitacionesDelLaberinto();
        conexionNodos.insertarNodosQueComponenAlNodoPrincipal();
        conexionNodos.recorrerOrdenSolucionLaberinto();
    }
    public void inicializarLaberinto(Integer filas, Integer columnas){
        dimensionesLaberintoEjeX = columnas;
        dimensionesLaberintoEjeY = filas;
        laberinto = new Laberinto(dimensionesLaberintoEjeY, dimensionesLaberintoEjeX);
    }
    public Laberinto getLaberinto() {
        return laberinto;
    }
    public ConexionNodos getConexionNodos() {
        return conexionNodos;
    }
    public Integer getDimensionesLaberintoEjeX() {
        return dimensionesLaberintoEjeX;
    }
    public Integer getDimensionesLaberintoEjeY() {
        return dimensionesLaberintoEjeY;
    }
}

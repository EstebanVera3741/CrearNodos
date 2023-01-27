package LaberintoGlobant.Controlador;

import LaberintoGlobant.Laberinto.Habitacion;
import LaberintoGlobant.Laberinto.Laberinto;
import java.util.Scanner;

public class Controlador
{
    private Nodo nodoPrincipal;
    private Nodo nodoAnterior;
    private Laberinto laberinto;
    private ConexionNodos conexionNodos;
    private Integer dimensionesLaberintoEjeX;
    private Integer dimensionesLaberintoEjeY;

    public Controlador ()
    {
        Scanner scanner = new Scanner(System.in);
        inicializarLaberinto(scanner.nextInt(), scanner.nextInt());
        conexionNodos = new ConexionNodos(laberinto.getListaHabitacionesDelLaberinto());
        laberinto.visualizarElNumeroDeLasHabitacionesDelLaberinto();
        insertarNodosQueComponenAlNodoPrincipal();
        recorrerOrdenSolucionLaberinto();
    }
    public void inicializarLaberinto(Integer filas, Integer columnas)
    {
        dimensionesLaberintoEjeX = columnas;
        dimensionesLaberintoEjeY = filas;
        laberinto = new Laberinto(dimensionesLaberintoEjeY, dimensionesLaberintoEjeX);
    }

    public void recorrerOrdenSolucionLaberinto()
    {
        recorrerCaminoDeLaDerecha(nodoPrincipal);
    }

    public void recorrerCaminoDeLaDerecha (Nodo nodo)
    {
        if(nodo == null)
        {
            return;
        }
        else
        {
            System.out.println("\n" + nodo.getHabitacion().getTipoHabitacion());
            condicionSalidaLaberinto(nodo.getHabitacion().getTipoHabitacion());
            recorrerCaminoDeLaDerecha(nodo.getNodoDerecho());
        }
    }

    public void condicionSalidaLaberinto (Habitacion.TIPO_HABITACION tipoHabitacion)
    {
        if(tipoHabitacion.equals(Habitacion.TIPO_HABITACION.SALIDA))
        {
            System.out.println("Felicidades Terminaste el Juego Automaticamente");
        }
    }

    public void insertarNodosQueComponenAlNodoPrincipal()
    {
        for (Integer i = 0; i < laberinto.getListaHabitacionesDelLaberinto().size(); i++)
        {
            for (Integer j = 0; j < laberinto.getListaHabitacionesDelLaberinto().get(i)
                    .getHabitaciones().size(); j++)
            {

                Habitacion habitacion = laberinto.getListaHabitacionesDelLaberinto()
                        .get(i).getHabitaciones().get(j);
                Integer ejeY = i;
                Integer ejeX = j;

                Nodo nodoNuevo = new Nodo(habitacion);
                if ( habitacion.getTipoHabitacion().equals(Habitacion.TIPO_HABITACION.ENTRADA))
                {
                    if (nodoPrincipal == null)
                    {
                        nodoPrincipal = nodoNuevo;
                        nodoAnterior = nodoPrincipal;
                    }
                }
                else if (habitacion.getTipoHabitacion().equals(Habitacion.TIPO_HABITACION.CAMINO))
                {
                    conexionNodos.insertarNuevoNodo(nodoAnterior, nodoNuevo, ejeY, ejeX);
                }
                else if (habitacion.getTipoHabitacion().equals(Habitacion.TIPO_HABITACION.SALIDA))
                {
                    conexionNodos.insertarNuevoNodo(nodoAnterior, nodoNuevo, ejeY, ejeX);
                }
            }
        }
    }
}

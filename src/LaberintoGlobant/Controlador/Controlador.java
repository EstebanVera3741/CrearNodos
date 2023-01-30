package LaberintoGlobant.Controlador;

import LaberintoGlobant.Laberinto.Habitacion;
import LaberintoGlobant.Laberinto.Laberinto;

import java.util.Scanner;

public class Controlador
{
    private Nodo nodoPrincipal;
    private Nodo nodoAnterior;
    private Laberinto laberinto;
    private Integer dimensionesLaberintoEjeX;
    private Integer dimensionesLaberintoEjeY;
    private Integer ejeY;
    private Integer ejeX;

    public Controlador ()
    {
        Scanner scanner = new Scanner(System.in);
        inicializarLaberinto(scanner.nextInt(), scanner.nextInt());
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
        recorrerCaminoDeAbajo(nodoPrincipal);
        recorrerCaminoDeLaIzquierda(nodoPrincipal);
        recorrerCaminoDeArriba(nodoPrincipal);
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
    public void recorrerCaminoDeLaIzquierda (Nodo nodo)
    {
        if(nodo == null)
        {
            return;
        }
        else
        {
            System.out.println("\n" + nodo.getHabitacion().getTipoHabitacion());
            condicionSalidaLaberinto(nodo.getHabitacion().getTipoHabitacion());
            recorrerCaminoDeLaIzquierda(nodo.getNodoIzquierdo());
        }
    }
    public void recorrerCaminoDeAbajo (Nodo nodo)
    {
        if(nodo == null)
        {
            return;
        }
        else
        {
            System.out.println("\n" + nodo.getHabitacion().getTipoHabitacion());
            condicionSalidaLaberinto(nodo.getHabitacion().getTipoHabitacion());
            recorrerCaminoDeAbajo(nodo.getNodoAbajo());
        }
    }
    public void recorrerCaminoDeArriba(Nodo nodo)
    {
        if(nodo == null)
        {
            return;
        }
        else
        {
            System.out.println("\n" + nodo.getHabitacion().getTipoHabitacion());
            condicionSalidaLaberinto(nodo.getHabitacion().getTipoHabitacion());
            recorrerCaminoDeArriba(nodo.getNodoArriba());
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
        encontrarLaHabitacionEntradaEnElLaberinto();
        encontrarHabitacionLadoDerecho();
        encontrarHabitacionLadoIzquierda ();
    }


    public void encontrarHabitacionLadoDerecho (){
        Integer posicionActualEjeY = ejeY;
        Integer posicionActualEjeX = ejeX;
        for (ejeY = posicionActualEjeY; ejeY < laberinto.getListaHabitacionesDelLaberinto().size(); ejeY++) {
            for (ejeX = posicionActualEjeX; ejeX < laberinto.getListaHabitacionesDelLaberinto().get(ejeY)
                    .getHabitaciones().size(); ejeX++) {

                Habitacion habitacion = laberinto.getListaHabitacionesDelLaberinto()
                        .get(ejeY).getHabitaciones().get(ejeX);
                ejeY = ejeY;
                ejeX = ejeX;
                Nodo nodoNuevo = new Nodo(habitacion, laberinto.getListaHabitacionesDelLaberinto() );

                if (habitacion.getTipoHabitacion().equals(Habitacion.TIPO_HABITACION.CAMINO)){
                    Nodo aux;
                    aux = nodoAnterior.insertarNuevoNodo(nodoAnterior, nodoNuevo, ejeY, ejeX);
                    nodoAnterior = aux;
                }
                else if (habitacion.getTipoHabitacion().equals(Habitacion.TIPO_HABITACION.SALIDA))
                {
                    nodoAnterior.insertarNuevoNodo(nodoAnterior, nodoNuevo, ejeY, ejeX);
                }
                else {
                    break;
                }
            }
        }
    }
    public void encontrarHabitacionLadoIzquierda (){
        Integer posicionActualEjeY = ejeY;
        Integer posicionActualEjeX = ejeX;
        for (ejeY = posicionActualEjeY; ejeY < laberinto.getListaHabitacionesDelLaberinto().size(); ejeY--) {
            for (ejeX = posicionActualEjeX; ejeX < laberinto.getListaHabitacionesDelLaberinto().get(ejeY)
                    .getHabitaciones().size(); ejeX--) {

                Habitacion habitacion = laberinto.getListaHabitacionesDelLaberinto()
                        .get(ejeY).getHabitaciones().get(ejeX);
                ejeY = ejeY;
                ejeX = ejeX;
                Nodo nodoNuevo = new Nodo(habitacion, laberinto.getListaHabitacionesDelLaberinto() );

                if (habitacion.getTipoHabitacion().equals(Habitacion.TIPO_HABITACION.CAMINO)){
                    Nodo aux;
                    aux = nodoAnterior.insertarNuevoNodo(nodoAnterior, nodoNuevo, ejeY, ejeX);
                    nodoAnterior = aux;
                }
                else if (habitacion.getTipoHabitacion().equals(Habitacion.TIPO_HABITACION.SALIDA))
                {
                    nodoAnterior.insertarNuevoNodo(nodoAnterior, nodoNuevo, ejeY, ejeX);
                }
                else {
                    break;
                }
            }
        }
    }

    public void encontrarLaHabitacionEntradaEnElLaberinto () {
        boolean entradaEncontrada = false;
        for (Integer i = 0; i < laberinto.getListaHabitacionesDelLaberinto().size(); i++) {
            for (Integer j = 0; j < laberinto.getListaHabitacionesDelLaberinto().get(i)
                    .getHabitaciones().size() && !entradaEncontrada; j++)
            {
                Habitacion habitacion = laberinto.getListaHabitacionesDelLaberinto()
                        .get(i).getHabitaciones().get(j);
                ejeY = i;
                ejeX = j;
                Nodo nodoNuevo = new Nodo(habitacion, laberinto.getListaHabitacionesDelLaberinto());
                if (habitacion.getTipoHabitacion().equals(Habitacion.TIPO_HABITACION.ENTRADA))
                {
                    if (nodoPrincipal == null)
                    {
                        nodoPrincipal = nodoNuevo;
                        nodoAnterior = nodoPrincipal;
                        entradaEncontrada = true;
                    }
                }
            }
        }
    }



}

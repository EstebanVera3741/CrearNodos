package LaberintoGlobant.Controlador;

import LaberintoGlobant.Laberinto.Habitacion;
import LaberintoGlobant.Laberinto.Laberinto;

import java.util.Scanner;

public class Controlador
{
    private Nodo nodoPrincipal;
    private Nodo nodoAnterior;
    private Laberinto laberinto;
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
        laberinto = new Laberinto(filas, columnas);
    }
    public void insertarNodosQueComponenAlNodoPrincipal()
    {
        encontrarLaHabitacionEntradaEnElLaberinto();
        try {
            encontrarHabitacionLadoDerecho();
        }catch (NullPointerException e){

        }
        finally {
            encontrarHabitacionLadoIzquierda ();
        }
    }

    public void encontrarLaHabitacionEntradaEnElLaberinto () {
        boolean entradaEncontrada = false;
        for (Integer i = 0; i < laberinto.getListaHabitacionesDelLaberinto().size() && !entradaEncontrada; i++) {
            for (Integer j = 0; j < laberinto.getListaHabitacionesDelLaberinto().get(i)
                    .getHabitaciones().size() && !entradaEncontrada; j++)
            {
                Habitacion habitacion = laberinto.getListaHabitacionesDelLaberinto()
                        .get(i).getHabitaciones().get(j);
                habitacion.setEstadoHabitacion("Visitada");
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


    public void encontrarHabitacionLadoDerecho (){
        Integer posicionActualEjeY;
        Integer posicionActualEjeX;

        for (posicionActualEjeY = ejeY; posicionActualEjeY <
                laberinto.getListaHabitacionesDelLaberinto().size(); posicionActualEjeY++) {
            for (posicionActualEjeX = ejeX; posicionActualEjeX <
                    laberinto.getListaHabitacionesDelLaberinto().get(posicionActualEjeY)
                            .getHabitaciones().size(); posicionActualEjeX++) {

                Habitacion habitacion = laberinto.getListaHabitacionesDelLaberinto()
                        .get(posicionActualEjeY).getHabitaciones().get(posicionActualEjeX);

                Nodo nodoNuevo = new Nodo(habitacion, laberinto.getListaHabitacionesDelLaberinto() );

                if (habitacion.getTipoHabitacion().equals(Habitacion.TIPO_HABITACION.CAMINO)){

                    Nodo aux;
                    aux = nodoAnterior.insertarNuevoNodo(nodoAnterior, nodoNuevo, posicionActualEjeY, posicionActualEjeX);
                    nodoAnterior = aux;
                    ejeY = posicionActualEjeY;
                    ejeX = posicionActualEjeX;
                }
                else if (habitacion.getTipoHabitacion().equals(Habitacion.TIPO_HABITACION.SALIDA))
                {
                    nodoAnterior.insertarNuevoNodo(nodoAnterior, nodoNuevo, posicionActualEjeY, posicionActualEjeX);
                    ejeY = posicionActualEjeY;
                    ejeX = posicionActualEjeX;
                    break;
                }
            }
        }
    }
    public void encontrarHabitacionLadoIzquierda (){
        Integer posicionActualEjeY;
        Integer posicionActualEjeX;

        try {
            for (posicionActualEjeY = ejeY; posicionActualEjeY <
                    laberinto.getListaHabitacionesDelLaberinto().size(); posicionActualEjeY--) {
                for (posicionActualEjeX = ejeX; posicionActualEjeX <
                        laberinto.getListaHabitacionesDelLaberinto().get(posicionActualEjeY)
                                .getHabitaciones().size() && posicionActualEjeX >= 0; posicionActualEjeX--) {

                    Habitacion habitacion = laberinto.getListaHabitacionesDelLaberinto()
                            .get(posicionActualEjeY).getHabitaciones().get(posicionActualEjeX);

                    Nodo nodoNuevo = new Nodo(habitacion, laberinto.getListaHabitacionesDelLaberinto() );

                    if (habitacion.getTipoHabitacion().equals(Habitacion.TIPO_HABITACION.CAMINO)){

                        Nodo aux;
                        aux = nodoAnterior.insertarNuevoNodo(nodoAnterior, nodoNuevo, posicionActualEjeY, posicionActualEjeX);
                        nodoAnterior = aux;
                        ejeY = posicionActualEjeY;
                        ejeX = posicionActualEjeX;
                    }
                    else if (habitacion.getTipoHabitacion().equals(Habitacion.TIPO_HABITACION.SALIDA))
                    {
                        nodoAnterior.insertarNuevoNodo(nodoAnterior, nodoNuevo, posicionActualEjeY, posicionActualEjeX);
                        ejeY = posicionActualEjeY;
                        ejeX = posicionActualEjeX;
                        break;
                    }
                }
            }
        } catch (IndexOutOfBoundsException e){

        }
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
            System.out.println("\n" + nodo.getHabitacion().getValor());
            condicionSalidaLaberinto(nodo.getHabitacion().getTipoHabitacion());
            recorrerCaminoDeAbajo(nodo.getNodoAbajo());
            recorrerCaminoDeLaIzquierda(nodo.getNodoIzquierdo());
            recorrerCaminoDeArriba(nodo.getNodoArriba());
            recorrerCaminoDeLaDerecha(nodo.getNodoDerecho());
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
            System.out.println("\n" + nodo.getHabitacion().getValor());
            condicionSalidaLaberinto(nodo.getHabitacion().getTipoHabitacion());
            recorrerCaminoDeLaIzquierda(nodo.getNodoIzquierdo());
            recorrerCaminoDeArriba(nodo.getNodoArriba());
            recorrerCaminoDeLaDerecha(nodo.getNodoDerecho());
            recorrerCaminoDeAbajo(nodo.getNodoAbajo());
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
            System.out.println("\n" + nodo.getHabitacion().getValor());
            condicionSalidaLaberinto(nodo.getHabitacion().getTipoHabitacion());
            recorrerCaminoDeArriba(nodo.getNodoArriba());
            recorrerCaminoDeLaDerecha(nodo.getNodoDerecho());
            recorrerCaminoDeAbajo(nodo.getNodoAbajo());
            recorrerCaminoDeLaIzquierda(nodo.getNodoIzquierdo());
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
            System.out.println("\n" + nodo.getHabitacion().getValor());
            condicionSalidaLaberinto(nodo.getHabitacion().getTipoHabitacion());
            recorrerCaminoDeLaDerecha(nodo.getNodoDerecho());
            recorrerCaminoDeAbajo(nodo.getNodoAbajo());
            recorrerCaminoDeLaIzquierda(nodo.getNodoIzquierdo());
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



}

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
    private boolean salida;

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
        while (salida == false){
            try {
                encontrarHabitacionDelLadoDerecho();
            } catch (IndexOutOfBoundsException i){}
            finally {
                try {
                    encontrarHabitacionDelLadoAbajo();
                }catch (IndexOutOfBoundsException i){}
                finally {
                    try {
                        encontrarHabitacionDelLadoIzquierdo();
                    }catch (IndexOutOfBoundsException i){}
                    finally {
                        try{
                            encontrarHabitacionDelLadoArriba();
                        }catch (IndexOutOfBoundsException i){}
                    }
                }
            }
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
                ejeY = i;
                ejeX = j;
                Nodo nodoNuevo = new Nodo(habitacion, laberinto.getListaHabitacionesDelLaberinto(), ejeY, ejeX);
                if (habitacion.getTipoHabitacion().equals(Habitacion.TIPO_HABITACION.ENTRADA))
                {
                    if (nodoPrincipal == null)
                    {
                        habitacion.setEstadoHabitacion("Visitada");
                        nodoPrincipal = nodoNuevo;
                        nodoAnterior = nodoPrincipal;
                        entradaEncontrada = true;
                    }
                }
            }
        }
    }



    public void encontrarHabitacionDelLadoDerecho(){

        if (laberinto.getListaHabitacionesDelLaberinto().get(nodoAnterior.getEjeY())
                .getHabitaciones().get(nodoAnterior.getEjeX() + 1).getEstadoHabitacion().equals("Habilitada")){

            ejeY = nodoAnterior.getEjeY();
            ejeX = nodoAnterior.getEjeX() + 1;


            Habitacion habitacion = laberinto.getListaHabitacionesDelLaberinto().get(nodoAnterior.getEjeY())
                    .getHabitaciones().get(nodoAnterior.getEjeX() + 1);


            Nodo nodoNuevo = new Nodo(habitacion, laberinto.getListaHabitacionesDelLaberinto(), ejeY, ejeX );

            if (habitacion.getTipoHabitacion().equals(Habitacion.TIPO_HABITACION.CAMINO)){

                Nodo aux;
                aux = nodoAnterior.insertarNuevoNodo(nodoAnterior, nodoNuevo, ejeY, ejeX );
                nodoAnterior = aux;

            }
            else if (habitacion.getTipoHabitacion().equals(Habitacion.TIPO_HABITACION.SALIDA))
            {
                nodoAnterior.insertarNuevoNodo(nodoAnterior, nodoNuevo, ejeY, ejeX);
                salida = true;
            }
        }
    }
    public void encontrarHabitacionDelLadoAbajo(){

        if (laberinto.getListaHabitacionesDelLaberinto().get(nodoAnterior.getEjeY() + 1)
                .getHabitaciones().get(nodoAnterior.getEjeX()).getEstadoHabitacion().equals("Habilitada")){

            ejeY = nodoAnterior.getEjeY() + 1;
            ejeX = nodoAnterior.getEjeX();


            Habitacion habitacion = laberinto.getListaHabitacionesDelLaberinto().get(nodoAnterior.getEjeY() + 1)
                    .getHabitaciones().get(nodoAnterior.getEjeX());


            Nodo nodoNuevo = new Nodo(habitacion, laberinto.getListaHabitacionesDelLaberinto(), ejeY, ejeX );

            if (habitacion.getTipoHabitacion().equals(Habitacion.TIPO_HABITACION.CAMINO)){

                Nodo aux;
                aux = nodoAnterior.insertarNuevoNodo(nodoAnterior, nodoNuevo, ejeY, ejeX );
                nodoAnterior = aux;

            }
            else if (habitacion.getTipoHabitacion().equals(Habitacion.TIPO_HABITACION.SALIDA))
            {
                nodoAnterior.insertarNuevoNodo(nodoAnterior, nodoNuevo, ejeY, ejeX);
                salida = true;
            }
        }
    }
    public void encontrarHabitacionDelLadoIzquierdo(){

        if (laberinto.getListaHabitacionesDelLaberinto().get(nodoAnterior.getEjeY())
                .getHabitaciones().get(nodoAnterior.getEjeX() - 1).getEstadoHabitacion().equals("Habilitada")){

            ejeY = nodoAnterior.getEjeY();
            ejeX = nodoAnterior.getEjeX() - 1;


            Habitacion habitacion = laberinto.getListaHabitacionesDelLaberinto().get(nodoAnterior.getEjeY())
                    .getHabitaciones().get(nodoAnterior.getEjeX() - 1);

            System.out.println("Habitacion" + habitacion.getEstadoHabitacion());

            Nodo nodoNuevo = new Nodo(habitacion, laberinto.getListaHabitacionesDelLaberinto(), ejeY, ejeX );

            if (habitacion.getTipoHabitacion().equals(Habitacion.TIPO_HABITACION.CAMINO)){

                Nodo aux;
                aux = nodoAnterior.insertarNuevoNodo(nodoAnterior, nodoNuevo, ejeY, ejeX );
                nodoAnterior = aux;

            }
            else if (habitacion.getTipoHabitacion().equals(Habitacion.TIPO_HABITACION.SALIDA))
            {
                nodoAnterior.insertarNuevoNodo(nodoAnterior, nodoNuevo, ejeY, ejeX);
                salida = true;
            }
        }
    }
    public void encontrarHabitacionDelLadoArriba(){

        if (laberinto.getListaHabitacionesDelLaberinto().get(nodoAnterior.getEjeY() - 1)
                .getHabitaciones().get(nodoAnterior.getEjeX()).getEstadoHabitacion().equals("Habilitada")){

            ejeY = nodoAnterior.getEjeY() - 1;
            ejeX = nodoAnterior.getEjeX();


            Habitacion habitacion = laberinto.getListaHabitacionesDelLaberinto().get(nodoAnterior.getEjeY() - 1)
                    .getHabitaciones().get(nodoAnterior.getEjeX());

            System.out.println("Habitacion" + habitacion.getEstadoHabitacion());

            Nodo nodoNuevo = new Nodo(habitacion, laberinto.getListaHabitacionesDelLaberinto(), ejeY, ejeX );

            if (habitacion.getTipoHabitacion().equals(Habitacion.TIPO_HABITACION.CAMINO)){

                Nodo aux;
                aux = nodoAnterior.insertarNuevoNodo(nodoAnterior, nodoNuevo, ejeY, ejeX );
                nodoAnterior = aux;

            }
            else if (habitacion.getTipoHabitacion().equals(Habitacion.TIPO_HABITACION.SALIDA))
            {
                nodoAnterior.insertarNuevoNodo(nodoAnterior, nodoNuevo, ejeY, ejeX);
                salida = true;
            }
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
    public boolean condicionSalidaLaberinto (Habitacion.TIPO_HABITACION tipoHabitacion)
    {
        if(tipoHabitacion.equals(Habitacion.TIPO_HABITACION.SALIDA))
        {
            if (salida == true){
                System.out.println("Felicidades Terminaste el Juego Automaticamente");
            }
        }
        return salida;
    }



}

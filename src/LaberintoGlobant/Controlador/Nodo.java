package LaberintoGlobant.Controlador;


import LaberintoGlobant.Laberinto.Habitacion;
import LaberintoGlobant.Laberinto.HabitacionesDelLaberinto;

import java.util.List;

public class Nodo
{
    private Nodo nodoIzquierdo, nodoDerecho, nodoArriba, nodoAbajo;
    private Habitacion habitacion;
    private Nodo auxiliar;
    private List<HabitacionesDelLaberinto> habitacionesDelLaberintos;

    public Nodo(Habitacion habitacion, List<HabitacionesDelLaberinto> habitacionesDelLaberintos)
    {
        nodoIzquierdo = null;
        nodoDerecho = null;
        nodoAbajo = null;
        nodoArriba = null;
        this.habitacion = habitacion;
        this.habitacionesDelLaberintos = habitacionesDelLaberintos;
    }


    public Nodo getNodoIzquierdo()
    {
        return nodoIzquierdo;
    }
    public Nodo getNodoDerecho()
    {
        return nodoDerecho;
    }
    public Nodo getNodoArriba()
    {
        return nodoArriba;
    }
    public Nodo getNodoAbajo()
    {
        return nodoAbajo;
    }
    public Habitacion getHabitacion()
    {
        return habitacion;
    }

    public void setNodoIzquierdo(Nodo nodoIzquierdo)
    {
        this.nodoIzquierdo = nodoIzquierdo;
    }

    public void setNodoDerecho(Nodo nodoDerecho)
    {
        this.nodoDerecho = nodoDerecho;
    }

    public void setNodoArriba(Nodo nodoArriba)
    {
        this.nodoArriba = nodoArriba;
    }

    public void setNodoAbajo(Nodo nodoAbajo)
    {
        this.nodoAbajo = nodoAbajo;
    }











    public Nodo insertarNuevoNodo (Nodo nodoAnterior, Nodo nodoNuevo, Integer ejeY, Integer ejeX)
    {
        auxiliar = insertarNodoDerecha(nodoAnterior, nodoNuevo, ejeY, ejeX);

        if (auxiliar == null){
            auxiliar = insertarNodoAbajo(nodoAnterior, nodoNuevo, ejeY, ejeX);
        }
        else if (auxiliar == null){
            auxiliar = insertarNodoIzquierda(nodoAnterior, nodoNuevo, ejeY, ejeX);
        }
        else if (auxiliar == null){
            auxiliar = insertarNodoArriba(nodoAnterior, nodoNuevo, ejeY, ejeX);
        }

        return auxiliar;
    }


    public Nodo insertarNodoDerecha (Nodo nodoAnterior, Nodo nodoNuevo, Integer ejeY, Integer ejeX)
    {
        if(verificarUbicacionDelNuevoNodoDerechaEnElNodoPrincipal(nodoAnterior, ejeY, ejeX))
        {
            nodoAnterior.setNodoDerecho(nodoNuevo);
            auxiliar = nodoAnterior;
            //nodoNuevo.setNodoIzquierdo(nodoAnterior);
        }
        else {
            try {
                nodoAnterior = nodoDerecho;
                nodoDerecho.insertarNodoDerecha(nodoAnterior, nodoNuevo, ejeY, ejeX);
            }
            catch (NullPointerException e){
                insertarNodoAbajo(nodoAnterior, nodoNuevo, ejeY, ejeX);
            }
        }
        return auxiliar;
    }

    public Nodo insertarNodoAbajo (Nodo nodoAnterior, Nodo nodoNuevo, Integer ejeY, Integer ejeX)
    {
        if(verificarUbicacionDelNuevoNodoAbajoEnElNodoPrincipal(nodoAnterior, ejeY, ejeX))
        {
            nodoAnterior.setNodoAbajo(nodoNuevo);
            auxiliar = nodoAnterior;
            //nodoNuevo.setNodoArriba(nodoAnterior);
        }else {
            try {
                nodoAnterior = nodoAbajo;
                nodoAbajo.insertarNodoAbajo(nodoAnterior, nodoNuevo, ejeY, ejeX);
            }
            catch (NullPointerException e){
                insertarNodoIzquierda(nodoAnterior, nodoNuevo, ejeY, ejeX);
            }
        }
        return auxiliar;
    }

    public Nodo insertarNodoIzquierda (Nodo nodoAnterior, Nodo nodoNuevo,  Integer ejeY, Integer ejeX)
    {
        if(verificarUbicacionDelNuevoNodoIzquierdaEnElNodoPrincipal(nodoAnterior, ejeY, ejeX))
        {
            nodoAnterior.setNodoIzquierdo(nodoNuevo);
            auxiliar = nodoAnterior;
            //nodoNuevo.setNodoDerecho(nodoAnterior);
        }else {
            try {
                nodoAnterior = nodoIzquierdo;
                nodoIzquierdo.insertarNodoAbajo(nodoAnterior, nodoNuevo, ejeY, ejeX);
            }
            catch (NullPointerException e){
                System.out.println("NO HAY CAMINO");
            }
        }
        return auxiliar;
    }

    public Nodo insertarNodoArriba (Nodo nodoAnterior, Nodo nodoNuevo, Integer ejeY, Integer ejeX)
    {
        if (verificarUbicacionDelNuevoNodoArribaEnElNodoPrincipal(nodoAnterior, ejeY, ejeX))
        {
            nodoAnterior.setNodoArriba(nodoNuevo);
            auxiliar = nodoAnterior;
            //nodoNuevo.setNodoAbajo(nodoAnterior);
        } else {
            try {
                nodoAnterior = nodoArriba;
                nodoArriba.insertarNodoAbajo(nodoAnterior, nodoNuevo, ejeY, ejeX);
            }
            catch (NullPointerException e){
                System.out.println("NO HAY CAMINO");
            }
        }
        return auxiliar;
    }

    private boolean verificarUbicacionDelNuevoNodoDerechaEnElNodoPrincipal(Nodo nodoAnterior, Integer ejeY, Integer ejeX)
    {
        boolean result = false;
        try
        {
            result = nodoAnterior.getHabitacion().getTipoHabitacion()
                    .equals(habitacionesDelLaberintos.get(ejeY).getHabitaciones().get(ejeX - 1).getTipoHabitacion()) &&
                    nodoAnterior.getNodoDerecho() == null;
        }
        catch (IndexOutOfBoundsException e)
        {
        }
        finally
        {
            return result;
        }
    }
    private boolean verificarUbicacionDelNuevoNodoArribaEnElNodoPrincipal(Nodo nodoAnterior, Integer ejeY, Integer ejeX)
    {
        boolean result = false;
        try
        {
            result = nodoAnterior.getHabitacion().getTipoHabitacion()
                    .equals(habitacionesDelLaberintos.get(ejeY + 1).getHabitaciones().get(ejeX).getTipoHabitacion()) &&
                    nodoAnterior.getNodoArriba() == null;
        }
        catch (IndexOutOfBoundsException e)
        {
        }
        finally
        {
            return result;
        }
    }

    private boolean verificarUbicacionDelNuevoNodoIzquierdaEnElNodoPrincipal(Nodo nodoAnterior, Integer ejeY, Integer ejeX)
    {
        boolean result = false;
        try
        {
            result = nodoAnterior.getHabitacion().getTipoHabitacion()
                    .equals(habitacionesDelLaberintos.get(ejeY).getHabitaciones().get(ejeX + 1).getTipoHabitacion()) &&
                    nodoAnterior.getNodoDerecho() == null;
        }
        catch (IndexOutOfBoundsException e)
        {
        }
        finally
        {
            return result;
        }
    }



    private boolean verificarUbicacionDelNuevoNodoAbajoEnElNodoPrincipal(Nodo nodoAnterior, Integer ejeY, Integer ejeX)
    {
        boolean result = false;
        try
        {
            result = nodoAnterior.getHabitacion().getTipoHabitacion()
                    .equals(habitacionesDelLaberintos.get(ejeY - 1).getHabitaciones().get(ejeX).getTipoHabitacion()) &&
                    nodoAnterior.getNodoArriba() == null;
        }
        catch (IndexOutOfBoundsException e)
        {
        }
        finally
        {
            return result;
        }
    }




}

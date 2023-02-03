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
    private boolean nodoExitosoDerecha;
    private boolean nodoExitosoAbajo;
    private boolean nodoExitosoIzquierda;
    private boolean nodoExitosoArriba;


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
        if (nodoExitosoDerecha != true){
            auxiliar = insertarNodoDerecha(nodoAnterior, nodoNuevo, ejeY, ejeX);
        }
        if (nodoExitosoAbajo != true){
            auxiliar = insertarNodoAbajo(nodoAnterior, nodoNuevo, ejeY, ejeX);
        }
        if (nodoExitosoIzquierda != true){
            auxiliar = insertarNodoIzquierda(nodoAnterior, nodoNuevo, ejeY, ejeX);
        }
        if (nodoExitosoArriba!= true){
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
            nodoExitosoDerecha = true;
        }
        else {
            try {
                if (nodoDerecho != null){
                    nodoAnterior = nodoDerecho;
                    nodoDerecho.insertarNodoDerecha(nodoAnterior, nodoNuevo, ejeY, ejeX);
                }
                else{
                    insertarNodoAbajo(nodoAnterior, nodoNuevo, ejeY, ejeX);
                }
            }
            catch (NullPointerException e){

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
            nodoExitosoAbajo = true;
        }
        else {
            try {
                if (nodoAbajo != null){
                    nodoAnterior = nodoAbajo;
                    nodoAbajo.insertarNodoAbajo(nodoAnterior, nodoNuevo, ejeY, ejeX);
                }
                else{
                    insertarNodoIzquierda(nodoAnterior, nodoNuevo, ejeY, ejeX);
                }
            }
            catch (NullPointerException e){

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
            nodoExitosoIzquierda = true;
        }else {
            try {
                if (nodoIzquierdo != null){
                    nodoAnterior = nodoIzquierdo;
                    nodoIzquierdo.insertarNodoIzquierda(nodoAnterior, nodoNuevo, ejeY, ejeX);
                }
                else {
                    insertarNodoArriba(nodoAnterior, nodoNuevo, ejeY, ejeX);
                }
            }
            catch (NullPointerException e){
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
            nodoExitosoArriba = true;
        } else {
            try {
                if (nodoArriba != null){
                    nodoAnterior = nodoArriba;
                    nodoArriba.insertarNodoArriba(nodoAnterior, nodoNuevo, ejeY, ejeX);
                }
            }
            catch (NullPointerException e){
            }
        }
        return auxiliar;
    }

    private boolean verificarUbicacionDelNuevoNodoDerechaEnElNodoPrincipal(Nodo nodoAnterior, Integer ejeY, Integer ejeX)
    {
        boolean result = false;
        try
        {
            result = habitacionesDelLaberintos.get(ejeY).getHabitaciones().get(ejeX - 1).getTipoHabitacion()
                    .equals(Habitacion.TIPO_HABITACION.ENTRADA) ||
                    habitacionesDelLaberintos.get(ejeY).getHabitaciones().get(ejeX - 1).getTipoHabitacion()
                    .equals(Habitacion.TIPO_HABITACION.CAMINO)
                    && nodoAnterior.getNodoDerecho() == null;
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
            result = habitacionesDelLaberintos.get(ejeY - 1).getHabitaciones().get(ejeX).getTipoHabitacion()
                    .equals(Habitacion.TIPO_HABITACION.ENTRADA) ||
                    habitacionesDelLaberintos.get(ejeY - 1).getHabitaciones().get(ejeX).getTipoHabitacion()
                    .equals(Habitacion.TIPO_HABITACION.CAMINO) &&
                    nodoAnterior.getNodoAbajo() == null;
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
            result = habitacionesDelLaberintos.get(ejeY).getHabitaciones().get(ejeX + 1).getTipoHabitacion()
                    .equals(Habitacion.TIPO_HABITACION.ENTRADA) ||
                    habitacionesDelLaberintos.get(ejeY).getHabitaciones().get(ejeX + 1).getTipoHabitacion()
                    .equals(Habitacion.TIPO_HABITACION.CAMINO)
                    && nodoAnterior.getNodoIzquierdo() == null;
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
            result = habitacionesDelLaberintos.get(ejeY + 1).getHabitaciones().get(ejeX).getTipoHabitacion()
                    .equals(Habitacion.TIPO_HABITACION.ENTRADA) ||
                    habitacionesDelLaberintos.get(ejeY + 1).getHabitaciones().get(ejeX).getTipoHabitacion()
                            .equals(Habitacion.TIPO_HABITACION.CAMINO) &&
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

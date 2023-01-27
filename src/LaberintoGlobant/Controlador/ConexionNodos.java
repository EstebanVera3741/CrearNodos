package LaberintoGlobant.Controlador;

import LaberintoGlobant.Laberinto.Habitacion;
import LaberintoGlobant.Laberinto.HabitacionesDelLaberinto;

import java.util.List;

public class ConexionNodos
{
    private List<HabitacionesDelLaberinto> habitacionesDelLaberintos;

    public ConexionNodos(List<HabitacionesDelLaberinto> habitacionesDelLaberintos)
    {
        this.habitacionesDelLaberintos = habitacionesDelLaberintos;
    }
    public void insertarNuevoNodo (Nodo nodoAnterior, Nodo nodoNuevo, Integer ejeY, Integer ejeX)
    {
        if(verificarUbicacionDelNuevoNodoDerechaEnElNodoPrincipal(nodoAnterior, ejeY, ejeX))
        {
            insertarNodoDerecha(nodoAnterior, nodoNuevo);
        }
        else if(verificarUbicacionDelNuevoNodoAbajoEnElNodoPrincipal(nodoAnterior, ejeY, ejeX))
        {
            insertarNodoAbajo(nodoAnterior, nodoNuevo);
        }
        else if(verificarUbicacionDelNuevoNodoIzquierdaEnElNodoPrincipal(nodoAnterior, ejeY, ejeX))
        {
            insertarNodoIzquierda(nodoAnterior, nodoNuevo);
        } else if (verificarUbicacionDelNuevoNodoArribaEnElNodoPrincipal(nodoAnterior, ejeY, ejeX))
        {
            insertarNodoArriba(nodoAnterior, nodoNuevo);
        }
    }

    public void insertarNodoDerecha (Nodo nodoAnterior, Nodo nodoNuevo)
    {
        if (nodoAnterior.getNodoDerecho() == null)
        {
            nodoAnterior.setNodoDerecho(nodoNuevo);
            nodoNuevo.setNodoIzquierdo(nodoAnterior);
        }
    }

    public void insertarNodoAbajo (Nodo nodoAnterior, Nodo nodoNuevo)
    {
        if (nodoAnterior.getNodoAbajo() == null)
        {
            nodoAnterior.setNodoAbajo(nodoNuevo);
            nodoNuevo.setNodoArriba(nodoAnterior);
        }
    }

    public void insertarNodoIzquierda (Nodo nodoAnterior, Nodo nodoNuevo)
    {
        if (nodoAnterior.getNodoIzquierdo() == null)
        {
            nodoAnterior.setNodoIzquierdo(nodoNuevo);
            nodoNuevo.setNodoDerecho(nodoAnterior);
        }
    }

    public void insertarNodoArriba (Nodo nodoAnterior, Nodo nodoNuevo)
    {
        if (nodoAnterior.getNodoArriba() == null)
        {
            nodoAnterior.setNodoArriba(nodoNuevo);
            nodoNuevo.setNodoAbajo(nodoAnterior);
        }
    }

    private boolean verificarUbicacionDelNuevoNodoArribaEnElNodoPrincipal(Nodo nodoAnterior, Integer ejeY, Integer ejeX)
    {
        boolean result = false;
        try
        {
            result = habitacionesDelLaberintos.get(ejeY - 1).getHabitaciones().get(ejeX).getTipoHabitacion().equals(Habitacion.TIPO_HABITACION.CAMINO)
                    && nodoAnterior.getNodoAbajo() != null
                    || habitacionesDelLaberintos.get(ejeY - 1).getHabitaciones().get(ejeX).getTipoHabitacion().equals(Habitacion.TIPO_HABITACION.ENTRADA)                              && nodoAnterior.getNodoAbajo() != null
                    && nodoAnterior.getNodoAbajo() != null;
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
            result = habitacionesDelLaberintos.get(ejeY).getHabitaciones().get(ejeX + 1).getTipoHabitacion().equals(Habitacion.TIPO_HABITACION.CAMINO)
                    && nodoAnterior.getNodoDerecho() != null
                    || habitacionesDelLaberintos.get(ejeY).getHabitaciones().get(ejeX + 1).getTipoHabitacion().equals(Habitacion.TIPO_HABITACION.ENTRADA)
                    && nodoAnterior.getNodoDerecho() != null;
        }
        catch (IndexOutOfBoundsException e)
        {
        }
        finally
        {
            return result;
        }
    }

    private boolean verificarUbicacionDelNuevoNodoDerechaEnElNodoPrincipal(Nodo nodoAnterior, Integer ejeY, Integer ejeX)
    {
        boolean result = false;
        try
        {
            result = habitacionesDelLaberintos.get(ejeY).getHabitaciones().get(ejeX - 1).getTipoHabitacion().equals(Habitacion.TIPO_HABITACION.CAMINO)
                    && nodoAnterior.getNodoIzquierdo() != null
                    || habitacionesDelLaberintos.get(ejeY).getHabitaciones().get(ejeX - 1).getTipoHabitacion().equals(Habitacion.TIPO_HABITACION.ENTRADA)
                    && nodoAnterior.getNodoIzquierdo() != null;
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
            result = habitacionesDelLaberintos.get(ejeY + 1).getHabitaciones().get(ejeX).getTipoHabitacion().equals(Habitacion.TIPO_HABITACION.CAMINO)
                    && nodoAnterior.getNodoArriba() != null
                    || habitacionesDelLaberintos.get(ejeY + 1).getHabitaciones().get(ejeX).getTipoHabitacion().equals(Habitacion.TIPO_HABITACION.ENTRADA)
                    && nodoAnterior.getNodoArriba() != null;
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

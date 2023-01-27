package LaberintoGlobant.Controlador;


import LaberintoGlobant.Laberinto.Habitacion;

public class Nodo
{
    private Nodo nodoIzquierdo, nodoDerecho, nodoArriba, nodoAbajo;
    private Habitacion habitacion;

    public Nodo(Habitacion habitacion)
    {
        nodoIzquierdo = null;
        nodoDerecho = null;
        nodoAbajo = null;
        nodoArriba = null;
        this.habitacion = habitacion;
    }


    public Nodo getNodoIzquierdo() {
        return nodoIzquierdo;
    }
    public Nodo getNodoDerecho() {
        return nodoDerecho;
    }
    public Nodo getNodoArriba() {
        return nodoArriba;
    }
    public Nodo getNodoAbajo() {
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

    public void setHabitacion(Habitacion habitacion)
    {
        this.habitacion = habitacion;
    }
}

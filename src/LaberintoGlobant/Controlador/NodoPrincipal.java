package LaberintoGlobant.Controlador;


import LaberintoGlobant.Laberinto.Habitacion;

public class NodoPrincipal {
    private NodoPrincipal nodoIzquierdo, nodoDerecho, nodoArriba, nodoAbajo;
    private Habitacion habitacion;

    public NodoPrincipal (Habitacion habitacion){
        nodoIzquierdo = null;
        nodoDerecho = null;
        nodoAbajo = null;
        nodoArriba = null;
        this.habitacion = habitacion;
    }
    public NodoPrincipal getNodoIzquierdo() {
        return nodoIzquierdo;
    }
    public NodoPrincipal getNodoDerecho() {
        return nodoDerecho;
    }
    public NodoPrincipal getNodoArriba() {
        return nodoArriba;
    }
    public NodoPrincipal getNodoAbajo() {
        return nodoAbajo;
    }
    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setNodoIzquierdo(NodoPrincipal nodoIzquierdo) {
        this.nodoIzquierdo = nodoIzquierdo;
    }

    public void setNodoDerecho(NodoPrincipal nodoDerecho) {
        this.nodoDerecho = nodoDerecho;
    }

    public void setNodoArriba(NodoPrincipal nodoArriba) {
        this.nodoArriba = nodoArriba;
    }

    public void setNodoAbajo(NodoPrincipal nodoAbajo) {
        this.nodoAbajo = nodoAbajo;
    }
}

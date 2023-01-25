package LaberintoGlobant.Controlador;


import LaberintoGlobant.Laberinto.Habitacion;

public class NodoPrincipal {
    private NodoPrincipal nodoIzquierdo, nodoDerecho, nodoArriba, nodoAbajo;
    private Habitacion habitacion;
    private Controlador controlador;

    public NodoPrincipal (Habitacion habitacion, Controlador controlador){
        nodoIzquierdo = null;
        nodoDerecho = null;
        nodoAbajo = null;
        nodoArriba = null;
        this.habitacion = habitacion;
        this.controlador = controlador;
    }

    public void insertarNuevoNodo (Habitacion habitacion, NodoPrincipal nodoNuevo, Integer ejeY, Integer ejeX) {
        try {
            if (insertarNuevoNodoArriba(habitacion, ejeY, ejeX)){
                if (nodoArriba == null){
                    nodoArriba = nodoNuevo;
                }
                else{
                    nodoArriba.insertarNuevoNodo(habitacion, nodoNuevo, ejeY, ejeX);
                }
            }
            else if (insertarNuevoNodoIzquierda(habitacion, ejeY, ejeX)){
                if (nodoIzquierdo == null){
                    nodoIzquierdo = nodoNuevo;
                }
                else{
                    nodoIzquierdo.insertarNuevoNodo(habitacion, nodoNuevo, ejeY, ejeX);
                }
            }
            else if (insertarNuevoNodoAbajo(habitacion, ejeY, ejeX)){
                if (nodoAbajo == null){
                    nodoAbajo = nodoNuevo;
                }
                else{
                    nodoAbajo.insertarNuevoNodo(habitacion, nodoNuevo, ejeY, ejeX);
                }
            }
            else if (insertarNuevoNodoDerecha(habitacion, ejeY, ejeX)){
                if (nodoDerecho == null){
                    nodoDerecho = nodoNuevo;
                }
                else {
                    nodoDerecho.insertarNuevoNodo(habitacion, nodoNuevo, ejeY, ejeX);
                }
            }
        }
        catch (IndexOutOfBoundsException e){

        }

    }



    private boolean insertarNuevoNodoArriba (Habitacion habitacion, Integer ejeY, Integer ejeX){
        return this.controlador.getLaberinto().getListaHabitacionesDelLaberinto()
                .get(ejeY).getListaHabitacionesLaberinto().get(ejeX).equals(habitacion);
    }
    private boolean insertarNuevoNodoIzquierda (Habitacion habitacion, Integer ejeY, Integer ejeX){
        return this.controlador.getLaberinto().getListaHabitacionesDelLaberinto()
                .get(ejeY).getListaHabitacionesLaberinto().get(ejeX).equals(habitacion);
    }
    private boolean insertarNuevoNodoAbajo (Habitacion habitacion, Integer ejeY, Integer ejeX){
        return controlador.getLaberinto().getListaHabitacionesDelLaberinto()
                .get(ejeY).getListaHabitacionesLaberinto().get(ejeX).equals(habitacion);
    }
    private boolean insertarNuevoNodoDerecha (Habitacion habitacion, Integer ejeY, Integer ejeX){
        return this.controlador.getLaberinto().getListaHabitacionesDelLaberinto()
                .get(ejeY).getListaHabitacionesLaberinto().get(ejeX).equals(habitacion);
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

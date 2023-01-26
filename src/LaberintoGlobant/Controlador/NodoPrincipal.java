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

    public void insertarNuevoNodo (NodoPrincipal nodoNuevo, Integer ejeY, Integer ejeX) {
        try {
            if (insertarNuevoNodoArriba(ejeY, ejeX)){
                if (nodoArriba == null){
                    nodoArriba = nodoNuevo;
                }
                else{
                    nodoArriba.insertarNuevoNodo(nodoNuevo, ejeY, ejeX);
                }
            }
            else if (insertarNuevoNodoIzquierda(ejeY, ejeX)){
                if (nodoIzquierdo == null){
                    nodoIzquierdo = nodoNuevo;
                }
                else{
                    nodoIzquierdo.insertarNuevoNodo(nodoNuevo, ejeY, ejeX);
                }
            }
            else if (insertarNuevoNodoAbajo(ejeY, ejeX)){
                if (nodoAbajo == null){
                    nodoAbajo = nodoNuevo;
                }
                else{
                    nodoAbajo.insertarNuevoNodo(nodoNuevo, ejeY, ejeX);
                }
            }
            else if (insertarNuevoNodoDerecha(ejeY, ejeX)){
                if (nodoDerecho == null){
                    nodoDerecho = nodoNuevo;
                }
                else {
                    nodoDerecho.insertarNuevoNodo(nodoNuevo, ejeY, ejeX);
                }
            }
        }
        catch (IndexOutOfBoundsException e){

        }
        finally {
            insertarNuevoNodo(nodoNuevo, ejeY, ejeX);
        }

    }




    private boolean insertarNuevoNodoArriba (Integer ejeY, Integer ejeX){
        return this.controlador.getLaberinto().getListaHabitacionesDelLaberinto()
                .get(ejeY - 1).getListaHabitacionesLaberinto().get(ejeX).equals(Habitacion.TIPO_HABITACION.CAMINO)
                || this.controlador.getLaberinto().getListaHabitacionesDelLaberinto()
                .get(ejeY - 1).getListaHabitacionesLaberinto().get(ejeX).equals(Habitacion.TIPO_HABITACION.ENTRADA);
    }
    private boolean insertarNuevoNodoIzquierda (Integer ejeY, Integer ejeX){
        return this.controlador.getLaberinto().getListaHabitacionesDelLaberinto()
                .get(ejeY).getListaHabitacionesLaberinto().get(ejeX - 1).equals(Habitacion.TIPO_HABITACION.CAMINO)
                || this.controlador.getLaberinto().getListaHabitacionesDelLaberinto()
                .get(ejeY).getListaHabitacionesLaberinto().get(ejeX - 1).equals(Habitacion.TIPO_HABITACION.ENTRADA);
    }
    private boolean insertarNuevoNodoAbajo (Integer ejeY, Integer ejeX){
        return this.controlador.getLaberinto().getListaHabitacionesDelLaberinto()
                .get(ejeY + 1).getListaHabitacionesLaberinto().get(ejeX).equals(Habitacion.TIPO_HABITACION.CAMINO)
                || this.controlador.getLaberinto().getListaHabitacionesDelLaberinto()
                .get(ejeY + 1).getListaHabitacionesLaberinto().get(ejeX).equals(Habitacion.TIPO_HABITACION.ENTRADA);
    }
    private boolean insertarNuevoNodoDerecha (Integer ejeY, Integer ejeX){
        return this.controlador.getLaberinto().getListaHabitacionesDelLaberinto()
                .get(ejeY).getListaHabitacionesLaberinto().get(ejeX + 1).equals(Habitacion.TIPO_HABITACION.CAMINO)
                || this.controlador.getLaberinto().getListaHabitacionesDelLaberinto()
                .get(ejeY).getListaHabitacionesLaberinto().get(ejeX + 1).equals(Habitacion.TIPO_HABITACION.ENTRADA);
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

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

    public void insertarNuevoNodo (Habitacion habitacion) {
        if (insertarNuevoNodoArriba(habitacion));
        else if (insertarNuevoNodoIzquierda(habitacion));
        else if (insertarNuevoNodoAbajo(habitacion));
        else if (insertarNuevoNodoDerecha(habitacion));
    }

    private boolean insertarNuevoNodoArriba (Habitacion habitacion){
        boolean nodoExitoso = false;
        try {
            if (this.habitacion.getValor() - getControlador().getDimensionesLaberintoEjeY() - 1 == habitacion.getValor()){
                if(this.nodoArriba == null){
                    this.nodoArriba = new NodoPrincipal(habitacion, controlador);
                    nodoExitoso = true;
                }
                else{
                    this.nodoArriba.insertarNuevoNodo(habitacion);
                }
            }
        }catch (IndexOutOfBoundsException e){}
        return nodoExitoso;
    }
    private boolean insertarNuevoNodoIzquierda (Habitacion habitacion){
        boolean nodoExitoso = false;
        try {
            if (this.habitacion.getValor() - 1 == habitacion.getValor()){
                if(this.nodoIzquierdo == null){
                    this.nodoIzquierdo = new NodoPrincipal(habitacion, controlador);
                    nodoExitoso = true;
                }
                else{
                    this.nodoIzquierdo.insertarNuevoNodo(habitacion);
                }
            }
        }catch (IndexOutOfBoundsException e){}
        return nodoExitoso;
    }
    private boolean insertarNuevoNodoAbajo (Habitacion habitacion){
        boolean nodoExitoso = false;
        try {
            if (this.habitacion.getValor() + getControlador().getDimensionesLaberintoEjeY() + 1 == habitacion.getValor()){
                if(this.nodoAbajo == null){
                    this.nodoAbajo = new NodoPrincipal(habitacion, controlador);
                    nodoExitoso = true;
                }
                else{
                    this.nodoAbajo.insertarNuevoNodo(habitacion);
                }
            }
        }catch (IndexOutOfBoundsException e){}
        return nodoExitoso;
    }
    private boolean insertarNuevoNodoDerecha (Habitacion habitacion){
        boolean nodoExitoso = false;
        try {
            if (this.habitacion.getValor() + 1 == habitacion.getValor()){
                if(this.nodoDerecho == null){
                    this.nodoDerecho = new NodoPrincipal(habitacion, controlador);
                    nodoExitoso = true;
                }
                else{
                    this.nodoDerecho.insertarNuevoNodo(habitacion);
                }
            }
        }catch (IndexOutOfBoundsException e){}
        return nodoExitoso;
    }


    public Controlador getControlador() {
        return controlador;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }
}

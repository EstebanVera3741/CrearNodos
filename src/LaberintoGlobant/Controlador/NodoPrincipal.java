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
    public void insertarNuevoNodo (Habitacion habitacionLaberinto) {
        if (insertarNuevoNodoArriba(habitacionLaberinto));
        else if (insertarNuevoNodoIzquierda(habitacionLaberinto));
        else if (insertarNuevoNodoAbajo(habitacionLaberinto));
        else if (insertarNuevoNodoDerecha(habitacionLaberinto));
    }
    private boolean insertarNuevoNodoArriba (Habitacion habitacion){
        boolean nodoExitoso = false;
        try {
            if (controlador.getLaberinto().getListaHabitacionesDelLaberinto()
                    .get(controlador.getDimensionesLaberintoEjeX() - 1).equals(habitacion.getValor())){
                if(nodoArriba == null){
                    this.nodoArriba = new NodoPrincipal(habitacion, controlador);
                    nodoExitoso = true;
                }
            }
        }catch (IndexOutOfBoundsException e){}
        return nodoExitoso;
    }
    private boolean insertarNuevoNodoIzquierda (Habitacion habitacionLaberinto){
        boolean nodoExitoso = false;
        try {
            if (controlador.getLaberinto().getFilasLaberinto().getListaHabitacionesLaberinto()
                    .get(+1).equals(this.habitacionLaberinto)){
                if(nodoIzquierdo == null){
                    this.nodoIzquierdo = new NodoPrincipal(habitacionLaberinto, controlador);
                    nodoExitoso = true;
                }
            }
        }catch (IndexOutOfBoundsException e){}
        return nodoExitoso;
    }
    private boolean insertarNuevoNodoAbajo (Habitacion habitacionLaberinto){
        boolean nodoExitoso = false;
        try {
            if (controlador.getLaberinto().getListaHabitacionesDelLaberinto()
                    .get(+1).getHabitacionLaberinto().equals(this.habitacionLaberinto)){
                if(nodoAbajo == null){
                    this.nodoAbajo = new NodoPrincipal(habitacionLaberinto, controlador);
                    nodoExitoso = true;
                }
            }
        }catch (IndexOutOfBoundsException e){}
        return nodoExitoso;
    }
    private boolean insertarNuevoNodoDerecha (Habitacion habitacionLaberinto){
        boolean nodoExitoso = false;
        try {
            if (controlador.getConexionNodos().getInicioNodoPadre()){
                if(nodoDerecho == null){
                    this.nodoDerecho = new NodoPrincipal(habitacionLaberinto, controlador);
                    nodoExitoso = true;
                }
            }
        }catch (IndexOutOfBoundsException e){}
        return nodoExitoso;
    }

    public HabitacionLaberinto getHabitacionLaberinto() {
        return habitacionLaberinto;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public Controlador getControlador() {
        return controlador;
    }
}

package LaberintoGlobant.Controlador;

import LaberintoGlobant.Laberinto.Habitacion;
import LaberintoGlobant.Laberinto.HabitacionesDelLaberinto;

public class ConexionNodos {

    private NodoPrincipal nodoPrincipal;
    private NodoPrincipal nodoAnterior;
    private Controlador controlador;

    public ConexionNodos(Controlador controlador){
        nodoPrincipal = null;
        this.controlador = controlador;
    }

    public void insertarNuevoNodoPrincipal (){
        insertarNodosQueComponenAlNodoPrincipal();
    }

    private void insertarNodosQueComponenAlNodoPrincipal(){
        for (HabitacionesDelLaberinto filasLaberinto : controlador.getLaberinto().getListaHabitacionesDelLaberinto()){
            for (Habitacion habitacion: filasLaberinto.getListaHabitacionesLaberinto()){
                if (nodoPrincipal == null && habitacion.getTipoHabitacion().equals(Habitacion.TIPO_HABITACION.ENTRADA))
                {
                    nodoPrincipal = new NodoPrincipal(habitacion);
                    nodoAnterior = nodoPrincipal;
                }
                else if (habitacion.getTipoHabitacion().equals(Habitacion.TIPO_HABITACION.CAMINO))
                {
                    insertarNuevoNodo(habitacion);
                }
            }
        }
    }

    public void insertarNuevoNodo (Habitacion habitacion) {
        NodoPrincipal aux = new NodoPrincipal(habitacion);
        if (insertarNuevoNodoArriba(habitacion)){
            if (nodoAnterior.getNodoArriba() == null){
                nodoAnterior.setNodoArriba(aux);
            }
        }
        else if (insertarNuevoNodoIzquierda(habitacion)){
            if (nodoAnterior.getNodoIzquierdo() == null){
                nodoAnterior.setNodoIzquierdo(aux);
            }
        }
        else if (insertarNuevoNodoAbajo(habitacion)){
            if (nodoAnterior.getNodoAbajo() == null){
                nodoAnterior.setNodoAbajo(aux);
            }
        }
        else if (insertarNuevoNodoDerecha(habitacion)){
            if (nodoAnterior.getNodoDerecho() == null){
                nodoAnterior.setNodoDerecho(aux);
            }
        }
        nodoPrincipal = nodoAnterior;
    }



    private boolean insertarNuevoNodoArriba (Habitacion habitacion){
        return this.nodoPrincipal.getHabitacion().getValor() - controlador.getDimensionesLaberintoEjeY()
                == habitacion.getValor();
    }
    private boolean insertarNuevoNodoIzquierda (Habitacion habitacion){
        return this.nodoPrincipal.getHabitacion().getValor() - 1 == habitacion.getValor();
    }
    private boolean insertarNuevoNodoAbajo (Habitacion habitacion){
        return this.nodoPrincipal.getHabitacion().getValor() + controlador.getDimensionesLaberintoEjeY()
                == habitacion.getValor();
    }
    private boolean insertarNuevoNodoDerecha (Habitacion habitacion){
        return this.nodoPrincipal.getHabitacion().getValor() + 1 == habitacion.getValor();
    }



    public void recorrerOrdenSolucionLaberinto (){
        recorrerOrdenLaberinto(nodoPrincipal);
    }
    public void recorrerOrdenLaberinto (NodoPrincipal nodoPrincipal){
        if(nodoPrincipal == null){
            return;
        }
        else {
            System.out.println("\n" + nodoPrincipal.getHabitacion().getValor());
            recorrerOrdenLaberinto(nodoPrincipal.getNodoArriba());
            recorrerOrdenLaberinto(nodoPrincipal.getNodoIzquierdo());
            recorrerOrdenLaberinto(nodoPrincipal.getNodoAbajo());
            recorrerOrdenLaberinto(nodoPrincipal.getNodoDerecho());
        }
    }
}

package LaberintoGlobant.Controlador;

import LaberintoGlobant.Laberinto.Habitacion;
import LaberintoGlobant.Laberinto.HabitacionesDelLaberinto;

public class ConexionNodos {

    private NodoPrincipal nodoPrincipal;
    private Controlador controlador;

    public ConexionNodos(Controlador controlador){
        nodoPrincipal = null;
        this.controlador = controlador;
    }

    public void insertarNodosQueComponenAlNodoPrincipal(){
        for (Integer i = 0; i < controlador.getLaberinto().getListaHabitacionesDelLaberinto().size(); i++){
            for (Integer j = 0; j < controlador.getLaberinto().getListaHabitacionesDelLaberinto().get(i)
                    .getListaHabitacionesLaberinto().size(); j++){

                Habitacion habitacion = controlador.getLaberinto().getListaHabitacionesDelLaberinto()
                        .get(i).getListaHabitacionesLaberinto().get(j);
                Integer ejeY = i;
                Integer ejeX = j;

                NodoPrincipal nodoNuevo = new NodoPrincipal(habitacion, controlador);
                if ( habitacion.getTipoHabitacion().equals(Habitacion.TIPO_HABITACION.ENTRADA))
                {
                    if (nodoPrincipal == null){
                        nodoPrincipal = nodoNuevo;
                    }
                }
                else if (habitacion.getTipoHabitacion().equals(Habitacion.TIPO_HABITACION.CAMINO))
                {
                    nodoPrincipal.insertarNuevoNodo(habitacion, nodoNuevo, ejeY, ejeX);
                }
            }
        }
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

package LaberintoGlobant.Controlador;

import LaberintoGlobant.Laberinto.Habitacion;

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
                    nodoPrincipal.insertarNuevoNodo(nodoNuevo, ejeY, ejeX);
                } else if (habitacion.getTipoHabitacion().equals(Habitacion.TIPO_HABITACION.SALIDA)) {
                    nodoPrincipal.insertarNuevoNodo(nodoNuevo, ejeY, ejeX);
                }
            }
        }
    }





    public void recorrerOrdenSolucionLaberinto (){
        recorrerCaminoDeLaDerecha(nodoPrincipal);
    }

    public void recorrerCaminoDeLaDerecha (NodoPrincipal nodoPrincipal){
        if(nodoPrincipal == null){
            return;
        }
        else {
            condicionSalidaLaberinto(nodoPrincipal.getHabitacion().getTipoHabitacion());
            System.out.println(nodoPrincipal.getHabitacion().getTipoHabitacion());
            recorrerCaminoDeLaDerecha(nodoPrincipal.getNodoDerecho());
        }
    }
    public void condicionSalidaLaberinto (Habitacion.TIPO_HABITACION tipoHabitacion){
        if(tipoHabitacion.equals(Habitacion.TIPO_HABITACION.SALIDA)){
            System.out.println("Felicidades Terminaste e Juego Automaticamente");
        }
    }
}

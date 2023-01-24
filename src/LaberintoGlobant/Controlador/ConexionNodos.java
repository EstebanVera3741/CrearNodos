package LaberintoGlobant.Controlador;

import LaberintoGlobant.Laberinto.Habitacion;
import LaberintoGlobant.Laberinto.HabitacionesDelLaberinto;

public class ConexionNodos {

    private NodoPrincipal inicioNodoPadre;
    private Controlador controlador;

    public ConexionNodos(Controlador controlador){
        inicioNodoPadre = null;
        this.controlador = controlador;
    }

    public void insertarNuevoNodoPrincipal (){
        insertarNodoPrincipalBuscandoHabitacionEntreda();
        insertarNodosQueComponenAlNodoPrincipal();
    }
    private void insertarNodoPrincipalBuscandoHabitacionEntreda (){
        for (HabitacionesDelLaberinto filasLaberinto : controlador.getLaberinto().getListaHabitacionesDelLaberinto()){
            for (Habitacion habitacion: filasLaberinto.getListaHabitacionesLaberinto()){
                if (inicioNodoPadre == null && habitacion.getTipoHabitacion().equals(Habitacion.TIPO_HABITACION.ENTRADA))
                {
                    inicioNodoPadre = new NodoPrincipal(habitacion, controlador);
                }
            }
        }
    }
    private void insertarNodosQueComponenAlNodoPrincipal(){
        for (HabitacionesDelLaberinto filasLaberinto : controlador.getLaberinto().getListaHabitacionesDelLaberinto()){
            for (Habitacion habitacion: filasLaberinto.getListaHabitacionesLaberinto()){
                if (habitacion.getTipoHabitacion().equals(Habitacion.TIPO_HABITACION.CAMINO))
                {
                    inicioNodoPadre.insertarNuevoNodo(habitacion);
                }
            }
        }
    }



    public void recorrerOrdenSolucionLaberinto (){
        recorrerOrdenLaberinto(inicioNodoPadre);
    }
    public void recorrerOrdenLaberinto (NodoPrincipal nodoPrincipal){
        if(nodoPrincipal == null){
            return;
        }
        else {
            System.out.println("\n" + nodoPrincipal.getControlador().getLaberinto().getListaHabitacionesDelLaberinto()
                    .get(1).getListaHabitacionesLaberinto().get(1).getValor());
            recorrerOrdenLaberinto(nodoPrincipal.getNodoArriba());
            System.out.println("\n" + nodoPrincipal.getHabitacionLaberinto().getValor());
            recorrerOrdenLaberinto(nodoPrincipal.getNodoIzquierdo());
            System.out.println("\n" + nodoPrincipal.getHabitacionLaberinto().getValor());
            recorrerOrdenLaberinto(nodoPrincipal.getNodoAbajo());
            System.out.println("\n" + nodoPrincipal.getHabitacionLaberinto().getValor());
            recorrerOrdenLaberinto(nodoPrincipal.getNodoDerecho());
            System.out.println("\n" + nodoPrincipal.getHabitacionLaberinto().getValor());
        }
    }
    public Controlador getControlador() {
        return controlador;
    }
    public NodoPrincipal getInicioNodoPadre() {
        return inicioNodoPadre;
    }
}

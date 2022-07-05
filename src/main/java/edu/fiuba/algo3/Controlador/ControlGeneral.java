package edu.fiuba.algo3.Controlador;
import edu.fiuba.algo3.Modelo.Vehiculo;
import  edu.fiuba.algo3.Vista.Juego;
import  edu.fiuba.algo3.Modelo.Gameplay;

public class ControlGeneral{
    private Juego juego  = new Juego();
    private Gameplay gameplay = new Gameplay();
    private HandlerMoverVehiculo movimientosHandle;

    public ControlGeneral() throws Exception {

        String vehiculoSeleccionado = this.juego.preguntarVehiculo();
        String usuario = this.juego.getNombreDeUsuario();

        this.gameplay.registrarUsuario(usuario, vehiculoSeleccionado);
        this.juego.setDimension(this.gameplay.getDimension());
        this.movimientosHandle = new HandlerMoverVehiculo(this.gameplay);
        this.juego.jugar(this.movimientosHandle);


    }
}

package elementos;

import com.badlogic.gdx.graphics.Texture;

import comun.Constantes;
import comun.Posicion;

public class PuertaVertical extends Puerta{
	
	public PuertaVertical(Texture imagen, Posicion posicion) {
		super(imagen, posicion);
	}

	public void moviminetoAbrirArriba() {
		moverAbrir.setPosition(this.posicion.x, this.posicion.y + imagen.getHeight());
		moverAbrir.setDuration(Constantes.MOVIMIENTO_PUERTA_ACCION);
	}
	
	public void moviminetoAbrirAbajo() {
		moverAbrir.setPosition(this.posicion.x, this.posicion.y - imagen.getHeight());
		moverAbrir.setDuration(Constantes.MOVIMIENTO_PUERTA_ACCION);
	}

}

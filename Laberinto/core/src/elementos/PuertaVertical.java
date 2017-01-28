package elementos;

import com.badlogic.gdx.graphics.Texture;

import comun.Constantes;
import comun.Posicion;

public class PuertaVertical extends Puerta{

	public PuertaVertical(Texture imagen, Posicion posicion) {
		super(imagen, posicion);
	}

	@Override
	protected void moviminetoAbrir() {
		moverAbrir.setPosition(this.posicion.x, this.posicion.y - Constantes.MOVIMIENTO_PUERTA);
		moverAbrir.setDuration(Constantes.MOVIMIENTO_PUERTA_ACCION);
	}

}

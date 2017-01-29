package elementos;

import com.badlogic.gdx.graphics.Texture;

import comun.Constantes;
import comun.Posicion;

public class PuertaHorizontal extends Puerta {
	
	public PuertaHorizontal(Texture imagen, Posicion posicion) {
		super(imagen, posicion);
	}

	@Override
	protected void moviminetoAbrir() {
		moverAbrir.setPosition(this.posicion.x - imagen.getWidth(), this.posicion.y);
		moverAbrir.setDuration(Constantes.MOVIMIENTO_PUERTA_ACCION);
	}

}

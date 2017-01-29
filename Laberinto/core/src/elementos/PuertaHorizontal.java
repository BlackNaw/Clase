package elementos;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;

import comun.Constantes;
import comun.Posicion;

public class PuertaHorizontal extends Puerta {
	
	public PuertaHorizontal(Texture imagen, Posicion posicion) {
		super(imagen, posicion);
	}

	public void moviminetoAbrirDerecha() {
		moverAbrir.setPosition(this.posicion.x + imagen.getWidth(), this.posicion.y);
		moverAbrir.setDuration(generarNumero());
	}
	
	public void moviminetoAbrirIzquierda() {
		moverAbrir.setPosition(this.posicion.x - imagen.getWidth(), this.posicion.y);
		moverAbrir.setDuration(generarNumero());
	}

}

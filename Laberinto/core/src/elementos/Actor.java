package elementos;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;

import Interfaces.Actualizable;
import Interfaces.Colisionable;
import Interfaces.Movible;
import Interfaces.Pintable;
import comun.Posicion;
import comun.Rectangulo;

public class Actor extends Elemento implements Actualizable, Colisionable {

	MoveToAction mover;
	
	public Actor(Posicion posicion, Texture imagen) {
		super(posicion, imagen);
		mover = new MoveToAction();
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		batch.draw(imagen, posicion.x, posicion.y);
	}
	
	/**
	 * Modificar la posicion y comprobar colision
	 */
	@Override
	public boolean actualizar(Rectangulo cuerpo) {
		return comprobarColision(cuerpo);
	}

	@Override
	public void act(float delta) {
		super.act(delta);
		moveBy(posicion.x, posicion.y);
	}

	public boolean enLimitesPantalla(Rectangulo mayor){
		return cuerpo.contiene(mayor);
	}

	@Override
	public boolean comprobarColision(Rectangulo cuerpo) {
		return this.cuerpo.colision(cuerpo);
	}

}

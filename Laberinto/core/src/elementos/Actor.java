package elementos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;

import Interfaces.Actualizable;
import Interfaces.Colisionable;
import Interfaces.Movible;
import Interfaces.Pintable;
import comun.Posicion;
import comun.Rectangulo;

public class Actor extends Elemento implements Colisionable {
	private float elapsedTime=0;
	
	public Actor(Posicion posicion, Animation animation) {
		super(posicion, animation);
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		elapsedTime += Gdx.graphics.getDeltaTime();
		batch.draw((TextureRegion)animation.getKeyFrame(elapsedTime, true), posicion.x, posicion.y);
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

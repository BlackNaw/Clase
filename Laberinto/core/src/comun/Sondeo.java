package comun;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;

import elementos.Actor;

public class Sondeo {

	/*static Texture up = new Texture(Gdx.files.internal("hansito/hansitoUp.png"));
	static Texture down = new Texture(Gdx.files.internal("hansito/hansitoDown.png"));
	static Texture left = new Texture(Gdx.files.internal("hansito/hansitoLeft.png"));
	static Texture right = new Texture(Gdx.files.internal("hansito/hansitoRight.png"));*/
	
	static Animation up=AnimationE.getAnimation(AnimationE.up);
	static Animation down=AnimationE.getAnimation(AnimationE.down);
	static Animation left=AnimationE.getAnimation(AnimationE.left);
	static Animation right=AnimationE.getAnimation(AnimationE.right);

	static Direccion direccion;
	
	public static void detectar(Actor actor, boolean salido) {

		if (Gdx.input.isKeyPressed(Keys.LEFT)) {
				actor.posicion.x -= Constantes.VELOCIDAD_PERSONAJE;
				actor.animation = left;
				direccion = Direccion.oeste;
		}
		if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
				actor.posicion.x += Constantes.VELOCIDAD_PERSONAJE;
				actor.animation = right;
				direccion = Direccion.este;
		}
		if (Gdx.input.isKeyPressed(Keys.UP)) {
				actor.posicion.y += Constantes.VELOCIDAD_PERSONAJE;
				actor.animation = up;
				direccion = Direccion.norte;
		}
		if (Gdx.input.isKeyPressed(Keys.DOWN)) {
				actor.posicion.y -= Constantes.VELOCIDAD_PERSONAJE;
				actor.animation = down;
				direccion = Direccion.sur;
		}
	}
}

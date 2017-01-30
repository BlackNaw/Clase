package comun;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;

import elementos.Actor;

public class Sondeo {


	/*static Texture upStop = new Texture(Gdx.files.internal("hansito/hansitoUp.png"));
	static Texture downStop = new Texture(Gdx.files.internal("hansito/hansitoDown.png"));
	static Texture leftStop = new Texture(Gdx.files.internal("hansito/hansitoLeft.png")); 
	static Texture rightStop = new Texture(Gdx.files.internal("hansito/hansitoRight.png"));*/

	static Animation up = AnimationE.getAnimation(AnimationE.up);
	static Animation down = AnimationE.getAnimation(AnimationE.down);
	static Animation left = AnimationE.getAnimation(AnimationE.left);
	static Animation right = AnimationE.getAnimation(AnimationE.right);
	
	static Animation upStop = AnimationE.getAnimation(AnimationE.upStop);
	static Animation downStop = AnimationE.getAnimation(AnimationE.downStop);
	static Animation leftStop = AnimationE.getAnimation(AnimationE.leftStop);
	static Animation rightStop = AnimationE.getAnimation(AnimationE.rightStop);


	static Direccion direccion;
	//                        left   right  up     down
	//static boolean[] pulsada={false, false, false, false};

	public static void detectar(Actor actor, boolean salido) {

		if (Gdx.input.isKeyPressed(Keys.LEFT)) {
			//pulsada[0]=true;
			if (!salido) {
				actor.posicion.x -= Constantes.VELOCIDAD_PERSONAJE;
				actor.animation = left;
				direccion = Direccion.oeste;
			} else {
				//actor.posicion.x=100;
				actor.posicion.x+=2;
				//actor.posicion.x += 1;

				//salido=false;
			}
		}else{
			//pulsada[0]=false;
			if (direccion==Direccion.oeste) {
				actor.animation=leftStop;
			}
		}
		if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			//pulsada[1]=true;
			if (!salido) {
				actor.posicion.x += Constantes.VELOCIDAD_PERSONAJE;
				actor.animation = right;
				direccion = Direccion.este;
			}else {
				actor.posicion.x-=2;
				//actor.posicion.x -= 1;
				//salido=false;
			}
		}else{
			//pulsada[1]=false;
			if (direccion==Direccion.este) {
				actor.animation=rightStop;
			}
		}
		if (Gdx.input.isKeyPressed(Keys.UP)) {
			//pulsada[2]=true;
			if (!salido) {
				actor.posicion.y += Constantes.VELOCIDAD_PERSONAJE;
				actor.animation = up;
				direccion = Direccion.norte;
			} else {
				actor.posicion.y-=2;
				//actor.posicion.y -=1;
				//salido=false;
			}

		}else{
			//pulsada[2]=false;
			if (direccion==Direccion.norte) {
				actor.animation=upStop;
			}
		}
		if (Gdx.input.isKeyPressed(Keys.DOWN)) {
			//pulsada[3]=true;
			if (!salido) {
				actor.posicion.y -= Constantes.VELOCIDAD_PERSONAJE;
				actor.animation = down;
				direccion = Direccion.sur;
			}else {

				actor.posicion.y+=2;
				//actor.posicion.y += 1;
				//salido=false;
			}

		}else{
			//pulsada[3]=false;
			if (direccion==Direccion.sur) {
				actor.animation=downStop;
			}
		}
	}
}


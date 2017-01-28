package comun;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;

import elementos.Actor;

public class Sondeo {

	static Texture up = new Texture(Gdx.files.internal("hansito/hansitoUp.png"));
	static Texture down = new Texture(Gdx.files.internal("hansito/hansitoDown.png"));
	static Texture left = new Texture(Gdx.files.internal("hansito/hansitoLeft.png"));
	static Texture right = new Texture(Gdx.files.internal("hansito/hansitoRight.png"));

	static Direccion direccion;

	static void anularDireccion(Direccion direccion){
		if(Direccion.norte == direccion){
			direccion.norte.setDireccion(false);
			direccion.sur.setDireccion(true);
			direccion.este.setDireccion(true);
			direccion.oeste.setDireccion(true);
		}if(Direccion.sur == direccion){
			direccion.norte.setDireccion(true);
			direccion.sur.setDireccion(false);
			direccion.este.setDireccion(true);
			direccion.oeste.setDireccion(true);
		}if(Direccion.este == direccion){
			direccion.norte.setDireccion(true);
			direccion.sur.setDireccion(true);
			direccion.este.setDireccion(false);
			direccion.oeste.setDireccion(true);
		}if(Direccion.oeste == direccion){
			direccion.norte.setDireccion(true);
			direccion.sur.setDireccion(true);
			direccion.este.setDireccion(true);
			direccion.oeste.setDireccion(false);
		}
	}
	
	public static void detectar(Actor actor, boolean salido) {

		if (Gdx.input.isKeyPressed(Keys.LEFT)) {
			if (direccion.oeste.direccionValida) {
				if(salido){
					anularDireccion(Direccion.oeste);
				}
				actor.posicion.x--;
				actor.imagen = left;
				direccion = Direccion.oeste;
			}
		}
		if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			if (direccion.este.direccionValida) {
				if(salido){
					anularDireccion(Direccion.este);
				}
				actor.posicion.x++;
				actor.imagen = right;
				direccion = Direccion.este;
			}
		}
		if (Gdx.input.isKeyPressed(Keys.UP)) {
			if (direccion.norte.direccionValida) {
				if(salido){
					anularDireccion(Direccion.norte);
				}
				actor.posicion.y++;
				actor.imagen = up;
				direccion = Direccion.norte;
			}
		}
		if (Gdx.input.isKeyPressed(Keys.DOWN)) {
			if (direccion.sur.direccionValida) {
				if(salido){
					anularDireccion(Direccion.sur);
				}
				actor.posicion.y--;
				actor.imagen = down;
				direccion = Direccion.sur;
			}
		}
	}
}

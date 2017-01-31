package comun;

import java.time.temporal.JulianFields;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;

import elementos.Actor;

public class HUD implements Disposable{
	private BitmapFont font;
	public static boolean nivel=true;
	public static int puntuaciones=0;
	public static Integer highScore;
	private Texture azul,verde;
	float tamanoVida=90f;
	Actor actor;
	
	public HUD(Actor actor){	
		this.actor = actor;
		verde=new Texture("imagenes/verde.png");
		azul=new Texture("imagenes/azul.png");
		this.font=new BitmapFont(Gdx.files.internal("fuentes/arcade.fnt"));
	}

	public void pintar(SpriteBatch batch, Camera camera) {
		batch.draw(verde, camera.position.x-Gdx.graphics.getWidth()/2+10,  camera.position.y-Gdx.graphics.getHeight()/2+10,100,30);
		batch.draw(azul, camera.position.x-Gdx.graphics.getWidth()/2+15,camera.position.y-Gdx.graphics.getHeight()/2+15,tamanoVida*(actor.vidas/Constantes.VIDA_JUGADOR),20);
		//font.draw(batch, "Llaves :"+Jugador.llaves.size(),camera.position.x-Gdx.graphics.getWidth()/2+20, camera.position.y+Gdx.graphics.getHeight()/2-10); 
		font.draw(batch, "Monedas : "+actor.monedas, camera.position.x+Gdx.graphics.getWidth()/2-200, camera.position.y+Gdx.graphics.getHeight()/2-10);
	}

	@Override
	public void dispose() {
		font.dispose();
	}
}

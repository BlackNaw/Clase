package comun;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;

import elementos.Elemento;

public class Disparo extends Elemento {

	private float elapsedTime;

	MoveByAction mover = new MoveByAction();
	
	private int anchoRecorrido;

	public Disparo(Posicion posicion, int ancho,String trampa) {
		super(posicion, new Animation(1 / 30f, new TextureAtlas(Gdx.files.internal("disparo/disparo.atlas"))
				.findRegions("Custom Edited - Mario Customs - Bullet Bill")));
		generarMovimiento(trampa, ancho);
		mover.setDuration(generarNumero());
		System.out.println("creado");
		this.addAction(mover);
	}
	
	private void generarMovimiento(String trampa, int ancho) {
		if (trampa.startsWith("TrampaDerecha")) {
			this.setX(posicion.x);
			this.setY(posicion.y);
			anchoRecorrido = ancho + posicion.x;
			mover.setAmountX(ancho);
		} else if (trampa.startsWith("TrampaIzquierda")) {
			this.setX(posicion.x + ancho);
			this.setY(posicion.y);
			anchoRecorrido = ancho - posicion.x;
			mover.setAmountX(posicion.x + ancho);
		}/* else if (trampa.startsWith("TrampaArriba")) {
			mover.setPosition(this.posicion.x, this.posicion.y + imagen.getHeight());
		} else if (trampa.startsWith("TrampaAbajo")) {
			mover.setPosition(this.posicion.x, this.posicion.y - imagen.getHeight());
		}*/
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
			super.draw(batch, parentAlpha);
			elapsedTime += Gdx.graphics.getDeltaTime();
			batch.draw((TextureRegion) animation.getKeyFrame(elapsedTime, true), this.getX(), this.getY());
	}

	@Override
	public void act(float delta) {
		super.act(delta);
		posicion.x = (int) this.getX();
		posicion.y = (int) this.getY();		
	}

	public boolean accionFinalizada() {
		return posicion.x >= (anchoRecorrido - 10);
	}
	
	public float generarNumero() {
		float numero = (float) new Random().nextInt(3);
		if (numero < 1) {
			numero = 1;
		}
		return numero;
	}
	
}

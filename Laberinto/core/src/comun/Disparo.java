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

	private int recorrido;

	MoveByAction mover = new MoveByAction();

	private boolean horizontal = true;

	public Disparo(Posicion posicion, int ancho, int alto, String trampa) {
		super(posicion, new Animation(1 / 30f, new TextureAtlas(Gdx.files.internal("disparo/disparo.atlas"))
				.findRegions("Custom Edited - Mario Customs - Bullet Bill")));
		generarMovimiento(trampa, ancho, alto);
		mover.setDuration(generarNumero());
		this.addAction(mover);
	}

	private void generarMovimiento(String trampa, int ancho, int alto) {
		if (trampa.startsWith("TrampaDerecha")) {
			this.setX(posicion.x);
			this.setY(posicion.y);
			mover.setAmountX(ancho);
			recorrido = ancho + posicion.x;
		} else if (trampa.startsWith("TrampaIzquierda")) {
			this.setX(posicion.x + ancho);
			this.setY(posicion.y);
			mover.setAmountX(-ancho);
			recorrido = posicion.x;
		} else if (trampa.startsWith("TrampaArriba")) {
			this.setX(posicion.x);
			this.setY(posicion.y);
			mover.setAmountY(alto);
			recorrido = posicion.y + alto;
			horizontal = false;
		} else if (trampa.startsWith("TrampaAbajo")) {
			this.setX(posicion.x);
			this.setY(posicion.y + alto);
			mover.setAmountY(-alto);
			recorrido = posicion.y;
			horizontal = false;
		}
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
		if (horizontal) {
			return this.getX() > (recorrido - 6) && this.getX() < (recorrido + 6);
		} else {
			return this.getY() > (recorrido - 6) && this.getY() < (recorrido + 6);
		}
	}

	public float generarNumero() {
		float numero = (float) new Random().nextInt(3);
		if (numero < 1) {
			numero = 1;
		}
		return numero;
	}

}

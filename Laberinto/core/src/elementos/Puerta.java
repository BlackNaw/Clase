package elementos;

import java.util.Iterator;
import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.RepeatAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;

import Interfaces.Pintable;
import comun.Constantes;
import comun.Posicion;

public class Puerta extends Elemento {

	protected MoveToAction moverAbrir = new MoveToAction();

	protected MoveToAction moverCerrar = new MoveToAction();

	protected SequenceAction secuencia = new SequenceAction(moverAbrir, moverCerrar);

	protected RepeatAction repeticion = new RepeatAction();

	public Puerta() {
		// TODO Auto-generated constructor stub
	}
	
	public Puerta(Posicion posicion, Texture imagen, String puerta) {
		super(posicion, imagen);
		setBounds(this.posicion.x, this.posicion.y, imagen.getWidth(), imagen.getHeight());
		moverCerrar.setPosition(this.posicion.x, this.posicion.y);
		moverCerrar.setDuration(generarNumero());
		generarMovimiento(puerta);
		moverAbrir.setDuration(generarNumero());
		repeticion.setCount(RepeatAction.FOREVER);
		repeticion.setAction(secuencia);
		this.addAction(repeticion);
	}

	public void moviminetoAbrirDerecha() {
		moverAbrir.setPosition(this.posicion.x + imagen.getWidth(), this.posicion.y);
		moverAbrir.setDuration(generarNumero());
	}

	public void moviminetoAbrirIzquierda() {
		moverAbrir.setPosition(this.posicion.x - imagen.getWidth(), this.posicion.y);
		moverAbrir.setDuration(generarNumero());
	}

	public static Texture obtenerImagenPuerta(String puerta) {
		if (puerta.startsWith("PuertaHorizontalDerecha")) {
			return new Texture("muroHorizontalMediano.jpg");
		} else if (puerta.startsWith("PuertaHorizontalIzquierda")) {
			return new Texture("muroHorizontalMediano.jpg");
		} else if (puerta.startsWith("PuertaVerticalArriba")) {
			return new Texture("muroVerticalMediano.jpg");
		} else if (puerta.startsWith("PuertaVerticalAbajo")) {
			return new Texture("muroVerticalMediano.jpg");
		}
		return null;
	}
	
	private void generarMovimiento(String puerta) {
		if (puerta.startsWith("PuertaHorizontalDerecha")) {
			moverAbrir.setPosition(this.posicion.x + imagen.getWidth(), this.posicion.y);
		} else if (puerta.startsWith("PuertaHorizontalIzquierda")) {
			moverAbrir.setPosition(this.posicion.x - imagen.getWidth(), this.posicion.y);
		} else if (puerta.startsWith("PuertaVerticalArriba")) {
			moverAbrir.setPosition(this.posicion.x, this.posicion.y + imagen.getHeight());
		} else if (puerta.startsWith("PuertaVerticalAbajo")) {
			moverAbrir.setPosition(this.posicion.x, this.posicion.y - imagen.getHeight());
		}
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		batch.draw(imagen, this.getX(), this.getY(), this.getOriginX(), this.getOriginY(), this.getWidth(),
				this.getHeight(), this.getScaleX(), this.getScaleY(), this.getRotation(), 0, 0, imagen.getWidth(),
				imagen.getHeight(), false, false);
	}

	@Override
	public void act(float delta) {
		for (Iterator<Action> iter = this.getActions().iterator(); iter.hasNext();) {
			iter.next().act(delta);
		}
		posicion.x = (int) this.getX();
		posicion.y = (int) this.getY();
	}

	public float generarNumero() {
		float numero = (float) new Random().nextInt(3);
		if (numero < 1) {
			numero = 1;
		}
		return numero;
	}

}

package elementos;

import java.util.Iterator;

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

public abstract class Puerta extends Elemento {

	protected MoveToAction moverAbrir = new MoveToAction();
	
	protected MoveToAction moverCerrar = new MoveToAction();
	
	protected SequenceAction secuencia = new SequenceAction(moverAbrir, moverCerrar);
	
	protected RepeatAction repeticion = new RepeatAction();
	
	public Puerta(Texture imagen, Posicion posicion) {
		super(posicion, imagen);
		setBounds(this.posicion.x, this.posicion.y, imagen.getWidth(), imagen.getHeight());
		moverCerrar.setPosition(this.posicion.x, this.posicion.y);
		moverCerrar.setDuration(Constantes.MOVIMIENTO_PUERTA_ACCION);
		repeticion.setCount(RepeatAction.FOREVER);
		repeticion.setAction(secuencia);
		this.addAction(repeticion);
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
	
}

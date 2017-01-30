package comun;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;

import elementos.Elemento;

public class Disparo extends Elemento {

	private float elapsedTime;

	MoveByAction mover = new MoveByAction();

	public Disparo(Posicion posicion, int ancho) {
		super(posicion, new Animation(1 / 30f, new TextureAtlas(Gdx.files.internal("disparo/disparo.atlas"))
				.findRegions("Custom Edited - Mario Customs - Bullet Bill")));
		this.setX(posicion.x);
		this.setY(posicion.y);
		mover.setAmountX(ancho);
		mover.setDuration(3);
		System.out.println("creado");
		this.addAction(mover);
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

}

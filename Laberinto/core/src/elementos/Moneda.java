package elementos;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Rectangle;

import comun.Posicion;

public class Moneda extends Elemento{

	public ArrayList<Rectangle> respawn = new ArrayList<Rectangle>();
	
	private float elapsedTime = 0;
	
	public Moneda(Posicion posicion, Animation animation) {
		super(posicion, animation);
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		elapsedTime += Gdx.graphics.getDeltaTime();
		batch.draw((TextureRegion)animation.getKeyFrame(elapsedTime, true), posicion.x, posicion.y);
	}
	
	public void colocar() {
		//TODO esto nose si lo hace bien
		Rectangle respawn = this.respawn.get(new Random().nextInt(this.respawn.size()));
		Random random = new Random();
		int x =  (int) (random.nextInt((int) respawn.getX()) + respawn.getWidth());
		int y = (int) (random.nextInt((int) respawn.getY()) + respawn.getHeight());
		this.setX(x);
		this.setY(y);
		System.out.println("x " + getX());
		System.out.println("y " + getY());
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
		this.posicion.x = (int) getX();
		this.posicion.y = (int) getY();
	}
	
}

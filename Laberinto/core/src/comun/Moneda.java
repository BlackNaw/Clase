package comun;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Rectangle;

import elementos.Elemento;

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
		int x =  (int) Math.random() * (int)((respawn.x + respawn.getWidth()) - respawn.x) + (int)  respawn.x;
		int y =   (int) Math.random() * (int)((respawn.y + respawn.getWidth()) - respawn.y) + (int)  respawn.y;
		this.posicion.x = x;
		this.posicion.y = y;
		System.out.println("x " + posicion.x);
		System.out.println(posicion.y);
	}
	
}

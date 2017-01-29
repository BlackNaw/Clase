package comun;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.objects.RectangleMapObject;

import elementos.Elemento;

public class Moneda extends Elemento{

	ArrayList<RectangleMapObject> respawn = new ArrayList<RectangleMapObject>();
	
	public Moneda(Posicion posicion, Animation animation) {
		super(posicion, animation);
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		batch.draw((TextureRegion)animation.getKeyFrame(parentAlpha, true), posicion.x, posicion.y);
	}
	
	public void colocar() {
		RectangleMapObject respawn = this.respawn.get(new Random().nextInt(this.respawn.size()));
		int x =  (int) ((Math.random()*respawn.getRectangle().x) + (respawn.getRectangle().x + respawn.getRectangle().getWidth()));
		int y =  (int) ((Math.random()*respawn.getRectangle().y) + (respawn.getRectangle().y + respawn.getRectangle().getWidth()));
		this.posicion.x = x;
		this.posicion.y = y;
	}
	
}

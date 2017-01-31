package comun;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.Disposable;

public class Letras implements Disposable{

	BitmapFont bitmapFont;

	public Letras(String nombreFichero) {
		bitmapFont = new BitmapFont(Gdx.files.internal(nombreFichero));
	}
	
	public void pintarPantalla(Batch batch, String frase,Camera camara) {
		bitmapFont.draw(batch, frase, camara.position.x-Gdx.graphics.getWidth()/2+10,  camara.position.y-Gdx.graphics.getHeight()/2);
	}

	@Override
	public void dispose() {
		bitmapFont.dispose();
	}
	
}

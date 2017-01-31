package comun;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.Disposable;

public class Letras implements Disposable{

	BitmapFont bitmapFont;

	public Letras(String nombreFichero) {
		bitmapFont = new BitmapFont(Gdx.files.internal(nombreFichero));
	}
	
	public void pintarPantalla(Batch batch, String frase, int altoPantalla) {
		bitmapFont.draw(batch, frase, 0, altoPantalla);
	}

	@Override
	public void dispose() {
		bitmapFont.dispose();
	}
	
}

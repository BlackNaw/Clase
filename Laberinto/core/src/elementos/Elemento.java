package elementos;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;

import comun.Posicion;
import comun.Rectangulo;

public class Elemento extends Actor implements Disposable {

public Posicion posicion;
public Texture imagen;
public TextureRegion textureRegion;
public Animation animation;
public Rectangulo cuerpo;

public Elemento(){}

public Elemento(Posicion posicion, Texture imagen) {
	super();
	this.posicion = posicion;
	this.imagen = imagen;
	cuerpo = new Rectangulo(this.posicion, imagen.getWidth(), imagen.getHeight());
}

public Elemento(Posicion posicion, Animation animation) {
	super();
	this.posicion = posicion;
	this.animation = animation;
	//((AtlasRegion)animacion.getKeyFrames()[0]).getRegionHeight()
	//cuerpo = new Rectangulo(this.posicion, animation.getWidth(), animation.getHeight());
	cuerpo = new Rectangulo(this.posicion, ((AtlasRegion)animation.getKeyFrames()[0]).getRegionWidth(), ((AtlasRegion)animation.getKeyFrames()[0]).getRegionHeight());
}


public Elemento(Posicion posicion, TextureRegion region) {
	super();
	this.posicion = posicion;
	this.textureRegion = region;
	cuerpo = new Rectangulo(this.posicion, 0, 0);
}

public Elemento(Posicion posicion, int ancho, int alto) {
	super();
	this.posicion = posicion;
	cuerpo = new Rectangulo(this.posicion, ancho, alto);
}

@Override
public void dispose() {
	if(imagen!=null){
	imagen.dispose();
	}
}

}

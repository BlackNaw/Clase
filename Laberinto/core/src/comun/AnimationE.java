package comun;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public enum AnimationE {
	up("HANSUP"), down("HANSDOWN"), left("HANSLEFT"), right("HANSRIGHT");
	private String titulo;
	Animation animation;
	TextureAtlas textureAtlas;
	
	private AnimationE(String titulo){
		this.titulo=titulo;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return titulo;
	}
	
	public static Animation getAnimation(AnimationE animationE){
		String titulo=animationE.toString();
		TextureAtlas textureAtlas=new TextureAtlas(Gdx.files.internal("hansAtlas/HANS.atlas"));
		return new Animation(1/5f, textureAtlas.findRegions(titulo));
	}
	
}

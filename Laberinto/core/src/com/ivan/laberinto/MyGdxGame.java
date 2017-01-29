package com.ivan.laberinto;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;

import comun.AnimationE;
import comun.Moneda;
import comun.Posicion;
import comun.Rectangulo;
import comun.Sondeo;
import elementos.Actor;
import elementos.Puerta;

public class MyGdxGame extends ApplicationAdapter {

	//TODO aqui creo que hay demasiadas propiedades

	TiledMapRenderer tiledMapRenderer;

	TiledMap tiledMap;

	Sprite sprite;

	SpriteBatch batch;

	Stage escenario;

	OrthographicCamera camara;

	Actor actor;

	Texture pantalla;

	ArrayList<Rectangulo> muro = new ArrayList<Rectangulo>();

	ArrayList<Puerta> puertas = new ArrayList<Puerta>();

	Moneda modeda;

	@Override
	public void create() {
		batch = new SpriteBatch();
		pantalla = new Texture("stone-wall-tiled-multiple.png");
		sprite = new Sprite(pantalla);
		//TODO las animaciones no van bien
		Animation animacion = new Animation(1 / 30f, new TextureAtlas(Gdx.files.internal("coinAtlas/COIN.atlas")).findRegions("COIN"));
		modeda = new Moneda(new Posicion(), animacion);
		actor = new Actor(new Posicion(100, 100), AnimationE.getAnimation(AnimationE.up));
		escenario = new Stage();
		escenario.addActor(actor);
		escenario.addActor(modeda);
		camara = new OrthographicCamera(Gdx.graphics.getWidth() * 2, Gdx.graphics.getHeight() * 2);
		camara = (OrthographicCamera) escenario.getViewport().getCamera();
		tiledMap = new TmxMapLoader().load("MapaDavid.tmx");
		obtenerElementosMapa();
		modeda.colocar();
		tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
	}

	private void obtenerElementosMapa() {
		for (MapObject elemento : tiledMap.getLayers().get(1).getObjects()) {
			if (elemento.getName() != null) {
				int alto = (int) ((RectangleMapObject) elemento).getRectangle().height;
				int ancho = (int) ((RectangleMapObject) elemento).getRectangle().width;
				if (elemento.getName().startsWith("Puerta")) {
					Puerta puerta = new Puerta(obtenerPosicion(elemento), Puerta.obtenerImagenPuerta(elemento.getName()), elemento.getName());
					escenario.addActor(puerta);
					puertas.add(puerta);
				} else if (elemento.getName().startsWith("Muro")) {
					muro.add(new Rectangulo(obtenerPosicion(elemento), ancho, alto));
				} else if (elemento.getName().startsWith("Respawn")) {
					Rectangle rectangulo = ((RectangleMapObject) elemento).getRectangle();
					modeda.respawn.add(rectangulo);
				}
			}
		}
	}

	private Posicion obtenerPosicion(MapObject elemento) {
		int x = (int) ((RectangleMapObject) elemento).getRectangle().x;
		int y = (int) ((RectangleMapObject) elemento).getRectangle().y;
		return new Posicion(x, y);
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if (!comprobarColisionLimites()) {
			Sondeo.detectar(actor, false);
		} else {
			Sondeo.detectar(actor, true);
		}
		comprobarMoneda();
		camara.position.x = actor.posicion.x;
		camara.position.y = actor.posicion.y;
		camara.update();
		batch.setProjectionMatrix(camara.combined);
		batch.begin();
		sprite.draw(batch);
		batch.end();
		tiledMapRenderer.setView(camara);
		tiledMapRenderer.render();
		escenario.act();
		escenario.draw();
	}

	protected void comprobarMoneda() {
		if (actor.comprobarColision(modeda.cuerpo)){
			modeda.colocar();
		}
	}

	protected boolean comprobarColisionLimites() {
		//TODO falta los limites de la pantalla
		for (Rectangulo rectangulo : muro) {
			if (actor.comprobarColision(rectangulo)) {
				System.out.println("has chocao con un muro");
				return true;
			}
		}
		for (Puerta puerta : puertas) {
			if (actor.comprobarColision(
					new Rectangulo(puerta.posicion, puerta.imagen.getWidth(), puerta.imagen.getHeight()))) {
				System.out.println("has chocao con una puerta");
				return true;
			}
		}
		return false;
	}

	@Override
	public void dispose() {
		//TODO aqui supongo que faltan disposear cosas
	}
}

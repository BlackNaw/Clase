package com.ivan.laberinto;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.PolylineMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.objects.TextureMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Polyline;

import elementos.Actor;
import elementos.Elemento;
import elementos.Puerta;

import com.badlogic.gdx.scenes.scene2d.Stage;

import comun.AnimationE;
import comun.Posicion;
import comun.Rectangulo;
import comun.Sondeo;
import elementos.PuertaHorizontal;
import elementos.PuertaVertical;

public class MyGdxGame extends ApplicationAdapter {
	// TODO: Comprobar si esta colisionando
	// TODO: Poner la camara y actualizable

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

	@Override
	public void create() {
		batch = new SpriteBatch();
		pantalla = new Texture("stone-wall-tiled-multiple.png");
		sprite = new Sprite(pantalla);
		//actor = new Actor(new Posicion(100, 100), new Texture(Gdx.files.internal("hansito/hansitoUp.png")));
		actor=new Actor(new Posicion(100, 100), AnimationE.getAnimation(AnimationE.up));
		escenario = new Stage();
		escenario.addActor(actor);
		camara = new OrthographicCamera(Gdx.graphics.getWidth() * 2, Gdx.graphics.getHeight() * 2);
		camara = (OrthographicCamera) escenario.getViewport().getCamera();
		// ------------IVAN---------------------
		// Gdx.input.setInputProcessor(this);
		tiledMap = new TmxMapLoader().load("MapaDavid.tmx");
		for (MapObject elemento : tiledMap.getLayers().get(1).getObjects()) {
			System.out.print(elemento.getName());
			if (elemento.getName() != null) {
				int x = (int) ((RectangleMapObject) elemento).getRectangle().x;
				int y = (int) ((RectangleMapObject) elemento).getRectangle().y;
				int alto = (int) ((RectangleMapObject) elemento).getRectangle().height;
				int ancho = (int) ((RectangleMapObject) elemento).getRectangle().width;
				if (elemento.getName().startsWith("PuertaHorizontalDerecha")) {
					PuertaHorizontal puerta = new PuertaHorizontal(new Texture("muroHorizontalMediano.jpg"),
							new Posicion(x, y));
					puerta.moviminetoAbrirDerecha();
					escenario.addActor(puerta);
					puertas.add(puerta);
				} else if (elemento.getName().startsWith("PuertaHorizontalIzquierda")) {
					PuertaHorizontal puerta = new PuertaHorizontal(new Texture("muroHorizontalMediano.jpg"),
							new Posicion(x, y));
					puerta.moviminetoAbrirIzquierda();
					escenario.addActor(puerta);
					puertas.add(puerta);
				} else if (elemento.getName().startsWith("PuertaVerticalArriba")) {
					PuertaVertical puerta = new PuertaVertical(new Texture("muroVerticalMediano.jpg"),
							new Posicion(x, y));
					puerta.moviminetoAbrirArriba();
					escenario.addActor(puerta);
					puertas.add(puerta);
				} else if (elemento.getName().startsWith("PuertaVerticalAbajo")) {
					PuertaVertical puerta = new PuertaVertical(new Texture("muroVerticalMediano.jpg"),new Posicion(x, y));
					puerta.moviminetoAbrirAbajo();
					escenario.addActor(puerta);
					puertas.add(puerta);
				} else if (elemento.getName().startsWith("Muro")) {
					muro.add(new Rectangulo(new Posicion(x, y), ancho, alto));
				}
			}
		}
		tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if (!comprobarColisionLimites())  {
			Sondeo.detectar(actor, false);
		} else {
			Sondeo.detectar(actor, true);
		}
		
		
		camara.position.x = actor.posicion.x;
		camara.position.y = actor.posicion.y;
		camara.update();
		batch.setProjectionMatrix(camara.combined);
		batch.begin();
		sprite.draw(batch);
		batch.end();
		// ---------------IVAN-------------
		tiledMapRenderer.setView(camara);
		tiledMapRenderer.render();
		escenario.act();
		escenario.draw();
	}

	protected boolean comprobarColisionLimites() {
		for (Rectangulo rectangulo : muro) {
			if (actor.comprobarColision(rectangulo)) {
				System.out.println("has chocao con un muro");
				return true;
			}
		}
		
		for (Puerta puerta : puertas) {
			if (actor.comprobarColision(new Rectangulo(puerta.posicion, puerta.imagen.getWidth(), puerta.imagen.getHeight()))) {
				System.out.println("has chocao con una puerta");
				return true;
			}
		}
		return false;
	}

	@Override
	public void dispose() {

	}
	//
	// @Override
	// public boolean keyDown(int keycode) {
	// // TODO Auto-generated method stub
	// return false;
	// }
	//
	// @Override
	// public boolean keyUp(int keycode) {
	// if (keycode == Input.Keys.LEFT)
	// camera.translate(-32, 0);
	// if (keycode == Input.Keys.RIGHT)
	// camera.translate(32, 0);
	// if (keycode == Input.Keys.UP)
	// camera.translate(0, -32);
	// if (keycode == Input.Keys.DOWN)
	// camera.translate(0, 32);
	// if(keycode == Input.Keys.NUM_1)
	// tiledMap.getLayers().get(0).setVisible(!tiledMap.getLayers().get(0).isVisible());
	// if(keycode == Input.Keys.NUM_2)
	// tiledMap.getLayers().get(1).setVisible(!tiledMap.getLayers().get(1).isVisible());
	// return true;
	// }
	//
	// @Override
	// public boolean keyTyped(char character) {
	// // TODO Auto-generated method stub
	// return false;
	// }
	//
	// @Override
	// public boolean touchDown(int screenX, int screenY, int pointer, int
	// button) {
	// // TODO Auto-generated method stub
	// return false;
	// }
	//
	// @Override
	// public boolean touchUp(int screenX, int screenY, int pointer, int button)
	// {
	// // TODO Auto-generated method stub
	// return false;
	// }
	//
	// @Override
	// public boolean touchDragged(int screenX, int screenY, int pointer) {
	// // TODO Auto-generated method stub
	// return false;
	// }
	//
	// @Override
	// public boolean mouseMoved(int screenX, int screenY) {
	// // TODO Auto-generated method stub
	// return false;
	// }
	//
	// @Override
	// public boolean scrolled(int amount) {
	// // TODO Auto-generated method stub
	// return false;
	// }
}

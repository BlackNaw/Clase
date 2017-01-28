package com.ivan.laberinto;

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
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import elementos.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

import comun.Posicion;
import comun.Rectangulo;
import comun.Sondeo;
import elementos.PuertaHorizontal;
import elementos.PuertaVertical;

public class MyGdxGame extends ApplicationAdapter {
	// TODO: Comprobar si esta colisionando
	// TODO: Poner la camara y actualizable
	// TODO: ArrayList de textura de paredes

	// TiledMapRenderer tiledMapRenderer;
	// TiledMap tiledMap;
	// OrthographicCamera camara;

	Sprite sprite;

	SpriteBatch batch;

	Stage escenario;

	OrthographicCamera camera;

	Actor actor;

	PuertaHorizontal puertaHorizontal;

	PuertaVertical puertaVertical;

	@Override
	public void create() {
		batch = new SpriteBatch();
		sprite = new Sprite(new Texture("stone-wall-tiled-multiple.png"));
		puertaHorizontal = new PuertaHorizontal(new Texture(Gdx.files.internal("baldosa.png")), new Posicion(100, 100));
		puertaVertical = new PuertaVertical(new Texture(Gdx.files.internal("baldosa.png")), new Posicion(150, 150));
		actor = new Actor(new Posicion(100, 100), new Texture(Gdx.files.internal("hansito/hansitoUp.png")));
		escenario = new Stage();
		escenario.addActor(actor);
		escenario.addActor(puertaVertical);
		escenario.addActor(puertaHorizontal);
		camera = new OrthographicCamera(Gdx.graphics.getWidth() * 2, Gdx.graphics.getHeight() * 2);
		camera = (OrthographicCamera) escenario.getViewport().getCamera();
//		Gdx.input.setInputProcessor(this);
		// tiledMap = new
		// TmxMapLoader().load("mapaDos.tmx");
		// for (MapObject elemento : tiledMap.getLayers().get(2).getObjects()) {
		// System.out.println(elemento.getName());
		// }
		// tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
		// camara = (OrthographicCamera) escenario.getViewport().getCamera();

	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if (actor.comprobarColision(puertaHorizontal.cuerpo) || actor.comprobarColision(puertaHorizontal.cuerpo)) {
			System.out.println("chocao");
		}
		if (!actor.enLimitesPantalla(
				new Rectangulo(new Posicion(0, 0), (int) sprite.getWidth(), (int) sprite.getHeight()))) {
			System.out.println("tas salio");
			Sondeo.detectar(actor,true);
		} else {
			Sondeo.detectar(actor,false);
		}
		camera.position.x = actor.posicion.x;
		camera.position.y = actor.posicion.y;
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		sprite.draw(batch);
		batch.end();
		escenario.act();
		escenario.draw();
		// tiledMapRenderer.setView(camera);
		// tiledMapRenderer.render();
		// escenario.act();
		// escenario.draw();
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

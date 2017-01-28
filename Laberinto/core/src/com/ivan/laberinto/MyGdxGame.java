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
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;

import comun.Posicion;
import elementos.PuertaHorizontal;
import elementos.PuertaVertical;

public class MyGdxGame extends ApplicationAdapter implements InputProcessor {
	// TODO: Comprobar si esta colisionando
	// TODO: Poner la camara y actualizable
	// TODO: ArrayList de textura de paredes

	Sprite sprite;

	// OrthographicCamera camara;

	Stage escenario;

	TiledMap tiledMap;
	OrthographicCamera camera;
	TiledMapRenderer tiledMapRenderer;

	@Override
	public void create() {
		PuertaHorizontal puertaHorizontal = new PuertaHorizontal(new Texture(Gdx.files.internal("baldosa.png")),
				new Posicion(100, 100));
		PuertaVertical puertaVertical = new PuertaVertical(new Texture(Gdx.files.internal("baldosa.png")),
				new Posicion(150, 150));
		 camera = new OrthographicCamera(Gdx.graphics.getWidth()*2, Gdx.graphics.getHeight()*2);
		 camera.update();
	        tiledMap = new TmxMapLoader().load("mapaDos.tmx");
	        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
	        Gdx.input.setInputProcessor(this);
		escenario = new Stage();
		escenario.addActor(puertaVertical);
		escenario.addActor(puertaHorizontal);
		// camara = (OrthographicCamera) escenario.getViewport().getCamera();

	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();
//		escenario.act();
//		escenario.draw();
	}

	@Override
	public void dispose() {
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		if(keycode == Input.Keys.LEFT)
            camera.translate(-32,0);
        if(keycode == Input.Keys.RIGHT)
            camera.translate(32,0);
        if(keycode == Input.Keys.UP)
            camera.translate(0,-32);
        if(keycode == Input.Keys.DOWN)
            camera.translate(0,32);
        if(keycode == Input.Keys.NUM_1)
            tiledMap.getLayers().get(0).setVisible(!tiledMap.getLayers().get(0).isVisible());
        if(keycode == Input.Keys.NUM_2)
            tiledMap.getLayers().get(1).setVisible(!tiledMap.getLayers().get(1).isVisible());
        return true;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
}

package com.ivan.laberinto;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

import comun.Posicion;
import elementos.PuertaHorizontal;
import elementos.PuertaVertical;

public class MyGdxGame extends ApplicationAdapter {	
	//TODO: Comprobar si esta colisionando
	//TODO: Poner la camara y actualizable
	//TODO: ArrayList de textura de paredes
	
	Sprite sprite;
	
	//OrthographicCamera camara;
	
	Stage escenario;
	
	@Override
	public void create () {
		PuertaHorizontal puertaHorizontal = new PuertaHorizontal(new Texture(Gdx.files.internal("baldosa.png")), new Posicion(100, 100));
		PuertaVertical puertaVertical = new PuertaVertical(new Texture(Gdx.files.internal("baldosa.png")), new Posicion(150, 150));
		//camara = new OrthographicCamera(640, 480);
		escenario = new Stage();
		escenario.addActor(puertaVertical);
		escenario.addActor(puertaHorizontal);
		//camara = (OrthographicCamera) escenario.getViewport().getCamera();
		
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		escenario.act();
		escenario.draw();
	}
	
	@Override
	public void dispose () {
	}
}

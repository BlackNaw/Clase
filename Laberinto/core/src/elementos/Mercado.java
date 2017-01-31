package elementos;

import java.util.Scanner;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.Batch;

import comun.Letras;

public class Mercado {
	
	public static int comprar(int monedas, Batch batch, Camera camara) {
		Letras letras = new Letras("letra/Letras.fnt");
		letras.pintarPantalla(batch, "1. Vida +1",camara);
		letras.pintarPantalla(batch, "2. Cuchillo",camara);
		letras.pintarPantalla(batch, "3. Pistola",camara);
		letras.pintarPantalla(batch, "4. Balas +5",camara);
		Scanner leer = new Scanner(System.in);
		switch (leer.nextInt()) {
		case 1:
			if (monedas >= 25) {
				return monedas -= 25;
			}
			break;
		case 2:
			if (monedas >= 15) {
				return monedas -= 15;
			}
			break;
		case 3:
			if (monedas >= 50) {
				return monedas -= 50;
			}
			break;
		case 4:
			if (monedas >= 20) {
				return monedas -= 20;
			}
			break;
		}
		return monedas;
	}

}

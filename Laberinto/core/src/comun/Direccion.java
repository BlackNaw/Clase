package comun;

public enum Direccion {

	norte(true), sur(true), este(true), oeste(true);
	
	Boolean direccionValida;
	
	private Direccion(Boolean direccionValida) {
		this.direccionValida = direccionValida;
	}
	
	public void setDireccion(Boolean direccionValida) {
		this.direccionValida = direccionValida;
	}
	
}

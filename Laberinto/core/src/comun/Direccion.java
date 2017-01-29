package comun;

public enum Direccion {

	norte(true), sur(true), este(true), oeste(true);
	
	Boolean direccionValida;
	
	private Direccion(Boolean direccionValida) {
		this.direccionValida = direccionValida;
	}
	
	public boolean isChocado() {
		if(this.norte.direccionValida == false){
			return true;
		}else if(this.sur.direccionValida == false){
			return true;
		}else if(this.este.direccionValida == false){
			return true;
		}else if(this.oeste.direccionValida == false){
			return true;
		}
		return false;
	}
	
}

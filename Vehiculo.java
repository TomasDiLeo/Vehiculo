
public abstract class Vehiculo {
	private Persona chofer;

	private double distanciaRecorrida = 0;

	public Vehiculo(Persona chofer) {
		this.chofer = chofer;
	}

	public void recorrerDistancia(double distancia) {
		if(distancia < 0)
			throw new Error("No se puede recorrer una distancia negativa");
		else
			distanciaRecorrida += distancia;
	}

	public double getDistanciaRecorrida() {
		return distanciaRecorrida;
	}

	public void cambiarChofer(Persona choferNuevo) {
		this.chofer = choferNuevo;
	}
	
	public abstract void agregarPersona(Persona nuevaPersona);
	
	public abstract void bajarPersona();
	
	public String toString() {
		return " Chofer : " + this.chofer;
	}
}

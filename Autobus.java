import java.util.*;

public class Autobus extends Vehiculo implements Combustible {
	private List<Persona> pasajeros = new ArrayList<Persona>();
	private int pasajerosMaximos;
	private double combustible;
	private double combustibleMaximo = 210;
	
	public Autobus(Persona chofer, int pasajerosMaximos) {
		super(chofer);
		
		this.combustible = 0;
		this.pasajerosMaximos = pasajerosMaximos;
	}
	
	/**
	 *@pre: Una persona no puede ser chofer y acompañante al mismo tiempo
	 **/
	@Override
	public void cambiarChofer(Persona chofer) {
		if(!this.pasajeros.isEmpty())
			throw new Error("Todavia hay pasajeros");
		
		super.cambiarChofer(chofer);	
	}
	
	/**
	 *@pre: Una persona no puede ser chofer y acompañante al mismo tiempo
	 **/
	@Override
	public void agregarPersona(Persona nuevaPersona) {
		if(pasajeros.size() == pasajerosMaximos)
			throw new Error("No hay mas espacio para nuevos pasajeros");
		
		for(int i = 0; i < pasajeros.size(); i++)
			if(nuevaPersona.equals(pasajeros.get(i)))
				throw new Error("Una persona no puede subir mas de dos veces al vehiculo");
		
		pasajeros.add(nuevaPersona);	
	}

	/**
	 * @post: Baja a todos los pasajeros
	 * */
	@Override
	public void bajarPersona() {
		pasajeros.clear();
		
	}
	
	public void bajarPersona(Persona persona) {	
		pasajeros.remove(persona);
	}

	@Override
	public void cargarCombustible(double combustible) {
		if(this.combustible + combustible > combustibleMaximo)
			throw new Error("No se puede exceder del combustible maximo " + this.combustibleMaximo + " litros");
		else
			this.combustible += combustible;
	}
	
	@Override
	public void consumirCombustible(double kilometros) {
		if(kilometros*2 > this.combustible)
			throw new Error("No hay suficiente combustible");
		else		
			this.combustible -= kilometros*2;
	}
	
	@Override
	public void recorrerDistancia(double distancia) {
		consumirCombustible(distancia);
		super.recorrerDistancia(distancia);
		
	}
	
	private String getPasajeros() {
		String personas = "";
		for(int i = 0; i < pasajeros.size(); i++) 
			personas += "\n " + pasajeros.get(i);
			
		return personas;
	}
	
	public String toString() {
		String personas = getPasajeros();
		
		return "Motocicleta\n" + super.toString() + "\n Combustible: " + this.combustible + "\n Pasajeros: "
				+ personas;
	}
	
	
	
}

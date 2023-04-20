
public class Participante {
    private String nombre;
    private int puntos;

    public Participante(String nombre, int puntos) {
		this.nombre = nombre;
        this.puntos = puntos;
	}

    public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

    public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
}
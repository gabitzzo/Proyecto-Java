
public class Equipo{
    private String nombre;
    private String descripcion;

    public Equipo(String nombre, String descripcion) {
		this.nombre = nombre;
        this.descripcion = descripcion;
	}

	// Nombre
	public String getNombre() {
		return nombre;
	}
    public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// Descripción
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
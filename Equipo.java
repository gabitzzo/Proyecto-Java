public class Equipo{
    private String nombre;
    private String descripcion;
	private Participante participante1;
	private Participante participante2;
	private Participante participante3;
	private Participante participante4;

    public Equipo(String nombre, String descripcion) {
		this.nombre = nombre;
        this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

    public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
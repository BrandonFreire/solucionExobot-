package DataAccess.DTO;

public class PersonaDTO {
    private Integer IdPersona;       
    private String  Nombre;       
    private String  Estado;       
    private String  FechaCrea;    
    private String  FechaModifica;

    
    public PersonaDTO() {
    }
    public PersonaDTO(Integer idPersona, String nombre, String estado, String fechaCrea, String fechaModifica) {
        IdPersona = idPersona;
        Nombre = nombre;
        Estado = estado;
        FechaCrea = fechaCrea;
        FechaModifica = fechaModifica;
    }
    
    public PersonaDTO(String nombre) {
        this.Nombre = nombre;
    }

    public Integer getIdPersona() {
        return IdPersona;
    }
    public void setIdPersona(Integer idPersona) {
        IdPersona = idPersona;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public String getEstado() {
        return Estado;
    }
    public void setEstado(String estado) {
        Estado = estado;
    }
    public String getFechaCrea() {
        return FechaCrea;
    }
    public void setFechaCrea(String fechaCrea) {
        FechaCrea = fechaCrea;
    }
    public String getFechaModifica() {
        return FechaModifica;
    }
    public void setFechaModifica(String fechaModifica) {
        FechaModifica = fechaModifica;
    }

    @Override
    public String toString(){
        return getClass().getName()
        + "\n IdPersona:       "+ getIdPersona()       
        + "\n Nombre:       "+ getNombre()       
        + "\n Estado:       "+ getEstado()       
        + "\n FechaCrea:    "+ getFechaCrea()    
        + "\n FechaModifica:"+ getFechaModifica();
    }


}

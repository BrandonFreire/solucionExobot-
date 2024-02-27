package DataAccess.DTO;

public class PersonaCargoDTO {
    
    private Integer idPersona;
    private String nombre;
    private Integer idCargo;
    
    public PersonaCargoDTO() {
    }

    public PersonaCargoDTO(Integer idPersona, String nombre, Integer idCargo) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.idCargo = idCargo;
    }


    public Integer getIdPersona() {
        return idPersona;
    }
    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getIdCargo() {
        return idCargo;
    }
    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

    public String toString(){
        return getClass().getName()
        + "\n IdPersona: " + getIdPersona()       
        + "\n Nombre: " + getNombre()    
        + "\n IdCargo: " + getIdCargo();
    }

}



    

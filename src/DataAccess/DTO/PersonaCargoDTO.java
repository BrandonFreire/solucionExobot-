package DataAccess.DTO;

public class PersonaCargoDTO {
    
    private int idPersona;
    private String nombre;
    private int idCargo;
    
    public PersonaCargoDTO() {
    }

    public PersonaCargoDTO(int idPersona, String nombre, int idCargo) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.idCargo = idCargo;
    }


    public int getIdPersona() {
        return idPersona;
    }
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getIdCargo() {
        return idCargo;
    }
    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public String toString(){
        return getClass().getName()
        + "\n IdPersona: " + getIdPersona()       
        + "\n Nombre: " + getNombre()    
        + "\n IdCargo: " + getIdCargo();
    }

}



    

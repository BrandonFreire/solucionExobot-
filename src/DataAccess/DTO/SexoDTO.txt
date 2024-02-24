package DataAccess.DTO;

public class SexoDTO {
    private int    IdIFSexo;       
    private String Nombre;
    private String Estado;
    private String FechaCrea;
    private String FechaModifica;
    /**
     * Constructor
     * @param idIFSexo
     * @param nombre
     * @param estado
     * @param fechaCrea
     * @param fechaModifica
     */
    public SexoDTO(int idIFSexo
                , String nombre
                , String estado
                , String fechaCrea
                , String fechaModifica) {
        this.IdIFSexo = idIFSexo;
        this.Nombre = nombre;
        this.Estado = estado;
        this.FechaCrea = fechaCrea;
        this.FechaModifica = fechaModifica;
    }

    /**
     * getter/setter
     * @return
     */
    public int getIdIFSexo() {
        return IdIFSexo;
    }
    public void setIdIFSexo(int idIFSexo) {
        IdIFSexo = idIFSexo;
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
        + "\n IdSexo:       "+ getIdIFSexo()       
        + "\n Nombre:       "+ getNombre()       
        + "\n Estado:       "+ getEstado()       
        + "\n FechaCrea:    "+ getFechaCrea()    
        + "\n FechaModifica:"+ getFechaModifica();
    }
}

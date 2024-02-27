package DataAccess.DTO;
public class ExobotDTO {
    private Integer IdExaBot;       
    private Integer IdIABot;       
    private Integer IdAramaIzquierda;       
    private Integer IdAramaDerecha;       
    private String  Nombre;
    private String  Serie;
    private String  Estado;

    public ExobotDTO(){ }

    public ExobotDTO(String nombre) {
        this.Nombre = nombre;
    }
    
    public ExobotDTO(Integer idExaBot, Integer idIABot, Integer idAramaIzquierda, Integer idAramaDerecha, String nombre,
            String serie, String estado) {
        IdExaBot = idExaBot;
        IdIABot = idIABot;
        IdAramaIzquierda = idAramaIzquierda;
        IdAramaDerecha = idAramaDerecha;
        Nombre = nombre;
        Serie = serie;
        Estado = estado;
    }

    public Integer getIdExaBot() {
        return IdExaBot;
    }

    public void setIdExaBot(Integer idExaBot) {
        IdExaBot = idExaBot;
    }

    public Integer getIdIABot() {
        return IdIABot;
    }

    public void setIdIABot(Integer idIABot) {
        IdIABot = idIABot;
    }

    public Integer getIdAramaIzquierda() {
        return IdAramaIzquierda;
    }

    public void setIdAramaIzquierda(Integer idAramaIzquierda) {
        IdAramaIzquierda = idAramaIzquierda;
    }

    public Integer getIdAramaDerecha() {
        return IdAramaDerecha;
    }

    public void setIdAramaDerecha(Integer idAramaDerecha) {
        IdAramaDerecha = idAramaDerecha;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getSerie() {
        return Serie;
    }

    public void setSerie(String serie) {
        Serie = serie;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    
    @Override
    public String toString(){
        return getClass().getName()
        + "\n IdSexo:       "+ getIdExaBot()
        + "\n IdSexo:       "+ getIdIABot() 
        + "\n IdSexo:       "+ getIdAramaIzquierda()       
        + "\n IdSexo:       "+ getIdAramaDerecha()       
        + "\n Nombre:       "+ getNombre() 
        + "\n Nombre:       "+ getSerie()       
        + "\n Estado:       "+ getEstado();
    }
    
}
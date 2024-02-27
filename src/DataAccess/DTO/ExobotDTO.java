package DataAccess.DTO;
/**
 * @author Ismael Freire
 * @date 23/02/2024
 * @version 1.0
 */
public class ExobotDTO {
    private Integer    IdExaBot;
    private Integer    IdIABot;
    private Integer    IdArmaIzquierda;
    private Integer    IdArmaDerecha;
    private String Nombre;
    private String Serie;

    public ExobotDTO() {}

    /**
     * constructor con parametros 
     * @param idExaBot
     * @param string
     * @param string2
     * @param string3
     * @param nombre
     * @param serie
     */
    public ExobotDTO(Integer IdIABot, Integer IdArmaIzquierda, Integer IdArmaDerecha, String nombre, String serie) {
        this.IdIABot = IdIABot;
        this.IdArmaIzquierda = IdArmaIzquierda;
        this.IdArmaDerecha = IdArmaDerecha;
        this.Nombre = nombre;
        this.Serie = serie;
    }

    /**
     * getter/setter
     * @return
     */
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
    public Integer getIdArmaIzquierda() {
        return IdArmaIzquierda;
    }
    public void setIdArmaIzquierda(Integer idArmaIzquierda) {
        IdArmaIzquierda = idArmaIzquierda;
    }
    public Integer getIdArmaDerecha() {
        return IdArmaDerecha;
    }
    public void setIdArmaDerecha(Integer idArmaDerecha) {
        IdArmaDerecha = idArmaDerecha;
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

    @Override
    public String toString(){
        return getClass().getName()
        + "\n IdIABot:          "+ getIdIABot()       
        + "\n IdArmaIzquierda:  "+ getIdArmaDerecha()    
        + "\n IdArmaDerecha:    "+ getIdArmaDerecha()
        + "\n Nombre:           "+ getNombre()
        + "\n Serie:            "+ getSerie();
    }
}

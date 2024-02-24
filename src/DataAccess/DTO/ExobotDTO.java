package DataAccess.DTO;
/**
 * @author Ismael Freire
 * @date 23/02/2024
 * @version 1.0
 */
public class ExobotDTO {
    //private int    IdExaBot;
    private int    IdIABot;
    private int    IdArmaIzquierda;
    private int    IdArmaDerecha;
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
    public ExobotDTO(int IdIABot, int IdArmaIzquierda, int IdArmaDerecha, String nombre, String serie) {
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
    // public int getIdExaBot() {
    //     return IdExaBot;
    // }
    // public void setIdExaBot(int idExaBot) {
    //     IdExaBot = idExaBot;
    // }
    public int getIdIABot() {
        return IdIABot;
    }
    public void setIdIABot(int idIABot) {
        IdIABot = idIABot;
    }
    public int getIdArmaIzquierda() {
        return IdArmaIzquierda;
    }
    public void setIdArmaIzquierda(int idArmaIzquierda) {
        IdArmaIzquierda = idArmaIzquierda;
    }
    public int getIdArmaDerecha() {
        return IdArmaDerecha;
    }
    public void setIdArmaDerecha(int idArmaDerecha) {
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

package BusinessLogic.EjercitoRuso;
public abstract class DMHumano {
    private String dmNombre;
    private String dmCargo;

    public DMHumano(String dmNombre, String dmCargo) {
        this.dmNombre = dmNombre;
        this.dmCargo = dmCargo;
    }

    public String getDmNombre() {
        return dmNombre;
    }

    public void setDmNombre(String dmNombre) {
        this.dmNombre = dmNombre;
    }
}

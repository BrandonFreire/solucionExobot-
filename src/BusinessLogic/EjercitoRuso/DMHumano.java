package BusinessLogic.EjercitoRuso;
public abstract class DMHumano {
    private String dmNombre;

    public DMHumano(String dmNombre) {
        this.dmNombre = dmNombre;
    }

    public String getDmNombre() {
        return dmNombre;
    }

    public void setDmNombre(String dmNombre) {
        this.dmNombre = dmNombre;
    }
}

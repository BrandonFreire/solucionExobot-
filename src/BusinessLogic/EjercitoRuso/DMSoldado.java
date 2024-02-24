package BusinessLogic.EjercitoRuso;
public class DMSoldado extends DMHumano implements IAIHumanoExtremidad {
    private boolean dmHabilidadBrazoIzq;
    private boolean dmHabilidadBrazoDer;

    public DMSoldado(String dmNombre) {
        super(dmNombre);
        this.dmHabilidadBrazoIzq = dmGetHabilidadRandom();
        this.dmHabilidadBrazoDer = dmGetHabilidadRandom();
    }

    public boolean dmGetHabilidadBrazoIzq() {
        return dmHabilidadBrazoIzq;
    }

    public boolean dmGetHabilidadBrazoDer() {
        return dmHabilidadBrazoDer;
    }

    boolean dmGetHabilidadRandom() {
        int dmRandom = 50;
        return (Math.random() * 100 < dmRandom);
    }

}
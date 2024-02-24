package BusinessLogic.Exoesqueleto;
public abstract class DMArmaIzquierda {
    private String Tipo;

    public DMArmaIzquierda(String tipo){
        this.Tipo = tipo;
        System.out.println(tipo);
    }
    public String getTipo() {
        return Tipo;
    }
    public void disparar(int tiempo) {
        for (int i = 0; i < tiempo; i++)
        System.out.print(" * ");
    }

}

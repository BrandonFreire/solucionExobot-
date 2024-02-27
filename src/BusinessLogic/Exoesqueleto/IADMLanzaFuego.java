/**
 * @autor Ivonne Ayala 
 * @autor David Morales
 * @date 12/02/2024
 * @version 10.0
 */
package BusinessLogic.Exoesqueleto;

public class IADMLanzaFuego implements IAIArmaDerecha {

    private String iaLongitud;
    private IAFuenteDePoder fuenteDePoder;

    public IADMLanzaFuego(String longitud, IAFuenteDePoder fuenteDePoder) {
        this.iaLongitud = longitud;
        this.fuenteDePoder = fuenteDePoder;
        System.out.println("Lanza fuegos");
    }

    public void iaDisparar(int iaCantidadBalas) {
        System.out.println("Lanza fuego disparándose...");
    }

    @Override
    public void iaActivarArma(int iaTiempo) {
        if (fuenteDePoder.iaObtenerEnergia() >= 70) {
            System.out.println("Potencia alta");
            iaDisparar(iaTiempo);
            fuenteDePoder.iaDescargar(10);
        } else if (fuenteDePoder.iaObtenerEnergia() < 70 && fuenteDePoder.iaObtenerEnergia() >= 30) {
            System.out.println("Potencia media");
            iaDisparar(iaTiempo);
            fuenteDePoder.iaDescargar(10);
        } else if (fuenteDePoder.iaObtenerEnergia() < 30 && fuenteDePoder.iaObtenerEnergia() >= 10) {
            System.out.println("Potencia baja");
            iaDisparar(iaTiempo);
            fuenteDePoder.iaDescargar(10);
        } else if (fuenteDePoder.iaObtenerEnergia() < 10) {
            System.out.println("Sin potencia para el disparo");
        }
    }
}

/**
 * @autor Ivonne Ayala 
 * @date 12/02/2024
 * @version 10.0
 */
package BusinessLogic.Exoesqueleto;
public class IAFuenteDePoder {

    private static final int ENERGIA_MAXIMA = 100;
    private int iaEnergiaFP;

    public IAFuenteDePoder() {
        iaRecargar();
    }

    public void iaRecargar() {
        iaEnergiaFP = ENERGIA_MAXIMA;
        System.out.println("La fuente ha sido recargada. Energía restablecida al máximo.");
    }

    public void iaDescargar(int iaEnergiaMenos) {
        iaEnergiaFP = Math.max(0, iaEnergiaFP - iaEnergiaMenos);

        if (iaEnergiaFP == 0) {
            iaRecargar();
        }
        iaMostrarEstado();
    }

    public int iaObtenerEnergia() {
        return iaEnergiaFP;
    }

    private void iaMostrarEstado() {
        System.out.println("La energía actual es: " + iaEnergiaFP + "%");
        if (iaEnergiaFP == 0) {
            System.out.println("La energía de la fuente se agotó. Se ha recargado automáticamente.");
        }
    }
}

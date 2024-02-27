/**
 * @autor Ivonne Ayala 
 * @autor David Morales
 * @date 12/02/2024
 * @version 10.0
 */
package BusinessLogic.Exoesqueleto;
public class IADMLaser implements IAIArmaDerecha {
    
    public IADMLaser(){
        System.out.println("Laser");
    }

    @Override
    public void iaActivarArma(int iaTiempo) {
        System.out.println("Activando Láser durante " + iaTiempo + " segundos...");
        for (int i = 0; i < iaTiempo; i++) {
            System.out.print(" *");
        }
        System.out.println("\n¡Láser activado!");
    }
}

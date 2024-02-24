/**
 * @autor: Ismael Freire
 * @date: 13/02/2024
 * brandon.freire@outlook.com
 */
package BusinessLogic.Exoesqueleto;
public class IFBrazoDerecho {
    public IAIArmaDerecha ifArmaDerecha;

    /** 
     * gatter para arma derecha
     * @return
     */
    public IAIArmaDerecha IFgetArmaDerecha() {
        return ifArmaDerecha;
    }
    /**
     * setter para arma derecha
     * @param ifArmaDerecha
     */
    public void IFsetArmaDerecha(IAIArmaDerecha ifArmaDerecha) {
        this.ifArmaDerecha = ifArmaDerecha;
    } 
}

/**
 * @autor: Ismael Freire
 * @date: 13/02/2024
 * brandon.freire@outlook.com
 */
package BusinessLogic.EjercitoRuso;
import BusinessLogic.Exoesqueleto.IFITecnicoIngles;

public class IFExpertoIngles extends DMHumano{
    /**
     * constructor con parametros
     */
    public IFExpertoIngles(String ifnombre) {
        super(ifnombre, "2");
    }
    /**
     * metodo para traducir al ingles
     * @param iftTecnicoIngles
     */
    public void IFEnsenarIngles(IFITecnicoIngles iftTecnicoIngles){
        iftTecnicoIngles.ifTraducirIngles();
    }
}

/**
 * @autor: Ismael Freire
 * @date: 13/02/2024
 * brandon.freire@outlook.com
 */
package BusinessLogic.EjercitoRuso;
import BusinessLogic.Exoesqueleto.DMITecnicoEspanol;

public class IFExpertoEspanol extends DMHumano{

    /**
     * constructor con parametros
     * @param ifnombre
     */
    public IFExpertoEspanol(String ifnombre) {
        super(ifnombre);
    }

    /**
     * metodo para enseñar español
     * @param ifTecnicoEspanol
     */
    public void IFEnsenarEspañol(DMITecnicoEspanol ifTecnicoEspanol){
        ifTecnicoEspanol.ifTraducirEspanol();
    }
}

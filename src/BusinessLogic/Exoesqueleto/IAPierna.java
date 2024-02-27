/**
 * @autor Ivonne Ayala 
 * @date 12/02/2024
 * @version 10.0
 */
package BusinessLogic.Exoesqueleto;
public class IAPierna {

    public void iaCorrer(int iaVelocidad) {
        if(iaVelocidad <= 200 &&  iaVelocidad != 0){
            System.out.println("Estoy corriendo a una velocidad de " + iaVelocidad +"km/h.");
        }else{
            System.out.println("No puedo correr con esa velocidad, es demasiado rapido");
        }
    }

    public void iaSaltar(int iaAltitud) {
        if(iaAltitud<=50 &&  iaAltitud!=0){
            System.out.println("Estoy saltando a " + iaAltitud +"m.");
        }else{
            System.out.println("No puedo saltar tan alto");
        }
    }
}

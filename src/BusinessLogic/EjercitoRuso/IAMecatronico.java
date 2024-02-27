/**
 * @autor David Morales
 * @autor Ivonne Ayala 
 * @date 12/02/2024
 * @version 10.0
 */
package BusinessLogic.EjercitoRuso;
import java.util.ArrayList;
import BusinessLogic.Exoesqueleto.IAIFExobot;
import BusinessLogic.InteligenciaArtificial.IAIABot;


public class IAMecatronico extends DMHumano {
    ArrayList<DMSoldado> dmSoldados = new ArrayList<>();
    ArrayList<IAIFExobot> dmExobots = new ArrayList<>();
    ArrayList<DMSoldado> dmPelotonHabilidadAmbas = new ArrayList<>();
    ArrayList<DMSoldado> dmPelotonHabilidadIzq = new ArrayList<>();
    ArrayList<DMSoldado> dmPelotonHabilidadDer = new ArrayList<>();
    ArrayList<DMSoldado> dmPelotonHabilidadNin = new ArrayList<>();
    IAIABot dmPadreDeTodo = IAIABot.iaGetInstance("Padre");

    public IAMecatronico(String nombre) {
        super(nombre, "4");
    }

    public void iaDesplegarPeloton() {
        for (int i = 0; i < 40; i++) {
            dmSoldados.add(new DMSoldado("Soldado " + i));
        }

        System.out.println("\nEl mecatronico está ensamblando a los Exobots...");
        
        for (int i = 0; i < dmSoldados.size(); i++) {
            if (dmSoldados.get(i).dmGetHabilidadBrazoDer() == true
                    && dmSoldados.get(i).dmGetHabilidadBrazoIzq() == true)
                dmPelotonHabilidadAmbas.add(dmSoldados.get(i));
            if (dmSoldados.get(i).dmGetHabilidadBrazoDer() == true
                    && dmSoldados.get(i).dmGetHabilidadBrazoIzq() == false)
                dmPelotonHabilidadDer.add(dmSoldados.get(i));
            if (dmSoldados.get(i).dmGetHabilidadBrazoDer() == false
                    && dmSoldados.get(i).dmGetHabilidadBrazoIzq() == true)
                dmPelotonHabilidadIzq.add(dmSoldados.get(i));
            if (dmSoldados.get(i).dmGetHabilidadBrazoDer() == false
                    && dmSoldados.get(i).dmGetHabilidadBrazoIzq() == false)
                dmPelotonHabilidadNin.add(dmSoldados.get(i));
        }
        int numeroPeloton = 1;
        for (int i = 0; i < dmPelotonHabilidadAmbas.size(); i++) {
            if (i % 5 == 0) {
                System.out.println("        Peloton " + numeroPeloton);
                numeroPeloton++;
            }
            System.out.println(dmPelotonHabilidadAmbas.get(i).getDmNombre());
            dmExobots.add(new IAIFExobot(dmPadreDeTodo));
            dmExobots.get(i).asignarArmas(0);
        }

        for (int i = 0; i < dmPelotonHabilidadIzq.size(); i++) {
            if (i % 5 == 0) {
                System.out.println("        Peloton " + numeroPeloton);
                numeroPeloton++;
            }
            System.out.println(dmPelotonHabilidadIzq.get(i).getDmNombre());
            dmExobots.add(new IAIFExobot(dmPadreDeTodo));
            dmExobots.get(i).asignarArmas(1);
        }
        for (int i = 0; i < dmPelotonHabilidadDer.size(); i++) {
            if (i % 5 == 0) {
                System.out.println("        Peloton " + numeroPeloton);
                numeroPeloton++;
            }
            System.out.println(dmPelotonHabilidadDer.get(i).getDmNombre());
            dmExobots.add(new IAIFExobot(dmPadreDeTodo));
            dmExobots.get(i).asignarArmas(2);
        }
        for (int i = 0; i < dmPelotonHabilidadNin.size(); i++) {
            if (i % 5 == 0) {
                System.out.println("        Peloton " + numeroPeloton);
                numeroPeloton++;
            }
            System.out.println(dmPelotonHabilidadNin.get(i).getDmNombre());
            dmExobots.add(new IAIFExobot(dmPadreDeTodo));
            dmExobots.get(i).asignarArmas(3);
        }

    }
}

/**
 * @autor Ismael Freire
 * @autor Ivonne Ayala
 * @date 12/02/2024
 */
package BusinessLogic.Exoesqueleto;
import java.util.Hashtable;

import BusinessLogic.EjercitoRuso.IAIHumanoExtremidad;
import BusinessLogic.InteligenciaArtificial.IAIABot;

public class IAIFExobot extends IAIABot implements IAIHumanoExtremidad, DMITecnicoEspanol, IFITecnicoIngles {
    
    private Boolean eIFInicializado = false;
    private String dmCodigoSeguridad;
    private IAFuenteDePoder eIAFuentePoder;
    private IATurboReactor eIATurboReactor;
    private IFBrazoDerecho eIFBrazoDerecho;
    private IABrazoIzquierdo eIABrazoIzquierdo;
    private IAPierna eIAPiernaDerecha;
    private IAPierna eIAPiernaIzquierda;
    private DMArmaBazuca dmBazuca;
    private IADMLanzaFuego dmLanzaFuego;
    private IADMLaser dmLaser;
    private IFArmaMetralleta dmMetralleta;
    private Hashtable<Integer, String> ifIdiomasHashtable;

    public IAIFExobot(IAIABot iaBot) {
        super(iaBot);
        this.dmCodigoSeguridad = iaBot.dmCrearCodigoSeguridad();
        eIAFuentePoder = new IAFuenteDePoder();
        eIATurboReactor = new IATurboReactor();
        eIFBrazoDerecho = new IFBrazoDerecho();
        eIABrazoIzquierdo = new IABrazoIzquierdo();
        eIAPiernaDerecha = new IAPierna();
        eIAPiernaIzquierda = new IAPierna();
    }

    public Boolean inicializar() {
        if (!eIFInicializado) {
            System.out.println("Iniciando el exobot...");
        }
        return eIFInicializado = true;
    }

    public void ifPrenderFuente(IAFuenteDePoder ifFuenteDePoder) {
        eIAFuentePoder = ifFuenteDePoder;
        eIAFuentePoder.iaRecargar();
    }

    @Override
    public void ifTraducirEspanol() {
        ifIdiomasHashtable.put(1, "Español");
    }

    @Override
    public void ifTraducirIngles() {
        ifIdiomasHashtable.put(2, "Ingles");

    }

    public void ifTraducirIdiomas() {
        System.out.println("El exobot puede traducir al español o ingles");
        ifIdiomasHashtable.forEach((key, value) -> {
            System.out.println("-" + value);
        });
    }

    public void asignarArmas(int tipoEquip) {
        if (tipoEquip==0) {
            dmBazuca= new DMArmaBazuca("Antitanque");
            dmLaser = new IADMLaser();
        }
        if(tipoEquip==1){
            dmLanzaFuego = new IADMLanzaFuego("1.3f", eIAFuentePoder);
            dmMetralleta = new IFArmaMetralleta("MK16");
        }
        if (tipoEquip ==2) {
            dmMetralleta = new IFArmaMetralleta("MK16");
            dmLaser = new IADMLaser();
        }
        if (tipoEquip == 3) {
            dmBazuca= new DMArmaBazuca("Antitanque");
            dmLanzaFuego = new IADMLanzaFuego("1.3f", eIAFuentePoder);
        }
    }
}

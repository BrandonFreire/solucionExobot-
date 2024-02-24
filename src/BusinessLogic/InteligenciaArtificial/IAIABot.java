/**
 * @autor David Morales
 * @autor Ivonne Ayala 
 * @date 12/02/2024
 * @version 10.0
 */
package BusinessLogic.InteligenciaArtificial;
import java.security.SecureRandom;

public class IAIABot {
    private static final String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static SecureRandom random = new SecureRandom();
    private static IAIABot iaInstance;
    private String iaNombre;

    private IAIABot() {
    }

    protected IAIABot(IAIABot iaIABot) {
        if (iaIABot != null) {
            iaInstance = iaIABot;
        }
    }

    public static IAIABot iaGetInstance(String iaNombre) {
        if (iaInstance == null) {
            iaInstance = new IAIABot();
            iaInstance.iaSetNombre(iaNombre);
        }
        return iaInstance;
    }

    public String iaGetNombre() {
        return iaNombre;
    }
    
    public void iaSetNombre(String iaNombre) {
        this.iaNombre = iaNombre;
    }

    public String dmCrearCodigoSeguridad() {
        StringBuilder codigo = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            codigo.append(CARACTERES.charAt(random.nextInt(CARACTERES.length())));
        }
        return codigo.toString();
    }

}

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;




public class Registros {

    public static void main(String[] args) {
        //Creamos el archivo de texto para guardar los registros
        dmCrearArchivoDeRegistro();
        dmEscribirRegistro();
    }

    public static void dmCrearArchivoDeRegistro() {
        Path path = Paths.get("script.sql");
        try {
            if (Files.notExists(path)) {
                Files.createFile(path);
            } else {
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void dmEscribirRegistro() {
        try (FileWriter writer = new FileWriter("script.sql", true)) {
            writer.write("INSERT INTO Exobots (IdIABot, IdArmaIzquierda, IdArmaDerecha, Nombre, Serie)\r\n" + //
            "VALUES");
            for (int i = 0; i<1000; i++) {
                writer.write("("+"'1'" + ",'"+numRand()+ "','"
                        +numRand()+"',"+"'Exobot "+ i+"',"+"'Serie E"+i + "')"+",\n");
            }
            writer.write("('"+1 + "','" + numRand()+ "','"
                        + numRand()+"',"+"'Exobot 1000'"+","+"'Serie E1000'" + ")"+";\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int numRand(){
         Random random = new Random();
        
        // Generar un número aleatorio entre 1 y 2
        int numeroAleatorio = random.nextInt(2) + 1;
        return numeroAleatorio;
    }
}

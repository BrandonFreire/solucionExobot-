package Framework;

public class EXOException extends Exception {

    public EXOException(String e, String clase, String metodo) {
        //grabar el log
        System.out.println("[ERROR EN IABot para el LOG] " + clase +"."+ metodo +" : "+ e );
    }

    @Override 
    public String getMessage(){
        return "Privado!!!";
    }    
}

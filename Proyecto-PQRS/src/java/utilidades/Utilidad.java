package utilidades;

import model.Usuario;


public class Utilidad {

    public static Usuario Usertemp;
    public static String estado;
    public static int radicado;
    public static int menucorrecto;

    public static boolean CasillaVacia(String text) {
        String texto = text.trim();
        if (texto.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

}

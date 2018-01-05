package br.com.ioasys.lucascarvalho.empresas.Utils;

import android.widget.EditText;

/**
 * Created by Desenvolvimento on 04/01/2018.
 */

public class Utils {

    public static boolean validaCampoVazio(EditText texto, String msgError){

        if(texto.getText().toString().equals("")) {
            texto.setError(msgError);
            texto.findFocus();
            return false;
        } else {

            return true;
        }
    }

    public static boolean validaEmail(EditText texto, String msgError){

        String email = texto.getText().toString().trim();

        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+\\.+[a-z]+";

        if (email.matches(emailPattern))
        {
            return true;
        }
        else {
            texto.setError(msgError);
            texto.findFocus();
            return (false);
        }
    }
}

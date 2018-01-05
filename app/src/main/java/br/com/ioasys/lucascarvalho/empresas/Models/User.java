package br.com.ioasys.lucascarvalho.empresas.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Desenvolvimento on 04/01/2018.
 */

public class User {

    @SerializedName("email")
    private String email;
    @SerializedName("senha")
    private String senha;

    public User(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}

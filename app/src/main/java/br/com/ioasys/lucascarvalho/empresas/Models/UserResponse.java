package br.com.ioasys.lucascarvalho.empresas.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Desenvolvimento on 04/01/2018.
 */

public class UserResponse {

    @SerializedName("enterprise")
    private String enterprise;
    @SerializedName("sucess")
    private boolean sucess;

    public UserResponse( String enterprise, boolean sucess) {
        this.enterprise = enterprise;
        this.sucess = sucess;
    }

    public String getEnterprise() {
        return enterprise;
    }
    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }

    public boolean isSucess() {
        return sucess;
    }

    public void setSucess(boolean sucess) {
        this.sucess = sucess;
    }
}
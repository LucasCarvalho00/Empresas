package br.com.ioasys.lucascarvalho.empresas.Models;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by Desenvolvimento on 04/01/2018.
 */

public class EnterpriseSearchResponse {


    @SerializedName("enterprises")
    private List<Enterprise> enterprises;

    public EnterpriseSearchResponse() {
    }

    public EnterpriseSearchResponse(List<Enterprise> enterprises) {
        this.enterprises = enterprises;
    }

    public List<Enterprise> getEnterprises() {
        return enterprises;
    }

    public void setEnterprises(List<Enterprise> enterprises) {
        this.enterprises = enterprises;
    }
}

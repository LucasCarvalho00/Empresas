package br.com.ioasys.lucascarvalho.empresas.Models;

/**
 * Created by Desenvolvimento on 04/01/2018.
 */

public class EnterpriseType {

    private String enterprise_type_name;
    private int id;

    public EnterpriseType(String enterprise_type_name) {
        this.enterprise_type_name = enterprise_type_name;
    }

    public String getEnterprise_type_name() {
        return enterprise_type_name;
    }
    public void setEnterprise_type_name(String enterprise_type_name) {
        this.enterprise_type_name = enterprise_type_name;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}

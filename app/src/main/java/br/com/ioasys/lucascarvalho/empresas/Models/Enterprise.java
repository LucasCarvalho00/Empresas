package br.com.ioasys.lucascarvalho.empresas.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Desenvolvimento on 04/01/2018.
 */

public class Enterprise implements Serializable {

    @SerializedName("id")
    private Integer id;
    @SerializedName("enterprise_name")
    private String enterpriseName;
    @SerializedName("description")
    private String description;
    @SerializedName("city")
    private String city;
    @SerializedName("country")
    private String country;
    @SerializedName("enterprise_type")
    private EnterpriseType enterpriseType;

    public Enterprise() {

    }

    public Enterprise(Integer id, String enterpriseName, String description, String city, String country, EnterpriseType enterpriseType) {
        this.id = id;
        this.enterpriseName = enterpriseName;
        this.description = description;
        this.city = city;
        this.country = country;
        this.enterpriseType = enterpriseType;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }
    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }
    public void setEnterpriseType(EnterpriseType enterpriseType) {
        this.enterpriseType = enterpriseType;
    }
}
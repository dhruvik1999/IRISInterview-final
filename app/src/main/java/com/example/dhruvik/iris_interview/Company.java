
package com.example.dhruvik.iris_interview;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Company {

    //java class for convert response into java object

    @SerializedName("company_type")
    @Expose
    private String companyType;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

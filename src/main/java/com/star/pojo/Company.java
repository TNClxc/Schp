package com.star.pojo;

public class Company
{
    private int id ;
    private String companyName ;
    private String companyContent ;
    private String companyPhone ;
    private String companyAddress;
    private int companyCapital;

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public int getCompanyCapital() {
        return companyCapital;
    }

    public void setCompanyCapital(int companyCapital) {
        this.companyCapital = companyCapital;
    }

    //该公司下面的所有员工


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyContent() {
        return companyContent;
    }

    public void setCompanyContent(String companyContent) {
        this.companyContent = companyContent;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }
}

package com.star.pojo;

public class Company
{
    private int id ;
    private String companyName ;
    private int companyContent ;
    private int companyPhone ;


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

    public int getCompanyContent() {
        return companyContent;
    }

    public void setCompanyContent(int companyContent) {
        this.companyContent = companyContent;
    }

    public int getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(int companyPhone) {
        this.companyPhone = companyPhone;
    }
}

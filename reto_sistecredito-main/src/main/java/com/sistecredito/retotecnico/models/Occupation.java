package com.sistecredito.retotecnico.models;

public class Occupation {

    private String occupation;
    private String salaryRange;
    private String businessName;
    private String businessPhone;
    private String role;

    public Occupation(String occupation, String salaryRange, String enterpriseName, String enterpriseNumber, String role) {
        this.occupation = occupation;
        this.salaryRange = salaryRange;
        this.businessName = enterpriseName;
        this.businessPhone = enterpriseNumber;
        this.role = role;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getSalaryRange() {
        return salaryRange;
    }

    public String getBusinessName() {
        return businessName;
    }

    public String getBusinessPhone() {
        return businessPhone;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Occupation{" +
                "occupation='" + occupation + '\'' +
                ", salaryRange='" + salaryRange + '\'' +
                ", enterpriseName='" + businessName + '\'' +
                ", enterpriseNumber='" + businessPhone + '\'' +
                ", position='" + role + '\'' +
                '}';
    }
}

package com.example.myapplication;

public class UserProfile {


    private String FirstName,LastName,Age,Gender,MaritalStatus,Occupation,HealthProblem,BloodGroup;


    public UserProfile()
    {

    }

    public UserProfile(String firstName, String lastName,String age, String gender, String maritalStatus, String occupation, String healthProblem, String bloodGroup) {
        FirstName = firstName;
        LastName = lastName;
        Age = age;
        Gender = gender;
        MaritalStatus = maritalStatus;
        Occupation = occupation;
        HealthProblem = healthProblem;
        BloodGroup = bloodGroup;

    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getMaritalStatus() {
        return MaritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        MaritalStatus = maritalStatus;
    }

    public String getOccupation() {
        return Occupation;
    }

    public void setOccupation(String occupation) {
        Occupation = occupation;
    }

    public String getHealthProblem() {
        return HealthProblem;
    }

    public void setHealthProblem(String healthProblem) {
        HealthProblem = healthProblem;
    }

    public String getBloodGroup() {
        return BloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        BloodGroup = bloodGroup;
    }
}

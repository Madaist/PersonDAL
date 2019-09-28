package com.example.persondal.dal.model;

import java.util.Objects;

/**
 * PersonDTO
 */

public class PersonDTO {

    private int id;
    private String lastName;
    private String firstName;
    private Integer age;
    private String socialSecurityCode;

    public PersonDTO lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public PersonDTO firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public PersonDTO age(Integer age) {
        this.age = age;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public PersonDTO socialSecurityCode(String socialSecurityCode) {
        this.socialSecurityCode = socialSecurityCode;
        return this;
    }

    public String getSocialSecurityCode() {
        return socialSecurityCode;
    }

    public void setSocialSecurityCode(String socialSecurityCode) {
        this.socialSecurityCode = socialSecurityCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PersonDTO personDTO = (PersonDTO) o;
        return Objects.equals(this.lastName, personDTO.lastName) &&
                Objects.equals(this.firstName, personDTO.firstName) &&
                Objects.equals(this.age, personDTO.age) &&
                Objects.equals(this.socialSecurityCode, personDTO.socialSecurityCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, age, socialSecurityCode);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PersonDTO {\n");

        sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
        sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
        sb.append("    age: ").append(toIndentedString(age)).append("\n");
        sb.append("    socialSecurityCode: ").append(toIndentedString(socialSecurityCode)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

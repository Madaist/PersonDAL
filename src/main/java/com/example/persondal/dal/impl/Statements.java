package com.example.persondal.dal.impl;

public class Statements {

    public static final String SELECT_PERSON_BY_ID = "SELECT LASTNAME"
            + ", FIRSTNAME"
            + ", AGE"
            + ", SOCIALSECURITYCODE"
            + " FROM STUDENT.PERSONS_MADA"
            + " WHERE PERSONID = ?";


    public static final String SELECT_ALL_PERSONS = "SELECT LASTNAME"
            + ", FIRSTNAME"
            + ", AGE"
            + ", SOCIALSECURITYCODE"
            + " FROM STUDENT.PERSONS_MADA";

    public static final String SELECT_ALL_IDS = "SELECT PERSONID FROM STUDENT.PERSONS_MADA";

    public static final String INSERT_PERSON = "INSERT INTO STUDENT.PERSONS_MADA VALUES ("
            + "seq_person.nextval, ?, ?, ?, ? )";

    public static final String DELETE_PERSON = "DELETE FROM STUDENT.PERSONS_MADA WHERE PERSONID = ?";

    public static final String UPDATE_PERSON = "UPDATE STUDENT.PERSONS_MADA"
            + " SET LASTNAME = ?"
            + ", FIRSTNAME = ?"
            + ", AGE = ?"
            + ", SOCIALSECURITYCODE = ?"
            + " WHERE PERSONID = ?";


}


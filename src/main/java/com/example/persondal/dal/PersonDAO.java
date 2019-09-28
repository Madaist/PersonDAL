package com.example.persondal.dal;

import com.example.persondal.dal.model.PersonDTO;
import java.util.List;

public interface PersonDAO {

    List<PersonDTO> getAllPersons() throws DalException;

    PersonDTO getPersonById(int id) throws DalException;

    List<Integer> getPersonsIds() throws DalException;

    void insertPerson(PersonDTO personDTO) throws DalException;

    void deletePerson(int id) throws DalException;

    void updatePerson(int id, PersonDTO personDTO) throws DalException;



}

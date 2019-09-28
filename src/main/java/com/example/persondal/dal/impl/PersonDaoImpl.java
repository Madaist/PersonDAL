package com.example.persondal.dal.impl;

import com.example.persondal.dal.DalErrorCodes;
import com.example.persondal.dal.DalException;
import com.example.persondal.dal.PersonDAO;
import com.example.persondal.dal.model.PersonDTO;
import com.example.persondal.dal.model.rowmappers.PersonMapper;
import java.util.List;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDaoImpl implements PersonDAO {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private JdbcTemplate personJdbcTemplate;

    public PersonDaoImpl(@Qualifier("studentDS") DataSource studentDs) {
        this.personJdbcTemplate = new JdbcTemplate(studentDs);
    }

    @Override
    public List<PersonDTO> getAllPersons() throws DalException {
        try {
            logger.info("Get persons list");
            List<PersonDTO> personDTOList = personJdbcTemplate.query(Statements.SELECT_ALL_PERSONS, new PersonMapper());
            logger.info("Get persons response: {}", personDTOList);
            return personDTOList;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DalException(DalErrorCodes.TECHNICAL_ERROR, e.getMessage());
        }
    }

    @Override
    public PersonDTO getPersonById(int id) throws DalException {

        try {
            logger.info("Get personDTO by id");
            List<Integer> ids = getPersonsIds();
            if (!ids.contains(id))
                throw new DalException(DalErrorCodes.ID_NOT_FOUND, "ID not found");
            PersonDTO personDTO = personJdbcTemplate.queryForObject(Statements.SELECT_PERSON_BY_ID, new Object[]{id}, new PersonMapper());
            logger.info("Get personDTO by id response: " + personDTO);
            return personDTO;
        } catch (DalException e) {
            logger.trace(e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DalException(DalErrorCodes.TECHNICAL_ERROR , e.getMessage());
        }
    }

    @Override
    public List<Integer> getPersonsIds() throws DalException {
        try {
            logger.info("Get all ids");
            List<Integer> personIds = personJdbcTemplate.queryForList(Statements.SELECT_ALL_IDS, Integer.class);
            logger.info("All ids: " + personIds);
            return personIds;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DalException(DalErrorCodes.TECHNICAL_ERROR, e.getMessage());

        }
    }

    @Override
    public void insertPerson(PersonDTO personDTO) throws DalException {
        try {
            Object[] params = {personDTO.getLastName(),
                    personDTO.getFirstName(),
                    personDTO.getAge(),
                    personDTO.getSocialSecurityCode()};
            personJdbcTemplate.update(Statements.INSERT_PERSON, params);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DalException(DalErrorCodes.TECHNICAL_ERROR, e.getMessage());
        }
    }

    @Override
    public void deletePerson(int id) throws DalException {
        try {
            List<Integer> ids = getPersonsIds();
            if (!ids.contains(id))
                throw new DalException(DalErrorCodes.ID_NOT_FOUND, "ID not found");

            Object[] params = {id};
            personJdbcTemplate.update(Statements.DELETE_PERSON, params);
        } catch (DalException e) {
            logger.trace(e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DalException(DalErrorCodes.TECHNICAL_ERROR, e.getMessage());
        }

    }

    @Override
    public void updatePerson(int id, PersonDTO personDTO) throws DalException {
        try {
            List<Integer> ids = getPersonsIds();
            if (!ids.contains(id))
                throw new DalException(DalErrorCodes.ID_NOT_FOUND, "ID not found");

            Object[] params = {personDTO.getLastName(),
                    personDTO.getFirstName(),
                    personDTO.getAge(),
                    personDTO.getSocialSecurityCode(),
                    id};

            personJdbcTemplate.update(Statements.UPDATE_PERSON, params);
        } catch (DalException e) {
            logger.trace(e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new DalException(DalErrorCodes.TECHNICAL_ERROR, e.getMessage());
        }

    }
}



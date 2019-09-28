package com.example.persondal.dal.model.rowmappers;

import com.example.persondal.dal.model.PersonDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class PersonMapper implements RowMapper<PersonDTO> {

    @Override
    public PersonDTO mapRow(ResultSet resultSet, int i) throws SQLException {
        PersonDTO personDTO = new PersonDTO();

        personDTO.setId(resultSet.getInt("personId"));
        personDTO.setLastName(resultSet.getString("lastName"));
        personDTO.setFirstName(resultSet.getString("firstName"));
        personDTO.setAge(resultSet.getInt("age"));
        personDTO.setSocialSecurityCode(resultSet.getString("socialSecurityCode"));

        return personDTO;

    }


}




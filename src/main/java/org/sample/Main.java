package org.sample;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Person person = new Person();
        person.setId(1);
        person.setName("John");
        person.setEmail("john@gmail.com");
        person.setPhones(List.of(
                new Person.PhoneNumber("100", Person.PhoneType.MOBILE),
                new Person.PhoneNumber("200", Person.PhoneType.HOME)
        ));
        String objectAsString = objectMapper.writeValueAsString(person);

        System.out.println(objectAsString);
    }
}

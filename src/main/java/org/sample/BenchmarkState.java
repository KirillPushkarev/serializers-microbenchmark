package org.sample;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.List;

@State(Scope.Benchmark)
public class BenchmarkState {

    private ObjectMapper objectMapper;
    private Person person;
    private String personJsonAsString = "{\"id\":1,\"name\":\"John\",\"email\":\"john@gmail.com\",\"phones\":[{\"number\":\"100\",\"type\":\"MOBILE\"},{\"number\":\"200\",\"type\":\"HOME\"}]}";
    private org.sample.protos.Person personProto;
    private byte[] personProtoAsBytes;

    @Setup(Level.Trial)
    public void setUp() {
        objectMapper = new ObjectMapper();
        person = new Person();
        person.setId(1);
        person.setName("John");
        person.setEmail("john@gmail.com");
        person.setPhones(List.of(
                new Person.PhoneNumber("100", Person.PhoneType.MOBILE),
                new Person.PhoneNumber("200", Person.PhoneType.HOME)
        ));

        personProto = buildPersonProto();
        personProtoAsBytes = personProto.toByteArray();
    }

    private org.sample.protos.Person buildPersonProto() {
        org.sample.protos.Person.Builder person = org.sample.protos.Person.newBuilder();
        person.setId(1);
        person.setName("John");
        person.setEmail("john@gmail.com");
        person.addAllPhones(List.of(
                org.sample.protos.Person.PhoneNumber.newBuilder().setNumber("100").setType(org.sample.protos.Person.PhoneType.MOBILE).build(),
                org.sample.protos.Person.PhoneNumber.newBuilder().setNumber("200").setType(org.sample.protos.Person.PhoneType.HOME).build()
        ));

        return person.build();
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public Person getPerson() {
        return person;
    }

    public String getPersonJsonAsString() {
        return personJsonAsString;
    }

    public org.sample.protos.Person getPersonProto() {
        return personProto;
    }

    public byte[] getPersonProtoAsBytes() {
        return personProtoAsBytes;
    }
}

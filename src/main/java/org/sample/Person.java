package org.sample;

import java.util.List;

public class Person {

    enum PhoneType {
        MOBILE, HOME, WORK
    }

    static class PhoneNumber {
        private String number;
        private PhoneType type = PhoneType.HOME;

        public PhoneNumber() {
        }

        public PhoneNumber(String number, PhoneType type) {
            this.number = number;
            this.type = type;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public PhoneType getType() {
            return type;
        }

        public void setType(PhoneType type) {
            this.type = type;
        }
    }

    private int id;
    private String name;
    private String email;
    private List<PhoneNumber> phones;

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<PhoneNumber> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneNumber> phones) {
        this.phones = phones;
    }
}

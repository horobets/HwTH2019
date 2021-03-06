package task8.kismia.pages.fakepersongenerator;

import task8.kismia.pages.profile.Gender;

import java.time.LocalDate;


public class FakePerson {
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate birthday;
    private String phone;
    private String email;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String sSN;

    public FakePerson() {
        super();
    }

    public FakePerson(String firstName, String lastName, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return String.format(
                "First Name: %s %n " +
                        "Last Name: %s %n " +
                        "Gender: %s %n " +
                        "Birthday: %s %n " +
                        "Phone: %s %n " +
                        "Email: %s %n " +
                        "Street: %s %n " +
                        "City: %s %n " +
                        "State: %s %n " +
                        "ZIP: %s %n " +
                        "Country: %s %n " +
                        "SSN: %s %n ",
                firstName,
                lastName,
                gender.toString(),
                birthday.toString(),
                phone,
                email,
                street,
                city,
                state,
                zip,
                country,
                sSN
        );
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setSSN(String sSN) {
        this.sSN = sSN;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getCountry() {
        return country;
    }

    public String getSSN() {
        return sSN;
    }
}

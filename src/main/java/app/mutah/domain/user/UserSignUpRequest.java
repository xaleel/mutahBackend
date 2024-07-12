package app.mutah.domain.user;

public class UserSignUpRequest {
    private final String name;
    private final String surname;
    private final Long phone;
    private final Email email;
    private final String rawPassword;
    private final String country;

    public UserSignUpRequest(String name, String surname, Long phone, Email email, String rawPassword,
            String country) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.rawPassword = rawPassword;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Long getPhone() {
        return phone;
    }

    public Email getEmail() {
        return email;
    }

    public String getRawPassword() {
        return rawPassword;
    }

    public String getCountry() {
        return country;
    }
}

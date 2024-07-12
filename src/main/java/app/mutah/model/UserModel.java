package app.mutah.model;

import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import app.mutah.domain.user.Email;
import app.mutah.domain.user.Password;
import app.mutah.enums.Country;
import app.mutah.enums.UserRole;
import app.mutah.util.Timestamp;

@Entity
@Table(name = "user_account")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "phone", nullable = false)
    private Long phone;

    @Embedded
    private Email email;

    @Embedded
    private Password password;

    @Column(name = "role", nullable = false)
    private UserRole role;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;

    @Column(name = "image")
    private Optional<String> image;

    @Column(name = "country", nullable = false)
    private Country country;

    @Column(name = "banned", nullable = false)
    private Boolean banned;

    @Column(name = "push_token")
    private Optional<String> pushToken;

    @Column(name = "pw_reset_token")
    private Optional<String> passwordResetToken;

    @Column(name = "verified", nullable = false)
    private Boolean verified;

    @Column(name = "otp")
    private Optional<String> otp;

    protected UserModel() {
    }

    public UserModel(String name, String surname, Long phone, Email email, Password password, UserRole role,
            Timestamp createdAt, Timestamp updatedAt, Optional<String> image, Country country, Boolean banned,
            Optional<String> pushToken, Optional<String> passwordResetToken, Boolean verified, Optional<String> otp) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.role = role;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.image = image;
        this.country = country;
        this.banned = banned;
        this.pushToken = pushToken;
        this.passwordResetToken = passwordResetToken;
        this.verified = verified;
        this.otp = otp;
    }

    public Long getId() {
        return id;
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

    public String getEmail() {
        return email.toString();
    }

    public Password getPassword() {
        return password;
    }

    public UserRole getRole() {
        return role;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public Optional<String> getImage() {
        return image;
    }

    public Country getCountry() {
        return country;
    }

    public Boolean getBanned() {
        return banned;
    }

    public Optional<String> getPush_token() {
        return pushToken;
    }

    public Optional<String> getPw_reset_token() {
        return passwordResetToken;
    }

    public Boolean getVerified() {
        return verified;
    }

    public Optional<String> getOtp() {
        return otp;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public void setCreated_at(Timestamp timestamp) {
        this.createdAt = timestamp;
    }

    public void setUpdated_at(Timestamp timestamp) {
        this.updatedAt = timestamp;
    }

    public void setImage(Optional<String> image) {
        this.image = image;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setBanned(Boolean banned) {
        this.banned = banned;
    }

    public void setPush_token(Optional<String> pushToken) {
        this.pushToken = pushToken;
    }

    public void setPasswordResetToken(Optional<String> passwordResetToken) {
        this.passwordResetToken = passwordResetToken;
    }

}

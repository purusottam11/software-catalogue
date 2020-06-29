package com.purusottam.softwarecatalogue.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StringUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "USERS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User extends AuditableIdEntity {

    public enum Gender {
        MALE, FEMALE;

        public static Gender parse(String genderString) {
            for (Gender gender : values()) {
                if (StringUtils.endsWithIgnoreCase(gender.name(), genderString)) {
                    return gender;
                }
            }
            return null;
        }
    }

    @Column(name = "EMAIL_ID")
    private String emailId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "GENDER")
    private Gender gender;


    @Column(name = "DOB")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dob;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "PINCODE")
    private String pincode;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE")
    private String state;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "WEBSITE")
    private String website;

    @Column(name = "NOTES")
    private String notes;

    @Column(name = "SEC_CODE")
    private String password;

    @Column(name = "ACCOUNT_ACTIVE", columnDefinition = "TINYINT default '1'")
    private boolean accountActive = true;

    @Column(name = "ACCOUNT_LOCKED", columnDefinition = "TINYINT default '0'")
    private boolean accountLocked = false;

    @Column(name = "CREDENTIALS_EXPIRED", columnDefinition = "TINYINT default '0'")
    private boolean credentialsExpired = false;

    @Column(name = "ENABLED", columnDefinition = "TINYINT default '1'")
    private boolean enabled = true;


}

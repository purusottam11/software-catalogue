package com.purusottam.softwarecatalogue.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PublisherBean {

    public enum PublisherType {
        SOFTWARE, HARDWARE, OTHER;
    }

    private String name;

    private String website;

    private String foundedDate;

    private String description;

    private String industry;

    private String country;

    private String state;

    private String city;

    private String address;

    private PublisherType type;

}

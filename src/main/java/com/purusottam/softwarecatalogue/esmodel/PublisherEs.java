package com.purusottam.softwarecatalogue.esmodel;

import com.purusottam.softwarecatalogue.model.Publisher;
import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Document(indexName = "publisher", type = "publisher")
public class PublisherEs {


    public enum PublisherType {
        SOFTWARE("Software"), HARDWARE("Hardware"), OTHER("Other");
        private String label;

        private PublisherType(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }

    private Long id;

    private String name;

    private String website;

    private String foundedDate;


    private String description;

    private String industry;

    private String country;

    private String state;

    private String city;

    private String address;

    private Publisher.PublisherType type;

}

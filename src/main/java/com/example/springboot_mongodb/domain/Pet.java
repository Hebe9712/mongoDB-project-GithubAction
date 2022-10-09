package com.example.springboot_mongodb.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pet {
    private String id;
    private String name;
    private String species;
}

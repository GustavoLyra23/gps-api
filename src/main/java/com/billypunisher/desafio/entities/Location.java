package com.billypunisher.desafio.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_location")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer x;
    private Integer y;


}

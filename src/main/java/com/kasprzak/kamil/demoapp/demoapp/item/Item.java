package com.kasprzak.kamil.demoapp.demoapp.item;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ITEMS")
@NoArgsConstructor
@Getter
@Setter
public class Item {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "USERNAME")
    private String description;





}

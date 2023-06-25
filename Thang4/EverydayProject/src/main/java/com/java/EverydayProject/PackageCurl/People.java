package com.java.EverydayProject.PackageCurl;

import javax.persistence.*;

@Entity
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    private String name;
    private String address;

    public String getName() {
        return name;
    }

    public People(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public People() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

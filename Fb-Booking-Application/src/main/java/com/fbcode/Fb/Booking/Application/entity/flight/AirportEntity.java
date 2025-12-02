package com.fbcode.Fb.Booking.Application.entity.flight;


import jakarta.persistence.*;

@Entity
@Table(name="airport")
public class AirportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", length = 10, unique = true, nullable = false)
    private String code;

    private String name;
    private String city;
    private String state;
    private String country;

    public AirportEntity() {
    }

    public AirportEntity(Long id, String code, String name, String city, String state, String country) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

package com.anapedra.commerce.entities;

import com.anapedra.commerce.entities.enums.AddressType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_address")
public class Address implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer addressType;
    private String street;
    private Integer number;
    private String cep;
    private String borhood;
    private String city;
    private String state;
    private String country;
    private String AddressComplement;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;



    public Address(Long id, AddressType addressType, String street, Integer number, String cep, String borhood,
                   String city, String state,String country,String addressComplement, User user) {
        this.id = id;
        setAddressType(addressType);
        this.street=street;
        this.number = number;
        this.cep = cep;
        this.borhood = borhood;
        this.city = city;
        this.state = state;
        this.country=country;
        this.AddressComplement=addressComplement;
        this.user=user;

    }

    public Address() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public AddressType getAddressType(){
        return AddressType.valueOf(addressType);
    }

    public void setAddressType(AddressType addressType) {
        if (addressType != null){
            this.addressType = addressType.getCode();
        }
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBorhood() {
        return borhood;
    }

    public void setBorhood(String borhood) {
        this.borhood = borhood;
    }

    public String getAddressComplement() {
        return AddressComplement;
    }

    public void setAddressComplement(String addressComplement) {
        AddressComplement = addressComplement;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address that = (Address) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}



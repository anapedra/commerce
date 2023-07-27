package com.anapedra.commerce.dtos;

import com.anapedra.commerce.entities.Address;
import com.anapedra.commerce.entities.enums.AddressType;
import java.io.Serializable;

public class AddressDTO implements Serializable {
    private static final long serialVersionUID=1L;

    private Long id;
    private AddressType addressType;
    private String street;
    private Integer number;
    private String cep;
    private String borhood;
    private String city;
    private String state;
    private String country;
    private String AddressComplement;
    private Long userId;


    public AddressDTO(){

    }

    public AddressDTO(Long id,AddressType addressType, String street, Integer number, String cep, String borhood,
                      String city, String state, String country, String addressComplement, Long userId ) {
        this.id = id;
        this.addressType = addressType;
        this.street = street;
        this.number = number;
        this.cep = cep;
        this.borhood = borhood;
        this.city = city;
        this.state = state;
        this.country = country;
        AddressComplement = addressComplement;
        this.userId = userId;
    }

    public AddressDTO(Address entity) {
        id = entity.getId();
        addressType = entity.getAddressType();
        street = entity.getStreet();
        number = entity.getNumber();
        cep = entity.getCep();
        borhood = entity.getBorhood();
        city = entity.getCity();
        state = entity.getState();
        country = entity.getCountry();
        AddressComplement = entity.getAddressComplement();
        userId = entity.getUser().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddressComplement() {
        return AddressComplement;
    }

    public void setAddressComplement(String addressComplement) {
        AddressComplement = addressComplement;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

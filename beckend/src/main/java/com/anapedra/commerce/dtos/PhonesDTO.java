package com.anapedra.commerce.dtos;

import com.anapedra.commerce.entities.Phones;
import com.anapedra.commerce.entities.enums.PhoneType;

import java.io.Serializable;
import java.util.Objects;

public class PhonesDTO implements Serializable {
    private static final long serialVersionUID=1L;

    private Long id;
    private Long userId;
    private String timeAvailability;
    private PhoneType phoneType;
    private String DDI;
    private String DDD;
    private String phone;

    public PhonesDTO(){

    }

    public PhonesDTO(Long id, Long userId, String timeAvailability, PhoneType phoneType, String DDI, String DDD, String phone) {
        this.id = id;
        this.userId = userId;
        this.timeAvailability = timeAvailability;
        this.phoneType = phoneType;
        this.DDI = DDI;
        this.DDD = DDD;
        this.phone = phone;
    }

    public PhonesDTO(Phones entity) {
        id = entity.getId();
        DDI = entity.getDDI();
        DDD = entity.getDDD();
        phone = entity.getPhone();
        timeAvailability = entity.getTimeAvailability();
        phoneType = entity.getPhoneType();
        userId=entity.getUser().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTimeAvailability() {
        return timeAvailability;
    }

    public void setTimeAvailability(String timeAvailability) {
        this.timeAvailability = timeAvailability;
    }

    public PhoneType getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }

    public String getDDI() {
        return DDI;
    }

    public void setDDI(String DDI) {
        this.DDI = DDI;
    }

    public String getDDD() {
        return DDD;
    }

    public void setDDD(String DDD) {
        this.DDD = DDD;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhonesDTO)) return false;
        PhonesDTO phonesDTO = (PhonesDTO) o;
        return Objects.equals(id, phonesDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

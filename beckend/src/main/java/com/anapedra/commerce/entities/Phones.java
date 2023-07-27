package com.anapedra.commerce.entities;

import com.anapedra.commerce.entities.enums.PhoneType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_phones")
public class Phones implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String DDI;
    private String DDD;
    private String phone;
    private String timeAvailability;
    private Integer phoneType;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public Phones(Long id, String DDI, String DDD, String phone, String timeAvailability, PhoneType phoneType,User user) {
        this.id = id;
        this.DDI = DDI;
        this.DDD = DDD;
        this.phone = phone;
        this.timeAvailability = timeAvailability;
        setPhoneType(phoneType);
        this.user=user;
    }

    public Phones() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getTimeAvailability() {
        return timeAvailability;
    }

    public void setTimeAvailability(String timeAvailability) {
        this.timeAvailability = timeAvailability;
    }

    public PhoneType getPhoneType() {
        return PhoneType.valueOf(phoneType);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPhoneType(PhoneType phoneType) {
        if (phoneType != null){
            this.phoneType = phoneType.getCode();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Phones)) return false;
        Phones phones = (Phones) o;
        return Objects.equals(getId(), phones.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

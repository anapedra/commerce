package com.anapedra.commerce.dtos;

import com.anapedra.commerce.entities.User;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class UserDTO implements Serializable {
    private static final long serialVersionUID=1L;
    private Long id;
    @NotBlank(message = "Campo obrigatório")
    private String name;
    private Instant momentRegistration;
    private Instant momentUpdate;
    @NotBlank(message = "Campo obrigatório")
    private String mainPhone;
    @Email
    private String registrationEmail;
    private Long additionalDataId;
    @CPF
    private String cpf;
    private Set<RoleDTO>roles=new HashSet<>();

    public UserDTO() {

    }

    public UserDTO(Long id, String name, Instant momentRegistration, Instant momentUpdate, String mainPhone,
                   String registrationEmail, Long additionalDataId, String cpf) {
        this.id = id;
        this.name = name;
        this.momentRegistration = momentRegistration;
        this.momentUpdate = momentUpdate;
        this.mainPhone = mainPhone;
        this.registrationEmail = registrationEmail;
        this.additionalDataId=additionalDataId;
        this.cpf=cpf;

    }


    public UserDTO(User entity) {
        id=entity.getId();
        name=entity.getName();
        momentRegistration=entity.getMomentRegistration();
        momentUpdate=entity.getMomentUpdate();
        mainPhone=entity.getMainPhone();
        registrationEmail=entity.getRegistrationEmail();
        cpf=entity.getCpf();


    }

    public UserDTO(Long id, String name, Instant momentRegistration, Instant momentUpdate, String mainPhone, String registrationEmail, String cpf) {
        this.id = id;
        this.name = name;
        this.momentRegistration = momentRegistration;
        this.momentUpdate = momentUpdate;
        this.mainPhone = mainPhone;
        this.registrationEmail = registrationEmail;
        this.cpf=cpf;


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getMomentRegistration() {
        return momentRegistration;
    }

    public void setMomentRegistration(Instant momentRegistration) {
        this.momentRegistration = momentRegistration;
    }

    public Instant getMomentUpdate() {
        return momentUpdate;
    }

    public void setMomentUpdate(Instant momentUpdate) {
        this.momentUpdate = momentUpdate;
    }

    public String getMainPhone() {
        return mainPhone;
    }

    public void setMainPhone(String mainPhone) {
        this.mainPhone = mainPhone;
    }

    public String getRegistrationEmail() {
        return registrationEmail;
    }

    public void setRegistrationEmail(String registrationEmail) {
        this.registrationEmail = registrationEmail;
    }

    public Long getAdditionalDataId() {
        return additionalDataId;
    }

    public void setAdditionalDataId(Long additionalDataId) {
        this.additionalDataId = additionalDataId;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Set<RoleDTO> getRoles() {
        return roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDTO)) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(getId(), userDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }


}

package com.anapedra.commerce.entities;

import com.anapedra.commerce.entities.enums.AddressType;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name = "tb_user")
public class User implements UserDetails,Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
   @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",timezone = "GMT")
    private Instant momentRegistration;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",timezone = "GMT")
    private Instant momentUpdate;
    private String mainPhone;
    @CPF
    private String cpf;
    @Email
    @Column(unique = true)
    private String registrationEmail;
    private String password;
    @OneToMany(mappedBy = "client")
    private List<Order>orders=new ArrayList<>();
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles=new HashSet<>();
    @OneToMany(mappedBy = "user")
    private List<Address>addresses=new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<Phones>phones=new ArrayList<>();


    public User(Long id, String name, Instant momentRegistration,
                Instant momentUpdate, String mainPhone, String cpf,
                String registrationEmail, String password) {
        this.id = id;
        this.name = name;
        this.momentRegistration = momentRegistration;
        this.momentUpdate = momentUpdate;
        this.mainPhone = mainPhone;
        this.cpf = cpf;
        this.registrationEmail = registrationEmail;
        this.password = password;

    }

    public User() {

    }

    public User(Long id, String name, Instant momentRegistration, Instant momentUpdate,
                String mainPhone, String cpf, String registrationEmail) {
        this.id = id;
        this.name = name;
        this.momentRegistration = momentRegistration;
        this.momentUpdate = momentUpdate;
        this.mainPhone = mainPhone;
        this.cpf = cpf;
        this.registrationEmail = registrationEmail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRegistrationEmail() {
        return registrationEmail;
    }

    public void setRegistrationEmail(String registrationEmail) {
        this.registrationEmail = registrationEmail;
    }
    public String getPassword() {
        return password;
    }
    public Set<Role> getRoles() {
        return roles;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public List<Phones> getPhones() {
        return phones;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getAuthority()))
                .collect(Collectors.toList());
    }

    public Long getShippingAddress(){
        AddressType add=AddressType.SHIPPING_ADDRESS;
        Long addressId=0L;
        for (Address address: addresses){
            if (address.getAddressType() == add){
            addressId=address.getId();
            }
        }
        return addressId;

    }
    public String getAddressCountry(){
        AddressType add=AddressType.SHIPPING_ADDRESS;
        String country="";
        for (Address address: addresses){
            if (address.getAddressType() == add){
            country=address.getCountry();
            }

        }
        return country;

    }

    public String getAddressState(){
        AddressType add=AddressType.SHIPPING_ADDRESS;
        String state="";
        for (Address address: addresses){
            if (address.getAddressType() == add){
                state=address.getState();
            }
        }
        return state;

    }

    public Integer getAddressNumber(){
        AddressType add=AddressType.SHIPPING_ADDRESS;
        int number=0;
        for (Address address: addresses){
            if (address.getAddressType() == add){
                number=address.getNumber();
            }
        }
        return number;

    }


    public String getAddressCep(){
        AddressType add=AddressType.SHIPPING_ADDRESS;
        String cep="";
        for (Address address: addresses){
            if (address.getAddressType() == add){
                cep=address.getCep();
            }
        }
        return cep;

    }


    @Override
    public String getUsername() {
        return getRegistrationEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;


    }

    public boolean hasHole(String roleName){
        for (Role role : roles){
            if (role.getAuthority().equals(roleName)){
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
























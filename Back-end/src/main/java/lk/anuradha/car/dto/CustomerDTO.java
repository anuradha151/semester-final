package lk.anuradha.car.dto;

import java.io.Serializable;

public class CustomerDTO implements Serializable {

    private Long id;
    private String name;
    private String address;
    private String email;
    private String passport;
    private String nic;

    public CustomerDTO() {
    }

    public CustomerDTO(Long id, String name, String address, String email, String passport, String nic) {
        this.setId(id);
        this.setName(name);
        this.setAddress(address);
        this.setEmail(email);
        this.setPassport(passport);
        this.setNic(nic);
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", passport='" + getPassport() + '\'' +
                ", nic='" + getNic() + '\'' +
                '}';
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }
}

package lk.anuradha.car.dto;

public class CustomerDTO {

    private String id;
    private String name;
    private String address;
    private String email;
    private String passport;
    private String NIC;

    public CustomerDTO() {
    }

    public CustomerDTO(String id, String name, String address, String email, String passport, String NIC) {
        this.setId(id);
        this.setName(name);
        this.setAddress(address);
        this.setEmail(email);
        this.setPassport(passport);
        this.setNIC(NIC);
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", passport='" + passport + '\'' +
                ", NIC='" + NIC + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }
}

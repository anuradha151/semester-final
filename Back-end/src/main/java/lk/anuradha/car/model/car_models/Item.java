package lk.anuradha.car.model.car_models;

import javax.persistence.*;

//@Entity
public class Item {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long code;
//    @Column(name = "description")
    private String description;
//    @Column(name = "price")
    private double price;

    public Item() {
    }

    public Item(long code, String description, double price) {
        this.setCode(code);
        this.setDescription(description);
        this.setPrice(price);
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "code=" + getCode() +
                ", description='" + getDescription() + '\'' +
                ", price=" + getPrice() +
                '}';
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

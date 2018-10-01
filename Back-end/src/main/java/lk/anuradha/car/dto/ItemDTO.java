package lk.anuradha.car.dto;

import java.io.Serializable;

public class ItemDTO implements Serializable {
    private long code;
    private String description;
    private double price;

    public ItemDTO() {
    }

    public ItemDTO(long code, String description, double price) {
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

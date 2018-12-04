package lk.anuradha.car.dto;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class CropDetailsDTO implements Serializable {

    private int crop_pk;
    private String crop_id;
    private int crop_details_id;
    @NotNull
    @Size(min = 2)
    @Pattern(regexp = "^([A-Za-z0-9.,\\s])*$")
    private String name;
    @NotNull
    @Pattern(regexp = "^(en|si|ta)$")
    private String language;
    @NotNull
    private int crop_type_id;
    private String url;
    private double price;

    public CropDetailsDTO() {
    }

    public CropDetailsDTO(int crop_pk, String crop_id, String name, String url) {
        this.crop_pk = crop_pk;
        this.crop_id = crop_id;
        this.name = name;
        this.url = url;
    }

    public CropDetailsDTO(int crop_pk, String crop_id, String name, String url, Double price) {
        this.crop_pk = crop_pk;
        this.crop_id = crop_id;
        this.name = name;
        this.url = url;
        this.price =  price;
    }

    public CropDetailsDTO(int crop_pk, String crop_id, String name, String url, int crop_type_id) {
        this.crop_pk = crop_pk;
        this.crop_id = crop_id;
        this.name = name;
        this.url=url;
        this.crop_type_id=crop_type_id;
    }

    public CropDetailsDTO(int crop_pk, String crop_id, String name, String url, int crop_type_id, Double price) {
        this.crop_pk = crop_pk;
        this.crop_id = crop_id;
        this.name = name;
        this.url=url;
        this.crop_type_id=crop_type_id;
        this.price =  price;
    }

    public CropDetailsDTO(int crop_details_id, String name, String language) {
        this.crop_details_id = crop_details_id;
        this.name = name;
        this.language = language;
    }

    public CropDetailsDTO(int crop_pk, @NotNull @Size(min = 2) @Pattern(regexp = "^([A-Za-z0-9.,\\s])*$") String name, String url, double price) {
        this.crop_pk = crop_pk;
        this.name = name;
        this.url = url;
        this.price = price;
    }

    @Override
    public String toString() {
        return "CropDetailsDTO{" +
                "crop_details_id=" + crop_details_id +
                ", name='" + name + '\'' +
                ", language='" + language + '\'' +
                ", crop_type='" + crop_type_id + '\'' +
                '}';
    }

    public int getCrop_details_id() {
        return crop_details_id;
    }

    public void setCrop_details_id(int crop_details_id) {
        this.crop_details_id = crop_details_id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getCrop_type_id() {
        return crop_type_id;
    }

    public void setCrop_type_id(int crop_type) {
        this.crop_type_id = crop_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCrop_pk() {
        return crop_pk;
    }

    public void setCrop_pk(int crop_pk) {
        this.crop_pk = crop_pk;
    }

    public String getCrop_id() {
        return crop_id;
    }

    public void setCrop_id(String crop_id) {
        this.crop_id = crop_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

package org.codewithsoly.shopservice.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private Double price;

    private String category;
    private String imageUrl;

//    public Integer getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public Double getPrice() {
//        return price;
//    }
//
//    public String getCategory() {
//        return category;
//    }
//
//    public String getImageUrl() {
//        return imageUrl;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public void setPrice(Double price) {
//        this.price = price;
//    }
//
//    public void setCategory(String category) {
//        this.category = category;
//    }
//
//    public void setImageUrl(String imageUrl) {
//        this.imageUrl = imageUrl;
//    }
}

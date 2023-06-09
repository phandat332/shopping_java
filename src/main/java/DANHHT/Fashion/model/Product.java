package DANHHT.Fashion.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idProduct;
    @Column(name = "name")
    private String nameProduct;
    @Column(name = "price")
    private double priceProduct;
    @Column(name = "img")
    private String imgProduct;
    @Column(name = "imgCover")
    private String imgCoverProduct;
    @Column(name = "description", length = 10000)
    private String desProduct;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
    @ManyToMany
    @JoinTable(name = "product_size",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "size_id"))
    private List<Size> size;

}

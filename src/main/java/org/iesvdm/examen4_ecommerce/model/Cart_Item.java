package org.iesvdm.examen4_ecommerce.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "cart_item")
public class Cart_Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", nullable = false, foreignKey = @ForeignKey(name = "FK_PRODUCT"))
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "created_date")
    @JsonFormat(pattern = "yyy-MM-dd-HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private Date created_date;

    @Column(name = "modified_date")
    @JsonFormat(pattern = "yyy-MM-dd-HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private Date modified_date;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name = "FK_USER"))
    private User user;

}

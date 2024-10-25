package ibradi.dev.my_store.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder

@Entity
@Table(name = "product_table")
@SequenceGenerator(name = "generator2", sequenceName = "gen2", initialValue = 5000)
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator2")
	@Column(name = "product_id")
	private long productId;

	@NotEmpty(message = "Product name is required.")
	@Column(name = "productname", nullable = false, length = 20)
	private String productname;

	@Column(name = "product_image")
	@NotEmpty
	private String image;
//	


	@NotEmpty(message = "Product description is required.")
	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "mrp_price", nullable = false, precision = 10)
	private double mrpPrice;

	//	//@Size(min = 2, max = 10)
//		@Column(name = "price", nullable = false, precision = 10, scale = 2)
//	    private double price;
//	
	@Column(name = "quantity")
	private long quantity;

//	@Column(name = "cart_id")
//	private long cartId;

	private Category category;

	@Column(name = "measurment")
	private String measurment;


	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productname=" + productname + ", description=" + description + ", mrpPrice=" + mrpPrice + ", quantity=" + quantity + "]";
	}

}
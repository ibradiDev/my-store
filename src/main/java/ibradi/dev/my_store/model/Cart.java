package ibradi.dev.my_store.model;

import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "cart_table")
@SequenceGenerator(name = "generator3", sequenceName = "gen3", initialValue = 1500)
@NoArgsConstructor
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator3")
	@Column(name = "cart_id")
	private long cartId;


	@Column(name = "quantity")
	private long quantity;

	@Column(name = "mrp_price", nullable = false)
	private double mrpPrice;


	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "product_id")
	//@JsonIgnore
	private Product product;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "customer_id")
	private Customer customer;


	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", quantity=" + quantity + ", mrpPrice=" + mrpPrice + ", product=" + product
				+ ", customer=" + customer + "]";
	}


}
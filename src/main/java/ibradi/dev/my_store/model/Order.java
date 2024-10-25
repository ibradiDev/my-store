package ibradi.dev.my_store.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.sql.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "order_table")
@SequenceGenerator(name = "generator6", sequenceName = "gen", initialValue = 1000)
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator6")
	@Column(name = "order_id")
	private long orderId;

	@Column(name = "mrp_price")
	private double mrpPrice;

	@Column(name = "quantity")
	private long quantity;

	@Column(name = "total_price")
	private double totalPrice;

	@Column(name = "order_status")
	private String orderStatus;

	@Column(name = "payment_status")
	private String paymentStatus;

	@Column(name = "ordered_date")
	private Date orderedDate;

	@NotEmpty(message = "Product name is required.")
	@Column(name = "productname", nullable = false, length = 20)
	private String productname;

	@Column(name = "product_image")
	@NotEmpty
	private String image;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(
			name = "order_product",
			joinColumns = @JoinColumn(name = "order_id"),
			inverseJoinColumns = @JoinColumn(name = "product_id")
	)
	private List<Product> products;

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", mrpPrice=" + mrpPrice + ", quantity=" + quantity + ", totalPrice=" + totalPrice + ", orderStatus=" + orderStatus + ", paymentStatus=" + paymentStatus + ", orderedDate=" + orderedDate + ", customer=" + customer + "]";
	}
}
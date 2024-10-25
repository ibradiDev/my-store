package ibradi.dev.my_store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "payment_table")
@SequenceGenerator(name = "generator5", sequenceName = "gen5", initialValue = 100)
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator5")
	@Column(name = "payment_id")
	private long paymentId;


	@Column(name = "total_price")
	private double totalPrice;

	@Column(name = "order_id", unique = true)
	private long orderId;


	@Column(name = "name_on_card")
	@NotEmpty
	@Size(min = 3, message = "name must contain atleast 3 characters")
	private String nameOnCard;

	@Column(name = "card_number")
	@NotEmpty
	@Size(min = 16, max = 16, message = "cardNumber must contain 16 digits")
	private String cardNumber;

	@Column(name = "exp_year")
	private String expYear;

	@Column(name = "cvv")
	@NotNull
	private int cvv;

	@Column(name = "paid_date")
	private LocalDate PaidDate;

	@Column(name = "paid_amount", nullable = false)
	private double paidAmount;

//@Column(name="paid_date")
//private Date paidDate;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "customer__id")
	@JsonIgnore
	private Customer customer;


	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", totalPrice=" + totalPrice + ", orderId=" + orderId + ", nameOnCard=" + nameOnCard + ", cardNumber=" + cardNumber + ", expYear=" + expYear + ", cvv=" + cvv + ", PaidDate=" + PaidDate + ", paidAmount=" + paidAmount + ", customer=" + customer + "]";
	}


}
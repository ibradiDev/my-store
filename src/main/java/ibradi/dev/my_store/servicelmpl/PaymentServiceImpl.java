package ibradi.dev.my_store.servicelmpl;

import ibradi.dev.my_store.exception.ResourceNotFoundException;
import ibradi.dev.my_store.model.Customer;
import ibradi.dev.my_store.model.Order;
import ibradi.dev.my_store.model.Payment;
import ibradi.dev.my_store.repository.OrderRepository;
import ibradi.dev.my_store.repository.PaymentRepository;
import ibradi.dev.my_store.service.CustomerService;
import ibradi.dev.my_store.service.OrderService;
import ibradi.dev.my_store.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@AllArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService {

	private PaymentRepository paymentRepository;
	private OrderRepository orderRepository;

	private CustomerService customerService;
	private OrderService orderService;


	@Override
	public Payment addPayment(Payment payment, long orderId, long customerId) {

		// TODO Auto-generated method stub
		Order order = orderRepository.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("Order", "orderId", orderId));
		payment.setOrderId(orderId);
		payment.setTotalPrice(order.getTotalPrice());
		payment.setPaidDate(LocalDate.now());
		payment.setPaidAmount(order.getTotalPrice());
		if (payment.getTotalPrice() == payment.getPaidAmount()) {
			order.setPaymentStatus("PAID");
			order.setOrderStatus("Delivered");
		} else {

			order.setPaymentStatus("NOT-PAID");
			order.setOrderStatus("payment pending");
		}
		Customer customer = customerService.getCustomerById(customerId);

		payment.setCustomer(customer);

		//return paymentRepository.save(payment);

		return paymentRepository.save(payment);

	}
	// order = orderService.getOrderById(orderId);
	//payment.setOrderId(order.getOrderId());
	//payment.setTotalPrice(payment.getTotalPrice());
	//payment.setPaidDate(payment.getPaidDate());


	@Override
	public List<Payment> getAllPayments() {
		return paymentRepository.findAll();
	}

	@Override
	public List<Payment> getAllPaymentsByCustomerId(long customerId) {
		return paymentRepository.findByOrderId(customerId);
	}


	@Override
	public Payment getPaymentById(long paymentId) {

		return paymentRepository.findById(paymentId).orElseThrow(() -> new ResourceNotFoundException("Payement", "Id", paymentId));
	}


	@Override
	public void deletePayment(long paymentId) {
		paymentRepository.findById(paymentId).orElseThrow(() -> new ResourceNotFoundException("Payement", "Id", paymentId));
		paymentRepository.deleteById(paymentId);

	}

}
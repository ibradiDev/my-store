package ibradi.dev.my_store.service;


import ibradi.dev.my_store.model.Payment;

import java.util.List;


public interface PaymentService {

	Payment addPayment(Payment payment, long orderId, long customerId);

	List<Payment> getAllPayments();

	Payment getPaymentById(long paymentId);

	void deletePayment(long paymentId);

	public List<Payment> getAllPaymentsByCustomerId(long customerId);
}
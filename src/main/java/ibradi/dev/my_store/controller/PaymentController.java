package ibradi.dev.my_store.controller;


import ibradi.dev.my_store.model.Payment;
import ibradi.dev.my_store.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")

@AllArgsConstructor
@RestController // is controller which provides different end points to access the services
@RequestMapping("/api/payements")
public class PaymentController {
	private PaymentService paymentService;

	@PostMapping("{orderId}/{customerId}")
	public ResponseEntity<Payment> addPayment(@RequestBody Payment payment, @PathVariable long orderId,
	                                          @PathVariable long customerId) {

		return new ResponseEntity<Payment>(paymentService.addPayment(payment, orderId, customerId),
				HttpStatus.CREATED);
	}

	// getting list of payements
	@GetMapping
	public List<Payment> getAlPayments() {
		return paymentService.getAllPayments();
	}

	// to get payement by payement id(for receipt)

	@GetMapping("{paymentId}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable("paymentId") long paymentId) {
		return new ResponseEntity<Payment>(paymentService.getPaymentById(paymentId), HttpStatus.OK);
	}

	// to delete payement
	@DeleteMapping("{paymentId}")
	public ResponseEntity<Boolean> deletePayment(@PathVariable("paymentId") long paymentId) {
		paymentService.deletePayment(paymentId);
		boolean flag = true;
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
	}
}
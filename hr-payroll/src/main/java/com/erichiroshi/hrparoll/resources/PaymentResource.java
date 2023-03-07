package com.erichiroshi.hrparoll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erichiroshi.hrparoll.entities.Payment;
import com.erichiroshi.hrparoll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/payments")
public class PaymentResource {

	@Autowired
	private PaymentService paymentService;

	@HystrixCommand(fallbackMethod = "getPaymentAlternative")
	@GetMapping("/{workeyId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workeyId, @PathVariable Integer days) {
		return ResponseEntity.ok(paymentService.getPayment(workeyId, days));
	}

	public ResponseEntity<Payment> getPaymentAlternative(Long workeyId, Integer days) {
		return ResponseEntity.ok(new Payment("Brann", 400.0, days));
	}

}

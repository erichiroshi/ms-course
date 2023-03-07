package com.erichiroshi.hrparoll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erichiroshi.hrparoll.entities.Payment;
import com.erichiroshi.hrparoll.services.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentResource {

	@Autowired
	private PaymentService paymentService;

	@GetMapping("/{workeyId}/days/{days}")
	public ResponseEntity<Payment> payment(@PathVariable Long workeyId, @PathVariable Integer days) {
		return ResponseEntity.ok(paymentService.getPayment(workeyId, days));
	}
}

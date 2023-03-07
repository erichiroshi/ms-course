package com.erichiroshi.hrworker.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erichiroshi.hrworker.entities.Worker;
import com.erichiroshi.hrworker.repositories.WorkerRepository;

@RestController
@RequestMapping("/workers")
public class WorkerResource {

	@Autowired
	private WorkerRepository repository;

	@GetMapping
	public ResponseEntity<List<Worker>> listAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) {
		return ResponseEntity.ok(repository.findById(id).orElseThrow());
	}

}

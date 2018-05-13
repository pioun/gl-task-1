package com.globallogic.task.controller;

import com.globallogic.task.model.Office;
import com.globallogic.task.repository.OfficeRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping(value = "/office", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OfficeController {

    private final OfficeRepository officeRepository;

    public OfficeController(final OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Office>> getAll() {
        return ResponseEntity.ok(officeRepository.findAll());
    }


    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Office> post(@RequestBody final Office office) {
        return ResponseEntity.ok(officeRepository.save(office));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Office> get(@PathVariable long id) {
        return ResponseEntity.ok(officeRepository.findById(id).orElseThrow(EntityNotFoundException::new));
    }
}

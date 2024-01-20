package ec.edu.espam.api.caja.controller;

import ec.edu.espam.api.caja.domain.dto.MovementDto;
import ec.edu.espam.api.caja.service.MovementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimientos")
@RequiredArgsConstructor
public class MovementController {

    private final MovementService service;

    @PostMapping
    public ResponseEntity<MovementDto> create(@Valid @RequestBody MovementDto dto) {
        return new ResponseEntity<>(service.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovementDto> update(@PathVariable Long id, @Valid @RequestBody MovementDto dto) {
        return new ResponseEntity<>(service.update(id, dto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovementDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<MovementDto>> getAll(@RequestParam(value = "accountId", required = false) Long accountId) {
        return ResponseEntity.ok(service.getAll(accountId));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}

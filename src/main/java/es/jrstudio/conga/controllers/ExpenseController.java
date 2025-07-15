package es.jrstudio.conga.controllers;

import es.jrstudio.conga.model.ExpenseDTO;
import es.jrstudio.conga.services.ExpenseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
@CrossOrigin(origins = "*")
public class ExpenseController {
    private final ExpenseService service;
    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    @PostMapping
    public ExpenseDTO add(@RequestBody ExpenseDTO dto) {
        return service.save(dto);
    }
    @GetMapping
    public List<ExpenseDTO> getAll(@RequestParam String type) {
        return service.listBy(type);
    }
}

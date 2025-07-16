package es.jrstudio.conga.controllers;

import es.jrstudio.conga.model.Expense;
import es.jrstudio.conga.model.ExpenseDTO;
import es.jrstudio.conga.model.Message;
import es.jrstudio.conga.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
@CrossOrigin(origins = "*")
public class ExpenseController {
    @Autowired
    ExpenseService expenseService;

    @GetMapping("/list")
    public ResponseEntity<List<Expense>> list() {
        List<Expense> list = expenseService.expenseList();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Expense> getById(@PathVariable("id") Long id) {
        if(!expenseService.existsById(id))
            return new ResponseEntity(new Message("Expense NO exists"), HttpStatus.NOT_FOUND);
        Expense expense = expenseService.getOne(id).get();
        return new ResponseEntity(expense, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ExpenseDTO expenseDTO) {
        if (expenseDTO.getDate() == null)
            return new ResponseEntity(new Message("Date is mandatory"), HttpStatus.BAD_REQUEST);

        if (expenseDTO.getCategory() == null)
            return new ResponseEntity(new Message("Category is mandatory"), HttpStatus.BAD_REQUEST);

        if (expenseDTO.getAmount() == null)
            return new ResponseEntity(new Message("Amount is mandatory"), HttpStatus.BAD_REQUEST);

        if (expenseDTO.getType() == null)
            return new ResponseEntity(new Message("Type is mandatory"), HttpStatus.BAD_REQUEST);


        Expense expense = new Expense(expenseDTO.getCategory(), expenseDTO.getAmount(), expenseDTO.getDate(), expenseDTO.getType());

        expenseService.save(expense);
        return new ResponseEntity(new Message("Expense generated"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")Long id){
        if(!expenseService.existsById(id))
            return new ResponseEntity(new Message("Expense NO exists"), HttpStatus.NOT_FOUND);
        expenseService.delete(id);
        return new ResponseEntity(new Message("Expense deleted"), HttpStatus.OK);
    }
}

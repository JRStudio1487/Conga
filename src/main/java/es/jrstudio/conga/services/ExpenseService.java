package es.jrstudio.conga.services;

import es.jrstudio.conga.model.ExpenseDTO;

import java.util.List;

public interface ExpenseService {
    ExpenseDTO save(ExpenseDTO dto);
    List<ExpenseDTO> listBy(String type);
}

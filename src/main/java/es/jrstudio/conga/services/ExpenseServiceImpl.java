package es.jrstudio.conga.services;

import es.jrstudio.conga.model.Expense;
import es.jrstudio.conga.model.ExpenseDTO;
import es.jrstudio.conga.model.ExpenseType;
import es.jrstudio.conga.repositories.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    private final ExpenseRepository repo;
    public ExpenseServiceImpl(ExpenseRepository repo) {
        this.repo = repo;
    }

    @Override
    public ExpenseDTO save(ExpenseDTO dto) {
        Expense e = new Expense();
        e.setId(dto.getId());
        e.setCategory(dto.getCategory());
        e.setAmount(dto.getAmount());
        e.setDate(dto.getDate());
        e.setType(ExpenseType.valueOf(dto.getType()));
        Expense saved = repo.save(e);
        dto.setId(saved.getId());
        return dto;
    }
    @Override
    public List<ExpenseDTO> listBy(String type) {
        ExpenseType t = ExpenseType.valueOf(type);
        return repo.findByType(t)
                .stream()
                .map(e -> {
                    ExpenseDTO dto = new ExpenseDTO();
                    dto.setId(e.getId());
                    dto.setCategory(e.getCategory());
                    dto.setAmount(e.getAmount());
                    dto.setDate(e.getDate());
                    dto.setType(e.getType().name());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}

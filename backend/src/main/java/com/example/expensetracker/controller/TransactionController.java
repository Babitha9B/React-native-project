package com.example.expensetracker.controller;
import com.example.expensetracker.dto.TransactionRequest;
import com.example.expensetracker.model.*;
import com.example.expensetracker.repository.TransactionRepository;
import com.example.expensetracker.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.time.*;
import java.util.*;
@RestController @RequestMapping("/api/transactions") @CrossOrigin(origins="*")
public class TransactionController {
 private final TransactionService service; private final TransactionRepository repository;
 public TransactionController(TransactionService service,TransactionRepository repository){this.service=service;this.repository=repository;}
 @GetMapping public List<Transaction> all(@RequestParam(required=false) TransactionType type){return type==null?service.getAll():service.getByType(type);}
 @PostMapping public Transaction create(@Valid @RequestBody TransactionRequest request){return service.create(request);}
 @PutMapping("/{id}") public Transaction update(@PathVariable Long id,@Valid @RequestBody TransactionRequest request){return service.update(id,request);}
 @DeleteMapping("/{id}") public Map<String,String> delete(@PathVariable Long id){service.delete(id);return Map.of("message","Transaction deleted");}
 @GetMapping("/summary") public Map<String,Object> summary(@RequestParam(required=false) Integer month,@RequestParam(required=false) Integer year){
  LocalDate now=LocalDate.now(); int m=month==null?now.getMonthValue():month; int y=year==null?now.getYear():year;
  if(m<1||m>12) throw new IllegalArgumentException("month must be between 1 and 12");
  LocalDate start=LocalDate.of(y,m,1), end=start.withDayOfMonth(start.lengthOfMonth());
  List<Transaction> items=repository.findByTransactionDateBetweenOrderByTransactionDateDesc(start,end);
  BigDecimal income=items.stream().filter(t->t.getType()==TransactionType.INCOME).map(Transaction::getAmount).reduce(BigDecimal.ZERO,BigDecimal::add);
  BigDecimal expenses=items.stream().filter(t->t.getType()==TransactionType.EXPENSE).map(Transaction::getAmount).reduce(BigDecimal.ZERO,BigDecimal::add);
  return Map.of("month",m,"year",y,"income",income,"expenses",expenses,"balance",income.subtract(expenses));
 }
}
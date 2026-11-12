package com.example.expensetracker.service;
import com.example.expensetracker.dto.TransactionRequest;
import com.example.expensetracker.model.*;
import com.example.expensetracker.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
@Service
public class TransactionService {
 private final TransactionRepository repository;
 public TransactionService(TransactionRepository repository){this.repository=repository;}
 public List<Transaction> getAll(){return repository.findAllByOrderByTransactionDateDescIdDesc();}
 public List<Transaction> getByType(TransactionType type){return repository.findByTypeOrderByTransactionDateDescIdDesc(type);}
 public Transaction create(TransactionRequest r){Transaction t=new Transaction(); apply(t,r); return repository.save(t);}
 public Transaction update(Long id,TransactionRequest r){Transaction t=repository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Transaction not found")); apply(t,r); return repository.save(t);}
 public void delete(Long id){if(!repository.existsById(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Transaction not found"); repository.deleteById(id);}
 private void apply(Transaction t,TransactionRequest r){t.setTitle(r.title().trim());t.setAmount(r.amount());t.setType(r.type());t.setCategory(r.category().trim());t.setTransactionDate(r.transactionDate());t.setNotes(r.notes());}
}
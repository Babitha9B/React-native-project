package com.example.expensetracker.repository;
import com.example.expensetracker.model.Transaction;
import com.example.expensetracker.model.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
 List<Transaction> findAllByOrderByTransactionDateDescIdDesc();
 List<Transaction> findByTypeOrderByTransactionDateDescIdDesc(TransactionType type);
 List<Transaction> findByTransactionDateBetweenOrderByTransactionDateDesc(LocalDate start, LocalDate end);
}
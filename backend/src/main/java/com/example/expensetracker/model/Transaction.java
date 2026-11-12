package com.example.expensetracker.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@Table(name="transactions")
public class Transaction {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,length=100) private String title;
 @Column(nullable=false,precision=12,scale=2) private BigDecimal amount;
 @Enumerated(EnumType.STRING) @Column(nullable=false,length=10) private TransactionType type;
 @Column(nullable=false,length=50) private String category;
 @Column(nullable=false) private LocalDate transactionDate;
 @Column(length=500) private String notes;
 public Long getId(){return id;} public void setId(Long id){this.id=id;}
 public String getTitle(){return title;} public void setTitle(String title){this.title=title;}
 public BigDecimal getAmount(){return amount;} public void setAmount(BigDecimal amount){this.amount=amount;}
 public TransactionType getType(){return type;} public void setType(TransactionType type){this.type=type;}
 public String getCategory(){return category;} public void setCategory(String category){this.category=category;}
 public LocalDate getTransactionDate(){return transactionDate;} public void setTransactionDate(LocalDate transactionDate){this.transactionDate=transactionDate;}
 public String getNotes(){return notes;} public void setNotes(String notes){this.notes=notes;}
}
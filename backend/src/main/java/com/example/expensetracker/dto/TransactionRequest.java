package com.example.expensetracker.dto;
import com.example.expensetracker.model.TransactionType;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
popoopo
import java.time.LocalDate;
public record TransactionRequest(@NotBlank @Size(max=100) String title, @NotNull @DecimalMin("0.01") BigDecimal amount, @NotNull TransactionType type, @NotBlank @Size(max=50) String category, @NotNull LocalDate transactionDate, @Size(max=500) String notes) {}
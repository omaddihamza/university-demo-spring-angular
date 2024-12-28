package org.example.universitydemospringang.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private Double amount;
    @Enumerated(EnumType.STRING)
    private PaymetType type;
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;
    private String file;
    @ManyToOne
    private Student student;
}

package org.example.universitydemospringang.entities;

import jakarta.persistence.*;
import lombok.*;
import org.example.universitydemospringang.enumeration.PaymentStatus;
import org.example.universitydemospringang.enumeration.PaymetType;

import java.time.LocalDate;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter  @Setter
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

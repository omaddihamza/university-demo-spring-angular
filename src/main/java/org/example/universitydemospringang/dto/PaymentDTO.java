package org.example.universitydemospringang.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.universitydemospringang.enumeration.PaymetType;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentDTO {
    private LocalDate date;
    private Double amount;
    private PaymetType type;
    private String studentCode;
}

package org.example.universitydemospringang.mappers;

import org.example.universitydemospringang.dto.PaymentDTO;
import org.example.universitydemospringang.entities.Payment;

public class PaymentMapper {
    public static PaymentDTO toDto(Payment payment) {
      return  PaymentDTO.builder()
              .id(payment.getId())
              .date(payment.getDate())
              .amount(payment.getAmount())
              .type(payment.getType())
              .status(payment.getStatus())
              .file(payment.getFile())
              .studentCode(payment.getStudent().getCode())
              .build();
    }

    public static Payment toEntity(PaymentDTO paymentDTO) {
        return Payment.builder()
                 .id(paymentDTO.getId())
                 .date(paymentDTO.getDate())
                .amount(paymentDTO.getAmount())
                .type(paymentDTO.getType())
                .status(paymentDTO.getStatus())
                .file(paymentDTO.getFile())
                .build();
    }
}

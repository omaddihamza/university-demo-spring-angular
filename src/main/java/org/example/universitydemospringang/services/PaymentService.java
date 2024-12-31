package org.example.universitydemospringang.services;

import org.example.universitydemospringang.entities.Payment;
import org.example.universitydemospringang.enumeration.PaymentStatus;
import org.example.universitydemospringang.enumeration.PaymetType;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface PaymentService {
    void savePayment(Payment payment);
    List<Payment> getPayments();
    Payment getPaymentById(Long id);
    void deletePaymentById(int id);
    List<Payment> getPaymentsByStudent(String code);
    List<Payment> getPaymentsByStatus(PaymentStatus status);
    List<Payment> getPaymentsByType(PaymetType type);
    Payment updatePaymentStatus(PaymentStatus status, Long id);
    Payment save(MultipartFile file, LocalDate date, double amount, PaymetType type, String studentId) throws IOException;
    byte[] gePaymentFile(Long id) throws IOException;
}

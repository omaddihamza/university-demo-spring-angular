package org.example.universitydemospringang.repository;

import org.example.universitydemospringang.entities.Payment;
import org.example.universitydemospringang.entities.PaymentStatus;
import org.example.universitydemospringang.entities.PaymetType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByStudent_Code(String studentCode);
    List<Payment> findByStatus(PaymentStatus status);
    List<Payment> findByType(PaymetType type);
}

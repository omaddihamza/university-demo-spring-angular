package org.example.universitydemospringang.services;

import org.example.universitydemospringang.dto.PaymentDTO;
import org.example.universitydemospringang.entities.Payment;
import org.example.universitydemospringang.entities.Student;
import org.example.universitydemospringang.enumeration.PaymentStatus;
import org.example.universitydemospringang.enumeration.PaymetType;
import org.example.universitydemospringang.repository.PaymentRepository;
import org.example.universitydemospringang.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class PaymentServiceImp implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void savePayment(Payment payment) {
       paymentRepository.save(payment);
    }

    @Override
    public List<Payment> getPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id).get();
    }

    @Override
    public void deletePaymentById(int id) {

    }

    @Override
    public List<Payment> getPaymentsByStudent(String code) {
        return paymentRepository.findByStudent_Code(code);
    }

    @Override
    public List<Payment> getPaymentsByStatus(PaymentStatus status) {
        return paymentRepository.findByStatus(status);
    }

    @Override
    public List<Payment> getPaymentsByType(PaymetType type) {
        return paymentRepository.findByType(type);
    }

    @Override
    public Payment updatePaymentStatus(PaymentStatus status, Long id) {
        Payment payment = paymentRepository.findById(id).get();
        payment.setStatus(status);
        return paymentRepository.save(payment);
    }

    @Override
    public Payment save(MultipartFile file, PaymentDTO paymentDTO) throws IOException {

        Path folderPath = Paths.get("C:/spring/university/payments/");
        if(!folderPath.toFile().exists()){
            Files.createDirectories(folderPath);
        }
        String uniqueFileName = paymentDTO.getStudentCode() + "_" + UUID.randomUUID() + ".pdf";
        Path filePath = folderPath.resolve(uniqueFileName);

        Files.copy(file.getInputStream(), filePath);
        Student student = studentRepository.findByCode(paymentDTO.getStudentCode());
        Payment payment = Payment.builder()

                .date(paymentDTO.getDate())
                .type(paymentDTO.getType())
                .amount(paymentDTO.getAmount())
                .student(student)
                .status(PaymentStatus.CREATED)
                .file(filePath.toUri().toString())
                .build();
        return paymentRepository.save(payment);
    }

    @Override
    public byte[] gePaymentFile(Long id) throws IOException {
        Payment payment = paymentRepository.findById(id).get();
        return Files.readAllBytes(Path.of(URI.create(payment.getFile())));
    }
}

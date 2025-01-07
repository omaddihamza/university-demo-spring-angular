package org.example.universitydemospringang.endpoint;

import org.example.universitydemospringang.entities.Payment;
import org.example.universitydemospringang.enumeration.PaymentStatus;
import org.example.universitydemospringang.enumeration.PaymetType;
import org.example.universitydemospringang.services.PaymentService;
import org.example.universitydemospringang.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/api/")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private StudentService studentService;

    @PostMapping(path = "savePayment")
    public void savePayment(Payment payment) {
        paymentService.savePayment(payment);
    }

    @GetMapping(path = "payments")
    public List<Payment> getPayments() {
        return paymentService.getPayments();
    }

    @GetMapping(path = "payment/{id}")
    public Payment getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }

    @DeleteMapping("deletePayment/{id}")
    public void deletePaymentById(@PathVariable int id) {
        paymentService.deletePaymentById(id);
    }

    @GetMapping(path = "students/{code}/payment")
    public List<Payment> getPaymentsByStudent(@PathVariable String code) {
        return paymentService.getPaymentsByStudent( code);
    }

    @GetMapping("paymentsByStatus")
    public List<Payment> getPaymentsByStatus(@RequestParam PaymentStatus status) {
        return paymentService.getPaymentsByStatus(status);
    }

    @GetMapping("paymentsByType")
    public List<Payment> getPaymentsByType(@RequestParam PaymetType type) {
        return paymentService.getPaymentsByType(type);
    }

    @PutMapping("payment/{id}")
    public Payment updatePaymentStatus(@RequestParam PaymentStatus status,@PathVariable Long id) {
        return paymentService.updatePaymentStatus(status, id);
    }

    @PostMapping(path = "payments", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Payment save(@RequestParam("file") MultipartFile file, LocalDate date, double amount, PaymetType type, String studentCode) throws IOException {
        return paymentService.save(file, date, amount, type, studentCode);
    }

    @GetMapping(path = "paymentFile/{id}", consumes = MediaType.APPLICATION_PDF_VALUE)
    public byte[] gePaymentFile(@PathVariable Long id) throws IOException {
        return paymentService.gePaymentFile(id);
    }
}

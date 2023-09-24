package bills.example.SriCareBillGeneration.controller;

import bills.example.SriCareBillGeneration.dto.PaymentResponse;
import bills.example.SriCareBillGeneration.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @GetMapping("/payment/{userId}/{billId}")
    public PaymentResponse bill_payment(@PathVariable Integer userId, @PathVariable Integer billId){
        return paymentService.paymentDone(userId,billId);
    }



}

package bills.example.SriCareBillGeneration.controller;

import bills.example.SriCareBillGeneration.dto.PaymentResponse;
import bills.example.SriCareBillGeneration.dto.ServiceDTO;
import bills.example.SriCareBillGeneration.service.BillService;
import bills.example.SriCareBillGeneration.service.ServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BillController {
    private final BillService billService;
//
    @PutMapping("/generate/{userId}/{billId}")
    public void getBills(
         @PathVariable Integer billId,
         @PathVariable Integer userId){

         billService.services(userId,billId);
    }

    //
    @GetMapping("/bills/{userId}")
    public ServiceDTO generate_bill(@PathVariable Integer userId){

        return
                billService.generateBill(userId);



    }

//    @GetMapping("/bills/{userId}/{billId}")
//    public PaymentResponse bill_payment(@PathVariable Integer userId, @PathVariable Integer billId){
//        return paymentService.paymentDone(userId,billId);
//    }

//    @PutMapping
}

package bills.example.SriCareBillGeneration.service;

import bills.example.SriCareBillGeneration.dto.PaymentResponse;
import bills.example.SriCareBillGeneration.entity.Bill;
import bills.example.SriCareBillGeneration.entity.Payment;
import bills.example.SriCareBillGeneration.entity.UserInfo;
import bills.example.SriCareBillGeneration.repository.BillRepository;
import bills.example.SriCareBillGeneration.repository.PaymentRepository;
import bills.example.SriCareBillGeneration.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    UserInfoRepository userInfoRepository;

    @Autowired
    BillRepository billRepository;

    public PaymentResponse paymentDone(Integer userId, Integer billId){
        var payment = Payment.builder()
                .build();
    Optional<UserInfo> userInfoOptional = userInfoRepository.findById(userId);
    UserInfo user =userInfoOptional.get();
    payment.setUserInfo(user);

    Optional<Bill> billOptional = billRepository.findById(billId);
    Bill bill = billOptional.get();
    payment.setBill(bill);

    paymentRepository.save(payment);
    return PaymentResponse.builder()
            .paymentId(payment.getPaymentId())
            .build();
    }
}

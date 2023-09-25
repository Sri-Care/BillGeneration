package bills.example.SriCareBillGeneration.service;

import bills.example.SriCareBillGeneration.dao.PaymentJDBCDao;
import bills.example.SriCareBillGeneration.dto.PaymentDTO;
import bills.example.SriCareBillGeneration.dto.PaymentResponse;
import bills.example.SriCareBillGeneration.entity.Bill;
import bills.example.SriCareBillGeneration.entity.Payment;
import bills.example.SriCareBillGeneration.entity.UserInfo;
import bills.example.SriCareBillGeneration.repository.BillRepository;
import bills.example.SriCareBillGeneration.repository.PaymentRepository;
import bills.example.SriCareBillGeneration.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private PaymentJDBCDao paymentJDBCDao;

    public PaymentResponse paymentDone(Integer userId, Integer billId){
        var payment = Payment.builder()
                .build();
    Optional<UserInfo> userInfoOptional = userInfoRepository.findById(userId);
    UserInfo user =userInfoOptional.get();
    payment.setUserInfo(user);

    Optional<Bill> billOptional = billRepository.findById(billId);
    Bill bill = billOptional.get();
    payment.setBill(bill);
    payment.setPaymentAmount(bill.getTotalAmount());

    paymentRepository.save(payment);
    return PaymentResponse.builder()
            .paymentId(payment.getPaymentId())
            .build();
    }

    public List<PaymentDTO> userPayment(Integer userId){
        return paymentJDBCDao.getPaymentHistory(userId);
    }
}

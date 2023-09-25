package bills.example.SriCareBillGeneration.service;

import bills.example.SriCareBillGeneration.dto.PaymentResponse;
import bills.example.SriCareBillGeneration.dto.ServiceDTO;
import bills.example.SriCareBillGeneration.entity.Bill;
import bills.example.SriCareBillGeneration.entity.Payment;
import bills.example.SriCareBillGeneration.entity.UserInfo;
import bills.example.SriCareBillGeneration.entity.UserService;
import bills.example.SriCareBillGeneration.repository.BillRepository;
import bills.example.SriCareBillGeneration.repository.JDBCDao.BillJDBCDao;
import bills.example.SriCareBillGeneration.repository.JDBCDao.ServiceJDBCDao;
import bills.example.SriCareBillGeneration.repository.UserInfoRepository;
import bills.example.SriCareBillGeneration.repository.UserServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BillService {

    @Autowired
    BillJDBCDao billJDBCDao;
    @Autowired
    UserInfoRepository userInfoRepository;
    @Autowired
    BillRepository billRepository;



    public ServiceDTO generateBill(Integer userId){
        var bill = Bill.builder()
                .build();
        Optional<UserInfo> userInfoOptional = userInfoRepository.findById(userId);
        UserInfo user =userInfoOptional.get();
        bill.setUserInfo(user);

        billRepository.save(bill);
//        billJDBCDao.getAllBills(userId);
        return ServiceDTO.builder()
                .billId(bill.getBillId())
                .build();
    }
    public void services(Integer userId ,Integer billId){

        billJDBCDao.getAllBills(userId,billId);
    }









}

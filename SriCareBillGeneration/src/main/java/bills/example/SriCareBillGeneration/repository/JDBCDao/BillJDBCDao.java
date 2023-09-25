package bills.example.SriCareBillGeneration.repository.JDBCDao;

import bills.example.SriCareBillGeneration.dto.ServiceDTO;
import bills.example.SriCareBillGeneration.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class BillJDBCDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private BillRepository billRepository; // Inject your bill repository
    public void getAllBills(Integer userId, Integer billId ) {


        LocalDate earliestMonth = LocalDate.now().minusMonths(1).withDayOfMonth(26); // Calculate the first day of the relevant month
        LocalDate latestMonth = LocalDate.now().withDayOfMonth(25);
        HashMap<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        params.put("billId", billId);
        params.put("earliestMonth", earliestMonth);
        params.put("latestMonth", latestMonth);

        String sql=("update bill set total_amount =(select sum(service.charge_per_month) from user_service join user_info on user_service.user_id= user_info.user_id join service on \n" +
                "user_service.service_id=service.service_id where user_service.subscribed_date between :earliestMonth and :latestMonth or\n" +
                "user_service.cancellation_date between :earliestMonth and  :latestMonth) where user_id=:userId and bill_id=:billId");



         namedParameterJdbcTemplate.update(sql, params);




    }
}

package bills.example.SriCareBillGeneration.dao;

import bills.example.SriCareBillGeneration.dto.PaymentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class PaymentJDBCDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<PaymentDTO> getPaymentHistory(Integer userId) {
        StringBuffer SQL = new StringBuffer();
        HashMap<String, Object> params = new HashMap<>();
        List<PaymentDTO> userPayments = new ArrayList<>();
        params.put("userId", userId);

        SQL.append("SELECT bill.bill_id, bill.bill_date, payment.payment_date, payment.payment_time, payment.payment_amount  FROM payment\n                                     ");
        SQL.append("INNER JOIN bill ON payment.bill_id = bill.bill_id        \n");
        SQL.append("WHERE payment.user_id=:userId");

        return namedParameterJdbcTemplate.query(SQL.toString(), params, rs -> {
            while (rs.next()) {
                PaymentDTO paymentDTO = new PaymentDTO();

                paymentDTO.setBillId(rs.getInt("bill_id"));
                paymentDTO.setPaymentDate(rs.getDate("payment_date"));
                paymentDTO.setPaymentTime(rs.getTime("payment_time"));
                paymentDTO.setPaymentAmount(rs.getInt("payment_amount"));
                paymentDTO.setBillDate(rs.getDate("bill_date"));



                userPayments.add(paymentDTO);
            }
            return userPayments;
        });


    }
}

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

        SQL.append("SELECT * FROM reservation\n                                     ");
        SQL.append("INNER JOIN rooms ON reservation.room_id = rooms.room_id        \n");
        SQL.append("INNER JOIN hotel_agent ON rooms.hotel_id = hotel_agent.hotel_id\n");
        SQL.append("WHERE hotel_agent.user_id=:userID");

        return namedParameterJdbcTemplate.query(SQL.toString(), params, rs -> {
            while (rs.next()) {
                PaymentDTO paymentDTO = new PaymentDTO();

                paymentDTO.setBillId(rs.getInt("billId"));
                paymentDTO.setPaymentDate(rs.getDate("paymentDate"));
                paymentDTO.setPaymentTime(rs.getTime("paymentTime"));
                paymentDTO.setPaymentAmount(rs.getInt("paymentAmount"));
                paymentDTO.setBillDate(rs.getDate("billDate"));



                userPayments.add(paymentDTO);
            }
            return userPayments;
        });


    }
}

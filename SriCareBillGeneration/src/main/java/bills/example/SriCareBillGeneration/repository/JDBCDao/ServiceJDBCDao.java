package bills.example.SriCareBillGeneration.repository.JDBCDao;

import bills.example.SriCareBillGeneration.dto.ServiceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class ServiceJDBCDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    public List<ServiceDTO> getAllServices( ) {
        StringBuffer SQL = new StringBuffer();
        HashMap<String, Object> params = new HashMap<>();
        List<ServiceDTO> services = new ArrayList<>();
//        LocalDate earliestMonth = LocalDate.now().minusMonths(1).withDayOfMonth(26); // Calculate the first day of the relevant month
//        LocalDate latestMonth = LocalDate.now().withDayOfMonth(25);
        SQL.append("select * from service");
//        params.put("serviceId", serviceId);

        return namedParameterJdbcTemplate.query(SQL.toString(), params, rs -> {
            while (rs.next()) {
                ServiceDTO serviceDTO = new ServiceDTO();

                serviceDTO.setServiceName(rs.getString("service_name"));
//                reviewDTO.setFname(rs.getString("fname"));
//                reviewDTO.setLname(rs.getString("lname"));
//                reviewDTO.setStars(rs.getInt("stars"));

                services.add(serviceDTO);
            }
            return services;
        });



    }
}

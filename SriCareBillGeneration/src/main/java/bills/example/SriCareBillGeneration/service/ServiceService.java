package bills.example.SriCareBillGeneration.service;

import bills.example.SriCareBillGeneration.dto.ServiceDTO;
import bills.example.SriCareBillGeneration.repository.JDBCDao.ServiceJDBCDao;
import bills.example.SriCareBillGeneration.repository.ServiceRepository;
import bills.example.SriCareBillGeneration.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService {

    @Autowired
    ServiceJDBCDao serviceJDBCDao;

    public List<ServiceDTO> services(){

        return serviceJDBCDao.getAllServices();
    }


}

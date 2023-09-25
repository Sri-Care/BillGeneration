package bills.example.SriCareBillGeneration.controller;

import bills.example.SriCareBillGeneration.dto.PaymentResponse;
import bills.example.SriCareBillGeneration.dto.ServiceDTO;
import bills.example.SriCareBillGeneration.service.PaymentService;
import bills.example.SriCareBillGeneration.service.ServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ServiceController {
    private final ServiceService serviceService;

    @GetMapping("/services")
    public List<ServiceDTO> getServices(){
        return serviceService.services();
    }
}

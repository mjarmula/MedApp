package pl.miloszjarmula.medapp.Fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.miloszjarmula.medapp.entity.Service;
import pl.miloszjarmula.medapp.repository.ServiceRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceFixtures {

    private final ServiceRepository serviceRepository;

    @Autowired
    public ServiceFixtures(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public void creatAndInsertIntoDb(){
        List<Service> services = createServices();
        serviceRepository.saveAll(services);
    }

    private List<Service> createServices(){

        List<Service> services = new ArrayList<>();

        Service service = new Service();
        service.setName("lecznie kanalowe");
        service.setDescription("lecznie polega na przelaczenia kanalu zebmoweogo bla bla itp");
        service.setPrice(800);
        services.add(service);

        Service service2 = new Service();
        service2.setName("konsultacja medczyna- med chinska");
        service2.setDescription("konsultacja z lekarzem medycyny chisnkiej");
        service2.setPrice(800);
        services.add(service2);

        Service service3 = new Service();
        service2.setName("lecznie zachowawcze");
        service2.setDescription("lecznie polega na leczniu zachowawczym");
        service2.setPrice(100);
        services.add(service3);

        return services;
    }
}

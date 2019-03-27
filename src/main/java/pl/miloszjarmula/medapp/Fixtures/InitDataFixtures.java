package pl.miloszjarmula.medapp.Fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InitDataFixtures {


    private final ServiceFixtures serviceFixtures;

    @Autowired
    public InitDataFixtures(ServiceFixtures serviceFixtures) {
        this.serviceFixtures = serviceFixtures;
    }

    @PostConstruct
    public void initData(){
        System.out.println("init data");
        serviceFixtures.creatAndInsertIntoDb();
    }
}

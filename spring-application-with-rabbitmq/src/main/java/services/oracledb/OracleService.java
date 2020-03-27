package services.oracledb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OracleService {

    @Autowired
    private OracleRepository oracleRepository;

    public void connectInDatabase() {
        oracleRepository.connectInDatabase();
    }

    public void createUserInDatabase(String user) {
        oracleRepository.createUserInDatabase(user, "mock", "mock");
    }

}

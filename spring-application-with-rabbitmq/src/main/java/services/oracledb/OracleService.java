package services.oracledb;

import entities.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OracleService {

    @Autowired
    private OracleRepository oracleRepository;

    public void connectInDatabase() {
        oracleRepository.connectInDatabase();
    }

    public void createUserInDatabase(UserVO user) {
        oracleRepository.createUserInDatabase(user);
    }

}

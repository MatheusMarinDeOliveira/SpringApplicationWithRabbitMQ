package infrastructure.oracledb;

import entities.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Repository
@ComponentScan(basePackages = {"infrastructure.oracledb"})
public class OracleRepository {

    public static final String QUERY_CREATE_USER = "CREATE USER schema_user1 IDENTIFIED BY identifiedBY1";
    public static final String QUERY_GRANT = "GRANT CONNECT, RESOURCE TO schema_user1";
    public static final String QUERY_CREATE_TABLE = "CREATE TABLE USERSYSTEM(" +
            "ID_USER varchar(255)," +
            "NAME varchar(255)," +
            "PASSWORD varchar(255)," +
            "CONSTRAINT id_pk PRIMARY KEY (ID_USER)" +
            ")";
    public static final String QUERY_INSERT_VALUES = "insert into USERSYSTEM (ID_USER, NAME, PASSWORD) values (:ID_USER,:NAME,:PASSWORD)";
    public static final String ID_USER = "ID_USER";
    public static final String NAME = "NAME";
    public static final String PASSWORD = "PASSWORD";

    @Autowired
    public DataSource dataSource;

    public void createUserInDatabase(UserVO userVO) {

        String idUser = userVO.getIdUser();
        String name = userVO.getName();
        String password =  userVO.getPassword();
        NamedParameterJdbcTemplate namedParamterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

        Map<String, Object> namedParameters = getNamedParameters(idUser, name, password);
        int status = namedParamterJdbcTemplate.update(QUERY_INSERT_VALUES, namedParameters);

        if (status != 0) {
            System.out.println("User saved");
        } else
            System.out.println("User save failed");
    }

    public void connectInDatabase() {
        NamedParameterJdbcTemplate namedParamterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        JdbcTemplate jdbcTemplate = namedParamterJdbcTemplate.getJdbcTemplate();
        jdbcTemplate.execute(QUERY_CREATE_USER);
        jdbcTemplate.execute(QUERY_GRANT);
        jdbcTemplate.execute(QUERY_CREATE_TABLE);
    }

    private Map<String, Object> getNamedParameters(String idUser, String name, String password) {
        Map<String, Object> namedParameters = new HashMap<String, Object>();
        namedParameters.put(ID_USER, idUser);
        namedParameters.put(NAME, name);
        namedParameters.put(PASSWORD, password);
        return namedParameters;
    }
}


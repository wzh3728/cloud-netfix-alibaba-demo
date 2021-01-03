import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;

/**
 * @author wzh
 * @Description
 * @create 2020-12-25 19:51
 */
public class Test1 {

    @Autowired
    DataSource dataSource;

    @Test
    public void test1(){
        System.out.println(dataSource);

    }
}

import com.dubbo.bookInfo.ProviderApplication;
import com.dubbo.bookInfo.entity.Book;
import com.dubbo.bookInfo.mapper.BookMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: XDwan
 * @Date:2022/4/4
 * @Description:
 **/

@SpringBootTest(classes = ProviderApplication.class)
public class MybatisApplicationTests {
    @Autowired
    DataSource dataSource;
    @Test
    void contextLoads() throws SQLException{
        System.out.println(dataSource.getClass());

        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Autowired
    BookMapper bookMapper;
    @Test
    public void toTest(){
        List<Book> bookList = bookMapper.selectAllBookList();
        for(Book book:bookList){
            System.out.println(book);
        }
    }


}

package hello.toby.user.dao;

import org.junit.Test;

import java.sql.SQLException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserDaoTest {

    @Test
    public void userInsertAndGetTest() throws SQLException, ClassNotFoundException {
        UserDao userDao = new UserDao();

        userDao.deleteAll();

        User user = new User();
        user.setPassword("1234");
        user.setName("이성호");
        user.setId("moduda0911");

        userDao.add(user);

        User getuser = userDao.get("moduda0911");

        System.out.println("getuser = " + getuser.getName());

        assertThat(getuser.getId(), is("moduda0911"));
    }
}
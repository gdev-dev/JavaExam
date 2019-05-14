package dev.gdev.readcode.mapper;

import dev.gdev.readcode.enums.UserSexEnum;
import dev.gdev.readcode.model.MariadbUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MariadbUserMapperTest {

    @Autowired
    private MariadbUserMapper mariadbUserMapper;

    @Test
    public void testInsert() throws Exception {
        mariadbUserMapper.insert(new MariadbUser("aa1", "a123456", UserSexEnum.MAN));
        mariadbUserMapper.insert(new MariadbUser("bb1", "b123456", UserSexEnum.WOMAN));
        mariadbUserMapper.insert(new MariadbUser("cc1", "b123456", UserSexEnum.WOMAN));

        Assert.assertEquals(3, mariadbUserMapper.getAll().size());
    }

    @Test
    public void testQuery() throws Exception {
        List<MariadbUser> users = mariadbUserMapper.getAll();
        System.out.println(users.toString());
    }


    @Test
    public void testUpdate() throws Exception {
        MariadbUser user = mariadbUserMapper.getOne(30l);
        System.out.println(user.toString());
        user.setNickName("neo");
        mariadbUserMapper.update(user);
        Assert.assertTrue(("neo".equals(mariadbUserMapper.getOne(30l).getNickName())));
    }

}

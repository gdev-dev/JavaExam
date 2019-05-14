package dev.gdev.readcode.web;

import dev.gdev.readcode.mapper.MariadbUserMapper;
import dev.gdev.readcode.model.MariadbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MariadbUserController {

    @Autowired
    private MariadbUserMapper mariadbUserMapper;

    @RequestMapping("/getUsers")
    public List<MariadbUser> getUsers() {
        List<MariadbUser> users=mariadbUserMapper.getAll();
        return users;
    }

    @RequestMapping("/getUser")
    public MariadbUser getUser(Long id) {
        MariadbUser user=mariadbUserMapper.getOne(id);
        return user;
    }

    @RequestMapping("/add")
    public void save(MariadbUser user) {
        mariadbUserMapper.insert(user);
    }

    @RequestMapping(value="update")
    public void update(MariadbUser user) {
        mariadbUserMapper.update(user);
    }

    @RequestMapping(value="/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        mariadbUserMapper.delete(id);
    }


}
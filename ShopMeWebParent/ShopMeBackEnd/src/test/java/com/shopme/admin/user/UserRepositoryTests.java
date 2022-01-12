package com.shopme.admin.user;


import com.shopme.common.entity.Role;
import com.shopme.common.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.registerCustomDateFormat;

@DataJpaTest(showSql = false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired
    private UserRepository repo;
    @Autowired
    private TestEntityManager entityManager;


    @Test
    public void testCreateNewUserWithOneRole(){
        Role roleAdmin = entityManager.find(Role.class,1);
        User userNameHM = new User("testingpurposeap@gmail.com","qwerty123","Ajit","Pal");
        userNameHM.addRole(roleAdmin);

        User savedUser = repo.save(userNameHM);

        assertThat(savedUser.getId()).isGreaterThan(0);
    }
    @Test
    public void testCreateNewUserWithTwoRoles(){
        User userAjit = new User("ajitpal353@gmail.com","ajitpal343","Ginny","Singh");
        Role roleEditor = new Role(5);
        Role roleAssistant = new Role(6);
        userAjit.addRole(roleEditor);
        userAjit.addRole(roleAssistant);

        User savedUser = repo.save(userAjit);

        assertThat(savedUser.getId()).isGreaterThan(0);
    }


    @Test
    public void testListAllUsers(){
       Iterable<User> listUsers = repo.findAll();

       listUsers.forEach(user ->System.out.println(user));
    }

    @Test
    public void testGetUserById(){
        User user = repo.findById(10).get();
        System.out.println(user);
        assertThat(user).isNotNull();

    }

    @Test
    public void testUpdateUserDetails(){
        User user = repo.findById(10).get();
        user.setEnabled(true);
        user.setEmail("ajitpal1411@gmail.com");
        repo.save(user);
    }

    @Test
    public void testUpdateUserRoles(){
        User userAjit = repo.findById(10).get();
        Role roleEditor = new Role(5);
        Role roleSalesperson = new Role(8);
        userAjit.getRoles().remove(roleEditor);
        userAjit.addRole(roleSalesperson);
        repo.save(userAjit);
    }
    @Test
    public void testDeleteUser(){
        Integer userId = 10;
        repo.deleteById(userId);

    }


    @Test
    public void testGetUserByEmail(){
        String email = "ajitpal353@gmail.com";
        User user = repo.getUserByEmail(email);
        System.out.println(user);
        assertThat(user).isNotNull();
    }

    @Test
    public void testCountById(){
        Integer id = 23;

        Long countById = repo.countById(id);

        assertThat(countById).isGreaterThan(0);
    }


    @Test
    public void testDisabledUser(){
        Integer id = 9;

        repo.updateEnabledStatus(id, false);
    }

    @Test
    public void testEnabledUser(){
        Integer id = 25;

        repo.updateEnabledStatus(id, true);
    }

    @Test
    public void testListFIrstPage(){
        int pageNumber = 0;
        int pageSize = 4;

        Pageable pageable = PageRequest.of(pageNumber,pageSize);

        Page<User> page = repo.findAll(pageable);

        List<User> listUsers = page.getContent();

        listUsers.forEach(user -> System.out.println(user));


        assertThat(listUsers.size()).isEqualTo(pageSize);
    }

    @Test
    public void testSearchUsers(){
        String keyword = "bruce";
        int pageNumber = 0;
        int pageSize = 4;

        Pageable pageable = PageRequest.of(pageNumber,pageSize);

        Page<User> page = repo.findAll(keyword,pageable);

        List<User> listUsers = page.getContent();

        listUsers.forEach(user -> System.out.println(user));

        assertThat(listUsers.size()).isGreaterThan(0);
    }
}

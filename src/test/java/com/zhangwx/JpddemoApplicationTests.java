package com.zhangwx;

import com.zhangwx.dao.RoleDao;
import com.zhangwx.dao.StudentDao;
import com.zhangwx.dao.TeacherDao;
import com.zhangwx.dao.UserDao;
import com.zhangwx.model.Role;
import com.zhangwx.model.Student;
import com.zhangwx.model.Teacher;
import com.zhangwx.model.User;
import org.hibernate.criterion.Example;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Rollback;

import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpddemoApplicationTests {

    @Autowired
    private UserDao userDao;

    @Autowired
    private TeacherDao teacherDao;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private RoleDao roleDao;

    @Test
    @Transactional
    @Rollback(value = false)
    void contextLoads() {
        int a= userDao.updatemy("zhangwx121",2);
        System.out.println(a);
    }

    @Test
    void contextLoads2() {
        Specification<User> sp = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Integer> id=  root.get("id");
                Predicate predicate = criteriaBuilder.equal(id,1);
                return predicate;
            }
        };
        int a= (int) userDao.count(sp);
        System.out.println(a);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void test1(){
        Teacher teacher =new Teacher();
        teacher.setTname("zhangwx");

        Student student = new Student();
        student.setSname("tmr");

        Student student2 = new Student();
        student2.setSname("tmr2");

        teacher.getList().add(student);
        teacher.getList().add(student2);
        studentDao.save(student);
        studentDao.save(student2);
        teacherDao.save(teacher);

    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void test2(){
        Teacher teacher =new Teacher();
        teacher.setTname("zhangwx");

        Student student = new Student();
        student.setSname("tmr");
        student.setTeacher(teacher);

        Student student2 = new Student();
        student2.setSname("tmr2");
        student2.setTeacher(teacher);

        teacherDao.save(teacher);
        studentDao.save(student);
        studentDao.save(student2);


    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void test3(){
     Teacher teacher = teacherDao.getOne(7);

        teacherDao.delete(teacher);



    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void manyToManyTest(){
//多对多，被动的一方放弃维护权，role放弃
        User user = new User() ;
        user.setName("zhangwx");

        Role role = new Role();
        role.setRname("java程序员");

        user.getRoles().add(role);

        userDao.save(user);
        roleDao.save(role);



    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void manyToManyRemoveTest(){
        User user = userDao.getOne(1) ;
         userDao.delete(user);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void test4(){
        User user = userDao.getOne(2) ;
        System.out.println(user);
    }
}

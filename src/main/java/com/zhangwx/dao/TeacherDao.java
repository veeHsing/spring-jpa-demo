package com.zhangwx.dao;

import com.zhangwx.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TeacherDao extends JpaRepository<Teacher,Integer>, JpaSpecificationExecutor<Teacher> {
}

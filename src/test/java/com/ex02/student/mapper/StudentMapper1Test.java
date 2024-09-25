package com.ex02.student.mapper;

import com.ex02.student.po.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.Reader;
import java.util.List;

public class StudentMapper1Test {
    com.ex02.student.mapper.StudentMapper1 mapper =null;
    SqlSession sqlSession =null;
    @Before
    public void setUp() throws Exception {
        Reader resourceAsReader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);
        sqlSession = sqlSessionFactory.openSession();
        mapper = sqlSession.getMapper(com.ex02.student.mapper.StudentMapper1.class);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void selectStudentBySno() {
        Student student = mapper.selectStudentBySno("100000001");
        System.out.println(student);
    }

    @Test
    public void selectStudentBySname() {
        List<Student> students = mapper.selectStudentBySname("刘");
        for (Student student : students) {
            System.out.println(student);
        }
    }
    // 请补全其他代码，完成对stu表的其他操作
    // ……

    //  sqlSession.close();
}


package test;

import config.MainConfigOfAutowired;
import dao.BookDAO;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.BookService;

public class AutowiredTest {
    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext=
                new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
        System.out.println("容器创建完成");
        BookService bookService=applicationContext.getBean(BookService.class);
        System.out.println(bookService);
        BookDAO bookDAO=applicationContext.getBean(BookDAO.class);
        System.out.println(bookDAO);
        applicationContext.close();
    }
}

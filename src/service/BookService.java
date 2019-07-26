package service;

import dao.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired(required=false)
    private BookDAO bookDAO;

    public void print(){
        System.out.println(bookDAO);
    }

    @Override
    public String toString() {
        return "BookService{" +
                "bookDAO=" + bookDAO +
                '}';
    }
}

package dao;

import org.springframework.stereotype.Repository;

@Repository
public class BookDAO {
    private String label="1";

    public String getLable() {
        return label;
    }

    public void setLable(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "BookDAO{" +
                "label='" + label + '\'' +
                '}';
    }
}

package collectionsandset;

import java.util.Objects;

public class Computer implements Comparable{
    private String name;
    private String createdDate;
    private String price;

    public Computer(String name, String createdDate, String price) {
        this.name = name;
        this.createdDate = createdDate;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "name='" + name + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj==null)
            return false;
        if(getClass()!=obj.getClass())
            return false;
        Computer computer=(Computer)obj;
        if(!name.equals(computer.name))
            return false;
        if(!createdDate.equals(computer.createdDate))
            return false;
        if(!price.equals(computer.price))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, createdDate, price);
    }

    public int compareTo(Object obj){
        if(obj instanceof  Computer){
            Computer computer=(Computer)obj;
            int i=name.compareTo(computer.name);
            if(i==0){
                i=createdDate.compareTo(computer.createdDate);
                if(i==0){
                    return price.compareTo(computer.price);
                }
            }
            return i;
        }
        return 0;
    }
}

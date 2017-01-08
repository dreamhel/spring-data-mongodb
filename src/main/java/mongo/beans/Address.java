package mongo.beans;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Annotation;

/**
 * Created by Administrator on 2017/1/4.
 */
@Document
public class Address implements Reference {
    @Id
    private String address;
    private int number;

    @Override
    public Class<? extends Annotation> annotationType() {
        return Address.class;
    }

    public Address(String address) {
        this.address = address;
        this.number = 999;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

package mongo.beans;

import mongo.events.CascadeSave;
import mongo.events.RefrencesHolder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/1/4.
 */
@Document
public class Account implements DBReference {
    @Id
    private String bank;

    @RefrencesHolder
    @CascadeSave
    @DBRef
    private ArrayList<DBReference> references;
    public void addRefrence(DBReference dbReference)
    {
        if(references == null)
        {
            references = new ArrayList<>();
        }
        references.add(dbReference);
    }

    public ArrayList<DBReference> getReferences() {
        return references;
    }

    public void setReferences(ArrayList<DBReference> references) {
        this.references = references;
    }

    public Account() {
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        System.out.print("Acc");
        return Account.class;
    }

    private int number;

    public Account(String bank, int number) {
        this.bank = bank;
        this.number = number;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

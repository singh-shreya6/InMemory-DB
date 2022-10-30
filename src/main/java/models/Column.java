package models;

import contraints.Constraint;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Column {

    String columnName;
    Type type;
    private Set<Constraint> cons;

    public Column(String columnName, Type type) {
        this.columnName = columnName;
        this.type = type;
        this.cons = new HashSet<>();
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Set<Constraint> getCons() {
        return cons;
    }

    public void setCons(Set<Constraint> cons) {
        this.cons = cons;
    }

    public void addCons(Constraint con) {
        cons.add(con);
    }

    public void validate(Object value) {
        Iterator<Constraint> it = cons.iterator();
        while (it.hasNext()) {
            if (!it.next().validate(value)) {
                throw new RuntimeException("Constraint violation!!");
            }
        }
    }
}

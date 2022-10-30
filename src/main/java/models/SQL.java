package models;

import operators.Operator;

import javax.jws.Oneway;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class SQL {

    Database db;

    public SQL(Database db) {
        this.db = db;
    }

    //INSERT into EMPLOYEE values("", "")
    public void insert(String query) {
        String[] splitQuery = query.split(" ");
        String[] values = parseValues(splitQuery[3]);
        Table table = db.getTable(splitQuery[2]);
        if (table == null) {
            System.out.print("Table not found!!");
            return;
        }
        Set<String> columns = table.getColumns().keySet();

        if (values.length != columns.size()) {
            System.out.print("Values length invalid");
            return;
        }
        LinkedHashMap<String, Object> record = new LinkedHashMap<>();
        AtomicInteger k = new AtomicInteger(0);
        columns.forEach(col -> insert(table, record, col, values[k.getAndIncrement()]));

        table.insert(record);

    }

    public void insert(Table table, LinkedHashMap<String, Object> record, String col, String val) {
        if (table.getColumns().get(col).getType() == Type.INTEGER) {
            record.put(col, Integer.valueOf(val));
        } else {
            record.put(col, val);
        }
    }

    private String[] parseValues(String splitedQuery) {
        return splitedQuery.replaceAll("values", "").replaceAll("\"", "").replaceAll("\\)", "").replaceAll("\"", "")
                .replaceAll("\\(", "").replaceAll(";", "").split(",");
    }
}

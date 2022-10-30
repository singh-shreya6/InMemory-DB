package models;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Table {

    String tableName;
    Map<Integer, Row> rows;
    Map<String, Column> columns;
    Integer autoId;

    public Table(String tableName) {
        this.tableName = tableName;
        this.rows = new HashMap<>();
        this.columns = new LinkedHashMap<>();
        this.autoId = 0;
    }

    public Map<String, Column> getColumns() {
        return columns;
    }

    public String getTableName() {
        return tableName;
    }

    public Map<Integer, Row> getRows() {
        return rows;
    }

    public void setRows(HashMap<Integer, Row> rows) {
        this.rows = rows;
    }

    public Integer getAutoId() {
        synchronized (autoId) {
            return autoId++;
        }
    }

    public void setAutoId(Integer autoId) {
        this.autoId = autoId;
    }

    public boolean insert(LinkedHashMap<String, Object> values) {
        int id = getAutoId();
        Set<String> cols = columns.keySet();
        for(String col: cols) {
            columns.get(col).validate(values.get(col));
        }
        Row row = new Row(id, values);
        rows.put(id, row);
        return true;
    }

    public void delete(Integer rowId) {
        rows.remove(rowId);
    }

    public void printAllRecords() {
        for(Map.Entry<Integer, Row> row: rows.entrySet()) {
            System.out.println(row.toString());
        }
    }

    public Column createColumn(String columnName, Type type) {
        if (columns.containsKey(columnName)) {
            System.out.println("Column already exists!!");
        }
        Column col = new Column(columnName, type);
        columns.put(columnName, col);
        return col;
    }
}

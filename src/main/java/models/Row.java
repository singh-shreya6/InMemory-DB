package models;

import java.util.Map;

public class Row {

    int id;
    Map<String, Object> values;

    public Row(int id, Map<String, Object> values) {
        this.id = id;
        this.values = values;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<String, Object> getValues() {
        return values;
    }

    public void setValues(Map<String, Object> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "Row{" +
                "id=" + id +
                ", values=" + values +
                '}';
    }
}

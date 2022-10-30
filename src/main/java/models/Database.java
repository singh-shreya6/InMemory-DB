package models;

import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Database {
    private String dbName;
    private Map<String, Database> dbMap;
    private Map<String, Table>  tables;
    private static String currentDatabase;

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getCurrentDatabase() {
        return currentDatabase;
    }

    public void setCurrentDatabase(String currentDatabase) {
        Database.currentDatabase = currentDatabase;
        getInstance(currentDatabase);
    }

    public Database(String dbName) {
        this.dbName = dbName;
        this.tables = new HashMap<String, Table>();
    }


    public Database getInstance(String dbName) {
        if (!dbMap.containsKey(dbName)) {
            dbMap.put(dbName, new Database(dbName));
        }
        return dbMap.get(dbName);
    }

    public Table createTable(String tableName) {
        Table newTable = new Table(tableName);
        tables.put(tableName, newTable);
        return newTable;
    }

    public Table getTable(String tableName) {
        return tables.get(tableName);
    }
    public void deleteTable(String tableName) {
        tables.remove(tableName);
    }
}

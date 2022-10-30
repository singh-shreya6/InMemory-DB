import contraints.IntegerConstraint;
import contraints.StringConstraint;
import models.*;

public class Driver {
    public static void main(String[] args) {

        Database db = new Database("Company");
        SQL sql = new SQL(db);
        Table employeeTable = db.createTable("EMPLOYEE");
        Column id = employeeTable.createColumn("Id", Type.INTEGER);
        id.addCons(new IntegerConstraint());

        Column userName = employeeTable.createColumn("UserName", Type.STRING);
        userName.addCons(new StringConstraint());

        sql.insert("INSERT INTO EMPLOYEE values(101,\"Shreya\");");

        sql.insert("INSERT INTO EMPLOYEE values(102,\"XYZ\");");

        db.getTable("EMPLOYEE").printAllRecords();
    }
}

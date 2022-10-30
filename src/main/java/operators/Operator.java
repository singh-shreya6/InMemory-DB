package operators;

public abstract class Operator {
    String name;
    String sign;

    public abstract boolean applyOp(Object filterValue, Object value);
}
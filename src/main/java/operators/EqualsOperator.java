package operators;

public class EqualsOperator extends Operator{

    public EqualsOperator() {
        this.name = "equals";
        this.sign = "=";
    }
    @Override
    public boolean applyOp(Object filterValue, Object value) {
        return filterValue == value || filterValue.equals(value);
    }
}

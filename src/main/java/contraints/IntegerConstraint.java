package contraints;

public class IntegerConstraint implements Constraint {
    @Override
    public boolean validate(Object value) {
        return value.getClass().equals(Integer.class);
    }
}

package contraints;

public class StringConstraint implements Constraint{
    @Override
    public boolean validate(Object value) {
        return value.getClass().equals(String.class);
    }
}

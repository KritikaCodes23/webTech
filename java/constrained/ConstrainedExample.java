package constrained;

import java.beans.*;

class Person {
    private int age;
    private VetoableChangeSupport vcs = new VetoableChangeSupport(this);

    public int getAge() {
        return age;
    }

    public void setAge(int newAge) throws PropertyVetoException {
        int oldAge = this.age;

        vcs.fireVetoableChange("age", oldAge, newAge);

        this.age = newAge;
    }

    public void addVetoableChangeListener(VetoableChangeListener listener) {
        vcs.addVetoableChangeListener(listener);
    }
}

public class ConstrainedExample {
    public static void main(String[] args) {

        Person p = new Person();

        p.addVetoableChangeListener(evt -> {
            int newAge = (int) evt.getNewValue();
            if (newAge < 18) {
                throw new PropertyVetoException("Age must be 18+", evt);
            }
        });

        try {
            p.setAge(20); // OK
            System.out.println("Age set to 20");

            p.setAge(15); // ERROR
        } catch (PropertyVetoException e) {
            System.out.println(e.getMessage());
        }
    }
}
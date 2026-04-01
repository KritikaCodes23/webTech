package bound;

import java.beans.*;

class Person {
    private String name;
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        String oldName = this.name;
        this.name = newName;
        pcs.firePropertyChange("name", oldName, newName);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }
}

public class BoundExample {
    public static void main(String[] args) {

        Person p = new Person();

        p.addPropertyChangeListener(evt -> {
            System.out.println("Property changed: " +
                evt.getPropertyName() +
                " from " + evt.getOldValue() +
                " to " + evt.getNewValue());
        });

        p.setName("Harsha");
        p.setName("Rahul");
    }
}
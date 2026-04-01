package beaninfo;

import beans.Person;
import java.beans.*;

public class PersonBeanInfo extends SimpleBeanInfo {
    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        try {
            PropertyDescriptor nameDesc = new PropertyDescriptor("name", Person.class);
            PropertyDescriptor ageDesc = new PropertyDescriptor("age", Person.class);
            
            nameDesc.setDisplayName("Full Name");
            ageDesc.setDisplayName("User Age");
            
            return new PropertyDescriptor[] { nameDesc, ageDesc };
        } catch (IntrospectionException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Isse run hoga program
    public static void main(String[] args) {
        System.out.println("--- Bean Information ---");
        PersonBeanInfo info = new PersonBeanInfo();
        for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
            System.out.println("Property: " + pd.getName() + " | Display Name: " + pd.getDisplayName());
        }
    }
}
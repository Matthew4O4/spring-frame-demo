package cn.bugstack.springframework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: matthew
 * @Date: 2023/1/8 21:40
 */
public class PropertyValues {
    private final List<PropertyValue> propertyValues = new ArrayList<>();

    public void addPropertyValue(PropertyValue propertyValue) {
        this.propertyValues.add(propertyValue);
    }

    public PropertyValue[] getPropertyValues() {
        return propertyValues.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue propertyValue : propertyValues) {
            if (propertyValue.getName().equals(propertyName)) {
                return propertyValue;
            }
        }
        return null;
    }
}

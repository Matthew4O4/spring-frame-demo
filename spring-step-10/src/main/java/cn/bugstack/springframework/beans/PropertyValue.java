package cn.bugstack.springframework.beans;

/**
 * @Description:
 * @Author: matthew
 * @Date: 2023/1/8 21:39
 */
public class PropertyValue {
    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}

package cn.bugstack.springframework.context.support;

import java.util.EventObject;

/**
 * @Description:
 * Class to be extended by all application events .
 * Abstract as it doesn't make sense for generic events to be
 * published directly.
 * @Author: matthew
 */
public class ApplicationEvent extends EventObject {

    public ApplicationEvent(Object source) {
        super(source);
    }
}

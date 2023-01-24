package cn.bugstack.springframework.context.event;

/**
 * @Description:
 * Event raised whe an <code>ApplicationContext</code> gets initialized or refreshed.
 * @Author: matthew
 */
public class ContextRefreshedEvent extends ApplicationContextEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source
     */
    public ContextRefreshedEvent(Object source) {
        super(source);
    }
}

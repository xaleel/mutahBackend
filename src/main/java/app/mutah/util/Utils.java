package app.mutah.util;

import org.springframework.stereotype.Component;

@Component
public class Utils {
    public <T> T getValueOrDefault(T value, T defaultValue) {
        return value == null ? defaultValue : value;
    }
}

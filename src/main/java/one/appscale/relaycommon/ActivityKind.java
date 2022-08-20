package one.appscale.relaycommon;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

public enum ActivityKind {
    INSTALL("install"),
    EVENT("event"),
    REATTRIBUTION("reattribution");

    private final String value;

    ActivityKind(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value();
    }

    public String value() {
        return value;
    }

    private static final Map<String, ActivityKind> activityKindMap = Arrays.stream(values())
                                                                           .collect(toMap(ActivityKind::value, Function.identity()));

    public static ActivityKind fromValue(final String value) {
        if (value == null) {
            throw new IllegalArgumentException("activityKind:" + value);
        }
        final String lowerCaseText = value.toLowerCase();
        return activityKindMap.computeIfAbsent(lowerCaseText, v -> {
            throw new IllegalArgumentException("activityKind:" + v);
        });
    }
}

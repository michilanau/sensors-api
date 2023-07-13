package com.malanau.sensorsapi.shared.domain;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class Utils {
    public static String dateToString(final LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public static String dateToString(final Timestamp timestamp) {
        return dateToString(timestamp.toLocalDateTime());
    }
}

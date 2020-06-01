package com.maxdexter.studentsdatabase.database;

import androidx.room.TypeConverter;

import java.util.Date;
/*создадим конвертер, который умеет конвертировать дату в длинное целое число и обратно.*/
public class DateConverter {
    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }

}

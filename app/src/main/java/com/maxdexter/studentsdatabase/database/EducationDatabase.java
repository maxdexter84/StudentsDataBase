package com.maxdexter.studentsdatabase.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.maxdexter.studentsdatabase.data.Email;
import com.maxdexter.studentsdatabase.data.Student;

@Database(entities = {Student.class, Email.class}, version = 2)
@TypeConverters(DateConverter.class)
public abstract class EducationDatabase extends RoomDatabase {
    public abstract EducationDao getEducationDao();
}

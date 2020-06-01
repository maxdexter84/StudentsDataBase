package com.maxdexter.studentsdatabase.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.maxdexter.studentsdatabase.data.Student;

@Database(entities = {Student.class}, version = 1)
public abstract class EducationDatabase extends RoomDatabase {
    public abstract EducationDao getEducationDao();
}

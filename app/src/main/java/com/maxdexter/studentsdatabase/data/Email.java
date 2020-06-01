package com.maxdexter.studentsdatabase.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

// Таблица со списком электронных адресов студента связана по полям id со
// стороны таблицы student и student_id со стороны таблицы email (внешний
// ключ). При удалении студента все почтовые адреса тоже удаляются (CASCADE)
@Entity(foreignKeys = @ForeignKey(entity = Student.class,
        parentColumns = "id",
        childColumns = "student_id", onDelete = CASCADE))
public class Email {
    @PrimaryKey(autoGenerate = true)
    public long id;

    // Внешний ключ
    @ColumnInfo(name = "student_id")
    public long studentId;

    public String email;
}

package com.maxdexter.studentsdatabase.data;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.io.Serializable;
import java.util.List;

// Результат запроса через Relation: первый запрос по всем студентам, далее запросы по каждому студенту для получения e-mail
public class StudentEmail implements Serializable {

    @Embedded
    public Student student;

    @Relation(parentColumn = "id", entityColumn = "student_id")
    public List<Email> emails;
}


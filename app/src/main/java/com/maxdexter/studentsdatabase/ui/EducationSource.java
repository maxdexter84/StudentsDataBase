package com.maxdexter.studentsdatabase.ui;

import com.maxdexter.studentsdatabase.data.Student;
import com.maxdexter.studentsdatabase.database.EducationDao;

import java.util.List;

// Вспомогательный класс, развязывающий зависимость между Room и RecyclerView
public class EducationSource {
    private final EducationDao mEducationDao;

    // Буфер с данными: сюда будем подкачивать данные из БД
    private List<Student> students;
    
    public EducationSource(EducationDao educationDao) {
        mEducationDao = educationDao;
    }

    // Получить всех студентов
    public List<Student> getStudents(){
        // Если объекты еще не загружены, загружаем их.
        // Это сделано для того, чтобы не делать запросы к БД каждый раз
        if (students == null){
            LoadStudents();
        }
        return students;
    }
//загружаем студентов в буфер
    public void LoadStudents() {
        students = mEducationDao.getAllStudents();
    }
    // Получаем количество записей
    public long getCountStudents(){
        return mEducationDao.getCountStudents();
    }
    // Добавляем студента
    public void addStudent(Student student){
        mEducationDao.insertStudent(student);
        // После изменения БД надо повторно прочесть данные из буфера
        LoadStudents();
    }

    // Заменяем студента
    public void updateStudent(Student student){
        mEducationDao.updateStudent(student);
        LoadStudents();
    }

    // Удаляем студента из базы
    public void removeStudent(long id){
        mEducationDao.deteleStudentById(id);
        LoadStudents();
    }




}

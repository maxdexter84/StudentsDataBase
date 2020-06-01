package com.maxdexter.studentsdatabase.database;

import android.app.Application;

import androidx.room.Room;

// Паттерн Singleton, наследуем класс Application, создаём базу данных
// в методе onCreate
public class App extends Application {
    private static App instance;
    //База данных
    private EducationDatabase db;

    public static App getInstance() {
        if(instance == null){
            instance = new App();
        }
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // Сохраняем объект приложения (для Singleton’а)
        instance = this;
        //Строим базу данных
        db= Room.databaseBuilder(getApplicationContext(),EducationDatabase.class,"education_database")
                .allowMainThreadQueries()//только для примеров и тестирования
                .build();
    }
    // Получаем EducationDao для составления запросов
    public EducationDao getEducationDao(){
        return db.getEducationDao();
    }
}

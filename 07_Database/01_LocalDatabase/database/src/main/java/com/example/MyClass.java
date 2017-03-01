package com.example;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

public class MyClass {

    public static void main(String args[]) {
        // Design a new database schema
        //
        Schema schema = new Schema(1, "com.miguelcr.a01_localdatabase.localdb");

        // Database design
        Entity students = schema.addEntity("Students");
        students.addIdProperty().autoincrement().primaryKey();
        students.addStringProperty("name");
        students.addIntProperty("age");
        students.addBooleanProperty("repeat");
        students.addLongProperty("idSubject");

        // Subjects
        Entity subjects = schema.addEntity("Subjects");
        subjects.addIdProperty().autoincrement().primaryKey();
        subjects.addStringProperty("name").notNull();

        try {
            new DaoGenerator().generateAll(schema, "./app/src/main/java");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

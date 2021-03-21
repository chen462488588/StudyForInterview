package com.chen;

import java.io.*;

public class Client {
    public static void main(String[] args) {
        System.out.println(333);
        //1. object to be serialized
        Student student = new Student();
        student.setSex("man");
        student.setsName("Xiao Hong");
        student.setTeacher(new Teacher("James Li", 40));

        //2. File to store the student object
        File file = new File("/home/chenkun/IdeaProjects/MyStudy/student.ser");
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(student);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //3. Test deserialize
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Student student1 = (Student) objectInputStream.readObject();
            System.out.println("------student1-------");
            System.out.println(student1);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            //close stream
        }
    }
}

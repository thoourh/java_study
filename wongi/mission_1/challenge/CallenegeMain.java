package dev.thoourh.challenge;

import dev.thoourh.basic.Lecturer;
import dev.thoourh.basic.Person;
import dev.thoourh.basic.Student;

import java.util.*;

public class CallenegeMain {
    public static void main(String[] args) {
        Person studentKim = new Student("KiM", 26);
        Student studentLee = new Student("Lee", 28);
        Person studentPark = new Student("Park", 24);

        Person lecturer = new Lecturer("Park Jeeho", 35);

        Vector<Person> everyone = new Vector<>();
        everyone.add(studentKim);
        everyone.add(studentLee);
        everyone.add(studentPark);
        everyone.add(lecturer);

        printItems(everyone);
    }

    public static <T> void printItems(Iterable<T> iterable){
        Iterator<T> iterator = iterable.iterator();
        if (!iterator.hasNext()) {
            System.out.println("No Elements");
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("idx\t\titem\n");
        for (int i = 0; iterator.hasNext(); i++) {
            T item = iterator.next();
            stringBuilder.append(
                    String.format("%d\t\t%s\n", i, item));
        }

        System.out.println(stringBuilder);
    }
}

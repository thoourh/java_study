package dev.sw.basic.challenge;

import dev.sw.basic.Lecturer;
import dev.sw.basic.Person;
import dev.sw.basic.Student;

import java.util.*;

public class ChallengeMain {
    public static void main(String[] args) {
        Person studentKim = new Student("Kim", 26);
        Person studentLee = new Student("Lee", 28);
        Person studentPark = new Student("Park", 24);

        Person lecturer = new Lecturer("Park Jeeho", 35);

        List<Person> everyone = new ArrayList<>();
        everyone.add(studentKim);
        everyone.add(studentLee);
        everyone.add(studentPark);
        everyone.add(lecturer);

        printItems(everyone);
    }

    public static <T> void printItems(Iterable<T> iterable){
        Iterator<T> iterator = iterable.iterator();
        if(!iterator.hasNext()) {
            System.out.println("No Elements");
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("idx\t\titem\n");
        for (int i = 0; iterator.hasNext(); i++){
            T item = iterator.next();
            stringBuilder.append(
                    String.format("%d\t\t%s\n", i, item));
        }

        System.out.println(stringBuilder);
    }
}

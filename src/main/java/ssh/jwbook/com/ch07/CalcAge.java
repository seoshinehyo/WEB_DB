package ssh.jwbook.com.ch07;

import java.time.LocalDate;

public class CalcAge {
    int age, year;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        LocalDate date = LocalDate.now();
        this.age = date.getYear() - age;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

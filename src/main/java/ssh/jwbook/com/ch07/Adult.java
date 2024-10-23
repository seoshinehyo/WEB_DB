package ssh.jwbook.com.ch07;

public class Adult {
    String name;
    int age;

    String adul;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAdul() {
        if (age >= 20) {
            return "성인";
        } else {
            return "성인 아님";
        }
    }

    public void setAdul(String adul) {
        this.adul = adul;
    }
}

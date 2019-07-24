package org.liangxiong.data.structure.array;

/**
 * @author liangxiong
 * @Date:2019-07-24
 * @Time:16:16
 * @Description 学生
 */
public class Student {

    /**
     * 姓名
     */
    private String name;

    /**
     * 分数
     */
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public static void main(String[] args) {
        Array<Student> studentArray = new Array<>(4);
        studentArray.addFirst(new Student("tom", 66));
        studentArray.addLast(new Student("jerry", 88));
        studentArray.add(1, new Student("dog", 12));
        System.out.println(studentArray);
    }
}

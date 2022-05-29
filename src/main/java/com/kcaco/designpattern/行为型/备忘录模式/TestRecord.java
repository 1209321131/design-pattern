package com.kcaco.designpattern.行为型.备忘录模式;

/**
 * Description:
 *
 * @author kcaco
 * @since 2022-05-29 16:02
 */
public class TestRecord {
    public static void main(String[] args) {
        Student student = new Student();
        student.work("学Java");   //开始学Java
        System.out.println(student);

        State savedState = student.save();   //保存一下当前的状态

        student.work("打电动");   // 刚打开B站播放视频，学一半开始摆烂了
        System.out.println(student);

        student.restore(savedState);   //两级反转！回到上一个保存的状态
        System.out.println(student);   //回到学Java的状态
    }
}

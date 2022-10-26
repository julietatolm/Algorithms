package org.class_10_19.hw;

//Задача: Написать метод который принимает на вход стрингу вида
//helloworld или mynameis итд, т.е. использует snake case. Соответственно надо написать
// метод который преобразует snale case в camel case.
//Т.е helloworld == helloWorld итд.

public class CamelCase {
    public static void main(String[] args) {

        String a = "hello_world";
        String b = "my_name_is";

        System.out.println(toCamelCase(a));
        System.out.println(toCamelCase(b));

    }

    public static String toCamelCase(String s) {
        char[] source = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder("");

        for (int i = 0; i < source.length; i++) {
            if (source[i] == '_') {
                i++;
                if (i == source.length - 1) {
                    break;
                }
                source[i] = (char) (source[i] - 32);
            }
            stringBuilder.append(source[i]);
        }
        return stringBuilder.toString();
    }
}

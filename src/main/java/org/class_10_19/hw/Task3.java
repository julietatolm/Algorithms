package org.class_10_19.hw;

//Задача на собесе в банк Кипра.
//Position: junior+/middle java developer.
//Две группы студентов решали контрольную  состоящую из N задач. Известно что  первая группа решила суммарно A задач,
// а вторая В задач, при этом каждый студент решил хотя бы одну задачу.
//Далее….
//Вам надо узнать МОГЛО ЛИ БЫТЬ В ПЕРВОЙ ГРУППЕ СТУДЕНТОВ БОЛЬШЕ ЧЕМ ВО ВТОРОЙ.
//
//Входные данные: Вводим три числа A B N соответственно.
//Условия: (0<=A, B <= 10^4, 1 <= N <=10^4)
//
//
//
//Выходные данные: Да- может, Нет - не может )))
//Например: A = 60, B=30, N = 4 --> Yes
//                 A = 30, B = 30, N = 1 --> No
//                 A = 30, B = 150, N = 4 --> No
//!Примеры выше реальные!
//Можно без кода просто математикой или псевдо….не суть важно.

//Решение:
//Посчитать макс и мин возможный количества людей для решения задач N в каждой из групп исходя из:
// 1. если бы каждую студент решил одну задачу
// 2. если бы каждый студент решил все задачи
// и сравнить если возможен вариант когда студентов в группе один больше (это возможно когда студенты в группе один
// решили бы меньше задач на каждого студента чем студенты в граппе два)


import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        //1. number of problems N (from 1 to 10^4)
        //2. group one solved A problems (from 0 to ..)
        //3.group two solved B problems (from .. to 10^4)
        //4. each student solved at least one problem

        //Can group one have more students than group two?

        // Input data: three numbers A B N (data check (0<=A, B <= 10^4, 1 <= N <=10^4))
        // Output data: Yes / No
        Scanner sc = new Scanner(System.in);
        int A = -1;
        int B = (int) (Math.pow(10, 4)+1);
        int N = 0;

        while (A < 0) {
            System.out.println("Input number of solved problems in group ONE (from 0 to ..): ");
            A = sc.nextInt();
        }
        while (B > Math.pow(10, 4)) {
            System.out.println("Input number of solved problems in group two (from .. to 10^4): ");
            B = sc.nextInt();
        }
        while (N < 1 || N > Math.pow(10, 4)) {
            System.out.println("Input number of problems (from 1 to 10^4): ");
            N = sc.nextInt();
        }

        System.out.println("Can group one have more students than group two? ");

        int studentsOneMin = A;
        int studentsTwoMax = B/N;

        if (studentsOneMin > studentsTwoMax) {
            System.out.println("Yes");
        } else System.out.println("No");


    }



}

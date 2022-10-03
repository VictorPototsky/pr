package lesson2;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        takeValue();
    }

    /*  Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
     и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения,
     вместо этого, необходимо повторно запросить у пользователя ввод данных.
    */
    private static float takeValue (){
        float value = 0.0f;
        String st;
        boolean isContinue = true;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print("Введите чего-нибудь : ");
                st = sc.nextLine();
                if (st.trim().isBlank()) {
                    throw new MyException();
                } else {
                    value = Float.parseFloat(String.valueOf(st));
                }
                isContinue = false;
            } catch (MyException e){
                System.out.println("Ошибка. Пустая строка - некорректный ввод данных.");
                isContinue=true;
            }catch(NumberFormatException | InputMismatchException | IllegalStateException e){
                System.out.println("Введено некорректное числовое значение. Повторите попытку");
                isContinue= true;
            }
        } while(isContinue);
        System.out.println("Введено число : " + value);
        sc.close();
        return value;

    }


/*    Если необходимо, исправьте данный код
       (задание 2 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)

       Нужен отлов еще 2-х исключений - ArrayIndexOutOfBoundsException, если уйдем за границы массива
       и NullPointerException, если массив пустой.
       в блок  catch  добавим эти исключения :

       try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
       } catch (ArithmeticException | ArrayIndexOutOfBoundsException | NullPointerException e) {
         System.out.println("Catching exception: " + e);

        Или

        можно также поймать исключение, которое выше рангом - RuntimeException.
         В блоке catch поменяем  ArithmeticException на RuntimeException
         try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
          } catch (RuntimeException e) {
            System.out.println("Catching exception: " + e);

*/


/*
     Дан следующий код, исправьте его там, где требуется
     (задание 3 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)

    В блоке try-catch метода main -  проверка catch (Throwable ex) {
       System.out.println("Что-то пошло не так...");}
   должна быть в самом конце, т.к. будут отлавливаться все исключения, до следующих исключений (наследников) дело не дойдет.

   Проброс исключений - throws Exception не нужен, мы и так обрабатываем все - код не упадет.


public static void main(String[] args) {
   try {
       int a = 90;
       int b = 3;
       System.out.println(a / b);
       printSum(23, 234);
       int[] abc = { 1, 2 };
       abc[3] = 9;
   } catch (NullPointerException ex) {
       System.out.println("Указатель не может указывать на null!");
   } catch (IndexOutOfBoundsException ex) {
       System.out.println("Массив выходит за пределы своего размера!");
   } catch (Throwable ex) {
       System.out.println("Что-то пошло не так...");}
}

или просто убрать последующие 2 блока catch из кода, если не нужна конкретика что же все-таки пошло не так...

public static void main(String[] args) {
   try {
       int a = 90;
       int b = 3;
       System.out.println(a / b);
       printSum(23, 234);
       int[] abc = { 1, 2 };
       abc[3] = 9;
} catch (Throwable ex) {
       System.out.println("Что-то пошло не так...");}
}


В этом методе абсолютно не при чем исключение работы с файлом - его нужно убрать.

public static void printSum(Integer a, Integer b){      //  это не нужно - throws FileNotFoundException {
   System.out.println(a + b);
}

*/


/*
     Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
     Пользователю должно показаться сообщение, что пустые строки вводить нельзя.

      Реализовано в методе takeValue.

*/

}


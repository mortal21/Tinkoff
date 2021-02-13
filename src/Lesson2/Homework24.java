package Lesson2;

public class Homework24 {
    public static String[] phoneNubmerCheck(String phoneNumber) {
        String output = "";

        // Если номер начинается с +7, то заменять на 8
        if (phoneNumber.substring(0, 2).equals("+7")) {
            phoneNumber = phoneNumber.replace("+7", "8");
            output = "Замена +7 на 8";
        }

        // Если в номере есть пробелы и/или скобки - удалять
        if (phoneNumber.contains(" ") || phoneNumber.contains("(") || phoneNumber.contains(")")) {
            phoneNumber = phoneNumber.replace(" ", "").replace("(", "").
                    replace(")", "");
            if (!output.isEmpty())
                output = output + "; " + "В номере есть пробелы и/или скобки";
            else output = output + "В номере есть пробелы и/или скобки";
        }

        // Если после изменений количество символов не 11 - считаем, что введен некорректный номер
        if (phoneNumber.length() != 11) {
            phoneNumber = "Введен некорректный номер";
            if (!output.isEmpty())
                output = output + "; " + "Сумма символов не равна 11";
            else output = output + "Сумма символов не равна 11";
        }

        if (output.isEmpty())
            output = "Не было изменений";

        // На выход отдаем массив из 2 строк:
        // 1. Исправленный номер телефона, если номер корректный,
        // или строку "Введен некорректный номер" для некорректных номеров
        // 2. Список изменений и сработавших проверок на некорректность, которые были совершены через ";".
        // Если изменений не было - выводить "Не было изменений".
        return new String[]{phoneNumber, output};
    }

    public static void main(String[] args) {
        String phoneNumber = "+7 (919) 303 860 62";
        String[] array = phoneNubmerCheck(phoneNumber);
        for (String s : array) System.out.println(s);
    }
}
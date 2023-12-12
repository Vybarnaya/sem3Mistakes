package hw3Exception;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DataInput {

    public void enter() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите через пробел Фамилию,Имя,Отчество, дату рождения (в формате dd.mm.yyyy), номер телефона (целое беззнаковое число ), пол (f или m) :  ");

        String ownData = scanner.nextLine();

        String[] dataArray = ownData.split(" ");

        if (dataArray.length != 6) {
            throw new IOException("Введено неверное количество данных. Введите, пожалуйста, данные еще раз. ");
        }

        String firstName = dataArray[0];
        String secondName = dataArray[1];
        String mName = dataArray[2];
        String birthDay = dataArray[3];
        String phoneNumber = dataArray[4];
        String sexUser = dataArray[5];

        if (!firstName.matches("[A-Za-zА-Яа-яЁё]+")){
            throw new IOException("Неверный формат фамилии. Введите еще раз.");
        }

        if (!secondName.matches("[A-Za-zА-Яа-яЁё]+")){
            throw new IOException("Неверный формат имени. Введите еще раз.");
        }

        if (!mName.matches("[A-Za-zА-Яа-яЁё]+")){
            throw new IOException("Неверный формат отчества. Введите еще раз.");
        }

        if (!birthDay.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
            throw new IOException("Неверный формат даты. Введите в формате dd.mm.yyyy : ");
        }

        if (!phoneNumber.matches("\\d{11}")) {
            throw new IOException("Неверный формат телефонного номера. Введите в формате ххххххххххх : ");
        }

        if (!sexUser.equalsIgnoreCase("f") && !sexUser.equalsIgnoreCase("m")) {
            throw new IOException("Неверный формат пола. Введите f или m");
        }


        try (FileWriter writer = new FileWriter(firstName + ".txt", true)) {
            writer.write("< " + firstName.toUpperCase() + " > ");
            writer.write("< " + secondName.toUpperCase() + " > ");
            writer.write("< " + mName.toUpperCase() + " > ");
            writer.write("< " + birthDay + " > ");
            writer.write("< " + phoneNumber + " > ");
            writer.write("< " + sexUser + " > ");
            writer.write("\n");
            System.out.println("Данные записаны в файл " + firstName + ".txt");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
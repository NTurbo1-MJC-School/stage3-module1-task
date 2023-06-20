package com.mjc.school;

import com.mjc.school.controller.Controller;
import com.mjc.school.controller.impl.ControllerImpl;
import com.mjc.school.service.Dto.NewsDto;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter the number of operation:\n" +
                "1 - Get all news.\n" +
                "2 - Get news by id.\n" +
                "3 - Create news.\n" +
                "4 - Update news.\n" +
                "5 - Remove news by id.\n" +
                "0 - Exit.");

        Scanner scanner = new Scanner(System.in);
        try {
            int command = scanner.nextInt();
            Controller<NewsDto> controller = new ControllerImpl();

            if (command == 1) {
                System.out.println(controller.readAll());
                main(args);
            } else if (command == 2) {
                Scanner idScanner = new Scanner(System.in);
                System.out.println("Enter news id:");
                int id = idScanner.nextInt();
                System.out.println(controller.readById(Long.parseLong(String.valueOf(id))));
                main(args);
            } else if (command == 3) {
                Scanner fieldScanner = new Scanner(System.in);
                System.out.println("Enter news id:");
                int id = fieldScanner.nextInt();

                System.out.println("Enter news title:");
                String title = fieldScanner.nextLine();

                System.out.println("Enter news content:");
                String content = fieldScanner.nextLine();

                System.out.println("Enter news author id:");
                int authorId = fieldScanner.nextInt();

                NewsDto newsDto = new NewsDto(
                        Long.parseLong(String.valueOf(id)),
                        title,
                        content,
                        Long.parseLong(String.valueOf(authorId))
                );

                System.out.println(controller.create(newsDto));

                main(args);
            } else if (command == 4) {
                Scanner fieldScanner = new Scanner(System.in);
                System.out.println("Enter news id:");
                int id = fieldScanner.nextInt();

                System.out.println("Enter news title:");
                String title = fieldScanner.nextLine();

                System.out.println("Enter news content:");
                String content = fieldScanner.nextLine();

                System.out.println("Enter news author id:");
                int authorId = fieldScanner.nextInt();

                NewsDto newsDto = new NewsDto(
                        Long.parseLong(String.valueOf(id)),
                        title,
                        content,
                        Long.parseLong(String.valueOf(authorId))
                );

                System.out.println(controller.update(newsDto));
                main(args);
            } else if (command == 5) {
                Scanner idScanner = new Scanner(System.in);
                System.out.println("Enter news id:");
                int id = idScanner.nextInt();

                System.out.println(controller.delete(Long.parseLong(String.valueOf(id))));
                main(args);
            } else if (command == 0) {}
        } catch (InputMismatchException e) {
            System.out.println("Command not found.");
            main(args);
        }
    }
}

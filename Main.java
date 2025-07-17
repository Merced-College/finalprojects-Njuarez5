// Author: Nestor Juarez
// Date: July 17, 2025
// Main class to run the Quiz App
// Main quiz loop and user interaction developed by me, inspired by tutorial examples and ChatGPT suggestions.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        QuestionManager manager = new QuestionManager();
        Scanner scanner = new Scanner(System.in);

        // Adding sample questions - student written
        manager.addQuestion(new Question("What is the capital of California?", "Sacramento"));
        manager.addQuestion(new Question("What keyword is used to create a new object in Java?", "new"));
        manager.addQuestion(new Question("What data structure uses FIFO?", "Queue"));
        manager.addQuestion(new Question("What is the size complexity of a binary search?", "O(log n)"));

        int correctAnswers = 0;
        Question q;

        System.out.println("Welcome to the Quiz App!\n");

        // Main quiz loop - student written
        while ((q = manager.getNextQuestion()) != null) {
            System.out.println(q.getPrompt());
            String answer = scanner.nextLine().trim();

            if (answer.equalsIgnoreCase(q.getAnswer())) {
                System.out.println("Correct!");
                correctAnswers++;
            } else {
                System.out.println("Incorrect! The correct answer is: " + q.getAnswer());
                manager.addMissedQuestion(q);
            }
            System.out.println();
        }

        System.out.println("Quiz complete! You answered " + correctAnswers + " out of 4 correctly.\n");

        // Missed questions review loop - student written
        if (manager.hasMissedQuestions()) {
            System.out.println("Would you like to review the questions you missed? (yes/no)");
            String choice = scanner.nextLine().trim();

            while (choice.equalsIgnoreCase("yes") && manager.hasMissedQuestions()) {
                Question missed = manager.getNextMissedQuestion();
                System.out.println(missed.getPrompt());
                String answer = scanner.nextLine().trim();

                if (answer.equalsIgnoreCase(missed.getAnswer())) {
                    System.out.println("Correct!");
                } else {
                    System.out.println("Incorrect! The correct answer is: " + missed.getAnswer());
                }

                if (manager.hasMissedQuestions()) {
                    System.out.println("Review next missed question? (yes/no)");
                    choice = scanner.nextLine().trim();
                } else {
                    System.out.println("No more missed questions to review.");
                    break;
                }
            }
        }

        System.out.println("Thank you for playing the Quiz App!");
        scanner.close();
    }
}

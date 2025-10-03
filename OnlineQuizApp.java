package Quizapp;

import java.util.*;

class Question {
    String mcq;
    String[] options;
    int correctAnswer;

    Question(String mcq, String[] options, int correctAnswer) {
        this.mcq = mcq;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    void showQuestion() {
        System.out.println(mcq);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    boolean isCorrect(int answer) {
        return answer == correctAnswer;
    }

    String getCorrectAnswer() {
        return options[correctAnswer - 1];
    }
}

class Quiz {
    List<Question> questions = new ArrayList<>();
    int score = 0;

    void addQuestions() {
        questions.add(new Question("Which keyword is used to inherit a class in Java?",
                new String[]{"extends", "implements", "inherit", "super"}, 1));
        questions.add(new Question("Which of these is not OOP concept?",
                new String[]{"Encapsulation", "Polymorphism", "Compilation", "Inheritance"}, 3));
        questions.add(new Question("Which of the following is dynamically typed?",
                new String[]{"Java", "C", "C++", "Python"}, 4));
        questions.add(new Question("Which header file is required for printf() in C?",
                new String[]{"stdio.h", "stdlib.h", "string.h", "math.h"}, 1));
        questions.add(new Question("Which company originally developed Java?",
                new String[]{"Microsoft", "Oracle", "Sun Microsystems", "Google"}, 3));
    }

    void startQuiz() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < questions.size(); i++) {
            System.out.println("\nQ" + (i + 1) + ": ");
            questions.get(i).showQuestion();
            System.out.print("Enter your choice (1-4): ");
            int ans = sc.nextInt();

            if (questions.get(i).isCorrect(ans)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! Correct Answer: " + questions.get(i).getCorrectAnswer());
            }
        }
    }

    void showResult() {
        System.out.println("\n----- Quiz Over -----");
        System.out.println("Your Score: " + score + " out of " + questions.size());
        if (score == questions.size()) {
            System.out.println("Excellent, all correct!");
        } else if (score >= questions.size() / 2) {
            System.out.println("Good attempt, you passed.");
        } else {
            System.out.println("Need more practice!");
        }
    }
}

public class OnlineQuizApp {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.addQuestions();
        quiz.startQuiz();
        quiz.showResult();
    }
}


// Author: Nestor Juarez
// Date: July 17, 2025
// This class manages quiz questions using multiple data structures.
// Data structures and recursion adapted with guidance from ChatGPT (OpenAI).
// Student code is clearly marked below.

import java.util.*;

public class QuestionManager {
    // Data structures designed by me to meet project requirements:
    // ArrayList for storing all questions,
    // Queue for quiz order,
    // Stack for missed questions review,
    // LinkedList for demonstrating recursion.
    private ArrayList<Question> questions;
    private Queue<Question> questionQueue;
    private Stack<Question> missedQuestions;
    private LinkedList<Question> questionList;

    // Constructor - student written
    public QuestionManager() {
        questions = new ArrayList<>();
        questionQueue = new LinkedList<>();
        missedQuestions = new Stack<>();
        questionList = new LinkedList<>();
    }

    // Adds a question to all data structures - student written
    public void addQuestion(Question q) {
        questions.add(q);
        questionQueue.offer(q);
        questionList.add(q);
    }

    // Retrieves the next question from the queue - student written
    public Question getNextQuestion() {
        return questionQueue.poll();
    }

    // Adds a missed question to the stack - student written
    public void addMissedQuestion(Question q) {
        missedQuestions.push(q);
    }

    // Checks if there are missed questions - student written
    public boolean hasMissedQuestions() {
        return !missedQuestions.isEmpty();
    }

    // Retrieves the next missed question from the stack - student written
    public Question getNextMissedQuestion() {
        return missedQuestions.isEmpty() ? null : missedQuestions.pop();
    }

    // Recursive search method implemented with guidance from ChatGPT (OpenAI)
    // I adapted this method to fulfill the recursion requirement.
    public boolean searchRecursive(LinkedList<Question> list, String prompt, int index) {
        if (index >= list.size()) {
            return false;
        }
        if (list.get(index).getPrompt().equalsIgnoreCase(prompt)) {
            return true;
        }
        return searchRecursive(list, prompt, index + 1);
    }
}

// Author: Nestor Juarez
// Date: July 17, 2025
// This class defines a simple Question object with a prompt and answer.

public class Question {
    private String prompt;
    private String answer;

    // Constructor written by me
    public Question(String prompt, String answer) {
        this.prompt = prompt;
        this.answer = answer;
    }

    // Getter for question prompt
    public String getPrompt() {
        return prompt;
    }

    // Getter for correct answer
    public String getAnswer() {
        return answer;
    }
}

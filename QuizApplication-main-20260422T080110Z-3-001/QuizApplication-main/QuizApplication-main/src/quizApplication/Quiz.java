package quizApplication;

import java.util.Scanner;

public class Quiz {
    private MultipleChoiceQuestion[] questions;
    private int score;
    
    public Quiz(MultipleChoiceQuestion[] questions) {
        this.questions = questions;
        this.score = 0;
    }
    
    //Method to display the quiz questions and get the answer from user and validate them
    public void startQuiz() {
        Scanner sc = new Scanner(System.in);
        for(int questCnt=0; questCnt < questions.length; questCnt++) {
            System.out.println("\nQuestion "+(questCnt+1));
            questions[questCnt].displayQuestion();
            System.out.println("Enter your option [1 to 4]");
            int fetchOption = sc.nextInt();
            if(questions[questCnt].validateAnswer(fetchOption)) {
                System.out.println("Correct Answer!!");
                score += 1;
            } else
                System.out.println("Oops!! Wrong Answer");
        }
        displayOverallScore();
    }
    
    //Method to display the score after quiz completion
    public void displayOverallScore() {
        System.out.println("\nQuiz Completed!");
        System.out.println("Your Score: " + score + "/" + questions.length);

    }
    
}

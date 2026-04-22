package AdavanceQuizApplication;

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
            int questionScore = questions[questCnt].calculateScore(fetchOption);
            if(questionScore > 0) {
                System.out.println("Correct Answer!! "+questionScore+" points");
            } else if (questionScore < 0)
                System.out.println("Oops!! Wrong Answer you lost "+questionScore+" points");
            else
                System.out.println("Oops!! Wrong Answer! No points awarded.");
            score += 1;
        }
        displayOverallScore();
    }
    
    //Method to display the score after quiz completion
    public void displayOverallScore() {
        if(score < 0)
            score = 0;  //Avoid negative score
        System.out.println("\nQuiz Completed!");
        System.out.println("Your Score: " + score);

    }
    
}

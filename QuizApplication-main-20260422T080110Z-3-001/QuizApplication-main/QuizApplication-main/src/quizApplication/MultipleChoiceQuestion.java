package quizApplication;


public class MultipleChoiceQuestion {

    private String questionText;
    private String[] optionList;
    private int correctAnsPos;
    
    //Constructs a MultipleChoiceQuestion object.
    public MultipleChoiceQuestion(String questionText, String[] optionList, int correctAnsPos) {
        this.questionText = questionText;
        this.optionList = optionList;
        this.correctAnsPos = correctAnsPos;
    }
    
    //Method to display the question and respection options
    public void displayQuestion() {
        System.out.println(questionText);
        for(int optCnt=0; optCnt<optionList.length; optCnt++)
            System.out.println((optCnt+1) + ". " + optionList[optCnt]);
    }
    
    //Method to evaluate the user choice and return the result
    public boolean validateAnswer(int userChoice) {
        return userChoice == correctAnsPos+1;
    }
}

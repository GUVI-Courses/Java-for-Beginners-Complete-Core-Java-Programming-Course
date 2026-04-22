package quizApplication;

public class MainQuizApplication {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MultipleChoiceQuestion q1 = new MultipleChoiceQuestion(
                "Which keyword is used to define a class in Java?",
                new String[]{"new", "class", "Class", "define"},
                1
        );

        MultipleChoiceQuestion q2 = new MultipleChoiceQuestion(
                "Which data type is used to store decimal values?",
                new String[]{"int", "double", "char", "boolean"},
                1
        );

        MultipleChoiceQuestion q3 = new MultipleChoiceQuestion(
                "What does JVM stand for?",
                new String[]{"Java Virtual Machine", "Java Variable Method",
                        "Java Visual Model", "Joint Virtual Module"},
                0
        );

        MultipleChoiceQuestion q4 = new MultipleChoiceQuestion(
                "Which loop executes at least once?",
                new String[]{"for loop", "while loop", "do-while loop", "none"},
                2
        );

        MultipleChoiceQuestion q5 = new MultipleChoiceQuestion(
                "Which operator is used for logical AND?",
                new String[]{"&", "&&", "|", "||"},
                1
        );

        MultipleChoiceQuestion[] MultipleChoiceQuestions = {q1, q2, q3, q4, q5};

        Quiz quiz = new Quiz(MultipleChoiceQuestions);
        quiz.startQuiz();
    }
 }



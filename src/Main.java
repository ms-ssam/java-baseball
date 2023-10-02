import handler.BaseballGameHandler;
import model.ScoreModel;
import model.enums.ScoreStatus;

import java.util.Scanner;

public class Main {
    public static Integer GAME_PROCESSING_SIGNAL = 1;
    public static Integer GAME_TERMINATE_SIGNAL = 2;

    public static void main(String[] args) {
        System.out.println("게임 시작!");

        int replay = GAME_PROCESSING_SIGNAL;
        BaseballGameHandler handler = new BaseballGameHandler();
        Scanner scanner = new Scanner(System.in);

        Integer realAnswer = handler.getRandomNumber();

        while (replay == GAME_PROCESSING_SIGNAL) {
            System.out.println("enter the number : ");
            Integer myAnswer = scanner.nextInt();

            ScoreModel scoreModel = ScoreModel.fromAnswers(myAnswer.toString(), realAnswer.toString());

            ScoreStatus gameStatus = scoreModel.getGameStatus();
            String result = handler.getResultFromScoreModel(scoreModel);

            System.out.println("게임 결과: " + result);

            if (handler.isGameEnd(scoreModel)) {
                System.out.println("You catch all these three numbers! stop the game");
                System.out.println("enter 1 to restart, or enter 2 to exit");

                replay = scanner.nextInt();
                realAnswer = handler.getRandomNumber();
            }
        }

        System.out.println("Main exit");
    }
}

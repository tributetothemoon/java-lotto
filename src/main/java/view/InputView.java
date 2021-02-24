package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String MESSAGE_BUDGET = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요. (쉼표로 구분)";
    private static final String MESSAGE_BONUS_BALL = "보너스 볼을 입력해 주세요.";
    private static final String COMMA = ",";
    private static final String ERROR_INVALID_BLANK = "[ERROR] 값을 입력해주세요.";

    private static InputView instance;

    private final Scanner scanner = new Scanner(System.in);

    public static InputView getInstance() {
        if (instance == null) {
            instance = new InputView();
        }
        return instance;
    }

    private String deleteWhiteSpaces(String string) {
        return string.replaceAll("\\s+", "");
    }

    private boolean isEmptyString(String string) throws NullPointerException {
        return string.equals("");
    }

    public String scanBudget() {
        System.out.println(MESSAGE_BUDGET);
        String inputString = deleteWhiteSpaces(scanner.nextLine());
        if (isEmptyString(inputString)) {
            System.out.println(ERROR_INVALID_BLANK);
            return scanBudget();
        }
        return inputString;
    }

    public List<String> scanWinningNumber() {
        System.out.println(MESSAGE_WINNING_NUMBER);
        String inputString = deleteWhiteSpaces(scanner.nextLine());
        if (isEmptyString(inputString)) {
            System.out.println(ERROR_INVALID_BLANK);
            return scanWinningNumber();
        }
        return Arrays.asList(inputString.split(COMMA));
    }

    public String scanBonusBall() {
        System.out.println(MESSAGE_BONUS_BALL);
        String inputString = deleteWhiteSpaces(scanner.nextLine());
        if (isEmptyString(inputString)) {
            System.out.println(ERROR_INVALID_BLANK);
            return scanBonusBall();
        }
        return inputString;
    }
}

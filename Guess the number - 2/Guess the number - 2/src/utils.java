public class utils {
    public static int generateRandomNumberWithScope() {
        int min = 0;
        int max = 100;
        return (int) (Math.random() * (max - min) + min);
    }
    public static void checkIfNumberIsHigherOrLower(int guessedNumber, int generatedNumber) {
        if (guessedNumber > generatedNumber) {
            System.out.println("Tip: Generated number is lower");
        } else if (guessedNumber < generatedNumber) {
            System.out.println("Tip: Generated number is higher");
        }
    }
}

public class CreditCardValidator {

    public static boolean isValidCreditCard(String cardNumber) {
        int sumStep3 = 0;
        int sumStep5 = 0;
        
        for (int count = 0; count < cardNumber.length(); count++) {
            char digitChar = cardNumber.charAt(cardNumber.length() - 1 - count);

            // check for non-digit characters
            if (!Character.isDigit(digitChar)) {
                return false;
            }

            int digit = Character.getNumericValue(digitChar);

            if (count % 2 == 0) {
                sumStep5 += digit;
            } else {
                int doubled = digit * 2;
                if (doubled >= 10) {
                    doubled = doubled - 9;
                }
                sumStep3 += doubled;
            }
        }

        int finalSum = sumStep3 + sumStep5;
        return finalSum % 10 == 0;
    }

    // Optional main method to allow manual testing
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your credit card number: ");
        String cardNumber = scanner.nextLine();

        boolean isValid = isValidCreditCard(cardNumber);
        System.out.println("Credit card is valid: " + isValid);
    }
}
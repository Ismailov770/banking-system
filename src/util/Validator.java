package util;


import exceptions.InvalidAccountException;

public class Validator {
    public static void checkAccountNumber(String number) throws InvalidAccountException {
        if (number == null || !number.matches("\\d{10}"))
            throw new InvalidAccountException("Account number must be 10 digits!");
    }
}

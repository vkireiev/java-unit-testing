package ua.vkireiev.testing.module02.exercise0203;

public class InterestCalculator {

    public double calculateInterest(double principal, double rate, double time)
        throws IllegalArgumentException {

        makeCheckForPositivity(principal, "Principal", true);
        makeCheckForPositivity(time, "Time", false);

        int intTime = (int) time;

        return principal * rate * intTime;
    }

    private void makeCheckForPositivity(double variableValue, String variableName, boolean isZeroAllowed)
        throws IllegalArgumentException {

        if (!isZeroAllowed && variableValue == 0.0d) {
            throw new IllegalArgumentException(variableName + " value cannot be 0.");
        }

        if (variableValue < 0.0d) {
            throw new IllegalArgumentException(variableName + " value must be greater than 0.");
        }
    }
}

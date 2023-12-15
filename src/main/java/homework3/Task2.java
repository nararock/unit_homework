package homework3;

public class Task2 {
    private int lowerLimit;
    private int upperLimit;
    public Task2(int lowerLim, int upperLim){
        if (lowerLim < upperLim){
            lowerLimit = lowerLim;
            upperLimit = upperLim;
        }
        else {
            throw new RuntimeException("Нижняя граница должна быть строго меньше верхней.");
        }
    }
    public boolean numberInInterval(int n) {
        return n > lowerLimit && n < upperLimit;
    }
}

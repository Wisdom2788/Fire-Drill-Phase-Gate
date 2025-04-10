import java.time.LocalDate;

public class CycleLogic {

    public String calculateFlowDate(String startDate) {
        return startDate;
    }

    public String calculateNextPeriod(String startDate, int cycleLength) {
        LocalDate date = LocalDate.parse(startDate);
        LocalDate nextPeriod = date.plusDays(cycleLength);
        return nextPeriod.toString();
    }

    public String calculateOvulationDate(String startDate, int cycleLength) {
        LocalDate date = LocalDate.parse(startDate);
        LocalDate ovulation = date.plusDays(cycleLength - 14);
        return ovulation.toString();
    }

    public String calculateFertileWindow(String startDate, int cycleLength) {
        LocalDate date = LocalDate.parse(startDate);
        LocalDate startWindow = date.plusDays(cycleLength - 17);
        LocalDate endWindow = date.plusDays(cycleLength - 12); 
        return "Fertile window: " + startWindow + " to " + endWindow;
    }

    public String calculateSafePeriod(String startDate, int cycleLength) {
        LocalDate date = LocalDate.parse(startDate);
        LocalDate fertileStart = date.plusDays(cycleLength - 17);
        LocalDate fertileEnd = date.plusDays(cycleLength - 12);
        LocalDate safeStart1 = date;
        LocalDate safeEnd1 = fertileStart.minusDays(1);
        LocalDate safeStart2 = fertileEnd.plusDays(1);
        LocalDate safeEnd2 = date.plusDays(cycleLength - 1);
        return "Safe period: " + safeStart1 + " to " + safeEnd1 + " and " + safeStart2 + " to " + safeEnd2;
    }
}

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MenstrualCycleAppTest {

    @Test
    public void testFlowDateReturnsSameDate() {
        CycleLogic cycle = new CycleLogic();
        String result = cycle.calculateFlowDate("2025-04-01");
        assertEquals("2025-04-01", result);
    }

    @Test
    public void testNextPeriodDate() {
        CycleLogic cycle = new CycleLogic();
        String result = cycle.calculateNextPeriod("2025-04-01", 28);
        assertEquals("2025-04-29", result);
    }

    @Test
    public void testOvulationDate() {
        CycleLogic cycle = new CycleLogic();
        String result = cycle.calculateOvulationDate("2025-04-01", 28);
        assertEquals("2025-04-15", result);
    }

    @Test
    public void testFertileWindow() {
        CycleLogic cycle = new CycleLogic();
        String result = cycle.calculateFertileWindow("2025-04-01", 28);
        assertEquals("Fertile window: 2025-04-11 to 2025-04-16", result);
    }

    @Test
    public void testSafePeriod() {
        CycleLogic cycle = new CycleLogic();
        String result = cycle.calculateSafePeriod("2025-04-01", 28);
        assertTrue(result.contains("Safe period:"));
    }
}

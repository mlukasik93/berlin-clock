import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(JUnitParamsRunner.class)
public class BerlinClockTest {

    @Test
    @Parameters({
            "00:00:00, 0000",
            "23:59:59, YYYY",
            "12:32:00, YY00",
            "12:34:00, YYYY",
            "12:35:00, 0000"
    })
    public void shouldCalculateSingleMinutesRow(String time, String expectedMinutesRow) {
        //Given
        BerlinClock bc = new BerlinClock();
        //When
        String singleMinuteRow = bc.getSingleMinutesRow(time);
        //Then
        assertThat(singleMinuteRow).isEqualTo(expectedMinutesRow);
    }

    @Test
    @Parameters({
            "00:00:00, 00000000000",
            "23:59:59, YYRYYRYYRYY",
            "12:04:00, 00000000000",
            "12:23:00, YYRY0000000",
            "12:35:00, YYRYYRY0000"
    })
    public void shouldCalculateFiveMinutesRow(String time, String expectedFiveMinutesRow) {
        //Given
        BerlinClock bc = new BerlinClock();
        //When
        String fiveMinutesRow = bc.getFiveMinutesRow(time);
        //Then
        assertThat(fiveMinutesRow).isEqualTo(expectedFiveMinutesRow);
    }

    @Test
    @Parameters({
            "00:00:00, 0000",
            "23:59:59, RRR0",
            "02:04:00, RR00",
            "08:23:00, RRR0",
            "14:35:00, RRRR"
    })
    public void shouldCalculateSingleHourRow(String time, String expectedSingleHourRow) {
        //Given
        BerlinClock bc = new BerlinClock();
        //When
        String singleHourRow = bc.getSingleHourRow(time);
        //Then
        assertThat(singleHourRow).isEqualTo(expectedSingleHourRow);
    }

    @Test
    @Parameters({
            "00:00:00, 0000",
            "23:59:59, RRRR",
            "02:04:00, 0000",
            "08:23:00, R000",
            "16:35:00, RRR0"
    })
    public void shouldCalculateFiveHourRow(String time, String expectedFiveHoursRow) {
        //Given
        BerlinClock bc = new BerlinClock();
        //When
        String fiveHoursRow = bc.getFiveHoursRow(time);
        //Then
        assertThat(fiveHoursRow).isEqualTo(expectedFiveHoursRow);
    }

    @Test
    @Parameters({
            "00:00:00, Y",
            "23:59:59, 0"
    })
    public void shouldCalculateSecondsLamp(String time, String expectedSecondsLamp) {
        //Given
        BerlinClock bc = new BerlinClock();
        //When
        String secondsLamp = bc.getSecondsLamp(time);
        //Then
        assertThat(secondsLamp).isEqualTo(expectedSecondsLamp);
    }

    @Test
    @Parameters({
            "00:00:00, Y00000000000000000000000",
            "23:59:59, 0RRRRRRR0YYRYYRYYRYYYYYY",
            "16:50:06, YRRR0R000YYRYYRYYRY00000",
            "11:37:01, 0RR00R000YYRYYRY0000YY00"
    })
    public void shouldCalculateBerlinCloak(String time, String expectedBerlinClock) {
        //Given
        BerlinClock bc = new BerlinClock();
        //When
        String berlinClock = bc.getClock(time);
        //Then
        assertThat(berlinClock).isEqualTo(expectedBerlinClock);
    }
}
/*
    Berlin Clock
    Create a representation of the Berlin Clock for a given time (hh::mm:ss).

    The Berlin Uhr (Clock) is a rather strange way to show the time.
    On the top of the clock there is a yellow lamp that blinks on/off every two seconds.
    The time is calculated by adding rectangular lamps.

    The top two rows of lamps are red. These indicate the hours of a day. In the top row there are 4 red lamps.
    Every lamp represents 5 hours. In the lower row of red lamps every lamp represents 1 hour.
    So if two lamps of the first row and three of the second row are switched on that indicates 5+5+3=13h or 1 pm.

    The two rows of lamps at the bottom count the minutes. The first of these rows has 11 lamps, the second 4.
    In the first row every lamp represents 5 minutes.
    In this first row the 3rd, 6th and 9th lamp are red and indicate the first quarter, half and last quarter of an hour.
    The other lamps are yellow. In the last row with 4 lamps every lamp represents 1 minute.

    The lamps are switched on from left to right.

    Y = Yellow
    R = Red
    O = Off
*/

public class BerlinClock {


    private String[] split;

    public String getClock(String time) {

        return getSecondsLamp(time)
                + getFiveHoursRow(time)
                + getSingleHourRow(time)
                + getFiveMinutesRow(time)
                + getSingleMinutesRow(time);
    }

    String getSingleMinutesRow(String time) {
        split = time.split(":");
        String singleMinute="0000";
        if ((Integer.parseInt(split[1])) != 0) {
            int temp = (Integer.parseInt(split[1]))%5;
            switch (temp) {
                case 1:
                    singleMinute = "Y000";
                    break;
                case 2:
                    singleMinute = "YY00";
                    break;
                case 3:
                    singleMinute = "YYY0";
                    break;
                case 4:
                    singleMinute = "YYYY";
                    break;
            }

        }

        return singleMinute;
    }

    String getFiveMinutesRow(String time) {
        split = time.split(":");
        String fiveMinutes = "";
        String wholeTime = "YYRYYRYYRYY";
        if (Integer.parseInt(split[1]) >= 5) {
            int i = 0;
            int temp = Integer.parseInt(split[1]) / 5;
            while (i < wholeTime.length()) {
                fiveMinutes = wholeTime.substring(0, temp);
                i++;
            }
            for (int j = 0; j < (wholeTime.length() -temp); j++) {
                fiveMinutes = new StringBuilder(fiveMinutes).append("0").toString();
            }
        } else fiveMinutes = "00000000000";
        return fiveMinutes;
    }

    String getSingleHourRow(String time) {
        split = time.split(":");
        String singleHour = "0000";
        if (Integer.parseInt(split[0]) % 5 != 0) {
            int temp = Integer.parseInt(split[0]) % 5;
            switch (temp) {
                case 1:
                    singleHour = "R000";
                    break;
                case 2:
                    singleHour = "RR00";
                    break;
                case 3:
                    singleHour = "RRR0";
                    break;
                case 4:
                    singleHour = "RRRR";
                    break;
            }
        }
        return singleHour;
    }

    String getFiveHoursRow(String time) {
        split = time.split(":");
        String fiveHour = "0000";
        if ((Integer.parseInt(split[0])) != 0) {
            int temp = (Integer.parseInt(split[0])) / 5;
            switch (temp) {
                case 1:
                    fiveHour = "R000";
                    break;
                case 2:
                    fiveHour = "RR00";
                    break;
                case 3:
                    fiveHour = "RRR0";
                    break;
                case 4:
                    fiveHour = "RRRR";
                    break;
            }

        }
        return fiveHour;
    }

    String getSecondsLamp(String time) {
        split = time.split(":");
        String sec = "0";
        if ((Integer.parseInt(split[2])) % 2 == 0) {
            sec = "Y";
        }
        return sec;
    }
}

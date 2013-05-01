package doo.daba.java.beans;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Gerardo Aquino
 * Date: 11/07/13
 */
@RequiredArgsConstructor
public class DaysOfMonthEntries {

    @Getter @Setter
    private int firstDayPosition;

    @Getter @Setter
    private List<DayOfMonth> daysOfMonth;

    @NonNull
    @Setter @Getter
    private boolean error;

    @NonNull
    @Getter @Setter
    private String message;


    public DaysOfMonthEntries() {
        this.init();
    }


    private void init() {
        this.daysOfMonth = new ArrayList<DayOfMonth>();
    }

    public void addMonth(int day, boolean hasEntries) {
        this.daysOfMonth.add(new DayOfMonth(day, hasEntries));
    }


    @AllArgsConstructor
    public class DayOfMonth {
        @NonNull @Getter
        private int day;
        @NonNull @Getter
        private boolean active;
    }
}

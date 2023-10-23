package sample;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 * <p>
 * <p>
 * package sample;
 * <p>
 * import java.time.LocalDate;
 * import java.util.Collection;
 * import java.util.List;
 * <p>
 * /**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 * <p>
 * Implement in single class. Don't chane constructor and signature method.
 */
public class DateSorter {

    /**
     * The implementation of this method should sort dates.
     * The output should be in the following order:
     * Dates with an 'r' in the month,
     * sorted ascending (first to last),
     * then dates without an 'r' in the month,
     * sorted descending (last to first).
     * For example, October dates would come before May dates,
     * because October has an 'r' in it.
     * thus: (2004-07-01, 2005-01-02, 2007-01-01, 2032-05-03)
     * would sort to
     * (2005-01-02, 2007-01-01, 2032-05-03, 2004-07-01)
     *
     * @param unsortedDates - an unsorted list of dates
     * @return the collection of dates now sorted as per the spec
     */
    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        //Create two list to store date with "r" in month and without "r" in month
        List<LocalDate> datesWithRInMonth = new ArrayList<>();
        List<LocalDate> datesWithoutRInMonth = new ArrayList<>();


        for (LocalDate date : unsortedDates) {
            //Check if the date contains "r" in month and put it in an appropriate List
            if (isMonthWithR(date)) {
                datesWithRInMonth.add(date);
            } else {
                datesWithoutRInMonth.add(date);
            }
        }

        //Sort lists in ascending and descending order
        Collections.sort(datesWithRInMonth);
        Collections.sort(datesWithoutRInMonth, Collections.reverseOrder());

        datesWithRInMonth.addAll(datesWithoutRInMonth);

        return datesWithRInMonth;
    }


    //Check if the date contains "r" in its month
    private boolean isMonthWithR(LocalDate date) {
        return date.getMonth().toString().toLowerCase().contains("r");
    }
}

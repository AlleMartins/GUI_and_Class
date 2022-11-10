package it.unibo.nestedenum;

import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    public enum Month {
        JANUARY(31),
        FEBRUARY(28),
        MARCH(31),
        APRIL(30),
        MAY(31),
        JUNE(30),
        JULY(31),
        AUGUST(31),
        SEPTEMBER(30),
        OCTOBER(31),
        NOVEMBER(30),
        DECEMBER(31);

        private int days;

        private Month(final int days){
            this.days = days;
        }

        public static Month fromString(final String month){
            Month result = null;
            for(Month elem : Month.values()){
                if(elem.toString().toLowerCase().startsWith( month.toString().toLowerCase())){
                    if(result != null){
                        throw new IllegalArgumentException();
                    }
                    result = elem;
                }
            }
            if(result == null){
                throw new IllegalArgumentException();
            }
            return result;
        }
    }

    private class SortByDays implements Comparator<String>{
        @Override
        public int compare(String o1, String o2) {
            final var var1 = Month.fromString(o1).days;
            final var var2 = Month.fromString(o2).days;

            return Integer.compare(var1, var2);
        }     
    }   

    @Override
    public Comparator<String> sortByDays() {
        return new SortByDays();
    }

    private class SortByOrder implements Comparator<String>{
        @Override
        public int compare(String o1, String o2) {
            final var var1 = Month.fromString(o1).ordinal();
            final var var2 = Month.fromString(o2).ordinal();

            return Integer.compare(var1, var2);
        }
    }

    @Override
    public Comparator<String> sortByOrder() {
        return new SortByOrder();
    }
}

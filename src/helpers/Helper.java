package helpers;

public class Helper {

    public java.sql.Date convertDate(java.util.Date date) {
        return new java.sql.Date(date.getTime());
    }

    public java.sql.Time ConvertTime(long time) {
        return new java.sql.Time(time);
    }
}

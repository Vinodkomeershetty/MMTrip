package mmutil

import geb.Page

import java.text.SimpleDateFormat

/**
 * Created by vinodk on 16-10-2015.
 */
class MmtUtils{


    def getAddedMonthDate(String s1,String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date=sdf.parse(s1)
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, 1);
        def date1= sdf.format(cal.getTime())
        return date1
    }

    def getDateValfrmString(String dateval,String actualformat,String expformat) {
        SimpleDateFormat sdf = new SimpleDateFormat(actualformat);
        Date date=sdf.parse(dateval)
        SimpleDateFormat expf = new SimpleDateFormat(expformat);
       String finals= expf.format(date)

//        Calendar cal = Calendar.getInstance();
//        cal.setTime(date);
//        def date1= sdf.format(cal.getTime())
        return finals
    }


}

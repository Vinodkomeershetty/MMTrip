package makemytrip.pages
import geb.Page
import makemytripmodules.SearchResultsModule
import mmutil.MmtUtils
import java.text.DateFormat
import java.text.SimpleDateFormat
/**
 * Created by vinodk on 19-10-2015.
 */
class SearchResultsPage extends Page {

    MmtUtils mmt=new MmtUtils();
    static at={
        title=="Flight Search"

    }
    static content={
        SearchResultsobj{module SearchResultsModule}
    }

    def verifyFromAndToAddress(String frmaddr,String toaddr){

        def  temp=SearchResultsobj.fromAndToAdress.text().split("to")
        temp[0].trim().contentEquals(frmaddr)
        temp[1].trim().contentEquals(toaddr)
    }

    def verifyDepartureDate(String twe_date) {
        println twe_date
        def temp=SearchResultsobj.departureDate.text().split("\n")
        def depDateInResultsPage= temp[1]+temp[2]
        def s2=  mmt.getAddedMonthDate(twe_date,"dd-MM-yyyy")
        def s3 = mmt.getDateValfrmString(s2, "dd-MM-yyyy","ddMMM yy")
        depDateInResultsPage.equalsIgnoreCase(s3)
    }
    def verifyAdultCount(String adulCount){
       def str=SearchResultsobj.adultCount.text().split("ADULT")
        print str[1]
        print adulCount
        str[1].trim().contentEquals(adulCount)
    }
    def verifyDepartureSearchRecord(def s1)
    {
        try {
            String li = SearchResultsobj.departureRecordTexts.text()
            li.trim().contentEquals(s1)

        }
        catch(NullPointerException e)
        {
            print "Ignore Null  Values"
        }
    }
    def verifyArrivalSearchRecord(def s1)
    {
        String li= SearchResultsobj.arrivalRecordTexts.text()
        li.trim().contentEquals(s1)
    }
    def clickOnBookButton(){
        SearchResultsobj.bookButton.click()
    }
    def clickOnShowDetails(){
        SearchResultsobj.showDetailsButton.click()
    }
    def clickOnItenararyButton(){
        SearchResultsobj.itenararyButton.click()
    }

    def getDepartureTime()
    {
        String s1=SearchResultsobj.departureTimes.text()
        return s1
    }
    def getArrivalTime()
    {
        String s2=SearchResultsobj.arrivalTimes.text()
        return s2
    }
    def verifyItenararyDetails(String dep,String arr,String srcshrt,String srclng,String destshrt,String destlong,String durtime,String flightype)
    {
       def itsrc=SearchResultsobj.itenararysrc.text().split("\n")
        itsrc[0].contentEquals(dep)
        itsrc[1].contentEquals(srcshrt)
        itsrc[2].contentEquals(srclng)

        def itdest=SearchResultsobj.itenararydest.text().split("\n")
        itdest[0].contentEquals(arr)
        itdest[1].contentEquals(destshrt)
        itdest[2].contentEquals(destlong)

        def it_dur=SearchResultsobj.itenararyduration.text().split("\n")
        it_dur[0].contentEquals(durtime)
        it_dur[1].contentEquals(flightype)
    }

    def getDurationTime(){
        String s3=SearchResultsobj.durationTimes.text()
        return s3
    }
    def getFlightType()
    {
        String s4=SearchResultsobj.flightTypes.text()
        return  s4
    }


}

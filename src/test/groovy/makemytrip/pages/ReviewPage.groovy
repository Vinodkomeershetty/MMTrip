package makemytrip.pages

import geb.Page
import makemytripmodules.ReviewModule
import mmutil.MmtUtils

/**
 * Created by vinodk on 20-10-2015.
 */
class ReviewPage extends Page
{
    MmtUtils mmt=new MmtUtils()
    static at={
    title=="Flights Review"
    }
    static content={
        ReviewPageObj{module ReviewModule}
    }
    def verifyDepartureDateinReviewPage(String depttime,String shrtsrc,String lngsrc){
        waitFor {ReviewPageObj.departureDate.isDisplayed()}
        def temp=ReviewPageObj.departureDate.text().split("\n")
        print temp
        print temp[0]
        temp[0].contentEquals(depttime)
        temp[1].contentEquals(shrtsrc)
        temp[2].contentEquals(lngsrc)
    }

    def verifyArrivalDateinReviewPage(String arrtime,String shrtsrc,String lngsrc){
        def temp1=ReviewPageObj.arrivalDate.text().split("\n")
        temp1[0].contentEquals(arrtime)
        temp1[1].contentEquals(shrtsrc)
        temp1[2].contentEquals(lngsrc)
    }
    def verifyDurationDateinReviewPage(String durtime,String flighType){
        def temp2=ReviewPageObj.durationDate.text().split("\n")
        temp2[0].contentEquals(durtime)
        temp2[1].contentEquals(flighType)
    }
    def verifyDeptDateinReviewPage(String s) {
        def s2=  mmt.getAddedMonthDate(s,"dd-MM-yyyy")
        def s3 = mmt.getDateValfrmString(s2, "dd-MM-yyyy","dd MMM yyyy")
        def s4= ReviewPageObj.datedept.text().split(",")
        s4[0].contentEquals(s3)
    }
    def clickOnContinueButtoninReviewPage()
    {
        waitFor {ReviewPageObj.continueButton.isDisplayed()}
        ReviewPageObj.continueButton.click()
    }


    def getGrandTotalinReviewPage()
    {
        String temp=ReviewPageObj.grndTotalinReviewPage.text()
        return temp

    }
    def clickOnIAgreeButton(){
        waitFor {ReviewPageObj.iAgreebutton.isDisplayed()}
        if(ReviewPageObj.iAgreebutton.displayed)
            ReviewPageObj.iAgreebutton.click(TravellersPage)
    }

    def  passValuesTOEmailField(String email){
        js.exec "scroll(0,300);"
        if(ReviewPageObj.email_field.displayed) {
            ReviewPageObj.email_field.value("")
            ReviewPageObj.email_field.value(email)
        }
        else
        {
            print " "
        }
		
		sdscsfcf
    }
}

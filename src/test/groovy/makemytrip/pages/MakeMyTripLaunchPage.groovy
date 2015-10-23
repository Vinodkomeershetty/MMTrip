package makemytrip.pages

import geb.Page
import makemytripmodules.MakeMyTripLaunchModule

/**
 * Created by vinodk on 16-10-2015.
 */
class MakeMyTripLaunchPage extends Page{

//    static  url={"/"}
     static at = { title == "MakeMyTrip, India's No 1 Travel Site | Book Flights, Hotels, Holiday Packages & Bus Tickets" }
     static content={
         MakeMyTripLaunchPageObjects{module MakeMyTripLaunchModule}
           }
    def closeOfferDialog(){
        if(MakeMyTripLaunchPageObjects.closeiconInOfferDialog.displayed){
            MakeMyTripLaunchPageObjects.closeiconInOfferDialog.click()
        }
        else{
            print "Offer Dialog Not Displayed"
        }
    }

    def loginToMakeMyTripPortal(def username,def password){
        MakeMyTripLaunchPageObjects.userNameField.value(username)
        MakeMyTripLaunchPageObjects.passwordField_text.click()
        MakeMyTripLaunchPageObjects.passwordField.value(password)
        MakeMyTripLaunchPageObjects.continueButton.click()
    }
    def clickOnLoginLink(){
        MakeMyTripLaunchPageObjects.login_link.click()
    }
    def  verifyLogin(){
        def var=MakeMyTripLaunchPageObjects.login_link.text()
        var.contains('Hello! user')
    }

    def addAdults(int i) {
        if(MakeMyTripLaunchPageObjects.increaseAdultCount.displayed){
            int temp=1;
            while(temp<i)
            {
                MakeMyTripLaunchPageObjects.increaseAdultCount.click()
                temp++
            }
        }
        else{
            print "Either Adult count button Not Displayed or Youve selected 1 option"
        }
    }
    def  clickOnSearchFlightButton(){
        MakeMyTripLaunchPageObjects.searchFlightsButton.click()
    }
    def clickOnOneWayOption(){
        MakeMyTripLaunchPageObjects.oneWayOption.click()
    }
    def passValuestoFromField(String from) {
        MakeMyTripLaunchPageObjects.fromField.value(from)
    }
    def passValuestoToField(String to){
        MakeMyTripLaunchPageObjects.toField.value(to)
    }
    def selectStartDate(String date){
        MakeMyTripLaunchPageObjects.startDateField.click()
        MakeMyTripLaunchPageObjects.startdate(date).click()
    }




}

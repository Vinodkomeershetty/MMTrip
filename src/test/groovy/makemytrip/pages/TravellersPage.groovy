package makemytrip.pages

import geb.Page
import makemytripmodules.TravellersModule

/**
 * Created by vinodk on 21-10-2015.
 */
class TravellersPage extends Page {
    static at={
        title=="Flights Traveller"
    }
    static content={
        Travellersobj{module TravellersModule}
    }

    def clickOnContinueToPaymentButton(){
        try{
            if(Travellersobj.continueToPaymentButton.displayed) {
            Travellersobj.continueToPaymentButton.click(PaymentsPage)
        }
        else {
            print " "

        }

        }
        catch (Exception e) {
            print "ex"
            print "Unable to find the element"
        }
    }
    def passValuesToFirstName(String fname)
    {
        Travellersobj.firstNameField<<fname
    }
    def passValuesToAgeField(String age)
    {
        Travellersobj.ageField<<age
    }
    def passValuesToPhoneField(String number1)
    {
        Travellersobj.phoneNumberField<<number1
    }

    def passValuesToLastName(String lname)
    {
        Travellersobj.lastNameField<<lname
    }

    def verifyDetailsinTravellersPage(String src,String dest,String duration,String deptime,String arr,String amt){
    def temp=Travellersobj.cityandduration.text()
        temp[0].contentEquals(src)
        temp[1].contentEquals(dest)
        temp[2].contentEquals(duration)

        def temp1=Travellersobj.timeanddate.text()
        def starttim=temp1[0].split(",")
        starttim[0].contentEquals(deptime)

        def endtim=temp1[1].split(",")
        endtim[0].contentEquals(arr)

        def temp3=Travellersobj.amount.text().split("Rs.")
        print temp3
        temp3[0].contentEquals(amt)


    }

}

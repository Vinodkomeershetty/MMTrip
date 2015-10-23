package makemytrip.pages

import geb.Page
import makemytripmodules.TravellersModule

/**
 * Created by vinodk on 21-10-2015.
 */
class TravellersPage extends Page {
    static at={
        1==1
    }
    static content={
        Travellersobj{module TravellersModule}
    }

    public void clickOnContinueToPaymentButton(){
        js.exec "scroll(0,300);"
        if(Travellersobj.continueToPaymentButton.displayed) {
            Travellersobj.continueToPaymentButton.click()
        }
    }
    public passValuesToFirstName(String fname)
    {
        Travellersobj.firstNameField<<fname
    }
    public passValuesToAgeField(String age)
    {
        Travellersobj.ageField<<age
    }
    public passValuesToPhoneField(String number1)
    {
        Travellersobj.phoneNumberField<<number1
    }

    public passValuesToLastName(String lname)
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

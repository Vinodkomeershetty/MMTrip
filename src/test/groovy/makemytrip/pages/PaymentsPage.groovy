package makemytrip.pages

import geb.Page
import makemytripmodules.PaymentsModule

/**
 * Created by vinodk on 21-10-2015.
 */
class PaymentsPage extends Page{

    static at = {
        title=="MakeMytrip Payment : Safe and Secure"
    }

    static content={
        PaymentsPageObj{module PaymentsModule}
    }
    def verifyDetailsInPaymentsPage(String src,String dest,String duration,String deptime,String arr,String amt){
        def temp=PaymentsPageObj.cityandduration.text()
        temp[0].contentEquals(src)
        temp[1].contentEquals(dest)
        temp[2].contentEquals(duration)

        def temp1=PaymentsPageObj.timeanddate.text()
        def starttim=temp1[0].split(",")
        starttim[0].contentEquals(deptime)

        def endtim=temp1[1].split(",")
        endtim[0].contentEquals(arr)

        def temp3=PaymentsPageObj.amount.text().split("Rs.")
        print temp3
        temp3[0].contentEquals(amt)
    }
}

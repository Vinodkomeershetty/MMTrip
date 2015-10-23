package makemytripmodules

import geb.Module

/**
 * Created by vinodk on 21-10-2015.
 */
class TravellersModule extends Module{
    static content={
        continueToPaymentButton{$("a",text:"Continue to payment")}
        firstNameField{$(".first_name>input")}
        ageField{$("input[placeholder='Age']")}
        phoneNumberField{$("input[placeholder=\"Mobile Number\"]")}
        lastNameField{$(".last_name>input")}
        cityandduration{$("span.city_time_info>span:nth-of-type(2)")}
        timeanddate{$(".city_revwinfo.pull-left.ng-binding")}
        amount{$("span.price_info>span:nth-of-type(1)")}
    }

}

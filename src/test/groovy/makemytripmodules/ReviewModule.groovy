package makemytripmodules

import geb.Module

/**
 * Created by vinodk on 21-10-2015.
 */
class ReviewModule extends Module{

    static content={
        email_field{$("input[type='email']",0)}
        continueButton{$("a.btn.btn-lg.btn-block.btn-primary-red",text:"Continue as Guest")}
        departureDate{$("div.itnry_bottom_top>div:nth-child(2)")}
        arrivalDate{$("div.itnry_bottom_top>div:nth-child(4)")}
        durationDate{$("div.itnry_bottom_top>div:nth-child(5)")}
        datedept{$(".review_itnry_upper>p>span")}
        iAgreebutton{$("a",text:"I Agree")}
        grndTotalinReviewPage{$(".review_grandtotal>span:nth-of-type(2)")}
    }
}

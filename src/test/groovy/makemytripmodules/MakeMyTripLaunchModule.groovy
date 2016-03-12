package makemytripmodules

import geb.Module

/**
 * Created by vinodk on 19-10-2015.
 */
class MakeMyTripLaunchModule extends Module{
    static content={
	
	xcx
        login_link{$("#ssologinlink")}
        userNameField{$("#username")}
        passwordField_text{$("#password_text")}
        continueButton{$("#login_btn")}
        passwordField{$("#password")}
        oneWayOption{$("#one_way_button1")}
        roundTripOption{$("#round_trip_button1")}
        fromField {$("#from_typeahead1")}
        toField{$("#to_typeahead1")}
        startDateField{$("#start_date_sec")}
        startdate {val->$("td[fare-date='"+val+"']>a")}
        returnDateField{$("#return_date_sec")}
        searchFlightsButton{$("#flights_submit")}
        closeiconInOfferDialog{$(".appfest_container-close.pull-right.clearfix")}
        increaseAdultCount{$("#adult_count>a:nth-child(3)")}
    }
}



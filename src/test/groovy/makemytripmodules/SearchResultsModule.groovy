package makemytripmodules

import geb.Module

/**
 * Created by vinodk on 21-10-2015.
 */
class SearchResultsModule  extends Module {

    static content={
        login_link{$("#ssologinlink")}
        fromAndToAdress{$("p[class^='modify_city_name']")}
        departureDate{$(".modify_captions",text:"DEPARTURE").parent()}
        adultCount{$(".modify_captions",text:"ADULT").parent()}
        flightDetails{$("p[class^='flight_dtl_sectors']")}
        departureRecordTexts{$(".listing_top.clearfix>div:nth-of-type(3)>span:nth-of-type(2)",0)}
        arrivalRecordTexts{$(".listing_top.clearfix>div:nth-of-type(4)>span:nth-of-type(2)",0)}
        bookButton{$(".listing_top.clearfix>div:nth-of-type(8)>p>a",0,text:"Book")}
        showDetailsButton{$(".listing_top.clearfix>div:nth-of-type(8)>p>a:nth-of-type(1)>span",0)}
        departureTimes{$(".listing_top.clearfix>div:nth-of-type(3)>span.block.time",0)}
        arrivalTimes{$(".listing_top.clearfix>div:nth-of-type(4)>span.block.time",0)}
        durationTimes{$(".listing_top.clearfix>div:nth-of-type(5)>span.block.time",0)}
        flightTypes{$(".listing_top.clearfix>div:nth-of-type(5)>span.block.time+span",0)}
        itenararyButton{$("a",text:" ITINERARY")}
        itenararysrc{$(".itineary_departure",0)}
        itenararydest{$(".itineary_departure",1)}
        itenararyduration{$(".itineary_duration")}
//        adultCount1{val->$(".modify_captions",text:"ADULT").next("p").children("span",text:val)}

    }
}

package testcases

import geb.spock.GebReportingSpec
import makemytrip.pages.MakeMyTripLaunchPage
import makemytrip.pages.ReviewPage
import makemytrip.pages.SearchResultsPage
import makemytrip.pages.TravellersPage
import spock.lang.Shared

/**
 * Created by vinodk on 16-10-2015.
 */
class MakeMyTripTestCases extends GebReportingSpec{

    String startingdate_tweek="24-10-2015"
    def  "Login to makeMyTrip account with valid details"() {
        given:
        to MakeMyTripLaunchPage
        when:  "User is trying to login to the application with valid details"
        closeOfferDialog()
        clickOnLoginLink()
        loginToMakeMyTripPortal("zq@yopmail.com","second")
        then: "user should be successfully logged into the application"
        verifyLogin()
//        where username "zq@yopmail.com"


    }
    def "Search and Book For One Way Trip Ticket using Guest Login"(){
        at MakeMyTripLaunchPage
        when: "User tries to search for a One way trip flight ticket"
        clickOnOneWayOption()
        passValuestoFromField("Bangalore, India (BLR)")
        passValuestoToField("Hyderabad, India (HYD)")
        selectStartDate startingdate_tweek
        addAdults(1)
        clickOnSearchFlightButton()
        at SearchResultsPage
        then: "Appropriate search results should be displayed"
        verifyFromAndToAddress "Bangalore", "Hyderabad"
        verifyDepartureDate(startingdate_tweek)
        verifyAdultCount("01")
        verifyDepartureSearchRecord("Bangalore")
        verifyArrivalSearchRecord("Hyderabad")
        clickOnShowDetails()
        clickOnItenararyButton()
        String dept_time=getDepartureTime()
        String arrival_time=getArrivalTime()
        String duration_time=getDurationTime()
        String flight_type=getFlightType()
        verifyItenararyDetails dept_time, arrival_time, "BLR", "Bangalore", "HYD", "Hyderabad",duration_time,flight_type
       when: "Clicked on Book Button"
        clickOnBookButton()
        at ReviewPage
        then:"User is Navigated to Review Page"
        verifyDepartureDateinReviewPage(dept_time,"BLR", "Bangalore")
        verifyArrivalDateinReviewPage(arrival_time,"HYD", "Hyderabad")
        verifyDurationDateinReviewPage(duration_time, flight_type)
        verifyDeptDateinReviewPage(startingdate_tweek)
        String grandTotal= getGrandTotalinReviewPage()
        passValuesTOEmailField "zq@yopmail.com"
        clickOnContinueButtoninReviewPage()
        when: "Clicked on I Agree Button"
        clickOnIAgreeButton()
        at TravellersPage
        then:"User is Navigated to Travellers Page"
        passValuesToFirstName "test"
        passValuesToLastName("tester")
        passValuesToAgeField("32")
        passValuesToPhoneField("9885500590")
        verifyDetailsinTravellersPage("Bangalore","Hyderabad",duration_time,dept_time,arrival_time,grandTotal)
        when: "Clicked on Continue to Payment Button"
        clickOnContinueToPaymentButton()
        then: "User is Navigated to Payments Page"
//        verifyDetailsInPaymentsPage("Bangalore","Hyderabad",duration_time,dept_time,arrival_time,grandTotal)

    }
}

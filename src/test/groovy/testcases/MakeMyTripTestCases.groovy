package testcases

import geb.spock.GebReportingSpec
import makemytrip.pages.MakeMyTripLaunchPage
import makemytrip.pages.PaymentsPage
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

        then: "Appropriate search results should be displayed"

        verifyFromAndToAddress "Bangalore", "Hyderabad"
        verifyDepartureDate(startingdate_tweek)
        verifyAdultCount("01")
        verifyDepartureSearchRecord("Bangalore")
        verifyArrivalSearchRecord("Hyderabad")

        when: "User tries to see Itenerary Details"
        clickOnShowDetails()
        clickOnItenararyButton()
        String dept_time=getDepartureTime()
        String arrival_time=getArrivalTime()
        String duration_time=getDurationTime()
        String flight_type=getFlightType()

        then: "Approproate details should be displayed  in Itenarary tab"
        verifyItenararyDetails dept_time, arrival_time, "BLR", "Bangalore", "HYD", "Hyderabad",duration_time,flight_type

        when: "Clicked on Book Button"
        clickOnBookButton()


        then:"User is Navigated to Review Page and appropriate details are displayed in Review Page"
        verifyDepartureDateinReviewPage(dept_time,"BLR", "Bangalore")
        verifyArrivalDateinReviewPage(arrival_time,"HYD", "Hyderabad")
        verifyDurationDateinReviewPage(duration_time, flight_type)
        verifyDeptDateinReviewPage(startingdate_tweek)

        and: "In Review Page, User enters all the details and navigates to Travellers Page"
        String grandTotal= getGrandTotalinReviewPage()
        passValuesTOEmailField "zq@yopmail.com"
        clickOnContinueButtoninReviewPage()
        clickOnIAgreeButton()

        then: "Verify details in Travellers Page"
        verifyDetailsinTravellersPage("Bangalore","Hyderabad",duration_time,dept_time,arrival_time,grandTotal)

        and:  "Provide required details in Travellers Page and navigates to Payment Page by clicking on 'Continue to Payment' button"
        passValuesToFirstName "test"
        passValuesToLastName("tester")
        passValuesToAgeField("32")
        passValuesToPhoneField("9885500590")
        clickOnContinueToPaymentButton()

        then: "User is Navigated to Payments Page"

        print "Successfull"
    }
}

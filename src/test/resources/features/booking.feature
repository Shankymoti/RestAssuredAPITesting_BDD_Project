Feature: Restful Booker API Integration

  Scenario Outline: Create, Get, Update, and Delete Booking
    Given User has booking data from "<ExcelFile>" sheet "<SheetName>" row <RowNum>
    When User calls "<APIResource>" API with "<HttpMethod>" request
    Then API call is successful with status code 200
    And Verify booking firstname is "<Firstname>"

    Examples:
      | ExcelFile                     | SheetName | RowNum | APIResource      | HttpMethod | Firstname |
      | src/test/resources/data.xlsx   | Booking   | 1      | CREATE_BOOKING   | POST       | John      |

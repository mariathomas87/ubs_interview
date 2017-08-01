Story: The Berlin Clock

Meta:
@scope interview

Narrative:
    As a clock enthusiast
    I want to tell the time using the Berlin Clock
    So that I can increase then number of ways that I can read the time

Scenario: Midnight
Given a Berlin Clock
When the time is 00:00:00
Then the clock should look like
Y
OOOO
OOOO
OOOOOOOOOOO
OOOO

Scenario: Middle of the afternoon
Given a Berlin Clock
When the time is 13:17:01
Then the clock should look like
O
RROO
RRRO
YYROOOOOOOO
YYOO

Scenario: Just before midnight
Given a Berlin Clock
When the time is 23:59:59
Then the clock should look like
O
RRRR
RRRO
YYRYYRYYRYY
YYYY

Scenario: Midnight
Given a Berlin Clock
When the time is 24:00:00
Then the clock should look like
Y
RRRR
RRRR
OOOOOOOOOOO
OOOO

Scenario: More than 3 set of values in input
Given a Berlin Clock
When the time is 24:00:00:31
Then the clock should look like
Y
RRRR
RRRR
OOOOOOOOOOO
OOOO

Scenario: Less than 3 set of values in input(HH:MM:SS is expected)
Given a Berlin Clock
When the time is 24:00
Then an empty string is returned

Scenario: Negative value for time input
Given a Berlin Clock
When the time is 24:-21:00
Then an empty string is returned

Scenario: Invalid value for hours, minutes or seconds
Given a Berlin Clock
When the time is 25:59:59
Then an empty string is returned

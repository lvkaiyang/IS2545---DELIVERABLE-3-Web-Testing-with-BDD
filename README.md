# IS2545---DELIVERABLE-3-Web-Testing-with-BDD
In this deliverable, I confronted with some problems. First, when I used htmlunit driver to write the test, it always could not find the elements since they were not visible even I put a long implicit time to wait. Second, I could not get the log in success page even I put the correct account and password. When I debuged it, it could run successfully so I guess it just needed some time to wait the page redirect. However, I was fail to set the waiting time. Third, when I finish my second story coding, my ip address was locked, so I changed other test. The second and the third story I used Chrome driver for the test.

Following are my stories and scenarioes:


Story #1

As a visitor

I would like to shop without logging in

So that less personal information will be provided due to privacy.

Scenario #1

Given that 0 item is added into cart

When clicking Checkout to process 

Then error message “Oops, there is nothing in your cart.” will occur

Scenario #2

Given that more than 0 item is added into cart

When clicking Purchase button without leaving any personal information

Then the page will step back

Scenario #3

Given that more than 0 item is added into cart 

When clicking Remove button

Then message “Oops, there is nothing in your cart.” will occur

Story #2

As a visitor

I would like to log in my account

So that I could manage my account

Scenario #1

Given that log in page 

When inputting wrong account

Then I still stay in log in page

Scenario #2

Given that log in page

When inputting wrong password

Then I still stay in log in page

Scenario #3

Given that log in page

When inputting wrong account and password

Then I still stay in log in page

Story #3

As a visitor

I would like to search something I need

So that I could input the name in search

Scenario #1

Given home page

When I input appel

Then message that Sorry, but nothing matched your search criteria. Please try again with some different keywords.

Scenario #2

Given home page

When I input apple

Then some pictures would be displayed

Scenario #3

Given home page

When I input Apple

Then some pictures would be displayed


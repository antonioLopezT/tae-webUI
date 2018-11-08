###########################################################################
#                IMDB USER INTERFACE AUTOMATON TEST
###########################################################################
Run instructions:
	1.- The project is build with Maven so you must have Maven (Version 3.5.4) and Java JDK (Version 1.8) installed on your computer.
		Links to download Maven and Java (For installation follow the instructions in the web seite).
		- https://maven.apache.org/download.cgi
		- https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
	2.- For building the project you need to open a command prompt and move to the location where the project "pom.xml" is and enter the next commands:
		- mvn clean install -DskipTests (If everything was ok a "BUILD SUCCESS" message is prompt)
	3.- For running the automation test you need to open a command prompt in the same location of the instruction number 2 and enter the next commands:
		- mvn test

	**Notes: 
	The project is configure to run in a Mac or a Windows computer. 
	The commands in the instruction number 3 run the default configuration that open a Firefox browser, you can run the automation test with Firefox or Chrome with the next commands:
		- For Firefox -> mvn test -PFirefox
		- For Chrome -> mvn test -PChrome
	For the test data in the differents test cases you can modify them in the resource.properties 
		- imdb\src\test\resources\resources.properties

Project frameworks and tools versions:
	- Java JDK 1.8
	- Maven 3.5.4
	- Selenium 3.14.0
	- TestNG 6.8
	- Log4j 1.2.17
	- Google Chrome 70.0.3538.77
	- Firefox 58.0.2

Test cases:
+----+--------------------------+-----------------------------------------------+--------------------------------------------------+----------------------------------------------------------------+
| ID | Precondition             | Step description                              | Test data                                        | Expected result                                                |
+----+--------------------------+-----------------------------------------------+--------------------------------------------------+----------------------------------------------------------------+
| 1  | Browser is launched and  | Enter the IMDB website home page.             | URL = https://www.imdb.com/                      | The URL is the same as https://www.imdb.com/                   |
|    | imdb website open.       | Validate the current URL of IMDB the website. | Title = IMDb - Movies, TV and Celebrities - IMDb | and the title of the page is IMDb - Movies,                    |
|    |                          | Validate the title of the IMDB website.       |                                                  | TV and Celebrities - IMDb                                      |
+----+--------------------------+-----------------------------------------------+--------------------------------------------------+----------------------------------------------------------------+
| 2  | Browser is launched and  | Enter the IMDB website home page.             |                                                  | There has to be 4 options in me main menu                      |
|    | imdb website open.       | Validate that 4 options are display           |                                                  |                                                                |
|    |                          | in the main menu.                             |                                                  |                                                                |
+----+--------------------------+-----------------------------------------------+--------------------------------------------------+----------------------------------------------------------------+
| 3  | Browser is launched and  | Enter the IMDB website home page.             | Option 1 = Movies, TV and Showtimes              | Every option in the main menu have the correct description(s). |
|    | imdb website open.       | Validate the correct description on every     | Option 2 = Celebs, Events and Photos             |                                                                |
|    |                          | option of the main menu.                      | Option 3 = News and Community                    | Option 1 = Movies, TV and Showtimes                            |
|    |                          |                                               | Option 4 = Watchlist                             | Option 2 = Celebs, Events and Photos                           |
|    |                          |                                               |                                                  | Option 3 = News and Community                                  |
|    |                          |                                               |                                                  | Option 4 = Watchlist                                           |
+----+--------------------------+-----------------------------------------------+--------------------------------------------------+----------------------------------------------------------------+
| 4  | Browser is launched and  | Enter the IMDB website home page.             | The Front Runner                                 | The list of options are the same as:                           |
|    | imdb website open.       | Validate that the opening this week           | The Grinch                                       |                                                                |
|    |                          | options are correct.                          | The Girl in the Spider's Web:                    | The Front Runner                                               |
|    |                          |                                               | A New Dragon Tattoo Story                        | The Grinch                                                     |
|    |                          |                                               | Overlord                                         | The Girl in the Spider's Web:                                  |
|    |                          |                                               | Narcissister Organ Player                        | A New Dragon Tattoo Story                                      |
|    |                          |                                               | El Angel                                         | Overlord                                                       |
|    |                          |                                               | River Runs Red                                   | Narcissister Organ Player                                      |
|    |                          |                                               | Postcards from London                            | El Angel                                                       |
|    |                          |                                               | Lez Bomb                                         | River Runs Red                                                 |
|    |                          |                                               |                                                  | Postcards from London                                          |
|    |                          |                                               |                                                  | Lez Bomb                                                       |
+----+--------------------------+-----------------------------------------------+--------------------------------------------------+----------------------------------------------------------------+
| 5  | Browser is launched and  | Enter the IMDB website home page.             | Adam Devine                                      | The name of the fist celebrity has to be                       |
|    | imdb website open.       | Select -> Celebs, Events & Photos             |                                                  | Adam Devine                                                    |
|    |                          | -> Celebs -> Born Today.                      |                                                  |                                                                |
|    |                          | Validate the name of the first celebrity.     |                                                  |                                                                |
+----+--------------------------+-----------------------------------------------+--------------------------------------------------+----------------------------------------------------------------+
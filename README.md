# Unit 3 - Data for Social Good Project 

## User Story

> As an D1 College basketball player, <br> 
> I want to improve my 3-point shooting, <br> 
> so I can score more points on the perimeter and make the NBA. 

## Dataset 

Dataset 1: [3pt Percentage Data](https://www.basketball-reference.com/leaders/fg3_pct_career.html#nba)
- **Player** (String) - name of the NBA Player
- **3P%** (double) - 3pt shot percentage of the player

Dataset 2: [3pt Field Goals Made Data](https://www.basketball-reference.com/leaders/fg3_career.html#nba)
- **Player** (String) - name of the NBA Player
- **3P** (int) - 3pt shots made by the player

## UML Diagram 

![UML Diagram](https://github.com/user-attachments/assets/70619bf4-f588-4421-968e-b303ded6893f)

## Description 

This project initializes the 3pt percentage and 3pt field goals text files into 1D arrays. These 1D arrays are then iterated by index and the data from them is used to copy or concatenate a returned String of data including NBA Players names and statistics. The user will interact with my project by selecting from 4 options, to find and sort players by 3pt Percentage, Shots Made, Overall (calculated and sorted using the findBestShooters method), and Average shot statistics among all top 250 players. If any of the first 3 options are selected, it will first ask how many players from the top it would like to list (Ex. Top 5, Top 20, etc), and then it will run the methods specific to that option with that parameter specified. For the 4th option (Average), it will ask for the statistics to find the average among the 250 players in the datasets and create sub-options. Depending on the option selected, it will either return the Average 3pt percentage or the Average 3pt shots made among the players. My project addresses my user's goals because it provides him with information on the best 3-point shooters in the NBA by statistic or overall as well as the average 3-point statistics among those players which the user can use to find which players he can study, watch film, and analyze the 3 point shots of alongside finding the ideal 3 point percentage (based on the average from the dataset) that he can shoot. 

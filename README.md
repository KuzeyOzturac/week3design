# week3design

## Description of Domain
We are planning on pursuing a project within the domain of data analysis. Our project will specifically analyze public data about Toronto's TTC buses and streetcars, and will present this data in an easy-to-visualize manner.

## High-Level Description of Project
We are considering developing an application that tracks the coordinates of the TTC non-subway vehicles. The user will state which station they are at. We are going to provide the user with a list of each route and how much time it will take for the vehicle to arrive. We are going to use route numbers to track vehicles.

## API Documentation
Documentation for our API can be found at [xml-feed-documentation.pdf](./xml-feed-documentation.pdf).

## Screenshot of API test using Postman
We asked the API for a list of all vehicle locations that were part of route 510 (streetcar along Spadina).
<img width="1506" alt="screenshotpostman" src="https://github.com/KuzeyOzturac/week3design/assets/69856672/01cb396e-b4b6-4fdb-97a4-fea77b3716bf">

## Java Code
Our example Java code can be found at [./src/Main.java](./src/Main.java). Our example sends a `GET` request to our API, asking for a list of all TTC vehicles that follow route 510. It then converts the response into an XML DOM, and prints each vehicle id and its respective location as latitude and longitude. Because the API tracks TTC live updates, each instance of running our code will produce a unique result, and therefore our example output below may be different from other instances.

Example output of our code run at 12:31 AM on 26 Sept, 2023:

```
TTC Route 510 Vehicle Locations
------
	Vehicle id: 4485
	Vehicle location: 43.6393117, -79.3837412

	Vehicle id: 4553
	Vehicle location: 43.6600539, -79.4014185

	Vehicle id: 4564
	Vehicle location: 43.6510749, -79.3972405

	Vehicle id: 4532
	Vehicle location: 43.653258, -79.3981851

	Vehicle id: 4556
	Vehicle location: 43.6455316, -79.3950083

	Vehicle id: 4448
	Vehicle location: 43.6672633, -79.4037283

	Vehicle id: 4602
	Vehicle location: 43.6400018, -79.3800853
```

## Technical Problems
As of right now, none.

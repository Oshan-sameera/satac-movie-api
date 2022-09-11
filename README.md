## Movie API

## Backend API services are divided into two end points. 

Spring boot App

* Get All Movies - http://localhost:8080/movies
* Get by given filters - http://localhost:8080/movies/search

## Frontend

simple react app

## Port Numbers

* Backend run on - localhost:8080
* Frontend run on - localhost:3000

## Basic Authentication Credentials
* username :- user
* password :- 123


### How to run locally

```bash


# to run the frontend 
cd frontend
npm install # to install node modules
npm start 

# to run the backend
cd backend 
mvn package #Build Spring Boot Project with Maven 
java -jar target/movies-api-0.0.1-SNAPSHOT.jar # Run Spring Boot app with java -jar command


```
```bash


### Folder structure

├── backend
│                
└── frontend
    

```
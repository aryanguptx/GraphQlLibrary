# Library GraphQL API

## Table of Contents
1. [Introduction](#introduction)
2. [What is GraphQL?](#what-is-graphql)
3. [Schema](#schema)
4. [Sample Queries](#sample-queries)
5. [Running the Application](#running-the-application)
6. [Testing with GraphiQL](#testing-with-graphiql)

## Introduction

This project implements a GraphQL API for a library system, allowing users to query book information and add new books to the library.

## What is GraphQL?

GraphQL is a query language for APIs and a runtime for executing those queries with your existing data. It provides a more efficient, powerful and flexible alternative to REST API.

Key benefits of GraphQL:
- Clients can request exactly the data they need, no more, no less.
- Multiple resources can be retrieved in a single request.
- Strongly-typed schema that serves as a contract between client and server.

## Schema

```graphql
type Book {
    id: ID!
    title: String!
    author: String!
    publicationYear: Int
    genre: String
}

type Query {
    getBookById(id: ID!): Book
}

input AddBookInput {
    id : ID!
    title: String!
    author: String!
    publicationYear: Int
    genre: String
}

type AddBookPayload {
    status: String
    book: Book
}

type Mutation {
    addBook(input: AddBookInput!): AddBookPayload
}

schema {
    query: Query
    mutation: Mutation
}
```

## Sample Query And Mutation
```
query {
  getBookById(id: "book1") {
    title
    author
    publicationYear
    genre
  }
}
```
```
mutation {
  addBook(input: {
    id: "book3"
    title: "To Kill a Mockingbird"
    author: "Harper Lee"
    publicationYear: 1960
    genre: "Novel"
  }) {
    status
    book {
      id
      title
      author
    }
  }
}
```

## Running the Application

run the following commands:

```
mvn clean install
```

```
mvn spring-boot:run
```

## Testing with Graphiql

Browse to the below url and test your server

```http://localhost:8080/graphiql```

# dsl-project

[![Build Status](https://travis-ci.org/CPSC-410-Future-Gadget-Laboratory/dsl-project.svg?branch=master)](https://travis-ci.org/CPSC-410-Future-Gadget-Laboratory/dsl-project)

This is the CPSC 410 - Advanced Software Engineering group project.

## EBNF
Below is the EBNF of the language.
```
Program ::= EndpointDeclaration*
EndpointDeclaration ::= RequestMethod STRING " {" (Statement)* Response "}"
RequestMethod ::= "GET" | "PUT" | "POST" | "DELETE"
Statement ::= Conditional | ValueDeclaration | Response ";"
Response ::= "SEND {" (Statement)* "}"
Conditional ::= "IF (" Expression ") {" (Statement)* "} ELSE {" (Statement)* "}"
ValueDeclaration ::= ":" Type " = " Expression
Value::= String | Number | Boolean
Type ::= "String" | "Number" | "Boolean"
String ::= "\"" /^[a-z\d\-_\s]+$/i "\"";
Number ::= "^[0-9]+$"
Boolean ::= "true" | "false"
Expression ::= BinaryOperation | Value ";"
BinaryOperation ::= BinaryOperator "TO" Expression Expression
BinaryOperator ::=  "+" "-" "*" "/"
ReservedKeywords ::= RequestMethod & "SEND" & Type & "GET_PARAM"
```

## Language Design Specification Changelist

#### 1.0.0 - October 8th, 2019 (latest)
After discussion the following changes were proposed:
- We now support prefix notation for BinaryOperation. A binary operation starts with an operator (`+`, `-`, `*`, `/`), followed by two Values seperated by the string `"TO"`
- Variables will have to be declared with types. The variable name should be followed by a `":"` and a type (currently only `Number` and `Boolean` are supported)
```
GET "meaning/of/life" {
    // SOME LOGIC..
    IF (answer == 42) {
            SEND {
            200;
            "Found the meaning of life and this universe!";
        }
    } ELSE {
        SEND {
            404;
            "Still searching for my meaning";
        }
    }
}
```

#### 0.0.2 - October 2nd, 2019
After user testing, the following changes were made:
- The `THEN` keyword will be omitted in the `IF` and `ELSE` conditions to maintain consistency with other languages
- The `=` after `GET` and `SEND` keyword will be omitted due to redundancy
- The `ENDPOINT` keyword will be omitted inside the body of an endpoint method, and the endpoint string will be specified right after the endpoint method keyword, such as `GET` or `POST`
```
GET "meaning/of/life" {
    // SOME LOGIC..
    IF (answer == 42) {
            SEND {
            200;
            "Found the meaning of life!";
        }
    } ELSE {
        SEND {
            404;
            "Still searching";
        }
    }
}
```

#### 0.0.1 - September 23th, 2019
- `VAL` must be declared before being used.
- Endpoint Declaration must declare the endpoint url in their body using the `ENDPOINT` keyword which is assigned to a value of type `String`, and AT LEAST one response declaration using `SEND` keyword. For instance:
```
GET = {
    ENDPOINT = "/path/to/resource";
    // SOME LOGIC...
    SEND = {
        200;
        "Here is your resource!";
    }
}
```

## Contribution guide

Please do not work directly in the master branch. Work in seperate branches, and make a pull request to merge into dev so that other members can work with/on your code. Once things are working on dev and after making sure that the code builds on travis, we'll send in a pull request to merge into master.

We will be following the peer-review method of development, so any merge into dev or master will require atleast one review from someone. Master won't allow any pull requests before a review, dev will allow it but it's in good practice to get it reviewed. This keeps the sanity of our codebase in check, and atleast one person from the team will be upto speed with what you did.

Also, keep in mind the following things when sending in pull requests:

1. Pull request sizes should be as small as possible
2. Whenever it is possible, break pull requests into smaller ones
3. The pull request should do only one thing
4. Make a self-explanatory title describing **what** the pull request does
5. Detail with **what** was changed, **why** it was changed, and **how** it was changed.


Following these practices will ensure that:

1. Your pull request will be reviewed quickly
2. Less bugs will be introduced in the codebase
3. Development process will speed up as a result, and we'll be done before we know it

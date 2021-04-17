# Jetbrains Academy - Simple Search Engine

My solutions for the Jetbrains Academy Problem: Simple Search Engine

https://hyperskill.org/projects/89

The solution is build up step by step over several stages. 
Stage 1 is the first and simple one. The following stages 
build up on the previous stages and get more and more advanced.
There are six stages in total.

Because each stage is completely independent of the previous one,
IntelliJ might show some warnings about duplicated code between 
the stages.

## Stage 1/6

[click here to see description @ JetBrains Academy](https://hyperskill.org/projects/89/stages/494/implement)

A super simple search engine!

just execute this:

    gradle -PmainClass=stage1.MainKt run --console=plain

input

    alpha bravo charlie
    bravo

output

    2

## Stage 2/6

[click here to see description @ JetBrains Academy](https://hyperskill.org/projects/89/stages/495/implement)

We add some interactivity.

just execute this:

    gradle -PmainClass=stage2.MainKt run --console=plain

    Enter the number of people:
    3
    Enter all people:
    Alfred
    Bruce
    Selina
    Enter the number of search queries:
    1
    Enter data to search people:
    Bruce
    Bruce

## Stage 3/6

[click here to see description @ JetBrains Academy](https://hyperskill.org/projects/89/stages/496/implement)

We add a menu for the user to enter his chosen action.

just execute this:

    gradle -PmainClass=stage3.MainKt run --console=plain

    Enter the number of people:
    3
    Enter all people:
    Alfred
    Bruce
    Selina
    === Menu ===
    1. Find a person
    2. Print all people
    0. Exit
    2
    === List of people ===
    Alfred
    Bruce
    Selina
    === Menu ===
    1. Find a person
    2. Print all people
    0. Exit
    0
    Bye!

## Stage 4/6

[click here to see description @ JetBrains Academy](https://hyperskill.org/projects/89/stages/497/implement)

Here we read the data from a file.

just execute this:

    gradle -PmainClass=stage4.MainKt run --console=plain --args="--data ./src/main/resources/persons.txt"
    
    === Menu ===
    1. Find a person
    2. Print all people
    0. Exit
    2
    === List of people ===
    Loyd Marable
    ...
    Valeria Sessler
    ...
    === Menu ===
    1. Find a person
    2. Print all people
    0. Exit
    1
    Enter a name or email to search all suitable people.
    Valeria
    Valeria Sessler

## Stage 5/6

[click here to see description @ JetBrains Academy](https://hyperskill.org/projects/89/stages/498/implement)

We add an inverted index.

just execute this:

    gradle -PmainClass=stage5.MainKt run --console=plain --args="--data ./src/main/resources/persons.txt"

no new output

## Stage 6/6

[click here to see description @ JetBrains Academy](https://hyperskill.org/projects/89/stages/499/implement)

We add different search strategies for ALL, ANY and NONE.

just execute this:

    gradle -PmainClass=stage6.MainKt run --console=plain --args="--data ./src/main/resources/persons.txt" 
    
    === Menu ===
    1. Find a person
    2. Print all people
    0. Exit
    2
    === List of people ===
    Loyd Marable
    ...
    Breanna Glance
    ...
    === Menu ===
    1. Find a person
    2. Print all people
    0. Exit
    1
    Select a matching strategy: ALL, ANY, NONE
    ALL
    Enter a name or email to search all suitable people.
    Breanna
    Breanna Glance

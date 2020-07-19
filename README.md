# Programming school

## Introduction

The purpose of this repo is to teach my kids to program. So I set them up with laptops and we all sit around the table.

There are directories for each child that allows them to keep their code isolated, but I am encouraging cross interaction. The purpose of this is to also teach them how to use editor and how to use github.

Note that the point of this is to have results, as in build a game, or draw something. The goal is NOT to teach kids specific operators or boolean algebra or sorting or something like that. They would all be very bored with that approach, I think. So the point of this is to throw them into the code at a higher level, where they can add few lines of code here and there to affect how their game works, rather than start from scratch with empty program and build something up from nothing. While I do think that skill is important, I think it's often a bit of an advanced topic these days, since most people start with some existing framework even in real-world projects.

## Target audience

The target audience for this is a programmer parent. I am making no intention whatsoever to be able to teach kids who don't get some parental guidance. Programming is hard. Kids have questions. Without parents around, who understand programming, and have time to at least answer questions and get their hands dirty with a little bit of coding, not much progress will be made.

There is also an implicit assumption that the parent knows basic things like `if` clauses, syntax of expressions, basic operators, and such. These lessons are NOT intended to teach kids basics of language. The lessons are intended to keep them interested in creating a fun goal (draw something, build an adventure game), while it's expected of the parents to along the way teach them the basics. I believe every kid dies of boredom if someone will recite them all the boolean operators and make them learn than. But if they learn operators along the way, while using them through parental guidance, they might make progress.

## Why java?

I believe java is a great introductory language. It's very explicit, so you have to type boilerplate code a lot, which I think is great for kids to see the structure fully, not deal with magic.

It is also possibly the most suitable language for frameworks. Large parts of these lessons is not just learning java, but also living within the framework.
The entire series of adventure game lessons is basically lessons how to learn within framework and extend them with your own logic. And java is the most suitable language for this.

In several occasions, I had to rework the framework which caused API changes and brekages in kids code. It was a great lesson in how to live life as a real programmer, not just be isolated inside your simple test program.

Other options which I've considered and discarded:
- node.js: JS is too unstructured for my mind, plus the asynchronous model of node engine is not for the faint-hearted. It's hard to learn node.js without dwelling into understanding how the engine actually works.
- python: I personally dislike python for many reason (maybe because it reminds me of perl?), and it's also a bit hacky. I think strong-typing is a plus with teaching how to code.
- C: in some way, I believe C is a great introductory language, but it's hard to be effective unless you learn basics of memory management and pointers, which are again something not for the faint-hearted.

## Curriculum

This grows as it goes by, but the progression is as follows:
- draw basic graphics: circles lines (this is using a simple java AWT Graphics primitives)
- respond to basic key presses: similar than before, except allow ability to control what happens with clicks on the keyboard.
- adventure game: allow kids to create a basic adventure game with places and things and creatures, with support for graphics and sound at a location.

## Workstation Setup

Each student needs:
- github account
- laptop
  
Each laptop needs:
- java 11
- VS Code or Eclipse or some other IDE, use whatever you're most comfortable teaching your kids
- git client either integrated into IDE or any other form that you're comfortable teaching your kids

## Student setup

Each student should have his code under package `programming.school.student.<UNIQUENAME>`
In order to bring a new student on-board, they should have their new package created, and then you can copy in all the programs from the package `programming.school.reference`. That will give them the boilerplace for all the lessons and they will be able to progress from there.

Each java class has a `main()` method, so it can be executed directly as a standalone program, typically via right-click "run" action in most IDEs. VSCode can do that. Eclipse can also do that.
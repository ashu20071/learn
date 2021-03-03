Problem Summary
---
There is no ruler in the universe of Southeros and pandemonium reigns. Shan, the gorilla king of the Space kingdom
wants to rule all Six Kingdoms in the universe of Southeros. 

He needs the support of 3 more kingdoms to be the ruler.
Each kingdom has an animal emblem and Shan needs to send a message with the animal in the message to win them over.

Challenge is to have King Shan send secret message to each kingdom and win them over.

Problem source: `GeekTrust.in` [Golden Crown/Tame of Thrones](https://github.com/ashu20071/learn/blob/main/src/GeekTrust/TameOfThrones/Geektrust_in_tameofthrones_java.pdf)

Solution Description
---
Class `KingdomSymbols` holds the animal emblems in map structure which is instantiated and retrieved on demand.

`Decipher` method in `Geektrust` class used to decode the secret message sent by King Shan to other kingdoms and retrieve their response.

Allied kingdoms stored in ArrayList for future retrieval and final output appended in `output` string.

Exceptions for incorrect or invalid input is handled by throwing `IllegalArgumentException`.

Test Cases written for positive and negative response and also for invalid input in `GeekTrustTest` class.

How to run
---
Run `main` method in `Geektrust` class.
Pass absolute path to `input` text file as argument containing kingdom name and secret message.
Refer included `guide` for input examples.

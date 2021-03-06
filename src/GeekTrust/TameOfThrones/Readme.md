Problem Summary
---
There is no ruler in the universe of Southeros and pandemonium reigns. Shan, the gorilla king of the Space kingdom
wants to rule all Six Kingdoms in the universe of Southeros. 

He needs the support of 3 more kingdoms to be the ruler.
Each kingdom has an animal emblem and Shan needs to send a message with the animal in the message to win them over.

Challenge is to have King Shan send secret message to each kingdom and win them over.

Problem source: `GeekTrust.in` [Golden Crown/Tame of Thrones](https://www.geektrust.in/coding-problem/backend/tame-of-thrones)

Solution Description
---
Enum `KingdomSymbols` holds the animal emblems which is instantiated and retrieved on demand.

`Decipher` method in `DecipherMessage` class is used to decode the secret message sent by King Shan to other kingdoms and retrieve their responses.

Parallel processing implemented using `ExecutorService` and cached thread pool. Assigning tasks for each message and implementing the decipher method in parallel. 

Allied kingdoms stored in HashSet for future retrieval and final output appended in `output` string.

`Exceptions` for incorrect or invalid input is handled by throwing appropriate exceptions.

Test Cases written for positive and negative response and also for invalid input in `GeekTrustTest` class. 
Provide test values in `decipherTest` method in test class to test different values.

How to run
---
Run `main` method in `Geektrust` class.
Pass absolute path to `input` text file as argument containing kingdom name and secret message.
Refer included `guide` for input examples.

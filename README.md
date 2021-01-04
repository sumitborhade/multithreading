# Java Multithreading Basics with example #
## Concepts:
### [Deadlocks in Java](src/main/java/com/example/multithreading/Deadlock.md) ###

## Examples
### [Print Even-Odd Numbers using wait and notify](src/main/java/com/example/multithreading/EvenOddNumbersUsingWaitNotify.java)
### [Example of Producer Consumer using BlockingQueue](src/main/java/com/example/multithreading/ProducerConsumerBlockingQueue.java)
### [Example of Producer Consumer using wait and notify](src/main/java/com/example/multithreading/ProducerConsumerWaitAndNotify.java)

1. Ability to add an item to the bill using the barcode as a parameter. You may add only 1 item at a time.

2. Ability to remove an item from the bill using the barcode as a parameter. You may remove only 1 item at a time.

3. Ability to print a summary of the bill. The summary will look like the following...

1 x Apple @ 1.30 = 1.30

2 x Banana @ 0.99 = 1.98

3 x Carrot @ 1.66 = 4.98

Total = 8.26

 

2 Banana @0.99 = 1.98

1 Apple @1.3 = 1.3

3 Carrot @1.66 = 4.9799999999999995


-----------------

Test data:

Barcode    Description Price

-------------------------

01001    Banana         0.99

01002    Apple         1.30

01003    Carrot         1.66

-------------------------

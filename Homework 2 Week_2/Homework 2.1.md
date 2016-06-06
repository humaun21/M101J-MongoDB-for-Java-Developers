#Homework: Homework 2.1

We are now going to test that you can run a Maven-based project that depends on the MongoDB Java driver, Spark, and Freemarker. Download spark-freemarker-mongodb.zip, uncompress it, cd to the spark-freemarker-mongodb directory, and run Maven as follows:

mvn compile exec:java -Dexec.mainClass=course.homework.MongoDBSparkFreemarkerStyle

Like the previous homework, it requires Maven to be installed correctly, your mongod server to be running, and that you have run mongorestore properly from HW 1.1.

If all is working correctly, there should be two lines towards the bottom that say:

== Spark has ignited ...
>> Listening on 0.0.0.0:4567

Next, open a tab in your web browser and navigate to http://localhost:4567. There should be a single line of text that starts with:

THE ANSWER IS:

Type the number that appears after the colon into the box below, no spaces or punctuation

#The answer is: 2805

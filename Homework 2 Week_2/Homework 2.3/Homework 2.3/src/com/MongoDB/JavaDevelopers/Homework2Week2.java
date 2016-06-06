package com.MongoDB.JavaDevelopers;

import static com.mongodb.client.model.Filters.eq;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class Homework2Week2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Here the the documentation is used for mongo-jva-driver-3.2.2.jar
		/*If you want to use different versionof  mongo-jva-driver 
		  then you have look for that version specificatios.*/
		MongoClient mongoClient = new MongoClient();
        // get handle to "students" database
		MongoDatabase database = mongoClient.getDatabase("students");
        // get a handle to the "grades" collection
		MongoCollection<Document> collection = database.getCollection("grades");
		/*
		 * Write a program in the language of your choice that will remove the grade of type "homework" with the lowest score for each student from the dataset in the handout. 
		 * Since each document is one grade, it should remove one document per student. 
		 * This will use the same data set as the last problem, but if you don't have it, you can download and re-import.
		 * The dataset contains 4 scores each for 200 students.
		 * First, letâs confirm your data is intact; the number of documents should be 800.
		
         *Hint/spoiler: If you select homework grade-documents, sort by student
          and then by score, you can iterate through and find the lowest score
          for each student by noticing a change in student id. As you notice
          that change of student_id, remove the document.
         */
	    MongoCursor<Document> cursor = collection.find(eq("type", "homework")).sort(new Document("student_id", 1).append("score", 1)).iterator();
	    int curStudentId = -1;
	    try
        {
        while (cursor.hasNext()) {
    		Document doc = cursor.next();
    		int studentId=(int) doc.get("student_id");
    		if (studentId != curStudentId) {
                collection.deleteMany(doc);
                curStudentId = studentId;
            }
        }
        }finally {
        	//Close cursor
            cursor.close();
        }	
	    //Close mongoClient
	    mongoClient.close();
	}

}

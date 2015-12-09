-- IMPORTANT! Left side of equals in SELECT queries (=) is ALWAYS database value,
-- right side of equals (=) you have to replace with Java/JSP variable.

-- ALSO: in INSERT queries, replace ALL values in parentheses with correct Java/JSP variables

--insert article into database
INSERT INTO articles VALUES (id, url, authorID, providerID, title, date, category);

--insert author into database
INSERT INTO authors VALUES (id, name);

--insert provider into database
INSERT INTO providers VALUES (id, providerName);

--add a rating to the database
INSERT INTO ratings VALUES (id, userID, articleID, ratingValue, ratingText, ratingDate);

--get a user from the database, checking that user ID and password match
SELECT * FROM users WHERE userID = userID AND userPassword = password;

--get all ratings for an article, newest first
SELECT * FROM ratings WHERE articleID = articleID ORDER BY ratingDate DESC;

--get a user from the database
SELECT * FROM users WHERE userID = userID;

--get an article from the database
SELECT * FROM articles WHERE articleID = articleID;

--get recovery question ID and answer from users database
SELECT userRecoveryQuestionID, userRecoveryAnswer FROM users WHERE userID = userID;

SELECT * FROM users WHERE userRecoveryAnswer = answer;
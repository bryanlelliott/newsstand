
-- use case 1, view accounts
SELECT * FROM users;

-- use case 2, delete account
DELETE FROM users WHERE userID = userId;

-- use case 3, view content
SELECT a.articleURL, a.articleURL, a.authorID, a.providerID, a.articleTitle, a.articleAddDate, a.ArticleCategory
FROM articles a, userArticles ua 
WHERE ua.userID = userId AND a.articleID = ua.articleID;

-- use case 4, delete unsuitable content


-- use case 5, create new account
INSERT INTO users VALUES (userId, userRealName, userBio, userEmail, userPassword, userRecoveryQuestionID, userRecoveryAnswer, userType);

-- use case 6, add provider
INSERT INTO providers VALUES (id, providerName);

-- use case 7, modify profile
UPDATE users SET .... WHERE userID = userId;

-- use case 8, add article
INSERT INTO articles VALUES (id, url, authorID, providerID, title, date, category);

-- use case 9, rate article
INSERT INTO ratings VALUES (id, userID, articleID, ratingValue, ratingText, ratingDate);

-- use case 10, view relevant articles
SELECT * from articles WHERE 

-- use case 11, view user profile
SELECT * FROM users WHERE userID = userId;

-- use case 12, recover password


-- use case 13, tag article
INSERT INTO articleCategories VALUES (articleCategoryId, articleID, articleCategory);


--------------------------------------------------------------------------------------------------------
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
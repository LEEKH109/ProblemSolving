# SELECT e2.ID, e2.PARENT_ID
# FROM ECOLI_DATA e2, (SELECT ID
#                      FROM ECOLI_DATA
#                      WHERE PARENT_ID IS NULL) AS e1
# WHERE e2.PARENT_ID = e1.ID;

SELECT e3.ID
FROM ECOLI_DATA e3, (SELECT e2.ID, e2.PARENT_ID
                     FROM ECOLI_DATA e2, (SELECT ID
                                          FROM ECOLI_DATA
                                          WHERE PARENT_ID IS NULL) AS e1
                     WHERE e2.PARENT_ID = e1.ID) AS e2
WHERE e3.PARENT_ID = e2.ID
ORDER BY ID ASC;



-- 여집합을 구하는 문제 LEFT OUTER JOIN
-- 주의 사항 동물id 타입은 null false라서 가능 동물이름은 nullable이라 불가능
SELECT o.ANIMAL_ID, o.NAME
FROM ANIMAL_OUTS o
LEFT JOIN ANIMAL_INS i
ON o.ANIMAL_ID = i.ANIMAL_ID
WHERE i.ANIMAL_ID IS NULL;
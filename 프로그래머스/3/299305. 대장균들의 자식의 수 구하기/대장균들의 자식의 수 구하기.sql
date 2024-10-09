-- 최초의 대장균 개체의 PARENT_ID 는 NULL 값입니다.
-- 대장균 개체의 ID(ID)와 자식의 수(CHILD_COUNT)를 출력하는 SQL 문을 작성해주세요.
-- 자식이 없다면 자식의 수는 0으로 출력해주세요. => PARENT_ID COUNT해서 null이면 0
-- 결과는 개체의 ID 에 대해 오름차순 ASC 정렬해주세요.
SELECT ID, (SELECT COUNT(*) FROM ECOLI_DATA e2 WHERE e2.PARENT_ID = e1.ID) AS CHILD_COUNT
FROM ECOLI_DATA e1
ORDER BY ID ASC;

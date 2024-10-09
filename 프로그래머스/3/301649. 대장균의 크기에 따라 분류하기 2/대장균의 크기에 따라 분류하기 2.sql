-- 대장균 개체의 크기를 내름차순으로 정렬했을 때 
-- 상위 0% ~ 25% 를 'CRITICAL'
-- 26% ~ 50% 를 'HIGH'
-- 51% ~ 75% 를 'MEDIUM'
-- 76% ~ 100% 를 'LOW' 라고 분류
-- 대장균 개체의 ID(ID) 와 분류된 이름(COLONY_NAME)을 출력하는 SQL 문을 작성
-- 결과는 개체의 ID 에 대해 오름차순 정렬
-- 단, 총 데이터의 수는 4의 배수
SELECT ID, CASE
                WHEN RN <= TOTAL_COUNT * 0.25 THEN 'CRITICAL'
                WHEN RN <= TOTAL_COUNT * 0.5 THEN 'HIGH'
                WHEN RN <= TOTAL_COUNT * 0.75 THEN 'MEDIUM'
                ELSE 'LOW' END AS COLONY_NAME
FROM (SELECT ID, SIZE_OF_COLONY,
        ROW_NUMBER() OVER (ORDER BY SIZE_OF_COLONY DESC) AS RN,
        COUNT(*) OVER () AS TOTAL_COUNT
      FROM ECOLI_DATA) AS TMP
ORDER BY ID ASC;
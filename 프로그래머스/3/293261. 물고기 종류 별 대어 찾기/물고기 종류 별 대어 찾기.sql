-- 물고기 종류 별로 가장 큰 물고기의 ID, 물고기 이름, 길이를 출력
-- 물고기의 ID 컬럼명은 ID, 이름 컬럼명은 FISH_NAME, 길이 컬럼명은 LENGTH로 작성
-- 결과는 물고기의 ID에 대해 오름차순 정렬
-- 단, 물고기 종류별 가장 큰 물고기는 1마리만 있으며 10cm 이하의 물고기가 가장 큰 경우는 없음
-- 1. 각 FISH_TYPE별로 가장 큰 물고기의 길이를 구하는 서브쿼리
SELECT b.ID, c.FISH_NAME, a.MAX_LENGTH AS LENGTH
FROM (SELECT FISH_TYPE, MAX(LENGTH) as MAX_LENGTH
      FROM FISH_INFO
      GROUP BY FISH_TYPE) a
INNER JOIN FISH_INFO b
ON a.FISH_TYPE = b.FISH_TYPE AND a.MAX_LENGTH = b.LENGTH
INNER JOIN FISH_NAME_INFO c
ON a.FISH_TYPE = c.FISH_TYPE;
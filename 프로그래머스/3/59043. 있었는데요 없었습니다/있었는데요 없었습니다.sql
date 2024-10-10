-- ANIMAL_INS 테이블은 동물 보호소에 들어온 동물의 정보
-- ANIMAL_OUTS 테이블은 동물 보호소에서 입양 보낸 동물의 정보
-- 관리자의 실수로 일부 동물의 입양일이 잘못 입력 
-- 보호 시작일보다 입양일이 더 빠른 동물의 아이디와 이름을 조회
-- 결과는 보호 시작일이 빠른 순으로 조회해야합니다.
-- inner join
SELECT i.ANIMAL_ID, i.NAME
FROM ANIMAL_INS i
INNER JOIN ANIMAL_OUTS o
ON i.ANIMAL_ID = o.ANIMAL_ID
WHERE i.DATETIME > o.DATETIME
ORDER BY i.DATETIME ASC;
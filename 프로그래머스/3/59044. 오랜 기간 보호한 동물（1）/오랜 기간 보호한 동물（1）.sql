-- ANIMAL_INS 테이블은 동물 보호소에 들어온 동물의 정보를 담은 테이블
-- ANIMAL_OUTS 테이블은 동물 보호소에서 입양 보낸 동물의 정보를 담은 테이블
-- 아직 입양을 못 간(INTAKE_CONDITION) 동물 중
-- 가장 오래 보호소에 있었던 동물 3마리의 이름과 보호 시작일을 조회
-- 결과는 보호 시작일 순으로 조회
-- LEFT JOIN 여집합 null => 필터링 => 정렬 => LIMIT
SELECT i.NAME, i.DATETIME
FROM ANIMAL_INS i
LEFT JOIN ANIMAL_OUTS o
ON i.ANIMAL_ID = o.ANIMAL_ID
WHERE o.ANIMAL_ID IS NULL
ORDER BY DATETIME ASC
LIMIT 3;


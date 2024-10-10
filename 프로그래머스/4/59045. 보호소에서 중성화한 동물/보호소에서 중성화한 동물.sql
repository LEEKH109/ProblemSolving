-- ANIMAL_INS 테이블은 동물 보호소에 들어온 동물의 정보를 담은 테이블
-- SEX_UPON_INTAKE, 성별 및 중성화 여부 NULLABLE FALSE
-- ANIMAL_OUTS 테이블은 동물 보호소에서 입양 보낸 동물의 정보를 담은 테이블
-- SEX_UPON_OUTCOME, 성별 및 중성화 여부 NULLABLE FALSE
-- 보호소에서 중성화 수술을 거친 동물 정보를 알아보려 합니다.
-- 보호소에 들어올 당시에는 중성화되지 않았지만, 보호소를 나갈 당시에는 중성화된 동물
-- 동물의 아이디와 생물 종, 이름을 조회하는 아이디 순으로 조회
-- 정렬에 대한 조건은 없음
SELECT i.ANIMAL_ID, i.ANIMAL_TYPE, i.NAME
FROM ANIMAL_INS i
INNER JOIN ANIMAL_OUTS o
ON i.ANIMAL_ID = o.ANIMAL_ID
WHERE i.SEX_UPON_INTAKE LIKE 'Intact%' AND (o.SEX_UPON_OUTCOME LIKE 'Neutered%' OR o.SEX_UPON_OUTCOME LIKE 'Spayed%');

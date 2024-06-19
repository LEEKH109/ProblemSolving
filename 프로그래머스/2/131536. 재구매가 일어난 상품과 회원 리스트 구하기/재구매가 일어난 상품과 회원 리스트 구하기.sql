-- 회원 ID와 상품 ID를 그룹화하여 각 조합의 판매 횟수를 계산
SELECT USER_ID, PRODUCT_ID
FROM ONLINE_SALE
-- 동일한 USER_ID와 PRODUCT_ID를 가진 레코드들을 그룹으로 묶기
GROUP BY USER_ID, PRODUCT_ID
-- 각 그룹의 레코드 수가 2개 이상인 경우, 즉 재구매한 경우만 선택
HAVING COUNT(*) > 1
-- 결과를 회원 ID를 기준으로 오름차순 정렬하고, 회원 ID가 같다면 상품 ID를 기준으로 내림차순 정렬
ORDER BY USER_ID ASC, PRODUCT_ID DESC;
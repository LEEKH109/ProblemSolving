-- PRODUCT 테이블과 OFFLINE_SALE 테이블에서 
-- 상품코드 별 매출액(판매가 * 판매량) 합계를 출력
-- 결과는 매출액을 기준으로 내림차순 정렬, 매출액이 같다면 상품코드를 기준으로 오름차순 정렬
SELECT p.PRODUCT_CODE, SUM(p.PRICE * o.SALES_AMOUNT) AS SALES
FROM PRODUCT p
INNER JOIN OFFLINE_SALE o
ON p.PRODUCT_ID = o.PRODUCT_ID
GROUP BY p.PRODUCT_CODE
ORDER BY SALES DESC, p.PRODUCT_CODE ASC;

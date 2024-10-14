-- PARENT 아이템이 없는 아이템을 ROOT 아이템
-- ROOT 아이템을 찾아 아이템 ID(ITEM_ID), 아이템 명(ITEM_NAME)을 출력
-- 결과는 아이템 ID를 기준으로 오름차순 정렬
SELECT info.ITEM_ID, info.ITEM_NAME
FROM ITEM_INFO info
INNER JOIN ITEM_TREE tree
ON info.ITEM_ID = tree.ITEM_ID
WHERE tree.PARENT_ITEM_ID IS NULL
ORDER BY info.ITEM_ID ASC;
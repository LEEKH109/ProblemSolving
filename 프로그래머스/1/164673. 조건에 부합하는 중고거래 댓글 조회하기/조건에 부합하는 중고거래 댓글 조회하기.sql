SELECT a.TITLE, a.BOARD_ID, b.REPLY_ID, b.WRITER_ID, b.CONTENTS, DATE_FORMAT(b.CREATED_DATE, '%Y-%m-%d') AS CREATED_DATE
FROM USED_GOODS_BOARD a
INNER JOIN USED_GOODS_REPLY b
ON a.BOARD_ID = b.BOARD_ID
WHERE a.CREATED_DATE BETWEEN '2022-10-01' AND '2022-10-31'
ORDER BY b.CREATED_DATE ASC, a.TITLE ASC;

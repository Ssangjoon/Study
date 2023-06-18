-- 코드를 입력하세요
# SELECT 
# MEMBER_NAME
# ,REVIEW_TEXT
# ,DATE_FORMAT(REVIEW_DATE, "%Y-%m-%d") REVIEW_DATE
# FROM MEMBER_PROFILE MP
# JOIN REST_REVIEW MR ON MP.MEMBER_ID = MR.MEMBER_ID
# WHERE MR.MEMBER_ID = (
#         SELECT MEMBER_ID
#         FROM REST_REVIEW
#         GROUP BY MEMBER_ID
#         ORDER BY COUNT(MEMBER_ID) DESC
#         LIMIT 1
#     )
    
SELECT A.MEMBER_NAME,B.REVIEW_TEXT,DATE_FORMAT(B.REVIEW_DATE, "%Y-%m-%d") AS REVIEW_DATE
from MEMBER_PROFILE A join REST_REVIEW B
on A.MEMBER_ID = B.MEMBER_ID
WHERE A.MEMBER_ID = (SELECT MEMBER_ID FROM REST_REVIEW
GROUP BY MEMBER_ID
ORDER BY COUNT(*) DESC LIMIT 1)
order by REVIEW_DATE asc, REVIEW_TEXT
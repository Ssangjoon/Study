-- 코드를 입력하세요
SELECT rest.REST_ID, rest.REST_NAME, rest.FOOD_TYPE, rest.FAVORITES, rest.ADDRESS
, round(avg(review.REVIEW_SCORE),2) SCORE
from REST_INFO rest
join REST_REVIEW review
on review.REST_ID = rest.REST_ID
where rest.ADDRESS like '서울%' 
group by rest.REST_ID
order by SCORE desc, rest.FAVORITES desc
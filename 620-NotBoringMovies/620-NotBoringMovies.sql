-- Last updated: 8/6/2025, 4:47:22 PM
# Write your MySQL query statement below
select id ,movie,description , rating from cinema where description!='boring' and id%2=1 order by rating desc ;
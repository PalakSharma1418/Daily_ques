-- Last updated: 8/6/2025, 4:47:24 PM
# Write your MySQL query statement below

select class from courses group by class having count(student)>=5;
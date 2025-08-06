-- Last updated: 8/6/2025, 4:43:04 PM
# Write your MySQL query statement below
select teacher_id, count(distinct subject_id) as cnt from teacher
Group by teacher_id;
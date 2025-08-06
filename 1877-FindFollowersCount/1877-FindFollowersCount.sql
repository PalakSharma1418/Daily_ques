-- Last updated: 8/6/2025, 4:44:55 PM
# Write your MySQL query statement below
select user_id, count(follower_id) as followers_count from followers 
group by user_id
order by user_id;
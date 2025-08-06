-- Last updated: 8/6/2025, 4:45:55 PM
# Write your MySQL query statement below
select  activity_date as day,count(distinct user_id) as active_users from activity where activity_date<='2019-07-27' and activity_date>'2019-06-27'
group by activity_date;
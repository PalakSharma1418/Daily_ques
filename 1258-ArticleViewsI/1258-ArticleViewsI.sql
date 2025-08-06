-- Last updated: 8/6/2025, 4:45:51 PM
# Write your MySQL query statement below
select  distinct author_id as id from views where author_id = viewer_id order by id;
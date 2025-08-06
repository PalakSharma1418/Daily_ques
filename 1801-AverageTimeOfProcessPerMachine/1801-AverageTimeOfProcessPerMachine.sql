-- Last updated: 8/6/2025, 4:45:04 PM
# Write your MySQL query statement below
SELECT 
    A.machine_id, 
    ROUND(AVG(B.timestamp - A.timestamp), 3) AS processing_time
FROM Activity A
JOIN Activity B 
    ON A.machine_id = B.machine_id
    AND A.process_id = B.process_id
    AND A.activity_type != B.activity_type
WHERE A.activity_type = 'start'
GROUP BY A.machine_id;
-- Last updated: 8/6/2025, 4:49:21 PM
# Write your MySQL query statement below
-- select * from customer as c
-- left join orders
-- on c.id=customerid
-- where customerid is null
select (name) as Customers
from Customers
where id not in (select customerId from orders);
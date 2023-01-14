```
select u.user_id as 'buyer_id', join_date, count(o.order_date) as 'orders_in_2019'
from Users u
left join Orders o on u.user_id = o.buyer_id and o.order_date like '2019%'
group by u.user_id
```
```
select s.user_id, (sum(s.quantity * t.price)) as spending
from Sales s join Product t
on s.product_id = t.product_id
group by s.user_id
order by spending desc, s.user_id asc;
```
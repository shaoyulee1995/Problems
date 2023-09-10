```
select t.product_name, s.year, s.price
from Sales s left join Product t
    on s.product_id = t.product_id
```
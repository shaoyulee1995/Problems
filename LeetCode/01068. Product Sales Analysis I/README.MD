```
select
    product_name,
    year,
    price
from
    Sales left join Product
    using(product_id)
```
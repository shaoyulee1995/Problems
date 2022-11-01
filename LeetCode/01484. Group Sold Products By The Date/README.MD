# MsSQL
```
select a.sell_date,
        count(a.product) as num_sold,
        string_agg(a.product, ',') within group(order by product) as products
from (select distinct sell_date,
            product from Activities) as a
group by a.sell_date
order by a.sell_date asc
```

# MySQL
```
select sell_date, 
       count(distinct product) as num_sold,
       group_concat(distinct product order by product asc separator ',') as products
from activities
group by sell_date 
order by sell_date asc
```
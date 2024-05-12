# Sales Person
```
select
    name
from
    SalesPerson
where
    name not in 
                (select
                    s.name
                from
                    Orders o join SalesPerson s
                    using(sales_id) join Company c
                    using(com_id)
                where
                    c.name = 'Red')
order by
    1 
```
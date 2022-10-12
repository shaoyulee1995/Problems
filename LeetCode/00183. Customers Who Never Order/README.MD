# Not exists
```
select c.name as Customers
from Customers c
where not exists (
    select *
    from Orders o
    where o.customerId = c.id
)
```
# Not in
```
select c.name as Customers
from Customers c
where c.id not in (
    select customerId from orders
)
```